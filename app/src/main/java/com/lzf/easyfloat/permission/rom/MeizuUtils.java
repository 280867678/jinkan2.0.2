package com.lzf.easyfloat.permission.rom;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;
import com.lzf.easyfloat.permission.PermissionUtils;

/* loaded from: classes3.dex */
public class MeizuUtils {
    public static final String TAG = "MeizuUtils";

    public static void applyPermission(Fragment fragment) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", fragment.getActivity().getPackageName());
            fragment.startActivityForResult(intent, PermissionUtils.requestCode);
        } catch (Exception e) {
            try {
                Log.getStackTraceString(e);
                PermissionUtils.commonROMPermissionApplyInternal(fragment);
            } catch (Exception e2) {
                Log.getStackTraceString(e2);
            }
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
