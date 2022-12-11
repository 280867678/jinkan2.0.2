package com.arialyy.aria.core.loader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.core.task.ThreadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class NormalTTBuilder implements IThreadTaskBuilder {
    public String TAG = CommonUtil.getClassName(this);
    public AbsNormalTTBuilderAdapter mAdapter;
    public TaskRecord mRecord;
    public int mStartThreadNum;
    public Handler mStateHandler;
    public int mTotalThreadNum;
    public AbsTaskWrapper mWrapper;

    public NormalTTBuilder(AbsTaskWrapper absTaskWrapper, AbsNormalTTBuilderAdapter absNormalTTBuilderAdapter) {
        if (!(absTaskWrapper instanceof DGTaskWrapper)) {
            this.mWrapper = absTaskWrapper;
            this.mAdapter = absNormalTTBuilderAdapter;
            absNormalTTBuilderAdapter.setWrapper(absTaskWrapper);
            return;
        }
        throw new AssertionError("NormalTTBuilder 不适用于组合任务");
    }

    private IThreadTask createSingThreadTask(ThreadRecord threadRecord, int i) {
        return createThreadTask(this.mAdapter.getSubThreadConfig(this.mStateHandler, threadRecord, this.mRecord.isBlock, i));
    }

    private IThreadTask createThreadTask(SubThreadConfig subThreadConfig) {
        ThreadTask threadTask = new ThreadTask(subThreadConfig);
        threadTask.setAdapter(this.mAdapter.getAdapter(subThreadConfig));
        return threadTask;
    }

    private List<IThreadTask> handleBreakpoint() {
        Object obj;
        long fileSize = getEntity().getFileSize();
        long j = fileSize / this.mTotalThreadNum;
        ArrayList arrayList = new ArrayList(this.mTotalThreadNum);
        this.mRecord.fileLength = fileSize;
        if (this.mWrapper.isNewTask() && !this.mAdapter.handleNewTask(this.mRecord, this.mTotalThreadNum)) {
            ALog.m4191e(this.TAG, "初始化线程任务失败");
            return null;
        }
        for (ThreadRecord threadRecord : this.mRecord.threadRecords) {
            if (!threadRecord.isComplete) {
                this.mStartThreadNum++;
            }
        }
        long j2 = 0;
        int i = 0;
        while (i < this.mTotalThreadNum) {
            long j3 = i * j;
            int i2 = i + 1;
            long j4 = i2 * j;
            ThreadRecord threadRecord2 = this.mRecord.threadRecords.get(i);
            long j5 = fileSize;
            if (threadRecord2.isComplete) {
                long j6 = (j4 - j3) + j2;
                ALog.m4192d(this.TAG, String.format("任务【%s】线程__%s__已完成", this.mWrapper.getKey(), Integer.valueOf(i)));
                Message obtainMessage = this.mStateHandler.obtainMessage();
                obtainMessage.what = 4;
                Bundle data = obtainMessage.getData();
                if (data == null) {
                    data = new Bundle();
                }
                data.putString(IThreadStateManager.DATA_THREAD_NAME, CommonUtil.getThreadName(getEntity().getKey(), threadRecord2.threadId));
                obtainMessage.setData(data);
                obtainMessage.sendToTarget();
                j2 = j6;
                obj = null;
            } else {
                long j7 = threadRecord2.startLocation;
                if (j3 < j7) {
                    if (i == this.mTotalThreadNum - 1) {
                        j4 = j5;
                    }
                    if (j7 <= j4) {
                        j2 += j7 - j3;
                    }
                }
                ALog.m4192d(this.TAG, String.format("任务【%s】线程__%s__恢复任务", getEntity().getFileName(), Integer.valueOf(i)));
                IThreadTask createSingThreadTask = createSingThreadTask(threadRecord2, this.mStartThreadNum);
                if (createSingThreadTask == null) {
                    ALog.m4191e(this.TAG, "创建线程任务失败");
                    return null;
                }
                obj = null;
                arrayList.add(createSingThreadTask);
            }
            i = i2;
            fileSize = j5;
        }
        if (j2 != getEntity().getCurrentProgress()) {
            ALog.m4192d(this.TAG, String.format("进度修正，当前进度：%s", Long.valueOf(j2)));
            getEntity().setCurrentProgress(j2);
        }
        return arrayList;
    }

    private List<IThreadTask> handleNoSupportBP() {
        ArrayList arrayList = new ArrayList();
        this.mStartThreadNum = 1;
        IThreadTask createSingThreadTask = createSingThreadTask(this.mRecord.threadRecords.get(0), 1);
        if (createSingThreadTask == null) {
            ALog.m4191e(this.TAG, "创建线程任务失败");
            return null;
        }
        arrayList.add(createSingThreadTask);
        return arrayList;
    }

    private List<IThreadTask> handleTask() {
        return this.mWrapper.isSupportBP() ? handleBreakpoint() : handleNoSupportBP();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IThreadTaskBuilder
    public List<IThreadTask> buildThreadTask(TaskRecord taskRecord, Handler handler) {
        this.mRecord = taskRecord;
        this.mStateHandler = handler;
        this.mTotalThreadNum = taskRecord.threadNum;
        return handleTask();
    }

    public AbsNormalTTBuilderAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.arialyy.aria.core.loader.IThreadTaskBuilder
    public int getCreatedThreadNum() {
        return this.mStartThreadNum;
    }

    public AbsNormalEntity getEntity() {
        return (AbsNormalEntity) this.mWrapper.mo4442getEntity();
    }
}
