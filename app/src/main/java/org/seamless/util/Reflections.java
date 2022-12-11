package org.seamless.util;

import com.umeng.analytics.pro.C1543ak;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Reflections {
    public static Class classForName(String str) throws ClassNotFoundException {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(str);
        } catch (Exception unused) {
            return Class.forName(str);
        }
    }

    public static String decapitalize(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object get(Field field, Object obj) throws Exception {
        boolean isAccessible = field.isAccessible();
        try {
            try {
                field.setAccessible(true);
                return field.get(obj);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Could not get field value by reflection: " + toString(field) + " on: " + obj.getClass().getName(), e);
            }
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    public static Object getAndWrap(Field field, Object obj) {
        boolean isAccessible = field.isAccessible();
        try {
            try {
                field.setAccessible(true);
                return get(field, obj);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new IllegalArgumentException("exception setting: " + field.getName(), e);
            }
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    public static Class<?> getClass(Type type) {
        Class<?> cls;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if ((type instanceof GenericArrayType) && (cls = getClass(((GenericArrayType) type).getGenericComponentType())) != null) {
            return Array.newInstance(cls, 0).getClass();
        }
        return null;
    }

    public static Class getCollectionElementType(Type type) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 0) {
                throw new IllegalArgumentException("no type arguments for collection type");
            }
            Type type2 = actualTypeArguments.length == 1 ? actualTypeArguments[0] : actualTypeArguments[1];
            if (type2 instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type2).getRawType();
            }
            if (!(type2 instanceof Class)) {
                throw new IllegalArgumentException("type argument not a class");
            }
            return (Class) type2;
        }
        throw new IllegalArgumentException("collection type not parameterized");
    }

    public static Field getField(Class cls, String str) {
        while (cls != null && cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static List<Field> getFields(Class cls, Class cls2) {
        Field[] declaredFields;
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(cls2)) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Method getGetterMethod(Class cls, String str) {
        Method[] declaredMethods;
        while (cls != null && cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                String name = method.getName();
                if (method.getParameterTypes().length == 0) {
                    if (name.startsWith("get")) {
                        if (decapitalize(name.substring(3)).equals(str)) {
                            return method;
                        }
                    } else if (name.startsWith(C1543ak.f2994ae) && decapitalize(name.substring(2)).equals(str)) {
                        return method;
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Class getMapKeyType(Type type) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 0) {
                throw new IllegalArgumentException("no type arguments for collection type");
            }
            Type type2 = actualTypeArguments[0];
            if (!(type2 instanceof Class)) {
                throw new IllegalArgumentException("type argument not a class");
            }
            return (Class) type2;
        }
        throw new IllegalArgumentException("collection type not parameterized");
    }

    public static Method getMethod(Class cls, String str) {
        for (Class cls2 = cls; cls2 != null && cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                return cls2.getDeclaredMethod(str, new Class[0]);
            } catch (NoSuchMethodException unused) {
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No such method: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('.');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static Method getMethod(Annotation annotation, String str) {
        try {
            return annotation.annotationType().getMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static String getMethodPropertyName(String str) {
        String substring;
        if (!str.startsWith("get")) {
            if (str.startsWith(C1543ak.f2994ae)) {
                substring = str.substring(2);
                return decapitalize(substring);
            } else if (!str.startsWith("set")) {
                return null;
            }
        }
        substring = str.substring(3);
        return decapitalize(substring);
    }

    public static List<Method> getMethods(Class cls, Class cls2) {
        Method[] declaredMethods;
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(cls2)) {
                    arrayList.add(method);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Method getSetterMethod(Class cls, String str) {
        Method[] methods;
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (name.startsWith("set") && method.getParameterTypes().length == 1 && decapitalize(name.substring(3)).equals(str)) {
                return method;
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no such setter method: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('.');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<Class<?>> getTypeArguments(Class<T> cls, Class<? extends T> cls2) {
        int i;
        HashMap hashMap = new HashMap();
        while (true) {
            i = 0;
            if (getClass(cls2).equals(cls)) {
                break;
            } else if (cls2 instanceof Class) {
                cls2 = ((Class) cls2).getGenericSuperclass();
            } else {
                ParameterizedType parameterizedType = cls2;
                Class cls3 = (Class) parameterizedType.getRawType();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                TypeVariable<Class<T>>[] typeParameters = cls3.getTypeParameters();
                while (i < actualTypeArguments.length) {
                    hashMap.put(typeParameters[i], actualTypeArguments[i]);
                    i++;
                }
                if (!cls3.equals(cls)) {
                    cls2 = cls3.getGenericSuperclass();
                }
            }
        }
        Type[] typeParameters2 = cls2 instanceof Class ? ((Class) cls2).getTypeParameters() : ((ParameterizedType) cls2).getActualTypeArguments();
        ArrayList arrayList = new ArrayList();
        int length = typeParameters2.length;
        while (i < length) {
            Type type = typeParameters2[i];
            while (hashMap.containsKey(type)) {
                type = (Type) hashMap.get(type);
            }
            arrayList.add(getClass(type));
            i++;
        }
        return arrayList;
    }

    public static boolean instanceOf(Class cls, String str) {
        if (str.equals(cls.getName())) {
            return true;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        boolean z = false;
        for (int i = 0; i < interfaces.length && !z; i++) {
            z = instanceOf(interfaces[i], str);
        }
        return z;
    }

    public static Object invoke(Method method, Object obj, Object... objArr) throws Exception {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalArgumentException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not invoke method by reflection: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString(method));
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (objArr != null && objArr.length > 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " with parameters: (");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toClassNameString(", ", objArr));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " on: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.getClass().getName());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e);
        } catch (InvocationTargetException e2) {
            if (!(e2.getCause() instanceof Exception)) {
                throw e2;
            }
            throw ((Exception) e2.getCause());
        }
    }

    public static Object invokeAndWrap(Method method, Object obj, Object... objArr) {
        try {
            return invoke(method, obj, objArr);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("exception invoking: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(method.getName());
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public static boolean isClassAvailable(String str) {
        try {
            classForName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isInstanceOf(Class cls, String str) {
        if (str != null) {
            while (cls != Object.class) {
                if (instanceOf(cls, str)) {
                    return true;
                }
                cls = cls.getSuperclass();
            }
            return false;
        }
        throw new IllegalArgumentException("name cannot be null");
    }

    public static void set(Field field, Object obj, Object obj2) throws Exception {
        String str;
        boolean isAccessible = field.isAccessible();
        try {
            try {
                field.setAccessible(true);
                field.set(obj, obj2);
            } catch (IllegalArgumentException e) {
                String str2 = "Could not set field value by reflection: " + toString(field) + " on: " + field.getDeclaringClass().getName();
                if (obj2 == null) {
                    str = str2 + " with null value";
                } else {
                    str = str2 + " with value: " + obj2.getClass();
                }
                throw new IllegalArgumentException(str, e);
            }
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    public static void setAndWrap(Field field, Object obj, Object obj2) {
        boolean isAccessible = field.isAccessible();
        try {
            try {
                field.setAccessible(true);
                set(field, obj, obj2);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new IllegalArgumentException("exception setting: " + field.getName(), e);
            }
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    public static String toClassNameString(String str, Object... objArr) {
        if (objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            sb.append(str);
            sb.append(obj == null ? "null" : obj.getClass().getName());
        }
        return sb.substring(str.length());
    }

    public static String toString(Member member) {
        return unqualify(member.getDeclaringClass().getName()) + '.' + member.getName();
    }

    public static String unqualify(String str) {
        return unqualify(str, '.');
    }

    public static String unqualify(String str, char c) {
        return str.substring(str.lastIndexOf(c) + 1, str.length());
    }
}
