package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.tencent.smtt.utils.a */
/* loaded from: classes4.dex */
public class C1428a {
    /* renamed from: a */
    public static int m2139a(Context context, File file) {
        return m2138a(context, file, 0);
    }

    /* renamed from: a */
    public static int m2138a(Context context, File file, int i) {
        try {
            return m2136a(context, file, !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME), i);
        } catch (Exception unused) {
            TbsLog.m2155i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    /* renamed from: a */
    public static int m2136a(Context context, File file, boolean z, int i) {
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean contains = file.getName().contains("tbs.org");
                    boolean contains2 = file.getName().contains("x5.tbs.decouple");
                    if (contains || contains2) {
                        int m2132a = m2132a(contains2, file, i);
                        if (m2132a > 0) {
                            return m2132a;
                        }
                        if (!TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            return 0;
                        }
                    }
                    boolean z2 = (Build.VERSION.SDK_INT == 23 || Build.VERSION.SDK_INT == 25) && Build.MANUFACTURER.toLowerCase().contains("mi");
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z = false;
                        z2 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if (z || z2) {
                        int m2131b = m2131b(file);
                        if (m2131b > 0) {
                            return m2131b;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo == null) {
                return 0;
            }
            return packageArchiveInfo.versionCode;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public static int m2132a(boolean z, File file, int i) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            File[] listFiles = parentFile.listFiles();
            Pattern compile = Pattern.compile(m2133a(z, i) + "(.*)");
            for (File file2 : listFiles) {
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0068: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:35:0x0068 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2135a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream3 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    byte[] digest = messageDigest.digest();
                    int i2 = 0;
                    for (i = 0; i < 16; i++) {
                        byte b = digest[i];
                        int i3 = i2 + 1;
                        cArr2[i2] = cArr[(b >>> 4) & 15];
                        i2 = i3 + 1;
                        cArr2[i3] = cArr[b & 15];
                    }
                    String str = new String(cArr2);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream3 = fileInputStream2;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream3 != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static final String m2134a(boolean z) {
        return m2133a(z, 0);
    }

    /* renamed from: a */
    public static final String m2133a(boolean z, int i) {
        return i == 64 ? true : i == 32 ? false : C1429b.m2121b() ? z ? "x5.64.decouple.backup" : "x5.64.backup" : z ? "x5.decouple.backup" : "x5.backup";
    }

    /* renamed from: a */
    public static boolean m2137a(Context context, File file, long j, int i) {
        String str;
        if (file == null || !file.exists()) {
            str = "verifyTbsApk return false #1";
        } else if (j <= 0 || j == file.length()) {
            try {
                int m2139a = m2139a(context, file);
                if (i == m2139a) {
                    return "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(C1429b.m2126a(context, true, file));
                }
                TbsLog.m2155i("ApkUtil", "verifyTbsApk return false #3  versionCode is " + m2139a + " apkVersion is " + i);
                return false;
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("verifyTbsApk false  stack is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(e));
                str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
        } else {
            str = "verifyTbsApk return false #2";
        }
        TbsLog.m2155i("ApkUtil", str);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        r1 = r1[1].trim();
        com.tencent.smtt.utils.TbsLog.m2155i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "getApkVersionByReadFile version is " + r1);
        r1 = java.lang.Integer.parseInt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
        r7.close();
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b5, code lost:
        if (r2 != null) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.BufferedReader] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m2131b(File file) {
        JarFile jarFile;
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        String[] split;
        int parseInt;
        TbsLog.m2155i(TbsDownloader.LOGTAG, "getApkVersionByReadFile" + ((Object) file) + "exists:" + file.exists() + ";canread:" + file.canRead());
        synchronized (C1428a.class) {
            try {
                try {
                    try {
                        jarFile = new JarFile((File) file);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    jarFile = null;
                    e = e2;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    jarFile = null;
                    th = th3;
                    file = 0;
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(jarFile.getJarEntry("assets/webkit/tbs.conf"))));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                bufferedReader.close();
                                break;
                            } else if (readLine.contains("tbs_core_version") && (split = readLine.split("=")) != null && split.length == 2) {
                                break;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            TbsLog.m2152i(e);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    file = 0;
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (Exception unused) {
                            throw th;
                        }
                    }
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    throw th;
                }
                jarFile.close();
            } catch (Exception unused2) {
            }
            return -1;
        }
        return parseInt;
    }
}
