package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.Map;
import me.tvspark.AbstractC2396n6;

/* renamed from: me.tvspark.r6 */
/* loaded from: classes4.dex */
public final class C2550r6 implements DrmSession {
    public final DrmSession.DrmSessionException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2550r6(DrmSession.DrmSessionException drmSessionException) {
        if (drmSessionException != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = drmSessionException;
            return;
        }
        throw null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public AbstractC2587s6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}
