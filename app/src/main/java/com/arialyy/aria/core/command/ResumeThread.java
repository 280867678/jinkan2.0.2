package com.arialyy.aria.core.command;

import android.text.TextUtils;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.AbsTaskQueue;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ResumeThread implements Runnable {
    public boolean isDownloadCmd;
    public String sqlCondition;
    public String TAG = CommonUtil.getClassName(ResumeThread.class);
    public List<AbsTaskWrapper> mWaitList = new ArrayList();

    public ResumeThread(boolean z, String str) {
        this.isDownloadCmd = z;
        this.sqlCondition = str;
    }

    private void addResumeEntity(AbsTaskWrapper absTaskWrapper) {
        if (absTaskWrapper == null || absTaskWrapper.mo4442getEntity() == null || TextUtils.isEmpty(absTaskWrapper.getKey())) {
            return;
        }
        this.mWaitList.add(absTaskWrapper);
    }

    private void findTaskData(int i) {
        List<UploadEntity> findDatas;
        if (i == 1) {
            List<DownloadEntity> findDatas2 = DbEntity.findDatas(DownloadEntity.class, String.format("NOT(isGroupChild) AND NOT(isComplete) AND %s ORDER BY stopTime DESC", this.sqlCondition));
            if (findDatas2 == null || findDatas2.isEmpty()) {
                return;
            }
            for (DownloadEntity downloadEntity : findDatas2) {
                addResumeEntity(TaskWrapperManager.getInstance().getNormalTaskWrapper(DTaskWrapper.class, downloadEntity.getId()));
            }
        } else if (i == 2) {
            List<DownloadGroupEntity> findDatas3 = DbEntity.findDatas(DownloadGroupEntity.class, String.format("NOT(isComplete) AND %s ORDER BY stopTime DESC", this.sqlCondition));
            if (findDatas3 == null || findDatas3.isEmpty()) {
                return;
            }
            for (DownloadGroupEntity downloadGroupEntity : findDatas3) {
                addResumeEntity(TaskWrapperManager.getInstance().getGroupWrapper(DGTaskWrapper.class, downloadGroupEntity.getId()));
            }
        } else if (i == 3 && (findDatas = DbEntity.findDatas(UploadEntity.class, String.format("NOT(isComplete) AND %s ORDER BY stopTime DESC", this.sqlCondition))) != null && !findDatas.isEmpty()) {
            for (UploadEntity uploadEntity : findDatas) {
                addResumeEntity(TaskWrapperManager.getInstance().getNormalTaskWrapper(UTaskWrapper.class, uploadEntity.getId()));
            }
        }
    }

    private void handleWrapper(AbsTaskWrapper absTaskWrapper) {
        int requestType = absTaskWrapper.getRequestType();
        if (requestType == 3 || requestType == 6 || requestType == 4) {
            absTaskWrapper.getOptionParams().setParams(IOptionConstant.ftpUrlEntity, CommonUtil.getFtpUrlInfo(absTaskWrapper.mo4442getEntity().getKey()));
        }
    }

    private void resumeWaitTask() {
        String str;
        String str2;
        List<AbsTaskWrapper> list = this.mWaitList;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AbsTaskWrapper absTaskWrapper : this.mWaitList) {
            AbsTaskQueue absTaskQueue = null;
            if (absTaskWrapper instanceof DTaskWrapper) {
                absTaskQueue = DTaskQueue.getInstance();
            } else if (absTaskWrapper instanceof UTaskWrapper) {
                absTaskQueue = UTaskQueue.getInstance();
            } else if (absTaskWrapper instanceof DGTaskWrapper) {
                absTaskQueue = DGroupTaskQueue.getInstance();
            }
            if (absTaskQueue == null) {
                str = this.TAG;
                str2 = "任务类型错误";
            } else if (absTaskWrapper.mo4442getEntity() == null || TextUtils.isEmpty(absTaskWrapper.getKey())) {
                str = this.TAG;
                str2 = "任务实体为空或key为空";
            } else if (absTaskQueue.mo4434getTask(absTaskWrapper.getKey()) != null) {
                ALog.m4185w(this.TAG, "任务已存在");
            } else {
                int maxTaskNum = absTaskQueue.getMaxTaskNum();
                AbsTask mo4437createTask = absTaskQueue.mo4437createTask((AbsTaskQueue) absTaskWrapper);
                if (mo4437createTask != null) {
                    handleWrapper(absTaskWrapper);
                    if (absTaskQueue.getCurrentExePoolNum() < maxTaskNum) {
                        absTaskQueue.startTask((AbsTaskQueue) mo4437createTask);
                    } else {
                        absTaskWrapper.mo4442getEntity().setState(3);
                        sendWaitState(mo4437createTask);
                        arrayList.add(absTaskWrapper.mo4442getEntity());
                    }
                }
            }
            ALog.m4191e(str, str2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        DbEntity.updateManyData(arrayList);
    }

    private void sendWaitState(AbsTask absTask) {
        if (absTask != null) {
            absTask.getTaskWrapper().setState(3);
            absTask.getOutHandler().obtainMessage(10, absTask).sendToTarget();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.isDownloadCmd) {
            findTaskData(1);
            i = 2;
        } else {
            i = 3;
        }
        findTaskData(i);
        resumeWaitTask();
    }
}
