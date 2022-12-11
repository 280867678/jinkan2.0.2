package com.arialyy.aria.core.task;

import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public interface ITask<TASK_WRAPPER extends AbsTaskWrapper> {
    public static final int DOWNLOAD = 1;
    public static final int DOWNLOAD_GROUP = 3;
    public static final int DOWNLOAD_GROUP_SUB = 4;
    public static final int M3U8_PEER = 5;
    public static final int OTHER = -1;
    public static final int TEMP = 6;
    public static final int UPLOAD = 2;

    void cancel();

    void cancel(int i);

    Object getExpand(String str);

    String getKey();

    int getSchedulerType();

    int getState();

    String getTaskName();

    int getTaskType();

    TASK_WRAPPER getTaskWrapper();

    boolean isCancel();

    boolean isNeedRetry();

    boolean isRunning();

    boolean isStop();

    void start();

    void start(int i);

    void stop();

    void stop(int i);
}
