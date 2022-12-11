package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class DBFileTraversalUtil {

    /* renamed from: a */
    public static ExecutorService f3664a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    public static FileLockUtil f3665b = new FileLockUtil();

    /* renamed from: com.umeng.analytics.process.DBFileTraversalUtil$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1673a {
        /* renamed from: a */
        void mo848a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final AbstractC1673a abstractC1673a) {
        final File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        f3664a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    for (File file2 : file.listFiles()) {
                        if (file2.getName().endsWith(".db")) {
                            DBFileTraversalUtil.f3665b.doFileOperateion(file2, fileLockCallback);
                            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                        }
                    }
                    if (abstractC1673a != null) {
                        abstractC1673a.mo848a();
                    }
                } catch (Throwable unused) {
                }
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
            }
        });
    }
}
