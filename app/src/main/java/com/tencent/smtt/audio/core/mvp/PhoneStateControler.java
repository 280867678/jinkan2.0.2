package com.tencent.smtt.audio.core.mvp;

import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.smtt.audio.export.interfaces.RemoteMediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PhoneStateControler.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/mvp/PhoneStateControler.class */
public class PhoneStateControler {
    private static PhoneStateControler instance = null;
    private RemoteMediaPlayer audioPlayer;
    private boolean mResumeAfterCall = false;
    private PhoneStateListener mListener = new PhoneStateListener() { // from class: com.tencent.smtt.audio.core.mvp.PhoneStateControler.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, String incomingNumber) {
            if (state == 1) {
                AudioManager audioManager = (AudioManager) TbsAudioEngine.getsInstance().getUIActivity().getSystemService("audio");
                int ringvolume = audioManager.getStreamVolume(2);
                if (ringvolume > 0) {
                    PhoneStateControler.this.mResumeAfterCall = PhoneStateControler.this.audioPlayer.isPlaying() || PhoneStateControler.this.mResumeAfterCall;
                    PhoneStateControler.this.audioPlayer.pause();
                }
            } else if (state == 2) {
                PhoneStateControler.this.mResumeAfterCall = PhoneStateControler.this.audioPlayer.isPlaying() || PhoneStateControler.this.mResumeAfterCall;
                PhoneStateControler.this.audioPlayer.pause();
            } else if (state == 0) {
                PhoneStateControler.this.audioPlayer.start();
                PhoneStateControler.this.mResumeAfterCall = false;
            }
        }
    };

    private PhoneStateControler() {
    }

    public static PhoneStateControler getInstance() {
        synchronized (PhoneStateControler.class) {
            if (instance == null) {
                instance = new PhoneStateControler();
            }
        }
        return instance;
    }

    public void registerPhoneState(RemoteMediaPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        TelephonyManager tmgr = (TelephonyManager) TbsAudioEngine.getsInstance().getUIActivity().getSystemService("phone");
        tmgr.listen(this.mListener, 32);
    }

    public void unRegisterListener() {
        TelephonyManager tmgr = (TelephonyManager) TbsAudioEngine.getsInstance().getUIActivity().getSystemService("phone");
        tmgr.listen(this.mListener, 0);
    }
}
