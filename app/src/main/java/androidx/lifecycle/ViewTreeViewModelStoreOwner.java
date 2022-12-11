package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.viewmodel.C0412R;

/* loaded from: classes3.dex */
public class ViewTreeViewModelStoreOwner {
    @Nullable
    public static ViewModelStoreOwner get(@NonNull View view) {
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) view.getTag(C0412R.C0413id.view_tree_view_model_store_owner);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        while (true) {
            ViewParent parent = view.getParent();
            if (viewModelStoreOwner != null || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
            viewModelStoreOwner = (ViewModelStoreOwner) view.getTag(C0412R.C0413id.view_tree_view_model_store_owner);
        }
        return viewModelStoreOwner;
    }

    public static void set(@NonNull View view, @Nullable ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(C0412R.C0413id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
