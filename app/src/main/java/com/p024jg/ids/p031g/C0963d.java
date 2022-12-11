package com.p024jg.ids.p031g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p024jg.ids.AbstractC0959g;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.g.d */
/* loaded from: classes6.dex */
public final class C0963d extends AbstractC0959g {
    public C0963d(Context context) {
        super(context);
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        try {
            AbstractC0960a m3754a = AbstractBinderC0961b.m3754a(iBinder);
            if (m3754a != null) {
                String mo3752a = m3754a.mo3752a(this.f617a.getPackageName());
                String mo3750b = m3754a.mo3750b(this.f617a.getPackageName());
                String mo3753a = m3754a.mo3753a();
                b(mo3752a);
                a(mo3750b);
                c(mo3753a);
            }
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
            return this.f617a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
