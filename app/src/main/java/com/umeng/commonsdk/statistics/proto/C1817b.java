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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.outline;
import org.litepal.parser.LitePalParser;

/* renamed from: com.umeng.commonsdk.statistics.proto.b */
/* loaded from: classes4.dex */
public class C1817b implements AbstractC1558at<C1817b, EnumC1823e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1823e, C1580bf> f4164d;

    /* renamed from: e */
    public static final long f4165e = -6496538196005191531L;

    /* renamed from: f */
    public static final C1601bx f4166f = new C1601bx("IdSnapshot");

    /* renamed from: g */
    public static final C1591bn f4167g = new C1591bn("identity", (byte) 11, 1);

    /* renamed from: h */
    public static final C1591bn f4168h = new C1591bn("ts", (byte) 10, 2);

    /* renamed from: i */
    public static final C1591bn f4169i = new C1591bn(LitePalParser.NODE_VERSION, (byte) 8, 3);

    /* renamed from: j */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f4170j;

    /* renamed from: k */
    public static final int f4171k = 0;

    /* renamed from: l */
    public static final int f4172l = 1;

    /* renamed from: a */
    public String f4173a;

    /* renamed from: b */
    public long f4174b;

    /* renamed from: c */
    public int f4175c;

    /* renamed from: m */
    public byte f4176m;

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$a */
    /* loaded from: classes4.dex */
    public static class C1819a extends AbstractC1608cc<C1817b> {
        public C1819a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1817b c1817b) throws C1566az {
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
                        c1817b.f4173a = abstractC1596bs.mo1111z();
                        c1817b.m362a(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else if (s != 2) {
                    if (s == 3 && b == 8) {
                        c1817b.f4175c = abstractC1596bs.mo1114w();
                        c1817b.m357c(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else {
                    if (b == 10) {
                        c1817b.f4174b = abstractC1596bs.mo1113x();
                        c1817b.m359b(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                }
                abstractC1596bs.mo1124m();
            }
            abstractC1596bs.mo1126k();
            if (!c1817b.m353g()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'ts' was not found in serialized data! Struct: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
                throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else if (c1817b.m350j()) {
                c1817b.m349k();
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'version' was not found in serialized data! Struct: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toString());
                throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1817b c1817b) throws C1566az {
            c1817b.m349k();
            abstractC1596bs.mo1140a(C1817b.f4166f);
            if (c1817b.f4173a != null) {
                abstractC1596bs.mo1145a(C1817b.f4167g);
                abstractC1596bs.mo1139a(c1817b.f4173a);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1145a(C1817b.f4168h);
            abstractC1596bs.mo1146a(c1817b.f4174b);
            abstractC1596bs.mo1134c();
            abstractC1596bs.mo1145a(C1817b.f4169i);
            abstractC1596bs.mo1147a(c1817b.f4175c);
            abstractC1596bs.mo1134c();
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    /* loaded from: classes4.dex */
    public static class C1820b implements AbstractC1607cb {
        public C1820b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1819a mo230b() {
            return new C1819a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$c */
    /* loaded from: classes4.dex */
    public static class C1821c extends AbstractC1609cd<C1817b> {
        public C1821c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1817b c1817b) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1139a(c1817b.f4173a);
            c1602by.mo1146a(c1817b.f4174b);
            c1602by.mo1147a(c1817b.f4175c);
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1817b c1817b) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1817b.f4173a = c1602by.mo1111z();
            c1817b.m362a(true);
            c1817b.f4174b = c1602by.mo1113x();
            c1817b.m359b(true);
            c1817b.f4175c = c1602by.mo1114w();
            c1817b.m357c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$d */
    /* loaded from: classes4.dex */
    public static class C1822d implements AbstractC1607cb {
        public C1822d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1821c mo230b() {
            return new C1821c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$e */
    /* loaded from: classes4.dex */
    public enum EnumC1823e implements AbstractC1570ba {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, LitePalParser.NODE_VERSION);
        

        /* renamed from: d */
        public static final Map<String, EnumC1823e> f4180d = new HashMap();

        /* renamed from: e */
        public final short f4182e;

        /* renamed from: f */
        public final String f4183f;

        static {
            Iterator it = EnumSet.allOf(EnumC1823e.class).iterator();
            while (it.hasNext()) {
                EnumC1823e enumC1823e = (EnumC1823e) it.next();
                f4180d.put(enumC1823e.mo226b(), enumC1823e);
            }
        }

        EnumC1823e(short s, String str) {
            this.f4182e = s;
            this.f4183f = str;
        }

        /* renamed from: a */
        public static EnumC1823e m338a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return TS;
                }
                if (i == 3) {
                    return VERSION;
                }
                return null;
            }
            return IDENTITY;
        }

        /* renamed from: a */
        public static EnumC1823e m337a(String str) {
            return f4180d.get(str);
        }

        /* renamed from: b */
        public static EnumC1823e m336b(int i) {
            EnumC1823e m338a = m338a(i);
            if (m338a != null) {
                return m338a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f4182e;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f4183f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4170j = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1820b());
        f4170j.put(AbstractC1609cd.class, new C1822d());
        EnumMap enumMap = new EnumMap(EnumC1823e.class);
        enumMap.put((EnumMap) EnumC1823e.IDENTITY, (EnumC1823e) new C1580bf("identity", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1823e.TS, (EnumC1823e) new C1580bf("ts", (byte) 1, new C1581bg((byte) 10)));
        enumMap.put((EnumMap) EnumC1823e.VERSION, (EnumC1823e) new C1580bf(LitePalParser.NODE_VERSION, (byte) 1, new C1581bg((byte) 8)));
        Map<EnumC1823e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f4164d = unmodifiableMap;
        C1580bf.m1185a(C1817b.class, unmodifiableMap);
    }

    public C1817b() {
        this.f4176m = (byte) 0;
    }

    public C1817b(C1817b c1817b) {
        this.f4176m = (byte) 0;
        this.f4176m = c1817b.f4176m;
        if (c1817b.m356d()) {
            this.f4173a = c1817b.f4173a;
        }
        this.f4174b = c1817b.f4174b;
        this.f4175c = c1817b.f4175c;
    }

    public C1817b(String str, long j, int i) {
        this();
        this.f4173a = str;
        this.f4174b = j;
        m359b(true);
        this.f4175c = i;
        m357c(true);
    }

    /* renamed from: a */
    private void m365a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f4176m = (byte) 0;
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m364a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public C1817b deepCopy() {
        return new C1817b(this);
    }

    /* renamed from: a */
    public C1817b m367a(int i) {
        this.f4175c = i;
        m357c(true);
        return this;
    }

    /* renamed from: a */
    public C1817b m366a(long j) {
        this.f4174b = j;
        m359b(true);
        return this;
    }

    /* renamed from: a */
    public C1817b m363a(String str) {
        this.f4173a = str;
        return this;
    }

    /* renamed from: a */
    public void m362a(boolean z) {
        if (!z) {
            this.f4173a = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: b */
    public EnumC1823e fieldForId(int i) {
        return EnumC1823e.m338a(i);
    }

    /* renamed from: b */
    public String m361b() {
        return this.f4173a;
    }

    /* renamed from: b */
    public void m359b(boolean z) {
        this.f4176m = C1555aq.m1283a(this.f4176m, 0, z);
    }

    /* renamed from: c */
    public void m358c() {
        this.f4173a = null;
    }

    /* renamed from: c */
    public void m357c(boolean z) {
        this.f4176m = C1555aq.m1283a(this.f4176m, 1, z);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        this.f4173a = null;
        m359b(false);
        this.f4174b = 0L;
        m357c(false);
        this.f4175c = 0;
    }

    /* renamed from: d */
    public boolean m356d() {
        return this.f4173a != null;
    }

    /* renamed from: e */
    public long m355e() {
        return this.f4174b;
    }

    /* renamed from: f */
    public void m354f() {
        this.f4176m = C1555aq.m1272b(this.f4176m, 0);
    }

    /* renamed from: g */
    public boolean m353g() {
        return C1555aq.m1284a(this.f4176m, 0);
    }

    /* renamed from: h */
    public int m352h() {
        return this.f4175c;
    }

    /* renamed from: i */
    public void m351i() {
        this.f4176m = C1555aq.m1272b(this.f4176m, 1);
    }

    /* renamed from: j */
    public boolean m350j() {
        return C1555aq.m1284a(this.f4176m, 1);
    }

    /* renamed from: k */
    public void m349k() throws C1566az {
        if (this.f4173a != null) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'identity' was not present! Struct: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
        throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4170j.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f4173a;
        if (str == null) {
            str = "null";
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, ", ", "ts:");
        sb.append(this.f4174b);
        sb.append(", ");
        sb.append("version:");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.f4175c, ")");
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4170j.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
