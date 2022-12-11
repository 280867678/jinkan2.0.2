package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.utils.RunnableC1464l;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DexLoader {
    public static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    public static final String TAF_PACKAGE_PREFIX = "com.taf";
    public static final String TAG = "DexLoader";
    public static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    public static final String TBS_WEBVIEW_DEX = "webview_dex";
    public static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    public static boolean mCanUseDexLoaderProviderService = true;
    public static boolean mMttClassUseCorePrivate;
    public static boolean mUseSpeedyClassLoader;
    public static boolean mUseTbsCorePrivateClassLoader;
    public DexClassLoader mClassLoader;

    /* loaded from: classes3.dex */
    public static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            ClassLoader parent;
            if (str != null) {
                boolean startsWith = str.startsWith(DexLoader.JAVACORE_PACKAGE_PREFIX);
                if (DexLoader.mMttClassUseCorePrivate) {
                    startsWith = startsWith || str.startsWith(DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(DexLoader.TAF_PACKAGE_PREFIX);
                }
                if (!startsWith) {
                    return super.loadClass(str, z);
                }
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass != null) {
                    return findLoadedClass;
                }
                try {
                    findLoadedClass = findClass(str);
                } catch (ClassNotFoundException unused) {
                }
                return (findLoadedClass != null || (parent = getParent()) == null) ? findLoadedClass : parent.loadClass(str);
            }
            return super.loadClass(str, z);
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        DexClassLoader classLoader = dexLoader.getClassLoader();
        for (String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        str3 = !TextUtils.isEmpty(str2) ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3), File.pathSeparator, str2) : str3;
        DexClassLoader dexClassLoader = classLoader;
        for (String str4 : strArr) {
            dexClassLoader = createDexClassLoader(str4, str, str3, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        callingClassLoader = callingClassLoader == null ? context.getClassLoader() : callingClassLoader;
        String str3 = "Set base classLoader for DexClassLoader: " + callingClassLoader;
        DexClassLoader dexClassLoader = callingClassLoader;
        for (String str4 : strArr) {
            dexClassLoader = createDexClassLoader(str4, str2, str, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0162, code lost:
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019b  */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        DexClassLoader dexClassLoader;
        RunnableC1464l runnableC1464l;
        RunnableC1464l runnableC1464l2;
        int i;
        String str4;
        String str5;
        RunnableC1464l runnableC1464l3;
        int i2;
        String string;
        String string2;
        File file;
        String fileNameNoEx;
        StringBuilder sb;
        if (Build.VERSION.SDK_INT >= 29) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_code");
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_name");
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_display");
            SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_oat_status", 0);
            File file2 = new File(str);
            File file3 = new File(context.getDir("tbs", 0), "core_private");
            RunnableC1464l runnableC1464l4 = -1;
            try {
                try {
                    int i3 = sharedPreferences.getInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1);
                    String string3 = sharedPreferences.getString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "");
                    String string4 = sharedPreferences.getString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, "");
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    i = packageInfo.versionCode;
                    str4 = packageInfo.versionName;
                    str5 = Build.DISPLAY;
                    if (i == i3 && str4.equals(string3) && str5.equals(string4)) {
                        runnableC1464l2 = null;
                    }
                    runnableC1464l = new RunnableC1464l(file3, file2.getName() + "_loading.lock");
                    try {
                        runnableC1464l.m2027b();
                        i2 = sharedPreferences.getInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1);
                        string = sharedPreferences.getString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "");
                        string2 = sharedPreferences.getString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, "");
                    } catch (Exception e) {
                        e = e;
                        runnableC1464l3 = runnableC1464l;
                    } catch (Throwable th) {
                        th = th;
                        runnableC1464l3 = runnableC1464l;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    if (i == i2) {
                        try {
                            if (str4.equals(string)) {
                                if (str5.equals(string2)) {
                                    runnableC1464l3 = runnableC1464l;
                                    runnableC1464l2 = runnableC1464l3;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (runnableC1464l != null) {
                                runnableC1464l2 = runnableC1464l;
                                runnableC1464l2.m2024e();
                            }
                            if (shouldUseTbsCorePrivateClassLoader(str)) {
                            }
                            String str6 = "createDexClassLoader result: " + dexClassLoader;
                            return dexClassLoader;
                        }
                    }
                    sb.append(file2.getName());
                    sb.append(".prof");
                    File file4 = new File(file, sb.toString());
                    File file5 = new File(file, file2.getName() + ".cur.prof");
                    File file6 = new File(file, "arm");
                    File file7 = new File(file6, fileNameNoEx + ".odex");
                    File file8 = new File(file6, fileNameNoEx + ".vdex");
                    delete(file4);
                    delete(file5);
                    delete(file7);
                    delete(file8);
                    String str7 = "delete file:" + file4 + file5 + file7 + file8;
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str4);
                    edit.putInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
                    edit.putString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, str5);
                    edit.commit();
                    runnableC1464l2 = runnableC1464l3;
                } catch (Exception e3) {
                    e = e3;
                    runnableC1464l = runnableC1464l3;
                    e.printStackTrace();
                    if (runnableC1464l != null) {
                    }
                    if (shouldUseTbsCorePrivateClassLoader(str)) {
                    }
                    String str62 = "createDexClassLoader result: " + dexClassLoader;
                    return dexClassLoader;
                } catch (Throwable th3) {
                    th = th3;
                    runnableC1464l4 = runnableC1464l3;
                    if (runnableC1464l4 != 0) {
                        runnableC1464l4.m2024e();
                    }
                    throw th;
                }
                file = new File(file2.getParent(), "oat");
                fileNameNoEx = getFileNameNoEx(file2.getName());
                sb = new StringBuilder();
                runnableC1464l3 = runnableC1464l;
            } catch (Exception e4) {
                e = e4;
                runnableC1464l = null;
            } catch (Throwable th4) {
                th = th4;
                runnableC1464l4 = 0;
            }
        }
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            dexClassLoader = new TbsCorePrivateClassLoader(str, str2, str3, classLoader);
        } else if (Build.VERSION.SDK_INT > 25 || !mUseSpeedyClassLoader) {
            dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
        } else {
            try {
                dexClassLoader = DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
            } catch (Throwable th5) {
                String str8 = "createDexClassLoader exception: " + th5;
                dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
            }
        }
        String str622 = "createDexClassLoader result: " + dexClassLoader;
        return dexClassLoader;
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            delete(file2);
        }
        file.delete();
    }

    public static String getFileNameNoEx(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length()) ? str : str.substring(0, lastIndexOf);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        String str = "initTbsSettings - " + map;
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRAVITE_MTT_CLASSES);
                if (!(obj4 instanceof Boolean)) {
                    return;
                }
                mMttClassUseCorePrivate = ((Boolean) obj4).booleanValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (!mUseTbsCorePrivateClassLoader) {
            return false;
        }
        return str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX);
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 != null && str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                return th;
            }
            return null;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if (!"com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                return null;
            }
            return th;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable unused) {
        }
    }
}
