package com.arialyy.aria.core.listener;

import android.os.Handler;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.group.GroupSendParams;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.task.DownloadGroupTask;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DeleteDGRecord;
import com.arialyy.aria.util.ErrorHelp;

/* loaded from: classes3.dex */
public class DownloadGroupListener extends BaseListener<DownloadGroupEntity, DGTaskWrapper, AbsTask<DGTaskWrapper>> implements IDGroupListener {
    public GroupSendParams<DownloadGroupTask, DownloadEntity> mSeedEntity;

    public DownloadGroupListener(AbsTask<DGTaskWrapper> absTask, Handler handler) {
        super(absTask, handler);
        GroupSendParams<DownloadGroupTask, DownloadEntity> groupSendParams = new GroupSendParams<>();
        this.mSeedEntity = groupSendParams;
        groupSendParams.groupTask = (DownloadGroupTask) absTask;
    }

    private void handleSubSpeed(DownloadEntity downloadEntity, long j) {
        long j2 = 0;
        if (j == 0) {
            downloadEntity.setSpeed(0L);
            downloadEntity.setConvertSpeed("0kb/s");
            return;
        }
        long currentProgress = j - downloadEntity.getCurrentProgress();
        downloadEntity.setSpeed(currentProgress);
        int i = (currentProgress > 0L ? 1 : (currentProgress == 0L ? 0 : -1));
        downloadEntity.setConvertSpeed(i <= 0 ? "" : String.format("%s/s", CommonUtil.formatFileSize(currentProgress)));
        if (downloadEntity.getFileSize() > 0) {
            j2 = (downloadEntity.getCurrentProgress() * 100) / downloadEntity.getFileSize();
        }
        downloadEntity.setPercent((int) j2);
        downloadEntity.setCurrentProgress(j);
        if (i == 0) {
            downloadEntity.setTimeLeft(Integer.MAX_VALUE);
        } else {
            downloadEntity.setTimeLeft((int) ((downloadEntity.getFileSize() - downloadEntity.getCurrentProgress()) / currentProgress));
        }
    }

    private void saveCurrentLocation() {
        if (((DownloadGroupEntity) this.mEntity).getSubEntities() == null || ((DownloadGroupEntity) this.mEntity).getSubEntities().isEmpty()) {
            ALog.m4185w(BaseListener.TAG, "保存进度失败，子任务为null");
            return;
        }
        long j = 0;
        for (DownloadEntity downloadEntity : ((DownloadGroupEntity) this.mEntity).getSubEntities()) {
            j += downloadEntity.getCurrentProgress();
        }
        if (j > ((DownloadGroupEntity) this.mEntity).getFileSize()) {
            j = ((DownloadGroupEntity) this.mEntity).getFileSize();
        }
        ((DownloadGroupEntity) this.mEntity).setCurrentProgress(j);
        ((DownloadGroupEntity) this.mEntity).update();
    }

    private void saveSubState(int i, DownloadEntity downloadEntity) {
        downloadEntity.setState(i);
        if (i == 2) {
            downloadEntity.setStopTime(System.currentTimeMillis());
        } else if (i == 1) {
            downloadEntity.setComplete(true);
            downloadEntity.setCompleteTime(System.currentTimeMillis());
            downloadEntity.setCurrentProgress(downloadEntity.getFileSize());
            downloadEntity.setPercent(100);
            downloadEntity.setConvertSpeed("0kb/s");
            downloadEntity.setSpeed(0L);
        }
        downloadEntity.update();
    }

    private void sendInState2Target(int i, DownloadEntity downloadEntity) {
        if (this.outHandler.get() != null) {
            this.mSeedEntity.entity = downloadEntity;
            this.outHandler.get().obtainMessage(i, 209, 0, this.mSeedEntity).sendToTarget();
        }
    }

    @Override // com.arialyy.aria.core.listener.BaseListener
    public void handleCancel() {
        if (getTask().getSchedulerType() != 4) {
            DeleteDGRecord.getInstance().deleteRecord(this.mEntity, ((DGTaskWrapper) this.mTaskWrapper).isRemoveFile(), true);
            return;
        }
        ((DownloadGroupEntity) this.mEntity).setComplete(false);
        ((DownloadGroupEntity) this.mEntity).setState(3);
        DeleteDGRecord.getInstance().deleteRecord(this.mEntity, ((DGTaskWrapper) this.mTaskWrapper).isRemoveFile(), false);
    }

    @Override // com.arialyy.aria.core.listener.IDLoadListener
    public void onPostPre(long j) {
        ((DownloadGroupEntity) this.mEntity).setFileSize(j);
        ((DownloadGroupEntity) this.mEntity).setConvertFileSize(CommonUtil.formatFileSize(j));
        saveData(6, -1L);
        sendInState2Target(1);
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubCancel(DownloadEntity downloadEntity) {
        handleSubSpeed(downloadEntity, 0L);
        saveSubState(7, downloadEntity);
        saveCurrentLocation();
        sendInState2Target(164, downloadEntity);
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubComplete(DownloadEntity downloadEntity) {
        handleSubSpeed(downloadEntity, 0L);
        saveSubState(1, downloadEntity);
        saveCurrentLocation();
        sendInState2Target(167, downloadEntity);
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubFail(DownloadEntity downloadEntity, AriaException ariaException) {
        handleSubSpeed(downloadEntity, 0L);
        saveSubState(0, downloadEntity);
        saveCurrentLocation();
        this.mSeedEntity.groupTask.putExpand(AbsTask.ERROR_INFO_KEY, ariaException);
        sendInState2Target(165, downloadEntity);
        if (ariaException != null) {
            ariaException.printStackTrace();
            ErrorHelp.saveError(ariaException.getTag(), "", ALog.getExceptionString(ariaException));
        }
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubPre(DownloadEntity downloadEntity) {
        handleSubSpeed(downloadEntity, 0L);
        saveSubState(5, downloadEntity);
        sendInState2Target(161, downloadEntity);
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubRunning(DownloadEntity downloadEntity, long j) {
        handleSubSpeed(downloadEntity, j);
        if (System.currentTimeMillis() - this.mLastSaveTime >= 5000) {
            saveSubState(4, downloadEntity);
            this.mLastSaveTime = System.currentTimeMillis();
        }
        sendInState2Target(166, downloadEntity);
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubStart(DownloadEntity downloadEntity) {
        handleSubSpeed(downloadEntity, 0L);
        saveSubState(4, downloadEntity);
        sendInState2Target(162, downloadEntity);
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void onSubStop(DownloadEntity downloadEntity, long j) {
        downloadEntity.setCurrentProgress(j);
        handleSubSpeed(downloadEntity, 0L);
        saveSubState(2, downloadEntity);
        saveCurrentLocation();
        sendInState2Target(163, downloadEntity);
    }

    @Override // com.arialyy.aria.core.listener.IDLoadListener
    public void supportBreakpoint(boolean z) {
    }

    @Override // com.arialyy.aria.core.listener.IDGroupListener
    public void supportBreakpoint(boolean z, DownloadEntity downloadEntity) {
    }
}
