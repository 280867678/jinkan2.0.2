package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import me.tvspark.outline;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

/* loaded from: classes4.dex */
public class ObjectUtils {
    public static final Null NULL = new Null();

    /* loaded from: classes4.dex */
    public static class Null implements Serializable {
        public static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static byte CONST(byte b) {
        return b;
    }

    public static char CONST(char c) {
        return c;
    }

    public static double CONST(double d) {
        return d;
    }

    public static float CONST(float f) {
        return f;
    }

    public static int CONST(int i) {
        return i;
    }

    public static long CONST(long j) {
        return j;
    }

    public static <T> T CONST(T t) {
        return t;
    }

    public static short CONST(short s) {
        return s;
    }

    public static boolean CONST(boolean z) {
        return z;
    }

    public static byte CONST_BYTE(int i) throws IllegalArgumentException {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Supplied value must be a valid byte literal between -128 and 127: [", i, "]"));
        }
        return (byte) i;
    }

    public static short CONST_SHORT(int i) throws IllegalArgumentException {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Supplied value must be a valid byte literal between -32768 and 32767: [", i, "]"));
        }
        return (short) i;
    }

    public static <T> T clone(T t) {
        if (t instanceof Cloneable) {
            if (!t.getClass().isArray()) {
                try {
                    return (T) t.getClass().getMethod("clone", new Class[0]).invoke(t, new Object[0]);
                } catch (IllegalAccessException e) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot clone Cloneable type ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(t.getClass().getName());
                    throw new CloneFailedException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
                } catch (NoSuchMethodException e2) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cloneable type ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(t.getClass().getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" has no clone method");
                    throw new CloneFailedException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e2);
                } catch (InvocationTargetException e3) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Exception cloning Cloneable type ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(t.getClass().getName());
                    throw new CloneFailedException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), e3.getCause());
                }
            }
            Class<?> componentType = t.getClass().getComponentType();
            if (!componentType.isPrimitive()) {
                return (T) ((Object[]) t).clone();
            }
            int length = Array.getLength(t);
            T t2 = (T) Array.newInstance(componentType, length);
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return t2;
                }
                Array.set(t2, i, Array.get(t, i));
                length = i;
            }
        } else {
            return null;
        }
    }

    public static <T> T cloneIfPossible(T t) {
        T t2 = (T) clone(t);
        return t2 == null ? t : t2;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        return compare(t, t2, false);
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        return t == null ? z ? 1 : -1 : t2 == null ? z ? -1 : 1 : t.compareTo(t2);
    }

    public static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static <T> T firstNonNull(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            return null;
        }
        return null;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int i = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                i = (i * 31) + hashCode(obj);
            }
        }
        return i;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        identityToString(sb, obj);
        return sb.toString();
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        if (obj != null) {
            appendable.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static void identityToString(StringBuilder sb, Object obj) {
        if (obj != null) {
            sb.append(obj.getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static void identityToString(StrBuilder strBuilder, Object obj) {
        if (obj != null) {
            strBuilder.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, false) > 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, true) < 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    public static <T> T mode(T... tArr) {
        if (ArrayUtils.isNotEmpty(tArr)) {
            HashMap hashMap = new HashMap(tArr.length);
            int i = 0;
            for (T t : tArr) {
                MutableInt mutableInt = (MutableInt) hashMap.get(t);
                if (mutableInt == null) {
                    hashMap.put(t, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            while (true) {
                T t2 = null;
                for (Map.Entry entry : hashMap.entrySet()) {
                    int intValue = ((MutableInt) entry.getValue()).intValue();
                    if (intValue == i) {
                        break;
                    } else if (intValue > i) {
                        t2 = (T) entry.getKey();
                        i = intValue;
                    }
                }
                return t2;
            }
        }
        return null;
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    public String toString() {
        return super.toString();
    }
}
