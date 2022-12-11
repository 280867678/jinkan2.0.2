package com.arialyy.aria.core.task;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.arialyy.aria.core.inf.IUtil;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.ComponentUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AbsTask<TASK_WRAPPER extends AbsTaskWrapper> implements ITask<TASK_WRAPPER> {
    public static final String ERROR_INFO_KEY = "ERROR_INFO_KEY";
    public Context mContext;
    public IEventListener mListener;
    public Handler mOutHandler;
    public TASK_WRAPPER mTaskWrapper;
    public IUtil mUtil;
    public String TAG = CommonUtil.getClassName((Class) getClass());
    public boolean needRetry = true;
    public boolean isHeighestTask = false;
    public boolean isCancel = false;
    public boolean isStop = false;
    public Map<String, Object> mExpand = new HashMap();
    public int mSchedulerType = 1;

    @Override // com.arialyy.aria.core.task.ITask
    public void cancel() {
        cancel(1);
    }

    @Override // com.arialyy.aria.core.task.ITask
    public void cancel(int i) {
        IUtil util = getUtil();
        this.mUtil = util;
        if (util == null) {
            ALog.m4191e(this.TAG, "任务工具创建失败");
            return;
        }
        this.isCancel = true;
        this.mSchedulerType = i;
        getUtil().cancel();
    }

    public String getConvertCurrentProgress() {
        return this.mTaskWrapper.mo4442getEntity().getCurrentProgress() == 0 ? "0b" : CommonUtil.formatFileSize(this.mTaskWrapper.mo4442getEntity().getCurrentProgress());
    }

    public String getConvertFileSize() {
        return this.mTaskWrapper.mo4442getEntity().getFileSize() == 0 ? "0mb" : CommonUtil.formatFileSize(this.mTaskWrapper.mo4442getEntity().getFileSize());
    }

    public String getConvertSpeed() {
        return this.mTaskWrapper.mo4442getEntity().getConvertSpeed();
    }

    public String getConvertTimeLeft() {
        return CommonUtil.formatTime(getTaskWrapper().mo4442getEntity().getTimeLeft());
    }

    public long getCurrentProgress() {
        return this.mTaskWrapper.mo4442getEntity().getCurrentProgress();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public Object getExpand(String str) {
        return this.mExpand.get(str);
    }

    public String getExtendField() {
        if (this.mTaskWrapper.mo4442getEntity() == null) {
            return null;
        }
        return this.mTaskWrapper.mo4442getEntity().getStr();
    }

    public long getFileSize() {
        return this.mTaskWrapper.mo4442getEntity().getFileSize();
    }

    public Handler getOutHandler() {
        return this.mOutHandler;
    }

    public int getPercent() {
        return this.mTaskWrapper.mo4442getEntity().getPercent();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public int getSchedulerType() {
        return this.mSchedulerType;
    }

    public long getSpeed() {
        return this.mTaskWrapper.mo4442getEntity().getSpeed();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public int getState() {
        return this.mTaskWrapper.getState();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public TASK_WRAPPER getTaskWrapper() {
        return this.mTaskWrapper;
    }

    public int getTimeLeft() {
        return getTaskWrapper().mo4442getEntity().getTimeLeft();
    }

    public synchronized IUtil getUtil() {
        if (this.mUtil == null) {
            this.mUtil = ComponentUtil.getInstance().buildUtil(this.mTaskWrapper, this.mListener);
        }
        return this.mUtil;
    }

    @Override // com.arialyy.aria.core.task.ITask
    public boolean isCancel() {
        return this.isCancel;
    }

    public boolean isComplete() {
        return this.mTaskWrapper.mo4442getEntity().isComplete();
    }

    public boolean isHighestPriorityTask() {
        return this.isHeighestTask;
    }

    @Override // com.arialyy.aria.core.task.ITask
    public boolean isNeedRetry() {
        return this.needRetry;
    }

    @Override // com.arialyy.aria.core.task.ITask
    public boolean isRunning() {
        return getUtil().isRunning();
    }

    @Override // com.arialyy.aria.core.task.ITask
    public boolean isStop() {
        return this.isStop;
    }

    public void putExpand(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(this.TAG, "key 为空");
        } else if (obj == null) {
            ALog.m4189i(this.TAG, "扩展数据为空");
        } else {
            this.mExpand.put(str, obj);
        }
    }

    public void setHighestPriority(boolean z) {
        this.isHeighestTask = z;
    }

    public void setNeedRetry(boolean z) {
        this.needRetry = z;
    }

    @Override // com.arialyy.aria.core.task.ITask
    public void start() {
        start(1);
    }

    @Override // com.arialyy.aria.core.task.ITask
    public void start(int i) {
        this.mSchedulerType = i;
        IUtil util = getUtil();
        this.mUtil = util;
        if (util == null) {
            ALog.m4191e(this.TAG, "任务工具创建失败");
        } else if (i != 5) {
            if (getUtil().isRunning()) {
                ALog.m4192d(this.TAG, "任务正在下载");
            } else {
                getUtil().start();
            }
        } else if (getUtil().isRunning()) {
            ALog.m4191e(this.TAG, String.format("任务【%s】重启失败", getTaskName()));
        } else {
            this.mUtil.start();
            ALog.m4192d(this.TAG, String.format("任务【%s】重启成功", getTaskName()));
        }
    }

    @Override // com.arialyy.aria.core.task.ITask
    public void stop() {
        stop(1);
    }

    @Override // com.arialyy.aria.core.task.ITask
    public void stop(int i) {
        IUtil util = getUtil();
        this.mUtil = util;
        if (util == null) {
            ALog.m4191e(this.TAG, "任务工具创建失败");
            return;
        }
        this.isStop = true;
        this.mSchedulerType = i;
        getUtil().stop();
    }
}
