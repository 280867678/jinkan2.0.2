package com.arialyy.aria.core.queue.pool;

import com.arialyy.aria.core.task.AbsTask;

/* loaded from: classes3.dex */
public interface IPool<T extends AbsTask> {
    T getTask(String str);

    T pollTask();

    boolean putTask(T t);

    boolean removeTask(T t);

    boolean removeTask(String str);

    int size();

    boolean taskExits(String str);
}
