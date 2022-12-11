package com.arialyy.aria.core.task;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.util.ComponentUtil;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DownloadGroupTask extends AbsGroupTask<DGTaskWrapper> {

    /* loaded from: classes3.dex */
    public static class Builder {
        public Handler outHandler;
        public DGTaskWrapper taskEntity;

        public Builder(DGTaskWrapper dGTaskWrapper) {
            this.taskEntity = dGTaskWrapper;
        }

        public DownloadGroupTask build() {
            return new DownloadGroupTask(this.taskEntity, this.outHandler);
        }

        public Builder setOutHandler(ISchedulers iSchedulers) {
            this.outHandler = new Handler(Looper.getMainLooper(), iSchedulers);
            return this;
        }
    }

    public DownloadGroupTask(DGTaskWrapper dGTaskWrapper, Handler handler) {
        this.mTaskWrapper = dGTaskWrapper;
        this.mOutHandler = handler;
        this.mContext = AriaConfig.getInstance().getAPP();
        this.mListener = ComponentUtil.getInstance().buildListener(dGTaskWrapper.getRequestType(), this, this.mOutHandler);
    }

    public DownloadGroupEntity getEntity() {
        return (DownloadGroupEntity) ((DGTaskWrapper) this.mTaskWrapper).mo4442getEntity();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public String getTaskName() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("任务组->");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TextUtils.isEmpty(((DownloadGroupEntity) ((DGTaskWrapper) this.mTaskWrapper).mo4442getEntity()).getAlias()) ? ((DownloadGroupEntity) ((DGTaskWrapper) this.mTaskWrapper).mo4442getEntity()).getGroupHash() : ((DownloadGroupEntity) ((DGTaskWrapper) this.mTaskWrapper).mo4442getEntity()).getAlias());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public int getTaskType() {
        return 3;
    }
}
