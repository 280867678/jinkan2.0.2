package me.tvspark;

import me.tvspark.data.sql.WebHistoryData;
import me.tvspark.view.activity.WebSnifferActivity;
import org.litepal.crud.callback.CountCallback;

/* loaded from: classes4.dex */
public class it0 implements CountCallback {
    public final /* synthetic */ WebSnifferActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public it0(WebSnifferActivity webSnifferActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webSnifferActivity;
    }

    @Override // org.litepal.crud.callback.CountCallback
    public void onFinish(int i) {
        if (i != 0) {
            WebSnifferActivity webSnifferActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSnifferActivity.Wwwwwwwwwwwwwwwwww, webSnifferActivity.Wwwwwwwwwwwww, System.currentTimeMillis());
            return;
        }
        WebSnifferActivity webSnifferActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        new WebHistoryData(webSnifferActivity2.Wwwwwwwwwwwww, webSnifferActivity2.Wwwwwwwwwwwwwwwwww, false, System.currentTimeMillis()).saveAsync().listen(null);
    }
}
