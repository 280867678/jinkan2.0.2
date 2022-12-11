package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.core.download.AbsGroupTaskWrapper;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.manager.SubTaskManager;
import com.arialyy.aria.util.ALog;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupNormalTarget extends AbsNormalTarget<GroupNormalTarget> {
    public HttpGroupConfigHandler<GroupNormalTarget> mConfigHandler;

    public GroupNormalTarget(long j) {
        this.mConfigHandler = new HttpGroupConfigHandler<>(this, j);
        getTaskWrapper().setRequestType(2);
        getTaskWrapper().setNewTask(false);
    }

    public SubTaskManager getSubTaskManager() {
        return this.mConfigHandler.getSubTaskManager();
    }

    public GroupNormalTarget ignoreTaskOccupy() {
        ((AbsGroupTaskWrapper) getTaskWrapper()).setIgnoreTaskOccupy(true);
        return this;
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean isRunning() {
        return this.mConfigHandler.isRunning();
    }

    public GroupNormalTarget modifyDirPath(String str) {
        return this.mConfigHandler.setDirPath(str);
    }

    public GroupNormalTarget modifySubFileName(List<String> list) {
        return this.mConfigHandler.setSubFileName(list);
    }

    public GroupNormalTarget option(HttpOption httpOption) {
        if (httpOption != null) {
            getTaskWrapper().getOptionParams().setParams(httpOption);
            return this;
        }
        throw new NullPointerException("任务配置为空");
    }

    public GroupNormalTarget setFileSize(long j) {
        if (j <= 0) {
            ALog.m4191e(this.TAG, "文件大小不能小于 0");
            return this;
        }
        if (mo4441getEntity().getFileSize() <= 1 || mo4441getEntity().getFileSize() != j) {
            mo4441getEntity().setFileSize(j);
        }
        return this;
    }

    public GroupNormalTarget setGroupAlias(String str) {
        this.mConfigHandler.setGroupAlias(str);
        return this;
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean taskExists() {
        return this.mConfigHandler.taskExists();
    }

    public GroupNormalTarget unknownSize() {
        ((DGTaskWrapper) getTaskWrapper()).setUnknownSize(true);
        return this;
    }

    public GroupNormalTarget updateUrls(List<String> list) {
        return this.mConfigHandler.updateUrls(list);
    }
}
