package me.tvspark;

import android.view.View;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.view.activity.DelWebsiteActivity;

/* loaded from: classes4.dex */
public class zr0 implements View.OnClickListener {
    public final /* synthetic */ DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwww;

    public zr0(DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, WebSourceTitaData webSourceTitaData, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = DelWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
