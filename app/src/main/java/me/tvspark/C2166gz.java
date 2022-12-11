package me.tvspark;

import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: me.tvspark.gz */
/* loaded from: classes4.dex */
public final class C2166gz {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.gz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public final AtomicInteger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicInteger();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicInteger atomicInteger) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicInteger;
        }

        public final Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
            Type type2 = null;
            if (type != null) {
                if ((type instanceof Class) || (type instanceof TypeVariable)) {
                    return type;
                }
                if (type instanceof GenericArrayType) {
                    return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((GenericArrayType) type).getGenericComponentType()));
                }
                if (!(type instanceof ParameterizedType)) {
                    if (!(type instanceof WildcardType)) {
                        throw new AssertionError("must have been one of the known types");
                    }
                    WildcardType wildcardType = (WildcardType) type;
                    return wildcardType.getLowerBounds().length == 0 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getUpperBounds()) : type;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = new C2240iz(this, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, typeParameters[i]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(actualTypeArguments[i]);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType != null) {
                    type2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ownerType);
                }
                return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type2, cls, actualTypeArguments);
            }
            throw null;
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicInteger atomicInteger, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicInteger;
        }

        public TypeVariable<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type[] typeArr) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("capture#");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.incrementAndGet());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("-of ? extends ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(new C2382mt(String.valueOf('&')).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) Arrays.asList(typeArr)));
            return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), typeArr);
        }
    }

    /* renamed from: me.tvspark.gz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final TypeVariable<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            if (typeVariable != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = typeVariable;
                return;
            }
            throw null;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getGenericDeclaration(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName()});
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* renamed from: me.tvspark.gz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final ImmutableMap<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ImmutableMap.m3900of();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableMap<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> immutableMap) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = immutableMap;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        public Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Type mo4554get = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4554get(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable));
            if (mo4554get == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 0) {
                    return typeVariable;
                }
                Type[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2166gz(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bounds);
                return (!Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || !Arrays.equals(bounds, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) ? Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable.getGenericDeclaration(), typeVariable.getName(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : typeVariable;
            }
            return new C2166gz(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4554get);
        }
    }

    /* renamed from: me.tvspark.gz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2351lz {
        public final Map<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

        public static ImmutableMap<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
            if (type != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
                return ImmutableMap.copyOf((Map) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getGenericSuperclass());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getGenericInterfaces());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable.getBounds());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WildcardType wildcardType) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getUpperBounds());
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
            if (r7 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
            r4 = r12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
            if ((r7 instanceof java.lang.reflect.TypeVariable) == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
            r8 = new me.tvspark.C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((java.lang.reflect.TypeVariable) r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
            r7 = r4.remove(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
            r8 = null;
         */
        @Override // me.tvspark.AbstractC2351lz
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeParameters[i]);
                Type type = actualTypeArguments[i];
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    Type type2 = type;
                    while (true) {
                        if (type2 == null) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, type);
                            break;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                        boolean z = type2 instanceof TypeVariable;
                        if (z ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TypeVariable) type2) : false) {
                            break;
                        }
                        Map<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> map = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (z) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TypeVariable) type2);
                        }
                        type2 = map.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getOwnerType());
        }
    }

    /* renamed from: me.tvspark.gz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2351lz {
        public final /* synthetic */ Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Map Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map map, Type type) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = type;
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenericArrayType genericArrayType) {
            Type type = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (type instanceof WildcardType) {
                return;
            }
            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null, "%s is not an array type.", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, genericArrayType.getGenericComponentType(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParameterizedType parameterizedType) {
            Type type = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (type instanceof WildcardType) {
                return;
            }
            try {
                ParameterizedType parameterizedType2 = (ParameterizedType) ParameterizedType.class.cast(type);
                if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                    C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, actualTypeArguments[i], actualTypeArguments2[i]);
                }
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(type + " is not a " + ParameterizedType.class.getSimpleName());
            }
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WildcardType wildcardType) {
            Type type = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(type instanceof WildcardType)) {
                return;
            }
            WildcardType wildcardType2 = (WildcardType) type;
            Type[] upperBounds = wildcardType.getUpperBounds();
            Type[] upperBounds2 = wildcardType2.getUpperBounds();
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] lowerBounds2 = wildcardType2.getLowerBounds();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            for (int i = 0; i < upperBounds.length; i++) {
                C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, upperBounds[i], upperBounds2[i]);
            }
            for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, lowerBounds[i2], lowerBounds2[i2]);
            }
        }
    }

    public C2166gz() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public C2166gz(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public /* synthetic */ C2166gz(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static C2166gz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ImmutableMap<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableMap.builder();
        builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        for (Map.Entry<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> entry : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.entrySet()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww key = entry.getKey();
            Type value = entry.getValue();
            if (key != null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!(value instanceof TypeVariable ? key.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TypeVariable) value) : false), "Type variable %s bound to itself", key);
                builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key, value);
            } else {
                throw null;
            }
        }
        return new C2166gz(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, type2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
    }

    public Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        Type type2 = null;
        if (type != null) {
            if (type instanceof TypeVariable) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                TypeVariable<?> typeVariable = (TypeVariable) type;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    throw null;
                }
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable, new C2203hz(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, typeVariable, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType != null) {
                    type2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ownerType);
                }
                return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type2, (Class) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getRawType()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterizedType.getActualTypeArguments()));
            } else if (type instanceof GenericArrayType) {
                return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((GenericArrayType) type).getGenericComponentType()));
            } else {
                if (!(type instanceof WildcardType)) {
                    return type;
                }
                WildcardType wildcardType = (WildcardType) type;
                return new Types.WildcardTypeImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getLowerBounds()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getUpperBounds()));
            }
        }
        throw null;
    }

    public final Type[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr[i]);
        }
        return typeArr2;
    }
}
