package com.p024jg.ids.meizu;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.p024jg.ids.AbstractC0932a;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.meizu.c */
/* loaded from: classes6.dex */
public final class C0985c extends AbstractC0932a implements AbstractC0984b {
    public C0985c(Context context) {
        super(context, "meizu_thread");
        C0983a.m3719a().m3715a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: a */
    public final void mo3709a(Message message) {
        if (message != null) {
            try {
                int i = message.getData().getInt("type", -1);
                String str = "";
                switch (i) {
                    case 0:
                        str = C0983a.m3719a().m3713c(this.f617a);
                        break;
                    case 1:
                        str = C0983a.m3719a().m3712d(this.f617a);
                        break;
                    case 2:
                        str = C0983a.m3719a().m3714b(this.f617a);
                        break;
                }
                a(i, str);
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: b */
    protected final void mo3708b() {
        m3707b(2);
        m3707b(0);
        m3707b(1);
    }

    /* renamed from: b */
    private void m3707b(int i) {
        try {
            Message a = a();
            a.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            a.setData(bundle);
            b(a);
        } catch (Throwable th) {
        }
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public final boolean mo3706d() {
        return C0983a.m3719a().m3717a(this.f617a);
    }

    @Override // com.p024jg.ids.meizu.AbstractC0984b
    /* renamed from: a */
    public final void mo3710a(int i) {
        switch (i) {
            case 0:
                m3707b(0);
                return;
            case 1:
                m3707b(1);
                return;
            case 2:
                m3707b(2);
                return;
            default:
                return;
        }
    }
}
