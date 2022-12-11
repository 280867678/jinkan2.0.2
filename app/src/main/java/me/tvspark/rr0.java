package me.tvspark;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class rr0 extends AsyncTask<String, Void, Boolean> implements sk0 {
    public File Wwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    public rr0(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new File(context.getCacheDir(), "45912.apk");
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(String[] strArr) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww.exists()) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "45912.apk");
        }
        return true;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        Boolean bool2 = bool;
        super.onPostExecute(bool2);
        if (bool2.booleanValue()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
            hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
            QbSdk.initTbsSettings(hashMap);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww.exists()) {
                QbSdk.initX5Environment(this.Wwwwwwwwwwwwwwwwwwwwwwww, new qr0(this));
                return;
            }
            QbSdk.reset(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            QbSdk.installLocalTbsCore(this.Wwwwwwwwwwwwwwwwwwwwwwww, 45912, this.Wwwwwwwwwwwwwwwwwwwwwww.getAbsolutePath());
        }
    }
}
