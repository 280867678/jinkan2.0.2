package com.arialyy.aria.core.queue;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.event.DGMaxNumEvent;
import com.arialyy.aria.core.event.Event;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.task.DownloadGroupTask;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class DGroupTaskQueue extends AbsTaskQueue<DownloadGroupTask, DGTaskWrapper> {
    public static volatile DGroupTaskQueue INSTANCE;
    public final String TAG = CommonUtil.getClassName(this);

    public static DGroupTaskQueue getInstance() {
        if (INSTANCE == null) {
            synchronized (DGroupTaskQueue.class) {
                INSTANCE = new DGroupTaskQueue();
                EventMsgUtil.getDefault().register(INSTANCE);
            }
        }
        return INSTANCE;
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue, com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: createTask */
    public DownloadGroupTask mo4437createTask(DGTaskWrapper dGTaskWrapper) {
        super.mo4437createTask((DGroupTaskQueue) dGTaskWrapper);
        if (this.mCachePool.taskExits(dGTaskWrapper.getKey()) || this.mExecutePool.taskExits(dGTaskWrapper.getKey())) {
            ALog.m4185w(this.TAG, "任务已存在");
            return null;
        }
        DownloadGroupTask downloadGroupTask = (DownloadGroupTask) TaskFactory.getInstance().createTask(dGTaskWrapper, TaskSchedulers.getInstance());
        addTask(downloadGroupTask);
        return downloadGroupTask;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getMaxTaskNum() {
        return AriaConfig.getInstance().getDGConfig().getMaxTaskNum();
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue
    public int getOldMaxNum() {
        return AriaConfig.getInstance().getDGConfig().oldMaxTaskNum;
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue
    public int getQueueType() {
        return 2;
    }

    @Event
    public void maxTaskNum(DGMaxNumEvent dGMaxNumEvent) {
        setMaxTaskNum(dGMaxNumEvent.maxNum);
    }
}
