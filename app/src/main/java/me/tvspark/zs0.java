package me.tvspark;

import android.app.Activity;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.view.activity.SortWebsiteActivity;
import org.litepal.crud.callback.FindCallback;

/* loaded from: classes4.dex */
public class zs0 implements FindCallback<WebSourceTitaData> {
    public final /* synthetic */ SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public zs0(SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.litepal.crud.callback.FindCallback
    public void onFinish(WebSourceTitaData webSourceTitaData) {
        BaseActivity baseActivity;
        WebSourceTitaData webSourceTitaData2 = webSourceTitaData;
        if (webSourceTitaData2 != null) {
            baseActivity = SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) baseActivity, webSourceTitaData2, false, SortWebsiteActivity.this.Wwwwwwwwwwwwwww);
        }
    }
}
