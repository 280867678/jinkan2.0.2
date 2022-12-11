package com.p024jg.ids.p033i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import com.p024jg.ids.AbstractC0959g;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.i.d */
/* loaded from: classes6.dex */
public final class C0973d extends AbstractC0959g {

    /* renamed from: b */
    private String f631b = "";

    public C0973d(Context context) {
        super(context);
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        try {
            AbstractC0970a m3745a = AbstractBinderC0971b.m3745a(iBinder);
            String m3743a = m3743a(this.f617a, m3745a, "AUID");
            String m3743a2 = m3743a(this.f617a, m3745a, "OUID");
            String m3743a3 = m3743a(this.f617a, m3745a, "DUID");
            a(m3743a);
            b(m3743a3);
            c(m3743a2);
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public final boolean mo3706d() {
        if (this.f617a == null) {
            return false;
        }
        try {
            return this.f617a.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private String m3743a(Context context, AbstractC0970a abstractC0970a, String str) {
        Signature[] signatureArr;
        String str2 = null;
        if (context == null || abstractC0970a == null || !mo3706d()) {
            return "";
        }
        String packageName = this.f617a.getPackageName();
        if (TextUtils.isEmpty(this.f631b)) {
            try {
                signatureArr = this.f617a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable th) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Throwable th2) {
                }
            }
            this.f631b = str2;
        }
        return abstractC0970a.mo3744a(context.getPackageName(), this.f631b, str);
    }
}
