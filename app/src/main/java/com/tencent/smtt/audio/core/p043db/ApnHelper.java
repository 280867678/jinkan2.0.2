package com.tencent.smtt.audio.core.p043db;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.common.http.Apn;
import com.tencent.smtt.audio.core.utils.TbsDialogBase;
import com.tencent.smtt.audio.export.TbsAudioEngine;
import com.tencent.tbs.common.resources.TBSResources;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/ApnHelper.class
 */
/* renamed from: com.tencent.smtt.audio.core.db.ApnHelper */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/ApnHelper.class */
public class ApnHelper {
    private Context mContext;
    private static ApnHelper instance = null;
    private boolean isUse2GConfirmed = false;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.smtt.audio.core.db.ApnHelper.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) ApnHelper.this.mContext.getSystemService("connectivity");
                NetworkInfo info = connectivityManager.getActiveNetworkInfo();
                if (info != null && info.isAvailable() && 1 != info.getType()) {
                    ApnHelper.this.isUse2GConfirmed = false;
                }
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/ApnHelper$PlayListApnTypeListener.class
 */
    /* renamed from: com.tencent.smtt.audio.core.db.ApnHelper$PlayListApnTypeListener */
    /* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/db/ApnHelper$PlayListApnTypeListener.class */
    public interface PlayListApnTypeListener {
        void onResult(boolean z);
    }

    private ApnHelper() {
    }

    public static ApnHelper getInstance() {
        synchronized (ApnHelper.class) {
            if (instance == null) {
                instance = new ApnHelper();
            }
        }
        return instance;
    }

    public void registerApnReceiver(Context context) {
        this.mContext = context;
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this.mReceiver, mFilter);
    }

    public void unregisterApnReceiver() {
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    public void isUserWifiConfirmed(final PlayListApnTypeListener listener) {
        if (!Apn.isWifiMode() && !this.isUse2GConfirmed) {
            try {
                new TbsDialogBase.Builder(TbsAudioEngine.getsInstance().getUIActivity(), 2, false).setMessage(TBSResources.getString("x5_audio_values_confirm_network")).setNegativeButton(TBSResources.getString("x5_audio_values_cancel"), new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.audio.core.db.ApnHelper.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface Dialog, int which) {
                        listener.onResult(false);
                    }
                }).setPositiveButton(TBSResources.getString("x5_audio_values_continue_play"), new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.audio.core.db.ApnHelper.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface Dialog, int which) {
                        ApnHelper.this.isUse2GConfirmed = true;
                        listener.onResult(true);
                    }
                }).show();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        listener.onResult(true);
        this.isUse2GConfirmed = true;
    }
}
