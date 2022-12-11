package me.tvspark;

import me.tvspark.utils.sniffer.dialog.DialogParse;
import me.tvspark.view.activity.TbsPlayerActivity;

/* loaded from: classes4.dex */
public class et0 implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ TbsPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public et0(TbsPlayerActivity tbsPlayerActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tbsPlayerActivity;
    }

    @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww
    public void onDismiss() {
        TbsPlayerActivity tbsPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (tbsPlayerActivity != null) {
            new TbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().start();
            return;
        }
        throw null;
    }
}
