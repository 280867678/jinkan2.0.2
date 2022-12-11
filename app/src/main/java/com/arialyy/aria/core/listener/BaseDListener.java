package com.arialyy.aria.core.listener;

import android.os.Handler;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DeleteDRecord;

/* loaded from: classes3.dex */
public class BaseDListener extends BaseListener<DownloadEntity, DTaskWrapper, AbsTask<DTaskWrapper>> implements IDLoadListener {
    public BaseDListener(AbsTask<DTaskWrapper> absTask, Handler handler) {
        super(absTask, handler);
    }

    @Override // com.arialyy.aria.core.listener.BaseListener
    public void handleCancel() {
        if (getTask().getSchedulerType() != 4) {
            DeleteDRecord.getInstance().deleteRecord(this.mEntity, ((DTaskWrapper) this.mTaskWrapper).isRemoveFile(), true);
            return;
        }
        ((DownloadEntity) this.mEntity).setComplete(false);
        ((DownloadEntity) this.mEntity).setState(3);
        DeleteDRecord.getInstance().deleteRecord(this.mEntity, ((DTaskWrapper) this.mTaskWrapper).isRemoveFile(), false);
    }

    @Override // com.arialyy.aria.core.listener.IDLoadListener
    public void onPostPre(long j) {
        ((DownloadEntity) this.mEntity).setFileSize(j);
        ((DownloadEntity) this.mEntity).setConvertFileSize(CommonUtil.formatFileSize(j));
        saveData(6, -1L);
        sendInState2Target(1);
    }

    @Override // com.arialyy.aria.core.listener.IDLoadListener
    public void supportBreakpoint(boolean z) {
        if (!z) {
            sendInState2Target(9);
        }
    }
}
