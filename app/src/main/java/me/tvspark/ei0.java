package me.tvspark;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes4.dex */
public final class ei0 implements ij0<Object>, di0 {
    public static final HashMap<String, String> Wwwwwwwwwwwwwwwwwwww;
    public static final HashMap<String, String> Wwwwwwwwwwwwwwwwwwwww;
    public static final HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwww;
    public static final Map<Class<? extends cf0<?>>, Integer> Wwwwwwwwwwwwwwwwwwwwwww;
    public final Class<?> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Map<Class<? extends cf0<?>>, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class[] clsArr = {xg0.class, ih0.class, mh0.class, nh0.class, oh0.class, ph0.class, qh0.class, rh0.class, sh0.class, th0.class, yg0.class, zg0.class, ah0.class, bh0.class, ch0.class, dh0.class, eh0.class, fh0.class, gh0.class, hh0.class, jh0.class, kh0.class, lh0.class};
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clsArr, "elements");
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) clsArr);
        ArrayList arrayList = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 10));
        int i = 0;
        for (Object obj : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i2 = i + 1;
            if (i < 0) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else {
                arrayList.add(new Pair((Class) obj, Integer.valueOf(i)));
                i = i2;
            }
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, "$this$toMap");
        int size = arrayList.size();
        if (size == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (size != 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashMap<>(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.size()));
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            Pair pair = (Pair) arrayList.get(0);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair, "pair");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.singletonMap(pair.getFirst(), pair.getSecond());
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "java.util.Collections.si…(pair.first, pair.second)");
        }
        Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ClassTransform.BOOLEAN, "kotlin.Boolean");
        hashMap.put(ClassTransform.CHARACTER, "kotlin.Char");
        hashMap.put(ClassTransform.BYTE, "kotlin.Byte");
        hashMap.put(ClassTransform.SHORT, "kotlin.Short");
        hashMap.put(ClassTransform.INTEGER, "kotlin.Int");
        hashMap.put(ClassTransform.FLOAT, "kotlin.Float");
        hashMap.put(ClassTransform.LONG, "kotlin.Long");
        hashMap.put(ClassTransform.DOUBLE, "kotlin.Double");
        Wwwwwwwwwwwwwwwwwwwwww = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        Wwwwwwwwwwwwwwwwwwwww = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(Wwwwwwwwwwwwwwwwwwwwww);
        hashMap3.putAll(Wwwwwwwwwwwwwwwwwwwww);
        Collection<String> values = Wwwwwwwwwwwwwwwwwwwwww.values();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "kotlinName");
            sb.append(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, '.', (String) null, 2));
            sb.append("CompanionObject");
            Pair pair2 = new Pair(sb.toString(), outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".Companion"));
            hashMap3.put(pair2.getFirst(), pair2.getSecond());
        }
        for (Map.Entry<Class<? extends cf0<?>>, Integer> entry : Wwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        Wwwwwwwwwwwwwwwwwwww = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) entry2.getValue(), '.', (String) null, 2));
        }
    }

    public ei0(Class<?> cls) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "jClass");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
    }

    @Override // me.tvspark.di0
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ei0) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ij0) this), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ij0) obj));
    }

    @Override // me.tvspark.gj0
    public List<Annotation> getAnnotations() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ij0) this).hashCode();
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.toString() + " (Kotlin reflection is not available)";
    }
}
