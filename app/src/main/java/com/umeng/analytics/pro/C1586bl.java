package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.bl */
/* loaded from: classes4.dex */
public class C1586bl extends AbstractC1596bs {

    /* renamed from: a */
    public static final int f3172a = -65536;

    /* renamed from: b */
    public static final int f3173b = -2147418112;

    /* renamed from: h */
    public static final C1601bx f3174h = new C1601bx();

    /* renamed from: c */
    public boolean f3175c;

    /* renamed from: d */
    public boolean f3176d;

    /* renamed from: e */
    public int f3177e;

    /* renamed from: f */
    public boolean f3178f;

    /* renamed from: i */
    public byte[] f3179i;

    /* renamed from: j */
    public byte[] f3180j;

    /* renamed from: k */
    public byte[] f3181k;

    /* renamed from: l */
    public byte[] f3182l;

    /* renamed from: m */
    public byte[] f3183m;

    /* renamed from: n */
    public byte[] f3184n;

    /* renamed from: o */
    public byte[] f3185o;

    /* renamed from: p */
    public byte[] f3186p;

    /* renamed from: com.umeng.analytics.pro.bl$a */
    /* loaded from: classes4.dex */
    public static class C1587a implements AbstractC1598bu {

        /* renamed from: a */
        public boolean f3187a;

        /* renamed from: b */
        public boolean f3188b;

        /* renamed from: c */
        public int f3189c;

        public C1587a() {
            this(false, true);
        }

        public C1587a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C1587a(boolean z, boolean z2, int i) {
            this.f3187a = false;
            this.f3188b = true;
            this.f3187a = z;
            this.f3188b = z2;
            this.f3189c = i;
        }

        @Override // com.umeng.analytics.pro.AbstractC1598bu
        /* renamed from: a */
        public AbstractC1596bs mo1100a(AbstractC1612cg abstractC1612cg) {
            C1586bl c1586bl = new C1586bl(abstractC1612cg, this.f3187a, this.f3188b);
            int i = this.f3189c;
            if (i != 0) {
                c1586bl.m1177c(i);
            }
            return c1586bl;
        }
    }

    public C1586bl(AbstractC1612cg abstractC1612cg) {
        this(abstractC1612cg, false, true);
    }

    public C1586bl(AbstractC1612cg abstractC1612cg, boolean z, boolean z2) {
        super(abstractC1612cg);
        this.f3175c = false;
        this.f3176d = true;
        this.f3178f = false;
        this.f3179i = new byte[1];
        this.f3180j = new byte[2];
        this.f3181k = new byte[4];
        this.f3182l = new byte[8];
        this.f3183m = new byte[1];
        this.f3184n = new byte[2];
        this.f3185o = new byte[4];
        this.f3186p = new byte[8];
        this.f3175c = z;
        this.f3176d = z2;
    }

    /* renamed from: a */
    private int m1179a(byte[] bArr, int i, int i2) throws C1566az {
        m1176d(i2);
        return this.f3235g.m1088d(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: A */
    public ByteBuffer mo1153A() throws C1566az {
        int mo1114w = mo1114w();
        m1176d(mo1114w);
        if (this.f3235g.mo1085h() >= mo1114w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f3235g.mo1087f(), this.f3235g.mo1086g(), mo1114w);
            this.f3235g.mo1095a(mo1114w);
            return wrap;
        }
        byte[] bArr = new byte[mo1114w];
        this.f3235g.m1088d(bArr, 0, mo1114w);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1150a() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1149a(byte b) throws C1566az {
        byte[] bArr = this.f3179i;
        bArr[0] = b;
        this.f3235g.mo1091b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1148a(double d) throws C1566az {
        mo1146a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1147a(int i) throws C1566az {
        byte[] bArr = this.f3181k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f3235g.mo1091b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1146a(long j) throws C1566az {
        byte[] bArr = this.f3182l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.f3235g.mo1091b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1145a(C1591bn c1591bn) throws C1566az {
        mo1149a(c1591bn.f3221b);
        mo1137a(c1591bn.f3222c);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1144a(C1592bo c1592bo) throws C1566az {
        mo1149a(c1592bo.f3223a);
        mo1147a(c1592bo.f3224b);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1143a(C1593bp c1593bp) throws C1566az {
        mo1149a(c1593bp.f3225a);
        mo1149a(c1593bp.f3226b);
        mo1147a(c1593bp.f3227c);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1142a(C1594bq c1594bq) throws C1566az {
        if (this.f3176d) {
            mo1147a((-2147418112) | c1594bq.f3229b);
            mo1139a(c1594bq.f3228a);
        } else {
            mo1139a(c1594bq.f3228a);
            mo1149a(c1594bq.f3229b);
        }
        mo1147a(c1594bq.f3230c);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1141a(C1600bw c1600bw) throws C1566az {
        mo1149a(c1600bw.f3245a);
        mo1147a(c1600bw.f3246b);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1140a(C1601bx c1601bx) {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1139a(String str) throws C1566az {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo1147a(bytes.length);
            this.f3235g.mo1091b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C1566az("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1138a(ByteBuffer byteBuffer) throws C1566az {
        int limit = byteBuffer.limit() - byteBuffer.position();
        mo1147a(limit);
        this.f3235g.mo1091b(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), limit);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1137a(short s) throws C1566az {
        byte[] bArr = this.f3180j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f3235g.mo1091b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: a */
    public void mo1136a(boolean z) throws C1566az {
        mo1149a(z ? (byte) 1 : (byte) 0);
    }

    /* renamed from: b */
    public String m1178b(int i) throws C1566az {
        try {
            m1176d(i);
            byte[] bArr = new byte[i];
            this.f3235g.m1088d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new C1566az("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: b */
    public void mo1135b() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: c */
    public void mo1134c() {
    }

    /* renamed from: c */
    public void m1177c(int i) {
        this.f3177e = i;
        this.f3178f = true;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: d */
    public void mo1133d() throws C1566az {
        mo1149a((byte) 0);
    }

    /* renamed from: d */
    public void m1176d(int i) throws C1566az {
        if (i >= 0) {
            if (!this.f3178f) {
                return;
            }
            int i2 = this.f3177e - i;
            this.f3177e = i2;
            if (i2 < 0) {
                throw new C1597bt(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Message length exceeded: ", i));
            }
            return;
        }
        throw new C1597bt(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Negative length: ", i));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: e */
    public void mo1132e() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: f */
    public void mo1131f() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: g */
    public void mo1130g() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: h */
    public C1594bq mo1129h() throws C1566az {
        int mo1114w = mo1114w();
        if (mo1114w < 0) {
            if (((-65536) & mo1114w) != -2147418112) {
                throw new C1597bt(4, "Bad version in readMessageBegin");
            }
            return new C1594bq(mo1111z(), (byte) (mo1114w & 255), mo1114w());
        } else if (this.f3175c) {
            throw new C1597bt(4, "Missing version in readMessageBegin, old client?");
        } else {
            return new C1594bq(m1178b(mo1114w), mo1116u(), mo1114w());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: i */
    public void mo1128i() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: j */
    public C1601bx mo1127j() {
        return f3174h;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: k */
    public void mo1126k() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: l */
    public C1591bn mo1125l() throws C1566az {
        byte mo1116u = mo1116u();
        return new C1591bn("", mo1116u, mo1116u == 0 ? (short) 0 : mo1115v());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: m */
    public void mo1124m() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: n */
    public C1593bp mo1123n() throws C1566az {
        return new C1593bp(mo1116u(), mo1116u(), mo1114w());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: o */
    public void mo1122o() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: p */
    public C1592bo mo1121p() throws C1566az {
        return new C1592bo(mo1116u(), mo1114w());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: q */
    public void mo1120q() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: r */
    public C1600bw mo1119r() throws C1566az {
        return new C1600bw(mo1116u(), mo1114w());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: s */
    public void mo1118s() {
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: t */
    public boolean mo1117t() throws C1566az {
        return mo1116u() == 1;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: u */
    public byte mo1116u() throws C1566az {
        if (this.f3235g.mo1085h() < 1) {
            m1179a(this.f3183m, 0, 1);
            return this.f3183m[0];
        }
        byte b = this.f3235g.mo1087f()[this.f3235g.mo1086g()];
        this.f3235g.mo1095a(1);
        return b;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: v */
    public short mo1115v() throws C1566az {
        byte[] bArr = this.f3184n;
        int i = 0;
        if (this.f3235g.mo1085h() >= 2) {
            bArr = this.f3235g.mo1087f();
            i = this.f3235g.mo1086g();
            this.f3235g.mo1095a(2);
        } else {
            m1179a(this.f3184n, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: w */
    public int mo1114w() throws C1566az {
        byte[] bArr = this.f3185o;
        int i = 0;
        if (this.f3235g.mo1085h() >= 4) {
            bArr = this.f3235g.mo1087f();
            i = this.f3235g.mo1086g();
            this.f3235g.mo1095a(4);
        } else {
            m1179a(this.f3185o, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: x */
    public long mo1113x() throws C1566az {
        byte[] bArr = this.f3186p;
        int i = 0;
        if (this.f3235g.mo1085h() >= 8) {
            bArr = this.f3235g.mo1087f();
            i = this.f3235g.mo1086g();
            this.f3235g.mo1095a(8);
        } else {
            m1179a(this.f3186p, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: y */
    public double mo1112y() throws C1566az {
        return Double.longBitsToDouble(mo1113x());
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: z */
    public String mo1111z() throws C1566az {
        int mo1114w = mo1114w();
        if (this.f3235g.mo1085h() >= mo1114w) {
            try {
                String str = new String(this.f3235g.mo1087f(), this.f3235g.mo1086g(), mo1114w, "UTF-8");
                this.f3235g.mo1095a(mo1114w);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new C1566az("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m1178b(mo1114w);
    }
}
