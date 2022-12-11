package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC1558at;
import com.umeng.analytics.pro.AbstractC1570ba;
import com.umeng.analytics.pro.AbstractC1596bs;
import com.umeng.analytics.pro.AbstractC1606ca;
import com.umeng.analytics.pro.AbstractC1607cb;
import com.umeng.analytics.pro.AbstractC1608cc;
import com.umeng.analytics.pro.AbstractC1609cd;
import com.umeng.analytics.pro.C1555aq;
import com.umeng.analytics.pro.C1566az;
import com.umeng.analytics.pro.C1580bf;
import com.umeng.analytics.pro.C1581bg;
import com.umeng.analytics.pro.C1588bm;
import com.umeng.analytics.pro.C1591bn;
import com.umeng.analytics.pro.C1597bt;
import com.umeng.analytics.pro.C1599bv;
import com.umeng.analytics.pro.C1601bx;
import com.umeng.analytics.pro.C1602by;
import com.umeng.analytics.pro.C1610ce;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.umeng.commonsdk.statistics.proto.e */
/* loaded from: classes4.dex */
public class C1838e implements AbstractC1558at<C1838e, EnumC1844e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1844e, C1580bf> f4221d;

    /* renamed from: e */
    public static final long f4222e = 7501688097813630241L;

    /* renamed from: f */
    public static final C1601bx f4223f = new C1601bx("ImprintValue");

    /* renamed from: g */
    public static final C1591bn f4224g = new C1591bn("value", (byte) 11, 1);

    /* renamed from: h */
    public static final C1591bn f4225h = new C1591bn("ts", (byte) 10, 2);

    /* renamed from: i */
    public static final C1591bn f4226i = new C1591bn("guid", (byte) 11, 3);

    /* renamed from: j */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f4227j;

    /* renamed from: k */
    public static final int f4228k = 0;

    /* renamed from: a */
    public String f4229a;

    /* renamed from: b */
    public long f4230b;

    /* renamed from: c */
    public String f4231c;

    /* renamed from: l */
    public byte f4232l;

    /* renamed from: m */
    public EnumC1844e[] f4233m;

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$a */
    /* loaded from: classes4.dex */
    public static class C1840a extends AbstractC1608cc<C1838e> {
        public C1840a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1838e c1838e) throws C1566az {
            abstractC1596bs.mo1127j();
            while (true) {
                C1591bn mo1125l = abstractC1596bs.mo1125l();
                byte b = mo1125l.f3221b;
                if (b == 0) {
                    break;
                }
                short s = mo1125l.f3222c;
                if (s == 1) {
                    if (b == 11) {
                        c1838e.f4229a = abstractC1596bs.mo1111z();
                        c1838e.m256a(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else if (s != 2) {
                    if (s == 3 && b == 11) {
                        c1838e.f4231c = abstractC1596bs.mo1111z();
                        c1838e.m251c(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else {
                    if (b == 10) {
                        c1838e.f4230b = abstractC1596bs.mo1113x();
                        c1838e.m253b(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                }
                abstractC1596bs.mo1124m();
            }
            abstractC1596bs.mo1126k();
            if (c1838e.m247g()) {
                c1838e.m243k();
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'ts' was not found in serialized data! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1838e c1838e) throws C1566az {
            c1838e.m243k();
            abstractC1596bs.mo1140a(C1838e.f4223f);
            if (c1838e.f4229a != null && c1838e.m250d()) {
                abstractC1596bs.mo1145a(C1838e.f4224g);
                abstractC1596bs.mo1139a(c1838e.f4229a);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1145a(C1838e.f4225h);
            abstractC1596bs.mo1146a(c1838e.f4230b);
            abstractC1596bs.mo1134c();
            if (c1838e.f4231c != null) {
                abstractC1596bs.mo1145a(C1838e.f4226i);
                abstractC1596bs.mo1139a(c1838e.f4231c);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$b */
    /* loaded from: classes4.dex */
    public static class C1841b implements AbstractC1607cb {
        public C1841b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1840a mo230b() {
            return new C1840a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$c */
    /* loaded from: classes4.dex */
    public static class C1842c extends AbstractC1609cd<C1838e> {
        public C1842c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1838e c1838e) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1146a(c1838e.f4230b);
            c1602by.mo1139a(c1838e.f4231c);
            BitSet bitSet = new BitSet();
            if (c1838e.m250d()) {
                bitSet.set(0);
            }
            c1602by.m1104a(bitSet, 1);
            if (c1838e.m250d()) {
                c1602by.mo1139a(c1838e.f4229a);
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1838e c1838e) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1838e.f4230b = c1602by.mo1113x();
            c1838e.m253b(true);
            c1838e.f4231c = c1602by.mo1111z();
            c1838e.m251c(true);
            if (c1602by.m1102b(1).get(0)) {
                c1838e.f4229a = c1602by.mo1111z();
                c1838e.m256a(true);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$d */
    /* loaded from: classes4.dex */
    public static class C1843d implements AbstractC1607cb {
        public C1843d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1842c mo230b() {
            return new C1842c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    /* loaded from: classes4.dex */
    public enum EnumC1844e implements AbstractC1570ba {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d */
        public static final Map<String, EnumC1844e> f4237d = new HashMap();

        /* renamed from: e */
        public final short f4239e;

        /* renamed from: f */
        public final String f4240f;

        static {
            Iterator it = EnumSet.allOf(EnumC1844e.class).iterator();
            while (it.hasNext()) {
                EnumC1844e enumC1844e = (EnumC1844e) it.next();
                f4237d.put(enumC1844e.mo226b(), enumC1844e);
            }
        }

        EnumC1844e(short s, String str) {
            this.f4239e = s;
            this.f4240f = str;
        }

        /* renamed from: a */
        public static EnumC1844e m228a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return TS;
                }
                if (i == 3) {
                    return GUID;
                }
                return null;
            }
            return VALUE;
        }

        /* renamed from: a */
        public static EnumC1844e m227a(String str) {
            return f4237d.get(str);
        }

        /* renamed from: b */
        public static EnumC1844e m225b(int i) {
            EnumC1844e m228a = m228a(i);
            if (m228a != null) {
                return m228a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f4239e;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f4240f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4227j = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1841b());
        f4227j.put(AbstractC1609cd.class, new C1843d());
        EnumMap enumMap = new EnumMap(EnumC1844e.class);
        enumMap.put((EnumMap) EnumC1844e.VALUE, (EnumC1844e) new C1580bf("value", (byte) 2, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1844e.TS, (EnumC1844e) new C1580bf("ts", (byte) 1, new C1581bg((byte) 10)));
        enumMap.put((EnumMap) EnumC1844e.GUID, (EnumC1844e) new C1580bf("guid", (byte) 1, new C1581bg((byte) 11)));
        Map<EnumC1844e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f4221d = unmodifiableMap;
        C1580bf.m1185a(C1838e.class, unmodifiableMap);
    }

    public C1838e() {
        this.f4232l = (byte) 0;
        this.f4233m = new EnumC1844e[]{EnumC1844e.VALUE};
    }

    public C1838e(long j, String str) {
        this();
        this.f4230b = j;
        m253b(true);
        this.f4231c = str;
    }

    public C1838e(C1838e c1838e) {
        this.f4232l = (byte) 0;
        this.f4233m = new EnumC1844e[]{EnumC1844e.VALUE};
        this.f4232l = c1838e.f4232l;
        if (c1838e.m250d()) {
            this.f4229a = c1838e.f4229a;
        }
        this.f4230b = c1838e.f4230b;
        if (c1838e.m244j()) {
            this.f4231c = c1838e.f4231c;
        }
    }

    /* renamed from: a */
    private void m259a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f4232l = (byte) 0;
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m258a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public EnumC1844e fieldForId(int i) {
        return EnumC1844e.m228a(i);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public C1838e deepCopy() {
        return new C1838e(this);
    }

    /* renamed from: a */
    public C1838e m260a(long j) {
        this.f4230b = j;
        m253b(true);
        return this;
    }

    /* renamed from: a */
    public C1838e m257a(String str) {
        this.f4229a = str;
        return this;
    }

    /* renamed from: a */
    public void m256a(boolean z) {
        if (!z) {
            this.f4229a = null;
        }
    }

    /* renamed from: b */
    public C1838e m254b(String str) {
        this.f4231c = str;
        return this;
    }

    /* renamed from: b */
    public String m255b() {
        return this.f4229a;
    }

    /* renamed from: b */
    public void m253b(boolean z) {
        this.f4232l = C1555aq.m1283a(this.f4232l, 0, z);
    }

    /* renamed from: c */
    public void m252c() {
        this.f4229a = null;
    }

    /* renamed from: c */
    public void m251c(boolean z) {
        if (!z) {
            this.f4231c = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        this.f4229a = null;
        m253b(false);
        this.f4230b = 0L;
        this.f4231c = null;
    }

    /* renamed from: d */
    public boolean m250d() {
        return this.f4229a != null;
    }

    /* renamed from: e */
    public long m249e() {
        return this.f4230b;
    }

    /* renamed from: f */
    public void m248f() {
        this.f4232l = C1555aq.m1272b(this.f4232l, 0);
    }

    /* renamed from: g */
    public boolean m247g() {
        return C1555aq.m1284a(this.f4232l, 0);
    }

    /* renamed from: h */
    public String m246h() {
        return this.f4231c;
    }

    /* renamed from: i */
    public void m245i() {
        this.f4231c = null;
    }

    /* renamed from: j */
    public boolean m244j() {
        return this.f4231c != null;
    }

    /* renamed from: k */
    public void m243k() throws C1566az {
        if (this.f4231c != null) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'guid' was not present! Struct: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
        throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4227j.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (m250d()) {
            sb.append("value:");
            String str = this.f4229a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f4230b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f4231c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4227j.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
