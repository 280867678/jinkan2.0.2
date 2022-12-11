package com.p024jg.ids.p028d;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p024jg.ids.AbstractC0959g;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.d.a */
/* loaded from: classes6.dex */
public final class C0945a extends AbstractC0959g {
    public C0945a(Context context) {
        super(context);
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
        try {
            AbstractC0946b m3773a = AbstractBinderC0947c.m3773a(iBinder);
            if (m3773a != null) {
                c(m3773a.mo3769b());
                b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public final boolean mo3706d() {
        if (this.f617a == null) {
            return false;
        }
        try {
            return this.f617a.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
