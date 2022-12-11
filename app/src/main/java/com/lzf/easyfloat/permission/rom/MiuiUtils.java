package com.lzf.easyfloat.permission.rom;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.util.Log;

/* loaded from: classes3.dex */
public class MiuiUtils {
    public static final String TAG = "MiuiUtils";

    public static void applyMiuiPermission(Context context) {
        int miuiVersion = getMiuiVersion();
        if (miuiVersion == 5) {
            goToMiuiPermissionActivity_V5(context);
        } else if (miuiVersion == 6) {
            goToMiuiPermissionActivity_V6(context);
        } else if (miuiVersion == 7) {
            goToMiuiPermissionActivity_V7(context);
        } else if (miuiVersion < 8) {
        } else {
            goToMiuiPermissionActivity_V8(context);
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

    public static int getMiuiVersion() {
        String systemProperty = RomUtils.getSystemProperty("ro.miui.ui.version.name");
        if (systemProperty != null) {
            try {
                return Integer.parseInt(systemProperty.substring(1));
            } catch (Exception e) {
                Log.getStackTraceString(e);
                return -1;
            }
        }
        return -1;
    }

    public static void goToMiuiPermissionActivity_V5(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        intent.setFlags(268435456);
        if (isIntentAvailable(intent, context)) {
            context.startActivity(intent);
        }
    }

    public static void goToMiuiPermissionActivity_V6(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (isIntentAvailable(intent, context)) {
            context.startActivity(intent);
        }
    }

    public static void goToMiuiPermissionActivity_V7(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (isIntentAvailable(intent, context)) {
            context.startActivity(intent);
        }
    }

    public static void goToMiuiPermissionActivity_V8(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (!isIntentAvailable(intent, context)) {
            intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setPackage("com.miui.securitycenter");
            intent.putExtra("extra_pkgname", context.getPackageName());
            intent.setFlags(268435456);
            if (!isIntentAvailable(intent, context)) {
                return;
            }
        }
        context.startActivity(intent);
    }

    public static boolean isIntentAvailable(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
