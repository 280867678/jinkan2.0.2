package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.KeyedFactory {
    public static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE = {Application.class, SavedStateHandle.class};
    public static final Class<?>[] VIEWMODEL_SIGNATURE = {SavedStateHandle.class};
    public final Application mApplication;
    public final Bundle mDefaultArgs;
    public final ViewModelProvider.Factory mFactory;
    public final Lifecycle mLifecycle;
    public final SavedStateRegistry mSavedStateRegistry;

    public SavedStateViewModelFactory(@Nullable Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = application;
        this.mFactory = application != null ? ViewModelProvider.AndroidViewModelFactory.getInstance(application) : ViewModelProvider.NewInstanceFactory.getInstance();
    }

    public static <T> Constructor<T> findMatchingConstructor(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @NonNull
    public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        Object newInstance;
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Constructor findMatchingConstructor = (!isAssignableFrom || this.mApplication == null) ? findMatchingConstructor(cls, VIEWMODEL_SIGNATURE) : findMatchingConstructor(cls, ANDROID_VIEWMODEL_SIGNATURE);
        if (findMatchingConstructor == null) {
            return (T) this.mFactory.create(cls);
        }
        SavedStateHandleController create = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        if (isAssignableFrom) {
            try {
                if (this.mApplication != null) {
                    newInstance = findMatchingConstructor.newInstance(this.mApplication, create.getHandle());
                    T t = (T) newInstance;
                    t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
                    return t;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to access ", (Class) cls), e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("An exception happened in constructor of ", (Class) cls), e3.getCause());
            }
        }
        newInstance = findMatchingConstructor.newInstance(create.getHandle());
        T t2 = (T) newInstance;
        t2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
        return t2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public void onRequery(@NonNull ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }
}
