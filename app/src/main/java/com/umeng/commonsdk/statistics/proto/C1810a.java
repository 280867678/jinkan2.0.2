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

/* renamed from: com.umeng.commonsdk.statistics.proto.a */
/* loaded from: classes4.dex */
public class C1810a implements AbstractC1558at<C1810a, EnumC1816e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<EnumC1816e, C1580bf> f4141e;

    /* renamed from: f */
    public static final long f4142f = 9132678615281394583L;

    /* renamed from: g */
    public static final C1601bx f4143g = new C1601bx("IdJournal");

    /* renamed from: h */
    public static final C1591bn f4144h = new C1591bn("domain", (byte) 11, 1);

    /* renamed from: i */
    public static final C1591bn f4145i = new C1591bn("old_id", (byte) 11, 2);

    /* renamed from: j */
    public static final C1591bn f4146j = new C1591bn("new_id", (byte) 11, 3);

    /* renamed from: k */
    public static final C1591bn f4147k = new C1591bn("ts", (byte) 10, 4);

    /* renamed from: l */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f4148l;

    /* renamed from: m */
    public static final int f4149m = 0;

    /* renamed from: a */
    public String f4150a;

    /* renamed from: b */
    public String f4151b;

    /* renamed from: c */
    public String f4152c;

    /* renamed from: d */
    public long f4153d;

    /* renamed from: n */
    public byte f4154n;

    /* renamed from: o */
    public EnumC1816e[] f4155o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    /* loaded from: classes4.dex */
    public static class C1812a extends AbstractC1608cc<C1810a> {
        public C1812a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1810a c1810a) throws C1566az {
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
                        c1810a.f4150a = abstractC1596bs.mo1111z();
                        c1810a.m401a(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else if (s == 2) {
                    if (b == 11) {
                        c1810a.f4151b = abstractC1596bs.mo1111z();
                        c1810a.m398b(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else if (s != 3) {
                    if (s == 4 && b == 10) {
                        c1810a.f4153d = abstractC1596bs.mo1113x();
                        c1810a.m393d(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else {
                    if (b == 11) {
                        c1810a.f4152c = abstractC1596bs.mo1111z();
                        c1810a.m395c(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                }
                abstractC1596bs.mo1124m();
            }
            abstractC1596bs.mo1126k();
            if (c1810a.m384m()) {
                c1810a.m383n();
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'ts' was not found in serialized data! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1810a c1810a) throws C1566az {
            c1810a.m383n();
            abstractC1596bs.mo1140a(C1810a.f4143g);
            if (c1810a.f4150a != null) {
                abstractC1596bs.mo1145a(C1810a.f4144h);
                abstractC1596bs.mo1139a(c1810a.f4150a);
                abstractC1596bs.mo1134c();
            }
            if (c1810a.f4151b != null && c1810a.m390g()) {
                abstractC1596bs.mo1145a(C1810a.f4145i);
                abstractC1596bs.mo1139a(c1810a.f4151b);
                abstractC1596bs.mo1134c();
            }
            if (c1810a.f4152c != null) {
                abstractC1596bs.mo1145a(C1810a.f4146j);
                abstractC1596bs.mo1139a(c1810a.f4152c);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1145a(C1810a.f4147k);
            abstractC1596bs.mo1146a(c1810a.f4153d);
            abstractC1596bs.mo1134c();
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$b */
    /* loaded from: classes4.dex */
    public static class C1813b implements AbstractC1607cb {
        public C1813b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1812a mo230b() {
            return new C1812a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$c */
    /* loaded from: classes4.dex */
    public static class C1814c extends AbstractC1609cd<C1810a> {
        public C1814c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1810a c1810a) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1139a(c1810a.f4150a);
            c1602by.mo1139a(c1810a.f4152c);
            c1602by.mo1146a(c1810a.f4153d);
            BitSet bitSet = new BitSet();
            if (c1810a.m390g()) {
                bitSet.set(0);
            }
            c1602by.m1104a(bitSet, 1);
            if (c1810a.m390g()) {
                c1602by.mo1139a(c1810a.f4151b);
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1810a c1810a) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1810a.f4150a = c1602by.mo1111z();
            c1810a.m401a(true);
            c1810a.f4152c = c1602by.mo1111z();
            c1810a.m395c(true);
            c1810a.f4153d = c1602by.mo1113x();
            c1810a.m393d(true);
            if (c1602by.m1102b(1).get(0)) {
                c1810a.f4151b = c1602by.mo1111z();
                c1810a.m398b(true);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$d */
    /* loaded from: classes4.dex */
    public static class C1815d implements AbstractC1607cb {
        public C1815d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1814c mo230b() {
            return new C1814c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$e */
    /* loaded from: classes4.dex */
    public enum EnumC1816e implements AbstractC1570ba {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e */
        public static final Map<String, EnumC1816e> f4160e = new HashMap();

        /* renamed from: f */
        public final short f4162f;

        /* renamed from: g */
        public final String f4163g;

        static {
            Iterator it = EnumSet.allOf(EnumC1816e.class).iterator();
            while (it.hasNext()) {
                EnumC1816e enumC1816e = (EnumC1816e) it.next();
                f4160e.put(enumC1816e.mo226b(), enumC1816e);
            }
        }

        EnumC1816e(short s, String str) {
            this.f4162f = s;
            this.f4163g = str;
        }

        /* renamed from: a */
        public static EnumC1816e m371a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return OLD_ID;
                }
                if (i == 3) {
                    return NEW_ID;
                }
                if (i == 4) {
                    return TS;
                }
                return null;
            }
            return DOMAIN;
        }

        /* renamed from: a */
        public static EnumC1816e m370a(String str) {
            return f4160e.get(str);
        }

        /* renamed from: b */
        public static EnumC1816e m369b(int i) {
            EnumC1816e m371a = m371a(i);
            if (m371a != null) {
                return m371a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f4162f;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f4163g;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4148l = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1813b());
        f4148l.put(AbstractC1609cd.class, new C1815d());
        EnumMap enumMap = new EnumMap(EnumC1816e.class);
        enumMap.put((EnumMap) EnumC1816e.DOMAIN, (EnumC1816e) new C1580bf("domain", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1816e.OLD_ID, (EnumC1816e) new C1580bf("old_id", (byte) 2, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1816e.NEW_ID, (EnumC1816e) new C1580bf("new_id", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1816e.TS, (EnumC1816e) new C1580bf("ts", (byte) 1, new C1581bg((byte) 10)));
        Map<EnumC1816e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f4141e = unmodifiableMap;
        C1580bf.m1185a(C1810a.class, unmodifiableMap);
    }

    public C1810a() {
        this.f4154n = (byte) 0;
        this.f4155o = new EnumC1816e[]{EnumC1816e.OLD_ID};
    }

    public C1810a(C1810a c1810a) {
        this.f4154n = (byte) 0;
        this.f4155o = new EnumC1816e[]{EnumC1816e.OLD_ID};
        this.f4154n = c1810a.f4154n;
        if (c1810a.m394d()) {
            this.f4150a = c1810a.f4150a;
        }
        if (c1810a.m390g()) {
            this.f4151b = c1810a.f4151b;
        }
        if (c1810a.m387j()) {
            this.f4152c = c1810a.f4152c;
        }
        this.f4153d = c1810a.f4153d;
    }

    public C1810a(String str, String str2, long j) {
        this();
        this.f4150a = str;
        this.f4152c = str2;
        this.f4153d = j;
        m393d(true);
    }

    /* renamed from: a */
    private void m404a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f4154n = (byte) 0;
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m403a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public EnumC1816e fieldForId(int i) {
        return EnumC1816e.m371a(i);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public C1810a deepCopy() {
        return new C1810a(this);
    }

    /* renamed from: a */
    public C1810a m405a(long j) {
        this.f4153d = j;
        m393d(true);
        return this;
    }

    /* renamed from: a */
    public C1810a m402a(String str) {
        this.f4150a = str;
        return this;
    }

    /* renamed from: a */
    public void m401a(boolean z) {
        if (!z) {
            this.f4150a = null;
        }
    }

    /* renamed from: b */
    public C1810a m399b(String str) {
        this.f4151b = str;
        return this;
    }

    /* renamed from: b */
    public String m400b() {
        return this.f4150a;
    }

    /* renamed from: b */
    public void m398b(boolean z) {
        if (!z) {
            this.f4151b = null;
        }
    }

    /* renamed from: c */
    public C1810a m396c(String str) {
        this.f4152c = str;
        return this;
    }

    /* renamed from: c */
    public void m397c() {
        this.f4150a = null;
    }

    /* renamed from: c */
    public void m395c(boolean z) {
        if (!z) {
            this.f4152c = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        this.f4150a = null;
        this.f4151b = null;
        this.f4152c = null;
        m393d(false);
        this.f4153d = 0L;
    }

    /* renamed from: d */
    public void m393d(boolean z) {
        this.f4154n = C1555aq.m1283a(this.f4154n, 0, z);
    }

    /* renamed from: d */
    public boolean m394d() {
        return this.f4150a != null;
    }

    /* renamed from: e */
    public String m392e() {
        return this.f4151b;
    }

    /* renamed from: f */
    public void m391f() {
        this.f4151b = null;
    }

    /* renamed from: g */
    public boolean m390g() {
        return this.f4151b != null;
    }

    /* renamed from: h */
    public String m389h() {
        return this.f4152c;
    }

    /* renamed from: i */
    public void m388i() {
        this.f4152c = null;
    }

    /* renamed from: j */
    public boolean m387j() {
        return this.f4152c != null;
    }

    /* renamed from: k */
    public long m386k() {
        return this.f4153d;
    }

    /* renamed from: l */
    public void m385l() {
        this.f4154n = C1555aq.m1272b(this.f4154n, 0);
    }

    /* renamed from: m */
    public boolean m384m() {
        return C1555aq.m1284a(this.f4154n, 0);
    }

    /* renamed from: n */
    public void m383n() throws C1566az {
        if (this.f4150a == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'domain' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (this.f4152c != null) {
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'new_id' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4148l.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f4150a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (m390g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f4151b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f4152c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.f4153d, ")");
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4148l.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
