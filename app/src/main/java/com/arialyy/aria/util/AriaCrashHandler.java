package com.arialyy.aria.util;

import android.os.Process;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class AriaCrashHandler implements Thread.UncaughtExceptionHandler {
    public Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    public ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private void exit() {
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    private void handleException(final String str, final Throwable th) {
        if (th == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.arialyy.aria.util.AriaCrashHandler.1
            @Override // java.lang.Runnable
            public void run() {
                ErrorHelp.saveError(str, "", ALog.getExceptionString(th));
            }
        });
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        handleException(thread.getName(), th);
        try {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            this.mDefaultHandler.uncaughtException(thread, th);
            exit();
        }
    }
}
