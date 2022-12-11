package com.arialyy.aria.core.command;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.common.QueueMod;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.NetUtils;

/* loaded from: classes3.dex */
public final class StartCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public boolean nowStart = false;

    public StartCmd(T t, int i) {
        super(t, i);
    }

    private void findAllWaitTask() {
        new Thread(new ResumeThread(this.isDownloadCmd, String.format("state=%s", 3))).start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a6, code lost:
        if (r8.nowStart != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
        sendWaitState(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d0, code lost:
        if (r8.nowStart != false) goto L41;
     */
    @Override // com.arialyy.aria.core.command.ICmd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void executeCmd() {
        String str;
        String format;
        if (!this.canExeCmd) {
            return;
        }
        if (!NetUtils.isConnected(AriaConfig.getInstance().getAPP())) {
            ALog.m4191e(this.TAG, "启动任务失败，网络未连接");
            return;
        }
        int maxTaskNum = this.mQueue.getMaxTaskNum();
        AriaConfig ariaConfig = AriaConfig.getInstance();
        String queueMod = (this.isDownloadCmd ? ariaConfig.getDConfig() : ariaConfig.getUConfig()).getQueueMod();
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
            if (!queueMod.equals(QueueMod.NOW.getTag())) {
                if (queueMod.equals(QueueMod.WAIT.getTag())) {
                    int state = task.getState();
                    if (this.mQueue.getCurrentExePoolNum() < maxTaskNum) {
                        if (state != 2 && state != 0 && state != -1 && state != 5 && state != 6 && state != 1) {
                            if (state == 4) {
                                str = this.TAG;
                                format = String.format("任务【%s】已经在运行", task.getTaskName());
                                ALog.m4185w(str, format);
                            } else {
                                ALog.m4192d(this.TAG, String.format("开始新任务, 任务状态：%s", Integer.valueOf(state)));
                            }
                        }
                        resumeTask();
                    }
                }
            }
            startTask();
        } else if (!this.mQueue.taskIsRunning(task.getKey())) {
            if (!queueMod.equals(QueueMod.NOW.getTag())) {
                if (this.mQueue.getCurrentExePoolNum() >= maxTaskNum) {
                }
            }
            resumeTask();
        } else {
            str = this.TAG;
            format = String.format("任务【%s】已经在运行", task.getTaskName());
            ALog.m4185w(str, format);
        }
        if (this.mQueue.getCurrentCachePoolNum() != 0) {
            return;
        }
        findAllWaitTask();
    }

    public void setNowStart(boolean z) {
        this.nowStart = z;
    }
}
