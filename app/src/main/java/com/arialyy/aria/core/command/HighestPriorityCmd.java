package com.arialyy.aria.core.command;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.task.DownloadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.NetUtils;

/* loaded from: classes3.dex */
public final class HighestPriorityCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public HighestPriorityCmd(T t, int i) {
        super(t, i);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (!this.canExeCmd) {
            return;
        }
        if (!NetUtils.isConnected(AriaConfig.getInstance().getAPP())) {
            ALog.m4191e(this.TAG, "启动任务失败，网络未连接");
            return;
        }
        DownloadTask downloadTask = (DownloadTask) getTask();
        if (downloadTask == null) {
            downloadTask = (DownloadTask) createTask();
        }
        if (downloadTask == null) {
            return;
        }
        ((DTaskQueue) this.mQueue).setTaskHighestPriority(downloadTask);
    }
}
