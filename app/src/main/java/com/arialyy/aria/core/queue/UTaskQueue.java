package com.arialyy.aria.core.queue;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.event.Event;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.event.UMaxNumEvent;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.task.UploadTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public class UTaskQueue extends AbsTaskQueue<UploadTask, UTaskWrapper> {
    public static volatile UTaskQueue INSTANCE = null;
    public static final String TAG = "UploadTaskQueue";

    public static UTaskQueue getInstance() {
        if (INSTANCE == null) {
            synchronized (UTaskQueue.class) {
                INSTANCE = new UTaskQueue();
                EventMsgUtil.getDefault().register(INSTANCE);
            }
        }
        return INSTANCE;
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue, com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: createTask */
    public UploadTask mo4437createTask(UTaskWrapper uTaskWrapper) {
        super.mo4437createTask((UTaskQueue) uTaskWrapper);
        if (this.mCachePool.taskExits(uTaskWrapper.getKey()) || this.mExecutePool.taskExits(uTaskWrapper.getKey())) {
            ALog.m4185w(TAG, "任务已存在");
            return null;
        }
        UploadTask uploadTask = (UploadTask) TaskFactory.getInstance().createTask(uTaskWrapper, TaskSchedulers.getInstance());
        addTask(uploadTask);
        return uploadTask;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getMaxTaskNum() {
        return AriaConfig.getInstance().getUConfig().getMaxTaskNum();
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue
    public int getOldMaxNum() {
        return AriaConfig.getInstance().getUConfig().oldMaxTaskNum;
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue
    public int getQueueType() {
        return 3;
    }

    @Event
    public void maxTaskNum(UMaxNumEvent uMaxNumEvent) {
        setMaxTaskNum(uMaxNumEvent.maxNum);
    }
}
