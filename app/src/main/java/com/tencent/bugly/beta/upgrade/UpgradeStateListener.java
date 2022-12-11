package com.tencent.bugly.beta.upgrade;

/* loaded from: classes3.dex */
public interface UpgradeStateListener {
    void onDownloadCompleted(boolean z);

    void onUpgradeFailed(boolean z);

    void onUpgradeNoVersion(boolean z);

    void onUpgradeSuccess(boolean z);

    void onUpgrading(boolean z);
}
