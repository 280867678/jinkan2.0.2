package com.arialyy.aria.core.upload.target;

import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.event.ErrorEvent;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.core.inf.IConfigHandler;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.UploadTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;

/* loaded from: classes3.dex */
public class UNormalConfigHandler<TARGET extends AbsTarget> implements IConfigHandler {
    public UploadEntity mEntity;
    public TARGET mTarget;
    public UTaskWrapper mWrapper;

    public UNormalConfigHandler(TARGET target, long j) {
        this.mTarget = target;
        initTarget(j);
    }

    private UTaskWrapper getTaskWrapper() {
        return this.mWrapper;
    }

    private void initTarget(long j) {
        ErrorEvent errorEvent;
        UTaskWrapper uTaskWrapper = (UTaskWrapper) TaskWrapperManager.getInstance().getNormalTaskWrapper(UTaskWrapper.class, j);
        this.mWrapper = uTaskWrapper;
        if (this.mTarget instanceof AbsNormalTarget) {
            if (j < 0) {
                errorEvent = new ErrorEvent(j, "任务id为空");
            } else if (uTaskWrapper.mo4442getEntity().getId() < 0) {
                uTaskWrapper = this.mWrapper;
                errorEvent = new ErrorEvent(j, "任务信息不存在");
            }
            uTaskWrapper.setErrorEvent(errorEvent);
        }
        this.mEntity = this.mWrapper.mo4442getEntity();
        this.mTarget.setTaskWrapper(this.mWrapper);
        getTaskWrapper().setTempUrl(this.mEntity.getUrl());
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    /* renamed from: getEntity */
    public AbsEntity mo4422getEntity() {
        return this.mEntity;
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean isRunning() {
        UploadTask mo4434getTask = UTaskQueue.getInstance().mo4434getTask(this.mEntity.getKey());
        return mo4434getTask != null && mo4434getTask.isRunning();
    }

    public void setFilePath(String str) {
        File file = new File(str);
        this.mEntity.setFilePath(str);
        this.mEntity.setFileName(file.getName());
        this.mEntity.setFileSize(file.length());
    }

    public void setTempUrl(String str) {
        getTaskWrapper().setTempUrl(str);
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean taskExists() {
        return DbEntity.checkDataExist(UploadEntity.class, "key=?", this.mEntity.getFilePath());
    }
}
