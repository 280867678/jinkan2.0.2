package com.arialyy.aria.core.download.target;

import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.event.ErrorEvent;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.core.inf.IConfigHandler;
import com.arialyy.aria.core.manager.SubTaskManager;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.task.DownloadGroupTask;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public abstract class AbsGroupConfigHandler<TARGET extends AbsTarget> implements IConfigHandler {
    public String TAG = CommonUtil.getClassName((Class) getClass());
    public SubTaskManager mSubTaskManager;
    public TARGET mTarget;
    public DGTaskWrapper mWrapper;

    public AbsGroupConfigHandler(TARGET target, long j) {
        ErrorEvent errorEvent;
        this.mTarget = target;
        DGTaskWrapper dGTaskWrapper = (DGTaskWrapper) TaskWrapperManager.getInstance().getGroupWrapper(DGTaskWrapper.class, j);
        this.mWrapper = dGTaskWrapper;
        if (this.mTarget instanceof AbsNormalTarget) {
            if (j < 0) {
                errorEvent = new ErrorEvent(j, "任务id为空");
            } else if (((DownloadGroupEntity) dGTaskWrapper.mo4442getEntity()).getId() < 0) {
                dGTaskWrapper = this.mWrapper;
                errorEvent = new ErrorEvent(j, "任务信息不存在");
            }
            dGTaskWrapper.setErrorEvent(errorEvent);
        }
        this.mTarget.setTaskWrapper(this.mWrapper);
        if (mo4422getEntity() != null) {
            getTaskWrapper().setDirPathTemp(mo4422getEntity().getDirPath());
        }
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    /* renamed from: getEntity  reason: collision with other method in class */
    public DownloadGroupEntity mo4422getEntity() {
        return (DownloadGroupEntity) this.mWrapper.mo4442getEntity();
    }

    public SubTaskManager getSubTaskManager() {
        if (this.mSubTaskManager == null) {
            this.mSubTaskManager = new SubTaskManager(getTaskWrapper());
        }
        return this.mSubTaskManager;
    }

    public TARGET getTarget() {
        return this.mTarget;
    }

    public DGTaskWrapper getTaskWrapper() {
        return this.mWrapper;
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean isRunning() {
        DownloadGroupTask mo4434getTask = DGroupTaskQueue.getInstance().mo4434getTask(mo4422getEntity().getKey());
        return mo4434getTask != null && mo4434getTask.isRunning();
    }

    public TARGET setDirPath(String str) {
        this.mWrapper.setDirPathTemp(str);
        return this.mTarget;
    }

    public void setGroupAlias(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mo4422getEntity().setAlias(str);
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean taskExists() {
        return mo4422getEntity().getId() != -1 && DbEntity.checkDataExist(DownloadGroupEntity.class, "rowid=?", String.valueOf(mo4422getEntity().getId()));
    }
}
