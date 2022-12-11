package com.p024jg.ids.p026b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p024jg.ids.AbstractC0959g;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1529ab;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.b.a */
/* loaded from: classes6.dex */
public final class C0938a extends AbstractC0959g {
    public C0938a(Context context) {
        super(context);
        if (context instanceof Application) {
            this.f617a = context;
        } else {
            this.f617a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C1529ab.f2913b, C1529ab.f2914c));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        try {
            AbstractC0939b m3782a = AbstractBinderC0940c.m3782a(iBinder);
            if (m3782a != null) {
                String mo3775d = m3782a.mo3775d(this.f617a.getPackageName());
                String mo3776c = m3782a.mo3776c(this.f617a.getPackageName());
                String mo3777b = m3782a.mo3777b(this.f617a.getPackageName());
                a(mo3775d);
                b(mo3776c);
                c(mo3777b);
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
            return this.f617a.getPackageManager().getPackageInfo(C1529ab.f2913b, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
