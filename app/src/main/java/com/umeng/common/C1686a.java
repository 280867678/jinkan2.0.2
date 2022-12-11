package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* renamed from: com.umeng.common.a */
/* loaded from: classes4.dex */
public class C1686a {

    /* renamed from: a */
    public static String f3709a = null;

    /* renamed from: b */
    public static final String f3710b = "umeng+";

    /* renamed from: c */
    public static final String f3711c = "ek__id";

    /* renamed from: d */
    public static final String f3712d = "ek_key";

    /* renamed from: e */
    public static String f3713e = "";

    /* renamed from: f */
    public static final String f3714f = "umeng_subprocess_info";

    /* renamed from: g */
    public static String f3715g = "";

    /* renamed from: h */
    public static C1686a f3716h;

    /* renamed from: a */
    public static C1686a m825a() {
        if (f3716h == null) {
            synchronized (C1686a.class) {
                if (f3716h == null) {
                    f3716h = new C1686a();
                }
            }
        }
        return f3716h;
    }

    /* renamed from: c */
    private String m821c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < substring.length(); i++) {
                char charAt = substring.charAt(i);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public String m823a(String str) {
        try {
            return TextUtils.isEmpty(f3709a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f3709a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void m824a(Context context) {
        try {
            if (!TextUtils.isEmpty(f3709a)) {
                return;
            }
            String multiProcessSP = UMUtils.getMultiProcessSP(context, "ek__id");
            if (!TextUtils.isEmpty(multiProcessSP)) {
                f3713e = m821c(multiProcessSP);
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f3713e);
            }
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f3714f, 0);
            if (sharedPreferences != null) {
                f3715g = sharedPreferences.getString("ek__id", null);
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f3715g);
            }
            f3709a = m821c(UMUtils.genId());
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f3709a);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public String m822b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(f3709a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f3709a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f3713e)) {
                return null;
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f3713e.getBytes()));
            } catch (Exception unused2) {
            }
            try {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                return str2;
            } catch (Exception unused3) {
                str3 = str2;
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                try {
                    String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f3715g.getBytes()));
                    try {
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str4;
                    } catch (Throwable unused4) {
                        str3 = str4;
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                } catch (Throwable unused5) {
                }
            }
        }
    }
}
