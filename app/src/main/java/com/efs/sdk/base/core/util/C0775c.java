package com.efs.sdk.base.core.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.efs.sdk.base.core.util.c */
/* loaded from: classes3.dex */
public final class C0775c {
    /* renamed from: a */
    public static byte[] m4014a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            Log.m4065e("efs.base", "gzip error", e);
            return null;
        }
    }
}
