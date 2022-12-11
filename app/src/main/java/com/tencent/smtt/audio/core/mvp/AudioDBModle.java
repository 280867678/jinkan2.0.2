package com.tencent.smtt.audio.core.mvp;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.http.MttLocalProxy;
import com.tencent.common.threadpool.BrowserExecutorSupplier;
import com.tencent.mtt.ContextHolder;
import com.tencent.smtt.audio.core.p043db.DBManager;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioModel;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioDBModle.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioDBModle.class */
public class AudioDBModle implements IAudioModel {
    private final int MSG_UPDATE = 1;
    private final int MSG_UPDATE_TITLE = 2;
    private final int MSG_UPDATE_LIST = 3;
    private Handler mHandler = new Handler() { // from class: com.tencent.smtt.audio.core.mvp.AudioDBModle.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    IAudioView audioView = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
                    if (audioView != null) {
                        audioView.onPlayHistoryUpdate();
                        break;
                    }
                    break;
                case 2:
                    IAudioView audioView2 = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
                    if (audioView2 != null) {
                        audioView2.onPlayHistoryUpdate();
                        break;
                    }
                    break;
                case 3:
                    Bundle bundle = msg.getData();
                    int id = bundle.getInt("id");
                    String url = bundle.getString("url");
                    String origin_url = bundle.getString("origin_url");
                    String name = bundle.getString("name");
                    String artist = bundle.getString("artist");
                    int durationInt = bundle.getInt("durationInt");
                    TbsAudioEntity entity = new TbsAudioEntity();
                    entity.setTotalTime(durationInt);
                    entity.setValid(true);
                    entity.setArtist(artist);
                    entity.setAudioURL(url);
                    entity.setId(id);
                    entity.setOriginWebUrl(origin_url);
                    entity.setTitle(name);
                    TbsAudioEngine.getsInstance().getAudioPresenter().saveAudioToPlayHistoryDB(entity);
                    IAudioView audioView3 = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
                    if (audioView3 != null) {
                        audioView3.onPlayHistoryUpdate();
                        break;
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };
    private DBManager dbManager = new DBManager(ContextHolder.getAppContext());

    public void deleteAudioFromDB(final int id) {
        BrowserExecutorSupplier.postForDbTasks(new BrowserExecutorSupplier.BackgroundRunable() { // from class: com.tencent.smtt.audio.core.mvp.AudioDBModle.2
            public void doRun() {
                try {
                    AudioDBModle.this.dbManager.deleteAudioFromDB(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void savePlayHistoryToDB(final TbsAudioEntity entity) {
        BrowserExecutorSupplier.postForDbTasks(new BrowserExecutorSupplier.BackgroundRunable() { // from class: com.tencent.smtt.audio.core.mvp.AudioDBModle.3
            public void doRun() {
                try {
                    AudioDBModle.this.dbManager.addAudioToLastPlayList(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void checkPlayList() {
        new Thread(new Runnable() { // from class: com.tencent.smtt.audio.core.mvp.AudioDBModle.4
            @Override // java.lang.Runnable
            public void run() {
                AudioDBModle.this.checkAllPlayListAvaliable(AudioDBModle.this.dbManager.getLastPlayList());
            }
        }).start();
    }

    public List<TbsAudioEntity> getPlayListFromDB() {
        return this.dbManager.getLastPlayList();
    }

    public void deleteAudioFromDB(final String title, final long time) {
        BrowserExecutorSupplier.postForDbTasks(new BrowserExecutorSupplier.BackgroundRunable() { // from class: com.tencent.smtt.audio.core.mvp.AudioDBModle.5
            public void doRun() {
                try {
                    AudioDBModle.this.dbManager.deleteAudioFromDB(title, time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean isAudioValid() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAllPlayListAvaliable(List<TbsAudioEntity> playList) {
        try {
            for (TbsAudioEntity entity : playList) {
                if (entity.isValid()) {
                    boolean isAvailable = isAudioAvaliAble(entity.getAudioURL());
                    if (!isAvailable) {
                        entity.setValid(false);
                        this.dbManager.updateIsValidWithId(entity.getId(), false);
                        IAudioView view = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
                        if (view != null) {
                            view.setAudioValid(entity, false);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isAudioAvaliAble(String url0) {
        try {
            String url = MttLocalProxy.getInstance().getProxyURL(url0.toString());
            int responseCode = HttpUtils.getHttpResponseCode(new URL(url));
            AudioLog.i("isAudioAvaliAble, ur=" + url + ",responseCode=" + responseCode);
            return responseCode < 400;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
        }
    }

    @TargetApi(14)
    private void getMediaInfoAndWriteToDB(final int id, final String url0, final String defaultTitle, final String originUrl) {
        BrowserExecutorSupplier.postForBackgroundTasks(new BrowserExecutorSupplier.BackgroundRunable() { // from class: com.tencent.smtt.audio.core.mvp.AudioDBModle.6
            public void doRun() {
                String url;
                String name;
                String artist;
                int durationInt;
                try {
                    MediaMetadataRetriever myretrier = new MediaMetadataRetriever();
                    url = MttLocalProxy.getInstance().getProxyURL(url0.toString());
                    AudioLog.i("getMediaInfoAndWriteToDB - url: " + url);
                    myretrier.setDataSource(url, new HashMap());
                    name = myretrier.extractMetadata(7);
                    artist = myretrier.extractMetadata(2);
                    String duration = myretrier.extractMetadata(9);
                    durationInt = -1;
                    try {
                        durationInt = Integer.parseInt(duration);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (durationInt == 0) {
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    name = defaultTitle;
                }
                String cover_url = null;
                String x5_name = RemoteAudioBusinessPlayer.getInstance().getAudioTitle();
                String x5_artist = RemoteAudioBusinessPlayer.getInstance().getAudioAuthor();
                String x5_cover_url = RemoteAudioBusinessPlayer.getInstance().getX5AudioCoverUrl();
                if (TextUtils.isEmpty(x5_name)) {
                    name = x5_name;
                }
                if (TextUtils.isEmpty(x5_artist)) {
                    artist = x5_artist;
                }
                if (TextUtils.isEmpty(x5_cover_url)) {
                    cover_url = x5_cover_url;
                }
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("cover_url", cover_url);
                bundle.putInt("id", id);
                bundle.putString("url", url);
                bundle.putString("origin_url", originUrl);
                bundle.putString("name", name);
                bundle.putString("artist", artist);
                bundle.putInt("durationint", durationInt);
                message.setData(bundle);
                message.what = 3;
                AudioDBModle.this.mHandler.sendMessage(message);
                AudioDBModle.this.mHandler.sendEmptyMessage(1);
                Message msg = new Message();
                msg.arg1 = 0;
                msg.what = 2;
                AudioDBModle.this.mHandler.sendMessage(msg);
            }
        });
    }

    void saveInValidMedia(TbsAudioEntity entity) {
        entity.setValid(false);
        this.dbManager.updateIsValidWithId(entity.getId(), false);
    }
}
