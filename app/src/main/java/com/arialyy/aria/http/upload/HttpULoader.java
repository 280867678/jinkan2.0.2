package com.arialyy.aria.http.upload;

import android.os.Handler;
import android.os.Looper;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.loader.IThreadTaskBuilder;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.util.ALog;
import java.util.List;

/* loaded from: classes3.dex */
public final class HttpULoader extends AbsNormalLoader<UTaskWrapper> {
    public HttpULoader(UTaskWrapper uTaskWrapper, IEventListener iEventListener) {
        super(uTaskWrapper, iEventListener);
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IThreadStateManager iThreadStateManager) {
        this.mStateManager = iThreadStateManager;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    @Deprecated
    public void addComponent(IInfoTask iInfoTask) {
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IRecordHandler iRecordHandler) {
        this.mRecordHandler = iRecordHandler;
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IThreadTaskBuilder iThreadTaskBuilder) {
        this.mTTBuilder = iThreadTaskBuilder;
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public void checkComponent() {
        if (this.mRecordHandler != null) {
            if (this.mStateManager == null) {
                throw new NullPointerException("任务状态管理组件为空");
            }
            if (this.mTTBuilder == null) {
                throw new NullPointerException("线程任务组件为空");
            }
            return;
        }
        throw new NullPointerException("任务记录组件为空");
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public long getCurrentProgress() {
        return this.mStateManager.getCurrentProgress();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public long getFileSize() {
        return ((UTaskWrapper) this.mTaskWrapper).mo4442getEntity().getFileSize();
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public void handleTask(Looper looper) {
        TaskRecord record = this.mRecordHandler.getRecord(getFileSize());
        this.mRecord = record;
        this.mStateManager.setLooper(record, looper);
        List<IThreadTask> buildThreadTask = this.mTTBuilder.buildThreadTask(this.mRecord, new Handler(looper, this.mStateManager.getHandlerCallback()));
        if (buildThreadTask == null || buildThreadTask.isEmpty()) {
            ALog.m4191e(this.TAG, "创建线程任务失败");
            mo4447getListener().onFail(false, new AriaHTTPException(this.TAG, "创建线程任务失败"));
            return;
        }
        mo4447getListener().onStart(0L);
        ThreadTaskManager.getInstance().startThread(((UTaskWrapper) this.mTaskWrapper).getKey(), buildThreadTask.get(0));
        startTimer();
    }
}
