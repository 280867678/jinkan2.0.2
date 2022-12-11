package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.runtime.C0409R;

/* loaded from: classes3.dex */
public class ViewTreeLifecycleOwner {
    @Nullable
    public static LifecycleOwner get(@NonNull View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) view.getTag(C0409R.C0410id.view_tree_lifecycle_owner);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        while (true) {
            ViewParent parent = view.getParent();
            if (lifecycleOwner != null || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
            lifecycleOwner = (LifecycleOwner) view.getTag(C0409R.C0410id.view_tree_lifecycle_owner);
        }
        return lifecycleOwner;
    }

    public static void set(@NonNull View view, @Nullable LifecycleOwner lifecycleOwner) {
        view.setTag(C0409R.C0410id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
