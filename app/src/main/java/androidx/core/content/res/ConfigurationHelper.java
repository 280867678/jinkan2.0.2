package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class ConfigurationHelper {
    public static int getDensityDpi(@NonNull Resources resources) {
        return resources.getConfiguration().densityDpi;
    }
}
