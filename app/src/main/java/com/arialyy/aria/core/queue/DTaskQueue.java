package com.arialyy.aria.core.queue;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.event.DMaxNumEvent;
import com.arialyy.aria.core.event.Event;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.task.DownloadTask;
import com.arialyy.aria.util.ALog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes3.dex */
public class DTaskQueue extends AbsTaskQueue<DownloadTask, DTaskWrapper> {
    public static volatile DTaskQueue INSTANCE = null;
    public static final String TAG = "DownloadTaskQueue";

    public static DTaskQueue getInstance() {
        if (INSTANCE == null) {
            synchronized (DTaskQueue.class) {
                INSTANCE = new DTaskQueue();
                EventMsgUtil.getDefault().register(INSTANCE);
            }
        }
        return INSTANCE;
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue, com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: createTask */
    public DownloadTask mo4437createTask(DTaskWrapper dTaskWrapper) {
        super.mo4437createTask((DTaskQueue) dTaskWrapper);
        if (this.mCachePool.taskExits(dTaskWrapper.getKey()) || this.mExecutePool.taskExits(dTaskWrapper.getKey())) {
            ALog.m4185w(TAG, "任务已存在");
            return null;
        }
        DownloadTask downloadTask = (DownloadTask) TaskFactory.getInstance().createTask(dTaskWrapper, TaskSchedulers.getInstance());
        addTask(downloadTask);
        return downloadTask;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getMaxTaskNum() {
        return AriaConfig.getInstance().getDConfig().getMaxTaskNum();
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue
    public int getOldMaxNum() {
        return AriaConfig.getInstance().getDConfig().oldMaxTaskNum;
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue
    public int getQueueType() {
        return 1;
    }

    @Event
    public void maxTaskNum(DMaxNumEvent dMaxNumEvent) {
        setMaxTaskNum(dMaxNumEvent.maxNum);
    }

    public void setTaskHighestPriority(DownloadTask downloadTask) {
        downloadTask.setHighestPriority(true);
        List allTask = this.mExecutePool.getAllTask();
        if (allTask == null || allTask.isEmpty()) {
            return;
        }
        Iterator it = allTask.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                int maxTaskNum = AriaConfig.getInstance().getDConfig().getMaxTaskNum();
                int size = this.mExecutePool.size();
                if (size == 0 || size < maxTaskNum) {
                    startTask((DTaskQueue) downloadTask);
                    return;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                while (true) {
                    if (i >= maxTaskNum) {
                        break;
                    }
                    DownloadTask downloadTask2 = (DownloadTask) this.mExecutePool.pollTask();
                    if (downloadTask2 != null && downloadTask2.isRunning()) {
                        if (i == maxTaskNum - 1) {
                            downloadTask2.stop(3);
                            this.mCachePool.putTaskToFirst(downloadTask2);
                            break;
                        }
                        linkedHashSet.add(downloadTask2);
                    }
                    i++;
                }
                startTask((DTaskQueue) downloadTask);
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    this.mExecutePool.putTask((DownloadTask) it2.next());
                }
                return;
            }
            DownloadTask downloadTask3 = (DownloadTask) it.next();
            if (downloadTask3 != null && downloadTask3.isRunning() && downloadTask3.isHighestPriorityTask() && !downloadTask3.getKey().equals(downloadTask.getKey())) {
                ALog.m4191e(TAG, "设置最高优先级任务失败，失败原因【任务中已经有最高优先级任务，请等待上一个最高优先级任务完成，或手动暂停该任务】");
                downloadTask.setHighestPriority(false);
                return;
            }
        }
    }

    @Override // com.arialyy.aria.core.queue.AbsTaskQueue, com.arialyy.aria.core.queue.ITaskQueue
    public void stopTask(DownloadTask downloadTask) {
        downloadTask.setHighestPriority(false);
        super.stopTask((DTaskQueue) downloadTask);
    }
}
