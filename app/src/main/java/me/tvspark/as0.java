package me.tvspark;

import android.content.ClipboardManager;
import android.view.View;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.view.activity.DelWebsiteActivity;

/* loaded from: classes4.dex */
public class as0 implements View.OnClickListener {
    public final /* synthetic */ DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwww;

    public as0(DelWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, WebSourceTitaData webSourceTitaData) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceTitaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            ((ClipboardManager) DelWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.toCustomJson());
            baseActivity = DelWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, this.Wwwwwwwwwwwwwwwwwwwwwwww.getName() + " 网站规则已复制到剪切板");
        }
    }
}
