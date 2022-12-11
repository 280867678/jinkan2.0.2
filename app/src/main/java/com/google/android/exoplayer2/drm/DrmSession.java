package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2587s6;

/* loaded from: classes3.dex */
public interface DrmSession {

    /* loaded from: classes3.dex */
    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }

    @Nullable
    DrmSessionException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Nullable
    AbstractC2587s6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Nullable
    Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int getState();
}
