package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
/* loaded from: classes3.dex */
public class ViewModelStores {
    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelStore m4199of(@NonNull Fragment fragment) {
        return fragment.getViewModelStore();
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelStore m4198of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }
}
