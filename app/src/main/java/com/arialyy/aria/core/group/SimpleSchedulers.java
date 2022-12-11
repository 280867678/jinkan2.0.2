package com.arialyy.aria.core.group;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.NetUtils;
import java.io.File;

/* loaded from: classes3.dex */
public final class SimpleSchedulers implements Handler.Callback {
    public final String TAG = CommonUtil.getClassName(this);
    public GroupRunState mGState;
    public String mKey;
    public SimpleSubQueue mQueue;

    public SimpleSchedulers(GroupRunState groupRunState, String str) {
        this.mQueue = groupRunState.queue;
        this.mGState = groupRunState;
        this.mKey = str;
    }

    private synchronized void handleComplete(AbsSubDLoadUtil absSubDLoadUtil) {
        ALog.m4192d(this.TAG, String.format("子任务【%s】完成", absSubDLoadUtil.getEntity().getFileName()));
        if (absSubDLoadUtil.getRecord().isBlock) {
            new File(String.format(IRecordHandler.SUB_PATH, absSubDLoadUtil.getRecord().filePath, 0)).renameTo(new File(absSubDLoadUtil.getRecord().filePath));
        }
        ThreadTaskManager.getInstance().removeTaskThread(absSubDLoadUtil.getKey());
        this.mGState.listener.onSubComplete(absSubDLoadUtil.getEntity());
        this.mQueue.removeTaskFromExecQ(absSubDLoadUtil);
        this.mGState.updateCompleteNum();
        ALog.m4192d(this.TAG, String.format("总任务数：%s，完成的任务数：%s，失败的任务数：%s，停止的任务数：%s", Integer.valueOf(this.mGState.getSubSize()), Integer.valueOf(this.mGState.getCompleteNum()), Integer.valueOf(this.mGState.getFailNum()), Integer.valueOf(this.mGState.getStopNum())));
        if (this.mGState.getCompleteNum() + this.mGState.getFailNum() + this.mGState.getStopNum() == this.mGState.getSubSize()) {
            if (this.mGState.getStopNum() == 0 && this.mGState.getFailNum() == 0) {
                this.mGState.listener.onComplete();
            } else if (this.mGState.getStopNum() != 0 || Configuration.getInstance().dGroupCfg.isSubFailAsStop()) {
                this.mGState.listener.onStop(this.mGState.getProgress());
            } else {
                this.mGState.listener.onFail(false, new AriaException(this.TAG, String.format("任务组【%s】下载失败", this.mGState.getGroupHash())));
            }
            this.mQueue.clear();
            this.mGState.isRunning.set(false);
        } else {
            startNext();
        }
    }

    private synchronized void handleFail(AbsSubDLoadUtil absSubDLoadUtil, boolean z) {
        Configuration configuration = Configuration.getInstance();
        int subReTryNum = configuration.dGroupCfg.getSubReTryNum();
        boolean isNotNetRetry = configuration.appCfg.isNotNetRetry();
        if (z && ((NetUtils.isConnected(AriaConfig.getInstance().getAPP()) || isNotNetRetry) && absSubDLoadUtil.getLoader() != null && absSubDLoadUtil.getEntity().getFailNum() <= subReTryNum)) {
            SimpleSubRetryQueue.getInstance().offer(absSubDLoadUtil);
            return;
        }
        this.mQueue.removeTaskFromExecQ(absSubDLoadUtil);
        this.mGState.listener.onSubFail(absSubDLoadUtil.getEntity(), new AriaException(this.TAG, String.format("任务组子任务【%s】下载失败，下载地址【%s】", absSubDLoadUtil.getEntity().getFileName(), absSubDLoadUtil.getEntity().getUrl())));
        this.mGState.countFailNum(absSubDLoadUtil.getKey());
        if (this.mGState.getFailNum() != this.mGState.getSubSize() && this.mGState.getStopNum() + this.mGState.getFailNum() + this.mGState.getCompleteNum() != this.mGState.getSubSize()) {
            startNext();
        }
        this.mQueue.clear();
        this.mGState.isRunning.set(false);
        if (this.mGState.getCompleteNum() <= 0 || !Configuration.getInstance().dGroupCfg.isSubFailAsStop()) {
            this.mGState.listener.onFail(false, new AriaException(this.TAG, String.format("任务组【%s】下载失败", this.mGState.getGroupHash())));
        } else {
            ALog.m4191e(this.TAG, String.format("任务组【%s】停止", this.mGState.getGroupHash()));
            this.mGState.listener.onStop(this.mGState.getProgress());
        }
    }

    private synchronized void handleStop(AbsSubDLoadUtil absSubDLoadUtil, long j) {
        this.mGState.listener.onSubStop(absSubDLoadUtil.getEntity(), j);
        this.mGState.countStopNum(absSubDLoadUtil.getKey());
        if (this.mGState.getStopNum() != this.mGState.getSubSize() && this.mGState.getStopNum() + this.mGState.getCompleteNum() + this.mGState.getFailNum() + this.mQueue.getCacheSize() != this.mGState.getSubSize()) {
            startNext();
        }
        this.mQueue.clear();
        this.mGState.isRunning.set(false);
        this.mGState.listener.onStop(this.mGState.getProgress());
    }

    public static SimpleSchedulers newInstance(GroupRunState groupRunState, String str) {
        return new SimpleSchedulers(groupRunState, str);
    }

    private void startNext() {
        if (this.mQueue.isStopAll()) {
            return;
        }
        AbsSubDLoadUtil mo4428getNextTask = this.mQueue.mo4428getNextTask();
        if (mo4428getNextTask == null) {
            ALog.m4189i(this.TAG, "没有下一子任务");
            return;
        }
        ALog.m4192d(this.TAG, String.format("启动任务：%s", mo4428getNextTask.getEntity().getFileName()));
        this.mQueue.startTask(mo4428getNextTask);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            ALog.m4185w(this.TAG, "组合任务子任务调度数据为空");
            return true;
        }
        String string = data.getString(IThreadStateManager.DATA_THREAD_NAME);
        AbsSubDLoadUtil loaderUtil = this.mQueue.getLoaderUtil(string);
        if (loaderUtil == null) {
            ALog.m4191e(this.TAG, String.format("子任务loader不存在，state：%s，key：%s", Integer.valueOf(message.what), string));
            return true;
        }
        long j = data.getLong(IThreadStateManager.DATA_THREAD_LOCATION, loaderUtil.getLoader().getWrapper().mo4442getEntity().getCurrentProgress());
        int i = message.what;
        if (i == 1) {
            handleStop(loaderUtil, j);
        } else if (i == 2) {
            handleFail(loaderUtil, data.getBoolean(IThreadStateManager.DATA_RETRY, false));
        } else if (i != 4) {
            if (i == 5) {
                this.mGState.listener.onSubRunning(loaderUtil.getEntity(), ((Long) message.obj).longValue());
            } else if (i == 7) {
                this.mGState.listener.onSubPre(loaderUtil.getEntity());
                this.mGState.updateCount(loaderUtil.getKey());
            } else if (i == 8) {
                this.mGState.listener.onSubStart(loaderUtil.getEntity());
            }
            return true;
        } else {
            handleComplete(loaderUtil);
        }
        ThreadTaskManager.getInstance().removeSingleTaskThread(this.mKey, string);
        return true;
    }
}
