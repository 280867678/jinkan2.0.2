package com.tencent.smtt.audio.core.mvp;

import com.tencent.smtt.audio.export.AudioLog;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PlayListController.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PlayListController.class */
public class PlayListController extends PlayListBaseImpl {
    private static PlayListController instance = null;

    private PlayListController() {
    }

    public static PlayListController getInstance() {
        synchronized (PlayListController.class) {
            if (instance == null) {
                instance = new PlayListController();
            }
            AudioLog.i("playlist init");
        }
        return instance;
    }
}
