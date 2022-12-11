package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.aq */
/* loaded from: classes4.dex */
public class C1555aq {
    /* renamed from: a */
    public static final byte m1283a(byte b, int i, boolean z) {
        return (byte) m1281a((int) b, i, z);
    }

    /* renamed from: a */
    public static final int m1281a(int i, int i2, boolean z) {
        return z ? i | (1 << i2) : m1271b(i, i2);
    }

    /* renamed from: a */
    public static final int m1274a(byte[] bArr) {
        return m1273a(bArr, 0);
    }

    /* renamed from: a */
    public static final int m1273a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: a */
    public static final long m1277a(long j, int i, boolean z) {
        return z ? j | (1 << i) : m1270b(j, i);
    }

    /* renamed from: a */
    public static final short m1275a(short s, int i, boolean z) {
        return (short) m1281a((int) s, i, z);
    }

    /* renamed from: a */
    public static final void m1280a(int i, byte[] bArr) {
        m1279a(i, bArr, 0);
    }

    /* renamed from: a */
    public static final void m1279a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
    }

    /* renamed from: a */
    public static final boolean m1284a(byte b, int i) {
        return m1282a((int) b, i);
    }

    /* renamed from: a */
    public static final boolean m1282a(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    /* renamed from: a */
    public static final boolean m1278a(long j, int i) {
        return (j & (1 << i)) != 0;
    }

    /* renamed from: a */
    public static final boolean m1276a(short s, int i) {
        return m1282a((int) s, i);
    }

    /* renamed from: b */
    public static final byte m1272b(byte b, int i) {
        return (byte) m1271b((int) b, i);
    }

    /* renamed from: b */
    public static final int m1271b(int i, int i2) {
        return i & (~(1 << i2));
    }

    /* renamed from: b */
    public static final long m1270b(long j, int i) {
        return j & (~(1 << i));
    }

    /* renamed from: b */
    public static final short m1269b(short s, int i) {
        return (short) m1271b((int) s, i);
    }
}
