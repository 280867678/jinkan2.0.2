package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ViewModelProvider {
    public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    public final Factory mFactory;
    public final ViewModelStore mViewModelStore;

    /* loaded from: classes3.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static AndroidViewModelFactory sInstance;
        public Application mApplication;

        public AndroidViewModelFactory(@NonNull Application application) {
            this.mApplication = application;
        }

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application application) {
            if (sInstance == null) {
                sInstance = new AndroidViewModelFactory(application);
            }
            return sInstance;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.mApplication);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create an instance of ", (Class) cls), e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create an instance of ", (Class) cls), e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create an instance of ", (Class) cls), e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create an instance of ", (Class) cls), e4);
                }
            }
            return (T) super.create(cls);
        }
    }

    /* loaded from: classes3.dex */
    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    /* loaded from: classes3.dex */
    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);
    }

    /* loaded from: classes3.dex */
    public static class NewInstanceFactory implements Factory {
        public static NewInstanceFactory sInstance;

        @NonNull
        public static NewInstanceFactory getInstance() {
            if (sInstance == null) {
                sInstance = new NewInstanceFactory();
            }
            return sInstance;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create an instance of ", (Class) cls), e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot create an instance of ", (Class) cls), e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OnRequeryFactory {
        public void onRequery(@NonNull ViewModel viewModel) {
        }
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.getViewModelStore(), viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : NewInstanceFactory.getInstance());
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t = (T) this.mViewModelStore.get(str);
        if (cls.isInstance(t)) {
            Factory factory = this.mFactory;
            if (factory instanceof OnRequeryFactory) {
                ((OnRequeryFactory) factory).onRequery(t);
            }
            return t;
        }
        Factory factory2 = this.mFactory;
        T t2 = factory2 instanceof KeyedFactory ? (T) ((KeyedFactory) factory2).create(str, cls) : (T) factory2.create(cls);
        this.mViewModelStore.put(str, t2);
        return t2;
    }
}
