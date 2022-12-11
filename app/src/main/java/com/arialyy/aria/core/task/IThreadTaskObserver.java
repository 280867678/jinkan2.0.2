package com.arialyy.aria.core.task;

import android.os.Bundle;
import com.arialyy.aria.exception.AriaException;

/* loaded from: classes3.dex */
public interface IThreadTaskObserver {
    long getThreadProgress();

    void updateCompleteState();

    void updateFailState(AriaException ariaException, boolean z);

    void updateProgress(long j);

    void updateState(int i, Bundle bundle);
}
