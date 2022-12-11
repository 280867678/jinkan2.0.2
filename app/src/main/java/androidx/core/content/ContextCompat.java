package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.arialyy.aria.core.inf.ReceiverType;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.pro.C1543ak;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.litepal.parser.LitePalParser;

/* loaded from: classes3.dex */
public class ContextCompat {
    public static final String TAG = "ContextCompat";
    public static final Object sLock = new Object();
    public static TypedValue sTempValue;

    /* loaded from: classes3.dex */
    public static final class LegacyServiceMapHolder {
        public static final HashMap<Class<?>, String> SERVICES = new HashMap<>();

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                SERVICES.put(SubscriptionManager.class, "telephony_subscription_service");
                SERVICES.put(UsageStatsManager.class, "usagestats");
            }
            SERVICES.put(AppWidgetManager.class, "appwidget");
            SERVICES.put(BatteryManager.class, "batterymanager");
            SERVICES.put(CameraManager.class, "camera");
            SERVICES.put(JobScheduler.class, "jobscheduler");
            SERVICES.put(LauncherApps.class, "launcherapps");
            SERVICES.put(MediaProjectionManager.class, "media_projection");
            SERVICES.put(MediaSessionManager.class, "media_session");
            SERVICES.put(RestrictionsManager.class, "restrictions");
            SERVICES.put(TelecomManager.class, "telecom");
            SERVICES.put(TvInputManager.class, "tv_input");
            SERVICES.put(AppOpsManager.class, "appops");
            SERVICES.put(CaptioningManager.class, "captioning");
            SERVICES.put(ConsumerIrManager.class, "consumer_ir");
            SERVICES.put(PrintManager.class, "print");
            SERVICES.put(BluetoothManager.class, "bluetooth");
            SERVICES.put(DisplayManager.class, "display");
            SERVICES.put(UserManager.class, "user");
            SERVICES.put(InputManager.class, "input");
            SERVICES.put(MediaRouter.class, "media_router");
            SERVICES.put(NsdManager.class, "servicediscovery");
            SERVICES.put(AccessibilityManager.class, "accessibility");
            SERVICES.put(AccountManager.class, "account");
            SERVICES.put(ActivityManager.class, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            SERVICES.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            SERVICES.put(AudioManager.class, "audio");
            SERVICES.put(ClipboardManager.class, "clipboard");
            SERVICES.put(ConnectivityManager.class, "connectivity");
            SERVICES.put(DevicePolicyManager.class, "device_policy");
            SERVICES.put(DownloadManager.class, ReceiverType.DOWNLOAD);
            SERVICES.put(DropBoxManager.class, "dropbox");
            SERVICES.put(InputMethodManager.class, "input_method");
            SERVICES.put(KeyguardManager.class, "keyguard");
            SERVICES.put(LayoutInflater.class, "layout_inflater");
            SERVICES.put(LocationManager.class, "location");
            SERVICES.put(NfcManager.class, "nfc");
            SERVICES.put(NotificationManager.class, "notification");
            SERVICES.put(PowerManager.class, "power");
            SERVICES.put(SearchManager.class, "search");
            SERVICES.put(SensorManager.class, C1543ak.f2992ac);
            SERVICES.put(StorageManager.class, LitePalParser.NODE_STORAGE);
            SERVICES.put(TelephonyManager.class, "phone");
            SERVICES.put(TextServicesManager.class, "textservices");
            SERVICES.put(UiModeManager.class, "uimode");
            SERVICES.put(UsbManager.class, "usb");
            SERVICES.put(Vibrator.class, "vibrator");
            SERVICES.put(WallpaperManager.class, "wallpaper");
            SERVICES.put(WifiP2pManager.class, "wifip2p");
            SERVICES.put(WifiManager.class, NetworkUtil.NETWORK_TYPE_WIFI);
            SERVICES.put(WindowManager.class, "window");
        }
    }

    /* loaded from: classes3.dex */
    public static class MainHandlerExecutor implements Executor {
        public final Handler mHandler;

        public MainHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.mHandler.post(runnable)) {
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    public static synchronized File createFilesDir(File file) {
        synchronized (ContextCompat.class) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            if (file.exists()) {
                return file;
            }
            file.getPath();
            return null;
        }
    }

    public static File getCodeCacheDir(@NonNull Context context) {
        return context.getCodeCacheDir();
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @ColorRes int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    @Nullable
    public static File getDataDir(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        String str = context.getApplicationInfo().dataDir;
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return context.getDrawable(i);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context context) {
        return context.getExternalCacheDirs();
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context context, @Nullable String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Executor getMainExecutor(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? context.getMainExecutor() : new MainHandlerExecutor(new Handler(context.getMainLooper()));
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context context) {
        return context.getNoBackupFilesDir();
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context context) {
        return context.getObbDirs();
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context context, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) context.getSystemService(cls);
        }
        String systemServiceName = getSystemServiceName(context, cls);
        if (systemServiceName == null) {
            return null;
        }
        return (T) context.getSystemService(systemServiceName);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context context, @NonNull Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? context.getSystemServiceName(cls) : LegacyServiceMapHolder.SERVICES.get(cls);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void startForegroundService(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
