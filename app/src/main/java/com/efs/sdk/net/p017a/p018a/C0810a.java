package com.efs.sdk.net.p017a.p018a;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* renamed from: com.efs.sdk.net.a.a.a */
/* loaded from: classes3.dex */
public final class C0810a extends FilterOutputStream {

    /* renamed from: a */
    public long f433a;

    public C0810a(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        ((FilterOutputStream) this).out.write(i);
        this.f433a++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        this.f433a += i2;
    }
}
