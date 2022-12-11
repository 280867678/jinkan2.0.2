package com.p038qq.p039e.comm.p040pi;

import com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;

/* renamed from: com.qq.e.comm.pi.LADI */
/* loaded from: classes3.dex */
public interface LADI extends ApkDownloadComplianceInterface, IBidding {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    boolean isValid();
}
