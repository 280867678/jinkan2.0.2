package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes4.dex */
public class Base64 {

    /* renamed from: a */
    public static final /* synthetic */ boolean f2343a = !Base64.class.desiredAssertionStatus();

    /* renamed from: com.tencent.smtt.utils.Base64$a */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1418a {

        /* renamed from: a */
        public byte[] f2344a;

        /* renamed from: b */
        public int f2345b;
    }

    /* renamed from: com.tencent.smtt.utils.Base64$b */
    /* loaded from: classes4.dex */
    public static class C1419b extends AbstractC1418a {

        /* renamed from: c */
        public static final int[] f2346c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d */
        public static final int[] f2347d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e */
        public int f2348e;

        /* renamed from: f */
        public int f2349f;

        /* renamed from: g */
        public final int[] f2350g;

        public C1419b(int i, byte[] bArr) {
            this.f2344a = bArr;
            this.f2350g = (i & 8) == 0 ? f2346c : f2347d;
            this.f2348e = 0;
            this.f2349f = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00fe, code lost:
            if (r5 != 4) goto L27;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean m2214a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.f2348e;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.f2349f;
            byte[] bArr2 = this.f2344a;
            int[] iArr = this.f2350g;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.f2348e = 6;
                                return false;
                            }
                        }
                        i12 |= i6 << 6;
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i7] = (byte) (i6 >> 4);
                                i7++;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.f2348e = 6;
                                return false;
                            }
                        }
                        i12 |= i6 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.f2348e = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.f2348e = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        int i13 = i12 | (i6 << 6);
                        bArr2[i7 + 2] = (byte) i13;
                        bArr2[i7 + 1] = (byte) (i13 >> 8);
                        bArr2[i7] = (byte) (i13 >> 16);
                        i7 += 3;
                        i6 = i13;
                        i8 = 0;
                    } else if (i12 == -2) {
                        bArr2[i7 + 1] = (byte) (i6 >> 2);
                        bArr2[i7] = (byte) (i6 >> 10);
                        i7 += 2;
                        i8 = 5;
                    } else if (i12 != -1) {
                        break;
                    }
                    i8++;
                    i6 = i12;
                } else {
                    if (i12 < 0) {
                        if (i12 != -1) {
                            this.f2348e = 6;
                            return false;
                        }
                    }
                    i8++;
                    i6 = i12;
                }
                i9 = i11;
            }
            if (z) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                    } else if (i8 == 3) {
                        int i14 = i7 + 1;
                        bArr2[i7] = (byte) (i6 >> 10);
                        i7 = i14 + 1;
                        bArr2[i14] = (byte) (i6 >> 2);
                    }
                    this.f2348e = i8;
                }
                this.f2348e = 6;
                return false;
            }
            this.f2348e = i8;
            this.f2349f = i6;
            this.f2345b = i7;
            return true;
        }
    }

    /* renamed from: com.tencent.smtt.utils.Base64$c */
    /* loaded from: classes4.dex */
    public static class C1420c extends AbstractC1418a {

        /* renamed from: g */
        public static final /* synthetic */ boolean f2351g = !Base64.class.desiredAssertionStatus();

        /* renamed from: h */
        public static final byte[] f2352h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, NativeJavaObject.CONVERSION_NONE, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_MINIMALOPT};

        /* renamed from: i */
        public static final byte[] f2353i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, NativeJavaObject.CONVERSION_NONE, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, 45, 95};

        /* renamed from: c */
        public int f2354c;

        /* renamed from: d */
        public final boolean f2355d;

        /* renamed from: e */
        public final boolean f2356e;

        /* renamed from: f */
        public final boolean f2357f;

        /* renamed from: j */
        public final byte[] f2358j;

        /* renamed from: k */
        public int f2359k;

        /* renamed from: l */
        public final byte[] f2360l;

        public C1420c(int i, byte[] bArr) {
            this.f2344a = bArr;
            boolean z = true;
            this.f2355d = (i & 1) == 0;
            this.f2356e = (i & 2) == 0;
            this.f2357f = (i & 4) == 0 ? false : z;
            this.f2360l = (i & 8) == 0 ? f2352h : f2353i;
            this.f2358j = new byte[2];
            this.f2354c = 0;
            this.f2359k = this.f2356e ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00dd -> B:15:0x008a). Please submit an issue!!! */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean m2213a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 518
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.C1420c.m2213a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: a */
    public static byte[] m2219a(String str, int i) {
        return m2218a(str.getBytes(), i);
    }

    /* renamed from: a */
    public static byte[] m2218a(byte[] bArr, int i) {
        return m2217a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m2217a(byte[] bArr, int i, int i2, int i3) {
        C1419b c1419b = new C1419b(i3, new byte[(i2 * 3) / 4]);
        if (c1419b.m2214a(bArr, i, i2, true)) {
            int i4 = c1419b.f2345b;
            byte[] bArr2 = c1419b.f2344a;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    /* renamed from: b */
    public static byte[] m2216b(byte[] bArr, int i) {
        return m2215b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m2215b(byte[] bArr, int i, int i2, int i3) {
        C1420c c1420c = new C1420c(i3, null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!c1420c.f2355d) {
            int i6 = i2 % 3;
            if (i6 == 1) {
                i4 += 2;
            } else if (i6 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c1420c.f2356e && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!c1420c.f2357f) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        c1420c.f2344a = new byte[i4];
        c1420c.m2213a(bArr, i, i2, true);
        if (f2343a || c1420c.f2345b == i4) {
            return c1420c.f2344a;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(m2216b(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
