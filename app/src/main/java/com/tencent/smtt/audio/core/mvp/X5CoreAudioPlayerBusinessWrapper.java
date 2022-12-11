package com.tencent.smtt.audio.core.mvp;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.http.MttLocalProxy;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import com.tencent.smtt.audio.export.interfaces.RemotePlayerListener;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/X5CoreAudioPlayerBusinessWrapper.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/X5CoreAudioPlayerBusinessWrapper.class */
public class X5CoreAudioPlayerBusinessWrapper extends DefaultAudioPlayerBusinessWrapper {
    private static X5CoreAudioPlayerBusinessWrapper instance = null;
    private static final int MSG_WRITE_INFO_AND_UPDATE_UI = 1;
    private static final int MSG_AUDIO_INFO_UPDATE = 2;
    private Handler handler;
    private static final long DELAY_MILLIS = 1000;
    private boolean isReleasedByCore = false;
    private boolean isCompletion = false;
    private Handler mHandler = new Handler() { // from class: com.tencent.smtt.audio.core.mvp.X5CoreAudioPlayerBusinessWrapper.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    try {
                        Bundle bundle = msg.getData();
                        String url = bundle.getString("url");
                        String name = bundle.getString("name");
                        long lastPlayTime = bundle.getLong("lastPlayTime");
                        String artist = bundle.getString("artist");
                        String origin_url = bundle.getString("origin_url");
                        int durationInt = bundle.getInt("durationInt");
                        String cover_url = bundle.getString("cover_url");
                        TbsAudioEntity entity = new TbsAudioEntity();
                        entity.setAudioURL(url);
                        entity.setTitle(name);
                        entity.setValid(true);
                        entity.setCoverURL(cover_url);
                        entity.setLastPlayTime(lastPlayTime);
                        entity.setArtist(artist);
                        entity.setOriginWebUrl(origin_url);
                        entity.setTotalTime(durationInt);
                        X5CoreAudioPlayerBusinessWrapper.this.addToPlayListAndUpdateUI(entity);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 2:
                    TbsAudioEntity entity2 = TbsAudioEngine.getsInstance().getAudioPresenter().getCurrentEntity();
                    if (entity2 instanceof TbsAudioEntity) {
                        TbsAudioEngine.getsInstance().getAudioPresenter().removeFormCurrentPlayList(entity2);
                        String x5_title = X5CoreAudioPlayerBusinessWrapper.this.getX5AudioTitle();
                        String x5_artist = X5CoreAudioPlayerBusinessWrapper.this.getX5AudioAuthor();
                        String x5_cover_url = X5CoreAudioPlayerBusinessWrapper.this.getX5AudioCoverUrl();
                        entity2.setArtist(x5_artist);
                        entity2.setTitle(x5_title);
                        entity2.setCoverURL(x5_cover_url);
                        X5CoreAudioPlayerBusinessWrapper.this.addToPlayListAndUpdateUI(entity2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private long last_update_time = 0;
    private HandlerThread mHandlerThread = new HandlerThread("AUDIO_HANDLER_THREAD");

    private X5CoreAudioPlayerBusinessWrapper() {
        this.handler = null;
        this.mHandlerThread.start();
        this.handler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.tencent.smtt.audio.core.mvp.X5CoreAudioPlayerBusinessWrapper.1
            @Override // android.os.Handler
            @TargetApi(14)
            public void handleMessage(Message msg1) {
                try {
                    String url = (String) msg1.obj;
                    MediaMetadataRetriever myretrier = new MediaMetadataRetriever();
                    String url2 = MttLocalProxy.getInstance().getProxyURL(url);
                    AudioLog.i("getMediaInfoAndWriteToDB, handleMessage,url=" + url2);
                    myretrier.setDataSource(url2, new HashMap());
                    String default_name = myretrier.extractMetadata(7);
                    String duration = myretrier.extractMetadata(9);
                    String default_artist = myretrier.extractMetadata(2);
                    String name = X5CoreAudioPlayerBusinessWrapper.this.getX5AudioTitle();
                    String artist = X5CoreAudioPlayerBusinessWrapper.this.getX5AudioAuthor();
                    String cover_url = X5CoreAudioPlayerBusinessWrapper.this.getX5AudioCoverUrl();
                    if (TextUtils.isEmpty(name)) {
                        name = default_name;
                    }
                    if (TextUtils.isEmpty(artist)) {
                        artist = default_artist;
                    }
                    int durationInt = -1;
                    try {
                        durationInt = Integer.parseInt(duration);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (durationInt == 0) {
                        return;
                    }
                    if (TextUtils.isEmpty(name)) {
                        name = X5CoreAudioPlayerBusinessWrapper.this.origin_title;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("cover_url", cover_url);
                    bundle.putString("url", url);
                    bundle.putString("name", name);
                    bundle.putLong("lastPlayTime", System.currentTimeMillis());
                    bundle.putString("artist", artist);
                    bundle.putString("origin_url", X5CoreAudioPlayerBusinessWrapper.this.origin_url);
                    bundle.putInt("durationInt", durationInt);
                    Message msg = new Message();
                    msg.setData(bundle);
                    msg.what = 1;
                    X5CoreAudioPlayerBusinessWrapper.this.mHandler.sendMessage(msg);
                } catch (Throwable e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static X5CoreAudioPlayerBusinessWrapper getInstance() {
        synchronized (X5CoreAudioPlayerBusinessWrapper.class) {
            if (instance == null) {
                instance = new X5CoreAudioPlayerBusinessWrapper();
            }
        }
        return instance;
    }

    public boolean isReleasedByCore() {
        return this.isReleasedByCore;
    }

    public void setReleasedByCore(boolean releasedByCore) {
        this.isReleasedByCore = releasedByCore;
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void release() {
        RemoteAudioBusinessPlayer.getInstance().setCanPerformAction(true);
        if (this.isCompletion) {
            TbsAudioEngine.getsInstance().getAudioPresenter().exit();
        }
        this.isReleasedByCore = true;
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void onPauseByRemote() {
        AudioLog.i("X5CoreAudioPlayerBusinessWrapper::onPauseByRemote" + this.isReleasedByCore);
        if (!this.isReleasedByCore) {
            this.mPlayerListener.onPauseByRemote();
        } else {
            RemoteAudioBusinessPlayer.getInstance().pause();
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void onPlayByRemote() {
        AudioLog.i("X5CoreAudioPlayerBusinessWrapper::onPlayByRemote" + this.isReleasedByCore);
        if (!this.isReleasedByCore) {
            this.mPlayerListener.onPlayByRemote();
        } else {
            RemoteAudioBusinessPlayer.getInstance().start();
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void onSeekByRemote(int time) {
        AudioLog.i("X5CoreAudioPlayerBusinessWrapper::onSeekByRemote" + this.isReleasedByCore);
        if (!this.isReleasedByCore) {
            this.mPlayerListener.onSeekByRemote(time);
        } else {
            RemoteAudioBusinessPlayer.getInstance().seekTo(time);
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void setAudioInfo(String key, String value) {
        super.setAudioInfo(key, value);
        long current = System.currentTimeMillis();
        long interval = current - this.last_update_time;
        this.last_update_time = current;
        AudioLog.i("X5CoreAudioPlayerBusinessWrapper::setAudioInfo & update -- (" + key + ") interval: " + interval);
        if (interval > 1000) {
            Message msg = new Message();
            msg.what = 2;
            this.mHandler.sendMessageDelayed(msg, 1000L);
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper, com.tencent.smtt.audio.core.mvp.IAudioBusinessWrapper
    public void resetStatus() {
        AudioLog.i("X5CoreAudioPlayerBusinessWrapper::resetStatus");
        if (this.mPlayerListener != null) {
            this.mPlayerListener.onMediaInterruptedByRemote();
        }
        this.isReleasedByCore = false;
        this.isCompletion = false;
        super.resetStatus();
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void setMediaPlayerListener(RemotePlayerListener listener) {
        super.setMediaPlayerListener(listener);
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void setDataSource(String url) throws IOException {
        super.setDataSource(url);
        getMediaInfoAndWriteToDB(url);
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void setDataSource(Context mContext, Uri fromFile) throws IOException {
        super.setDataSource(mContext, fromFile);
        getMediaInfoAndWriteToDB(fromFile.toString());
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void setDataSource(Context context, Uri uri, HashMap<String, String> headersMap) throws IOException {
        super.setDataSource(context, uri, headersMap);
        getMediaInfoAndWriteToDB(uri.toString());
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void setDataSource(FileDescriptor fileDescriptor, long offset, long length) throws IOException {
        super.setDataSource(fileDescriptor, offset, length);
    }

    @TargetApi(14)
    private void getMediaInfoAndWriteToDB(String url) {
        AudioLog.e("getMediaInfoAndWriteToDB,url=" + url);
        Message msg = Message.obtain(this.handler);
        msg.obj = url;
        msg.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToPlayListAndUpdateUI(TbsAudioEntity entity) {
        int index = TbsAudioEngine.getsInstance().getAudioPresenter().addToPlayHistory(entity);
        AudioLog.i("h5 :: addToPlayListAndUpdateUI index: " + index);
        RemoteAudioBusinessPlayer.getInstance().setCurrent(entity);
        IAudioView view = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
        if (view != null) {
            view.onStartNewAudio(entity, AudioStateController.getCurrentMode(), index);
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void OnCompletion() {
        super.OnCompletion();
        if (this.isError) {
            return;
        }
        this.isCompletion = true;
        if (this.isReleasedByCore) {
            TbsAudioEngine.getsInstance().getAudioPresenter().exit();
        }
    }
}
