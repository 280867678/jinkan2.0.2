package tv.danmaku.ijk.media.player;

import android.graphics.SurfaceTexture;

/* loaded from: classes5.dex */
public interface ISurfaceTextureHolder {
    SurfaceTexture getSurfaceTexture();

    void setSurfaceTexture(SurfaceTexture surfaceTexture);

    void setSurfaceTextureHost(ISurfaceTextureHost iSurfaceTextureHost);
}
