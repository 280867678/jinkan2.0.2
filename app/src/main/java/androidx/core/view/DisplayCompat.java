package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

/* loaded from: classes3.dex */
public final class DisplayCompat {
    public static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    public static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    @RequiresApi(17)
    /* loaded from: classes3.dex */
    public static class Api17Impl {
        public static void getRealSize(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    @RequiresApi(23)
    /* loaded from: classes3.dex */
    public static class Api23Impl {
        @NonNull
        public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
            Display.Mode mode = display.getMode();
            Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            return (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) ? new ModeCompat(mode, true) : new ModeCompat(mode, currentDisplaySizeFromWorkarounds);
        }

        @NonNull
        @SuppressLint({"ArrayReturn"})
        public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                for (int i = 0; i < supportedModes.length; i++) {
                    modeCompatArr[i] = new ModeCompat(supportedModes[i], physicalSizeEquals(supportedModes[i], mode));
                }
            } else {
                for (int i2 = 0; i2 < supportedModes.length; i2++) {
                    modeCompatArr[i2] = physicalSizeEquals(supportedModes[i2], mode) ? new ModeCompat(supportedModes[i2], currentDisplaySizeFromWorkarounds) : new ModeCompat(supportedModes[i2], false);
                }
            }
            return modeCompatArr;
        }

        public static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
            Display.Mode mode = display.getMode();
            Display.Mode[] supportedModes = display.getSupportedModes();
            for (int i = 0; i < supportedModes.length; i++) {
                if (mode.getPhysicalHeight() < supportedModes[i].getPhysicalHeight() || mode.getPhysicalWidth() < supportedModes[i].getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        public static boolean physicalSizeEquals(Display.Mode mode, Point point) {
            return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
        }

        public static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
            return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ModeCompat {
        public final boolean mIsNative;
        public final Display.Mode mMode;
        public final Point mPhysicalSize;

        public ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = null;
            this.mIsNative = true;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, @NonNull Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
            this.mIsNative = z;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.mMode;
        }
    }

    public static Point getCurrentDisplaySizeFromWorkarounds(@NonNull Context context, @NonNull Display display) {
        Point parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties(Build.VERSION.SDK_INT < 28 ? "sys.display-size" : "vendor.display-size", display);
        if (parsePhysicalDisplaySizeFromSystemProperties != null) {
            return parsePhysicalDisplaySizeFromSystemProperties;
        }
        if (isSonyBravia4kTv(context) && isCurrentModeTheLargestMode(display)) {
            return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
        }
        return null;
    }

    @NonNull
    public static Point getDisplaySize(@NonNull Context context, @NonNull Display display) {
        Point currentDisplaySizeFromWorkarounds = getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds != null) {
            return currentDisplaySizeFromWorkarounds;
        }
        Point point = new Point();
        Api17Impl.getRealSize(display, point);
        return point;
    }

    @NonNull
    @VisibleForTesting
    public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getMode(context, display) : new ModeCompat(getDisplaySize(context, display));
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getSupportedModes(context, display) : new ModeCompat[]{getMode(context, display)};
    }

    @Nullable
    public static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.isCurrentModeTheLargestMode(display);
        }
        return true;
    }

    public static boolean isSonyBravia4kTv(@NonNull Context context) {
        return isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    public static boolean isTv(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    public static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String systemProperty = getSystemProperty(str);
        if (TextUtils.isEmpty(systemProperty)) {
            return null;
        }
        try {
            return parseDisplaySize(systemProperty);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
