package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC1558at;
import com.umeng.analytics.pro.AbstractC1570ba;
import com.umeng.analytics.pro.AbstractC1596bs;
import com.umeng.analytics.pro.AbstractC1606ca;
import com.umeng.analytics.pro.AbstractC1607cb;
import com.umeng.analytics.pro.AbstractC1608cc;
import com.umeng.analytics.pro.AbstractC1609cd;
import com.umeng.analytics.pro.C1566az;
import com.umeng.analytics.pro.C1580bf;
import com.umeng.analytics.pro.C1581bg;
import com.umeng.analytics.pro.C1582bh;
import com.umeng.analytics.pro.C1583bi;
import com.umeng.analytics.pro.C1585bk;
import com.umeng.analytics.pro.C1588bm;
import com.umeng.analytics.pro.C1591bn;
import com.umeng.analytics.pro.C1592bo;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.umeng.commonsdk.statistics.proto.c */
/* loaded from: classes4.dex */
public class C1824c implements AbstractC1558at<C1824c, EnumC1830e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1830e, C1580bf> f4184d;

    /* renamed from: e */
    public static final long f4185e = -5764118265293965743L;

    /* renamed from: f */
    public static final C1601bx f4186f = new C1601bx("IdTracking");

    /* renamed from: g */
    public static final C1591bn f4187g = new C1591bn("snapshots", (byte) 13, 1);

    /* renamed from: h */
    public static final C1591bn f4188h = new C1591bn("journals", (byte) 15, 2);

    /* renamed from: i */
    public static final C1591bn f4189i = new C1591bn("checksum", (byte) 11, 3);

    /* renamed from: j */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f4190j;

    /* renamed from: a */
    public Map<String, C1817b> f4191a;

    /* renamed from: b */
    public List<C1810a> f4192b;

    /* renamed from: c */
    public String f4193c;

    /* renamed from: k */
    public EnumC1830e[] f4194k;

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$a */
    /* loaded from: classes4.dex */
    public static class C1826a extends AbstractC1608cc<C1824c> {
        public C1826a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1824c c1824c) throws C1566az {
            abstractC1596bs.mo1127j();
            while (true) {
                C1591bn mo1125l = abstractC1596bs.mo1125l();
                byte b = mo1125l.f3221b;
                if (b == 0) {
                    abstractC1596bs.mo1126k();
                    c1824c.m311n();
                    return;
                }
                short s = mo1125l.f3222c;
                int i = 0;
                if (s == 1) {
                    if (b == 13) {
                        C1593bp mo1123n = abstractC1596bs.mo1123n();
                        c1824c.f4191a = new HashMap(mo1123n.f3227c * 2);
                        while (i < mo1123n.f3227c) {
                            String mo1111z = abstractC1596bs.mo1111z();
                            C1817b c1817b = new C1817b();
                            c1817b.read(abstractC1596bs);
                            c1824c.f4191a.put(mo1111z, c1817b);
                            i++;
                        }
                        abstractC1596bs.mo1122o();
                        c1824c.m326a(true);
                        abstractC1596bs.mo1124m();
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                    abstractC1596bs.mo1124m();
                } else if (s != 2) {
                    if (s == 3 && b == 11) {
                        c1824c.f4193c = abstractC1596bs.mo1111z();
                        c1824c.m322c(true);
                        abstractC1596bs.mo1124m();
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                    abstractC1596bs.mo1124m();
                } else {
                    if (b == 15) {
                        C1592bo mo1121p = abstractC1596bs.mo1121p();
                        c1824c.f4192b = new ArrayList(mo1121p.f3224b);
                        while (i < mo1121p.f3224b) {
                            C1810a c1810a = new C1810a();
                            c1810a.read(abstractC1596bs);
                            c1824c.f4192b.add(c1810a);
                            i++;
                        }
                        abstractC1596bs.mo1120q();
                        c1824c.m324b(true);
                        abstractC1596bs.mo1124m();
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                    abstractC1596bs.mo1124m();
                }
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1824c c1824c) throws C1566az {
            c1824c.m311n();
            abstractC1596bs.mo1140a(C1824c.f4186f);
            if (c1824c.f4191a != null) {
                abstractC1596bs.mo1145a(C1824c.f4187g);
                abstractC1596bs.mo1143a(new C1593bp((byte) 11, (byte) 12, c1824c.f4191a.size()));
                for (Map.Entry<String, C1817b> entry : c1824c.f4191a.entrySet()) {
                    abstractC1596bs.mo1139a(entry.getKey());
                    entry.getValue().write(abstractC1596bs);
                }
                abstractC1596bs.mo1132e();
                abstractC1596bs.mo1134c();
            }
            if (c1824c.f4192b != null && c1824c.m315j()) {
                abstractC1596bs.mo1145a(C1824c.f4188h);
                abstractC1596bs.mo1144a(new C1592bo((byte) 12, c1824c.f4192b.size()));
                for (C1810a c1810a : c1824c.f4192b) {
                    c1810a.write(abstractC1596bs);
                }
                abstractC1596bs.mo1131f();
                abstractC1596bs.mo1134c();
            }
            if (c1824c.f4193c != null && c1824c.m312m()) {
                abstractC1596bs.mo1145a(C1824c.f4189i);
                abstractC1596bs.mo1139a(c1824c.f4193c);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$b */
    /* loaded from: classes4.dex */
    public static class C1827b implements AbstractC1607cb {
        public C1827b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1826a mo230b() {
            return new C1826a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    /* loaded from: classes4.dex */
    public static class C1828c extends AbstractC1609cd<C1824c> {
        public C1828c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1824c c1824c) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1147a(c1824c.f4191a.size());
            for (Map.Entry<String, C1817b> entry : c1824c.f4191a.entrySet()) {
                c1602by.mo1139a(entry.getKey());
                entry.getValue().write(c1602by);
            }
            BitSet bitSet = new BitSet();
            if (c1824c.m315j()) {
                bitSet.set(0);
            }
            if (c1824c.m312m()) {
                bitSet.set(1);
            }
            c1602by.m1104a(bitSet, 2);
            if (c1824c.m315j()) {
                c1602by.mo1147a(c1824c.f4192b.size());
                for (C1810a c1810a : c1824c.f4192b) {
                    c1810a.write(c1602by);
                }
            }
            if (c1824c.m312m()) {
                c1602by.mo1139a(c1824c.f4193c);
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1824c c1824c) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            C1593bp c1593bp = new C1593bp((byte) 11, (byte) 12, c1602by.mo1114w());
            c1824c.f4191a = new HashMap(c1593bp.f3227c * 2);
            for (int i = 0; i < c1593bp.f3227c; i++) {
                String mo1111z = c1602by.mo1111z();
                C1817b c1817b = new C1817b();
                c1817b.read(c1602by);
                c1824c.f4191a.put(mo1111z, c1817b);
            }
            c1824c.m326a(true);
            BitSet m1102b = c1602by.m1102b(2);
            if (m1102b.get(0)) {
                C1592bo c1592bo = new C1592bo((byte) 12, c1602by.mo1114w());
                c1824c.f4192b = new ArrayList(c1592bo.f3224b);
                for (int i2 = 0; i2 < c1592bo.f3224b; i2++) {
                    C1810a c1810a = new C1810a();
                    c1810a.read(c1602by);
                    c1824c.f4192b.add(c1810a);
                }
                c1824c.m324b(true);
            }
            if (m1102b.get(1)) {
                c1824c.f4193c = c1602by.mo1111z();
                c1824c.m322c(true);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$d */
    /* loaded from: classes4.dex */
    public static class C1829d implements AbstractC1607cb {
        public C1829d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1828c mo230b() {
            return new C1828c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$e */
    /* loaded from: classes4.dex */
    public enum EnumC1830e implements AbstractC1570ba {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        public static final Map<String, EnumC1830e> f4198d = new HashMap();

        /* renamed from: e */
        public final short f4200e;

        /* renamed from: f */
        public final String f4201f;

        static {
            Iterator it = EnumSet.allOf(EnumC1830e.class).iterator();
            while (it.hasNext()) {
                EnumC1830e enumC1830e = (EnumC1830e) it.next();
                f4198d.put(enumC1830e.mo226b(), enumC1830e);
            }
        }

        EnumC1830e(short s, String str) {
            this.f4200e = s;
            this.f4201f = str;
        }

        /* renamed from: a */
        public static EnumC1830e m300a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return JOURNALS;
                }
                if (i == 3) {
                    return CHECKSUM;
                }
                return null;
            }
            return SNAPSHOTS;
        }

        /* renamed from: a */
        public static EnumC1830e m299a(String str) {
            return f4198d.get(str);
        }

        /* renamed from: b */
        public static EnumC1830e m298b(int i) {
            EnumC1830e m300a = m300a(i);
            if (m300a != null) {
                return m300a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f4200e;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f4201f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4190j = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1827b());
        f4190j.put(AbstractC1609cd.class, new C1829d());
        EnumMap enumMap = new EnumMap(EnumC1830e.class);
        enumMap.put((EnumMap) EnumC1830e.SNAPSHOTS, (EnumC1830e) new C1580bf("snapshots", (byte) 1, new C1583bi((byte) 13, new C1581bg((byte) 11), new C1585bk((byte) 12, C1817b.class))));
        enumMap.put((EnumMap) EnumC1830e.JOURNALS, (EnumC1830e) new C1580bf("journals", (byte) 2, new C1582bh((byte) 15, new C1585bk((byte) 12, C1810a.class))));
        enumMap.put((EnumMap) EnumC1830e.CHECKSUM, (EnumC1830e) new C1580bf("checksum", (byte) 2, new C1581bg((byte) 11)));
        Map<EnumC1830e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f4184d = unmodifiableMap;
        C1580bf.m1185a(C1824c.class, unmodifiableMap);
    }

    public C1824c() {
        this.f4194k = new EnumC1830e[]{EnumC1830e.JOURNALS, EnumC1830e.CHECKSUM};
    }

    public C1824c(C1824c c1824c) {
        this.f4194k = new EnumC1830e[]{EnumC1830e.JOURNALS, EnumC1830e.CHECKSUM};
        if (c1824c.m320e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, C1817b> entry : c1824c.f4191a.entrySet()) {
                hashMap.put(entry.getKey(), new C1817b(entry.getValue()));
            }
            this.f4191a = hashMap;
        }
        if (c1824c.m315j()) {
            ArrayList arrayList = new ArrayList();
            for (C1810a c1810a : c1824c.f4192b) {
                arrayList.add(new C1810a(c1810a));
            }
            this.f4192b = arrayList;
        }
        if (c1824c.m312m()) {
            this.f4193c = c1824c.f4193c;
        }
    }

    public C1824c(Map<String, C1817b> map) {
        this();
        this.f4191a = map;
    }

    /* renamed from: a */
    private void m332a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m331a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public EnumC1830e fieldForId(int i) {
        return EnumC1830e.m300a(i);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public C1824c deepCopy() {
        return new C1824c(this);
    }

    /* renamed from: a */
    public C1824c m330a(String str) {
        this.f4193c = str;
        return this;
    }

    /* renamed from: a */
    public C1824c m328a(List<C1810a> list) {
        this.f4192b = list;
        return this;
    }

    /* renamed from: a */
    public C1824c m327a(Map<String, C1817b> map) {
        this.f4191a = map;
        return this;
    }

    /* renamed from: a */
    public void m333a(C1810a c1810a) {
        if (this.f4192b == null) {
            this.f4192b = new ArrayList();
        }
        this.f4192b.add(c1810a);
    }

    /* renamed from: a */
    public void m329a(String str, C1817b c1817b) {
        if (this.f4191a == null) {
            this.f4191a = new HashMap();
        }
        this.f4191a.put(str, c1817b);
    }

    /* renamed from: a */
    public void m326a(boolean z) {
        if (!z) {
            this.f4191a = null;
        }
    }

    /* renamed from: b */
    public int m325b() {
        Map<String, C1817b> map = this.f4191a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    /* renamed from: b */
    public void m324b(boolean z) {
        if (!z) {
            this.f4192b = null;
        }
    }

    /* renamed from: c */
    public Map<String, C1817b> m323c() {
        return this.f4191a;
    }

    /* renamed from: c */
    public void m322c(boolean z) {
        if (!z) {
            this.f4193c = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        this.f4191a = null;
        this.f4192b = null;
        this.f4193c = null;
    }

    /* renamed from: d */
    public void m321d() {
        this.f4191a = null;
    }

    /* renamed from: e */
    public boolean m320e() {
        return this.f4191a != null;
    }

    /* renamed from: f */
    public int m319f() {
        List<C1810a> list = this.f4192b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: g */
    public Iterator<C1810a> m318g() {
        List<C1810a> list = this.f4192b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    /* renamed from: h */
    public List<C1810a> m317h() {
        return this.f4192b;
    }

    /* renamed from: i */
    public void m316i() {
        this.f4192b = null;
    }

    /* renamed from: j */
    public boolean m315j() {
        return this.f4192b != null;
    }

    /* renamed from: k */
    public String m314k() {
        return this.f4193c;
    }

    /* renamed from: l */
    public void m313l() {
        this.f4193c = null;
    }

    /* renamed from: m */
    public boolean m312m() {
        return this.f4193c != null;
    }

    /* renamed from: n */
    public void m311n() throws C1566az {
        if (this.f4191a != null) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'snapshots' was not present! Struct: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
        throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4190j.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, C1817b> map = this.f4191a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (m315j()) {
            sb.append(", ");
            sb.append("journals:");
            List<C1810a> list = this.f4192b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m312m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f4193c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f4190j.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
