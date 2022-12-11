package com.arialyy.aria.core.inf;

import android.os.Handler;
import android.os.Looper;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.loader.ILoaderComponent;

/* loaded from: classes3.dex */
public interface IThreadStateManager extends ILoaderComponent {
    public static final String DATA_ADD_LEN = "DATA_ADD_LEN";
    public static final String DATA_ERROR_INFO = "DATA_ERROR_INFO";
    public static final String DATA_RETRY = "DATA_RETRY";
    public static final String DATA_THREAD_LOCATION = "DATA_THREAD_LOCATION";
    public static final String DATA_THREAD_NAME = "DATA_THREAD_NAME";
    public static final int STATE_CANCEL = 3;
    public static final int STATE_COMPLETE = 4;
    public static final int STATE_FAIL = 2;
    public static final int STATE_PRE = 7;
    public static final int STATE_RUNNING = 5;
    public static final int STATE_START = 8;
    public static final int STATE_STOP = 1;
    public static final int STATE_UPDATE_PROGRESS = 6;

    long getCurrentProgress();

    Handler.Callback getHandlerCallback();

    boolean isComplete();

    boolean isFail();

    void setLooper(TaskRecord taskRecord, Looper looper);

    void updateCurrentProgress(long j);
}
