package com.arialyy.aria.core.listener;

import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.exception.AriaException;

/* loaded from: classes3.dex */
public interface IDGroupListener extends IDLoadListener {
    void onSubCancel(DownloadEntity downloadEntity);

    void onSubComplete(DownloadEntity downloadEntity);

    void onSubFail(DownloadEntity downloadEntity, AriaException ariaException);

    void onSubPre(DownloadEntity downloadEntity);

    void onSubRunning(DownloadEntity downloadEntity, long j);

    void onSubStart(DownloadEntity downloadEntity);

    void onSubStop(DownloadEntity downloadEntity, long j);

    void supportBreakpoint(boolean z, DownloadEntity downloadEntity);
}
