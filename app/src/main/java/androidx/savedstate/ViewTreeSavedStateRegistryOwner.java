package androidx.savedstate;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class ViewTreeSavedStateRegistryOwner {
    @Nullable
    public static SavedStateRegistryOwner get(@NonNull View view) {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) view.getTag(C0529R.C0530id.view_tree_saved_state_registry_owner);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        while (true) {
            ViewParent parent = view.getParent();
            if (savedStateRegistryOwner != null || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
            savedStateRegistryOwner = (SavedStateRegistryOwner) view.getTag(C0529R.C0530id.view_tree_saved_state_registry_owner);
        }
        return savedStateRegistryOwner;
    }

    public static void set(@NonNull View view, @Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        view.setTag(C0529R.C0530id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
