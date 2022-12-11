package com.efs.sdk.p020pa.p021a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.p020pa.AbstractC0827PA;
import com.efs.sdk.p020pa.PAANRListener;
import com.efs.sdk.p020pa.PAMsgListener;
import com.efs.sdk.p020pa.p021a.C0833b;
import com.efs.sdk.p020pa.p021a.C0840g;
import com.stub.StubApp;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* renamed from: com.efs.sdk.pa.a.c */
/* loaded from: classes3.dex */
public final class C0836c implements AbstractC0827PA {

    /* renamed from: a */
    public boolean f526a;

    /* renamed from: c */
    public C0838e f528c;

    /* renamed from: d */
    public C0839f f529d;

    /* renamed from: e */
    public C0830a f530e;

    /* renamed from: h */
    public boolean f533h;

    /* renamed from: i */
    public boolean f534i;

    /* renamed from: b */
    public Looper f527b = Looper.myLooper();

    /* renamed from: f */
    public C0833b f531f = new C0833b();

    /* renamed from: g */
    public C0840g f532g = new C0840g();

    public C0836c(boolean z) {
        this.f534i = z;
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        C0839f c0839f = this.f529d;
        if (c0839f == null || str == null || str.trim().length() == 0) {
            return;
        }
        c0839f.f543c = str;
        if (c0839f.f544d != null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Exception unused) {
        }
        try {
            c0839f.f544d = new BufferedOutputStream(fileOutputStream);
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 == null) {
                return;
            }
            try {
                fileOutputStream2.close();
            } catch (Exception unused3) {
            }
        }
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void enableLog(boolean z) {
        this.f526a = z;
        this.f531f.f520b = z;
        this.f532g.f546b = z;
        C0839f c0839f = this.f529d;
        if (c0839f != null) {
            c0839f.f542b = z;
        }
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final int endCalFPS(String str) {
        if (!this.f533h) {
            return -1;
        }
        C0833b c0833b = this.f531f;
        int i = 0;
        if (str != null && str.trim().length() != 0) {
            C0833b.C0834a c0834a = c0833b.f519a.get(str);
            if (c0834a == null) {
                return 0;
            }
            View view = c0834a.f524d;
            if (view != null && c0834a.f523c != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(c0834a.f523c);
            }
            c0833b.f519a.remove(str);
            int currentTimeMillis = (int) (((float) c0834a.f522b) / (((float) (System.currentTimeMillis() - c0834a.f521a)) / 1000.0f));
            if (currentTimeMillis > 0) {
                i = currentTimeMillis;
            }
            boolean z = c0833b.f520b;
        }
        return i;
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final long endCalTime(String str) {
        C0840g.C0841a c0841a;
        if (!this.f533h) {
            return -1L;
        }
        C0840g c0840g = this.f532g;
        if (str == null || str.trim().length() == 0 || (c0841a = c0840g.f545a.get(str)) == null) {
            return 0L;
        }
        c0840g.f545a.remove(str);
        long currentTimeMillis = System.currentTimeMillis() - c0841a.f547a;
        boolean z = c0840g.f546b;
        return currentTimeMillis;
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000L);
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j) {
        registerPAANRListener(context, pAANRListener, j, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j, Thread thread) {
        if (this.f530e == null) {
            this.f530e = thread != null ? new C0830a((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()), j) : new C0830a((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()), j, false);
        }
        this.f530e.f508h = pAANRListener;
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.f528c == null) {
            this.f528c = new C0838e();
        }
        this.f527b.setMessageLogging(this.f528c);
        if (this.f529d == null) {
            this.f529d = new C0839f();
        }
        C0839f c0839f = this.f529d;
        c0839f.f542b = this.f526a;
        c0839f.f541a = pAMsgListener;
        this.f528c.f535a.add(c0839f);
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void start() {
        if (this.f534i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.f533h = true;
            C0838e c0838e = this.f528c;
            if (c0838e != null) {
                this.f527b.setMessageLogging(c0838e);
            }
            C0830a c0830a = this.f530e;
            if (c0830a == null || !c0830a.f506f) {
                return;
            }
            c0830a.f506f = false;
            c0830a.f507g.post(c0830a.f513m);
            c0830a.f510j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void startCalFPS(String str, View view) {
        if (!this.f533h) {
            return;
        }
        C0833b c0833b = this.f531f;
        if (str == null || str.trim().length() == 0 || view == null || c0833b.f519a.get(str) != null) {
            return;
        }
        final C0833b.C0834a c0834a = new C0833b.C0834a((byte) 0);
        c0834a.f524d = view;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                c0834a.f522b++;
                return true;
            }
        };
        c0834a.f523c = onPreDrawListener;
        c0834a.f524d.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
        c0834a.f521a = System.currentTimeMillis();
        c0833b.f519a.put(str, c0834a);
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void startCalTime(String str) {
        if (!this.f533h) {
            return;
        }
        C0840g c0840g = this.f532g;
        if (str == null || str.trim().length() == 0 || c0840g.f545a.get(str) != null) {
            return;
        }
        C0840g.C0841a c0841a = new C0840g.C0841a((byte) 0);
        c0841a.f547a = System.currentTimeMillis();
        c0840g.f545a.put(str, c0841a);
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void stop() {
        this.f533h = false;
        this.f527b.setMessageLogging(null);
        C0830a c0830a = this.f530e;
        if (c0830a != null) {
            c0830a.f506f = true;
            c0830a.f507g.removeCallbacksAndMessages(null);
            c0830a.f501a = true;
        }
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void unRegisterPAMsgListener() {
        C0839f c0839f = this.f529d;
        if (c0839f != null) {
            c0839f.f541a = null;
        }
        C0838e c0838e = this.f528c;
        if (c0838e != null) {
            c0838e.f535a.remove(this.f529d);
        }
    }

    @Override // com.efs.sdk.p020pa.AbstractC0827PA
    public final void unregisterPAANRListener() {
    }
}
