package com.tencent.smtt.audio.core.mvp;

import android.content.Context;
import android.net.Uri;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.IMediaPlayer;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.interfaces.RemotePlayerListener;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/DefaultAudioPlayerBusinessWrapper.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/DefaultAudioPlayerBusinessWrapper.class */
public class DefaultAudioPlayerBusinessWrapper implements IAudioBusinessWrapper {
    IMediaPlayer mMediaPlayer;
    RemotePlayerListener mPlayerListener;
    public static final int ERROR_WRONG_STATE = -38;
    private static DefaultAudioPlayerBusinessWrapper instance = null;
    String origin_url = "";
    String origin_title = "";
    public boolean isError = false;
    private String x5_audio_author = "";
    private String x5_audio_title = "";
    private String x5_audio_cover_url = "";

    public static DefaultAudioPlayerBusinessWrapper getInstance() {
        synchronized (DefaultAudioPlayerBusinessWrapper.class) {
            if (instance == null) {
                instance = new DefaultAudioPlayerBusinessWrapper();
            }
        }
        return instance;
    }

    public void OnPrepared() {
        if (this.mPlayerListener != null) {
            this.mPlayerListener.OnPrepared();
        }
    }

    public void OnCompletion() {
        AudioLog.i("DefaultAudioPlayerBusinessWrapper::OnCompletion" + this);
        if (this.mPlayerListener != null) {
            this.mPlayerListener.OnCompletion();
        } else {
            TbsAudioEngine.getsInstance().getAudioPresenter().exit();
        }
    }

    public void OnBufferingUpdate(int percent) {
        AudioLog.i("DefaultAudioPlayerBusinessWrapper OnBufferingUpdate,percent=" + percent + "listener=" + this.mPlayerListener);
        if (this.mPlayerListener != null) {
            this.mPlayerListener.OnBufferingUpdate(percent);
        }
        IAudioView audioView = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
        if (audioView != null) {
            audioView.onBufferingUpdate(percent);
        }
    }

    public void OnSeekComplete() {
        if (this.mPlayerListener != null) {
            this.mPlayerListener.OnSeekComplete();
        }
        IAudioView audioView = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
        if (audioView != null) {
            audioView.OnSeekComplete();
        }
    }

    public void OnErrorListener(int what, int extra) {
        if (what == -38) {
            AudioLog.i("is Error = true");
            this.isError = true;
        }
        reset();
        if (this.mPlayerListener != null) {
            this.mPlayerListener.OnErrorListener(what, extra);
        }
    }

    public void onPauseByRemote() {
        AudioLog.i("DefaultAudioPlayerBusinessWrapper::onPauseByRemote");
        pause();
        if (this.mPlayerListener != null) {
            this.mPlayerListener.onPauseByRemote();
        }
    }

    public void onPlayByRemote() {
        AudioLog.i("DefaultAudioPlayerBusinessWrapper::onPlayByRemote");
        start();
        if (this.mPlayerListener != null) {
            this.mPlayerListener.onPlayByRemote();
        }
    }

    public void onSeekByRemote(int time) {
        AudioLog.i("DefaultAudioPlayerBusinessWrapper::onSeekByRemote");
        seekTo(time);
        if (this.mPlayerListener != null) {
            this.mPlayerListener.onSeekByRemote(time);
        }
    }

    public void onMediaInterruptedByRemote() {
        if (this.mPlayerListener != null) {
            this.mPlayerListener.onMediaInterruptedByRemote();
        }
    }

    public boolean isWebViewActive() {
        if (this.mPlayerListener != null) {
            return this.mPlayerListener.isWebViewActive();
        }
        return false;
    }

    public void start() {
        if (this.mMediaPlayer != null && AudioFocusChangeListener.getInstance().isFocusChange(true)) {
            this.mMediaPlayer.start();
            IAudioView audioView = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
            if (audioView != null) {
                audioView.onAudioPlay();
            }
            AudioLog.i("DefaultAudioPlayerBusinessWrapper::start" + TbsAudioEngine.getsInstance().getAudioPresenter().getView());
        }
    }

    public void seekTo(int time) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(time);
        }
        AudioLog.i("DefaultAudioPlayerBusinessWrapper::seekTo" + time + TbsAudioEngine.getsInstance().getAudioPresenter().getView());
    }

    public void pause() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.pause();
        }
        IAudioView audioView = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
        if (audioView != null) {
            audioView.onAudioPause();
        }
        AudioLog.i("DefaultAudioPlayerBusinessWrapper::pause" + TbsAudioEngine.getsInstance().getAudioPresenter().getView());
    }

    public void release() {
    }

    public void prepare() throws IOException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.prepare();
        }
    }

    public void prepareAsync() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.prepareAsync();
        }
    }

    public boolean isPlaying() {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.isPlaying();
        }
        return false;
    }

    public int getCurrentPosition() {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.getDuration();
        }
        return 0;
    }

    public void setMediaExtra(String url, String title) {
        this.origin_title = title;
        this.origin_url = url;
        resetX5AudioInfo();
    }

    public void setAudioInfo(String key, String value) {
        AudioLog.e("setAudioInfo -- key: " + key + ", value: " + value);
        if ("x5-audio-author".equals(key)) {
            this.x5_audio_author = value;
        } else if ("x5-audio-title".equals(key)) {
            this.x5_audio_title = value;
        } else if ("x5-audio-cover".equals(key)) {
            this.x5_audio_cover_url = value;
        } else {
            AudioLog.e("setAudioInfo -- key: " + key + ", value: " + value);
        }
    }

    protected void resetX5AudioInfo() {
        this.x5_audio_author = "";
        this.x5_audio_title = "";
        this.x5_audio_cover_url = "";
    }

    @Override // com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public String getX5AudioAuthor() {
        return this.x5_audio_author;
    }

    @Override // com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public String getX5AudioTitle() {
        return this.x5_audio_title;
    }

    @Override // com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public String getX5AudioCoverUrl() {
        return this.x5_audio_cover_url;
    }

    public void setDataSource(Context context, Uri uri, HashMap<String, String> headersMap) throws IOException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setDataSource(context, uri, headersMap);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor, long offset, long length) throws IOException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setDataSource(fileDescriptor, offset, length);
        }
    }

    public void setDataSource(Context mContext, Uri fromFile) throws IOException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setDataSource(mContext, fromFile);
        }
    }

    public void setDataSource(String url) throws IOException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setDataSource(url);
        }
    }

    public void setVolume(float volume, float volume2) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(volume, volume2);
        }
    }

    public void setMediaPlayerListener(RemotePlayerListener listener) {
        this.mPlayerListener = listener;
    }

    public Object getTrackInfo() {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.getTrackInfo();
        }
        return null;
    }

    public void reset() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
        }
    }

    public void stop() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
        }
    }

    public void setSpeedType(float speed) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setPlaySpeed(speed);
        }
    }

    public void setUIMediaPlayerListener(RemotePlayerListener listener) {
    }

    @Override // com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public void setMediaPlayer(IMediaPlayer mediaPlayer) {
        this.mMediaPlayer = mediaPlayer;
    }

    @Override // com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public void resetStatus() {
        AudioLog.i("reset status");
        this.isError = false;
    }

    @Override // com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public synchronized void realRelease() {
        AudioLog.i("realRelease: " + this.mMediaPlayer);
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }
}
