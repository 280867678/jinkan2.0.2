package com.arialyy.aria.m3u8.vod;

/* loaded from: classes3.dex */
public class DownloadCompleteEvent {
    public String localM3U8Path;
    public String mergedFilePath;

    public DownloadCompleteEvent(String str, String str2) {
        this.localM3U8Path = str;
        this.mergedFilePath = str2;
    }

    public String getLocalM3U8Path() {
        return this.localM3U8Path;
    }

    public String getMergedFilePath() {
        return this.mergedFilePath;
    }

    public void setLocalM3U8Path(String str) {
        this.localM3U8Path = str;
    }

    public void setMergedFilePath(String str) {
        this.mergedFilePath = str;
    }
}
