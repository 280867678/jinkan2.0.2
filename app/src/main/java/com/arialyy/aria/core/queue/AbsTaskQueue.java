package com.arialyy.aria.core.queue;

import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.queue.pool.BaseCachePool;
import com.arialyy.aria.core.queue.pool.BaseExecutePool;
import com.arialyy.aria.core.queue.pool.DGLoadSharePool;
import com.arialyy.aria.core.queue.pool.DLoadSharePool;
import com.arialyy.aria.core.queue.pool.UploadSharePool;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.task.ITask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class AbsTaskQueue<TASK extends AbsTask, TASK_WRAPPER extends AbsTaskWrapper> implements ITaskQueue<TASK, TASK_WRAPPER> {
    public BaseCachePool<TASK> mCachePool;
    public BaseExecutePool<TASK> mExecutePool;
    public final int TYPE_D_QUEUE = 1;
    public final int TYPE_DG_QUEUE = 2;
    public final int TYPE_U_QUEUE = 3;
    public final String TAG = CommonUtil.getClassName(this);

    public AbsTaskQueue() {
        BaseExecutePool<TASK> baseExecutePool;
        int queueType = getQueueType();
        if (queueType == 1) {
            this.mCachePool = DLoadSharePool.getInstance().cachePool;
            baseExecutePool = DLoadSharePool.getInstance().executePool;
        } else if (queueType == 2) {
            this.mCachePool = DGLoadSharePool.getInstance().cachePool;
            baseExecutePool = DGLoadSharePool.getInstance().executePool;
        } else if (queueType != 3) {
            return;
        } else {
            this.mCachePool = UploadSharePool.getInstance().cachePool;
            baseExecutePool = UploadSharePool.getInstance().executePool;
        }
        this.mExecutePool = baseExecutePool;
    }

    public void addTask(TASK task) {
        if (task == null) {
            ALog.m4185w(this.TAG, "add task fail, task is null");
        } else if (this.mCachePool.taskExits(task.getKey())) {
        } else {
            this.mCachePool.putTask(task);
        }
    }

    public void cancelTask(TASK task) {
        cancelTask((AbsTaskQueue<TASK, TASK_WRAPPER>) task, 1);
    }

    public void cancelTask(TASK task, int i) {
        task.cancel(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void cancelTask(ITask iTask) {
        cancelTask((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void cancelTask(ITask iTask, int i) {
        cancelTask((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask), i);
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: createTask */
    public TASK mo4437createTask(TASK_WRAPPER task_wrapper) {
        TaskWrapperManager.getInstance().putTaskWrapper(task_wrapper);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: createTask  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ITask mo4437createTask(AbsTaskWrapper absTaskWrapper) {
        return mo4437createTask((AbsTaskQueue<TASK, TASK_WRAPPER>) absTaskWrapper);
    }

    public BaseCachePool getCachePool() {
        return this.mCachePool;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getCurrentCachePoolNum() {
        return this.mCachePool.size();
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getCurrentExePoolNum() {
        return this.mExecutePool.size();
    }

    public BaseExecutePool getExecutePool() {
        return this.mExecutePool;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: getNextTask */
    public TASK mo4433getNextTask() {
        return this.mCachePool.pollTask();
    }

    public abstract int getOldMaxNum();

    public abstract int getQueueType();

    public <T extends AbsEntity> List<T> getRunningTask(Class<T> cls) {
        List<TASK> allTask = this.mExecutePool.getAllTask();
        List<TASK> allTask2 = this.mCachePool.getAllTask();
        ArrayList arrayList = new ArrayList();
        if (allTask != null && !allTask.isEmpty()) {
            for (TASK task : allTask) {
                arrayList.add(task.getTaskWrapper().mo4442getEntity());
            }
        }
        if (allTask2 != null && !allTask2.isEmpty()) {
            for (TASK task2 : allTask2) {
                arrayList.add(task2.getTaskWrapper().mo4442getEntity());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    /* renamed from: getTask */
    public TASK mo4434getTask(String str) {
        TASK task = this.mExecutePool.getTask(str);
        if (task == null) {
            task = this.mCachePool.getTask(str);
        }
        String str2 = this.TAG;
        ALog.m4189i(str2, "获取任务，key：" + str);
        return task;
    }

    public void reTryStart(TASK task) {
        String str;
        String format;
        if (task == null) {
            ALog.m4191e(this.TAG, "reTry fail, task is null");
            return;
        }
        switch (task.getState()) {
            case -1:
            case 0:
            case 2:
            case 3:
                task.start();
                return;
            case 1:
                str = this.TAG;
                format = String.format("任务【%s】重试失败，原因：已完成", task.getTaskName());
                ALog.m4191e(str, format);
                return;
            case 4:
            case 5:
            case 6:
                ALog.m4185w(this.TAG, String.format("任务【%s】没有停止，即将重新下载", task.getTaskName()));
                task.stop(2);
                task.start();
                return;
            case 7:
                str = this.TAG;
                format = String.format("任务【%s】重试失败，原因：任务已删除", task.getTaskName());
                ALog.m4191e(str, format);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void reTryStart(ITask iTask) {
        reTryStart((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask));
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void removeTaskFormQueue(String str) {
        TASK task = this.mExecutePool.getTask(str);
        String str2 = "成功";
        if (task != null) {
            String str3 = this.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = task.getTaskName();
            objArr[1] = this.mExecutePool.removeTask((BaseExecutePool<TASK>) task) ? str2 : "失败";
            ALog.m4192d(str3, String.format("从执行池删除任务【%s】%s", objArr));
        }
        TASK task2 = this.mCachePool.getTask(str);
        if (task2 != null) {
            String str4 = this.TAG;
            Object[] objArr2 = new Object[2];
            objArr2[0] = task2.getTaskName();
            if (!this.mCachePool.removeTask((BaseCachePool<TASK>) task2)) {
                str2 = "失败";
            }
            objArr2[1] = str2;
            ALog.m4192d(str4, String.format("从缓存池删除任务【%s】%s", objArr2));
        }
    }

    public void resumeTask(TASK task) {
        if (task == null) {
            ALog.m4185w(this.TAG, "resume task fail, task is null");
        } else if (this.mExecutePool.taskExits(task.getKey())) {
            ALog.m4185w(this.TAG, String.format("task【%s】running", task.getKey()));
        } else if (this.mExecutePool.size() < getMaxTaskNum()) {
            startTask((AbsTaskQueue<TASK, TASK_WRAPPER>) task);
        } else {
            task.getTaskWrapper().mo4442getEntity().setState(3);
            this.mCachePool.putTaskToFirst(task);
            stopTask((AbsTaskQueue<TASK, TASK_WRAPPER>) this.mExecutePool.pollTask());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void resumeTask(ITask iTask) {
        resumeTask((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask));
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void setMaxTaskNum(int i) {
        int oldMaxNum = getOldMaxNum();
        int i2 = i - oldMaxNum;
        if (oldMaxNum == i) {
            ALog.m4185w(this.TAG, "设置的下载任务数和配置文件的下载任务数一直，跳过");
            return;
        }
        if (i2 <= -1 && this.mExecutePool.size() >= oldMaxNum) {
            int abs = Math.abs(i2);
            for (int i3 = 0; i3 < abs; i3++) {
                TASK pollTask = this.mExecutePool.pollTask();
                if (pollTask != null) {
                    stopTask((AbsTaskQueue<TASK, TASK_WRAPPER>) pollTask);
                }
            }
        }
        this.mExecutePool.setMaxNum(i);
        if (i2 < 1) {
            return;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            TASK mo4433getNextTask = mo4433getNextTask();
            if (mo4433getNextTask != null && mo4433getNextTask.getState() == 3) {
                startTask((AbsTaskQueue<TASK, TASK_WRAPPER>) mo4433getNextTask);
            }
        }
    }

    public void startTask(TASK task) {
        startTask((AbsTaskQueue<TASK, TASK_WRAPPER>) task, 1);
    }

    public void startTask(TASK task, int i) {
        if (task == null) {
            ALog.m4185w(this.TAG, "create fail, task is null");
        }
        if (this.mExecutePool.taskExits(task.getKey())) {
            ALog.m4185w(this.TAG, String.format("任务【%s】执行中", task.getKey()));
            return;
        }
        String str = this.TAG;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("添加任务，key：");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(task.getKey());
        ALog.m4189i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        this.mCachePool.removeTask((BaseCachePool<TASK>) task);
        this.mExecutePool.putTask(task);
        task.getTaskWrapper().mo4442getEntity().setFailNum(0);
        task.start(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void startTask(ITask iTask) {
        startTask((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void startTask(ITask iTask, int i) {
        startTask((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask), i);
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void stopAllTask() {
        for (TASK task : this.mExecutePool.getAllTask()) {
            if (task != null) {
                int state = task.getState();
                if (task.isRunning() || (state != 1 && state != 7)) {
                    task.stop(2);
                }
            }
        }
        for (TASK task2 : this.mCachePool.getAllTask()) {
            if (task2 != null) {
                task2.stop(2);
            }
        }
        ThreadTaskManager.getInstance().removeAllThreadTask();
        this.mCachePool.clear();
    }

    public void stopTask(TASK task) {
        String str;
        String format;
        if (task == null) {
            ALog.m4185w(this.TAG, "stop fail, task is null");
            return;
        }
        boolean z = false;
        switch (task.getState()) {
            case -1:
            case 0:
            case 2:
                ALog.m4185w(this.TAG, String.format("停止任务【%s】失败，原因：已停止", task.getTaskName()));
                if (taskIsRunning(task.getKey())) {
                    removeTaskFormQueue(task.getKey());
                    if (ThreadTaskManager.getInstance().taskIsRunning(task.getKey())) {
                        ThreadTaskManager.getInstance().removeTaskThread(task.getKey());
                        break;
                    }
                }
                break;
            case 1:
                str = this.TAG;
                format = String.format("停止任务【%s】失败，原因：已完成", task.getTaskName());
                ALog.m4185w(str, format);
                break;
            case 3:
                this.mCachePool.removeTask((BaseCachePool<TASK>) task);
                z = true;
                break;
            case 4:
            case 5:
            case 6:
                this.mExecutePool.removeTask((BaseExecutePool<TASK>) task);
                z = true;
                break;
            case 7:
                str = this.TAG;
                format = String.format("停止任务【%s】失败，原因：任务已删除", task.getTaskName());
                ALog.m4185w(str, format);
                break;
        }
        if (!z) {
            return;
        }
        task.stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public /* bridge */ /* synthetic */ void stopTask(ITask iTask) {
        stopTask((AbsTaskQueue<TASK, TASK_WRAPPER>) ((AbsTask) iTask));
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public boolean taskExists(String str) {
        return mo4434getTask(str) != null;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public boolean taskIsRunning(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4185w(this.TAG, "key为空，无法确认任务是否执行");
            return false;
        }
        TASK task = this.mExecutePool.getTask(str);
        if (task == null && ThreadTaskManager.getInstance().taskIsRunning(str)) {
            ThreadTaskManager.getInstance().removeTaskThread(str);
        }
        return task != null && task.isRunning() && taskExists(str);
    }
}
