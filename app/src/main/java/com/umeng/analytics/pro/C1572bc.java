package com.umeng.analytics.pro;

import com.umeng.analytics.pro.C1588bm;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.bc */
/* loaded from: classes4.dex */
public class C1572bc {

    /* renamed from: a */
    public final ByteArrayOutputStream f3152a;

    /* renamed from: b */
    public final C1610ce f3153b;

    /* renamed from: c */
    public AbstractC1596bs f3154c;

    public C1572bc() {
        this(new C1588bm.C1589a());
    }

    public C1572bc(AbstractC1598bu abstractC1598bu) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f3152a = byteArrayOutputStream;
        C1610ce c1610ce = new C1610ce(byteArrayOutputStream);
        this.f3153b = c1610ce;
        this.f3154c = abstractC1598bu.mo1100a(c1610ce);
    }

    /* renamed from: a */
    public String m1215a(AbstractC1558at abstractC1558at, String str) throws C1566az {
        try {
            return new String(m1216a(abstractC1558at), str);
        } catch (UnsupportedEncodingException unused) {
            throw new C1566az(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("JVM DOES NOT SUPPORT ENCODING: ", str));
        }
    }

    /* renamed from: a */
    public byte[] m1216a(AbstractC1558at abstractC1558at) throws C1566az {
        this.f3152a.reset();
        abstractC1558at.write(this.f3154c);
        return this.f3152a.toByteArray();
    }

    /* renamed from: b */
    public String m1214b(AbstractC1558at abstractC1558at) throws C1566az {
        return new String(m1216a(abstractC1558at));
    }
}
