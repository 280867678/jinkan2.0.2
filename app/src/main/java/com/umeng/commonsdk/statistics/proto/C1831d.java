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
import com.umeng.analytics.pro.C1583bi;
import com.umeng.analytics.pro.C1585bk;
import com.umeng.analytics.pro.C1588bm;
import com.umeng.analytics.pro.C1591bn;
import com.umeng.analytics.pro.C1593bp;
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

/* renamed from: com.umeng.commonsdk.statistics.proto.d */
/* loaded from: classes4.dex */
public class C1831d implements AbstractC1558at<C1831d, EnumC1837e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1837e, C1580bf> f4202d;

    /* renamed from: e */
    public static final long f4203e = 2846460275012375038L;

    /* renamed from: f */
    public static final C1601bx f4204f = new C1601bx("Imprint");

    /* renamed from: g */
    public static final C1591bn f4205g = new C1591bn("property", (byte) 13, 1);

    /* renamed from: h */
    public static final C1591bn f4206h = new C1591bn(LitePalParser.NODE_VERSION, (byte) 8, 2);

    /* renamed from: i */
    public static final C1591bn f4207i = new C1591bn("checksum", (byte) 11, 3);

    /* renamed from: j */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f4208j;

    /* renamed from: k */
    public static final int f4209k = 0;

    /* renamed from: a */
    public Map<String, C1838e> f4210a;

    /* renamed from: b */
    public int f4211b;

    /* renamed from: c */
    public String f4212c;

    /* renamed from: l */
    public byte f4213l;

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$a */
    /* loaded from: classes4.dex */
    public static class C1833a extends AbstractC1608cc<C1831d> {
        public C1833a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1831d c1831d) throws C1566az {
            abstractC1596bs.mo1127j();
            while (true) {
                C1591bn mo1125l = abstractC1596bs.mo1125l();
                byte b = mo1125l.f3221b;
                if (b == 0) {
                    break;
                }
                short s = mo1125l.f3222c;
                if (s == 1) {
                    if (b == 13) {
                        C1593bp mo1123n = abstractC1596bs.mo1123n();
                        c1831d.f4210a = new HashMap(mo1123n.f3227c * 2);
                        for (int i = 0; i < mo1123n.f3227c; i++) {
                            String mo1111z = abstractC1596bs.mo1111z();
                            C1838e c1838e = new C1838e();
                            c1838e.read(abstractC1596bs);
                            c1831d.f4210a.put(mo1111z, c1838e);
                        }
                        abstractC1596bs.mo1122o();
                        c1831d.m290a(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else if (s != 2) {
                    if (s == 3 && b == 11) {
                        c1831d.f4212c = abstractC1596bs.mo1111z();
                        c1831d.m285c(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else {
                    if (b == 8) {
                        c1831d.f4211b = abstractC1596bs.mo1114w();
                        c1831d.m287b(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                }
                abstractC1596bs.mo1124m();
            }
            abstractC1596bs.mo1126k();
            if (c1831d.m280h()) {
                c1831d.m276l();
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'version' was not found in serialized data! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1831d c1831d) throws C1566az {
            c1831d.m276l();
            abstractC1596bs.mo1140a(C1831d.f4204f);
            if (c1831d.f4210a != null) {
                abstractC1596bs.mo1145a(C1831d.f4205g);
                abstractC1596bs.mo1143a(new C1593bp((byte) 11, (byte) 12, c1831d.f4210a.size()));
                for (Map.Entry<String, C1838e> entry : c1831d.f4210a.entrySet()) {
                    abstractC1596bs.mo1139a(entry.getKey());
                    entry.getValue().write(abstractC1596bs);
                }
                abstractC1596bs.mo1132e();
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1145a(C1831d.f4206h);
            abstractC1596bs.mo1147a(c1831d.f4211b);
            abstractC1596bs.mo1134c();
            if (c1831d.f4212c != null) {
                abstractC1596bs.mo1145a(C1831d.f4207i);
                abstractC1596bs.mo1139a(c1831d.f4212c);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$b */
    /* loaded from: classes4.dex */
    public static class C1834b implements AbstractC1607cb {
        public C1834b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1833a mo230b() {
            return new C1833a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$c */
    /* loaded from: classes4.dex */
    public static class C1835c extends AbstractC1609cd<C1831d> {
        public C1835c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1831d c1831d) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1147a(c1831d.f4210a.size());
            for (Map.Entry<String, C1838e> entry : c1831d.f4210a.entrySet()) {
                c1602by.mo1139a(entry.getKey());
                entry.getValue().write(c1602by);
            }
            c1602by.mo1147a(c1831d.f4211b);
            c1602by.mo1139a(c1831d.f4212c);
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1831d c1831d) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            C1593bp c1593bp = new C1593bp((byte) 11, (byte) 12, c1602by.mo1114w());
            c1831d.f4210a = new HashMap(c1593bp.f3227c * 2);
            for (int i = 0; i < c1593bp.f3227c; i++) {
                String mo1111z = c1602by.mo1111z();
                C1838e c1838e = new C1838e();
                c1838e.read(c1602by);
                c1831d.f4210a.put(mo1111z, c1838e);
            }
            c1831d.m290a(true);
            c1831d.f4211b = c1602by.mo1114w();
            c1831d.m287b(true);
            c1831d.f4212c = c1602by.mo1111z();
            c1831d.m285c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d */
    /* loaded from: classes4.dex */
    public static class C1836d implements AbstractC1607cb {
        public C1836d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1835c mo230b() {
            return new C1835c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$e */
    /* loaded from: classes4.dex */
    public enum EnumC1837e implements AbstractC1570ba {
        PROPERTY(1, "property"),
        VERSION(2, LitePalParser.NODE_VERSION),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        public static final Map<String, EnumC1837e> f4217d = new HashMap();

        /* renamed from: e */
        public final short f4219e;

        /* renamed from: f */
        public final String f4220f;

        static {
            Iterator it = EnumSet.allOf(EnumC1837e.class).iterator();
            while (it.hasNext()) {
                EnumC1837e enumC1837e = (EnumC1837e) it.next();
                f4217d.put(enumC1837e.mo226b(), enumC1837e);
            }
        }

        EnumC1837e(short s, String str) {
            this.f4219e = s;
            this.f4220f = str;
        }

        /* renamed from: a */
        public static EnumC1837e m265a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return VERSION;
                }
                if (i == 3) {
                    return CHECKSUM;
                }
                return null;
            }
            return PROPERTY;
        }

        /* renamed from: a */
        public static EnumC1837e m264a(String str) {
            return f4217d.get(str);
        }

        /* renamed from: b */
        public static EnumC1837e m263b(int i) {
            EnumC1837e m265a = m265a(i);
            if (m265a != null) {
                return m265a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f4219e;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f4220f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4208j = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1834b());
        f4208j.put(AbstractC1609cd.class, new C1836d());
        EnumMap enumMap = new EnumMap(EnumC1837e.class);
        enumMap.put((EnumMap) EnumC1837e.PROPERTY, (EnumC1837e) new C1580bf("property", (byte) 1, new C1583bi((byte) 13, new C1581bg((byte) 11), new C1585bk((byte) 12, C1838e.class))));
        enumMap.put((EnumMap) EnumC1837e.VERSION, (EnumC1837e) new C1580bf(LitePalParser.NODE_VERSION, (byte) 1, new C1581bg((byte) 8)));
        enumMap.put((EnumMap) EnumC1837e.CHECKSUM, (EnumC1837e) new C1580bf("checksum", (byte) 1, new C1581bg((byte) 11)));
        Map<EnumC1837e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f4202d = unmodifiableMap;
        C1580bf.m1185a(C1831d.class, unmodifiableMap);
    }

    public C1831d() {
        this.f4213l = (byte) 0;
    }

    public C1831d(C1831d c1831d) {
        this.f4213l = (byte) 0;
        this.f4213l = c1831d.f4213l;
        if (c1831d.m283e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, C1838e> entry : c1831d.f4210a.entrySet()) {
                hashMap.put(entry.getKey(), new C1838e(entry.getValue()));
            }
            this.f4210a = hashMap;
        }
        this.f4211b = c1831d.f4211b;
        if (c1831d.m277k()) {
            this.f4212c = c1831d.f4212c;
        }
    }

    public C1831d(Map<String, C1838e> map, int i, String str) {
        this();
        this.f4210a = map;
        this.f4211b = i;
        m287b(true);
        this.f4212c = str;
    }

    /* renamed from: a */
    private void m295a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f4213l = (byte) 0;
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m294a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public C1831d deepCopy() {
        return new C1831d(this);
    }

    /* renamed from: a */
    public C1831d m296a(int i) {
        this.f4211b = i;
        m287b(true);
        return this;
    }

    /* renamed from: a */
    public C1831d m293a(String str) {
        this.f4212c = str;
        return this;
    }

    /* renamed from: a */
    public C1831d m291a(Map<String, C1838e> map) {
        this.f4210a = map;
        return this;
    }

    /* renamed from: a */
    public void m292a(String str, C1838e c1838e) {
        if (this.f4210a == null) {
            this.f4210a = new HashMap();
        }
        this.f4210a.put(str, c1838e);
    }

    /* renamed from: a */
    public void m290a(boolean z) {
        if (!z) {
            this.f4210a = null;
        }
    }

    /* renamed from: b */
    public int m289b() {
        Map<String, C1838e> map = this.f4210a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: b */
    public EnumC1837e fieldForId(int i) {
        return EnumC1837e.m265a(i);
    }

    /* renamed from: b */
    public void m287b(boolean z) {
        this.f4213l = C1555aq.m1283a(this.f4213l, 0, z);
    }

    /* renamed from: c */
    public Map<String, C1838e> m286c() {
        return this.f4210a;
    }

    /* renamed from: c */
    public void m285c(boolean z) {
        if (!z) {
            this.f4212c = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        this.f4210a = null;
        m287b(false);
        this.f4211b = 0;
        this.f4212c = null;
    }

    /* renamed from: d */
    public void m284d() {
        this.f4210a = null;
    }

    /* renamed from: e */
    public boolean m283e() {
        return this.f4210a != null;
    }

    /* renamed from: f */
    public int m282f() {
        return this.f4211b;
    }

    /* renamed from: g */
    public void m281g() {
        this.f4213l = C1555aq.m1272b(this.f4213l, 0);
    }

    /* renamed from: h */
    public boolean m280h() {
        return C1555aq.m1284a(this.f4213l, 0);
    }

    /* renamed from: i */
    public String m279i() {
        return this.f4212c;
    }

    /* renamed from: j */
    public void m278j() {
        this.f4212c = null;
    }

    /* renamed from: k */
    public boolean m277k() {
        return this.f4212c != null;
    }

    /* renamed from: l */
    public void m276l() throws C1566az {
        if (this.f4210a == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'property' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (this.f4212c != null) {
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'checksum' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4208j.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, C1838e> map = this.f4210a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f4211b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f4212c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4208j.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
