package com.qihoo.util;

import android.content.DialogInterface;
import android.os.Build;

/* renamed from: com.qihoo.util.b */
/* loaded from: classes.dex */
final class DialogInterface$OnClickListenerC1039b implements DialogInterface.OnClickListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC1039b(RunnableC1038a runnableC1038a) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Thread currentThread = Thread.currentThread();
        synchronized (currentThread) {
            if (Build.VERSION.SDK_INT >= 19) {
                currentThread.notify();
            }
        }
    }
}
