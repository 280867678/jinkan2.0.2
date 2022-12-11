package me.tvspark;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes4.dex */
public abstract class Wwwwwwwww implements TextureView.SurfaceTextureListener {
    public static SurfaceTexture SAVED_SURFACE;
    public Handler handler;
    public Wwwwww jzvd;
    public Handler mMediaHandler;
    public HandlerThread mMediaHandlerThread;

    public Wwwwwwwww(Wwwwww wwwwww) {
        this.jzvd = wwwwww;
    }

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void prepare();

    public abstract void release();

    public abstract void seekTo(long j);

    public abstract void setSpeed(float f);

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f, float f2);

    public abstract void start();
}
