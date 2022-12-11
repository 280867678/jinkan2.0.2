package me.tvspark.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.tvspark.utils.player.MyJzvdStd;
import white.whale.R;

/* loaded from: classes4.dex */
public class KSYPlayerActivity_ViewBinding implements Unbinder {
    public KSYPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public KSYPlayerActivity_ViewBinding(KSYPlayerActivity kSYPlayerActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kSYPlayerActivity;
        kSYPlayerActivity.myJzvdStd = (MyJzvdStd) Utils.findRequiredViewAsType(view, R.id.video, "field 'myJzvdStd'", MyJzvdStd.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        KSYPlayerActivity kSYPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (kSYPlayerActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            kSYPlayerActivity.myJzvdStd = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
