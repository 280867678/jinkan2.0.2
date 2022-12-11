package me.tvspark;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* loaded from: classes4.dex */
public final class g10 {
    public final r20 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<Type, l00<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements r10<T> {
        public final /* synthetic */ Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ l00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g10 g10Var, l00 l00Var, Type type) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = l00Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // me.tvspark.r10
        public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements r10<T> {
        public final /* synthetic */ Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ l00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g10 g10Var, l00 l00Var, Type type) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = l00Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // me.tvspark.r10
        public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public g10(Map<Type, l00<?>> map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
    }

    public <T> r10<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t20<T> t20Var) {
        h10 h10Var;
        Type type = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<? super T> cls = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        l00<?> l00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(type);
        if (l00Var != null) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, l00Var, type);
        }
        l00<?> l00Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (l00Var2 != null) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, l00Var2, type);
        }
        r10<T> r10Var = null;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(declaredConstructor);
            }
            h10Var = new h10(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            h10Var = null;
        }
        if (h10Var != null) {
            return h10Var;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            r10Var = SortedSet.class.isAssignableFrom(cls) ? new i10(this) : EnumSet.class.isAssignableFrom(cls) ? new j10(this, type) : Set.class.isAssignableFrom(cls) ? new k10(this) : Queue.class.isAssignableFrom(cls) ? new l10(this) : new m10(this);
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                r10Var = new n10(this);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                r10Var = new b10(this);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                r10Var = new c10(this);
            } else {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 != null) {
                        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type2);
                        Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hashCode();
                        if (!String.class.isAssignableFrom(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            r10Var = new d10(this);
                        }
                    } else {
                        throw null;
                    }
                }
                r10Var = new e10(this);
            }
        }
        return r10Var != null ? r10Var : new f10(this, cls, type);
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
