package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.AbsTaskQueue;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import java.util.List;

/* loaded from: classes3.dex */
public final class CancelAllCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public boolean removeFile = false;

    public CancelAllCmd(T t, int i) {
        super(t, i);
    }

    private void remove(AbsTaskWrapper absTaskWrapper) {
        AbsTaskQueue dGroupTaskQueue;
        if (absTaskWrapper == null) {
            ALog.m4185w(this.TAG, "取消任务失败，任务为空");
            return;
        }
        if (absTaskWrapper instanceof DTaskWrapper) {
            dGroupTaskQueue = DTaskQueue.getInstance();
        } else if (!(absTaskWrapper instanceof UTaskWrapper)) {
            if (absTaskWrapper instanceof DGTaskWrapper) {
                dGroupTaskQueue = DGroupTaskQueue.getInstance();
            }
            absTaskWrapper.setRemoveFile(this.removeFile);
            removeTask(absTaskWrapper);
        } else {
            dGroupTaskQueue = UTaskQueue.getInstance();
        }
        this.mQueue = dGroupTaskQueue;
        absTaskWrapper.setRemoveFile(this.removeFile);
        removeTask(absTaskWrapper);
    }

    private void removeAllDGTask() {
        List<DownloadGroupEntity> findDatas = DbEntity.findDatas(DownloadGroupEntity.class, "state!=?", "-1");
        if (findDatas == null || findDatas.isEmpty()) {
            return;
        }
        for (DownloadGroupEntity downloadGroupEntity : findDatas) {
            remove(TaskWrapperManager.getInstance().getGroupWrapper(DGTaskWrapper.class, downloadGroupEntity.getId()));
        }
    }

    private void removeAllDTask() {
        List<DownloadEntity> findDatas = DbEntity.findDatas(DownloadEntity.class, "isGroupChild=?", "false");
        if (findDatas == null || findDatas.isEmpty()) {
            return;
        }
        for (DownloadEntity downloadEntity : findDatas) {
            remove(TaskWrapperManager.getInstance().getNormalTaskWrapper(DTaskWrapper.class, downloadEntity.getId()));
        }
    }

    private void removeUTask() {
        List<UploadEntity> findDatas = DbEntity.findDatas(UploadEntity.class, "isGroupChild=?", "false");
        if (findDatas == null || findDatas.isEmpty()) {
            return;
        }
        for (UploadEntity uploadEntity : findDatas) {
            remove(TaskWrapperManager.getInstance().getNormalTaskWrapper(UTaskWrapper.class, uploadEntity.getId()));
        }
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (!this.canExeCmd) {
            return;
        }
        if (!this.isDownloadCmd) {
            removeUTask();
            return;
        }
        removeAllDTask();
        removeAllDGTask();
    }
}
