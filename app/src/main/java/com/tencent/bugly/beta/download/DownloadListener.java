package com.tencent.bugly.beta.download;

/* loaded from: classes3.dex */
public interface DownloadListener {
    void onCompleted(DownloadTask downloadTask);

    void onFailed(DownloadTask downloadTask, int i, String str);

    void onReceive(DownloadTask downloadTask);
}
