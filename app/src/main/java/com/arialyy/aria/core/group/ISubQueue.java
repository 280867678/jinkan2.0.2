package com.arialyy.aria.core.group;

import com.arialyy.aria.core.inf.IUtil;

/* loaded from: classes3.dex */
public interface ISubQueue<Fileer extends IUtil> {
    void addTask(Fileer fileer);

    void clear();

    /* renamed from: getNextTask */
    Fileer mo4428getNextTask();

    void modifyMaxExecNum(int i);

    void removeAllTask();

    void removeTask(Fileer fileer);

    void removeTaskFromExecQ(Fileer fileer);

    void startTask(Fileer fileer);

    void stopAllTask();

    void stopTask(Fileer fileer);
}
