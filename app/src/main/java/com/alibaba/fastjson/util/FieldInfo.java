package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes3.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    public final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    public final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    public int ordinal;
    public final int serialzeFeatures;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2) {
        this.ordinal = 0;
        i = i < 0 ? 0 : i;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        boolean z = true;
        this.isEnum = cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            if ((modifiers & 1) == 0 && this.method != null) {
                z = false;
            }
            this.fieldAccess = z;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j = -3750763034362895579L;
        for (int i3 = 0; i3 < str.length(); i3++) {
            j = (j ^ str.charAt(i3)) * 1099511628211L;
        }
        this.nameHashCode = j;
        this.format = null;
        this.alternateNames = new String[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x014f, code lost:
        r7 = r16.declaringClass.getTypeParameters();
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0157, code lost:
        if (r12 >= r7.length) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015f, code lost:
        if (r2.equals(r7[r12]) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0161, code lost:
        r11 = r8[r12];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, JSONField jSONField, JSONField jSONField2, boolean z) {
        String str2;
        boolean z2;
        Class<?> type2;
        Type type3;
        Type type4 = type;
        this.ordinal = 0;
        int i3 = i < 0 ? 0 : i;
        this.name = str;
        this.method = method;
        this.field = field;
        this.ordinal = i3;
        this.methodAnnotation = jSONField;
        this.fieldAnnotation = jSONField2;
        this.serialzeFeatures = i2;
        JSONField annotation = getAnnotation();
        Type type5 = null;
        if (annotation != null) {
            str2 = annotation.format();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.alternateNames = annotation.alternateNames();
        } else {
            this.alternateNames = new String[0];
            str2 = null;
        }
        this.format = str2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.fieldTransient = (modifiers & 128) != 0;
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        long j = -3750763034362895579L;
        for (int i4 = 0; i4 < str.length(); i4++) {
            j = 1099511628211L * (str.charAt(i4) ^ j);
        }
        this.nameHashCode = j;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                z2 = false;
                type2 = parameterTypes[0];
                type3 = (type2 == Class.class || type2 == String.class || type2.isPrimitive() || !z) ? type2 : method.getGenericParameterTypes()[0];
                this.getOnly = false;
            } else {
                z2 = false;
                type2 = method.getReturnType();
                type3 = (type2 != Class.class && z) ? method.getGenericReturnType() : type2;
                this.getOnly = true;
            }
            this.declaringClass = method.getDeclaringClass();
        } else {
            z2 = false;
            type2 = field.getType();
            Type genericType = (type2.isPrimitive() || type2 == String.class || type2.isEnum() || !z) ? type2 : field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            this.getOnly = Modifier.isFinal(field.getModifiers());
            type3 = genericType;
        }
        if (cls != null && type2 == Object.class && (type3 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type[] actualTypeArguments = type4 instanceof ParameterizedType ? ((ParameterizedType) type4).getActualTypeArguments() : null;
            for (Class<?> cls2 = cls; cls2 != null && cls2 != Object.class && cls2 != this.declaringClass; cls2 = cls2.getSuperclass()) {
                Type genericSuperclass = cls2.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    TypeUtils.getArgument(actualTypeArguments2, cls2.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
            }
            if (type5 != null) {
                this.fieldClass = TypeUtils.getClass(type5);
                this.fieldType = type5;
                if (type2.isEnum() && !JSONAware.class.isAssignableFrom(type2)) {
                    z2 = true;
                }
                this.isEnum = z2;
                return;
            }
        }
        if (!(type3 instanceof Class)) {
            Type fieldType = getFieldType(cls, type4 == null ? cls : type4, type3);
            if (fieldType != type3 && ((fieldType instanceof ParameterizedType) || (fieldType instanceof Class))) {
                type2 = TypeUtils.getClass(fieldType);
            }
            type3 = fieldType;
        }
        this.fieldType = type3;
        this.fieldClass = type2;
        if (!type2.isArray() && type2.isEnum() && !JSONAware.class.isAssignableFrom(type2)) {
            z2 = true;
        }
        this.isEnum = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<?>>[] typeVariableArr;
        ParameterizedType parameterizedType;
        int i;
        boolean z;
        Type type3;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass() : type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    Class<?> cls2 = TypeUtils.getClass(parameterizedType2);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i2 = 0; i2 < cls2.getTypeParameters().length; i2++) {
                        if (cls2.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i2];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] typeArr = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        cls = cls.getSuperclass();
                    } else {
                        typeVariableArr = null;
                        parameterizedType = null;
                        z = false;
                        for (i = 0; i < actualTypeArguments.length && parameterizedType != null; i++) {
                            type3 = actualTypeArguments[i];
                            if (!(type3 instanceof TypeVariable)) {
                                TypeVariable typeVariable2 = (TypeVariable) type3;
                                for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                                    if (typeVariableArr[i3].getName().equals(typeVariable2.getName())) {
                                        if (typeArr == null) {
                                            typeArr = parameterizedType.getActualTypeArguments();
                                        }
                                        actualTypeArguments[i] = typeArr[i3];
                                        z = true;
                                    }
                                }
                            }
                        }
                        if (z) {
                            return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                        }
                    }
                    typeVariableArr = cls.getTypeParameters();
                    z = false;
                    while (i < actualTypeArguments.length) {
                        type3 = actualTypeArguments[i];
                        if (!(type3 instanceof TypeVariable)) {
                        }
                    }
                    if (z) {
                    }
                }
            }
        }
        return type2;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i <= i2) {
            return this.name.compareTo(fieldInfo.name);
        }
        return 1;
    }

    public boolean equals(FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        return this.fieldAccess ? this.field.get(obj) : this.method.invoke(obj, new Object[0]);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public String toString() {
        return this.name;
    }
}
