package com.efs.sdk.base.core.p010d;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* renamed from: com.efs.sdk.base.core.d.b */
/* loaded from: classes3.dex */
public final class C0739b {

    /* renamed from: a */
    public C0738a f278a;

    /* renamed from: b */
    public C0740c f279b = new C0740c();

    /* renamed from: c */
    public byte[] f280c;

    /* renamed from: d */
    public File f281d;

    public C0739b(String str, byte b) {
        this.f278a = new C0738a(str, b);
    }

    /* renamed from: a */
    public static C0739b m4097a(ILogProtocol iLogProtocol) {
        C0739b c0739b;
        C0739b c0739b2 = null;
        try {
            c0739b = new C0739b(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (Exception e) {
            e = e;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                c0739b.m4093b(0);
                c0739b.m4095a(iLogProtocol.generate());
            } else if (bodyType != 1) {
                Log.m4054w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
            } else {
                c0739b.m4093b(1);
                c0739b.f281d = new File(iLogProtocol.getFilePath());
            }
            return c0739b;
        } catch (Exception e2) {
            e = e2;
            c0739b2 = c0739b;
            Log.m4065e("efs.base", "log send error", e);
            return c0739b2;
        }
    }

    /* renamed from: d */
    private void m4091d() {
        byte[] bArr;
        C0738a c0738a = this.f278a;
        if (c0738a.f273c == 0 && (bArr = this.f280c) != null) {
            c0738a.f276f = bArr.length;
        } else if (this.f278a.f273c != 1 || !this.f281d.exists()) {
        } else {
            this.f278a.f276f = this.f281d.length();
        }
    }

    /* renamed from: a */
    public final long m4099a() {
        m4091d();
        return this.f278a.f276f;
    }

    /* renamed from: a */
    public final void m4098a(int i) {
        this.f278a.f275e = i;
        m4091d();
    }

    /* renamed from: a */
    public final void m4096a(String str) {
        this.f278a.f274d = str;
    }

    /* renamed from: a */
    public final void m4095a(byte[] bArr) {
        this.f280c = bArr;
        m4091d();
    }

    /* renamed from: b */
    public final void m4093b(int i) {
        this.f278a.f273c = i;
    }

    /* renamed from: b */
    public final boolean m4094b() {
        return !Constants.CP_NONE.equals(this.f278a.f274d);
    }

    /* renamed from: c */
    public final void m4092c() {
        this.f279b.f282a = true;
    }
}
