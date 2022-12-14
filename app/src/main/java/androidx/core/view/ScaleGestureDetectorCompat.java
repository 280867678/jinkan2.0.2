package androidx.core.view;

import android.view.ScaleGestureDetector;

/* loaded from: classes3.dex */
public final class ScaleGestureDetectorCompat {
    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
        scaleGestureDetector.setQuickScaleEnabled(z);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z);
    }
}
