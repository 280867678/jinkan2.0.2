package me.tvspark;

import java.util.List;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.view.activity.DelWebsiteActivity;
import org.litepal.crud.callback.FindMultiCallback;

/* loaded from: classes4.dex */
public class bs0 implements FindMultiCallback<WebSourceTitaData> {
    public final /* synthetic */ DelWebsiteActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public bs0(DelWebsiteActivity delWebsiteActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = delWebsiteActivity;
    }

    @Override // org.litepal.crud.callback.FindMultiCallback
    public void onFinish(List<WebSourceTitaData> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.clear();
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.addAll(list);
        }
        DelWebsiteActivity delWebsiteActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        delWebsiteActivity.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(delWebsiteActivity.Wwwwwwwwwwwwwww);
    }
}
