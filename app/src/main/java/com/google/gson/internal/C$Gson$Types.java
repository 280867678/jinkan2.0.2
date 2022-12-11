package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;
import okhttp3.HttpUrl;

/* renamed from: com.google.gson.internal.$Gson$Types  reason: invalid class name */
/* loaded from: classes3.dex */
public final class C$Gson$Types {
    public static final Type[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Type[0];

    /* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* loaded from: classes3.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        public static final long serialVersionUID = 0;
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    /* loaded from: classes3.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        public static final long serialVersionUID = 0;
        public final Type ownerType;
        public final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            }
            this.ownerType = type == null ? null : C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type);
            this.rawType = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.typeArguments[i]);
                C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.typeArguments[i]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i] = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr3[i]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
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
            int hashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Type type = this.ownerType;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.rawType);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.rawType));
            sb.append("<");
            sb.append(C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.typeArguments[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.typeArguments[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    /* loaded from: classes3.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        public static final long serialVersionUID = 0;
        public final Type lowerBound;
        public final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr2.length <= 1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr.length == 1);
            if (typeArr2.length != 1) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr[0]);
                C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr[0]);
                this.lowerBound = null;
                this.upperBound = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr[0]);
                return;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr2[0]);
            C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr2[0]);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr[0] != Object.class ? false : z);
            this.lowerBound = C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeArr2[0]);
            this.upperBound = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            return type != null ? new Type[]{type} : C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Type type;
            if (this.lowerBound != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("? super ");
                type = this.lowerBound;
            } else if (this.upperBound == Object.class) {
                return "?";
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("? extends ");
                type = this.upperBound;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C$Gson$Types.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((WildcardType) type).getUpperBounds()[0]);
            }
            String name = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
        }
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls2.isAssignableFrom(cls));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, cls2));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new GenericArrayTypeImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type, Class<?> cls, Type type2) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, type2, new HashSet());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        }
    }

    public static Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        TypeVariable typeVariable;
        do {
            int i = 0;
            if (!(type2 instanceof TypeVariable)) {
                if (type2 instanceof Class) {
                    Class cls2 = (Class) type2;
                    if (cls2.isArray()) {
                        Class<?> componentType = cls2.getComponentType();
                        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, componentType, collection);
                        return componentType == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? cls2 : new GenericArrayTypeImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, genericComponentType, collection);
                    return genericComponentType == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? genericArrayType : new GenericArrayTypeImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                } else if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, ownerType, collection);
                    boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    while (i < length) {
                        Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, actualTypeArguments[i], collection);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != actualTypeArguments[i]) {
                            if (!z) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z = true;
                            }
                            actualTypeArguments[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                        }
                        i++;
                    }
                    return z ? new ParameterizedTypeImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                } else {
                    boolean z2 = type2 instanceof WildcardType;
                    WildcardType wildcardType = type2;
                    if (z2) {
                        WildcardType wildcardType2 = (WildcardType) type2;
                        Type[] lowerBounds = wildcardType2.getLowerBounds();
                        Type[] upperBounds = wildcardType2.getUpperBounds();
                        if (lowerBounds.length == 1) {
                            Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, lowerBounds[0], collection);
                            wildcardType = wildcardType2;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != lowerBounds[0]) {
                                return new WildcardTypeImpl(new Type[]{Object.class}, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 instanceof WildcardType ? ((WildcardType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6).getLowerBounds() : new Type[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6});
                            }
                        } else {
                            wildcardType = wildcardType2;
                            if (upperBounds.length == 1) {
                                Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, upperBounds[0], collection);
                                wildcardType = wildcardType2;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != upperBounds[0]) {
                                    return new WildcardTypeImpl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 instanceof WildcardType ? ((WildcardType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7).getUpperBounds() : new Type[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7}, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                            }
                        }
                    }
                    return wildcardType;
                }
            }
            typeVariable = (TypeVariable) type2;
            if (collection.contains(typeVariable)) {
                return type2;
            }
            collection.add(typeVariable);
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 != null) {
                Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(type, cls, (Class<?>) cls3);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    int length2 = typeParameters.length;
                    while (i < length2) {
                        if (typeVariable.equals(typeParameters[i])) {
                            type2 = ((ParameterizedType) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8).getActualTypeArguments()[i];
                            continue;
                        } else {
                            i++;
                        }
                    }
                    throw new NoSuchElementException();
                }
            }
            type2 = typeVariable;
            continue;
        } while (type2 != typeVariable);
        return type2;
    }
}
