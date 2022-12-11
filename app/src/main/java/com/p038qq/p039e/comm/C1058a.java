package com.p038qq.p039e.comm;

import android.content.Context;
import android.content.Intent;
import com.p038qq.p039e.comm.constants.CustomPkgConstants;
import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.comm.a */
/* loaded from: classes3.dex */
public class C1058a {
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Class<?>... clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.m3646e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.m3645e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
        com.p038qq.p039e.comm.util.GDTLogger.m3646e(java.lang.String.format("Service[%s]需要在AndroidManifest.xml中声明", r4.getName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
        r8 = false;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m3664a(Context context) {
        boolean z;
        boolean z2;
        try {
            String[] strArr = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
            int i = 0;
            while (true) {
                if (i >= 3) {
                    z = true;
                    break;
                }
                String str = strArr[i];
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.m3646e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    z = false;
                    break;
                }
                i++;
            }
            if (!z || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, Class.forName(CustomPkgConstants.getADActivityName())) || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                return false;
            }
            Class<?>[] clsArr = {Class.forName(CustomPkgConstants.getDownLoadServiceName())};
            int i2 = 0;
            while (true) {
                if (i2 >= 1) {
                    z2 = true;
                    break;
                }
                Class<?> cls = clsArr[i2];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    break;
                }
                i2++;
            }
            return z2;
        } catch (Throwable th) {
            GDTLogger.m3645e("检查AndroidManifest.xml时发生异常", th);
            return false;
        }
    }
}
