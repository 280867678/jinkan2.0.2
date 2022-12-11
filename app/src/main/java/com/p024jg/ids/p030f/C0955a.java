package com.p024jg.ids.p030f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.p024jg.ids.AbstractC0959g;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.f.a */
/* loaded from: classes6.dex */
public final class C0955a extends AbstractC0959g {

    /* renamed from: b */
    private String f618b;

    public C0955a(Context context) {
        super(context);
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f618b);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        if (this.f617a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    String string = Settings.Global.getString(this.f617a.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        c(string);
                        return;
                    }
                }
                AbstractC0956b m3759a = AbstractBinderC0957c.m3759a(iBinder);
                if (!m3759a.mo3756b()) {
                    String mo3757a = m3759a.mo3757a();
                    if (!TextUtils.isEmpty(mo3757a)) {
                        c(mo3757a);
                    }
                }
                b();
            } catch (Exception e) {
            }
        }
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public final boolean mo3706d() {
        boolean z = true;
        if (this.f617a == null) {
            return false;
        }
        try {
            PackageManager packageManager = this.f617a.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f618b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f618b = "com.huawei.hwid.tv";
            } else {
                this.f618b = "com.huawei.hms";
                if (packageManager.getPackageInfo(this.f618b, 0) == null) {
                    z = false;
                }
            }
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0954f
    /* renamed from: c */
    public final boolean mo3760c() {
        return TextUtils.isEmpty(a(this.f617a));
    }
}
