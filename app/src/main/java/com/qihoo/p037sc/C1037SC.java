package com.qihoo.p037sc;

import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
@QVMProtect
/* renamed from: com.qihoo.sc.SC */
/* loaded from: classes6.dex */
public class C1037SC {
    public static Class artMethodClass;
    public static Field artMethodField;
    public static volatile ClassLoader initClassLoader;
    public static int testAccessFlag;
    public static Object testOffsetArtMethod1;
    public static Object testOffsetArtMethod2;
    public static Method testOffsetMethod1;
    public static Method testOffsetMethod2;

    static {
        StubApp.interface11(15908);
    }

    /* renamed from: b */
    public static native void m3689b();

    public static native void check(Member member);

    public static native long getArtMethod(Member member);

    public static native Field getField(Class cls, String str) throws NoSuchFieldException;

    public static native Object getJavaMethod(String str, String str2);

    public static native boolean hasJavaArtMethod();

    public static native void init();

    private static native void initTestAccessFlag();

    public static native void initTestOffset();

    private static native void loadArtMethod();
}
