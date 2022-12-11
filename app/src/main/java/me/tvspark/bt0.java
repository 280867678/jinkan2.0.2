package me.tvspark;

import android.content.DialogInterface;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.view.activity.SortWebsiteActivity;

/* loaded from: classes4.dex */
public class bt0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwww;

    public bt0(SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, List list) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity;
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        baseActivity = SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, "重启后生效...");
        mn0.Wwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
