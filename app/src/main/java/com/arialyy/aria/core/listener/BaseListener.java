package com.arialyy.aria.core.listener;

import android.os.Handler;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.ErrorHelp;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class BaseListener<ENTITY extends AbsEntity, TASK_WRAPPER extends AbsTaskWrapper<ENTITY>, TASK extends AbsTask<TASK_WRAPPER>> implements IEventListener {
    public static final int RUN_SAVE_INTERVAL = 5000;
    public static String TAG;
    public boolean isConvertSpeed;
    public ENTITY mEntity;
    public long mLastLen;
    public TASK mTask;
    public TASK_WRAPPER mTaskWrapper;
    public long mUpdateInterval;
    public SoftReference<Handler> outHandler;
    public boolean isFirst = true;
    public long mLastSaveTime = System.currentTimeMillis();

    public BaseListener(TASK task, Handler handler) {
        this.outHandler = new SoftReference<>(handler);
        TASK task2 = (TASK) new WeakReference(task).get();
        this.mTask = task2;
        this.mEntity = (ENTITY) task2.getTaskWrapper().mo4442getEntity();
        TASK_WRAPPER task_wrapper = (TASK_WRAPPER) this.mTask.getTaskWrapper();
        this.mTaskWrapper = task_wrapper;
        this.isConvertSpeed = task_wrapper.mo4438getConfig().isConvertSpeed();
        this.mUpdateInterval = this.mTaskWrapper.mo4438getConfig().getUpdateInterval();
        this.mLastLen = this.mEntity.getCurrentProgress();
        TAG = CommonUtil.getClassName((Class) getClass());
    }

    private void handleComplete() {
        this.mEntity.setComplete(true);
        this.mEntity.setCompleteTime(System.currentTimeMillis());
        ENTITY entity = this.mEntity;
        entity.setCurrentProgress(entity.getFileSize());
        this.mEntity.setPercent(100);
        handleSpeed(0L);
    }

    private void handleSpeed(long j) {
        long j2 = this.mUpdateInterval;
        if (j2 != 1000) {
            j = (j * 1000) / j2;
        }
        if (this.isConvertSpeed) {
            ENTITY entity = this.mEntity;
            StringBuilder sb = new StringBuilder();
            sb.append(CommonUtil.formatFileSize(j < 0 ? RoundRectDrawableWithShadow.COS_45 : j));
            sb.append("/s");
            entity.setConvertSpeed(sb.toString());
        }
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        this.mEntity.setSpeed(i < 0 ? 0L : j);
        int requestType = this.mTaskWrapper.getRequestType();
        if (requestType != 7 && requestType != 8) {
            ENTITY entity2 = this.mEntity;
            entity2.setPercent((int) (entity2.getFileSize() <= 0 ? 0L : (this.mEntity.getCurrentProgress() * 100) / this.mEntity.getFileSize()));
        }
        if (this.mEntity.getFileSize() != 0) {
            if (i == 0) {
                this.mEntity.setTimeLeft(Integer.MAX_VALUE);
                return;
            }
            ENTITY entity3 = this.mEntity;
            entity3.setTimeLeft((int) ((entity3.getFileSize() - this.mEntity.getCurrentProgress()) / j));
        }
    }

    public TASK getTask() {
        return this.mTask;
    }

    public abstract void handleCancel();

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onCancel() {
        saveData(7, -1L);
        handleSpeed(0L);
        if (this.mTask.getSchedulerType() != 4) {
            ALog.m4192d(TAG, "删除任务完成");
            sendInState2Target(5);
        }
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onComplete() {
        saveData(1, this.mEntity.getFileSize());
        handleSpeed(0L);
        sendInState2Target(6);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onFail(boolean z, AriaException ariaException) {
        ENTITY entity = this.mEntity;
        entity.setFailNum(entity.getFailNum() + 1);
        saveData(0, this.mEntity.getCurrentProgress());
        handleSpeed(0L);
        this.mTask.setNeedRetry(z);
        this.mTask.putExpand(AbsTask.ERROR_INFO_KEY, ariaException);
        sendInState2Target(4);
        if (ariaException != null) {
            String exceptionString = ALog.getExceptionString(ariaException);
            ALog.m4191e(TAG, exceptionString);
            ErrorHelp.saveError(ariaException.getTag(), ariaException.getMessage(), exceptionString);
        }
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onPre() {
        saveData(5, -1L);
        sendInState2Target(0);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onProgress(long j) {
        this.mEntity.setCurrentProgress(j);
        long j2 = j - this.mLastLen;
        if (this.isFirst) {
            j2 = 0;
            this.isFirst = false;
        }
        handleSpeed(j2);
        sendInState2Target(7);
        if (System.currentTimeMillis() - this.mLastSaveTime >= 5000) {
            saveData(4, j);
            this.mLastSaveTime = System.currentTimeMillis();
        }
        this.mLastLen = j;
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onResume(long j) {
        saveData(4, j);
        sendInState2Target(8);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onStart(long j) {
        saveData(4, j);
        sendInState2Target(2);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onStop(long j) {
        saveData(this.mTask.getSchedulerType() == 3 ? 3 : 2, j);
        handleSpeed(0L);
        sendInState2Target(3);
    }

    public void saveData(int i, long j) {
        this.mEntity.setState(i);
        if (i == 7) {
            handleCancel();
            return;
        }
        if (i == 2) {
            this.mEntity.setStopTime(System.currentTimeMillis());
        } else if (i == 1) {
            handleComplete();
        }
        if (j > 0) {
            this.mEntity.setCurrentProgress(j);
        }
        this.mEntity.update();
    }

    public void sendInState2Target(int i) {
        if (this.outHandler.get() != null) {
            this.outHandler.get().obtainMessage(i, this.mTask).sendToTarget();
        }
    }
}
