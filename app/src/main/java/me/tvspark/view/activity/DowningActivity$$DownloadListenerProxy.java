package me.tvspark.view.activity;

import com.arialyy.aria.core.scheduler.NormalTaskListener;
import com.arialyy.aria.core.task.DownloadTask;

/* loaded from: classes4.dex */
public final class DowningActivity$$DownloadListenerProxy extends NormalTaskListener<DownloadTask> {
    public DowningActivity obj;

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onPre(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask != null) {
                downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            }
            downloadTask.getTaskName();
            downloadTask.getState();
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskCancel(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask == null) {
                return;
            }
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskComplete(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask == null) {
                return;
            }
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskFail(DownloadTask downloadTask, Exception exc) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask == null) {
                return;
            }
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskResume(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            downloadTask.getTaskName();
            downloadTask.getState();
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskRunning(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask == null) {
                return;
            }
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskStart(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            downloadTask.getTaskName();
            downloadTask.getState();
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onTaskStop(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask == null) {
                return;
            }
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener
    public void onWait(DownloadTask downloadTask) {
        DowningActivity downingActivity = this.obj;
        if (downingActivity != null) {
            if (downloadTask == null) {
                return;
            }
            downingActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadTask.getEntity());
            return;
        }
        throw null;
    }

    @Override // com.arialyy.aria.core.scheduler.NormalTaskListener, com.arialyy.aria.core.scheduler.ISchedulerListener
    public void setListener(Object obj) {
        this.obj = (DowningActivity) obj;
    }
}
