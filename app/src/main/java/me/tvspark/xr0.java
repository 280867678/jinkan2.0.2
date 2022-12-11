package me.tvspark;

import android.content.DialogInterface;
import me.tvspark.data.event.CustomWebEvent;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.view.activity.DelWebsiteActivity;

/* loaded from: classes4.dex */
public class xr0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

    public xr0(DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, WebSourceTitaData webSourceTitaData) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DelWebsiteActivity.this.Wwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        DelWebsiteActivity delWebsiteActivity = DelWebsiteActivity.this;
        delWebsiteActivity.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(delWebsiteActivity.Wwwwwwwwwwwwwww);
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.getBaseUrl());
        CustomWebEvent customWebEvent = new CustomWebEvent();
        customWebEvent.setToAdd(false);
        customWebEvent.setWebSourceTitaData(this.Wwwwwwwwwwwwwwwwwwwwwww);
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
    }
}
