package com.tencent.smtt.audio.core.mvp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.tencent.mtt.ContextHolder;
import com.tencent.smtt.audio.core.p043db.ApnHelper;
import com.tencent.smtt.audio.core.p043db.PlayListAudioBusinessWrapper;
import com.tencent.smtt.audio.core.p043db.SysMediaPlayer;
import com.tencent.smtt.audio.core.utils.AudioPlayerInfoReporter;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioModel;
import com.tencent.smtt.audio.export.IAudioPlayerCallback;
import com.tencent.smtt.audio.export.IAudioPresenter;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.IMediaPlayer;
import com.tencent.smtt.audio.export.PlayListBase;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import com.tencent.smtt.audio.export.interfaces.IAudioClient;
import com.tencent.smtt.audio.export.interfaces.RemoteMediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioPresenterImpl.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioPresenterImpl.class */
public class AudioPresenterImpl implements IAudioPresenter, IAudioPlayerCallback {
    private IAudioView mAudioView;
    private WifiManager.WifiLock wifiLock;
    IAudioClient mClient;
    private static AudioPresenterImpl instance = null;
    private boolean isInited = false;
    private String mExoPlayerInfo = null;
    private int mPlayerType = 3;
    private boolean isSupportMultiPlaySpeed = false;
    private RemoteAudioBusinessPlayer mediaPlayer = RemoteAudioBusinessPlayer.getInstance();
    AudioDBModle dbModle = new AudioDBModle();

    /* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioPresenterImpl$AudioPlayerType.class
 */
    /* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioPresenterImpl$AudioPlayerType.class */
    interface AudioPlayerType {
        public static final int SYS_MEDIA_PLAYER = 0;
        public static final int EXO_PLAYER = 1;
        public static final int UNKNOWN = 2;
        public static final int UN_INITED = 3;
    }

    private AudioPresenterImpl() {
    }

    public static AudioPresenterImpl getInstance() {
        synchronized (AudioPresenterImpl.class) {
            if (instance == null) {
                instance = new AudioPresenterImpl();
            }
        }
        return instance;
    }

    public boolean playNextAudio() {
        return processNextOrLastAudio(true);
    }

    public boolean playLastAudio() {
        return processNextOrLastAudio(false);
    }

    public void checkPlayList() {
        if (this.dbModle != null) {
            this.dbModle.checkPlayList();
        }
    }

    public List<TbsAudioEntity> getPlayList() {
        return PlayListController.getInstance().getPlayList();
    }

    public List<TbsAudioEntity> getPlayHistory() {
        List<TbsAudioEntity> history_list = this.dbModle.getPlayListFromDB();
        AudioLog.d("getPlayHistory: history_list=" + history_list);
        return history_list;
    }

    public void setPlayList(List<TbsAudioEntity> entities) {
        AudioLog.i("setPlayList,entites=" + entities);
        PlayListController.getInstance().setPlayList(entities);
        if (this.mAudioView != null) {
            this.mAudioView.onPlayListUpdate();
        }
    }

    public void removeFromPlayList(TbsAudioEntity entity) {
        PlayListController.getInstance().removeFormPlayList(entity);
        if (this.mAudioView != null) {
            this.mAudioView.onPlayListUpdate();
        }
    }

    public void removeFromPlayHistory(TbsAudioEntity entity) {
        PlayHistoryController.getInstance().removeFormPlayList(entity);
        if (this.mAudioView != null) {
            this.mAudioView.onPlayHistoryUpdate();
        }
    }

    public void addToPlayList(TbsAudioEntity entity) {
        PlayListController.getInstance().addToPlayList(entity);
        if (this.mAudioView != null) {
            this.mAudioView.onPlayListUpdate();
        }
    }

    public int addToPlayHistory(TbsAudioEntity entity) {
        int index = PlayHistoryController.getInstance().addToPlayList(entity);
        if (this.mAudioView != null) {
            this.mAudioView.onPlayHistoryUpdate();
        }
        return index;
    }

    public void setPlaySpeed(int type) {
        AudioStateController.setSpeedType(type);
        switch (type) {
            case 0:
                this.mediaPlayer.setSpeedType(1.0f);
                return;
            case 1:
                this.mediaPlayer.setSpeedType(0.75f);
                return;
            case 2:
                this.mediaPlayer.setSpeedType(1.25f);
                return;
            case 3:
                this.mediaPlayer.setSpeedType(1.5f);
                return;
            default:
                return;
        }
    }

    public int getPlaySpeed() {
        AudioLog.i("getPlaySpeed" + AudioStateController.getSpeedType());
        return AudioStateController.getSpeedType();
    }

    public void setAudioCloseTime(int time) {
        AudioLog.i("setAudioCloseTime" + time);
        AudioStateController.setAudioCloseTime(time);
        AutoCloseControler.getInstance().setAudioCloseTime(time);
    }

    public void exit() {
        try {
            AudioLog.i("AudioPresenterImpl exit!");
            this.mediaPlayer.realRelease();
            this.isInited = false;
            RemoteAudioBusinessPlayer.getInstance().localListener.onMediaInterruptedByRemote();
            AudioFocusChangeListener.getInstance().setFouseUnChange();
            AutoCloseControler.getInstance().destroy();
            getInstance().resetStatus();
            this.mAudioView.onReleaseView();
            this.mAudioView = null;
            releaseWifiLock();
            ApnHelper.getInstance().unregisterApnReceiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCycleType() {
        AudioLog.i("AudioPresenterImpl getCycleType,ModeType=" + AudioStateController.getCycleType());
        return AudioStateController.getCycleType();
    }

    public void setCycpeType(int cycleType) {
        AudioLog.i("AudioPresenterImpl setCycpeType,ModeType=" + cycleType);
        this.mediaPlayer.localListener.onMediaInterruptedByRemote();
        this.mediaPlayer.setCanPerformAction(true);
        AudioStateController.setCycleType(cycleType);
        if (this.mAudioView != null) {
            this.mAudioView.onChangeCycleStatus(cycleType);
        }
        RemoteAudioBusinessPlayer.getInstance().setWrapper(PlayListAudioBusinessWrapper.getInstance());
    }

    public int getModeType() {
        AudioLog.i("AudioPresenterImpl getModeType,ModeType=" + AudioStateController.getCurrentMode());
        return AudioStateController.getCurrentMode();
    }

    public RemoteMediaPlayer getRemoteMediaPlayer() {
        return this.mediaPlayer;
    }

    public void deleteAudioFromDB(int id) {
        this.dbModle.deleteAudioFromDB(id);
    }

    public boolean processNextOrLastAudio(boolean isNext) {
        int index;
        AudioLog.i("AudioPresenterImpl processNextOrLastAudio,isNext=" + isNext);
        if (this.mediaPlayer.isPlaying) {
            AudioPlayerInfoReporter.reportAudioPlayerInfos();
        }
        if (isNext) {
            index = getCurrentPlayList().getNextIndex();
        } else {
            index = getCurrentPlayList().getLastIndex();
        }
        AudioLog.i("AudioPresenterImpl processNextOrLastAudio,isNext=" + isNext + "entity=" + index);
        startAudio(index);
        return true;
    }

    public void startAudioWithoutQueryApnType(int index) {
        try {
            AudioLog.i("startAudioWithoutQueryApnType,index=" + index);
            getCurrentPlayList().setIndex(index);
            TbsAudioEntity entity = getCurrentPlayList().getEntityWithIndex(index);
            if (entity == null) {
                return;
            }
            getView().onAudioLoadStart(entity.getType());
            this.mediaPlayer.localListener.onMediaInterruptedByRemote();
            setMode(3);
            this.mediaPlayer.reset();
            if (entity.getHeaders() != null) {
                this.mediaPlayer.setDataSource(ContextHolder.getAppContext(), Uri.parse(entity.getAudioURL()), entity.getHeaders());
            } else {
                this.mediaPlayer.setDataSource(entity.getAudioURL());
            }
            this.mediaPlayer.prepareAsync();
            RemoteAudioBusinessPlayer.getInstance().setCurrent(entity);
            if (this.mAudioView != null) {
                this.mAudioView.onStartNewAudio(entity, AudioStateController.getCurrentMode(), getCurrentPlayList().getIndex());
            }
            AudioLog.i("onStartNewAudio point 2" + entity + getCurrentPlayList() + "index=" + getCurrentPlayList().getIndex());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TbsAudioEntity getCurrentEntity() {
        return RemoteAudioBusinessPlayer.getInstance().getCurrent();
    }

    private void startAudio(int index) {
        AudioLog.i("startAudio,index=" + index);
        if (this.mClient != null) {
            this.mClient.onShowConfirmDialog(index);
        } else {
            startAudioWithoutQueryApnType(index);
        }
    }

    public PlayListBase getCurrentPlayList() {
        int currentMode = AudioStateController.getPlaylistMode();
        AudioLog.i("AudioPresenterImpl getCurrentPlayList,currentMode=" + currentMode);
        switch (currentMode) {
            case 0:
                return PlayHistoryController.getInstance();
            case 1:
                return PlayListController.getInstance();
            default:
                return null;
        }
    }

    public void removeFormCurrentPlayList(TbsAudioEntity entity) {
        getCurrentPlayList().removeFormPlayList(entity);
        if (this.mAudioView != null) {
            this.mAudioView.onPlayHistoryUpdate();
            this.mAudioView.onPlayListUpdate();
        }
    }

    public void addToPlayList(List<TbsAudioEntity> entities) {
        if (entities == null) {
            return;
        }
        for (TbsAudioEntity entity : entities) {
            addToPlayList(entity);
        }
    }

    public void resetStatus() {
        this.mediaPlayer.localListener.onMediaInterruptedByRemote();
        try {
            RemoteAudioBusinessPlayer.getInstance().getBusinessWrapper().resetStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMode(int mode) {
        AudioLog.i("setMode,mode=" + mode);
        AudioStateController.setCurrentMode(mode);
    }

    public int currentPlayerType() {
        return this.mPlayerType;
    }

    public boolean supportMultiPlaySpeed() {
        boolean supported = false;
        switch (this.mPlayerType) {
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                    supported = true;
                    break;
                }
                break;
            case 3:
                supported = false;
                break;
            default:
                supported = false;
                break;
        }
        return supported;
    }

    public void init(Context context, IAudioView view) {
        init(context, view, false);
    }

    public void init(Context context, IAudioView view, boolean shouldUseExoPlayer) {
        AudioLog.w("AudioPresenterImpl init,is inited=" + this.isInited + ", shouldUseExoPlayer: " + shouldUseExoPlayer);
        if (!this.isInited) {
            IMediaPlayer player = new SysMediaPlayer();
            this.mPlayerType = 0;
            try {
                player.setWakeMode(ContextHolder.getAppContext(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            AudioLog.i("AudioPresenterImpl init, player=" + player);
            RemoteAudioBusinessPlayer.getInstance().init(context, player, view);
            this.mediaPlayer = RemoteAudioBusinessPlayer.getInstance();
            AudioFocusChangeListener.getInstance().init(this);
            initWifiLock();
            ApnHelper.getInstance().registerApnReceiver(context);
            AudioLog.i("AudioPresenterImpl init, mediaPlayer=" + this.mediaPlayer);
            this.isInited = true;
        }
        setAudioView(view);
    }

    public void setPlayListMode(int mode) {
        AudioLog.i("setPlayListMode,mode=" + mode);
        if (mode != AudioStateController.getPlaylistMode()) {
            resetStatus();
            AudioStateController.setPlaylistMode(mode);
        }
    }

    public int getAutoCloseTime() {
        return AudioStateController.getAudioCloseTime();
    }

    public void seekBeforePrepare(int position) {
        PlayListAudioBusinessWrapper.getInstance().setSeekAfterPrepared(position);
    }

    public void setIAudioClient(IAudioClient client) {
        this.mClient = client;
    }

    @SuppressLint({"WifiManagerLeak"})
    private void initWifiLock() {
        this.wifiLock = ((WifiManager) ContextHolder.getAppContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).createWifiLock(1, "tbsAudioLock");
        this.wifiLock.acquire();
    }

    private void releaseWifiLock() {
        if (this.wifiLock != null) {
            this.wifiLock.release();
            this.wifiLock = null;
        }
    }

    public void deleteAudioFromDB(String title, long time) {
        this.dbModle.deleteAudioFromDB(title, time);
    }

    public void setAudioView(IAudioView view) {
        AudioLog.i("AudioPresenterImpl::setAudioView" + view);
        this.mAudioView = view;
    }

    public boolean goForward(int seconds) {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int destPosition = currentPosition + seconds;
        int duration = this.mediaPlayer.getDuration();
        if (destPosition < duration) {
            this.mediaPlayer.seekTo(destPosition);
            return true;
        }
        return false;
    }

    public boolean goBack(int seconds) {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int destPosition = currentPosition - seconds;
        if (destPosition > 0) {
            this.mediaPlayer.seekTo(destPosition);
            return true;
        }
        this.mediaPlayer.seekTo(0);
        return false;
    }

    public void playAudioInIndex(int index) {
        resetStatus();
        if (this.mediaPlayer.isPlaying) {
            AudioPlayerInfoReporter.reportAudioPlayerInfos();
        }
        playAudioInIndexWithoutReset(index);
    }

    public void playAudioInIndexWithoutReset(int index) {
        AudioLog.i("playAudioInIndex,index=" + index);
        startAudio(index);
    }

    public void saveAudioToPlayHistoryDB(TbsAudioEntity entity) {
        this.dbModle.savePlayHistoryToDB(entity);
    }

    public void start() {
        AudioLog.i("AudioPresenterImpl start,mode=" + AudioStateController.getCurrentMode());
        this.mediaPlayer.localListener.onPlayByRemote();
    }

    public void pause() {
        AudioLog.i("AudioPresenterImpl pause,mode=" + AudioStateController.getCurrentMode());
        this.mediaPlayer.localListener.onPauseByRemote();
    }

    public void seek(int time) {
        AudioLog.i("AudioPresenterImpl seek,mode=" + AudioStateController.getCurrentMode() + "time=" + time);
        this.mediaPlayer.localListener.onSeekByRemote(time);
    }

    public IAudioView getView() {
        return this.mAudioView;
    }

    public IAudioModel getDBModule() {
        return this.dbModle;
    }

    public boolean isPlaying() {
        return this.mediaPlayer.isAudioPlaying();
    }

    public int getPlayListMode() {
        return AudioStateController.getPlaylistMode();
    }

    public void onPlayerMessage(int msgCode, String msgDetails) {
        if (this.mAudioView != null) {
            AudioLog.d("onPlayerMessage: " + msgCode + ", " + msgDetails);
            this.mAudioView.onPlayerMessage(msgCode, msgDetails);
        }
    }

    public void onMiscNotification(Map<String, Object> info) {
        if (this.mAudioView != null) {
            AudioLog.d("onMiscNotification, info=" + info);
            this.mAudioView.onMiscNotification(info);
        }
    }

    public String exoPlayerInfo() {
        return this.mExoPlayerInfo;
    }
}
