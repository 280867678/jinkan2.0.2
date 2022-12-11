package com.qihoo.util;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class QHDialog {
    public static void showDialog(Context context, String str) {
        Thread thread = new Thread(new RunnableC1038a(context, str));
        synchronized (thread) {
            try {
                thread.start();
                if (Build.VERSION.SDK_INT >= 19) {
                    thread.wait();
                } else {
                    Thread.sleep(3000L);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
