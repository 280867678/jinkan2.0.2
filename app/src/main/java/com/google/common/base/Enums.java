package com.google.common.base;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import me.tvspark.C2536qt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Enums {
    public static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new WeakHashMap();

    /* loaded from: classes3.dex */
    public static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Class<T> enumClass;

        public StringConverter(Class<T> cls) {
            if (cls != null) {
                this.enumClass = cls;
                return;
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Object obj) {
            return doBackward((StringConverter<T>) ((Enum) obj));
        }

        public String doBackward(T t) {
            return t.name();
        }

        @Override // com.google.common.base.Converter
        public T doForward(String str) {
            return (T) Enum.valueOf(this.enumClass, str);
        }

        @Override // com.google.common.base.Converter, me.tvspark.AbstractC2271jt
        public boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                return this.enumClass.equals(((StringConverter) obj).enumClass);
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Enums.stringConverter(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.enumClass.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(".class)");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls) {
        HashMap hashMap;
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Map<String, WeakReference<? extends Enum<?>>> map = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
            hashMap = map;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                Iterator it = EnumSet.allOf(cls).iterator();
                while (it.hasNext()) {
                    Enum r3 = (Enum) it.next();
                    hashMap2.put(r3.name(), new WeakReference(r3));
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, hashMap2);
                hashMap = hashMap2;
            }
        }
        return hashMap;
    }

    public static <T extends Enum<T>> Optional<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls, String str) {
        if (cls != null) {
            if (str == null) {
                throw null;
            }
            return C2536qt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, str);
        }
        throw null;
    }
}
