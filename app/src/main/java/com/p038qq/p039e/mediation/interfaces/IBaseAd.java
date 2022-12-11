package com.p038qq.p039e.mediation.interfaces;

import java.util.Map;

/* renamed from: com.qq.e.mediation.interfaces.IBaseAd */
/* loaded from: classes3.dex */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i, int i2, String str);

    void sendWinNotification(int i);

    void setBidECPM(int i);
}
