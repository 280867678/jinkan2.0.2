package me.tvspark;

import me.tvspark.common.view.BaseActivity;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;

/* loaded from: classes4.dex */
public class up0 implements Runnable {
    public final /* synthetic */ CastPlayActivity Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

    public up0(CastPlayActivity castPlayActivity, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = castPlayActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseActivity baseActivity;
        baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
