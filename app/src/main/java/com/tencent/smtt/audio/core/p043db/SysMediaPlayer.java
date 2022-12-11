package com.tencent.smtt.audio.core.p043db;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import com.tencent.common.http.MttLocalProxy;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IMediaPlayer;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/SysMediaPlayer.class
 */
/* renamed from: com.tencent.smtt.audio.core.db.SysMediaPlayer */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/SysMediaPlayer.class */
public class SysMediaPlayer extends MediaPlayer implements IMediaPlayer {
    @Override // android.media.MediaPlayer
    public /* bridge */ /* synthetic */ Object getTrackInfo() throws IllegalStateException {
        return super.getTrackInfo();
    }

    public void setPlaySpeed(float speed) {
        if (Build.VERSION.SDK_INT >= 23) {
            setPlaybackParams(getPlaybackParams().setSpeed(speed));
        }
    }

    @Override // android.media.MediaPlayer
    public void reset() {
        try {
            super.reset();
        } catch (Throwable e) {
            AudioLog.e("[SysMediaPlayer] reset exception", e);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        AudioLog.i("SysMediaPlayer::setDataSource,url=" + path);
        String path2 = MttLocalProxy.getInstance().getProxyURL(path);
        AudioLog.i("SysMediaPlayer::setDataSource,proxyUrl=" + path2);
        super.setDataSource(path2);
    }

    @Override // android.media.MediaPlayer
    public void pause() throws IllegalStateException {
        super.pause();
        AudioLog.i("SysMediaPlayer::pause");
    }

    @Override // android.media.MediaPlayer
    public void start() throws IllegalStateException {
        super.start();
        AudioLog.i("SysMediaPlayer::start");
    }

    @Override // android.media.MediaPlayer
    public void seekTo(int msec) throws IllegalStateException {
        super.seekTo(msec);
        AudioLog.i("SysMediaPlayer::seekTo" + msec);
    }

    @Override // android.media.MediaPlayer
    public int getDuration() {
        AudioLog.i("SysMediaPlayer::getDuration");
        return super.getDuration();
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String url = MttLocalProxy.getInstance().getProxyURL(uri.toString());
        Uri genUri = Uri.parse(url);
        AudioLog.i("SysMediaPlayer::setDataSource,url=" + genUri + "headers=" + headers);
        super.setDataSource(context, genUri, headers);
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String url = MttLocalProxy.getInstance().getProxyURL(uri.toString());
        Uri genUri = Uri.parse(url);
        super.setDataSource(context, uri);
        AudioLog.i("SysMediaPlayer::setDataSource,url=" + genUri);
    }
}
