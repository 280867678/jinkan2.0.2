package com.p024jg.ids.p036l;

import android.content.Context;
import com.p024jg.ids.AbstractC0969i;
import com.p024jg.ids.C0979k;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.l.a */
/* loaded from: classes6.dex */
public final class C0982a implements AbstractC0969i {

    /* renamed from: a */
    private static Object f642a;

    /* renamed from: b */
    private static Class f643b;

    /* renamed from: c */
    private static Method f644c;

    /* renamed from: d */
    private static Method f645d;

    /* renamed from: e */
    private static Method f646e;

    static {
        f642a = null;
        f643b = null;
        f644c = null;
        f645d = null;
        f646e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f643b = cls;
            f642a = cls.newInstance();
        } catch (Throwable th) {
            f642a = null;
        }
        try {
            f643b.getMethod("getDefaultUDID", Context.class);
        } catch (Throwable th2) {
        }
        try {
            f644c = f643b.getMethod("getOAID", Context.class);
        } catch (Throwable th3) {
            f644c = null;
        }
        try {
            f645d = f643b.getMethod("getVAID", Context.class);
        } catch (Throwable th4) {
            f645d = null;
        }
        try {
            f646e = f643b.getMethod("getAAID", Context.class);
        } catch (Throwable th5) {
            f646e = null;
        }
    }

    /* renamed from: a */
    private static String m3722a(Context context, Method method) {
        if (f642a != null && method != null) {
            try {
                return (String) method.invoke(f642a, context);
            } catch (Throwable th) {
            }
        }
        return "";
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: a */
    public final String mo3723a(Context context) {
        String m3722a = m3722a(context, f645d);
        C0979k.m3734a().m3730b(m3722a);
        return m3722a;
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: b */
    public final String mo3721b(Context context) {
        String m3722a = m3722a(context, f644c);
        C0979k.m3734a().m3728c(m3722a);
        return m3722a;
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: c */
    public final String mo3720c(Context context) {
        String m3722a = m3722a(context, f646e);
        C0979k.m3734a().m3732a(m3722a);
        return m3722a;
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public final boolean mo3706d() {
        return f642a != null;
    }
}
