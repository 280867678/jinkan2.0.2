package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import org.mozilla.javascript.regexp.NativeRegExp;

/* renamed from: com.tencent.bugly.proguard.n */
/* loaded from: classes3.dex */
public final class C1230n {

    /* renamed from: a */
    public static final byte[] f1539a;

    /* renamed from: b */
    public static final byte[] f1540b;

    static {
        byte[] bArr = {NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        f1539a = bArr2;
        f1540b = bArr3;
    }

    /* renamed from: a */
    public static boolean m2887a(byte b, byte b2) {
        return b == b2;
    }

    /* renamed from: a */
    public static boolean m2886a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m2885a(long j, long j2) {
        return j == j2;
    }

    /* renamed from: a */
    public static boolean m2884a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m2882a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static byte[] m2883a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
