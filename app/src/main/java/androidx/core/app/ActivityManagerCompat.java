package androidx.core.app;

import android.app.ActivityManager;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class ActivityManagerCompat {
    public static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
