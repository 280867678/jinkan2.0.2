package me.tvspark;

import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import org.litepal.crud.callback.CountCallback;

/* loaded from: classes4.dex */
public class xp0 implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ CastPlayActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i != 0) {
                xp0 xp0Var = xp0.this;
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww, xp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, xp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount(), xp0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink(), System.currentTimeMillis());
            }
        }
    }

    public xp0(CastPlayActivity castPlayActivity, EpisodeParcel episodeParcel, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = castPlayActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
        CastPlayActivity castPlayActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        castPlayActivity.Wwwwwwwwwwwwwwwwww = new so0(castPlayActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink(), str, "", "", 0L, "", "");
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww();
        if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no_history", false)) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse) {
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
    }
}
