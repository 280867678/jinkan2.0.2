package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.umeng.analytics.pro.C1543ak;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class JavaBeanInfo {
    public final Constructor<?> creatorConstructor;
    public final String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public boolean ordered = false;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final boolean supportBeanToArray;
    public final String typeKey;
    public final long typeKeyHashCode;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType, String[] strArr) {
        int i;
        boolean z;
        int i2 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        String str = null;
        if (strArr == null || strArr.length != fieldInfoArr.length) {
            this.creatorConstructorParameters = strArr;
        } else {
            this.creatorConstructorParameters = null;
        }
        if (jSONType != null) {
            String typeName = jSONType.typeName();
            this.typeName = typeName.length() <= 0 ? cls.getName() : typeName;
            String typeKey = jSONType.typeKey();
            this.typeKey = typeKey.length() > 0 ? typeKey : str;
            i = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i = 0;
        }
        String str2 = this.typeKey;
        this.typeKeyHashCode = str2 == null ? 0L : TypeUtils.fnv_64_lower(str2);
        this.parserFeatures = i;
        if (jSONType != null) {
            Feature[] parseFeatures = jSONType.parseFeatures();
            z = false;
            for (Feature feature2 : parseFeatures) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.supportBeanToArray = z;
        FieldInfo[] computeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = !Arrays.equals(fieldInfoArr, computeSortedFields) ? computeSortedFields : fieldInfoArr;
        if (constructor != null) {
            i2 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i2 = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = i2;
    }

    public static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                FieldInfo fieldInfo2 = list.get(i);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0513, code lost:
        if (java.lang.Character.isUpperCase(r1.charAt(4)) != false) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x05af  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.lang.reflect.Type[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JavaBeanInfo build(Class<?> cls, int i, Type type, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        Constructor<?> constructor;
        Class<? super Object> cls2;
        Method[] methodArr;
        Method method;
        Method method2;
        Constructor<?> constructor2;
        Constructor<?> constructor3;
        Method[] methodArr2;
        Field[] fieldArr;
        Method method3;
        Constructor<?> constructor4;
        JSONField jSONField;
        String str;
        int i2;
        int i3;
        Constructor<?> constructor5;
        JSONField jSONField2;
        JSONField jSONField3;
        ArrayList arrayList;
        Field[] fieldArr2;
        Method[] methodArr3;
        Method method4;
        Constructor<?> constructor6;
        int i4;
        int i5;
        String str2;
        PropertyNamingStrategy propertyNamingStrategy2;
        int i6;
        int i7;
        Field[] declaredFields;
        int i8;
        int i9;
        HashMap hashMap;
        Field[] fieldArr3;
        Method[] methodArr4;
        Method method5;
        Constructor<?> constructor7;
        ArrayList arrayList2;
        Class<?> returnType;
        HashMap hashMap2;
        Method method6;
        int i10;
        int i11;
        String substring;
        HashMap hashMap3;
        Field field;
        Field field2;
        PropertyNamingStrategy propertyNamingStrategy3;
        JSONField jSONField4;
        int i12;
        int i13;
        Constructor<?> constructor8;
        Class<? super Object> cls3 = Object.class;
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap4 = new HashMap();
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        boolean isKotlin = TypeUtils.isKotlin(cls);
        int i14 = i & 1024;
        if (i14 != 0 || (declaredConstructors.length != 1 && isKotlin)) {
            constructor = null;
        } else {
            try {
                constructor8 = cls.getDeclaredConstructor(new Class[0]);
            } catch (Exception unused) {
                constructor8 = null;
            }
            if (constructor8 == null && cls.isMemberClass() && (i & 8) == 0) {
                int length = declaredConstructors.length;
                int i15 = 0;
                while (i15 < length) {
                    Constructor<?> constructor9 = declaredConstructors[i15];
                    Class<?>[] parameterTypes = constructor9.getParameterTypes();
                    Constructor<?> constructor10 = constructor8;
                    if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                        constructor = constructor9;
                        break;
                    }
                    i15++;
                    constructor8 = constructor10;
                }
            }
            constructor = constructor8;
        }
        String[] strArr = null;
        if (z) {
            cls2 = cls3;
            method = null;
            methodArr = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            Method method7 = null;
            for (Class<? super Object> cls4 = cls; cls4 != null && cls4 != cls3; cls4 = cls4.getSuperclass()) {
                Method[] declaredMethods = cls4.getDeclaredMethods();
                int length2 = declaredMethods.length;
                Class<? super Object> cls5 = cls3;
                int i16 = 0;
                while (i16 < length2) {
                    int i17 = length2;
                    Method method8 = declaredMethods[i16];
                    Method[] methodArr5 = declaredMethods;
                    int modifiers = method8.getModifiers();
                    if ((modifiers & 8) != 0) {
                        if (method8.isAnnotationPresent(JSONCreator.class)) {
                            if (method7 != null) {
                                throw new JSONException("multi-json creator");
                            }
                            method7 = method8;
                            i16++;
                            length2 = i17;
                            declaredMethods = methodArr5;
                        }
                    } else if ((modifiers & 2) == 0) {
                        method2 = method7;
                        if ((modifiers & 256) == 0 && (modifiers & 4) == 0) {
                            arrayList4.add(method8);
                        }
                        method7 = method2;
                        i16++;
                        length2 = i17;
                        declaredMethods = methodArr5;
                    }
                    method2 = method7;
                    method7 = method2;
                    i16++;
                    length2 = i17;
                    declaredMethods = methodArr5;
                }
                cls3 = cls5;
            }
            cls2 = cls3;
            Method[] methodArr6 = new Method[arrayList4.size()];
            arrayList4.toArray(methodArr6);
            methodArr = methodArr6;
            method = method7;
        }
        Field[] declaredFields2 = cls.getDeclaredFields();
        boolean z5 = cls.isInterface() || i14 != 0;
        if (constructor == null || z5) {
            int length3 = declaredConstructors.length;
            int i18 = 0;
            while (true) {
                if (i18 >= length3) {
                    constructor2 = null;
                    break;
                }
                constructor2 = declaredConstructors[i18];
                int i19 = length3;
                if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                    break;
                }
                i18++;
                length3 = i19;
            }
            String str3 = "illegal json creator";
            if (constructor2 != null) {
                TypeUtils.setAccessible(cls, constructor2, i);
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                Class<?>[] genericParameterTypes = z4 ? constructor2.getGenericParameterTypes() : parameterTypes2;
                Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
                int i20 = 0;
                while (i20 < parameterTypes2.length) {
                    Annotation[] annotationArr = parameterAnnotations[i20];
                    int length4 = annotationArr.length;
                    String str4 = str3;
                    int i21 = 0;
                    while (true) {
                        if (i21 >= length4) {
                            jSONField3 = null;
                            break;
                        }
                        int i22 = length4;
                        Annotation annotation = annotationArr[i21];
                        Annotation[] annotationArr2 = annotationArr;
                        if (annotation instanceof JSONField) {
                            jSONField3 = (JSONField) annotation;
                            break;
                        }
                        i21++;
                        length4 = i22;
                        annotationArr = annotationArr2;
                    }
                    if (jSONField3 == null) {
                        throw new JSONException(str4);
                    }
                    Class<?> cls6 = parameterTypes2[i20];
                    Class<?> cls7 = genericParameterTypes[i20];
                    Field field3 = TypeUtils.getField(cls, jSONField3.name(), declaredFields2, hashMap4);
                    if (field3 != null) {
                        TypeUtils.setAccessible(cls, field3, i);
                    }
                    addField(arrayList3, new FieldInfo(jSONField3.name(), cls, cls6, cls7, field3, jSONField3.ordinal(), SerializerFeature.m4193of(jSONField3.serialzeFeatures())), z);
                    i20++;
                    method = method;
                    str3 = str4;
                    constructor2 = constructor2;
                    constructor = constructor;
                    declaredFields2 = declaredFields2;
                    parameterTypes2 = parameterTypes2;
                    methodArr = methodArr;
                }
                constructor5 = constructor2;
                Field[] fieldArr4 = declaredFields2;
                constructor3 = constructor;
                methodArr2 = methodArr;
                Method method9 = method;
                int size = arrayList3.size();
                FieldInfo[] fieldInfoArr = new FieldInfo[size];
                arrayList3.toArray(fieldInfoArr);
                FieldInfo[] fieldInfoArr2 = new FieldInfo[size];
                System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, size);
                Arrays.sort(fieldInfoArr2);
                if (z2) {
                    JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
                }
                String[] strArr2 = new String[size];
                for (int i23 = 0; i23 < size; i23++) {
                    strArr2[i23] = fieldInfoArr[i23].name;
                }
                strArr = strArr2;
                method3 = method9;
                fieldArr = fieldArr4;
            } else {
                Constructor<?> constructor11 = constructor2;
                Field[] fieldArr5 = declaredFields2;
                constructor3 = constructor;
                methodArr2 = methodArr;
                Method method10 = method;
                if (method10 != null) {
                    TypeUtils.setAccessible(cls, method10, i);
                    Class<?>[] parameterTypes3 = method10.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        Class<?>[] genericParameterTypes2 = z4 ? method10.getGenericParameterTypes() : parameterTypes3;
                        Annotation[][] parameterAnnotations2 = method10.getParameterAnnotations();
                        int i24 = 0;
                        while (i24 < parameterTypes3.length) {
                            Annotation[] annotationArr3 = parameterAnnotations2[i24];
                            int length5 = annotationArr3.length;
                            int i25 = 0;
                            while (true) {
                                if (i25 >= length5) {
                                    jSONField2 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr3[i25];
                                if (annotation2 instanceof JSONField) {
                                    jSONField2 = (JSONField) annotation2;
                                    break;
                                }
                                i25++;
                            }
                            if (jSONField2 == null) {
                                throw new JSONException(str3);
                            }
                            Field[] fieldArr6 = fieldArr5;
                            addField(arrayList3, new FieldInfo(jSONField2.name(), cls, parameterTypes3[i24], genericParameterTypes2[i24], TypeUtils.getField(cls, jSONField2.name(), fieldArr6, hashMap4), jSONField2.ordinal(), SerializerFeature.m4193of(jSONField2.serialzeFeatures())), z);
                            i24++;
                            genericParameterTypes2 = genericParameterTypes2;
                            fieldArr5 = fieldArr6;
                            parameterTypes3 = parameterTypes3;
                        }
                        int size2 = arrayList3.size();
                        FieldInfo[] fieldInfoArr3 = new FieldInfo[size2];
                        arrayList3.toArray(fieldInfoArr3);
                        FieldInfo[] fieldInfoArr4 = new FieldInfo[size2];
                        System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, size2);
                        Arrays.sort(fieldInfoArr4);
                        return new JavaBeanInfo(cls, null, null, method10, fieldInfoArr3, Arrays.equals(fieldInfoArr3, fieldInfoArr4) ? fieldInfoArr3 : fieldInfoArr4, z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null, null);
                    }
                    fieldArr = fieldArr5;
                } else {
                    fieldArr = fieldArr5;
                    if (!z5) {
                        if (!isKotlin || declaredConstructors.length <= 0) {
                            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default constructor not found. ", (Class) cls));
                        }
                        String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                        if (koltinConstructorParameters == null) {
                            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default constructor not found. ", (Class) cls));
                        }
                        Constructor<?> constructor12 = constructor11;
                        for (Constructor<?> constructor13 : declaredConstructors) {
                            Class<?>[] parameterTypes4 = constructor13.getParameterTypes();
                            if ((parameterTypes4.length <= 0 || !parameterTypes4[parameterTypes4.length - 1].getName().equals("me.tvspark.gi0")) && (constructor12 == null || constructor12.getParameterTypes().length < parameterTypes4.length)) {
                                constructor12 = constructor13;
                            }
                        }
                        constructor12.setAccessible(true);
                        TypeUtils.setAccessible(cls, constructor12, i);
                        Class<?>[] parameterTypes5 = constructor12.getParameterTypes();
                        Class<?>[] genericParameterTypes3 = z4 ? constructor12.getGenericParameterTypes() : parameterTypes5;
                        Annotation[][] parameterAnnotations3 = constructor12.getParameterAnnotations();
                        int i26 = 0;
                        while (i26 < parameterTypes5.length) {
                            String str5 = koltinConstructorParameters[i26];
                            Annotation[] annotationArr4 = parameterAnnotations3[i26];
                            int length6 = annotationArr4.length;
                            int i27 = 0;
                            while (true) {
                                if (i27 >= length6) {
                                    jSONField = null;
                                    break;
                                }
                                Annotation annotation3 = annotationArr4[i27];
                                Annotation[] annotationArr5 = annotationArr4;
                                if (annotation3 instanceof JSONField) {
                                    jSONField = (JSONField) annotation3;
                                    break;
                                }
                                i27++;
                                annotationArr4 = annotationArr5;
                            }
                            Class<?> cls8 = parameterTypes5[i26];
                            Class<?> cls9 = genericParameterTypes3[i26];
                            Field field4 = TypeUtils.getField(cls, str5, fieldArr, hashMap4);
                            if (field4 != null && jSONField == null) {
                                jSONField = (JSONField) field4.getAnnotation(JSONField.class);
                            }
                            if (jSONField != null) {
                                int ordinal = jSONField.ordinal();
                                int m4193of = SerializerFeature.m4193of(jSONField.serialzeFeatures());
                                String name = jSONField.name();
                                if (name.length() != 0) {
                                    str5 = name;
                                }
                                i3 = m4193of;
                                i2 = ordinal;
                                str = str5;
                            } else {
                                str = str5;
                                i2 = 0;
                                i3 = 0;
                            }
                            addField(arrayList3, new FieldInfo(str, cls, cls8, cls9, field4, i2, i3), z);
                            i26++;
                            constructor12 = constructor12;
                            parameterTypes5 = parameterTypes5;
                            method10 = method10;
                        }
                        Constructor<?> constructor14 = constructor12;
                        method3 = method10;
                        int size3 = arrayList3.size();
                        FieldInfo[] fieldInfoArr5 = new FieldInfo[size3];
                        arrayList3.toArray(fieldInfoArr5);
                        FieldInfo[] fieldInfoArr6 = new FieldInfo[size3];
                        System.arraycopy(fieldInfoArr5, 0, fieldInfoArr6, 0, size3);
                        Arrays.sort(fieldInfoArr6);
                        String[] strArr3 = new String[size3];
                        for (int i28 = 0; i28 < size3; i28++) {
                            strArr3[i28] = fieldInfoArr5[i28].name;
                        }
                        strArr = strArr3;
                        constructor4 = constructor14;
                        constructor5 = constructor4;
                    }
                }
                method3 = method10;
                constructor4 = constructor11;
                constructor5 = constructor4;
            }
        } else {
            fieldArr = declaredFields2;
            method3 = method;
            constructor3 = constructor;
            methodArr2 = methodArr;
            constructor5 = null;
        }
        Constructor<?> constructor15 = constructor3;
        if (constructor3 != null) {
            TypeUtils.setAccessible(cls, constructor15, i);
        }
        int i29 = 4;
        if (!z) {
            Method[] methodArr7 = methodArr2;
            int length7 = methodArr7.length;
            int i30 = 0;
            while (i30 < length7) {
                Method method11 = methodArr7[i30];
                String name2 = method11.getName();
                if (name2.length() >= i29 && (((returnType = method11.getReturnType()) == Void.TYPE || returnType == method11.getDeclaringClass()) && method11.getParameterTypes().length == 1)) {
                    JSONField jSONField5 = z3 ? (JSONField) method11.getAnnotation(JSONField.class) : null;
                    if (jSONField5 == null && z3) {
                        jSONField5 = TypeUtils.getSupperMethodAnnotation(cls, method11);
                    }
                    JSONField jSONField6 = jSONField5;
                    if (jSONField6 == null) {
                        i8 = i30;
                        i9 = length7;
                        hashMap2 = hashMap4;
                        methodArr4 = methodArr7;
                        method5 = method3;
                        constructor7 = constructor15;
                        arrayList2 = arrayList3;
                        method6 = method11;
                        i10 = 0;
                        i11 = 0;
                    } else if (jSONField6.deserialize()) {
                        i10 = jSONField6.ordinal();
                        i11 = SerializerFeature.m4193of(jSONField6.serialzeFeatures());
                        if (jSONField6.name().length() != 0) {
                            i8 = i30;
                            i9 = length7;
                            method5 = method3;
                            constructor7 = constructor15;
                            hashMap2 = hashMap4;
                            methodArr4 = methodArr7;
                            arrayList2 = arrayList3;
                            addField(arrayList2, new FieldInfo(jSONField6.name(), method11, null, cls, type, i10, i11, jSONField6, null, z4), z);
                            TypeUtils.setAccessible(cls, method11, i);
                            hashMap = hashMap2;
                            fieldArr3 = fieldArr;
                            i30 = i8 + 1;
                            i29 = 4;
                            arrayList3 = arrayList2;
                            methodArr7 = methodArr4;
                            constructor15 = constructor7;
                            length7 = i9;
                            method3 = method5;
                            hashMap4 = hashMap;
                            fieldArr = fieldArr3;
                        } else {
                            i8 = i30;
                            i9 = length7;
                            hashMap2 = hashMap4;
                            methodArr4 = methodArr7;
                            method5 = method3;
                            constructor7 = constructor15;
                            arrayList2 = arrayList3;
                            method6 = method11;
                        }
                    }
                    if (name2.startsWith("set")) {
                        char charAt = name2.charAt(3);
                        if (Character.isUpperCase(charAt)) {
                            if (!TypeUtils.compatibleWithJavaBean) {
                                substring = Character.toLowerCase(name2.charAt(3)) + name2.substring(4);
                                hashMap3 = hashMap2;
                                field = TypeUtils.getField(cls, substring, fieldArr, hashMap3);
                                if (field == null && method6.getParameterTypes()[0] == Boolean.TYPE) {
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1543ak.f2994ae);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Character.toUpperCase(substring.charAt(0)));
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(substring.substring(1));
                                    field = TypeUtils.getField(cls, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), fieldArr, hashMap3);
                                }
                                field2 = field;
                                if (field2 != null) {
                                    JSONField jSONField7 = z3 ? (JSONField) field2.getAnnotation(JSONField.class) : null;
                                    if (jSONField7 != null) {
                                        i12 = jSONField7.ordinal();
                                        i13 = SerializerFeature.m4193of(jSONField7.serialzeFeatures());
                                        if (jSONField7.name().length() != 0) {
                                            hashMap = hashMap3;
                                            fieldArr3 = fieldArr;
                                            addField(arrayList2, new FieldInfo(jSONField7.name(), method6, field2, cls, type, i12, i13, jSONField6, jSONField7, z4), z);
                                        } else {
                                            hashMap = hashMap3;
                                            fieldArr3 = fieldArr;
                                            if (jSONField6 == null) {
                                                propertyNamingStrategy3 = propertyNamingStrategy;
                                                jSONField4 = jSONField7;
                                                if (propertyNamingStrategy3 != null) {
                                                    substring = propertyNamingStrategy3.translate(substring);
                                                }
                                                addField(arrayList2, new FieldInfo(substring, method6, null, cls, type, i12, i13, jSONField4, null, z4), z);
                                                TypeUtils.setAccessible(cls, method6, i);
                                            } else {
                                                i10 = i12;
                                                i11 = i13;
                                                propertyNamingStrategy3 = propertyNamingStrategy;
                                                jSONField4 = jSONField6;
                                                i12 = i10;
                                                i13 = i11;
                                                if (propertyNamingStrategy3 != null) {
                                                }
                                                addField(arrayList2, new FieldInfo(substring, method6, null, cls, type, i12, i13, jSONField4, null, z4), z);
                                                TypeUtils.setAccessible(cls, method6, i);
                                            }
                                        }
                                    }
                                }
                                hashMap = hashMap3;
                                fieldArr3 = fieldArr;
                                propertyNamingStrategy3 = propertyNamingStrategy;
                                jSONField4 = jSONField6;
                                i12 = i10;
                                i13 = i11;
                                if (propertyNamingStrategy3 != null) {
                                }
                                addField(arrayList2, new FieldInfo(substring, method6, null, cls, type, i12, i13, jSONField4, null, z4), z);
                                TypeUtils.setAccessible(cls, method6, i);
                            }
                            substring = TypeUtils.decapitalize(name2.substring(3));
                            hashMap3 = hashMap2;
                            field = TypeUtils.getField(cls, substring, fieldArr, hashMap3);
                            if (field == null) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1543ak.f2994ae);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Character.toUpperCase(substring.charAt(0)));
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(substring.substring(1));
                                field = TypeUtils.getField(cls, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), fieldArr, hashMap3);
                            }
                            field2 = field;
                            if (field2 != null) {
                            }
                            hashMap = hashMap3;
                            fieldArr3 = fieldArr;
                            propertyNamingStrategy3 = propertyNamingStrategy;
                            jSONField4 = jSONField6;
                            i12 = i10;
                            i13 = i11;
                            if (propertyNamingStrategy3 != null) {
                            }
                            addField(arrayList2, new FieldInfo(substring, method6, null, cls, type, i12, i13, jSONField4, null, z4), z);
                            TypeUtils.setAccessible(cls, method6, i);
                        } else {
                            if (charAt == '_') {
                                substring = name2.substring(4);
                            } else if (charAt == 'f') {
                                substring = name2.substring(3);
                            } else if (name2.length() >= 5) {
                            }
                            hashMap3 = hashMap2;
                            field = TypeUtils.getField(cls, substring, fieldArr, hashMap3);
                            if (field == null) {
                            }
                            field2 = field;
                            if (field2 != null) {
                            }
                            hashMap = hashMap3;
                            fieldArr3 = fieldArr;
                            propertyNamingStrategy3 = propertyNamingStrategy;
                            jSONField4 = jSONField6;
                            i12 = i10;
                            i13 = i11;
                            if (propertyNamingStrategy3 != null) {
                            }
                            addField(arrayList2, new FieldInfo(substring, method6, null, cls, type, i12, i13, jSONField4, null, z4), z);
                            TypeUtils.setAccessible(cls, method6, i);
                        }
                        i30 = i8 + 1;
                        i29 = 4;
                        arrayList3 = arrayList2;
                        methodArr7 = methodArr4;
                        constructor15 = constructor7;
                        length7 = i9;
                        method3 = method5;
                        hashMap4 = hashMap;
                        fieldArr = fieldArr3;
                    }
                    hashMap = hashMap2;
                    fieldArr3 = fieldArr;
                    i30 = i8 + 1;
                    i29 = 4;
                    arrayList3 = arrayList2;
                    methodArr7 = methodArr4;
                    constructor15 = constructor7;
                    length7 = i9;
                    method3 = method5;
                    hashMap4 = hashMap;
                    fieldArr = fieldArr3;
                }
                i8 = i30;
                i9 = length7;
                hashMap = hashMap4;
                fieldArr3 = fieldArr;
                methodArr4 = methodArr7;
                method5 = method3;
                constructor7 = constructor15;
                arrayList2 = arrayList3;
                i30 = i8 + 1;
                i29 = 4;
                arrayList3 = arrayList2;
                methodArr7 = methodArr4;
                constructor15 = constructor7;
                length7 = i9;
                method3 = method5;
                hashMap4 = hashMap;
                fieldArr = fieldArr3;
            }
            fieldArr2 = fieldArr;
            methodArr3 = methodArr7;
            method4 = method3;
            constructor6 = constructor15;
            arrayList = arrayList3;
        } else {
            arrayList = arrayList3;
            fieldArr2 = fieldArr;
            methodArr3 = methodArr2;
            method4 = method3;
            constructor6 = constructor15;
        }
        Field[] fieldArr7 = fieldArr2;
        ArrayList arrayList5 = new ArrayList(fieldArr7.length);
        for (Field field5 : fieldArr7) {
            int modifiers2 = field5.getModifiers();
            if ((modifiers2 & 8) == 0) {
                if ((modifiers2 & 16) != 0) {
                    Class<?> type2 = field5.getType();
                    if (!(Map.class.isAssignableFrom(type2) || Collection.class.isAssignableFrom(type2))) {
                    }
                }
                if ((field5.getModifiers() & 1) != 0) {
                    arrayList5.add(field5);
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls10 = cls2;
            if (superclass == cls10) {
                break;
            }
            for (Field field6 : superclass.getDeclaredFields()) {
                int modifiers3 = field6.getModifiers();
                if ((modifiers3 & 8) == 0) {
                    if ((modifiers3 & 16) != 0) {
                        Class<?> type3 = field6.getType();
                        if (!(Map.class.isAssignableFrom(type3) || Collection.class.isAssignableFrom(type3))) {
                        }
                    }
                    if ((modifiers3 & 1) != 0) {
                        arrayList5.add(field6);
                    }
                }
            }
            superclass = superclass.getSuperclass();
            cls2 = cls10;
        }
        Iterator it = arrayList5.iterator();
        while (it.hasNext()) {
            Field field7 = (Field) it.next();
            String name3 = field7.getName();
            int size4 = arrayList.size();
            boolean z6 = false;
            for (int i31 = 0; i31 < size4; i31++) {
                if (((FieldInfo) arrayList.get(i31)).name.equals(name3)) {
                    z6 = true;
                }
            }
            if (!z6) {
                JSONField jSONField8 = z3 ? (JSONField) field7.getAnnotation(JSONField.class) : null;
                if (jSONField8 != null) {
                    int ordinal2 = jSONField8.ordinal();
                    int m4193of2 = SerializerFeature.m4193of(jSONField8.serialzeFeatures());
                    if (jSONField8.name().length() != 0) {
                        name3 = jSONField8.name();
                    }
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i6 = ordinal2;
                    i7 = m4193of2;
                } else {
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i6 = 0;
                    i7 = 0;
                }
                if (propertyNamingStrategy2 != null) {
                    name3 = propertyNamingStrategy2.translate(name3);
                }
                TypeUtils.setAccessible(cls, field7, i);
                addField(arrayList, new FieldInfo(name3, null, field7, cls, type, i6, i7, null, jSONField8, z4), z);
            }
        }
        if (!z) {
            Method[] methodArr8 = methodArr3;
            int length8 = methodArr8.length;
            int i32 = 0;
            while (i32 < length8) {
                Method method12 = methodArr8[i32];
                String name4 = method12.getName();
                if (name4.length() >= 4 && name4.startsWith("get") && Character.isUpperCase(name4.charAt(3)) && method12.getParameterTypes().length == 0) {
                    Class<?> returnType2 = method12.getReturnType();
                    if (Collection.class.isAssignableFrom(returnType2) || Map.class.isAssignableFrom(returnType2)) {
                        JSONField jSONField9 = z3 ? (JSONField) method12.getAnnotation(JSONField.class) : null;
                        if (jSONField9 != null) {
                            String name5 = jSONField9.name();
                            if (name5.length() > 0) {
                                str2 = name5;
                                JSONField jSONField10 = jSONField9;
                                i4 = i32;
                                i5 = length8;
                                addField(arrayList, new FieldInfo(str2, method12, null, cls, type, 0, 0, jSONField10, null, z4), z);
                                TypeUtils.setAccessible(cls, method12, i);
                                i32 = i4 + 1;
                                length8 = i5;
                            }
                        }
                        str2 = Character.toLowerCase(name4.charAt(3)) + name4.substring(4);
                        JSONField jSONField102 = jSONField9;
                        i4 = i32;
                        i5 = length8;
                        addField(arrayList, new FieldInfo(str2, method12, null, cls, type, 0, 0, jSONField102, null, z4), z);
                        TypeUtils.setAccessible(cls, method12, i);
                        i32 = i4 + 1;
                        length8 = i5;
                    }
                }
                i4 = i32;
                i5 = length8;
                i32 = i4 + 1;
                length8 = i5;
            }
        }
        int size5 = arrayList.size();
        FieldInfo[] fieldInfoArr7 = new FieldInfo[size5];
        arrayList.toArray(fieldInfoArr7);
        FieldInfo[] fieldInfoArr8 = new FieldInfo[size5];
        System.arraycopy(fieldInfoArr7, 0, fieldInfoArr8, 0, size5);
        Arrays.sort(fieldInfoArr8);
        return new JavaBeanInfo(cls, constructor6, constructor5, method4, fieldInfoArr7, fieldInfoArr8, z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null, strArr);
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] orders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        JSONType jSONType = this.jsonType;
        if (jSONType != null && (orders = jSONType.orders()) != null && orders.length != 0) {
            int i = 0;
            while (true) {
                if (i >= orders.length) {
                    z = true;
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= fieldInfoArr2.length) {
                        z4 = false;
                        break;
                    } else if (fieldInfoArr2[i2].name.equals(orders[i])) {
                        z4 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return fieldInfoArr2;
            }
            if (orders.length == fieldInfoArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= orders.length) {
                        z3 = true;
                        break;
                    } else if (!fieldInfoArr2[i3].name.equals(orders[i3])) {
                        z3 = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return fieldInfoArr2;
                }
                FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                for (int i4 = 0; i4 < orders.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= fieldInfoArr2.length) {
                            break;
                        } else if (fieldInfoArr2[i5].name.equals(orders[i4])) {
                            fieldInfoArr3[i4] = fieldInfoArr2[i5];
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                this.ordered = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i6 = 0; i6 < orders.length; i6++) {
                int i7 = 0;
                while (true) {
                    if (i7 >= fieldInfoArr2.length) {
                        break;
                    } else if (fieldInfoArr2[i7].name.equals(orders[i6])) {
                        fieldInfoArr4[i6] = fieldInfoArr2[i7];
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            int length2 = orders.length;
            for (int i8 = 0; i8 < fieldInfoArr2.length; i8++) {
                for (int i9 = 0; i9 < length && i9 < length2; i9++) {
                    if (fieldInfoArr4[i8].equals(fieldInfoArr2[i9])) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z2) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i8];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
