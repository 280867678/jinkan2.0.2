package me.tvspark;

import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import me.tvspark.view.activity.TbsPlayerActivity;
import org.litepal.crud.callback.CountCallback;

/* loaded from: classes4.dex */
public class dt0 implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ TbsPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ EpisodeParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i != 0) {
                dt0 dt0Var = dt0.this;
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww, dt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, dt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount(), dt0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink(), System.currentTimeMillis());
            }
        }
    }

    public dt0(TbsPlayerActivity tbsPlayerActivity, int i, EpisodeParcel episodeParcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tbsPlayerActivity;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
        if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no_history", false)) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.finish();
        TbsPlayerActivity tbsPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tbsPlayerActivity, str, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww + " - " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLink(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse) {
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
    }
}
