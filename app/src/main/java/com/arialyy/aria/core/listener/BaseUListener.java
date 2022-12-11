package com.arialyy.aria.core.listener;

import android.os.Handler;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.util.DeleteURecord;

/* loaded from: classes3.dex */
public class BaseUListener extends BaseListener<UploadEntity, UTaskWrapper, AbsTask<UTaskWrapper>> implements IUploadListener {
    public BaseUListener(AbsTask<UTaskWrapper> absTask, Handler handler) {
        super(absTask, handler);
    }

    @Override // com.arialyy.aria.core.listener.BaseListener
    public void handleCancel() {
        if (getTask().getSchedulerType() != 4) {
            DeleteURecord.getInstance().deleteRecord(this.mEntity, ((UTaskWrapper) this.mTaskWrapper).isRemoveFile(), true);
            return;
        }
        ((UploadEntity) this.mEntity).setComplete(false);
        ((UploadEntity) this.mEntity).setState(3);
        DeleteURecord.getInstance().deleteRecord(this.mEntity, ((UTaskWrapper) this.mTaskWrapper).isRemoveFile(), false);
    }
}
