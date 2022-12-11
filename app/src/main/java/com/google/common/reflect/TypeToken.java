package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.tvspark.AbstractC1960bv;
import me.tvspark.AbstractC2055dz;
import me.tvspark.AbstractC2092ez;
import me.tvspark.AbstractC2129fz;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2351lz;
import me.tvspark.AbstractC2384mv;
import me.tvspark.AbstractC2573rt;
import me.tvspark.C1927az;
import me.tvspark.C2166gz;
import me.tvspark.C2277jz;
import me.tvspark.C2314kz;
import me.tvspark.C2382mt;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class TypeToken<T> extends AbstractC2092ez<T> implements Serializable {
    public static final long serialVersionUID = 3637540370352322684L;
    public transient C2166gz covariantTypeResolver;
    public transient C2166gz invariantTypeResolver;
    public final Type runtimeType;

    /* loaded from: classes3.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        public static final long serialVersionUID = 0;
        public transient ImmutableSet<TypeToken<? super T>> classes;

        public ClassSet() {
            super();
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<TypeToken<? super T>> mo4974delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<TypeToken<?>> wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ImmutableSet<TypeToken<? super T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC1960bv.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2277jz(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) ImmutableList.m3918of(TypeToken.this))).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.classes = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return immutableSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<Class<?>> wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return ImmutableSet.copyOf((Collection) new C2277jz(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) TypeToken.this.getRawTypes()));
        }
    }

    /* loaded from: classes3.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        public static final long serialVersionUID = 0;
        public final transient TypeToken<T>.TypeSet allTypes;
        public transient ImmutableSet<TypeToken<? super T>> interfaces;

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2573rt<Class<?>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InterfaceSet interfaceSet) {
            }

            @Override // me.tvspark.AbstractC2573rt
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }
        }

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<TypeToken<? super T>> mo4974delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC1960bv.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.allTypes).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeFilter.INTERFACE_ONLY).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.interfaces = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return immutableSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return AbstractC1960bv.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeToken.this.getRawTypes())).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        public static final long serialVersionUID = 0;

        public SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* loaded from: classes3.dex */
    public enum TypeFilter implements AbstractC2573rt<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // me.tvspark.AbstractC2573rt
            public boolean apply(TypeToken<?> typeToken) {
                return !(typeToken.runtimeType instanceof TypeVariable) && !(typeToken.runtimeType instanceof WildcardType);
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // me.tvspark.AbstractC2573rt
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* synthetic */ TypeFilter(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class TypeSet extends AbstractC2384mv<TypeToken<? super T>> implements Serializable {
        public static final long serialVersionUID = 0;
        public transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        @Override // me.tvspark.AbstractC2384mv, me.tvspark.AbstractC2051dv, me.tvspark.AbstractC2310kv
        /* renamed from: delegate */
        public Set<TypeToken<? super T>> mo4974delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC1960bv.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableList.m3918of(TypeToken.this))).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.types = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return immutableSet;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeToken.this.getRawTypes()));
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<TypeToken<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
            public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                super(null);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            }
        }

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<Class<?>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
                return cls.getSuperclass();
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Iterable<? extends Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }
        }

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<TypeToken<?>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public TypeToken<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Iterable<? extends TypeToken<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public abstract K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k);

        public abstract Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k);

        /* JADX WARN: Multi-variable type inference failed */
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k).isInterface();
            int i = isInterface;
            for (K k2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<K>) k)) {
                i = Math.max(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k2, map));
            }
            K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
            int i2 = i;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                i2 = Math.max(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, map));
            }
            int i3 = i2 + 1;
            map.put(k, Integer.valueOf(i3));
            return i3;
        }

        public ImmutableList<K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends K> iterable) {
            HashMap hashMap = new HashMap();
            for (K k : iterable) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, hashMap);
            }
            return (ImmutableList<K>) new C2314kz(Ordering.natural().reverse(), hashMap).immutableSortedCopy(hashMap.keySet());
        }

        public abstract Iterable<? extends K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k);
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Type[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type[] typeArr, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = typeArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
            TypeToken<?> m3792of = TypeToken.m3792of(type);
            for (Type type2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                boolean isSubtypeOf = m3792of.isSubtypeOf(type2);
                boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
            for (Type type2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                boolean isSubtypeOf = TypeToken.m3792of(type2).isSubtypeOf(type);
                boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2351lz {
        public final /* synthetic */ ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeToken typeToken, ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) cls);
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenericArrayType genericArrayType) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class<?>) TypeToken.m3792of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParameterizedType parameterizedType) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ((Class) parameterizedType.getRawType()));
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable.getBounds());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WildcardType wildcardType) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getUpperBounds());
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2351lz {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenericArrayType genericArrayType) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(genericArrayType.getGenericComponentType());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParameterizedType parameterizedType) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getActualTypeArguments());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getOwnerType());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WildcardType wildcardType) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getLowerBounds());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getUpperBounds());
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2055dz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Constructor constructor) {
            super(constructor);
        }

        @Override // me.tvspark.C2001cz
        public TypeToken<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return TypeToken.this;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0059  */
        @Override // me.tvspark.C2001cz
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            boolean z;
            StringBuilder sb = new StringBuilder();
            sb.append(TypeToken.this);
            sb.append("(");
            C2382mt c2382mt = new C2382mt(", ");
            C2166gz invariantTypeResolver = TypeToken.this.getInvariantTypeResolver();
            Type[] genericParameterTypes = this.Wwwwwwwwwwwwwwwwwwwwww.getGenericParameterTypes();
            if (genericParameterTypes.length > 0) {
                Class<?> declaringClass = this.Wwwwwwwwwwwwwwwwwwwwww.getDeclaringClass();
                if (declaringClass.getEnclosingConstructor() == null) {
                    Method enclosingMethod = declaringClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        z = !Modifier.isStatic(enclosingMethod.getModifiers());
                    } else if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                        z = false;
                    }
                    if (z) {
                        Class<?>[] parameterTypes = this.Wwwwwwwwwwwwwwwwwwwwww.getParameterTypes();
                        if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) {
                            genericParameterTypes = (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                        }
                    }
                }
                z = true;
                if (z) {
                }
            }
            if (invariantTypeResolver != null) {
                for (int i = 0; i < genericParameterTypes.length; i++) {
                    genericParameterTypes[i] = invariantTypeResolver.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(genericParameterTypes[i]);
                }
                sb.append(c2382mt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) Arrays.asList(genericParameterTypes)));
                sb.append(")");
                return sb.toString();
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2055dz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Method method) {
            super(method);
        }

        @Override // me.tvspark.C2001cz
        public TypeToken<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return TypeToken.this;
        }

        @Override // me.tvspark.C2001cz
        public String toString() {
            return TypeToken.this + "." + super.toString();
        }
    }

    public TypeToken() {
        Type capture = capture();
        this.runtimeType = capture;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(capture);
        }
    }

    public TypeToken(Type type) {
        if (type != null) {
            this.runtimeType = type;
            return;
        }
        throw null;
    }

    public /* synthetic */ TypeToken(Type type, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this(type);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww any(Type[] typeArr) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) m3792of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> m3792of = m3792of(type);
            if (m3792of.getRawType().isInterface()) {
                builder.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) m3792of);
            }
        }
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? canonicalizeWildcardType(typeVariable, (WildcardType) type) : canonicalizeWildcardsInType(type);
    }

    public static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] upperBounds;
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    public static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            actualTypeArguments[i] = canonicalizeTypeArg(typeParameters[i], actualTypeArguments[i]);
        }
        return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    public static Type canonicalizeWildcardsInType(Type type) {
        return type instanceof ParameterizedType ? canonicalizeWildcardsInParameterizedType((ParameterizedType) type) : type instanceof GenericArrayType ? Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww every(Type[] typeArr) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return (TypeToken<? extends T>) m3792of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != null) {
            return (TypeToken<? super T>) m3792of(newArrayClassOrGenericArrayType(componentType.getSupertype(cls.getComponentType()).runtimeType));
        }
        throw new NullPointerException(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("%s isn't a super type of %s", cls, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2166gz getCovariantTypeResolver() {
        C2166gz c2166gz = this.covariantTypeResolver;
        if (c2166gz == null) {
            C2166gz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
            this.covariantTypeResolver = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return c2166gz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2166gz getInvariantTypeResolver() {
        C2166gz c2166gz = this.invariantTypeResolver;
        if (c2166gz == null) {
            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
            ImmutableMap m3900of = ImmutableMap.m3900of();
            ImmutableMap<C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableMap.builder();
            builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m3900of);
            for (Map.Entry<C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> entry : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.entrySet()) {
                C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww key = entry.getKey();
                Type value = entry.getValue();
                if (key != null) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!(value instanceof TypeVariable ? key.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TypeVariable) value) : false), "Type variable %s bound to itself", key);
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, value);
                } else {
                    throw null;
                }
            }
            C2166gz c2166gz2 = new C2166gz(new C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
            this.invariantTypeResolver = c2166gz2;
            return c2166gz2;
        }
        return c2166gz;
    }

    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (!(type instanceof Class)) {
            return null;
        }
        return ((Class) type).getEnclosingClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableSet.builder();
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, builder).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
        return builder.mo4631Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) m3792of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> m3792of = m3792of(type);
            if (m3792of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) m3792of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    /* renamed from: is */
    private boolean m3794is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
        return every(canonicalizeWildcardType.getUpperBounds()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && m3792of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        TypeToken<?> m3792of;
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return false;
            }
            m3792of = m3793of((Class) cls.getComponentType());
        } else if (!(type instanceof GenericArrayType)) {
            return false;
        } else {
            m3792of = m3792of(((GenericArrayType) type).getGenericComponentType());
        }
        return m3792of.isSubtypeOf(genericArrayType.getGenericComponentType());
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = m3792of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!m3792of(getCovariantTypeResolver().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeParameters[i])).m3794is(actualTypeArguments[i], typeParameters[i])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : m3792of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        } else if (!(type instanceof GenericArrayType)) {
            return false;
        } else {
            return m3792of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
    }

    private boolean isWrapper() {
        return C1927az.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keySet().contains(this.runtimeType);
    }

    public static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.mo4822newArrayType(type);
    }

    /* renamed from: of */
    public static <T> TypeToken<T> m3793of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    /* renamed from: of */
    public static TypeToken<?> m3792of(Type type) {
        return new SimpleTypeToken(type);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> m3792of = m3792of(getCovariantTypeResolver().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type));
        m3792of.covariantTypeResolver = this.covariantTypeResolver;
        m3792of.invariantTypeResolver = this.invariantTypeResolver;
        return m3792of;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if (!(this.runtimeType instanceof Class) || (cls.getTypeParameters().length != 0 && getRawType().getTypeParameters().length == 0)) {
            TypeToken genericType = toGenericType(cls);
            Type type = genericType.getSupertype(getRawType()).runtimeType;
            C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Type type2 = this.runtimeType;
            HashMap hashMap = new HashMap();
            if (type == null) {
                throw null;
            }
            if (type2 != null) {
                C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, type, type2);
                ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableMap.builder();
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                for (Map.Entry entry : hashMap.entrySet()) {
                    C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) entry.getKey();
                    Type type3 = (Type) entry.getValue();
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!(type3 instanceof TypeVariable ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TypeVariable) type3) : false), "Type variable %s bound to itself", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, type3);
                    } else {
                        throw null;
                    }
                }
                return new C2166gz(new C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(genericType.runtimeType);
            }
            throw null;
        }
        return cls;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        AbstractC2239iy<Class<? super T>> mo4735iterator = getRawTypes().mo4735iterator();
        while (mo4735iterator.hasNext()) {
            if (cls.isAssignableFrom(mo4735iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (cls.isArray()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(toGenericType(cls.getComponentType()).runtimeType);
        } else {
            TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
            Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
            if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
                return m3793of((Class) cls);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, (Class<?>) cls, (Type[]) typeParameters);
        }
        return (TypeToken<? extends T>) m3792of(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public final AbstractC2055dz<T, T> constructor(Constructor<?> constructor) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            return null;
        }
        return m3792of(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) resolveSupertype(type2));
        }
        return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        Type type;
        Type type2 = this.runtimeType;
        if (type2 instanceof TypeVariable) {
            type = ((TypeVariable) type2).getBounds()[0];
        } else if (!(type2 instanceof WildcardType)) {
            Type genericSuperclass = getRawType().getGenericSuperclass();
            if (genericSuperclass != null) {
                return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
            }
            return null;
        } else {
            type = ((WildcardType) type2).getUpperBounds()[0];
        }
        return boundAsSuperclass(type);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().mo4735iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) m3792of(resolveTypeArgsForSubclass(cls));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        return type instanceof TypeVariable ? getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds()) : type instanceof WildcardType ? getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds()) : cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSubtypeOf(Type type) {
        if (type != null) {
            if (type instanceof WildcardType) {
                return any(((WildcardType) type).getLowerBounds()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
            }
            Type type2 = this.runtimeType;
            if (type2 instanceof WildcardType) {
                return any(((WildcardType) type2).getUpperBounds()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            }
            if (type2 instanceof TypeVariable) {
                return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            } else if (type2 instanceof GenericArrayType) {
                return m3792of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
            } else {
                if (type instanceof Class) {
                    return someRawTypeIsSubclassOf((Class) type);
                }
                if (type instanceof ParameterizedType) {
                    return isSubtypeOfParameterizedType((ParameterizedType) type);
                }
                if (!(type instanceof GenericArrayType)) {
                    return false;
                }
                return isSubtypeOfArrayType((GenericArrayType) type);
            }
        }
        throw null;
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type type) {
        return m3792of(type).isSubtypeOf(getType());
    }

    public final AbstractC2055dz<T, Object> method(Method method) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method);
    }

    public final TypeToken<T> rejectTypeVariables() {
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        if (type != null) {
            return m3792of(getInvariantTypeResolver().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type));
        }
        throw null;
    }

    public String toString() {
        return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? m3793of(C1927az.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(AbstractC2129fz<X> abstractC2129fz, TypeToken<X> typeToken) {
        new C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public final <X> TypeToken<T> where(AbstractC2129fz<X> abstractC2129fz, Class<X> cls) {
        return where(abstractC2129fz, m3793of((Class) cls));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? m3793of(C1927az.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return m3792of(new C2166gz().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.runtimeType));
    }
}
