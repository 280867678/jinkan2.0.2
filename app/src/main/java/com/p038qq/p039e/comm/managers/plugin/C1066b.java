package com.p038qq.p039e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.p038qq.p039e.comm.constants.CustomPkgConstants;
import com.p038qq.p039e.comm.constants.Sig;
import com.p038qq.p039e.comm.managers.status.SDKStatus;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.qq.e.comm.managers.plugin.b */
/* loaded from: classes3.dex */
public class C1066b {
    public static volatile String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, File file, File file2) throws Throwable {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        boolean z;
        AssetManager assets = context.getAssets();
        FileOutputStream fileOutputStream2 = null;
        try {
            C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            boolean z2 = false;
            if (Arrays.binarySearch(assets.list("gdt_plugin"), "gdtadv2.jar") >= 0) {
                String str = "gdt_plugin" + File.separator + "gdtadv2.jar";
                String str2 = Sig.ASSET_PLUGIN_SIG;
                if (str2 == null) {
                    str2 = "";
                }
                C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SDKStatus.getBuildInPluginVersion() + "#####" + str2, file2);
                if (!TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                    fileOutputStream = assets.open(str);
                    try {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                            byte[] bArr = new byte[1024];
                            int length = bytes.length;
                            int i = 0;
                            int i2 = 0;
                            while (true) {
                                int read = fileOutputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                int i3 = 0;
                                while (i3 < read) {
                                    int i4 = i2 + 1;
                                    if (i2 >= 64) {
                                        bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                        i++;
                                    }
                                    i3++;
                                    i2 = i4;
                                }
                                fileOutputStream3.write(bArr, 0, read);
                            }
                            z = true;
                            fileOutputStream2 = fileOutputStream3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (fileOutputStream2) {
                                throw new Exception("Plugin prepare failed");
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream3;
                            try {
                                GDTLogger.m3645e("插件加载失败", th);
                                throw th;
                            } finally {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        inputStream = fileOutputStream;
                        th = th3;
                        InputStream inputStream2 = inputStream;
                        th = th;
                        fileOutputStream = inputStream2;
                        GDTLogger.m3645e("插件加载失败", th);
                        throw th;
                    }
                }
                z2 = C1074h.m3648a(assets.open(str), file);
            }
            fileOutputStream = null;
            z = z2;
            if (fileOutputStream != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* renamed from: a */
    public static synchronized String m3658a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        synchronized (C1066b.class) {
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (Build.VERSION.SDK_INT >= 28) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Application.getProcessName();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                int myPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (it.hasNext()) {
                        try {
                            next = it.next();
                        } catch (Exception unused) {
                        }
                        if (next.pid == myPid) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = next.processName;
                            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        continue;
                    }
                }
                return null;
            }
        }
    }

    /* renamed from: a */
    public static synchronized String m3657a(String str) {
        synchronized (C1066b.class) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            boolean endsWith = str2.endsWith("_");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(endsWith ? "" : "_");
            String str3 = null;
            try {
                String str4 = new String(str2);
                try {
                    str3 = C1070d.m3654a(MessageDigest.getInstance(LitePalSupport.MD5).digest(str4.getBytes("UTF-8")));
                } catch (Exception unused) {
                    str3 = str4;
                }
            } catch (Exception unused2) {
            }
            sb.append(str3);
            return sb.toString();
        }
    }
}
