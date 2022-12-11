package com.p046uc.crashsdk.export;

/* renamed from: com.uc.crashsdk.export.VersionInfo */
/* loaded from: classes4.dex */
public class VersionInfo {
    public String mBuildId;
    public String mSubVersion;
    public String mVersion;

    public VersionInfo() {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
    }

    public VersionInfo(VersionInfo versionInfo) {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
        this.mVersion = versionInfo.mVersion;
        this.mSubVersion = versionInfo.mSubVersion;
        this.mBuildId = versionInfo.mBuildId;
    }
}
