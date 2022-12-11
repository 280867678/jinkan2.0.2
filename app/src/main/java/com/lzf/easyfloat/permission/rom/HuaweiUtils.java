package com.lzf.easyfloat.permission.rom;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;
import android.widget.Toast;

/* loaded from: classes3.dex */
public class HuaweiUtils {
    public static final String TAG = "HuaweiUtils";

    public static void applyPermission(Context context) {
        ActivityNotFoundException activityNotFoundException;
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (RomUtils.getEmuiVersion() != 3.1d) {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            context.startActivity(intent2);
            e.printStackTrace();
            activityNotFoundException = e;
            Log.getStackTraceString(activityNotFoundException);
        } catch (SecurityException e2) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            context.startActivity(intent3);
            Log.getStackTraceString(e2);
        } catch (Exception e3) {
            Toast.makeText(context, "进入设置页面失败，请手动设置", 1).show();
            activityNotFoundException = e3;
            Log.getStackTraceString(activityNotFoundException);
        }
    }

    public static boolean checkFloatWindowPermission(Context context) {
        return checkOp(context, 24);
    }

    @TargetApi(19)
    public static boolean checkOp(Context context, int i) {
        try {
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e) {
            Log.getStackTraceString(e);
            return false;
        }
    }
}
