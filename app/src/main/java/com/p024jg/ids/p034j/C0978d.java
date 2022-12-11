package com.p024jg.ids.p034j;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p024jg.ids.AbstractC0959g;
import com.umeng.analytics.pro.C1538ag;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.j.d */
/* loaded from: classes6.dex */
public final class C0978d extends AbstractC0959g {
    public C0978d(Context context) {
        super(context);
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent();
        intent.setClassName(C1538ag.f2929b, C1538ag.f2930c);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        try {
            AbstractC0975a m3740a = AbstractBinderC0976b.m3740a(iBinder);
            if (m3740a != null) {
                String mo3737b = m3740a.mo3737b(this.f617a.getPackageName());
                String mo3738a = m3740a.mo3738a(this.f617a.getPackageName());
                String mo3739a = m3740a.mo3739a();
                a(mo3737b);
                b(mo3738a);
                c(mo3739a);
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
            return this.f617a.getPackageManager().getPackageInfo(C1538ag.f2929b, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
