package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
/* loaded from: classes3.dex */
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int[] Wwwwwwwwwwwwwwwww = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    @Nullable
    public SurfaceTexture Wwwwwwwwwwwwwwwwww;
    @Nullable
    public EGLSurface Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public EGLContext Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public EGLDisplay Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww = null;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwww = new int[1];
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public EGLSurfaceTexture(Handler handler) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = handler;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        SurfaceTexture surfaceTexture = this.Wwwwwwwwwwwwwwwwww;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
