package com.tencent.smtt.audio.core.mvp;

import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.PlayListBase;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PlayListBaseImpl.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PlayListBaseImpl.class */
public class PlayListBaseImpl implements PlayListBase {
    private int index = 0;
    private List<TbsAudioEntity> playList = new ArrayList();
    private List<TbsAudioEntity> historyList = new ArrayList();

    public void setPlayList(List<TbsAudioEntity> playList) {
        this.playList = playList;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        AudioLog.i("setIndex:" + index);
        this.index = index;
    }

    public List<TbsAudioEntity> getPlayList() {
        return this.playList;
    }

    public TbsAudioEntity getCurrentPlayingAudio() {
        AudioLog.i("getCurrentPlayingAudio" + this + this.playList.get(this.index));
        return this.playList.get(this.index);
    }

    public void removeFormPlayList(TbsAudioEntity entity) {
        int entityIndex = this.playList.indexOf(entity);
        if (entityIndex < this.index) {
            setIndex(this.index - 1);
        }
        this.playList.remove(entity);
    }

    public int addToPlayList(TbsAudioEntity entity) {
        AudioLog.i("addToPlayList #4");
        int size = this.playList.size();
        AudioLog.i("addToPlayList size: " + size);
        setIndex(size);
        AudioLog.i("addToPlayList setIndex: " + size);
        this.playList.add(size, entity);
        AudioLog.i("addToPlayList #5");
        TbsAudioEntity item = this.playList.get(size);
        AudioLog.i("addToPlayList (" + size + "): " + item);
        return size;
    }

    public int getNextIndex() {
        AudioLog.i("getNextIndex,index=" + this.index + "size=" + this.playList.size() + "list=" + this.playList + this);
        int index = this.index;
        switch (AudioStateController.getCycleType()) {
            case 0:
            case 1:
            case 3:
                if (!hasValidMedia()) {
                    return 0;
                }
                do {
                    index = (index + 1) % this.playList.size();
                } while (!this.playList.get(index).isValid());
                break;
            case 2:
                if (!hasValidMedia()) {
                    return 0;
                }
                index = getRandomAudio();
                break;
        }
        AudioLog.i("getNextIndex,index=" + index + "this.index=" + this.index);
        return index;
    }

    public int getLastIndex() {
        AudioLog.i("getNextIndex,index=" + this.index + "size=" + this.playList.size() + "list=" + this.playList + this);
        int index = this.index;
        switch (AudioStateController.getCycleType()) {
            case 0:
            case 1:
            case 3:
                if (!hasValidMedia()) {
                    return 0;
                }
                do {
                    index--;
                    if (index < 0) {
                        index += this.playList.size();
                    }
                } while (!this.playList.get(index).isValid());
                break;
            case 2:
                if (!hasValidMedia()) {
                    return 0;
                }
                index = getRandomAudio();
                break;
        }
        return index;
    }

    public int getCycleAudio() {
        int index = this.index;
        AudioLog.i("getCycleAudio,audio=" + AudioStateController.getCycleType());
        switch (AudioStateController.getCycleType()) {
            case 0:
                return -1;
            case 1:
                if (!hasValidMedia()) {
                    return -1;
                }
                do {
                    index++;
                    if (index >= this.playList.size()) {
                        index %= this.playList.size();
                    }
                } while (!this.playList.get(index).isValid());
                return index;
            case 2:
                if (!hasValidMedia()) {
                    return -1;
                }
                return getRandomAudio();
            case 3:
                return index;
            default:
                return -1;
        }
    }

    public TbsAudioEntity getEntityWithIndex(int index) {
        return this.playList.get(index);
    }

    void showInvalidToast() {
    }

    private void showNoValidToast() {
    }

    private boolean hasValidMedia() {
        for (TbsAudioEntity entity : this.playList) {
            if (entity.isValid()) {
                return true;
            }
        }
        return false;
    }

    private int getRandomAudio() {
        int index;
        int i = this.index;
        int total = this.playList.size();
        do {
            double d = Math.random();
            index = (int) (d * total);
            this.playList.get(index);
        } while (!this.playList.get(index).isValid());
        return index;
    }
}
