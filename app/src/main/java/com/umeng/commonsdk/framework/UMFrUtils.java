package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.C1795a;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;

/* loaded from: classes4.dex */
public class UMFrUtils {
    public static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    public static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    public static String mDefaultEnvelopeDir = "envelope";
    public static String mDefaultEnvelopeDirPath = null;
    public static Object mEnvelopeBuildTimeLock = new Object();
    public static Object mEnvelopeFileLock = new Object();
    public static String sCurrentProcessName = "";

    public static boolean checkPermission(Context context, String str) {
        boolean z = false;
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                        return false;
                    }
                } else if (origApplicationContext.getPackageManager().checkPermission(str, origApplicationContext.getPackageName()) != 0) {
                    return false;
                }
                z = true;
                return true;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(origApplicationContext, th);
                return z;
            }
        }
        return false;
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                int myPid = Process.myPid();
                String processName = getProcessName(myPid);
                if (!TextUtils.isEmpty(processName)) {
                    sCurrentProcessName = processName;
                } else {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.pid == myPid) {
                                sCurrentProcessName = runningAppProcessInfo.processName;
                                break;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(StubApp.getOrigApplicationContext(context.getApplicationContext()), th);
            }
        }
        return sCurrentProcessName;
    }

    public static long getDistanceDays(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.m550d("--->>> Create Envelope Directory failed!!!");
                }
                str = mDefaultEnvelopeDirPath;
            }
        }
        return str;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                        if (i > 0) {
                            return 1;
                        }
                        return i == 0 ? 0 : -1;
                    }
                });
                return listFiles[0];
            }
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        String processName;
        try {
            processName = getProcessName(Process.myPid());
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (!TextUtils.isEmpty(processName)) {
            String replace = processName.replace(':', '_');
            ULog.m550d("--->>> getEnvelopeDir: use current process name as envelope directory.");
            return replace;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                ULog.m550d("--->>> getEnvelopeDir: can't get process name, use default envelope directory.");
                return mDefaultEnvelopeDir;
            } else if (runningAppProcesses.size() == 0) {
                return mDefaultEnvelopeDir;
            } else {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        String replace2 = runningAppProcessInfo.processName.replace(':', '_');
                        ULog.m550d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                        return replace2;
                    }
                }
            }
        }
        return mDefaultEnvelopeDir;
    }

    public static String getProcessName(int i) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return readLine;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static String getSubProcessName(Context context) {
        String str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(":");
            if (indexOf >= 0) {
                str = currentProcessName.substring(indexOf + 1);
            }
            if (indexOf < 0) {
                String packageName = context.getPackageName();
                return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(StubApp.getOrigApplicationContext(context.getApplicationContext()), th);
        }
        return str;
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        String str = uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL ? C1543ak.f2966aC : "a";
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = C1543ak.f2967aD;
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath != null) {
            File file = new File(envelopeDirPath);
            synchronized (mEnvelopeFileLock) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.getName().startsWith(str)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(StubApp.getOrigApplicationContext(context.getApplicationContext()), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                if (file.exists()) {
                    return file.delete();
                }
            }
            return true;
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > i) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i2 = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                        if (i2 > 0) {
                            return 1;
                        }
                        return i2 == 0 ? 0 : -1;
                    }
                });
                if (listFiles.length > i) {
                    for (int i2 = 0; i2 < listFiles.length - i; i2++) {
                        if (!listFiles[i2].delete()) {
                            ULog.m550d("--->>> remove [" + i2 + "] file fail.");
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return 101;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getEnvelopeDirPath(context));
        File file = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, str));
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                boolean m433a = C1795a.m434a(context).m433a(str);
                boolean m431b = C1795a.m434a(context).m431b(str);
                if (m433a) {
                    updateLastSuccessfulBuildTime(context);
                }
                if (m431b) {
                    updateLastInstantBuildTime(context);
                }
                return 0;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                UMCrashManager.reportCrash(context, e);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return 101;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        if (context == null) {
            return;
        }
        try {
            String legacyEnvelopeDir = getLegacyEnvelopeDir(context);
            if (TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
                return;
            }
            File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
            if (!file.exists()) {
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (!file.isDirectory()) {
                    return;
                }
                file.delete();
                return;
            }
            String envelopeDirPath = getEnvelopeDirPath(context);
            for (int i = 0; i < listFiles.length; i++) {
                File file2 = listFiles[i];
                file2.renameTo(new File(envelopeDirPath + File.separator + listFiles[i].getName()));
            }
            if (!file.isDirectory()) {
                return;
            }
            file.delete();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                try {
                    FileChannel channel = new RandomAccessFile(str, Tailer.RAF_MODE).getChannel();
                    MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    bArr = new byte[(int) channel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    channel.close();
                } catch (IOException e) {
                    UMCrashManager.reportCrash(appContext, e);
                    throw e;
                }
            }
        }
        return bArr;
    }

    public static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    public static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
