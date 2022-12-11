package me.tvspark.widget.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogVideoDownload_ViewBinding implements Unbinder {
    public DialogVideoDownload Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public DialogVideoDownload_ViewBinding(DialogVideoDownload dialogVideoDownload, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogVideoDownload;
        RecyclerView recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_file, "field 'rvFile'", RecyclerView.class);
        throw null;
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        throw new IllegalStateException("Bindings already cleared.");
    }
}
