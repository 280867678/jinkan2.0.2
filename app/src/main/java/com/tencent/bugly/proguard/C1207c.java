package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.transform.ClassTransform;

/* renamed from: com.tencent.bugly.proguard.c */
/* loaded from: classes3.dex */
public class C1207c {

    /* renamed from: a */
    public HashMap<String, HashMap<String, byte[]>> f1480a = new HashMap<>();

    /* renamed from: b */
    public HashMap<String, Object> f1481b = new HashMap<>();

    /* renamed from: c */
    public HashMap<String, Object> f1482c = new HashMap<>();

    /* renamed from: d */
    public String f1483d = "GBK";

    /* renamed from: e */
    public C1223k f1484e = new C1223k();

    /* renamed from: a */
    private void m3048a(ArrayList<String> arrayList, Object obj) {
        Object obj2;
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals(ClassTransform.BYTE)) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) <= 0) {
                arrayList.add("Array");
                arrayList.add("?");
            }
            arrayList.add("java.util.List");
            obj2 = Array.get(obj, 0);
            m3048a(arrayList, obj2);
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    obj2 = list.get(0);
                    m3048a(arrayList, obj2);
                }
                arrayList.add("?");
            } else if (!(obj instanceof Map)) {
                arrayList.add(obj.getClass().getName());
            } else {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() <= 0) {
                    arrayList.add("?");
                    arrayList.add("?");
                }
                Object next = map.keySet().iterator().next();
                obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
                m3048a(arrayList, obj2);
            }
        }
    }

    /* renamed from: a */
    public void mo3002a(String str) {
        this.f1483d = str;
    }

    /* renamed from: a */
    public <T> void mo2987a(String str, T t) {
        if (str != null) {
            if (t == null) {
                throw new IllegalArgumentException("put value can not is null");
            }
            if (t instanceof Set) {
                throw new IllegalArgumentException("can not support Set");
            }
            C1226l c1226l = new C1226l();
            c1226l.m2903a(this.f1483d);
            c1226l.m2904a(t, 0);
            byte[] m2883a = C1230n.m2883a(c1226l.m2912a());
            HashMap<String, byte[]> hashMap = new HashMap<>(1);
            ArrayList<String> arrayList = new ArrayList<>(1);
            m3048a(arrayList, t);
            hashMap.put(C1202a.m3070a(arrayList), m2883a);
            this.f1482c.remove(str);
            this.f1480a.put(str, hashMap);
            return;
        }
        throw new IllegalArgumentException("put key can not is null");
    }
}
