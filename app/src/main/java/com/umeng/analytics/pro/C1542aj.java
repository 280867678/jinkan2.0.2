package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.aj */
/* loaded from: classes4.dex */
public class C1542aj {

    /* renamed from: a */
    public static final String f2935a = "OpenId";

    /* renamed from: b */
    public static boolean f2936b;

    /* renamed from: a */
    public static String m1381a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    /* renamed from: a */
    public static void m1380a(String str, Object... objArr) {
        if (f2936b) {
            m1375e(str, objArr);
        }
    }

    /* renamed from: a */
    public static void m1379a(boolean z) {
        f2936b = z;
    }

    /* renamed from: b */
    public static void m1378b(String str, Object... objArr) {
        if (f2936b) {
            m1375e(str, objArr);
        }
    }

    /* renamed from: c */
    public static void m1377c(String str, Object... objArr) {
        if (f2936b) {
            m1375e(str, objArr);
        }
    }

    /* renamed from: d */
    public static void m1376d(String str, Object... objArr) {
        if (f2936b) {
            m1375e(str, objArr);
        }
    }

    /* renamed from: e */
    public static String m1375e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(m1381a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }
}
