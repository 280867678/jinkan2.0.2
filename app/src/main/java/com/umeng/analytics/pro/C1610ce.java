package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.umeng.analytics.pro.ce */
/* loaded from: classes4.dex */
public class C1610ce extends AbstractC1612cg {

    /* renamed from: a */
    public InputStream f3263a;

    /* renamed from: b */
    public OutputStream f3264b;

    public C1610ce() {
        this.f3263a = null;
        this.f3264b = null;
    }

    public C1610ce(InputStream inputStream) {
        this.f3263a = null;
        this.f3264b = null;
        this.f3263a = inputStream;
    }

    public C1610ce(InputStream inputStream, OutputStream outputStream) {
        this.f3263a = null;
        this.f3264b = null;
        this.f3263a = inputStream;
        this.f3264b = outputStream;
    }

    public C1610ce(OutputStream outputStream) {
        this.f3263a = null;
        this.f3264b = null;
        this.f3264b = outputStream;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: a */
    public int mo1094a(byte[] bArr, int i, int i2) throws C1613ch {
        InputStream inputStream = this.f3263a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read < 0) {
                    throw new C1613ch(4);
                }
                return read;
            } catch (IOException e) {
                throw new C1613ch(0, e);
            }
        }
        throw new C1613ch(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: a */
    public boolean mo1096a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: b */
    public void mo1093b() throws C1613ch {
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: b */
    public void mo1091b(byte[] bArr, int i, int i2) throws C1613ch {
        OutputStream outputStream = this.f3264b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e) {
                throw new C1613ch(0, e);
            }
        }
        throw new C1613ch(1, "Cannot write to null outputStream");
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: c */
    public void mo1090c() {
        InputStream inputStream = this.f3263a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f3263a = null;
        }
        OutputStream outputStream = this.f3264b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f3264b = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1612cg
    /* renamed from: d */
    public void mo1089d() throws C1613ch {
        OutputStream outputStream = this.f3264b;
        if (outputStream != null) {
            try {
                outputStream.flush();
                return;
            } catch (IOException e) {
                throw new C1613ch(0, e);
            }
        }
        throw new C1613ch(1, "Cannot flush null outputStream");
    }
}
