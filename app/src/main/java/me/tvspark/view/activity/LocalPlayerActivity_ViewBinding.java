package me.tvspark.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.tvspark.utils.player.MyJzvdStd;
import white.whale.R;

/* loaded from: classes4.dex */
public class LocalPlayerActivity_ViewBinding implements Unbinder {
    public LocalPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public LocalPlayerActivity_ViewBinding(LocalPlayerActivity localPlayerActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = localPlayerActivity;
        localPlayerActivity.myJzvdStd = (MyJzvdStd) Utils.findRequiredViewAsType(view, R.id.video, "field 'myJzvdStd'", MyJzvdStd.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalPlayerActivity localPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (localPlayerActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            localPlayerActivity.myJzvdStd = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
