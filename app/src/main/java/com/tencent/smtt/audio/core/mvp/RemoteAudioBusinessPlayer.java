package com.tencent.smtt.audio.core.mvp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.SystemClock;
import com.tencent.smtt.audio.core.utils.AudioPlayerInfoReporter;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.IMediaPlayer;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import com.tencent.smtt.audio.export.interfaces.RemoteMediaPlayer;
import com.tencent.smtt.audio.export.interfaces.RemotePlayerListener;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/RemoteAudioBusinessPlayer.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/RemoteAudioBusinessPlayer.class */
public class RemoteAudioBusinessPlayer implements RemoteMediaPlayer {
    IAudioBusinessWrapper wrapper;
    RemotePlayerListener mRemoteListener;
    RemotePlayerListener mUIRemoteListener;
    private IMediaPlayer mMediaPlayer;
    private static RemoteAudioBusinessPlayer instance = null;
    private long time;
    private static final int ERROR_WRONG_STATE = -107;
    private static final int ERROR_ACTION_IN_WRONG_STATE = -38;
    private int mId = 0;
    private boolean isAudioPlaying = false;
    public boolean isPlaying = false;
    public boolean isStarted = false;
    private boolean canPerformAction = false;
    TbsAudioEntity current = null;
    RemotePlayerListener localListener = new RemotePlayerListener() { // from class: com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer.6
        public void OnPrepared() {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().OnPrepared();
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.OnPrepared();
            }
        }

        public void OnCompletion() {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().OnCompletion();
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.OnCompletion();
            }
        }

        public void OnBufferingUpdate(int percent) {
            AudioLog.i("OnBufferingUpdate" + percent + RemoteAudioBusinessPlayer.this.mRemoteListener);
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().OnBufferingUpdate(percent);
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.OnBufferingUpdate(percent);
            }
        }

        public void OnSeekComplete() {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().OnSeekComplete();
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.OnSeekComplete();
            }
        }

        public void OnErrorListener(int what, int extra) {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().OnErrorListener(what, extra);
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.OnErrorListener(what, extra);
            }
        }

        public void onPauseByRemote() {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().onPauseByRemote();
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.onPauseByRemote();
            }
        }

        public void onPlayByRemote() {
            if (!RemoteAudioBusinessPlayer.this.canPerformAction) {
                return;
            }
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().onPlayByRemote();
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.onPlayByRemote();
            }
        }

        public void onSeekByRemote(int time) {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().onSeekByRemote(time);
            } else if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.onSeekByRemote(time);
            }
        }

        public void onMediaInterruptedByRemote() {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                RemoteAudioBusinessPlayer.this.getBusinessWrapper().onMediaInterruptedByRemote();
            }
            if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                RemoteAudioBusinessPlayer.this.mRemoteListener.onMediaInterruptedByRemote();
            }
        }

        public boolean isWebViewActive() {
            if (RemoteAudioBusinessPlayer.this.getBusinessWrapper() != null) {
                return RemoteAudioBusinessPlayer.this.getBusinessWrapper().isWebViewActive();
            }
            if (RemoteAudioBusinessPlayer.this.mRemoteListener != null) {
                return RemoteAudioBusinessPlayer.this.mRemoteListener.isWebViewActive();
            }
            return false;
        }
    };

    public void setCurrent(TbsAudioEntity current) {
        this.current = current;
    }

    public TbsAudioEntity getCurrent() {
        return this.current;
    }

    private RemoteAudioBusinessPlayer() {
    }

    public void setWrapper(IAudioBusinessWrapper wrapper) {
        if (this.wrapper != null && wrapper != null && !wrapper.equals(this.wrapper)) {
            AudioPlayerInfoReporter.reportAudioPlayerInfos();
        }
        this.wrapper = wrapper;
        if (wrapper != null) {
            wrapper.setMediaPlayer(this.mMediaPlayer);
        }
        AudioLog.i("setWrapper,wrapper=" + wrapper);
    }

    public static RemoteAudioBusinessPlayer getInstance() {
        synchronized (RemoteAudioBusinessPlayer.class) {
            if (instance == null) {
                instance = new RemoteAudioBusinessPlayer();
            }
        }
        return instance;
    }

    public void init(Context context, IMediaPlayer mediaPlayer, IAudioView view) {
        AudioLog.i("RemoteAudioBusinessPlayer init,player=" + mediaPlayer);
        this.mMediaPlayer = mediaPlayer;
        initListeners();
    }

    public void start() {
        AudioLog.i("RemoteAudioPlayer::start" + this.canPerformAction);
        if (this.canPerformAction) {
            this.isAudioPlaying = true;
            if (getBusinessWrapper() != null) {
                getBusinessWrapper().start();
            } else {
                this.mMediaPlayer.start();
            }
            this.isPlaying = true;
            if (!this.isStarted) {
                try {
                    TbsAudioEngine.getsInstance().getAudioPresenter().getView().onShowControllerView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AudioLog.i("onShowControllerView");
                this.isStarted = true;
            }
        }
    }

    public void seekTo(int time) {
        AudioLog.i("RemoteAudioPlayer::seekTo::" + time + this.canPerformAction);
        if (this.canPerformAction) {
            if (getBusinessWrapper() != null) {
                getBusinessWrapper().seekTo(time);
            } else {
                this.mMediaPlayer.seekTo(time);
            }
        }
    }

    public void pause() {
        if (this.canPerformAction) {
            AudioLog.i("RemoteAudioPlayer::pause" + this.canPerformAction);
            if (getBusinessWrapper() != null) {
                getBusinessWrapper().pause();
            } else {
                this.mMediaPlayer.pause();
            }
            this.isAudioPlaying = false;
        }
    }

    public void release() {
        AudioLog.i("RemoteAudioPlayer::release,wrapper = " + getBusinessWrapper());
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().release();
        } else {
            this.mMediaPlayer.release();
        }
    }

    public void prepare() throws IOException {
        AudioLog.i("RemoteAudioPlayer::prepare");
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().prepare();
        } else {
            this.mMediaPlayer.prepare();
        }
    }

    public void prepareAsync() {
        AudioLog.i("RemoteAudioPlayer::prepareAsync");
        this.time = SystemClock.elapsedRealtime();
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().prepareAsync();
        } else {
            this.mMediaPlayer.prepareAsync();
        }
    }

    public boolean isPlaying() {
        boolean isPlaying = false;
        try {
            if (getBusinessWrapper() != null) {
                isPlaying = getBusinessWrapper().isPlaying();
            } else {
                isPlaying = this.mMediaPlayer.isPlaying();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AudioLog.i("RemoteAudioPlayer::isPlaying" + isPlaying);
        return isPlaying;
    }

    public int getCurrentPosition() {
        int current = 0;
        try {
            if (this.canPerformAction) {
                if (getBusinessWrapper() != null) {
                    current = getBusinessWrapper().getCurrentPosition();
                } else {
                    current = this.mMediaPlayer.getCurrentPosition();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AudioLog.d("RemoteAudioPlayer::getCurrentPosition: " + current + ", canPerformAction: " + this.canPerformAction);
        return current;
    }

    public int getDuration() {
        int duration = 0;
        if (this.canPerformAction) {
            if (getBusinessWrapper() != null) {
                duration = getBusinessWrapper().getDuration();
            } else {
                duration = this.mMediaPlayer.getDuration();
            }
        }
        AudioLog.d("RemoteAudioPlayer::getDuration,duration=" + duration + this.canPerformAction);
        return duration;
    }

    public void setMediaExtra(String url, String title) {
        AudioLog.i("RemoteAudioPlayer::setMediaExtra,url=" + url + "title=" + title);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setMediaExtra(url, title);
        }
    }

    public void setAudioInfo(String key, String value) {
        AudioLog.i("RemoteAudioPlayer::setAudioInfo, key=" + key + "; value=" + value);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setAudioInfo(key, value);
        }
    }

    public String getAudioAuthor() {
        String author = null;
        if (getBusinessWrapper() != null) {
            author = getBusinessWrapper().getX5AudioAuthor();
        }
        return author;
    }

    public String getAudioTitle() {
        String title = null;
        if (getBusinessWrapper() != null) {
            title = getBusinessWrapper().getX5AudioTitle();
        }
        return title;
    }

    public String getX5AudioCoverUrl() {
        String url = null;
        if (getBusinessWrapper() != null) {
            url = getBusinessWrapper().getX5AudioCoverUrl();
        }
        return url;
    }

    public void setDataSource(Context context, Uri uri, HashMap<String, String> headersMap) throws IOException {
        AudioLog.i("RemoteAudioPlayer::setDataSource,uri=" + uri + "headersMap=" + headersMap);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setDataSource(context, uri, headersMap);
        } else {
            this.mMediaPlayer.setDataSource(context, uri, headersMap);
        }
        this.canPerformAction = false;
    }

    public void setDataSource(FileDescriptor fileDescriptor, long offset, long length) throws IOException {
        AudioLog.i("RemoteAudioPlayer::setDataSource,fileDescriptor=" + fileDescriptor + "offset=" + offset + "length=" + length);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setDataSource(fileDescriptor, offset, length);
        } else {
            this.mMediaPlayer.setDataSource(fileDescriptor, offset, length);
        }
        this.canPerformAction = false;
    }

    public void setDataSource(Context mContext, Uri fromFile) throws IOException {
        AudioLog.i("RemoteAudioPlayer::setDataSource,uri=" + fromFile);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setDataSource(mContext, fromFile);
        } else {
            this.mMediaPlayer.setDataSource(mContext, fromFile);
        }
        this.canPerformAction = false;
    }

    public void setDataSource(String url) throws IOException {
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setDataSource(url);
        } else {
            this.mMediaPlayer.setDataSource(url);
        }
        this.canPerformAction = false;
    }

    public void setVolume(float volume, float volume2) {
        AudioLog.i("RemoteAudioPlayer::setVolume,volume=" + volume + "volume2=" + volume2 + this.mMediaPlayer);
        try {
            if (getBusinessWrapper() != null) {
                getBusinessWrapper().setVolume(volume, volume2);
            } else {
                this.mMediaPlayer.setVolume(volume, volume2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMediaPlayerListener(RemotePlayerListener listener) {
        this.mRemoteListener = listener;
        AudioLog.i("RemoteAudioPlayer::setMediaPlayerListener,listener=" + listener);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setMediaPlayerListener(listener);
        }
    }

    public Object getTrackInfo() {
        AudioLog.i("RemoteAudioPlayer::getTrackInfo");
        if (getBusinessWrapper() != null) {
            return getBusinessWrapper().getTrackInfo();
        }
        return this.mMediaPlayer.getTrackInfo();
    }

    public void reset() {
        AudioLog.i("RemoteAudioPlayer::reset");
        this.canPerformAction = false;
        try {
            if (getBusinessWrapper() != null) {
                getBusinessWrapper().reset();
            } else {
                this.mMediaPlayer.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        AudioLog.i("RemoteAudioPlayer::stop");
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().stop();
        } else {
            this.mMediaPlayer.stop();
        }
    }

    public void setSpeedType(float speed) {
        AudioLog.i("RemoteAudioPlayer::setSpeedType" + speed);
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().setSpeedType(speed);
        } else {
            this.mMediaPlayer.setPlaySpeed(speed);
        }
        if (!this.isAudioPlaying) {
            pause();
        }
    }

    public void setUIMediaPlayerListener(RemotePlayerListener listener) {
    }

    private void initListeners() {
        AudioLog.i("init local MediaPlayerListeners");
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AudioLog.i("RemoteAudioPlayer::onCompletion" + mediaPlayer + RemoteAudioBusinessPlayer.this.getBusinessWrapper());
                TbsAudioEngine.getsInstance().getAudioPresenter().getView().onCompletion(RemoteAudioBusinessPlayer.this.getCurrent());
                RemoteAudioBusinessPlayer.this.localListener.OnCompletion();
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                long cost = SystemClock.elapsedRealtime() - RemoteAudioBusinessPlayer.this.time;
                AudioLog.i("RemoteAudioPlayer::OnPrepared" + mediaPlayer + "cost=" + cost);
                RemoteAudioBusinessPlayer.this.canPerformAction = true;
                RemoteAudioBusinessPlayer.this.localListener.OnPrepared();
                try {
                    TbsAudioEngine.getsInstance().getAudioPresenter().getView().onPrepared(cost, RemoteAudioBusinessPlayer.this.getCurrent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer.3
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                AudioLog.i("RemoteAudioPlayer::onBufferingUpdate" + mediaPlayer + "i=" + i);
                RemoteAudioBusinessPlayer.this.localListener.OnBufferingUpdate(i);
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer.4
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                AudioLog.i("RemoteAudioPlayer::onSeekComplete" + mediaPlayer);
                RemoteAudioBusinessPlayer.this.localListener.OnSeekComplete();
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                AudioLog.i("RemoteAudioPlayer::onError" + mediaPlayer + "i=" + i + "i1=" + i1);
                if (RemoteAudioBusinessPlayer.this.needProcessErrorCode(i, i1)) {
                    return true;
                }
                RemoteAudioBusinessPlayer.this.localListener.OnErrorListener(i, i1);
                TbsAudioEngine.getsInstance().getAudioPresenter().getView().onError(i, i1);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IAudioBusinessWrapper getBusinessWrapper() {
        return this.wrapper;
    }

    public boolean isAudioPlaying() {
        AudioLog.i("isAudioPlaying=" + this.isAudioPlaying + this);
        return this.isAudioPlaying;
    }

    public void realRelease() {
        AudioPlayerInfoReporter.reportAudioPlayerInfos();
        this.canPerformAction = false;
        this.isAudioPlaying = false;
        this.isStarted = false;
        this.isPlaying = false;
        if (getBusinessWrapper() != null) {
            getBusinessWrapper().realRelease();
        } else if (this.mRemoteListener != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void resetForNextAudioPlayIfNeed() {
        AudioLog.i("prepareAudioPlayerForSingleMediaPlayer isPlaying=" + this.isPlaying + this);
        if (this.isPlaying) {
            AudioLog.i("switch audio,reset origin mediaplayer");
            this.localListener.onMediaInterruptedByRemote();
            reset();
            AudioPresenterImpl.getInstance().resetStatus();
            return;
        }
        this.isPlaying = true;
    }

    public void setCanPerformAction(boolean canPerformAction) {
        this.canPerformAction = canPerformAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needProcessErrorCode(int i, int i1) {
        if (i == -38 || i1 == -107) {
            return true;
        }
        return false;
    }
}
