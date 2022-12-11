package me.tvspark.view.activity;

import com.arialyy.aria.core.scheduler.NormalTaskListener;
import com.arialyy.aria.core.task.DownloadTask;

/* loaded from: classes4.dex */
public final class AllDownParentActivity$$DownloadListenerProxy extends NormalTaskListener<DownloadTask> {
    public AllDownParentActivity obj;

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskComplete(DownloadTask downloadTask) {
        this.obj.Wwwwwwwwwwwwww();
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener, com.arialyy.aria.core.scheduler.ISchedulerListener
    public void setListener(Object obj) {
        this.obj = (AllDownParentActivity) obj;
    }
}
