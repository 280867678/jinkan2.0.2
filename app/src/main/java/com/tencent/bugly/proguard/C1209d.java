package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: classes3.dex */
public class C1209d extends C1207c {

    /* renamed from: f */
    public HashMap<String, byte[]> f1486f = null;

    /* renamed from: g */
    public HashMap<String, Object> f1487g = new HashMap<>();

    /* renamed from: h */
    public C1223k f1488h = new C1223k();

    /* renamed from: a */
    private Object m3001a(byte[] bArr, Object obj) {
        this.f1488h.m2925a(bArr);
        this.f1488h.m2931a(this.f1483d);
        return this.f1488h.m2932a((C1223k) obj, 0, true);
    }

    /* renamed from: c */
    private void m2999c(String str, Object obj) {
        this.f1487g.put(str, obj);
    }

    /* renamed from: a */
    public void mo2991a() {
        this.f1486f = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C1207c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo3002a(String str) {
        super.mo3002a(str);
    }

    @Override // com.tencent.bugly.proguard.C1207c
    /* renamed from: a */
    public <T> void mo2987a(String str, T t) {
        if (this.f1486f == null) {
            super.mo2987a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t == null) {
                throw new IllegalArgumentException("put value can not is null");
            }
            if (t instanceof Set) {
                throw new IllegalArgumentException("can not support Set");
            }
            C1226l c1226l = new C1226l();
            c1226l.m2903a(this.f1483d);
            c1226l.m2904a(t, 0);
            this.f1486f.put(str, C1230n.m2883a(c1226l.m2912a()));
        }
    }

    /* renamed from: b */
    public <T> T m3000b(String str, T t) throws C1204b {
        HashMap<String, byte[]> hashMap = this.f1486f;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (!this.f1487g.containsKey(str)) {
                try {
                    T t2 = (T) m3001a(this.f1486f.get(str), t);
                    if (t2 != null) {
                        m2999c(str, t2);
                    }
                    return t2;
                } catch (Exception e) {
                    throw new C1204b(e);
                }
            }
        } else if (!this.f1480a.containsKey(str)) {
            return null;
        } else {
            if (!this.f1487g.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator<Map.Entry<String, byte[]>> it = this.f1480a.get(str).entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<String, byte[]> next = it.next();
                    next.getKey();
                    bArr = next.getValue();
                }
                try {
                    this.f1488h.m2925a(bArr);
                    this.f1488h.m2931a(this.f1483d);
                    T t3 = (T) this.f1488h.m2932a((C1223k) t, 0, true);
                    m2999c(str, t3);
                    return t3;
                } catch (Exception e2) {
                    throw new C1204b(e2);
                }
            }
        }
        return (T) this.f1487g.get(str);
    }
}
