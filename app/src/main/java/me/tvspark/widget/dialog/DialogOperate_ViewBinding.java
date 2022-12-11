package me.tvspark.widget.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogOperate_ViewBinding implements Unbinder {
    public DialogOperate Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public DialogOperate_ViewBinding(DialogOperate dialogOperate, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogOperate;
        dialogOperate.recycler = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recycler'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogOperate dialogOperate = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogOperate != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogOperate.recycler = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
