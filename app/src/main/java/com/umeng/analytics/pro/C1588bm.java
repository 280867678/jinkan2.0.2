package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.bm */
/* loaded from: classes4.dex */
public class C1588bm extends AbstractC1596bs {

    /* renamed from: d */
    public static final C1601bx f3190d = new C1601bx("");

    /* renamed from: e */
    public static final C1591bn f3191e = new C1591bn("", (byte) 0, 0);

    /* renamed from: f */
    public static final byte[] f3192f;

    /* renamed from: h */
    public static final byte f3193h = -126;

    /* renamed from: i */
    public static final byte f3194i = 1;

    /* renamed from: j */
    public static final byte f3195j = 31;

    /* renamed from: k */
    public static final byte f3196k = -32;

    /* renamed from: l */
    public static final int f3197l = 5;

    /* renamed from: a */
    public byte[] f3198a;

    /* renamed from: b */
    public byte[] f3199b;

    /* renamed from: c */
    public byte[] f3200c;

    /* renamed from: m */
    public C1556ar f3201m;

    /* renamed from: n */
    public short f3202n;

    /* renamed from: o */
    public C1591bn f3203o;

    /* renamed from: p */
    public Boolean f3204p;

    /* renamed from: q */
    public final long f3205q;

    /* renamed from: r */
    public byte[] f3206r;

    /* renamed from: com.umeng.analytics.pro.bm$a */
    /* loaded from: classes4.dex */
    public static class C1589a implements AbstractC1598bu {

        /* renamed from: a */
        public final long f3207a;

        public C1589a() {
            this.f3207a = -1L;
        }

        public C1589a(int i) {
            this.f3207a = i;
        }

        @Override // com.umeng.analytics.pro.AbstractC1598bu
        /* renamed from: a */
        public AbstractC1596bs mo1100a(AbstractC1612cg abstractC1612cg) {
            return new C1588bm(abstractC1612cg, this.f3207a);
        }
    }

    /* renamed from: com.umeng.analytics.pro.bm$b */
    /* loaded from: classes4.dex */
    public static class C1590b {

        /* renamed from: a */
        public static final byte f3208a = 1;

        /* renamed from: b */
        public static final byte f3209b = 2;

        /* renamed from: c */
        public static final byte f3210c = 3;

        /* renamed from: d */
        public static final byte f3211d = 4;

        /* renamed from: e */
        public static final byte f3212e = 5;

        /* renamed from: f */
        public static final byte f3213f = 6;

        /* renamed from: g */
        public static final byte f3214g = 7;

        /* renamed from: h */
        public static final byte f3215h = 8;

        /* renamed from: i */
        public static final byte f3216i = 9;

        /* renamed from: j */
        public static final byte f3217j = 10;

        /* renamed from: k */
        public static final byte f3218k = 11;

        /* renamed from: l */
        public static final byte f3219l = 12;
    }

    static {
        f3192f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public C1588bm(AbstractC1612cg abstractC1612cg) {
        this(abstractC1612cg, -1L);
    }

    public C1588bm(AbstractC1612cg abstractC1612cg, long j) {
        super(abstractC1612cg);
        this.f3201m = new C1556ar(15);
        this.f3202n = (short) 0;
        this.f3203o = null;
        this.f3204p = null;
        this.f3198a = new byte[5];
        this.f3199b = new byte[10];
        this.f3206r = new byte[1];
        this.f3200c = new byte[1];
        this.f3205q = j;
    }

    /* renamed from: E */
    private int m1175E() throws C1566az {
        int i = 0;
        if (this.f3235g.mo1085h() >= 5) {
            byte[] mo1087f = this.f3235g.mo1087f();
            int mo1086g = this.f3235g.mo1086g();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = mo1087f[mo1086g + i];
                i2 |= (b & Byte.MAX_VALUE) << i3;
                if ((b & 128) != 128) {
                    this.f3235g.mo1095a(i + 1);
                    return i2;
                }
                i3 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte mo1116u = mo1116u();
                i |= (mo1116u & Byte.MAX_VALUE) << i4;
                if ((mo1116u & 128) != 128) {
                    return i;
                }
                i4 += 7;
            }
        }
    }

    /* renamed from: F */
    private long m1174F() throws C1566az {
        byte mo1116u;
        byte b;
        int i = 0;
        long j = 0;
        if (this.f3235g.mo1085h() >= 10) {
            byte[] mo1087f = this.f3235g.mo1087f();
            int mo1086g = this.f3235g.mo1086g();
            long j2 = 0;
            int i2 = 0;
            while (true) {
                j2 |= (b & Byte.MAX_VALUE) << i2;
                if ((mo1087f[mo1086g + i] & 128) != 128) {
                    this.f3235g.mo1095a(i + 1);
                    return j2;
                }
                i2 += 7;
                i++;
            }
        } else {
            while (true) {
                j |= (mo1116u & Byte.MAX_VALUE) << i;
                if ((mo1116u() & 128) != 128) {
                    return j;
                }
                i += 7;
            }
        }
    }

    /* renamed from: a */
    private long m1170a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }

    /* renamed from: a */
    private void m1172a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) (j & 255);
        bArr[i + 1] = (byte) ((j >> 8) & 255);
        bArr[i + 2] = (byte) ((j >> 16) & 255);
        bArr[i + 3] = (byte) ((j >> 24) & 255);
        bArr[i + 4] = (byte) ((j >> 32) & 255);
        bArr[i + 5] = (byte) ((j >> 40) & 255);
        bArr[i + 6] = (byte) ((j >> 48) & 255);
        bArr[i + 7] = (byte) ((j >> 56) & 255);
    }

    /* renamed from: a */
    private void m1171a(C1591bn c1591bn, byte b) throws C1566az {
        if (b == -1) {
            b = m1159e(c1591bn.f3221b);
        }
        short s = c1591bn.f3222c;
        short s2 = this.f3202n;
        if (s <= s2 || s - s2 > 15) {
            m1168b(b);
            mo1137a(c1591bn.f3222c);
        } else {
            m1161d(b | ((s - s2) << 4));
        }
        this.f3202n = c1591bn.f3222c;
    }

    /* renamed from: a */
    private void m1169a(byte[] bArr, int i, int i2) throws C1566az {
        m1167b(i2);
        this.f3235g.mo1091b(bArr, i, i2);
    }

    /* renamed from: b */
    private void m1168b(byte b) throws C1566az {
        byte[] bArr = this.f3206r;
        bArr[0] = b;
        this.f3235g.m1092b(bArr);
    }

    /* renamed from: b */
    private void m1167b(int i) throws C1566az {
        int i2 = 0;
        while ((i & (-128)) != 0) {
            this.f3198a[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2++;
        }
        byte[] bArr = this.f3198a;
        bArr[i2] = (byte) i;
        this.f3235g.mo1091b(bArr, 0, i2 + 1);
    }

    /* renamed from: b */
    private void m1166b(long j) throws C1566az {
        int i = 0;
        while (true) {
            int i2 = (((-128) & j) > 0L ? 1 : (((-128) & j) == 0L ? 0 : -1));
            byte[] bArr = this.f3199b;
            int i3 = i + 1;
            if (i2 == 0) {
                bArr[i] = (byte) j;
                this.f3235g.mo1091b(bArr, 0, i3);
                return;
            }
            bArr[i] = (byte) ((127 & j) | 128);
            j >>>= 7;
            i = i3;
        }
    }

    /* renamed from: c */
    private int m1164c(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: c */
    private long m1163c(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: c */
    private boolean m1165c(byte b) {
        int i = b & 15;
        return i == 1 || i == 2;
    }

    /* renamed from: d */
    private byte m1162d(byte b) throws C1597bt {
        byte b2 = (byte) (b & 15);
        switch (b2) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new C1597bt(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("don't know what type: ", (int) b2));
        }
    }

    /* renamed from: d */
    private long m1160d(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* renamed from: d */
    private void m1161d(int i) throws C1566az {
        m1168b((byte) i);
    }

    /* renamed from: e */
    private byte m1159e(byte b) {
        return f3192f[b];
    }

    /* renamed from: e */
    private byte[] m1158e(int i) throws C1566az {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.f3235g.m1088d(bArr, 0, i);
        return bArr;
    }

    /* renamed from: f */
    private void m1157f(int i) throws C1597bt {
        if (i >= 0) {
            long j = this.f3205q;
            if (j != -1 && i > j) {
                throw new C1597bt(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Length exceeded max allowed: ", i));
            }
            return;
        }
        throw new C1597bt(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Negative length: ", i));
    }

    /* renamed from: g */
    private int m1156g(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: A */
    public ByteBuffer mo1153A() throws C1566az {
        int m1175E = m1175E();
        m1157f(m1175E);
        if (m1175E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[m1175E];
        this.f3235g.m1088d(bArr, 0, m1175E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: B */
    public void mo1152B() {
        this.f3201m.m1265c();
        this.f3202n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1150a() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1149a(byte b) throws C1566az {
        m1168b(b);
    }

    /* renamed from: a */
    public void m1173a(byte b, int i) throws C1566az {
        if (i <= 14) {
            m1161d(m1159e(b) | (i << 4));
            return;
        }
        m1161d(m1159e(b) | 240);
        m1167b(i);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1148a(double d) throws C1566az {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        m1172a(Double.doubleToLongBits(d), bArr, 0);
        this.f3235g.m1092b(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1147a(int i) throws C1566az {
        m1167b(m1164c(i));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1146a(long j) throws C1566az {
        m1166b(m1163c(j));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1145a(C1591bn c1591bn) throws C1566az {
        if (c1591bn.f3221b == 2) {
            this.f3203o = c1591bn;
        } else {
            m1171a(c1591bn, (byte) -1);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1144a(C1592bo c1592bo) throws C1566az {
        m1173a(c1592bo.f3223a, c1592bo.f3224b);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1143a(C1593bp c1593bp) throws C1566az {
        int m1159e;
        int i = c1593bp.f3227c;
        if (i == 0) {
            m1159e = 0;
        } else {
            m1167b(i);
            m1159e = m1159e(c1593bp.f3226b) | (m1159e(c1593bp.f3225a) << 4);
        }
        m1161d(m1159e);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1142a(C1594bq c1594bq) throws C1566az {
        m1168b(f3193h);
        m1161d(((c1594bq.f3229b << 5) & (-32)) | 1);
        m1167b(c1594bq.f3230c);
        mo1139a(c1594bq.f3228a);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1141a(C1600bw c1600bw) throws C1566az {
        m1173a(c1600bw.f3245a, c1600bw.f3246b);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1140a(C1601bx c1601bx) throws C1566az {
        this.f3201m.m1267a(this.f3202n);
        this.f3202n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1139a(String str) throws C1566az {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m1169a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C1566az("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1138a(ByteBuffer byteBuffer) throws C1566az {
        int limit = byteBuffer.limit() - byteBuffer.position();
        m1169a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), limit);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1137a(short s) throws C1566az {
        m1167b(m1164c((int) s));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1136a(boolean z) throws C1566az {
        C1591bn c1591bn = this.f3203o;
        byte b = 1;
        if (c1591bn == null) {
            if (!z) {
                b = 2;
            }
            m1168b(b);
            return;
        }
        if (!z) {
            b = 2;
        }
        m1171a(c1591bn, b);
        this.f3203o = null;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: b */
    public void mo1135b() throws C1566az {
        this.f3202n = this.f3201m.m1268a();
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: c */
    public void mo1134c() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: d */
    public void mo1133d() throws C1566az {
        m1168b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: e */
    public void mo1132e() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: f */
    public void mo1131f() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: g */
    public void mo1130g() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: h */
    public C1594bq mo1129h() throws C1566az {
        byte mo1116u = mo1116u();
        if (mo1116u != -126) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected protocol id ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(-126));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(mo1116u));
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        byte mo1116u2 = mo1116u();
        byte b = (byte) (mo1116u2 & 31);
        if (b != 1) {
            throw new C1597bt(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected version 1 but got ", (int) b));
        }
        int m1175E = m1175E();
        return new C1594bq(mo1111z(), (byte) ((mo1116u2 >> 5) & 3), m1175E);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: i */
    public void mo1128i() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: j */
    public C1601bx mo1127j() throws C1566az {
        this.f3201m.m1267a(this.f3202n);
        this.f3202n = (short) 0;
        return f3190d;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: k */
    public void mo1126k() throws C1566az {
        this.f3202n = this.f3201m.m1268a();
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: l */
    public C1591bn mo1125l() throws C1566az {
        byte mo1116u = mo1116u();
        if (mo1116u == 0) {
            return f3191e;
        }
        short s = (short) ((mo1116u & 240) >> 4);
        byte b = (byte) (mo1116u & 15);
        C1591bn c1591bn = new C1591bn("", m1162d(b), s == 0 ? mo1115v() : (short) (this.f3202n + s));
        if (m1165c(mo1116u)) {
            this.f3204p = b == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f3202n = c1591bn.f3222c;
        return c1591bn;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: m */
    public void mo1124m() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: n */
    public C1593bp mo1123n() throws C1566az {
        int m1175E = m1175E();
        byte mo1116u = m1175E == 0 ? (byte) 0 : mo1116u();
        return new C1593bp(m1162d((byte) (mo1116u >> 4)), m1162d((byte) (mo1116u & 15)), m1175E);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: o */
    public void mo1122o() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: p */
    public C1592bo mo1121p() throws C1566az {
        byte mo1116u = mo1116u();
        int i = (mo1116u >> 4) & 15;
        if (i == 15) {
            i = m1175E();
        }
        return new C1592bo(m1162d(mo1116u), i);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: q */
    public void mo1120q() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: r */
    public C1600bw mo1119r() throws C1566az {
        return new C1600bw(mo1121p());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: s */
    public void mo1118s() throws C1566az {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: t */
    public boolean mo1117t() throws C1566az {
        Boolean bool = this.f3204p;
        if (bool == null) {
            return mo1116u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f3204p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: u */
    public byte mo1116u() throws C1566az {
        if (this.f3235g.mo1085h() <= 0) {
            this.f3235g.m1088d(this.f3200c, 0, 1);
            return this.f3200c[0];
        }
        byte b = this.f3235g.mo1087f()[this.f3235g.mo1086g()];
        this.f3235g.mo1095a(1);
        return b;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: v */
    public short mo1115v() throws C1566az {
        return (short) m1156g(m1175E());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: w */
    public int mo1114w() throws C1566az {
        return m1156g(m1175E());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: x */
    public long mo1113x() throws C1566az {
        return m1160d(m1174F());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: y */
    public double mo1112y() throws C1566az {
        byte[] bArr = new byte[8];
        this.f3235g.m1088d(bArr, 0, 8);
        return Double.longBitsToDouble(m1170a(bArr));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: z */
    public String mo1111z() throws C1566az {
        int m1175E = m1175E();
        m1157f(m1175E);
        if (m1175E == 0) {
            return "";
        }
        try {
            if (this.f3235g.mo1085h() < m1175E) {
                return new String(m1158e(m1175E), "UTF-8");
            }
            String str = new String(this.f3235g.mo1087f(), this.f3235g.mo1086g(), m1175E, "UTF-8");
            this.f3235g.mo1095a(m1175E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new C1566az("UTF-8 not supported!");
        }
    }
}
