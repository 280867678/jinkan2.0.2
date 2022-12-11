package com.arialyy.aria.core.queue.pool;

import android.text.TextUtils;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes3.dex */
public class BaseExecutePool<TASK extends AbsTask> implements IPool<TASK> {
    public static final Object LOCK = new Object();
    public final String TAG = CommonUtil.getClassName(this);
    public int mSize = getMaxSize();
    public Deque<TASK> mExecuteQueue = new LinkedBlockingDeque(this.mSize);

    public List<TASK> getAllTask() {
        return new ArrayList(this.mExecuteQueue);
    }

    public int getMaxSize() {
        return 2;
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public TASK getTask(String str) {
        synchronized (LOCK) {
            if (TextUtils.isEmpty(str)) {
                ALog.m4191e(this.TAG, "key为null");
                return null;
            }
            for (TASK task : this.mExecuteQueue) {
                if (task.getKey().equals(str)) {
                    return task;
                }
            }
            return null;
        }
    }

    public boolean pollFirstTask() {
        synchronized (LOCK) {
            TASK pollFirst = this.mExecuteQueue.pollFirst();
            if (pollFirst == null) {
                ALog.m4185w(this.TAG, "移除任务失败，原因：任务为null");
                return false;
            }
            pollFirst.stop();
            return true;
        }
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public TASK pollTask() {
        TASK poll;
        synchronized (LOCK) {
            poll = this.mExecuteQueue.poll();
        }
        return poll;
    }

    public boolean putNewTask(TASK task) {
        boolean offer;
        synchronized (LOCK) {
            offer = this.mExecuteQueue.offer(task);
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("任务【");
            sb.append(task.getTaskName());
            sb.append("】进入执行队列");
            sb.append(offer ? "成功" : "失败");
            ALog.m4192d(str, sb.toString());
        }
        return offer;
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public boolean putTask(TASK task) {
        synchronized (LOCK) {
            if (task == null) {
                ALog.m4191e(this.TAG, "任务不能为空！！");
                return false;
            } else if (this.mExecuteQueue.contains(task)) {
                String str = this.TAG;
                ALog.m4191e(str, "任务【" + task.getTaskName() + "】进入执行队列失败，原因：已经在执行队列中");
                return false;
            } else if (this.mExecuteQueue.size() < this.mSize) {
                return putNewTask(task);
            } else if (!pollFirstTask()) {
                return false;
            } else {
                return putNewTask(task);
            }
        }
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public boolean removeTask(TASK task) {
        synchronized (LOCK) {
            if (task == null) {
                ALog.m4191e(this.TAG, "任务不能为空");
                return false;
            }
            return removeTask(task.getKey());
        }
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public boolean removeTask(String str) {
        synchronized (LOCK) {
            if (TextUtils.isEmpty(str)) {
                ALog.m4191e(this.TAG, "key 为null");
                return false;
            }
            return this.mExecuteQueue.remove(getTask(str));
        }
    }

    public void setMaxNum(int i) {
        synchronized (LOCK) {
            LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(i);
            while (true) {
                TASK poll = this.mExecuteQueue.poll();
                if (poll != null) {
                    linkedBlockingDeque.offer(poll);
                } else {
                    this.mExecuteQueue = linkedBlockingDeque;
                    this.mSize = i;
                }
            }
        }
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public int size() {
        return this.mExecuteQueue.size();
    }

    @Override // com.arialyy.aria.core.queue.pool.IPool
    public boolean taskExits(String str) {
        return getTask(str) != null;
    }
}
