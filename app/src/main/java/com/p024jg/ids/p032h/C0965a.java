package com.p024jg.ids.p032h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import com.p024jg.ids.AbstractC0932a;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.h.a */
/* loaded from: classes6.dex */
public final class C0965a extends AbstractC0932a {

    /* renamed from: b */
    private static final Uri f623b = Uri.parse("content://cn.nubia.identity/identity");

    public C0965a(Context context) {
        super(context, "nubia_thread");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: a */
    public final void mo3709a(Message message) {
        String str = null;
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i = message.getData().getInt("type", -1);
                    String str2 = "";
                    switch (i) {
                        case 0:
                            str2 = "getOAID";
                            break;
                        case 1:
                            str2 = "getVAID";
                            str = this.f617a.getPackageName();
                            break;
                        case 2:
                            str2 = "getAAID";
                            str = this.f617a.getPackageName();
                            break;
                    }
                    mo3747a(i, m3746a(this.f617a, str2, str));
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: b */
    protected final void mo3708b() {
        m3748a(2);
        m3748a(0);
        m3748a(1);
    }

    /* renamed from: a */
    private void m3748a(int i) {
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

    /* renamed from: a */
    private static String m3746a(Context context, String str, String str2) {
        Bundle call;
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(f623b);
                if (acquireContentProviderClient == null) {
                    return "";
                }
                call = acquireContentProviderClient.call(str, str2, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(f623b, str, str2, (Bundle) null);
            }
            if (call != null && call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
        } catch (Throwable th) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: a */
    public final void mo3747a(int i, String str) {
        switch (i) {
            case 0:
                a(new RunnableC0966b(this, str));
                return;
            case 1:
                a(new RunnableC0967c(this, str));
                return;
            case 2:
                a(new RunnableC0968d(this, str));
                return;
            default:
                return;
        }
    }
}
