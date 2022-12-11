package com.tencent.smtt.audio.core.mvp;

import com.tencent.smtt.audio.export.IMediaPlayer;
import com.tencent.smtt.audio.export.interfaces.RemoteMediaPlayer;
import com.tencent.smtt.audio.export.interfaces.RemotePlayerListener;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/IAudioBusinessWrapper.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/IAudioBusinessWrapper.class */
public interface IAudioBusinessWrapper extends RemoteMediaPlayer, RemotePlayerListener {
    void setMediaPlayer(IMediaPlayer iMediaPlayer);

    void resetStatus();

    void realRelease();

    String getX5AudioAuthor();

    String getX5AudioTitle();

    String getX5AudioCoverUrl();
}
