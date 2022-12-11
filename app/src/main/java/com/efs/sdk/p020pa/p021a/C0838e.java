package com.efs.sdk.p020pa.p021a;

import android.os.SystemClock;
import android.util.Printer;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.efs.sdk.pa.a.e */
/* loaded from: classes3.dex */
public final class C0838e implements Printer {

    /* renamed from: f */
    public long f540f;

    /* renamed from: b */
    public boolean f536b = false;

    /* renamed from: c */
    public String f537c = null;

    /* renamed from: d */
    public long f538d = -1;

    /* renamed from: e */
    public long f539e = -1;

    /* renamed from: a */
    public Vector<AbstractC0837d> f535a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(">")) {
            this.f538d = SystemClock.elapsedRealtime();
            this.f539e = SystemClock.currentThreadTimeMillis();
            this.f537c = str;
            this.f536b = true;
            Iterator<AbstractC0837d> it = this.f535a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } else if (!this.f536b || !str.startsWith("<")) {
        } else {
            this.f536b = false;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f538d;
            if (elapsedRealtime <= this.f540f) {
                return;
            }
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.f539e;
            Iterator<AbstractC0837d> it2 = this.f535a.iterator();
            while (it2.hasNext()) {
                it2.next().mo3937a(this.f537c, elapsedRealtime, currentThreadTimeMillis);
            }
        }
    }
}
