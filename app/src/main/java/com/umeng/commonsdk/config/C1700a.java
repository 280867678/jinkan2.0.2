package com.umeng.commonsdk.config;

/* renamed from: com.umeng.commonsdk.config.a */
/* loaded from: classes4.dex */
public class C1700a {
    /* renamed from: a */
    public static boolean m788a(int i, int i2) {
        return i2 >= 0 && i2 <= 31 && (i & (1 << i2)) != 0;
    }

    /* renamed from: a */
    public static boolean m787a(long j, int i) {
        return i >= 0 && i <= 63 && (j & (1 << i)) != 0;
    }

    /* renamed from: b */
    public static int m786b(int i, int i2) {
        return i | (1 << i2);
    }

    /* renamed from: b */
    public static long m785b(long j, int i) {
        return (i < 0 || i > 63) ? j : j | (1 << i);
    }

    /* renamed from: c */
    public static int m784c(int i, int i2) {
        return i & (~(1 << i2));
    }

    /* renamed from: c */
    public static long m783c(long j, int i) {
        return (i < 0 || i > 63) ? j : j & (~(1 << i));
    }
}
