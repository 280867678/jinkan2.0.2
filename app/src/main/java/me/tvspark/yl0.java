package me.tvspark;

import android.app.Activity;
import android.content.DialogInterface;
import me.tvspark.data.event.CustomWebEvent;
import me.tvspark.data.sql.WebSourceTitaData;
import org.litepal.crud.callback.SaveCallback;

/* loaded from: classes4.dex */
public class yl0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.SaveCallback
        public void onFinish(boolean z) {
            if (!z) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yl0.this.Wwwwwwwwwwwwwwwwwwwwwww, "导入失败");
                return;
            }
            Activity activity = yl0.this.Wwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("成功导入 ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(yl0.this.Wwwwwwwwwwwwwwwwwwwwwwww.getName());
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            CustomWebEvent customWebEvent = new CustomWebEvent();
            customWebEvent.setToAdd(true);
            customWebEvent.setWebSourceTitaData(yl0.this.Wwwwwwwwwwwwwwwwwwwwww);
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
        }
    }

    public yl0(zl0 zl0Var, WebSourceTitaData webSourceTitaData, Activity activity, WebSourceTitaData webSourceTitaData2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
        this.Wwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwww = webSourceTitaData2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
