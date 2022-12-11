package com.tencent.bugly.beta.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.Signature;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes3.dex */
public class TinkerUtils {
    public static final int ERROR_PATCH_CONDITION_NOT_SATISFIED = -24;
    public static final int ERROR_PATCH_CRASH_LIMIT = -23;
    public static final int ERROR_PATCH_GOOGLEPLAY_CHANNEL = -20;
    public static final int ERROR_PATCH_MEMORY_LIMIT = -22;
    public static final int ERROR_PATCH_ROM_SPACE = -21;
    public static final int MIN_MEMORY_HEAP_SIZE = 45;
    public static final String PLATFORM = "platform";
    public static final String TAG = "Tinker.TinkerUtils";
    public static boolean background;

    /* loaded from: classes3.dex */
    public static class ScreenState {

        /* loaded from: classes3.dex */
        public interface IOnScreenOff {
            void onScreenOff();
        }

        public ScreenState(Context context, final IOnScreenOff iOnScreenOff) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    String action = intent == null ? "" : intent.getAction();
                    TinkerLog.i(TinkerUtils.TAG, "ScreenReceiver action [%s] ", new Object[]{action});
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        IOnScreenOff iOnScreenOff2 = iOnScreenOff;
                        if (iOnScreenOff2 != null) {
                            iOnScreenOff2.onScreenOff();
                        }
                        context2.unregisterReceiver(this);
                    }
                }
            }, intentFilter);
        }
    }

    public static String bytesToHexString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        Formatter formatter = new Formatter(stringBuffer);
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", Byte.valueOf(bArr[i]));
        }
        formatter.close();
        String stringBuffer2 = stringBuffer.toString();
        return z ? stringBuffer2.toUpperCase() : stringBuffer2.toLowerCase();
    }

    public static int checkForPatchRecover(long j, int i) {
        if (isGooglePlay()) {
            return -20;
        }
        if (i < 45) {
            return -22;
        }
        return !checkRomSpaceEnough(j) ? -21 : 0;
    }

    @Deprecated
    public static boolean checkRomSpaceEnough(long j) {
        long j2;
        long j3;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = statFs.getAvailableBlocks() * statFs.getBlockSize();
            try {
                j3 = statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception unused) {
                j3 = 0;
                return j3 == 0 ? false : false;
            }
        } catch (Exception unused2) {
            j2 = 0;
        }
        if (j3 == 0 && j2 > j) {
            return true;
        }
    }

    public static boolean copy(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            String absolutePath = file2.getAbsolutePath();
            File file3 = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator)));
            if (!file3.exists()) {
                file3.mkdirs();
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    bufferedOutputStream2.flush();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } catch (Throwable th) {
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream = bufferedOutputStream2;
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static String getExceptionCauseString(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th != null) {
            try {
                if (th.getCause() == null) {
                    break;
                }
                th = th.getCause();
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw th2;
            }
        }
        if (th != null) {
            th.printStackTrace(printStream);
        }
        String visualString = toVisualString(byteArrayOutputStream.toString());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return visualString;
    }

    public static String getSignature(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                MessageDigest.getInstance("SHA-1");
                return new String(x509Certificate.getEncoded());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isBackground() {
        return background;
    }

    public static boolean isGooglePlay() {
        return false;
    }

    public static boolean isXposedExists(Throwable th) {
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className != null && className.contains("de.robv.android.xposed.XposedBridge")) {
                return true;
            }
        }
        return false;
    }

    public static byte[] readBytes(InputStream inputStream) {
        try {
            byte[] bArr = new byte[512];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readJarEntry(File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && !TextUtils.isEmpty(str)) {
                    return readJarEntry(new JarFile(file), str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, String str) {
        if (jarFile != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return readJarEntry(jarFile, jarFile.getJarEntry(str));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, JarEntry jarEntry) {
        if (jarFile != null && jarEntry != null) {
            try {
                return readBytes(jarFile.getInputStream(jarEntry));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void rollbackPatch(Context context) {
        Tinker.with(context).rollbackPatch();
    }

    public static void setBackground(boolean z) {
        background = z;
    }

    public static String toVisualString(String str) {
        char[] charArray;
        boolean z;
        if (str == null || (charArray = str.toCharArray()) == null) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                z = false;
                break;
            } else if (charArray[i] > 127) {
                charArray[i] = 0;
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z ? new String(charArray, 0, i) : str;
    }
}
