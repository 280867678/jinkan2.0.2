package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;

/* loaded from: classes4.dex */
public class rp0 implements AbstractC3509oo0 {
    public final /* synthetic */ CastPlayActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public rp0(CastPlayActivity castPlayActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = castPlayActivity;
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mDirectionDpadView.setPlayStatus(false);
        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.PAUSED;
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String.format("Pause cast failed %s", str));
    }
}
