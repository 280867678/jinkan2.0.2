package androidx.core.p003os;

import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;

/* renamed from: androidx.core.os.EnvironmentCompat */
/* loaded from: classes3.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    public static final String TAG = "EnvironmentCompat";

    @NonNull
    public static String getStorageState(@NonNull File file) {
        return Environment.getExternalStorageState(file);
    }
}
