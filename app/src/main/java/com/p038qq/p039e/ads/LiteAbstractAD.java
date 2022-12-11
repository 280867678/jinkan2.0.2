package com.p038qq.p039e.ads;

import android.app.Activity;
import com.p038qq.p039e.comm.compliance.DownloadConfirmCallBack;
import com.p038qq.p039e.comm.compliance.DownloadConfirmListener;
import com.p038qq.p039e.comm.p040pi.LADI;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.ads.LiteAbstractAD */
/* loaded from: classes3.dex */
public abstract class LiteAbstractAD<T extends LADI> extends AbstractAD<T> implements LADI, DownloadConfirmListener {
    public DownloadConfirmListener Wwwwwwwwwwwwwwwwwwww;

    @Override // com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        T t = this.f657a;
        if (t != 0) {
            return ((LADI) t).getApkInfoUrl();
        }
        m3677a("getApkInfoUrl");
        return null;
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public int getECPM() {
        T t = this.f657a;
        if (t != 0) {
            return ((LADI) t).getECPM();
        }
        m3677a("getECPM");
        return -1;
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public String getECPMLevel() {
        T t = this.f657a;
        if (t != 0) {
            return ((LADI) t).getECPMLevel();
        }
        m3677a("getECPMLevel");
        return null;
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public Map<String, Object> getExtraInfo() {
        T t = this.f657a;
        if (t != 0) {
            return ((LADI) t).getExtraInfo();
        }
        m3677a("getExtraInfo");
        return new HashMap();
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public boolean isValid() {
        T t = this.f657a;
        if (t != 0) {
            return ((LADI) t).isValid();
        }
        m3677a("isValid");
        return false;
    }

    @Override // com.p038qq.p039e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.Wwwwwwwwwwwwwwwwwwww;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        T t = this.f657a;
        if (t != 0) {
            ((LADI) t).sendLossNotification(i, i2, str);
        } else {
            m3677a("sendLossNotification");
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        T t = this.f657a;
        if (t != 0) {
            ((LADI) t).sendLossNotification(map);
        } else {
            m3677a("sendLossNotification");
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendWinNotification(int i) {
        T t = this.f657a;
        if (t != 0) {
            ((LADI) t).sendWinNotification(i);
        } else {
            m3677a("sendWinNotification");
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        T t = this.f657a;
        if (t != 0) {
            ((LADI) t).sendWinNotification(map);
        } else {
            m3677a("sendWinNotification");
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void setBidECPM(int i) {
        T t = this.f657a;
        if (t != 0) {
            ((LADI) t).setBidECPM(i);
        } else {
            m3677a("setBidECPM");
        }
    }

    @Override // com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.Wwwwwwwwwwwwwwwwwwww = downloadConfirmListener;
        T t = this.f657a;
        if (t != 0) {
            ((LADI) t).setDownloadConfirmListener(this);
        }
    }
}
