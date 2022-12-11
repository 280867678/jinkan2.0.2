package com.qihoo.util;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Looper;

/* renamed from: com.qihoo.util.a */
/* loaded from: classes.dex */
final class RunnableC1038a implements Runnable {

    /* renamed from: a */
    private /* synthetic */ Context f654a;

    /* renamed from: b */
    private /* synthetic */ String f655b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1038a(Context context, String str) {
        this.f654a = context;
        this.f655b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.prepare();
        AlertDialog create = new AlertDialog.Builder(this.f654a).setMessage(this.f655b).setCancelable(false).setPositiveButton("确定", new DialogInterface$OnClickListenerC1039b(this)).create();
        create.getWindow().setType(2005);
        create.show();
        Looper.loop();
    }
}
