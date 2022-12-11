package com.arialyy.aria.core.upload.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public class HttpNormalTarget extends AbsNormalTarget<HttpNormalTarget> {
    public UNormalConfigHandler<HttpNormalTarget> mConfigHandler;

    public HttpNormalTarget(long j) {
        this.mConfigHandler = new UNormalConfigHandler<>(this, j);
        getTaskWrapper().setSupportBP(false);
        getTaskWrapper().setRequestType(5);
        getTaskWrapper().setNewTask(false);
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean isRunning() {
        return this.mConfigHandler.isRunning();
    }

    public HttpNormalTarget option(HttpOption httpOption) {
        if (httpOption != null) {
            getTaskWrapper().getOptionParams().setParams(httpOption);
            return this;
        }
        throw new NullPointerException("任务配置为空");
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget, com.arialyy.aria.core.common.controller.INormalFeature
    public void resume() {
        ALog.m4191e(this.TAG, "http上传任务没有恢复功能");
    }

    public HttpNormalTarget setUploadUrl(String str) {
        this.mConfigHandler.setTempUrl(str);
        return this;
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean taskExists() {
        return this.mConfigHandler.taskExists();
    }
}
