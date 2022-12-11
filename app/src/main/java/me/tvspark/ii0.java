package me.tvspark;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes4.dex */
public class ii0 {
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nullPointerException);
        throw nullPointerException;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " must not be null"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nullPointerException);
        throw nullPointerException;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("lateinit property ", str, " has not been initialized"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static <T extends Throwable> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) t, ii0.class.getName());
        return t;
    }

    public static <T extends Throwable> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nullPointerException);
        throw nullPointerException;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " must not be null"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illegalStateException);
        throw illegalStateException;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
