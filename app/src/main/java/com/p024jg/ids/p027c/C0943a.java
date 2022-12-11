package com.p024jg.ids.p027c;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p024jg.ids.AbstractC0959g;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.c.a */
/* loaded from: classes6.dex */
public final class C0943a extends AbstractC0959g {

    /* renamed from: b */
    private KeyguardManager f607b;

    public C0943a(Context context) {
        super(context);
        if (this.f617a != null) {
            this.f607b = (KeyguardManager) this.f617a.getSystemService("keyguard");
            if (mo3706d()) {
                try {
                    Object invoke = this.f607b.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f607b, new Object[0]);
                    if (invoke != null) {
                        c(invoke.toString());
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    protected final Intent mo3736a() {
        return new Intent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0959g
    /* renamed from: a */
    public final void mo3735a(IBinder iBinder) {
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public final boolean mo3706d() {
        if (this.f617a != null && this.f607b != null) {
            try {
                return ((Boolean) Objects.requireNonNull(this.f607b.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f607b, new Object[0]))).booleanValue();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
