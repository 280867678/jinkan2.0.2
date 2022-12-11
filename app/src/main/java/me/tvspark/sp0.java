package me.tvspark;

import android.os.Handler;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;

/* loaded from: classes4.dex */
public class sp0 implements AbstractC3509oo0 {
    public final /* synthetic */ CastPlayActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {

        /* renamed from: me.tvspark.sp0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3491Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public RunnableC3491Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (sp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                new Handler().postDelayed(new RunnableC3491Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 1000L);
                return;
            }
            ApplicationC1880C.Wwwwwwwwwww.clear();
            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            sp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.finish();
        }
    }

    public sp0(CastPlayActivity castPlayActivity, boolean z, boolean z2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = castPlayActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.tvPlayTime.setText("00:00:00");
        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.STOPED;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.AbstractC3509oo0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, String.format("Stop cast failed %s", str));
    }
}
