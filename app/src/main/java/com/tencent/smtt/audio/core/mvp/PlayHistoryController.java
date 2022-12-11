package com.tencent.smtt.audio.core.mvp;

import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.IAudioView;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PlayHistoryController.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PlayHistoryController.class */
public class PlayHistoryController extends PlayListBaseImpl {
    private static PlayHistoryController instance = null;

    private PlayHistoryController() {
        List<TbsAudioEntity> entities = TbsAudioEngine.getsInstance().getAudioPresenter().getDBModule().getPlayListFromDB();
        getPlayList().addAll(entities);
        AudioLog.i("init playlist from db,entites is" + entities);
    }

    public static PlayHistoryController getInstance() {
        synchronized (PlayHistoryController.class) {
            if (instance == null) {
                instance = new PlayHistoryController();
            }
        }
        return instance;
    }

    @Override // com.tencent.smtt.audio.core.mvp.PlayListBaseImpl
    public int addToPlayList(TbsAudioEntity entity) {
        AudioLog.i("addToPlayList #1");
        for (int i = 0; i < getPlayList().size(); i++) {
            TbsAudioEntity audioEntity = getPlayList().get(i);
            if (entity.getTitle().equals(audioEntity.getTitle()) && entity.getTotalTime() == audioEntity.getTotalTime()) {
                removeFromIndexByTime(i);
                AudioLog.e("removeFromIndexByTime::" + audioEntity.getTitle() + "index=" + i + "total=" + audioEntity.getTotalTime());
            }
        }
        AudioLog.i("addToPlayList #2");
        AudioLog.i("After remove: " + getPlayList());
        TbsAudioEngine.getsInstance().getAudioPresenter().getDBModule().savePlayHistoryToDB(entity);
        AudioLog.i("addToPlayList #3");
        int index = super.addToPlayList(entity);
        AudioLog.i("After add: " + getPlayList());
        return index;
    }

    public void removeFromIndexByTime(int index) {
        try {
            TbsAudioEntity entity = getPlayList().get(index);
            getPlayList().remove(index);
            AudioLog.i("After remove::" + getPlayList());
            TbsAudioEngine.getsInstance().getAudioPresenter().deleteAudioFromDB(entity.getTitle(), entity.getTotalTime());
            IAudioView audioView = TbsAudioEngine.getsInstance().getAudioPresenter().getView();
            if (audioView != null) {
                audioView.onPlayListUpdate();
                audioView.onPlayHistoryUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.audio.core.mvp.PlayListBaseImpl
    public void removeFormPlayList(TbsAudioEntity entity) {
        super.removeFormPlayList(entity);
        TbsAudioEngine.getsInstance().getAudioPresenter().deleteAudioFromDB(entity.getTitle(), entity.getTotalTime());
    }

    public void removeFromIndex(int index) {
        try {
            TbsAudioEntity entity = getPlayList().get(index);
            getPlayList().remove(index);
            TbsAudioEngine.getsInstance().getAudioPresenter().deleteAudioFromDB(entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
