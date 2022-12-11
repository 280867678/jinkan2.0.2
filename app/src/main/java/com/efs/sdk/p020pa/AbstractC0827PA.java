package com.efs.sdk.p020pa;

import android.content.Context;
import android.view.View;

/* renamed from: com.efs.sdk.pa.PA */
/* loaded from: classes3.dex */
public interface AbstractC0827PA {
    void enableDumpToFile(String str);

    void enableLog(boolean z);

    int endCalFPS(String str);

    long endCalTime(String str);

    void registerPAANRListener(Context context, PAANRListener pAANRListener);

    void registerPAANRListener(Context context, PAANRListener pAANRListener, long j);

    void registerPAANRListener(Context context, PAANRListener pAANRListener, long j, Thread thread);

    void registerPAMsgListener(PAMsgListener pAMsgListener);

    void start();

    void startCalFPS(String str, View view);

    void startCalTime(String str);

    void stop();

    void unRegisterPAMsgListener();

    void unregisterPAANRListener();
}
