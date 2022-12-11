package com.tencent.smtt.audio.core.utils;

import androidx.core.app.NotificationCompatJellybean;
import com.tencent.mtt.ContextHolder;
import com.tencent.smtt.audio.core.mvp.AudioStateController;
import com.tencent.smtt.audio.core.mvp.RemoteAudioBusinessPlayer;
import com.tencent.smtt.audio.export.AudioLog;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.TbsAudioEntity;
import com.tencent.tbs.common.beacon.X5CoreBeaconUploader;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/AudioPlayerInfoReporter.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/AudioPlayerInfoReporter.class */
public class AudioPlayerInfoReporter {
    private static final String AUDIO_EVENT = "AUDIO_PLAYER_EVENT";

    public static void reportAudioPlayerInfos() {
        try {
            TbsAudioEntity entity = RemoteAudioBusinessPlayer.getInstance().getCurrent();
            Map<String, String> map = new HashMap<>();
            map.put("url", entity.getOriginWebUrl());
            map.put(NotificationCompatJellybean.KEY_TITLE, entity.getTitle());
            map.put("total", String.valueOf(entity.getTotalTime()));
            int end = RemoteAudioBusinessPlayer.getInstance().getCurrentPosition();
            map.put("end", String.valueOf(end));
            map.put("isSingle", String.valueOf(AudioStateController.getCycleType() == 3));
            TbsAudioEngine.getsInstance().getAudioPresenter().getView().onAudioChange(entity, map, end);
            AudioLog.i("report info:" + map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void userBehaviorStatics(String action) {
        X5CoreBeaconUploader.getInstance(ContextHolder.getAppContext()).userBehaviorStatistics(action);
    }
}
