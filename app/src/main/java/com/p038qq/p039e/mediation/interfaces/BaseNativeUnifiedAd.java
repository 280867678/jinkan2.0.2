package com.p038qq.p039e.mediation.interfaces;

import android.content.Context;
import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.comm.adevent.ADListener;
import java.util.List;

/* renamed from: com.qq.e.mediation.interfaces.BaseNativeUnifiedAd */
/* loaded from: classes3.dex */
public abstract class BaseNativeUnifiedAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeUnifiedAd(Context context, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract void loadData(int i);

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(ADListener aDListener);

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setCategories(List<String> list);

    public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    public abstract void setECPMLevel(String str);

    public abstract void setMaxVideoDuration(int i);

    public abstract void setMinVideoDuration(int i);
}
