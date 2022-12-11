package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.outline;
import org.litepal.parser.LitePalParser;
import org.simpleframework.xml.strategy.Name;

/* renamed from: com.umeng.analytics.pro.al */
/* loaded from: classes4.dex */
public class C1544al implements AbstractC1558at<C1544al, EnumC1550e>, Serializable, Cloneable {

    /* renamed from: A */
    public static final int f3056A = 2;

    /* renamed from: B */
    public static final int f3057B = 3;

    /* renamed from: k */
    public static final Map<EnumC1550e, C1580bf> f3058k;

    /* renamed from: l */
    public static final long f3059l = 420342210744516016L;

    /* renamed from: m */
    public static final C1601bx f3060m = new C1601bx("UMEnvelope");

    /* renamed from: n */
    public static final C1591bn f3061n = new C1591bn(LitePalParser.NODE_VERSION, (byte) 11, 1);

    /* renamed from: o */
    public static final C1591bn f3062o = new C1591bn("address", (byte) 11, 2);

    /* renamed from: p */
    public static final C1591bn f3063p = new C1591bn("signature", (byte) 11, 3);

    /* renamed from: q */
    public static final C1591bn f3064q = new C1591bn("serial_num", (byte) 8, 4);

    /* renamed from: r */
    public static final C1591bn f3065r = new C1591bn("ts_secs", (byte) 8, 5);

    /* renamed from: s */
    public static final C1591bn f3066s = new C1591bn(Name.LENGTH, (byte) 8, 6);

    /* renamed from: t */
    public static final C1591bn f3067t = new C1591bn("entity", (byte) 11, 7);

    /* renamed from: u */
    public static final C1591bn f3068u = new C1591bn("guid", (byte) 11, 8);

    /* renamed from: v */
    public static final C1591bn f3069v = new C1591bn("checksum", (byte) 11, 9);

    /* renamed from: w */
    public static final C1591bn f3070w = new C1591bn("codex", (byte) 8, 10);

    /* renamed from: x */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f3071x;

    /* renamed from: y */
    public static final int f3072y = 0;

    /* renamed from: z */
    public static final int f3073z = 1;

    /* renamed from: C */
    public byte f3074C;

    /* renamed from: D */
    public EnumC1550e[] f3075D;

    /* renamed from: a */
    public String f3076a;

    /* renamed from: b */
    public String f3077b;

    /* renamed from: c */
    public String f3078c;

    /* renamed from: d */
    public int f3079d;

    /* renamed from: e */
    public int f3080e;

    /* renamed from: f */
    public int f3081f;

    /* renamed from: g */
    public ByteBuffer f3082g;

    /* renamed from: h */
    public String f3083h;

    /* renamed from: i */
    public String f3084i;

    /* renamed from: j */
    public int f3085j;

    /* renamed from: com.umeng.analytics.pro.al$a */
    /* loaded from: classes4.dex */
    public static class C1546a extends AbstractC1608cc<C1544al> {
        public C1546a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1544al c1544al) throws C1566az {
            abstractC1596bs.mo1127j();
            while (true) {
                C1591bn mo1125l = abstractC1596bs.mo1125l();
                byte b = mo1125l.f3221b;
                if (b == 0) {
                    abstractC1596bs.mo1126k();
                    if (!c1544al.m1320m()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'serial_num' was not found in serialized data! Struct: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
                        throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    } else if (!c1544al.m1317p()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'ts_secs' was not found in serialized data! Struct: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toString());
                        throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    } else if (c1544al.m1314s()) {
                        c1544al.m1368G();
                        return;
                    } else {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'length' was not found in serialized data! Struct: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(toString());
                        throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    }
                }
                switch (mo1125l.f3222c) {
                    case 1:
                        if (b == 11) {
                            c1544al.f3076a = abstractC1596bs.mo1111z();
                            c1544al.m1350a(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 2:
                        if (b == 11) {
                            c1544al.f3077b = abstractC1596bs.mo1111z();
                            c1544al.m1345b(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 3:
                        if (b == 11) {
                            c1544al.f3078c = abstractC1596bs.mo1111z();
                            c1544al.m1341c(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 4:
                        if (b == 8) {
                            c1544al.f3079d = abstractC1596bs.mo1114w();
                            c1544al.m1337d(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 5:
                        if (b == 8) {
                            c1544al.f3080e = abstractC1596bs.mo1114w();
                            c1544al.m1333e(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 6:
                        if (b == 8) {
                            c1544al.f3081f = abstractC1596bs.mo1114w();
                            c1544al.m1331f(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 7:
                        if (b == 11) {
                            c1544al.f3082g = abstractC1596bs.mo1153A();
                            c1544al.m1329g(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 8:
                        if (b == 11) {
                            c1544al.f3083h = abstractC1596bs.mo1111z();
                            c1544al.m1327h(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 9:
                        if (b == 11) {
                            c1544al.f3084i = abstractC1596bs.mo1111z();
                            c1544al.m1325i(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                    case 10:
                        if (b == 8) {
                            c1544al.f3085j = abstractC1596bs.mo1114w();
                            c1544al.m1323j(true);
                            continue;
                            abstractC1596bs.mo1124m();
                        }
                        break;
                }
                C1599bv.m1108a(abstractC1596bs, b);
                abstractC1596bs.mo1124m();
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1544al c1544al) throws C1566az {
            c1544al.m1368G();
            abstractC1596bs.mo1140a(C1544al.f3060m);
            if (c1544al.f3076a != null) {
                abstractC1596bs.mo1145a(C1544al.f3061n);
                abstractC1596bs.mo1139a(c1544al.f3076a);
                abstractC1596bs.mo1134c();
            }
            if (c1544al.f3077b != null) {
                abstractC1596bs.mo1145a(C1544al.f3062o);
                abstractC1596bs.mo1139a(c1544al.f3077b);
                abstractC1596bs.mo1134c();
            }
            if (c1544al.f3078c != null) {
                abstractC1596bs.mo1145a(C1544al.f3063p);
                abstractC1596bs.mo1139a(c1544al.f3078c);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1145a(C1544al.f3064q);
            abstractC1596bs.mo1147a(c1544al.f3079d);
            abstractC1596bs.mo1134c();
            abstractC1596bs.mo1145a(C1544al.f3065r);
            abstractC1596bs.mo1147a(c1544al.f3080e);
            abstractC1596bs.mo1134c();
            abstractC1596bs.mo1145a(C1544al.f3066s);
            abstractC1596bs.mo1147a(c1544al.f3081f);
            abstractC1596bs.mo1134c();
            if (c1544al.f3082g != null) {
                abstractC1596bs.mo1145a(C1544al.f3067t);
                abstractC1596bs.mo1138a(c1544al.f3082g);
                abstractC1596bs.mo1134c();
            }
            if (c1544al.f3083h != null) {
                abstractC1596bs.mo1145a(C1544al.f3068u);
                abstractC1596bs.mo1139a(c1544al.f3083h);
                abstractC1596bs.mo1134c();
            }
            if (c1544al.f3084i != null) {
                abstractC1596bs.mo1145a(C1544al.f3069v);
                abstractC1596bs.mo1139a(c1544al.f3084i);
                abstractC1596bs.mo1134c();
            }
            if (c1544al.m1369F()) {
                abstractC1596bs.mo1145a(C1544al.f3070w);
                abstractC1596bs.mo1147a(c1544al.f3085j);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.analytics.pro.al$b */
    /* loaded from: classes4.dex */
    public static class C1547b implements AbstractC1607cb {
        public C1547b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1546a mo230b() {
            return new C1546a();
        }
    }

    /* renamed from: com.umeng.analytics.pro.al$c */
    /* loaded from: classes4.dex */
    public static class C1548c extends AbstractC1609cd<C1544al> {
        public C1548c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, C1544al c1544al) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1139a(c1544al.f3076a);
            c1602by.mo1139a(c1544al.f3077b);
            c1602by.mo1139a(c1544al.f3078c);
            c1602by.mo1147a(c1544al.f3079d);
            c1602by.mo1147a(c1544al.f3080e);
            c1602by.mo1147a(c1544al.f3081f);
            c1602by.mo1138a(c1544al.f3082g);
            c1602by.mo1139a(c1544al.f3083h);
            c1602by.mo1139a(c1544al.f3084i);
            BitSet bitSet = new BitSet();
            if (c1544al.m1369F()) {
                bitSet.set(0);
            }
            c1602by.m1104a(bitSet, 1);
            if (c1544al.m1369F()) {
                c1602by.mo1147a(c1544al.f3085j);
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, C1544al c1544al) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1544al.f3076a = c1602by.mo1111z();
            c1544al.m1350a(true);
            c1544al.f3077b = c1602by.mo1111z();
            c1544al.m1345b(true);
            c1544al.f3078c = c1602by.mo1111z();
            c1544al.m1341c(true);
            c1544al.f3079d = c1602by.mo1114w();
            c1544al.m1337d(true);
            c1544al.f3080e = c1602by.mo1114w();
            c1544al.m1333e(true);
            c1544al.f3081f = c1602by.mo1114w();
            c1544al.m1331f(true);
            c1544al.f3082g = c1602by.mo1153A();
            c1544al.m1329g(true);
            c1544al.f3083h = c1602by.mo1111z();
            c1544al.m1327h(true);
            c1544al.f3084i = c1602by.mo1111z();
            c1544al.m1325i(true);
            if (c1602by.m1102b(1).get(0)) {
                c1544al.f3085j = c1602by.mo1114w();
                c1544al.m1323j(true);
            }
        }
    }

    /* renamed from: com.umeng.analytics.pro.al$d */
    /* loaded from: classes4.dex */
    public static class C1549d implements AbstractC1607cb {
        public C1549d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1548c mo230b() {
            return new C1548c();
        }
    }

    /* renamed from: com.umeng.analytics.pro.al$e */
    /* loaded from: classes4.dex */
    public enum EnumC1550e implements AbstractC1570ba {
        VERSION(1, LitePalParser.NODE_VERSION),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, Name.LENGTH),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: k */
        public static final Map<String, EnumC1550e> f3096k = new HashMap();

        /* renamed from: l */
        public final short f3098l;

        /* renamed from: m */
        public final String f3099m;

        static {
            Iterator it = EnumSet.allOf(EnumC1550e.class).iterator();
            while (it.hasNext()) {
                EnumC1550e enumC1550e = (EnumC1550e) it.next();
                f3096k.put(enumC1550e.mo226b(), enumC1550e);
            }
        }

        EnumC1550e(short s, String str) {
            this.f3098l = s;
            this.f3099m = str;
        }

        /* renamed from: a */
        public static EnumC1550e m1300a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public static EnumC1550e m1299a(String str) {
            return f3096k.get(str);
        }

        /* renamed from: b */
        public static EnumC1550e m1298b(int i) {
            EnumC1550e m1300a = m1300a(i);
            if (m1300a != null) {
                return m1300a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f3098l;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f3099m;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3071x = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1547b());
        f3071x.put(AbstractC1609cd.class, new C1549d());
        EnumMap enumMap = new EnumMap(EnumC1550e.class);
        enumMap.put((EnumMap) EnumC1550e.VERSION, (EnumC1550e) new C1580bf(LitePalParser.NODE_VERSION, (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1550e.ADDRESS, (EnumC1550e) new C1580bf("address", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1550e.SIGNATURE, (EnumC1550e) new C1580bf("signature", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1550e.SERIAL_NUM, (EnumC1550e) new C1580bf("serial_num", (byte) 1, new C1581bg((byte) 8)));
        enumMap.put((EnumMap) EnumC1550e.TS_SECS, (EnumC1550e) new C1580bf("ts_secs", (byte) 1, new C1581bg((byte) 8)));
        enumMap.put((EnumMap) EnumC1550e.LENGTH, (EnumC1550e) new C1580bf(Name.LENGTH, (byte) 1, new C1581bg((byte) 8)));
        enumMap.put((EnumMap) EnumC1550e.ENTITY, (EnumC1550e) new C1580bf("entity", (byte) 1, new C1581bg((byte) 11, true)));
        enumMap.put((EnumMap) EnumC1550e.GUID, (EnumC1550e) new C1580bf("guid", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1550e.CHECKSUM, (EnumC1550e) new C1580bf("checksum", (byte) 1, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1550e.CODEX, (EnumC1550e) new C1580bf("codex", (byte) 2, new C1581bg((byte) 8)));
        Map<EnumC1550e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f3058k = unmodifiableMap;
        C1580bf.m1185a(C1544al.class, unmodifiableMap);
    }

    public C1544al() {
        this.f3074C = (byte) 0;
        this.f3075D = new EnumC1550e[]{EnumC1550e.CODEX};
    }

    public C1544al(C1544al c1544al) {
        this.f3074C = (byte) 0;
        this.f3075D = new EnumC1550e[]{EnumC1550e.CODEX};
        this.f3074C = c1544al.f3074C;
        if (c1544al.m1340d()) {
            this.f3076a = c1544al.f3076a;
        }
        if (c1544al.m1330g()) {
            this.f3077b = c1544al.f3077b;
        }
        if (c1544al.m1324j()) {
            this.f3078c = c1544al.f3078c;
        }
        this.f3079d = c1544al.f3079d;
        this.f3080e = c1544al.f3080e;
        this.f3081f = c1544al.f3081f;
        if (c1544al.m1310w()) {
            this.f3082g = C1559au.m1240d(c1544al.f3082g);
        }
        if (c1544al.m1307z()) {
            this.f3083h = c1544al.f3083h;
        }
        if (c1544al.m1372C()) {
            this.f3084i = c1544al.f3084i;
        }
        this.f3085j = c1544al.f3085j;
    }

    public C1544al(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f3076a = str;
        this.f3077b = str2;
        this.f3078c = str3;
        this.f3079d = i;
        m1337d(true);
        this.f3080e = i2;
        m1333e(true);
        this.f3081f = i3;
        m1331f(true);
        this.f3082g = byteBuffer;
        this.f3083h = str4;
        this.f3084i = str5;
    }

    /* renamed from: a */
    private void m1354a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3074C = (byte) 0;
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m1353a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: A */
    public String m1374A() {
        return this.f3084i;
    }

    /* renamed from: B */
    public void m1373B() {
        this.f3084i = null;
    }

    /* renamed from: C */
    public boolean m1372C() {
        return this.f3084i != null;
    }

    /* renamed from: D */
    public int m1371D() {
        return this.f3085j;
    }

    /* renamed from: E */
    public void m1370E() {
        this.f3074C = C1555aq.m1272b(this.f3074C, 3);
    }

    /* renamed from: F */
    public boolean m1369F() {
        return C1555aq.m1284a(this.f3074C, 3);
    }

    /* renamed from: G */
    public void m1368G() throws C1566az {
        if (this.f3076a == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'version' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (this.f3077b == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'address' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        } else if (this.f3078c == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'signature' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        } else if (this.f3082g == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'entity' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        } else if (this.f3083h == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'guid' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
        } else if (this.f3084i != null) {
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'checksum' was not present! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: a */
    public C1544al deepCopy() {
        return new C1544al(this);
    }

    /* renamed from: a */
    public C1544al m1355a(int i) {
        this.f3079d = i;
        m1337d(true);
        return this;
    }

    /* renamed from: a */
    public C1544al m1352a(String str) {
        this.f3076a = str;
        return this;
    }

    /* renamed from: a */
    public C1544al m1351a(ByteBuffer byteBuffer) {
        this.f3082g = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public C1544al m1349a(byte[] bArr) {
        m1351a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public void m1350a(boolean z) {
        if (!z) {
            this.f3076a = null;
        }
    }

    /* renamed from: b */
    public C1544al m1347b(int i) {
        this.f3080e = i;
        m1333e(true);
        return this;
    }

    /* renamed from: b */
    public C1544al m1346b(String str) {
        this.f3077b = str;
        return this;
    }

    /* renamed from: b */
    public String m1348b() {
        return this.f3076a;
    }

    /* renamed from: b */
    public void m1345b(boolean z) {
        if (!z) {
            this.f3077b = null;
        }
    }

    /* renamed from: c */
    public C1544al m1343c(int i) {
        this.f3081f = i;
        m1331f(true);
        return this;
    }

    /* renamed from: c */
    public C1544al m1342c(String str) {
        this.f3078c = str;
        return this;
    }

    /* renamed from: c */
    public void m1344c() {
        this.f3076a = null;
    }

    /* renamed from: c */
    public void m1341c(boolean z) {
        if (!z) {
            this.f3078c = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        this.f3076a = null;
        this.f3077b = null;
        this.f3078c = null;
        m1337d(false);
        this.f3079d = 0;
        m1333e(false);
        this.f3080e = 0;
        m1331f(false);
        this.f3081f = 0;
        this.f3082g = null;
        this.f3083h = null;
        this.f3084i = null;
        m1323j(false);
        this.f3085j = 0;
    }

    /* renamed from: d */
    public C1544al m1339d(int i) {
        this.f3085j = i;
        m1323j(true);
        return this;
    }

    /* renamed from: d */
    public C1544al m1338d(String str) {
        this.f3083h = str;
        return this;
    }

    /* renamed from: d */
    public void m1337d(boolean z) {
        this.f3074C = C1555aq.m1283a(this.f3074C, 0, z);
    }

    /* renamed from: d */
    public boolean m1340d() {
        return this.f3076a != null;
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    /* renamed from: e */
    public EnumC1550e fieldForId(int i) {
        return EnumC1550e.m1300a(i);
    }

    /* renamed from: e */
    public C1544al m1334e(String str) {
        this.f3084i = str;
        return this;
    }

    /* renamed from: e */
    public String m1336e() {
        return this.f3077b;
    }

    /* renamed from: e */
    public void m1333e(boolean z) {
        this.f3074C = C1555aq.m1283a(this.f3074C, 1, z);
    }

    /* renamed from: f */
    public void m1332f() {
        this.f3077b = null;
    }

    /* renamed from: f */
    public void m1331f(boolean z) {
        this.f3074C = C1555aq.m1283a(this.f3074C, 2, z);
    }

    /* renamed from: g */
    public void m1329g(boolean z) {
        if (!z) {
            this.f3082g = null;
        }
    }

    /* renamed from: g */
    public boolean m1330g() {
        return this.f3077b != null;
    }

    /* renamed from: h */
    public String m1328h() {
        return this.f3078c;
    }

    /* renamed from: h */
    public void m1327h(boolean z) {
        if (!z) {
            this.f3083h = null;
        }
    }

    /* renamed from: i */
    public void m1326i() {
        this.f3078c = null;
    }

    /* renamed from: i */
    public void m1325i(boolean z) {
        if (!z) {
            this.f3084i = null;
        }
    }

    /* renamed from: j */
    public void m1323j(boolean z) {
        this.f3074C = C1555aq.m1283a(this.f3074C, 3, z);
    }

    /* renamed from: j */
    public boolean m1324j() {
        return this.f3078c != null;
    }

    /* renamed from: k */
    public int m1322k() {
        return this.f3079d;
    }

    /* renamed from: l */
    public void m1321l() {
        this.f3074C = C1555aq.m1272b(this.f3074C, 0);
    }

    /* renamed from: m */
    public boolean m1320m() {
        return C1555aq.m1284a(this.f3074C, 0);
    }

    /* renamed from: n */
    public int m1319n() {
        return this.f3080e;
    }

    /* renamed from: o */
    public void m1318o() {
        this.f3074C = C1555aq.m1272b(this.f3074C, 1);
    }

    /* renamed from: p */
    public boolean m1317p() {
        return C1555aq.m1284a(this.f3074C, 1);
    }

    /* renamed from: q */
    public int m1316q() {
        return this.f3081f;
    }

    /* renamed from: r */
    public void m1315r() {
        this.f3074C = C1555aq.m1272b(this.f3074C, 2);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f3071x.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    /* renamed from: s */
    public boolean m1314s() {
        return C1555aq.m1284a(this.f3074C, 2);
    }

    /* renamed from: t */
    public byte[] m1313t() {
        m1351a(C1559au.m1241c(this.f3082g));
        ByteBuffer byteBuffer = this.f3082g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f3076a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f3077b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f3078c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f3079d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f3080e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f3081f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f3082g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            C1559au.m1251a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f3083h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f3084i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (m1369F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f3085j);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public ByteBuffer m1312u() {
        return this.f3082g;
    }

    /* renamed from: v */
    public void m1311v() {
        this.f3082g = null;
    }

    /* renamed from: w */
    public boolean m1310w() {
        return this.f3082g != null;
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f3071x.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }

    /* renamed from: x */
    public String m1309x() {
        return this.f3083h;
    }

    /* renamed from: y */
    public void m1308y() {
        this.f3083h = null;
    }

    /* renamed from: z */
    public boolean m1307z() {
        return this.f3083h != null;
    }
}
