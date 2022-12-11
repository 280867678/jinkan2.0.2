package com.tencent.smtt.audio.core.mvp;

import com.tencent.smtt.audio.core.p043db.PlayListAudioBusinessWrapper;
import com.tencent.smtt.audio.export.AudioLog;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioStateController.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/AudioStateController.class */
public class AudioStateController {
    private static int cycleType = 0;
    private static int speedType = 0;
    private static int audioCloseTime = 0;
    private static int currentMode = 1;
    private static int playlistMode = 0;

    public static int getSpeedType() {
        return speedType;
    }

    public static void setSpeedType(int speedType2) {
        AudioLog.i("setSpeedType" + speedType2);
        speedType = speedType2;
    }

    public static int getAudioCloseTime() {
        return audioCloseTime;
    }

    public static void setAudioCloseTime(int autoCloseTime) {
        AudioLog.i("setAudioCloseTime" + autoCloseTime);
        audioCloseTime = autoCloseTime;
    }

    public static int getCycleType() {
        return cycleType;
    }

    public static void setCycleType(int cycleType2) {
        AudioLog.i("setCycleType" + cycleType2);
        cycleType = cycleType2;
    }

    public static int getCurrentMode() {
        return currentMode;
    }

    public static void setCurrentMode(int currentMode2) {
        IAudioBusinessWrapper wrapper;
        AudioLog.i("setCurrentMode" + currentMode2);
        currentMode = currentMode2;
        switch (currentMode2) {
            case 0:
                wrapper = X5CoreAudioPlayerBusinessWrapper.getInstance();
                setPlaylistMode(0);
                break;
            case 1:
            default:
                wrapper = DefaultAudioPlayerBusinessWrapper.getInstance();
                break;
            case 2:
                wrapper = PlayListAudioBusinessWrapper.getInstance();
                setPlaylistMode(1);
                break;
            case 3:
                wrapper = PlayListAudioBusinessWrapper.getInstance();
                break;
        }
        RemoteAudioBusinessPlayer.getInstance().setWrapper(wrapper);
    }

    public static void setPlaylistMode(int playlistMode2) {
        playlistMode = playlistMode2;
    }

    public static int getPlaylistMode() {
        return playlistMode;
    }
}
