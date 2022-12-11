package com.lzf.easyfloat.permission;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.lzf.easyfloat.interfaces.OnPermissionResult;
import com.lzf.easyfloat.permission.rom.HuaweiUtils;
import com.lzf.easyfloat.permission.rom.MeizuUtils;
import com.lzf.easyfloat.permission.rom.MiuiUtils;
import com.lzf.easyfloat.permission.rom.OppoUtils;
import com.lzf.easyfloat.permission.rom.QikuUtils;
import com.lzf.easyfloat.permission.rom.RomUtils;
import com.lzf.easyfloat.utils.Logger;
import com.umeng.analytics.pro.C1615d;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class PermissionUtils {
    public static final PermissionUtils INSTANCE = new PermissionUtils();
    public static final String TAG = "PermissionUtils--->";
    public static final int requestCode = 199;

    public static final boolean checkPermission(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        if (Build.VERSION.SDK_INT < 23) {
            if (RomUtils.INSTANCE.checkIsHuaweiRom()) {
                return INSTANCE.huaweiPermissionCheck(context);
            }
            if (RomUtils.INSTANCE.checkIsMiuiRom()) {
                return INSTANCE.miuiPermissionCheck(context);
            }
            if (RomUtils.INSTANCE.checkIsOppoRom()) {
                return INSTANCE.oppoROMPermissionCheck(context);
            }
            if (RomUtils.INSTANCE.checkIsMeizuRom()) {
                return INSTANCE.meizuPermissionCheck(context);
            }
            if (!RomUtils.INSTANCE.checkIs360Rom()) {
                return true;
            }
            return INSTANCE.qikuPermissionCheck(context);
        }
        return INSTANCE.commonROMPermissionCheck(context);
    }

    private final void commonROMPermissionApply(Fragment fragment) {
        if (RomUtils.INSTANCE.checkIsMeizuRom()) {
            MeizuUtils.applyPermission(fragment);
        } else if (Build.VERSION.SDK_INT < 23) {
            Logger.INSTANCE.m3698d(TAG, "user manually refuse OVERLAY_PERMISSION");
        } else {
            try {
                commonROMPermissionApplyInternal(fragment);
            } catch (Exception e) {
                Logger logger = Logger.INSTANCE;
                String stackTraceString = Log.getStackTraceString(e);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) stackTraceString, "Log.getStackTraceString(e)");
                logger.m3696e(TAG, stackTraceString);
            }
        }
    }

    public static final void commonROMPermissionApplyInternal(Fragment fragment) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragment, "fragment");
        try {
            Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            Activity activity = fragment.getActivity();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) activity, "fragment.activity");
            sb.append(activity.getPackageName());
            intent.setData(Uri.parse(sb.toString()));
            fragment.startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            Logger.INSTANCE.m3696e(TAG, String.valueOf(e));
        }
    }

    private final boolean commonROMPermissionCheck(Context context) {
        if (RomUtils.INSTANCE.checkIsMeizuRom()) {
            return meizuPermissionCheck(context);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Object invoke = Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
                if (invoke == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                }
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e) {
                Log.getStackTraceString(e);
            }
        }
        return true;
    }

    private final boolean huaweiPermissionCheck(Context context) {
        return HuaweiUtils.checkFloatWindowPermission(context);
    }

    private final boolean meizuPermissionCheck(Context context) {
        return MeizuUtils.checkFloatWindowPermission(context);
    }

    private final boolean miuiPermissionCheck(Context context) {
        return MiuiUtils.checkFloatWindowPermission(context);
    }

    private final boolean oppoROMPermissionCheck(Context context) {
        return OppoUtils.checkFloatWindowPermission(context);
    }

    private final boolean qikuPermissionCheck(Context context) {
        return QikuUtils.checkFloatWindowPermission(context);
    }

    public static final void requestPermission(Activity activity, OnPermissionResult onPermissionResult) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onPermissionResult, "onPermissionResult");
        PermissionFragment.Companion.requestPermission(activity, onPermissionResult);
    }

    public final void requestPermission$easyfloat_release(Fragment fragment) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragment, "fragment");
        if (Build.VERSION.SDK_INT >= 23) {
            commonROMPermissionApply(fragment);
        } else if (RomUtils.INSTANCE.checkIsHuaweiRom()) {
            HuaweiUtils.applyPermission(fragment.getActivity());
        } else if (RomUtils.INSTANCE.checkIsMiuiRom()) {
            MiuiUtils.applyMiuiPermission(fragment.getActivity());
        } else if (RomUtils.INSTANCE.checkIsOppoRom()) {
            OppoUtils.applyOppoPermission(fragment.getActivity());
        } else if (RomUtils.INSTANCE.checkIsMeizuRom()) {
            MeizuUtils.applyPermission(fragment);
        } else if (RomUtils.INSTANCE.checkIs360Rom()) {
            QikuUtils.applyPermission(fragment.getActivity());
        } else {
            Logger.INSTANCE.m3694i(TAG, "原生 Android 6.0 以下无需权限申请");
        }
    }
}
