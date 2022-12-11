package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.text.BidiFormatter;

/* loaded from: classes3.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    @RequiresApi(16)
    /* loaded from: classes3.dex */
    public static class Impl16 {
        public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE_SIZE);
        }
    }

    @RequiresApi(30)
    /* loaded from: classes3.dex */
    public static class Impl30 {
        public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(insetsController);
            }
            return null;
        }

        public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    @Nullable
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window, @NonNull View view) {
        return Build.VERSION.SDK_INT >= 30 ? Impl30.getInsetsController(window) : new WindowInsetsControllerCompat(window, view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window window, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) window.requireViewById(i);
        }
        T t = (T) window.findViewById(i);
        if (t == null) {
            throw new IllegalArgumentException("ID does not reference a View inside this Window");
        }
        return t;
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setDecorFitsSystemWindows(window, z);
        } else {
            Impl16.setDecorFitsSystemWindows(window, z);
        }
    }
}
