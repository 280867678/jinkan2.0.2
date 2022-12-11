package me.tvspark;

import me.tvspark.utils.cast.p050ui.CastPlayActivity;
import me.tvspark.utils.cast.p050ui.DialogDlna;

/* loaded from: classes4.dex */
public class wp0 implements DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public wp0(CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.utils.cast.p050ui.DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        CastPlayActivity.this.tvDevice.setText(str);
        CastPlayActivity.this.Wwwwwwwwwwwwww();
    }
}
