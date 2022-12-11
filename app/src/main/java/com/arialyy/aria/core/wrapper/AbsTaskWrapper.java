package com.arialyy.aria.core.wrapper;

import com.arialyy.aria.core.TaskOptionParams;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.config.BaseTaskConfig;
import com.arialyy.aria.core.event.ErrorEvent;
import com.arialyy.aria.core.inf.ITaskOption;
import com.arialyy.aria.util.ComponentUtil;

/* loaded from: classes3.dex */
public abstract class AbsTaskWrapper<ENTITY extends AbsEntity> implements ITaskWrapper {
    public int code;
    public ENTITY entity;
    public ErrorEvent errorEvent;
    public ITaskOption taskOption;
    public boolean refreshInfo = false;
    public boolean isNewTask = false;
    public int requestType = 1;
    public boolean removeFile = false;
    public boolean isSupportBP = true;
    public TaskOptionParams optionParams = new TaskOptionParams();
    public boolean ignoreFilePathOccupy = false;

    public AbsTaskWrapper(ENTITY entity) {
        this.entity = entity;
    }

    public void generateTaskOption(Class<? extends ITaskOption> cls) {
        this.taskOption = ComponentUtil.getInstance().buildTaskOption(cls, this.optionParams);
    }

    public int getCode() {
        return this.code;
    }

    /* renamed from: getConfig */
    public abstract BaseTaskConfig mo4438getConfig();

    @Override // com.arialyy.aria.core.wrapper.ITaskWrapper
    /* renamed from: getEntity */
    public ENTITY mo4442getEntity() {
        return this.entity;
    }

    public ErrorEvent getErrorEvent() {
        return this.errorEvent;
    }

    public TaskOptionParams getOptionParams() {
        if (this.optionParams == null) {
            this.optionParams = new TaskOptionParams();
        }
        return this.optionParams;
    }

    @Override // com.arialyy.aria.core.wrapper.ITaskWrapper
    public int getRequestType() {
        return this.requestType;
    }

    public int getState() {
        return mo4442getEntity().getState();
    }

    public ITaskOption getTaskOption() {
        return this.taskOption;
    }

    public boolean isIgnoreFilePathOccupy() {
        return this.ignoreFilePathOccupy;
    }

    public boolean isNewTask() {
        return this.isNewTask;
    }

    public boolean isRefreshInfo() {
        return this.refreshInfo;
    }

    public boolean isRemoveFile() {
        return this.removeFile;
    }

    public boolean isSupportBP() {
        return this.isSupportBP;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorEvent(ErrorEvent errorEvent) {
        this.errorEvent = errorEvent;
    }

    public void setIgnoreFilePathOccupy(boolean z) {
        this.ignoreFilePathOccupy = z;
    }

    public void setNewTask(boolean z) {
        this.isNewTask = z;
    }

    public void setRefreshInfo(boolean z) {
        this.refreshInfo = z;
    }

    public void setRemoveFile(boolean z) {
        this.removeFile = z;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public void setState(int i) {
        this.entity.setState(i);
    }

    public void setSupportBP(boolean z) {
        this.isSupportBP = z;
    }

    public void setTaskOption(ITaskOption iTaskOption) {
        this.taskOption = iTaskOption;
    }
}
