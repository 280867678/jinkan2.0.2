package com.umeng.analytics.pro;

import com.umeng.analytics.pro.C1588bm;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.umeng.analytics.pro.aw */
/* loaded from: classes4.dex */
public class C1563aw {

    /* renamed from: a */
    public final AbstractC1596bs f3141a;

    /* renamed from: b */
    public final C1611cf f3142b;

    public C1563aw() {
        this(new C1588bm.C1589a());
    }

    public C1563aw(AbstractC1598bu abstractC1598bu) {
        C1611cf c1611cf = new C1611cf();
        this.f3142b = c1611cf;
        this.f3141a = abstractC1598bu.mo1100a(c1611cf);
    }

    /* renamed from: a */
    private Object m1237a(byte b, byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        Object obj;
        try {
            try {
                C1591bn m1223j = m1223j(bArr, abstractC1570ba, abstractC1570baArr);
                if (m1223j != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && m1223j.f3221b == 11) {
                                                    obj = this.f3141a.mo1111z();
                                                }
                                            } else if (m1223j.f3221b == 10) {
                                                obj = Long.valueOf(this.f3141a.mo1113x());
                                            }
                                        } else if (m1223j.f3221b == 11) {
                                            obj = this.f3141a.mo1153A();
                                        }
                                    } else if (m1223j.f3221b == 8) {
                                        obj = Integer.valueOf(this.f3141a.mo1114w());
                                    }
                                } else if (m1223j.f3221b == 6) {
                                    obj = Short.valueOf(this.f3141a.mo1115v());
                                }
                            } else if (m1223j.f3221b == 4) {
                                obj = Double.valueOf(this.f3141a.mo1112y());
                            }
                        } else if (m1223j.f3221b == 3) {
                            obj = Byte.valueOf(this.f3141a.mo1116u());
                        }
                    } else if (m1223j.f3221b == 2) {
                        obj = Boolean.valueOf(this.f3141a.mo1117t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e) {
                throw new C1566az(e);
            }
        } finally {
            this.f3142b.m1097e();
            this.f3141a.mo1152B();
        }
    }

    /* renamed from: j */
    private C1591bn m1223j(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        this.f3142b.m1099a(bArr);
        int length = abstractC1570baArr.length + 1;
        AbstractC1570ba[] abstractC1570baArr2 = new AbstractC1570ba[length];
        int i = 0;
        abstractC1570baArr2[0] = abstractC1570ba;
        int i2 = 0;
        while (i2 < abstractC1570baArr.length) {
            int i3 = i2 + 1;
            abstractC1570baArr2[i3] = abstractC1570baArr[i2];
            i2 = i3;
        }
        this.f3141a.mo1127j();
        C1591bn c1591bn = null;
        while (i < length) {
            c1591bn = this.f3141a.mo1125l();
            if (c1591bn.f3221b == 0 || c1591bn.f3222c > abstractC1570baArr2[i].mo229a()) {
                return null;
            }
            if (c1591bn.f3222c != abstractC1570baArr2[i].mo229a()) {
                C1599bv.m1108a(this.f3141a, c1591bn.f3221b);
                this.f3141a.mo1124m();
            } else {
                i++;
                if (i < length) {
                    this.f3141a.mo1127j();
                }
            }
        }
        return c1591bn;
    }

    /* renamed from: a */
    public Boolean m1232a(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (Boolean) m1237a((byte) 2, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: a */
    public void m1236a(AbstractC1558at abstractC1558at, String str) throws C1566az {
        m1234a(abstractC1558at, str.getBytes());
    }

    /* renamed from: a */
    public void m1235a(AbstractC1558at abstractC1558at, String str, String str2) throws C1566az {
        try {
            try {
                m1234a(abstractC1558at, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new C1566az("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f3141a.mo1152B();
        }
    }

    /* renamed from: a */
    public void m1234a(AbstractC1558at abstractC1558at, byte[] bArr) throws C1566az {
        try {
            this.f3142b.m1099a(bArr);
            abstractC1558at.read(this.f3141a);
        } finally {
            this.f3142b.m1097e();
            this.f3141a.mo1152B();
        }
    }

    /* renamed from: a */
    public void m1233a(AbstractC1558at abstractC1558at, byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        try {
            try {
                if (m1223j(bArr, abstractC1570ba, abstractC1570baArr) != null) {
                    abstractC1558at.read(this.f3141a);
                }
            } catch (Exception e) {
                throw new C1566az(e);
            }
        } finally {
            this.f3142b.m1097e();
            this.f3141a.mo1152B();
        }
    }

    /* renamed from: b */
    public Byte m1231b(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (Byte) m1237a((byte) 3, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: c */
    public Double m1230c(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (Double) m1237a((byte) 4, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: d */
    public Short m1229d(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (Short) m1237a((byte) 6, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: e */
    public Integer m1228e(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (Integer) m1237a((byte) 8, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: f */
    public Long m1227f(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (Long) m1237a((byte) 10, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: g */
    public String m1226g(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (String) m1237a((byte) 11, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: h */
    public ByteBuffer m1225h(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        return (ByteBuffer) m1237a((byte) 100, bArr, abstractC1570ba, abstractC1570baArr);
    }

    /* renamed from: i */
    public Short m1224i(byte[] bArr, AbstractC1570ba abstractC1570ba, AbstractC1570ba... abstractC1570baArr) throws C1566az {
        Short sh;
        try {
            try {
                if (m1223j(bArr, abstractC1570ba, abstractC1570baArr) != null) {
                    this.f3141a.mo1127j();
                    sh = Short.valueOf(this.f3141a.mo1125l().f3222c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e) {
                throw new C1566az(e);
            }
        } finally {
            this.f3142b.m1097e();
            this.f3141a.mo1152B();
        }
    }
}
