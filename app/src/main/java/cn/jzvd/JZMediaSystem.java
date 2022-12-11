package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import cn.jzvd.JZMediaSystem;
import java.util.Map;
import me.tvspark.Wwwwww;
import me.tvspark.Wwwwwwwww;

/* loaded from: classes3.dex */
public class JZMediaSystem extends Wwwwwwwww implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer mediaPlayer;

    public JZMediaSystem(Wwwwww wwwwww) {
        super(wwwwww);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaPlayer mediaPlayer, HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.mediaPlayer.start();
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setLooping(this.jzvd.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnBufferingUpdateListener(this);
            this.mediaPlayer.setScreenOnWhilePlaying(true);
            this.mediaPlayer.setOnSeekCompleteListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.setOnInfoListener(this);
            this.mediaPlayer.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.mediaPlayer, this.jzvd.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString(), this.jzvd.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setSurface(new Surface(Wwwwwwwww.SAVED_SURFACE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.mediaPlayer.pause();
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.jzvd != null) {
            return;
        }
        throw null;
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.jzvd.setBufferProgress(i);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        try {
            if (this.mediaPlayer == null) {
                return;
            }
            this.mediaPlayer.seekTo((int) j);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public long getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // me.tvspark.Wwwwwwwww
    public long getDuration() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // me.tvspark.Wwwwwwwww
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = Wwwwwwwww.SAVED_SURFACE;
        if (surfaceTexture2 != null) {
            this.jzvd.Wwwww.setSurfaceTexture(surfaceTexture2);
            return;
        }
        Wwwwwwwww.SAVED_SURFACE = surfaceTexture;
        prepare();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void pause() {
        try {
            if (this.mMediaHandler == null || this.mediaPlayer == null) {
                return;
            }
            if (this.mediaPlayer == null) {
                return;
            }
            try {
                this.mMediaHandler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwww
                    @Override // java.lang.Runnable
                    public final void run() {
                        JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                });
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void prepare() {
        release();
        HandlerThread handlerThread = new HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new Handler(this.mMediaHandlerThread.getLooper());
        this.handler = new Handler();
        this.mMediaHandler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void release() {
        final HandlerThread handlerThread;
        final MediaPlayer mediaPlayer;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        Wwwwwwwww.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaPlayer, handlerThread);
            }
        });
        this.mediaPlayer = null;
    }

    @Override // me.tvspark.Wwwwwwwww
    public void seekTo(final long j) {
        Handler handler = this.mMediaHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwwww
                @Override // java.lang.Runnable
                public final void run() {
                    JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                }
            });
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    @RequiresApi(api = 23)
    public void setSpeed(float f) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f);
            this.mediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setVolume(final float f, final float f2) {
        Handler handler = this.mMediaHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2);
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void start() {
        try {
            if (this.mMediaHandler == null || this.mediaPlayer == null) {
                return;
            }
            this.mMediaHandler.post(new Runnable() { // from class: me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwww
                @Override // java.lang.Runnable
                public final void run() {
                    JZMediaSystem.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
