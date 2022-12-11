package com.tencent.smtt.audio.core.mvp;

import android.content.Context;
import android.net.Uri;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.interfaces.RemoteMediaPlayer;
import com.tencent.smtt.audio.export.interfaces.RemotePlayerListener;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/RemotePlayerProxy.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/RemotePlayerProxy.class */
public class RemotePlayerProxy implements RemoteMediaPlayer {
    private RemotePlayerListener mPlayerListener = null;
    private boolean isReleased = false;

    public void start() {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().start();
        }
    }

    public void seekTo(int time) {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().seekTo(time);
        }
    }

    public void pause() {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().pause();
        }
    }

    public void release() {
        this.isReleased = true;
        this.mPlayerListener = null;
        RemoteAudioBusinessPlayer.getInstance().release();
    }

    public void prepare() throws IOException {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().prepare();
        }
    }

    public void prepareAsync() {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().prepareAsync();
        }
    }

    public boolean isPlaying() {
        if (!this.isReleased) {
            return RemoteAudioBusinessPlayer.getInstance().isPlaying();
        }
        return false;
    }

    public int getCurrentPosition() {
        if (!this.isReleased) {
            return RemoteAudioBusinessPlayer.getInstance().getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (!this.isReleased) {
            return RemoteAudioBusinessPlayer.getInstance().getDuration();
        }
        return 0;
    }

    public void setMediaExtra(String url, String title) {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setMediaExtra(url, title);
        }
    }

    public void setAudioInfo(String key, String value) {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setAudioInfo(key, value);
        }
    }

    public void setDataSource(Context context, Uri uri, HashMap<String, String> headersMap) throws IOException {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setDataSource(context, uri, headersMap);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor, long offset, long length) throws IOException {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setDataSource(fileDescriptor, offset, length);
        }
    }

    public void setDataSource(Context mContext, Uri fromFile) throws IOException {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setDataSource(mContext, fromFile);
        }
    }

    public void setDataSource(String url) throws IOException {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setDataSource(url);
        }
    }

    public void setVolume(float volume, float volume2) {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setVolume(volume, volume2);
        }
    }

    public void setMediaPlayerListener(RemotePlayerListener listener) {
        if (!this.isReleased) {
            this.mPlayerListener = listener;
            AudioLog.i("RemotePlayerProxy::setMediaPlayerListener" + listener);
            RemoteAudioBusinessPlayer.getInstance().setMediaPlayerListener(new RemotePlayerListener() { // from class: com.tencent.smtt.audio.core.mvp.RemotePlayerProxy.1
                public void OnPrepared() {
                    AudioLog.i("RemotePlayerProxy::OnPrepared" + this);
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.OnPrepared();
                    }
                }

                public void OnCompletion() {
                    AudioLog.i("RemotePlayerProxy::OnCompletion" + this);
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.OnCompletion();
                    }
                }

                public void OnBufferingUpdate(int percent) {
                    AudioLog.i("RemotePlayerProxy::OnBufferingUpdate" + percent + this);
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.OnBufferingUpdate(percent);
                    }
                }

                public void OnSeekComplete() {
                    AudioLog.i("RemotePlayerProxy::OnSeekComplete" + this);
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.OnSeekComplete();
                    }
                }

                public void OnErrorListener(int what, int extra) {
                    AudioLog.i("RemotePlayerProxy::OnErrorListener");
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.OnErrorListener(what, extra);
                    }
                }

                public void onPauseByRemote() {
                    AudioLog.i("RemotePlayerProxy::onPauseByRemote");
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.onPauseByRemote();
                    }
                }

                public void onPlayByRemote() {
                    AudioLog.i("RemotePlayerProxy::onPlayByRemote");
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.onPlayByRemote();
                    }
                }

                public void onSeekByRemote(int time) {
                    AudioLog.i("RemotePlayerProxy::onSeekByRemote");
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.onSeekByRemote(time);
                    }
                }

                public void onMediaInterruptedByRemote() {
                    AudioLog.i("RemotePlayerProxy::onMediaInterruptedByRemote" + this + RemotePlayerProxy.this.mPlayerListener);
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        RemotePlayerProxy.this.mPlayerListener.onMediaInterruptedByRemote();
                    }
                    RemotePlayerProxy.this.mPlayerListener = null;
                }

                public boolean isWebViewActive() {
                    if (RemotePlayerProxy.this.mPlayerListener != null) {
                        return RemotePlayerProxy.this.mPlayerListener.isWebViewActive();
                    }
                    return false;
                }
            });
        }
    }

    public Object getTrackInfo() {
        if (!this.isReleased) {
            return RemoteAudioBusinessPlayer.getInstance().getTrackInfo();
        }
        return null;
    }

    public void reset() {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().reset();
        }
    }

    public void stop() {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().stop();
        }
    }

    public void setSpeedType(float speed) {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setSpeedType(speed);
        }
    }

    public void setUIMediaPlayerListener(RemotePlayerListener listener) {
        if (!this.isReleased) {
            RemoteAudioBusinessPlayer.getInstance().setUIMediaPlayerListener(listener);
        }
    }
}
