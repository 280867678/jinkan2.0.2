package com.lzf.easyfloat.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.lzf.easyfloat.permission.rom.RomUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1615d;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class DisplayUtils {
    public static final DisplayUtils INSTANCE = new DisplayUtils();
    public static final String TAG = "DisplayUtils--->";

    private final boolean isHasNavigationBar(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            int i3 = displayMetrics2.heightPixels;
            int i4 = displayMetrics2.widthPixels;
            if (getNavigationBarHeight(context) + i3 > i) {
                return false;
            }
            return i2 - i4 > 0 || i - i3 > 0;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final boolean isHuaWeiHideNav(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }

    private final boolean isMiuiFullScreen(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    private final boolean isVivoFullScreen(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
    }

    public final int dp2px(Context context, float f) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final int getNavigationBarCurrentHeight(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        if (hasNavigationBar(context)) {
            return getNavigationBarHeight(context);
        }
        return 0;
    }

    public final int getNavigationBarHeight(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final int getScreenHeight(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resources, "context.resources");
        return resources.getDisplayMetrics().heightPixels;
    }

    public final Point getScreenSize(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Point point = new Point();
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
            return point;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final int getScreenWidth(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resources, "context.resources");
        return resources.getDisplayMetrics().widthPixels;
    }

    public final int getStatusBarHeight(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean hasNavigationBar(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        if (getNavigationBarHeight(context) == 0) {
            return false;
        }
        if (RomUtils.INSTANCE.checkIsHuaweiRom() && isHuaWeiHideNav(context)) {
            return false;
        }
        if (RomUtils.INSTANCE.checkIsMiuiRom() && isMiuiFullScreen(context)) {
            return false;
        }
        if (RomUtils.INSTANCE.checkIsVivoRom() && isVivoFullScreen(context)) {
            return false;
        }
        return isHasNavigationBar(context);
    }

    public final int px2dp(Context context, float f) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resources, "context.resources");
        return (int) ((f / resources.getDisplayMetrics().density) + 0.5f);
    }

    public final int px2sp(Context context, float f) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resources, "context.resources");
        return (int) ((f / resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final int rejectedNavHeight(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Point screenSize = getScreenSize(context);
        int i = screenSize.x;
        int i2 = screenSize.y;
        return i > i2 ? i2 : i2 - getNavigationBarCurrentHeight(context);
    }

    public final int sp2px(Context context, float f) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Resources resources = context.getResources();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final int statusBarHeight(View view) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        Context context = view.getContext();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) context, "view.context");
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) origApplicationContext, "view.context.applicationContext");
        return getStatusBarHeight(origApplicationContext);
    }
}
