package me.tvspark.utils.player;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import me.tvspark.Wwwwww;
import me.tvspark.Wwwwwwwww;
import me.tvspark.utils.player.JZMediaIjk;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;

/* loaded from: classes4.dex */
public class JZMediaIjk extends Wwwwwwwww implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnVideoSizeChangedListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnTimedTextListener {
    public IjkMediaPlayer ijkMediaPlayer;

    public JZMediaIjk(Wwwwww wwwwww) {
        super(wwwwww);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IjkMediaPlayer ijkMediaPlayer, HandlerThread handlerThread) {
        ijkMediaPlayer.setSurface(null);
        ijkMediaPlayer.release();
        handlerThread.quit();
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        this.ijkMediaPlayer = ijkMediaPlayer;
        try {
            ijkMediaPlayer.setOption(1, "analyzemaxduration", 100L);
            this.ijkMediaPlayer.setOption(4, "packet-buffering", 1L);
            this.ijkMediaPlayer.setOption(1, "rtsp_transport", "tcp");
            this.ijkMediaPlayer.setOption(4, "max-buffer-size", 1048576L);
            this.ijkMediaPlayer.setOption(4, "soundtouch", 1L);
            this.ijkMediaPlayer.setOption(1, "allowed_extensions", "ALL");
            this.ijkMediaPlayer.setOption(1, "protocol_whitelist", "crypto,file,http,https,tcp,tls,udp");
            this.ijkMediaPlayer.setOnPreparedListener(this);
            this.ijkMediaPlayer.setOnVideoSizeChangedListener(this);
            this.ijkMediaPlayer.setOnCompletionListener(this);
            this.ijkMediaPlayer.setOnErrorListener(this);
            this.ijkMediaPlayer.setOnInfoListener(this);
            this.ijkMediaPlayer.setOnBufferingUpdateListener(this);
            this.ijkMediaPlayer.setOnSeekCompleteListener(this);
            this.ijkMediaPlayer.setOnTimedTextListener(this);
            this.ijkMediaPlayer.setDataSource(this.jzvd.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString());
            this.ijkMediaPlayer.setAudioStreamType(3);
            this.ijkMediaPlayer.setScreenOnWhilePlaying(true);
            this.ijkMediaPlayer.prepareAsync();
            if (this.jzvd.Wwwww == null || this.jzvd.Wwwww.getSurfaceTexture() == null) {
                return;
            }
            this.ijkMediaPlayer.setSurface(new Surface(this.jzvd.Wwwww.getSurfaceTexture()));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.jzvd.setBufferProgress(i);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IMediaPlayer iMediaPlayer) {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iMediaPlayer.getVideoWidth(), iMediaPlayer.getVideoHeight());
    }

    @Override // me.tvspark.Wwwwwwwww
    public long getCurrentPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // me.tvspark.Wwwwwwwww
    public long getDuration() {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // me.tvspark.Wwwwwwwww
    public boolean isPlaying() {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, final int i) {
        this.handler.post(new Runnable() { // from class: me.tvspark.zq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        this.handler.post(new Runnable() { // from class: me.tvspark.vq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: me.tvspark.br0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        });
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, final int i, final int i2) {
        this.handler.post(new Runnable() { // from class: me.tvspark.yq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        });
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        this.handler.post(new Runnable() { // from class: me.tvspark.uq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        this.handler.post(new Runnable() { // from class: me.tvspark.xq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
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

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
    public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(final IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
        this.handler.post(new Runnable() { // from class: me.tvspark.cr0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iMediaPlayer);
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void pause() {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.pause();
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
        this.mMediaHandler.post(new Runnable() { // from class: me.tvspark.wq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void release() {
        final HandlerThread handlerThread;
        final IjkMediaPlayer ijkMediaPlayer;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (ijkMediaPlayer = this.ijkMediaPlayer) == null) {
            return;
        }
        Wwwwwwwww.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: me.tvspark.ar0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaIjk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IjkMediaPlayer.this, handlerThread);
            }
        });
        this.ijkMediaPlayer = null;
    }

    @Override // me.tvspark.Wwwwwwwww
    public void seekTo(long j) {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.seekTo(j);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setSpeed(float f) {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSpeed(f);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setSurface(Surface surface) {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSurface(surface);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setVolume(float f, float f2) {
        IjkMediaPlayer ijkMediaPlayer = this.ijkMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setVolume(f, f2);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void start() {
        try {
            if (this.ijkMediaPlayer == null) {
                return;
            }
            this.ijkMediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
