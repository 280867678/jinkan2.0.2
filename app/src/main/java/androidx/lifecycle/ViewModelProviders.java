package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

@Deprecated
/* loaded from: classes3.dex */
public class ViewModelProviders {

    @Deprecated
    /* loaded from: classes3.dex */
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(@NonNull Application application) {
            super(application);
        }
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m4203of(@NonNull Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m4202of(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m4201of(@NonNull FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m4200of(@NonNull FragmentActivity fragmentActivity, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }
}
