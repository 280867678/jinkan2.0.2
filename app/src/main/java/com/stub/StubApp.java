package com.stub;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.qihoo.util.C1040c;
import dalvik.system.DexFile;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class StubApp extends Application {

    /* renamed from: d */
    private static Context f669d;

    /* renamed from: a */
    private static Application f666a = null;
    public static String strEntryApplication = "entryRunApplication";

    /* renamed from: b */
    private static Application f667b = null;

    /* renamed from: c */
    private static String f668c = "libjiagu";
    private static boolean loadFromLib = false;
    private static boolean needX86Bridge = true;
    private static boolean returnIntern = true;
    public static boolean isMcIsolated = false;

    /* renamed from: e */
    private static String f670e = null;

    /* renamed from: f */
    private static String f671f = null;

    /* renamed from: g */
    private static String f672g = null;

    /* renamed from: h */
    private static String f673h = null;

    /* renamed from: i */
    private static String f674i = null;

    /* renamed from: j */
    private static Map<Integer, String> f675j = new ConcurrentHashMap();

    public static native void interface11(int i);

    public static native Enumeration<String> interface12(DexFile dexFile);

    public static native long interface13(int i, long j, long j2, long j3, int i2, int i3, long j4);

    public static native String interface14(int i);

    public static native AssetFileDescriptor interface17(AssetManager assetManager, String str);

    public static native InputStream interface18(Class cls, String str);

    public static native InputStream interface19(ClassLoader classLoader, String str);

    public static native void interface20();

    public static native void interface21(Application application);

    public static native void interface22(int i, String[] strArr, int[] iArr);

    public static native ZipEntry interface30(ZipFile zipFile, String str);

    public static native void interface5(Application application);

    public static native String interface6(String str);

    public static native boolean interface7(Application application, Context context);

    public static native boolean interface8(Application application, Context context);

    public static native Location mark(LocationManager locationManager, String str);

    public static native void mark();

    public static native void mark(Location location);

    public static native void n0110();

    public static native boolean n0111();

    public static native void n01110(int i);

    public static native void n011110(int i, int i2);

    public static native boolean n011111(int i, boolean z);

    public static native Object n0111233(int i, long j, Object obj);

    public static native long n01112332(int i, long j, Object obj, Object obj2);

    public static native Object n01113(int i);

    public static native int n0111331(int i, Object obj, Object obj2);

    public static native void n01120(long j);

    public static native int n011211(long j, int i);

    public static native int n011231(long j, Object obj);

    public static native Object n0113();

    public static native void n01130(Object obj);

    public static native int n01131(Object obj);

    public static native int n0113111(Object obj, int i, int i2);

    public static native int n01131211(Object obj, int i, long j, int i2);

    public static native void n0113130(Object obj, int i, Object obj2);

    public static native Object n0113133(Object obj, int i, Object obj2);

    public static native long n01132(Object obj);

    public static native Object n01132113(Object obj, long j, int i, boolean z);

    public static native Object n011323(Object obj, long j);

    public static native Object n01133(Object obj);

    public static native void n011330(Object obj, Object obj2);

    public static native boolean n011331(Object obj, Object obj2);

    public static native boolean n0113311(Object obj, Object obj2, boolean z);

    public static native int n0113311111(Object obj, Object obj2, boolean z, boolean z2, int i, boolean z3);

    public static native Object n011333(Object obj, Object obj2);

    public static native long n01133312(Object obj, Object obj2, Object obj3, int i);

    public static native Object n0113333(Object obj, Object obj2, Object obj3);

    public static native void pmark(Context context);

    public static native void rmark();

    public native synchronized void n11030(Object obj);

    public native void n1110();

    public native int n1111();

    public native void n11110(int i);

    public native boolean n11111(boolean z);

    public native void n111110(int i, int i2);

    public native int n111111(int i, int i2);

    public native void n1111110(int i, int i2, int i3);

    public native int n1111111(int i, int i2, int i3);

    public native void n11111110(int i, int i2, int i3, int i4);

    public native int n11111111(int i, int i2, int i3, int i4);

    public native void n111111110(int i, int i2, int i3, int i4, int i5);

    public native int n111111111(int i, int i2, int i3, int i4, int i5);

    public native int n11111111111(int i, int i2, int i3, int i4, int i5, int i6, float f);

    public native int n111111111111(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6);

    public native void n111111111111110(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    public native void n11111111111111110(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    public native void n111111111111111110(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    public native void n111111111111310(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj, int i10);

    public native void n11111111111310(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj, int i9);

    public native void n11111111130(int i, int i2, int i3, int i4, int i5, int i6, Object obj);

    public native void n1111111130(int i, int i2, int i3, int i4, int i5, Object obj);

    public native void n11111111310(int i, int i2, int i3, int i4, int i5, Object obj, int i6);

    public native void n1111111131111110(int i, int i2, int i3, int i4, int i5, Object obj, int i6, int i7, int i8, int i9, int i10, int i11);

    public native void n11111120(int i, int i2, int i3, double d);

    public native void n11111130(int i, int i2, int i3, Object obj);

    public native int n111111311(int i, int i2, int i3, Object obj, int i4);

    public native void n1111113130(int i, int i2, int i3, Object obj, int i4, Object obj2);

    public native void n1111130(int i, int i2, Object obj);

    public native int n1111131(int i, int i2, Object obj);

    public native void n111113330(int i, int i2, Object obj, Object obj2, Object obj3);

    public native void n111120(int i, long j);

    public native long n111122(int i, long j);

    public native Object n11113(int i);

    public native void n111130(int i, Object obj);

    public native int n111131(int i, Object obj);

    public native void n1111320(int i, Object obj, long j);

    public native void n1111330(int i, Object obj, Object obj2);

    public native boolean n11113311(int i, Object obj, Object obj2, int i2);

    public native int n11113331(int i, Object obj, Object obj2, Object obj3);

    public native int n111133311(int i, Object obj, Object obj2, Object obj3, int i2);

    public native int n1111333331(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    public native long n1112();

    public native void n11120(long j);

    public native Object n1113();

    public native void n11130(Object obj);

    public native boolean n11131(Object obj);

    public native void n111310(Object obj, int i);

    public native Object n1113113(Object obj, boolean z, int i);

    public native Object n11131333(Object obj, boolean z, Object obj2, Object obj3);

    public native void n111322110(Object obj, long j, long j2, int i, int i2);

    public native Object n11133(Object obj);

    public native void n111330(Object obj, Object obj2);

    public native boolean n111331(Object obj, Object obj2);

    public native void n11133110(Object obj, Object obj2, boolean z, int i);

    public native void n1113330(Object obj, Object obj2, Object obj3);

    public native boolean n1113331(Object obj, Object obj2, Object obj3);

    public native void n11133310(Object obj, Object obj2, Object obj3, int i);

    public native Object n1113333(Object obj, Object obj2, Object obj3);

    public static String getSoPath1() {
        return f671f;
    }

    public static String getSoPath2() {
        return f672g;
    }

    public static String getDir() {
        return f673h;
    }

    public static Context getAppContext() {
        return f669d;
    }

    public static Context getOrigApplicationContext(Context context) {
        if (context == f666a) {
            return f667b;
        }
        return context;
    }

    /* renamed from: a */
    private static Application m3639a(Context context) {
        ClassLoader classLoader;
        Class<?> loadClass;
        try {
            if (f667b == null && (classLoader = context.getClassLoader()) != null && (loadClass = classLoader.loadClass(strEntryApplication)) != null) {
                f667b = (Application) loadClass.newInstance();
            }
        } catch (Exception e) {
        }
        return f667b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // android.app.Application
    public final void onCreate() {
        System.currentTimeMillis();
        super.onCreate();
        if (!isMcIsolated) {
            try {
                interface7(f667b, f666a.getBaseContext());
            } catch (Exception e) {
            }
            if (f667b != null) {
                f667b.onCreate();
            }
            interface21(f667b);
            ?? r5 = this;
            if (f667b != null) {
                r5 = f667b;
            }
            Context context = f669d;
            if (r5 != 0 && context != null && C1040c.m3687a(context)) {
                try {
                    ?? declaredMethod = Class.forName(C1040c.m3683a("s\u007f}>zw>rx>Bu`\u007fbdcDy}u")).getDeclaredMethod(C1040c.m3683a("BuwycdubQsdyfydiSq||Rqs{c"), Application.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, new Object[]{r5});
                } catch (Exception e2) {
                }
            }
        }
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        boolean m3686a;
        System.currentTimeMillis();
        super.attachBaseContext(context);
        C1040c.m3682b();
        f669d = context;
        if (f666a == null) {
            f666a = this;
        }
        if (f667b == null) {
            Boolean valueOf = Boolean.valueOf(C1040c.m3688a());
            Boolean bool = false;
            Boolean bool2 = false;
            if (Build.CPU_ABI.contains("64") || Build.CPU_ABI2.contains("64")) {
                bool = true;
            }
            if (Build.CPU_ABI.contains("mips") || Build.CPU_ABI2.contains("mips")) {
                bool2 = true;
            }
            if (valueOf.booleanValue() && needX86Bridge) {
                System.loadLibrary("X86Bridge");
            }
            if (loadFromLib) {
                if (valueOf.booleanValue() && !needX86Bridge) {
                    System.loadLibrary("jiagu_x86");
                } else {
                    System.loadLibrary("jiagu");
                }
            } else {
                String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
                try {
                    absolutePath = context.getFilesDir().getParentFile().getCanonicalPath();
                } catch (Exception e) {
                }
                String str = absolutePath + "/.jiagu";
                f674i = m3638a(str, bool.booleanValue(), bool2.booleanValue());
                f670e = m3638a(str, false, false);
                f671f = str + File.separator + f670e;
                f672g = str + File.separator + f674i;
                f673h = str;
                if (bool2.booleanValue()) {
                    C1040c.m3686a(context, f668c + "_mips.so", str, f670e);
                } else if (valueOf.booleanValue() && !needX86Bridge) {
                    C1040c.m3686a(context, f668c + "_x86.so", str, f670e);
                } else {
                    C1040c.m3686a(context, f668c + ".so", str, f670e);
                }
                if (bool.booleanValue() && !bool2.booleanValue()) {
                    if (valueOf.booleanValue() && !needX86Bridge) {
                        m3686a = C1040c.m3686a(context, f668c + "_x64.so", str, f674i);
                    } else {
                        m3686a = C1040c.m3686a(context, f668c + "_a64.so", str, f674i);
                    }
                    if (m3686a) {
                        System.load(str + "/" + f674i);
                    } else {
                        System.load(str + "/" + f670e);
                    }
                } else {
                    System.load(str + "/" + f670e);
                }
            }
        }
        if (!isMcIsolated) {
            interface5(f666a);
            if (f667b == null) {
                f667b = m3639a(context);
                if (f667b != null) {
                    try {
                        Method declaredMethod = Application.class.getDeclaredMethod("attach", Context.class);
                        if (declaredMethod != null) {
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(f667b, context);
                        }
                        interface8(f667b, context);
                        return;
                    } catch (Exception e2) {
                        throw new RuntimeException("Failed to call attachBaseContext.", e2);
                    }
                }
                System.exit(1);
            }
        }
    }

    /* renamed from: a */
    private static String m3638a(String str, boolean z, boolean z2) {
        String str2 = f668c;
        if (Build.VERSION.SDK_INT < 23) {
            str2 = str2 + str.hashCode();
        }
        if (z && !z2) {
            return str2 + "_64.so";
        }
        return str2 + ".so";
    }

    public static String getString2(int i) {
        String str = f675j.get(Integer.valueOf(i));
        if (str == null) {
            str = interface14(i);
            f675j.put(Integer.valueOf(i), str);
        }
        if (str != null && returnIntern) {
            return str.intern();
        }
        return str;
    }

    public static String getString2(String str) {
        try {
            return getString2(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
