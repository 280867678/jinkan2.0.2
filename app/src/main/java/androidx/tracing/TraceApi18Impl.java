package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes3.dex */
public final class TraceApi18Impl {
    public static void beginSection(@NonNull String str) {
        android.os.Trace.beginSection(str);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
