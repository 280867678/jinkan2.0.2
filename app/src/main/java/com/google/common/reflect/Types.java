package com.google.common.reflect;

import com.google.common.base.Predicates$IsEqualToPredicate;
import com.google.common.base.Predicates$NotPredicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.AbstractC2092ez;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2351lz;
import me.tvspark.C2345lt;
import me.tvspark.C2382mt;
import me.tvspark.C2575rv;
import me.tvspark.C2612sv;
import me.tvspark.Illllllllllllllllllllllllllll;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public final class Types {
    public static final C2382mt Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final AbstractC2271jt<Type, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        public static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<String> {
        }

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        }

        /* synthetic */ ClassOwnership(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        public static ClassOwnership detectJvmBehavior() {
            ClassOwnership[] values;
            ParameterizedType parameterizedType = (ParameterizedType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        public abstract Class<?> getOwnerType(Class<?> cls);
    }

    /* loaded from: classes3.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        public static final long serialVersionUID = 0;
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* loaded from: classes3.dex */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            /* renamed from: newArrayType */
            public GenericArrayType mo4822newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                if (type != null) {
                    if (!(type instanceof Class)) {
                        return type;
                    }
                    Class cls = (Class) type;
                    return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
                }
                throw null;
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.common.reflect.Types.JavaVersion
            /* renamed from: newArrayType */
            public Type mo4822newArrayType(Type type) {
                return type instanceof Class ? Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class<?>) type) : new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                if (type != null) {
                    return type;
                }
                throw null;
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            /* renamed from: newArrayType */
            public Type mo4822newArrayType(Type type) {
                return JavaVersion.JAVA7.mo4822newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e2) {
                    e = e2;
                    throw new RuntimeException(e);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        },
        JAVA9 { // from class: com.google.common.reflect.Types.JavaVersion.4
            @Override // com.google.common.reflect.Types.JavaVersion
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            /* renamed from: newArrayType */
            public Type mo4822newArrayType(Type type) {
                return JavaVersion.JAVA8.mo4822newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                return JavaVersion.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA8.usedInGenericType(type);
            }
        };
        
        public static final JavaVersion CURRENT;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2092ez<int[]> {
        }

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2092ez<Map.Entry<String, int[][]>> {
        }

        static {
            CURRENT = AnnotatedElement.class.isAssignableFrom(TypeVariable.class) ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().capture().toString().contains("java.util.Map.java.util.Map") ? JAVA8 : JAVA9 : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().capture() instanceof Class ? JAVA7 : JAVA6;
        }

        /* synthetic */ JavaVersion(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        /* renamed from: newArrayType */
        public abstract Type mo4822newArrayType(Type type);

        public String typeName(Type type) {
            return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
        }

        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) usedInGenericType(type));
            }
            return builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public abstract Type usedInGenericType(Type type);
    }

    /* loaded from: classes3.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableList<Type> argumentsList;
        public final Type ownerType;
        public final Class<?> rawType;

        public ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            if (cls != null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr.length == cls.getTypeParameters().length);
                Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr, "type parameter");
                this.ownerType = type;
                this.rawType = cls;
                this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
                return;
            }
            throw null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null && JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName()) {
                sb.append(JavaVersion.CURRENT.typeName(this.ownerType));
                sb.append('.');
            }
            sb.append(this.rawType.getName());
            sb.append('<');
            C2382mt c2382mt = Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ImmutableList<Type> immutableList = this.argumentsList;
            AbstractC2271jt<Type, String> abstractC2271jt = Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (immutableList != null) {
                sb.append(c2382mt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) new C2612sv(immutableList, abstractC2271jt)));
                sb.append('>');
                return sb.toString();
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableList<Type> lowerBounds;
        public final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr, "lower bound for wildcard");
            Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            AbstractC2239iy<Type> mo4735iterator = this.lowerBounds.mo4735iterator();
            while (mo4735iterator.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(mo4735iterator.next()));
            }
            Iterator it = ((C2575rv) Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) this.upperBounds)).iterator();
            while (true) {
                AbstractIterator abstractIterator = (AbstractIterator) it;
                if (abstractIterator.hasNext()) {
                    sb.append(" extends ");
                    sb.append(JavaVersion.CURRENT.typeName((Type) abstractIterator.next()));
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements InvocationHandler {
        public static final ImmutableMap<String, Method> Wwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwwww;

        static {
            Method[] methods;
            ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableMap.builder();
            for (Method method : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getMethods()) {
                if (method.getDeclaringClass().equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method.getName(), method);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwww = builder.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method mo4554get = Wwwwwwwwwwwwwwwwwwwwwww.mo4554get(name);
            if (mo4554get != null) {
                try {
                    return mo4554get.invoke(this.Wwwwwwwwwwwwwwwwwwwwwwww, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
            throw new UnsupportedOperationException(name);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<D extends GenericDeclaration> {
        public final ImmutableList<Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final D Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(D d, String str, Type[] typeArr) {
            Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr, "bound for type variable");
            if (d != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d;
                if (str == null) {
                    throw null;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ImmutableList.copyOf(typeArr);
                return;
            }
            throw null;
        }

        public boolean equals(Object obj) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(typeVariable.getName()) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(typeVariable.getGenericDeclaration());
            } else if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Proxy.getInvocationHandler(obj)).Wwwwwwwwwwwwwwwwwwwwwwww;
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<X> {
        public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getTypeParameters()[0].equals(Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class, "X", new Type[0]));
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2351lz {
        public final /* synthetic */ AtomicReference Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReference atomicReference) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(cls.getComponentType());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenericArrayType genericArrayType) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(genericArrayType.getGenericComponentType());
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeVariable.getBounds()));
        }

        @Override // me.tvspark.AbstractC2351lz
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WildcardType wildcardType) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wildcardType.getUpperBounds()));
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Type, String> {
        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public String mo4462apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    }

    static {
        C2382mt c2382mt = new C2382mt(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2345lt(c2382mt, c2382mt, "null");
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return new WildcardTypeImpl(new Type[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lowerBounds[0])}, new Type[]{Object.class});
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(upperBounds.length == 1, "Wildcard should have only one upper bound.");
            return new WildcardTypeImpl(new Type[0], new Type[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(upperBounds[0])});
        }
        return JavaVersion.CURRENT.mo4822newArrayType(type);
    }

    public static Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    public static /* synthetic */ Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type[] typeArr) {
        for (Type type : typeArr) {
            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof Class) {
                    Class cls = (Class) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return new WildcardTypeImpl(new Type[0], new Type[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2});
            }
        }
        return null;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    public static /* synthetic */ Type[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    public static /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable iterable) {
        Predicates$NotPredicate predicates$NotPredicate = new Predicates$NotPredicate(new Predicates$IsEqualToPredicate(Object.class));
        if (iterable != null) {
            return new C2575rv(iterable, predicates$NotPredicate);
        }
        throw null;
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        if (type != null) {
            AtomicReference atomicReference = new AtomicReference();
            new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(atomicReference).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            return (Type) atomicReference.get();
        }
        throw null;
    }

    public static <D extends GenericDeclaration> TypeVariable<D> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d, str, typeArr));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable.class.isInterface(), "%s is not an interface", TypeVariable.class);
        return (TypeVariable) TypeVariable.class.cast(Proxy.newProxyInstance(TypeVariable.class.getClassLoader(), new Class[]{TypeVariable.class}, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public static ParameterizedType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
        }
        if (typeArr != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
            return new ParameterizedTypeImpl(type, cls, typeArr);
        }
        throw null;
    }
}
