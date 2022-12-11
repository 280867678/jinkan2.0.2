package com.tencent.smtt.audio.core.p043db;

import com.tencent.smtt.audio.core.mvp.AudioPresenterImpl;
import com.tencent.smtt.audio.core.mvp.AudioStateController;
import com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper;
import com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer;
import com.tencent.smtt.audio.core.utils.AudioPlayerInfoReporter;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.TbsAudioEntity;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/PlayListAudioBusinessWrapper.class
 */
/* renamed from: com.tencent.smtt.audio.core.db.PlayListAudioBusinessWrapper */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/PlayListAudioBusinessWrapper.class */
public class PlayListAudioBusinessWrapper extends DefaultAudioPlayerBusinessWrapper {
    private static PlayListAudioBusinessWrapper instance = null;
    private int seekAfterPrepared = 0;

    private PlayListAudioBusinessWrapper() {
    }

    public static PlayListAudioBusinessWrapper getInstance() {
        synchronized (PlayListAudioBusinessWrapper.class) {
            if (instance == null) {
                instance = new PlayListAudioBusinessWrapper();
            }
        }
        AudioLog.i("PlayListAudioBusinessWrapper getInstance");
        return instance;
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void OnCompletion() {
        if (this.isError) {
            reset();
            return;
        }
        if (RemoteAudioBusinessPlayer.getInstance().isPlaying) {
            AudioPlayerInfoReporter.reportAudioPlayerInfos();
        }
        if (AudioStateController.getAudioCloseTime() == -1) {
            TbsAudioEngine.getsInstance().getAudioPresenter().exit();
        }
        int index = AudioPresenterImpl.getInstance().getCurrentPlayList().getCycleAudio();
        AudioLog.i("PlayListAudioBusinessWrapper::OnCompletion,next index=" + index + this.isError);
        if (index == -1) {
            TbsAudioEngine.getsInstance().getAudioPresenter().exit();
        } else {
            AudioPresenterImpl.getInstance().playAudioInIndexWithoutReset(index);
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void OnPrepared() {
        super.OnPrepared();
        RemoteAudioBusinessPlayer.getInstance().start();
        if (this.seekAfterPrepared != 0) {
            RemoteAudioBusinessPlayer.getInstance().seekTo(this.seekAfterPrepared);
            this.seekAfterPrepared = 0;
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void release() {
        super.release();
        RemoteAudioBusinessPlayer.getInstance().setCanPerformAction(false);
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void onSeekByRemote(int time) {
        RemoteAudioBusinessPlayer.getInstance().seekTo(time);
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void onPlayByRemote() {
        RemoteAudioBusinessPlayer.getInstance().start();
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void onPauseByRemote() {
        RemoteAudioBusinessPlayer.getInstance().pause();
    }

    public void setSeekAfterPrepared(int seekAfterPrepared) {
        this.seekAfterPrepared = seekAfterPrepared;
    }

    @Override // com.tencent.smtt.audio.core.mvp.DefaultAudioPlayerBusinessWrapper
    public void start() {
        super.start();
        TbsAudioEntity entity = RemoteAudioBusinessPlayer.getInstance().getCurrent();
        if (entity != null && entity.getTotalTime() == 0) {
            entity.setTotalTime(getDuration());
            if (AudioStateController.getPlaylistMode() == 1) {
                AudioPresenterImpl.getInstance().addToPlayHistory(entity);
                IAudioView view = AudioPresenterImpl.getInstance().getView();
                if (view != null) {
                    view.onStartNewAudio(entity, AudioStateController.getCurrentMode(), AudioPresenterImpl.getInstance().getCurrentPlayList().getIndex());
                }
            }
        }
    }
}
