package com.arialyy.aria.core.common;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.controller.INormalFeature;
import com.arialyy.aria.core.common.controller.NormalController;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DeleteDGRecord;
import com.arialyy.aria.util.RecordUtil;

/* loaded from: classes3.dex */
public abstract class AbsNormalTarget<TARGET extends AbsNormalTarget> extends AbsTarget<TARGET> implements INormalFeature {
    public NormalController mNormalController;

    private synchronized NormalController getController() {
        if (this.mNormalController == null) {
            this.mNormalController = new NormalController(getTaskWrapper());
        }
        return this.mNormalController;
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void cancel() {
        cancel(false);
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void cancel(boolean z) {
        onPre();
        getController().cancel(z);
    }

    public String getConvertFileSize() {
        return mo4441getEntity() == null ? "0b" : CommonUtil.formatFileSize(mo4441getEntity().getFileSize());
    }

    public long getCurrentProgress() {
        if (mo4441getEntity() == null) {
            return -1L;
        }
        return mo4441getEntity().getCurrentProgress();
    }

    public String getExtendField() {
        return mo4441getEntity().getStr();
    }

    public long getFileSize() {
        if (mo4441getEntity() == null) {
            return 0L;
        }
        return mo4441getEntity().getFileSize();
    }

    public int getPercent() {
        if (mo4441getEntity() == null) {
            ALog.m4191e("AbsTarget", "下载管理器中没有该任务");
            return 0;
        } else if (mo4441getEntity().getFileSize() == 0) {
            return 0;
        } else {
            return (int) ((mo4441getEntity().getCurrentProgress() * 100) / mo4441getEntity().getFileSize());
        }
    }

    public int getTaskState() {
        return mo4441getEntity().getState();
    }

    public TARGET ignoreCheckPermissions() {
        getController().ignoreCheckPermissions();
        return this;
    }

    public boolean isRunning() {
        return false;
    }

    public void onPre() {
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public long reStart() {
        onPre();
        return getController().reStart();
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void reTry() {
        onPre();
        getController().reTry();
    }

    public void removeRecord() {
        if (isRunning()) {
            ALog.m4192d("AbsTarget", "任务正在下载，即将删除任务");
            cancel();
            return;
        }
        if (mo4441getEntity() instanceof AbsNormalEntity) {
            RecordUtil.delNormalTaskRecord((AbsNormalEntity) mo4441getEntity(), getTaskWrapper().isRemoveFile());
        } else if (mo4441getEntity() instanceof DownloadGroupEntity) {
            DeleteDGRecord.getInstance().deleteRecord(mo4441getEntity(), getTaskWrapper().isRemoveFile(), true);
        }
        TaskWrapperManager.getInstance().removeTaskWrapper(getTaskWrapper());
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void resume() {
        resume(false);
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void resume(boolean z) {
        onPre();
        getController().resume(z);
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void save() {
        onPre();
        getController().save();
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void stop() {
        onPre();
        getController().stop();
    }

    public boolean taskExists() {
        return false;
    }
}
