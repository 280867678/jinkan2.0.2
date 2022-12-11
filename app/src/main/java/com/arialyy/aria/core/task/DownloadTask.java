package com.arialyy.aria.core.task;

import android.os.Handler;
import android.os.Looper;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.util.ComponentUtil;

/* loaded from: classes3.dex */
public class DownloadTask extends AbsTask<DTaskWrapper> {

    /* loaded from: classes3.dex */
    public static class Builder {
        public Handler outHandler;
        public DTaskWrapper taskEntity;

        public Builder(DTaskWrapper dTaskWrapper) {
            this.taskEntity = dTaskWrapper;
        }

        public DownloadTask build() {
            return new DownloadTask(this.taskEntity, this.outHandler);
        }

        public Builder setOutHandler(ISchedulers iSchedulers) {
            this.outHandler = new Handler(Looper.getMainLooper(), iSchedulers);
            return this;
        }
    }

    public DownloadTask(DTaskWrapper dTaskWrapper, Handler handler) {
        this.mTaskWrapper = dTaskWrapper;
        this.mOutHandler = handler;
        this.mContext = AriaConfig.getInstance().getAPP();
        this.mListener = ComponentUtil.getInstance().buildListener(dTaskWrapper.getRequestType(), this, this.mOutHandler);
    }

    public DownloadEntity getDownloadEntity() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity();
    }

    @Deprecated
    public String getDownloadUrl() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity().getUrl();
    }

    public DownloadEntity getEntity() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity();
    }

    public String getFilePath() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity().getFilePath();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public String getKey() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity().getKey();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public String getTaskName() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity().getFileName();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public int getTaskType() {
        return 1;
    }
}
