package com.just.agentweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class AgentWebCompat {
    public static void createFile(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00f4 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x0007, B:9:0x002a, B:11:0x0030, B:12:0x0034, B:14:0x0064, B:15:0x0079, B:16:0x00ea, B:17:0x00ee, B:19:0x00f4, B:22:0x0105, B:27:0x007d, B:29:0x00bf), top: B:5:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setDataDirectorySuffix(Context context) {
        String str;
        Iterator it;
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            HashSet hashSet = new HashSet();
            String absolutePath = context.getDataDir().getAbsolutePath();
            String currentProcessName = ProcessUtils.getCurrentProcessName(context);
            if (!TextUtils.equals(context.getPackageName(), currentProcessName)) {
                if (TextUtils.isEmpty(currentProcessName)) {
                    currentProcessName = context.getPackageName();
                }
                WebView.setDataDirectorySuffix(currentProcessName);
                String str2 = "_" + currentProcessName;
                hashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
                if (RomUtils.isHuawei()) {
                    str = absolutePath + "/app_hws_webview" + str2 + "/webview_data.lock";
                    hashSet.add(str);
                }
                it = hashSet.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (file.exists()) {
                        tryLockOrRecreateFile(file);
                        return;
                    }
                }
                return;
            }
            String str3 = "_" + currentProcessName;
            hashSet.add(absolutePath + "/app_webview/webview_data.lock");
            hashSet.add(absolutePath + "/app_webview" + str3 + "/webview_data.lock");
            if (RomUtils.isHuawei()) {
                hashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
                str = absolutePath + "/app_hws_webview" + str3 + "/webview_data.lock";
                hashSet.add(str);
            }
            it = hashSet.iterator();
            while (it.hasNext()) {
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        e.printStackTrace();
    }

    @TargetApi(28)
    public static void tryLockOrRecreateFile(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                createFile(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            boolean z = false;
            if (file.exists()) {
                z = file.delete();
            }
            createFile(file, z);
        }
    }
}
