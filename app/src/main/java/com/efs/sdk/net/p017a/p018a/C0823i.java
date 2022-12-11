package com.efs.sdk.net.p017a.p018a;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.efs.sdk.net.a.a.i */
/* loaded from: classes3.dex */
public final class C0823i {
    /* renamed from: a */
    public static void m3941a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
