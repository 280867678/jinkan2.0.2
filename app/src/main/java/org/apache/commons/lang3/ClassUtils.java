package org.apache.commons.lang3;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.mutable.MutableObject;
import org.mozilla.javascript.optimizer.OptRuntime;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes4.dex */
public class ClassUtils {
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final Map<String, String> abbreviationMap;
    public static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    public static final Map<String, String> reverseAbbreviationMap;
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
    public static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap();

    /* loaded from: classes4.dex */
    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    static {
        HashMap hashMap = new HashMap();
        primitiveWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = primitiveWrapperMap;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        for (Class<?> cls2 : primitiveWrapperMap.keySet()) {
            Class<?> cls3 = primitiveWrapperMap.get(cls2);
            if (!cls2.equals(cls3)) {
                wrapperPrimitiveMap.put(cls3, cls2);
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ClassTransform.INTEGER, OptRuntime.GeneratorState.resumptionPoint_TYPE);
        hashMap2.put(ClassTransform.BOOLEAN, "Z");
        hashMap2.put(ClassTransform.FLOAT, "F");
        hashMap2.put(ClassTransform.LONG, "J");
        hashMap2.put(ClassTransform.SHORT, ExifInterface.LATITUDE_SOUTH);
        hashMap2.put(ClassTransform.BYTE, "B");
        hashMap2.put(ClassTransform.DOUBLE, "D");
        hashMap2.put(ClassTransform.CHARACTER, "C");
        hashMap2.put(ClassTransform.VOID, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap2.entrySet()) {
            hashMap3.put(entry.getValue(), entry.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(hashMap2);
        reverseAbbreviationMap = Collections.unmodifiableMap(hashMap3);
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            try {
                arrayList.add(Class.forName(str));
            } catch (Exception unused) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<?> cls : list) {
            if (cls == null) {
                arrayList.add(null);
            } else {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return arrayList;
            }
            arrayList.add(cls);
        }
    }

    public static String getCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            return null;
        }
        int i = 0;
        while (deleteWhitespace.startsWith("[")) {
            i++;
            deleteWhitespace = deleteWhitespace.substring(1);
        }
        if (i < 1) {
            return deleteWhitespace;
        }
        if (deleteWhitespace.startsWith("L")) {
            deleteWhitespace = deleteWhitespace.substring(1, deleteWhitespace.endsWith(";") ? deleteWhitespace.length() - 1 : deleteWhitespace.length());
        } else if (deleteWhitespace.length() > 0) {
            deleteWhitespace = reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
        }
        StringBuilder sb = new StringBuilder(deleteWhitespace);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        try {
            if (!abbreviationMap.containsKey(str)) {
                return Class.forName(toCanonicalName(str), z, classLoader);
            }
            return Class.forName("[" + abbreviationMap.get(str), z, classLoader).getComponentType();
        } catch (ClassNotFoundException e) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    return getClass(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1), z);
                } catch (ClassNotFoundException unused) {
                    throw e;
                }
            }
            throw e;
        }
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    public static Class<?> getClass(String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return getClass(contextClassLoader, str, z);
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(Class<?> cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    public static String getPackageName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
            str = str.substring(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException, NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                }
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't find a public method for ", str, StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ArrayUtils.toString(clsArr));
        throw new NoSuchMethodException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static String getShortCanonicalName(Class<?> cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getName());
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getName());
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(Class<?> cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    public static String getShortClassName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            if (reverseAbbreviationMap.containsKey(str)) {
                str = reverseAbbreviationMap.get(str);
            }
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            i = lastIndexOf + 1;
        }
        int indexOf = str.indexOf(36, i);
        String substring = str.substring(lastIndexOf + 1);
        if (indexOf != -1) {
            substring = substring.replace('$', '.');
        }
        return substring + ((Object) sb);
    }

    public static String getSimpleName(Class<?> cls) {
        return cls == null ? "" : cls.getSimpleName();
    }

    public static String getSimpleName(Object obj, String str) {
        return obj == null ? str : getSimpleName(obj.getClass());
    }

    public static Iterable<Class<?>> hierarchy(Class<?> cls) {
        return hierarchy(cls, Interfaces.EXCLUDE);
    }

    public static Iterable<Class<?>> hierarchy(final Class<?> cls, Interfaces interfaces) {
        final Iterable<Class<?>> iterable = new Iterable<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1
            @Override // java.lang.Iterable
            public Iterator<Class<?>> iterator() {
                final MutableObject mutableObject = new MutableObject(cls);
                return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return mutableObject.mo5179getValue() != null;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    /* renamed from: next */
                    public Class<?> mo5125next() {
                        Class<?> cls2 = (Class) mutableObject.mo5179getValue();
                        mutableObject.setValue(cls2.getSuperclass());
                        return cls2;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
        return interfaces != Interfaces.INCLUDE ? iterable : new Iterable<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2
            @Override // java.lang.Iterable
            public Iterator<Class<?>> iterator() {
                final HashSet hashSet = new HashSet();
                final Iterator it = iterable.iterator();
                return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2.1
                    public Iterator<Class<?>> interfaces = Collections.emptySet().iterator();

                    private void walkInterfaces(Set<Class<?>> set, Class<?> cls2) {
                        Class<?>[] interfaces2;
                        for (Class<?> cls3 : cls2.getInterfaces()) {
                            if (!hashSet.contains(cls3)) {
                                set.add(cls3);
                            }
                            walkInterfaces(set, cls3);
                        }
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.interfaces.hasNext() || it.hasNext();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    /* renamed from: next */
                    public Class<?> mo5126next() {
                        if (this.interfaces.hasNext()) {
                            Class<?> next = this.interfaces.next();
                            hashSet.add(next);
                            return next;
                        }
                        Class<?> cls2 = (Class) it.next();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        walkInterfaces(linkedHashSet, cls2);
                        this.interfaces = linkedHashSet.iterator();
                        return cls2;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (Integer.TYPE.equals(cls)) {
            return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        } else if (Long.TYPE.equals(cls)) {
            return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
            return false;
        } else {
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            } else if (Short.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            } else if (!Byte.TYPE.equals(cls)) {
                return false;
            } else {
                return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
        }
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        return isAssignable(clsArr, clsArr2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!ArrayUtils.isSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignable(clsArr[i], clsArr2[i], z)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || isPrimitiveWrapper(cls);
    }

    public static boolean isPrimitiveWrapper(Class<?> cls) {
        return wrapperPrimitiveMap.containsKey(cls);
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : primitiveWrapperMap.get(cls);
    }

    public static Class<?>[] primitivesToWrappers(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = primitiveToWrapper(clsArr[i]);
        }
        return clsArr2;
    }

    public static String toCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace != null) {
            if (!deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                return deleteWhitespace;
            }
            StringBuilder sb = new StringBuilder();
            while (deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
                sb.append("[");
            }
            String str2 = abbreviationMap.get(deleteWhitespace);
            if (str2 != null) {
                sb.append(str2);
            } else {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "L", deleteWhitespace, ";");
            }
            return sb.toString();
        }
        throw new NullPointerException("className must not be null.");
    }

    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return wrapperPrimitiveMap.get(cls);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = wrapperToPrimitive(clsArr[i]);
        }
        return clsArr2;
    }
}
