package com.umeng.analytics.pro;

import com.umeng.analytics.pro.AbstractC1570ba;
import com.umeng.analytics.pro.AbstractC1573bd;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.umeng.analytics.pro.bd */
/* loaded from: classes4.dex */
public abstract class AbstractC1573bd<T extends AbstractC1573bd<?, ?>, F extends AbstractC1570ba> implements AbstractC1558at<T, F> {

    /* renamed from: c */
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> f3155c;

    /* renamed from: a */
    public Object f3156a;

    /* renamed from: b */
    public F f3157b;

    /* renamed from: com.umeng.analytics.pro.bd$a */
    /* loaded from: classes4.dex */
    public static class C1575a extends AbstractC1608cc<AbstractC1573bd> {
        public C1575a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, AbstractC1573bd abstractC1573bd) throws C1566az {
            abstractC1573bd.f3157b = null;
            abstractC1573bd.f3156a = null;
            abstractC1596bs.mo1127j();
            C1591bn mo1125l = abstractC1596bs.mo1125l();
            Object m1207a = abstractC1573bd.m1207a(abstractC1596bs, mo1125l);
            abstractC1573bd.f3156a = m1207a;
            if (m1207a != null) {
                abstractC1573bd.f3157b = (F) abstractC1573bd.m1201a(mo1125l.f3222c);
            }
            abstractC1596bs.mo1124m();
            abstractC1596bs.mo1125l();
            abstractC1596bs.mo1126k();
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, AbstractC1573bd abstractC1573bd) throws C1566az {
            if (abstractC1573bd.m1213a() == null || abstractC1573bd.m1200b() == null) {
                throw new C1597bt("Cannot write a TUnion with no set value!");
            }
            abstractC1596bs.mo1140a(abstractC1573bd.m1193d());
            abstractC1596bs.mo1145a(abstractC1573bd.m1194c(abstractC1573bd.f3157b));
            abstractC1573bd.m1208a(abstractC1596bs);
            abstractC1596bs.mo1134c();
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.analytics.pro.bd$b */
    /* loaded from: classes4.dex */
    public static class C1576b implements AbstractC1607cb {
        public C1576b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1575a mo230b() {
            return new C1575a();
        }
    }

    /* renamed from: com.umeng.analytics.pro.bd$c */
    /* loaded from: classes4.dex */
    public static class C1577c extends AbstractC1609cd<AbstractC1573bd> {
        public C1577c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, AbstractC1573bd abstractC1573bd) throws C1566az {
            abstractC1573bd.f3157b = null;
            abstractC1573bd.f3156a = null;
            short mo1115v = abstractC1596bs.mo1115v();
            Object m1206a = abstractC1573bd.m1206a(abstractC1596bs, mo1115v);
            abstractC1573bd.f3156a = m1206a;
            if (m1206a != null) {
                abstractC1573bd.f3157b = (F) abstractC1573bd.m1201a(mo1115v);
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, AbstractC1573bd abstractC1573bd) throws C1566az {
            if (abstractC1573bd.m1213a() == null || abstractC1573bd.m1200b() == null) {
                throw new C1597bt("Cannot write a TUnion with no set value!");
            }
            abstractC1596bs.mo1137a(abstractC1573bd.f3157b.mo229a());
            abstractC1573bd.m1196b(abstractC1596bs);
        }
    }

    /* renamed from: com.umeng.analytics.pro.bd$d */
    /* loaded from: classes4.dex */
    public static class C1578d implements AbstractC1607cb {
        public C1578d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1577c mo230b() {
            return new C1577c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3155c = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1576b());
        f3155c.put(AbstractC1609cd.class, new C1578d());
    }

    public AbstractC1573bd() {
        this.f3157b = null;
        this.f3156a = null;
    }

    public AbstractC1573bd(F f, Object obj) {
        m1209a((AbstractC1573bd<T, F>) f, obj);
    }

    public AbstractC1573bd(AbstractC1573bd<T, F> abstractC1573bd) {
        if (abstractC1573bd.getClass().equals(AbstractC1573bd.class)) {
            this.f3157b = abstractC1573bd.f3157b;
            this.f3156a = m1205a(abstractC1573bd.f3156a);
            return;
        }
        throw new ClassCastException();
    }

    /* renamed from: a */
    public static Object m1205a(Object obj) {
        return obj instanceof AbstractC1558at ? ((AbstractC1558at) obj).deepCopy() : obj instanceof ByteBuffer ? C1559au.m1240d((ByteBuffer) obj) : obj instanceof List ? m1204a((List) obj) : obj instanceof Set ? m1202a((Set) obj) : obj instanceof Map ? m1203a((Map<Object, Object>) obj) : obj;
    }

    /* renamed from: a */
    public static List m1204a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(m1205a(obj));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map m1203a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(m1205a(entry.getKey()), m1205a(entry.getValue()));
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Set m1202a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(m1205a(obj));
        }
        return hashSet;
    }

    /* renamed from: a */
    public F m1213a() {
        return this.f3157b;
    }

    /* renamed from: a */
    public abstract F m1201a(short s);

    /* renamed from: a */
    public Object m1212a(int i) {
        return m1210a((AbstractC1573bd<T, F>) m1201a((short) i));
    }

    /* renamed from: a */
    public Object m1210a(F f) {
        if (f == this.f3157b) {
            return m1200b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.f3157b);
    }

    /* renamed from: a */
    public abstract Object m1207a(AbstractC1596bs abstractC1596bs, C1591bn c1591bn) throws C1566az;

    /* renamed from: a */
    public abstract Object m1206a(AbstractC1596bs abstractC1596bs, short s) throws C1566az;

    /* renamed from: a */
    public void m1211a(int i, Object obj) {
        m1209a((AbstractC1573bd<T, F>) m1201a((short) i), obj);
    }

    /* renamed from: a */
    public void m1209a(F f, Object obj) {
        m1197b(f, obj);
        this.f3157b = f;
        this.f3156a = obj;
    }

    /* renamed from: a */
    public abstract void m1208a(AbstractC1596bs abstractC1596bs) throws C1566az;

    /* renamed from: b */
    public Object m1200b() {
        return this.f3156a;
    }

    /* renamed from: b */
    public abstract void m1197b(F f, Object obj) throws ClassCastException;

    /* renamed from: b */
    public abstract void m1196b(AbstractC1596bs abstractC1596bs) throws C1566az;

    /* renamed from: b */
    public boolean m1199b(int i) {
        return m1198b((AbstractC1573bd<T, F>) m1201a((short) i));
    }

    /* renamed from: b */
    public boolean m1198b(F f) {
        return this.f3157b == f;
    }

    /* renamed from: c */
    public abstract C1591bn m1194c(F f);

    /* renamed from: c */
    public boolean m1195c() {
        return this.f3157b != null;
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public final void clear() {
        this.f3157b = null;
        this.f3156a = null;
    }

    /* renamed from: d */
    public abstract C1601bx m1193d();

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        f3155c.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(AbstractC1573bd.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
        if (m1213a() != null) {
            Object m1200b = m1200b();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m1194c(m1213a()).f3220a);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
            if (m1200b instanceof ByteBuffer) {
                C1559au.m1251a((ByteBuffer) m1200b, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m1200b.toString());
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(">");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        f3155c.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
