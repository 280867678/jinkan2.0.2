package com.arialyy.aria.core.queue;

import com.arialyy.aria.core.task.ITask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public interface ITaskQueue<TASK extends ITask, TASK_WRAPPER extends AbsTaskWrapper> {
    void cancelTask(TASK task);

    void cancelTask(TASK task, int i);

    /* renamed from: createTask */
    TASK mo4437createTask(TASK_WRAPPER task_wrapper);

    int getCurrentCachePoolNum();

    int getCurrentExePoolNum();

    int getMaxTaskNum();

    /* renamed from: getNextTask */
    TASK mo4433getNextTask();

    /* renamed from: getTask */
    TASK mo4434getTask(String str);

    void reTryStart(TASK task);

    void removeTaskFormQueue(String str);

    void resumeTask(TASK task);

    void setMaxTaskNum(int i);

    void startTask(TASK task);

    void startTask(TASK task, int i);

    void stopAllTask();

    void stopTask(TASK task);

    boolean taskExists(String str);

    boolean taskIsRunning(String str);
}
