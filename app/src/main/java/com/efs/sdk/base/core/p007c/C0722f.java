package com.efs.sdk.base.core.p007c;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0778d;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* renamed from: com.efs.sdk.base.core.c.f */
/* loaded from: classes3.dex */
public final class C0722f {

    /* renamed from: b */
    public static FileLock f216b;

    /* renamed from: a */
    public volatile int f217a;

    /* renamed from: com.efs.sdk.base.core.c.f$a */
    /* loaded from: classes3.dex */
    public static class C0724a {

        /* renamed from: a */
        public static final C0722f f220a = new C0722f((byte) 0);

        /* renamed from: a */
        public static /* synthetic */ C0722f m4136a() {
            return f220a;
        }
    }

    public C0722f() {
        this.f217a = 0;
        m4137a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    public /* synthetic */ C0722f(byte b) {
        this();
    }

    /* renamed from: a */
    private synchronized void m4137a(final Context context) {
        Log.m4054w("efs.send_log", "tryFileLock start! ");
        this.f217a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.core.c.f.1
            {
                C0722f.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FileLock lock;
                try {
                    File m4051a = C0763a.m4051a(context);
                    if (!m4051a.exists()) {
                        m4051a.mkdirs();
                    }
                    File file = new File(m4051a.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        lock = new FileOutputStream(file).getChannel().lock();
                        C0722f.f216b = lock;
                    } while (!lock.isValid());
                    Log.m4054w("efs.send_log", "tryFileLock sendlock sucess! processname: " + C0778d.m4002b());
                    C0722f.this.f217a = 2;
                } catch (Exception e) {
                    Log.m4054w("efs.send_log", "tryFileLock fail! " + e.getMessage());
                    C0722f.this.f217a = 0;
                }
            }
        }).start();
    }

    /* renamed from: a */
    public final boolean m4138a() {
        if (this.f217a == 2) {
            return true;
        }
        if (this.f217a != 0) {
            return false;
        }
        m4137a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }
}
