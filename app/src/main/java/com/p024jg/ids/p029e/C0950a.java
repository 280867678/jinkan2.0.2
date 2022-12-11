package com.p024jg.ids.p029e;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p024jg.ids.AbstractC0959g;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.e.a */
/* loaded from: classes6.dex */
public final class C0950a extends AbstractC0959g {
    public C0950a(Context context) {
        super(context);
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        AbstractC0951b m3766a = AbstractBinderC0952c.m3766a(iBinder);
        if (m3766a != null) {
            String mo3765a = m3766a.mo3765a();
            a("");
            b("");
            c(mo3765a);
        }
    }
}
