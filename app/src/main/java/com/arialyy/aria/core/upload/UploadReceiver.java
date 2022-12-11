package com.arialyy.aria.core.upload;

import android.text.TextUtils;
import com.arialyy.annotations.TaskEnum;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.AriaManager;
import com.arialyy.aria.core.command.CancelAllCmd;
import com.arialyy.aria.core.command.CmdHelper;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.common.ProxyHelper;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.inf.AbsReceiver;
import com.arialyy.aria.core.inf.ReceiverType;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.upload.target.FtpBuilderTarget;
import com.arialyy.aria.core.upload.target.FtpNormalTarget;
import com.arialyy.aria.core.upload.target.HttpBuilderTarget;
import com.arialyy.aria.core.upload.target.HttpNormalTarget;
import com.arialyy.aria.core.upload.target.UTargetFactory;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.ComponentUtil;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class UploadReceiver extends AbsReceiver {
    public static final String TAG = "UploadReceiver";

    public List<UploadEntity> getAllCompleteTask() {
        return DbEntity.findDatas(UploadEntity.class, "isGroupChild=? and isComplete=?", "false", "true");
    }

    public List<UploadEntity> getAllCompleteTask(int i, int i2) {
        CheckUtil.checkPageParams(i, i2);
        return DbEntity.findDatas(UploadEntity.class, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "true");
    }

    public List<UploadEntity> getAllNotCompleteTask() {
        return DbEntity.findDatas(UploadEntity.class, "isGroupChild=? and isComplete=?", "false", "false");
    }

    public List<UploadEntity> getAllNotCompleteTask(int i, int i2) {
        CheckUtil.checkPageParams(i, i2);
        return DbEntity.findDatas(UploadEntity.class, i, i2, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "false");
    }

    public UploadEntity getFirstUploadEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (UploadEntity) DbEntity.findFirst(UploadEntity.class, "filePath=?", str);
    }

    public List<UploadEntity> getTaskList() {
        return DbEntity.findAllData(UploadEntity.class);
    }

    public List<UploadEntity> getTaskList(int i, int i2) {
        CheckUtil.checkPageParams(i, i2);
        return DbEntity.findDatas(UploadEntity.class, i, i2, "isGroupChild=? and downloadPath!=''", "false");
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public String getType() {
        return ReceiverType.UPLOAD;
    }

    public List<UploadEntity> getURunningTask() {
        return UTaskQueue.getInstance().getRunningTask(UploadEntity.class);
    }

    public UploadEntity getUploadEntity(long j) {
        if (j == -1) {
            return null;
        }
        return (UploadEntity) DbEntity.findFirst(UploadEntity.class, "rowid=?", String.valueOf(j));
    }

    public List<UploadEntity> getUploadEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return DbEntity.findDatas(UploadEntity.class, "filePath=?", str);
    }

    public HttpBuilderTarget load(String str) {
        ComponentUtil.getInstance().checkComponentExist(1);
        CheckUtil.checkUploadPathIsEmpty(str);
        return (HttpBuilderTarget) UTargetFactory.getInstance().generateBuilderTarget(HttpBuilderTarget.class, str);
    }

    public HttpNormalTarget load(long j) {
        ComponentUtil.getInstance().checkComponentExist(1);
        return (HttpNormalTarget) UTargetFactory.getInstance().generateNormalTarget(HttpNormalTarget.class, j);
    }

    public FtpBuilderTarget loadFtp(String str) {
        ComponentUtil.getInstance().checkComponentExist(2);
        CheckUtil.checkUploadPathIsEmpty(str);
        return (FtpBuilderTarget) UTargetFactory.getInstance().generateBuilderTarget(FtpBuilderTarget.class, str);
    }

    public FtpNormalTarget loadFtp(long j) {
        ComponentUtil.getInstance().checkComponentExist(2);
        return (FtpNormalTarget) UTargetFactory.getInstance().generateNormalTarget(FtpNormalTarget.class, j);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public void register() {
        Object obj = AbsReceiver.OBJ_MAP.get(getKey());
        if (obj == null) {
            ALog.m4191e(TAG, String.format("【%s】观察者为空", getTargetName()));
            return;
        }
        Set<Integer> checkProxyType = ProxyHelper.getInstance().checkProxyType(obj.getClass());
        if (checkProxyType == null || checkProxyType.isEmpty()) {
            ALog.m4191e(TAG, "没有Aria的注解方法，详情见：https://aria.laoyuyu.me/aria_doc/other/annotaion_invalid.html");
            return;
        }
        for (Integer num : checkProxyType) {
            if (num.intValue() == ProxyHelper.PROXY_TYPE_UPLOAD) {
                TaskSchedulers.getInstance().register(obj, TaskEnum.UPLOAD);
            }
        }
    }

    public void removeAllTask(boolean z) {
        AriaManager ariaManager = AriaManager.getInstance();
        CancelAllCmd cancelAllCmd = (CancelAllCmd) CmdHelper.createNormalCmd(new UTaskWrapper(null), NormalCmdFactory.TASK_CANCEL_ALL, 2);
        cancelAllCmd.removeFile = z;
        EventMsgUtil.getDefault().post(cancelAllCmd);
        for (String str : ariaManager.getReceiver().keySet()) {
            ariaManager.getReceiver().remove(str);
        }
    }

    @Deprecated
    public UploadReceiver setMaxSpeed(int i) {
        AriaConfig.getInstance().getUConfig().mo4410setMaxSpeed(i);
        return this;
    }

    public void stopAllTask() {
        EventMsgUtil.getDefault().post(NormalCmdFactory.getInstance().createCmd((AbsTaskWrapper) new UTaskWrapper(null), 183, 2));
    }

    public boolean taskExists(String str) {
        return DbEntity.checkDataExist(UTaskWrapper.class, "key=?", str);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public void unRegister() {
        if (this.needRmListener) {
            unRegisterListener();
        }
        AriaManager.getInstance().removeReceiver(AbsReceiver.OBJ_MAP.get(getKey()));
    }

    @Override // com.arialyy.aria.core.inf.AbsReceiver
    public void unRegisterListener() {
        Object obj = AbsReceiver.OBJ_MAP.get(getKey());
        if (obj == null) {
            ALog.m4191e(TAG, String.format("【%s】观察者为空", getTargetName()));
            return;
        }
        Set<Integer> set = ProxyHelper.getInstance().mProxyCache.get(obj.getClass().getName());
        if (set == null) {
            return;
        }
        for (Integer num : set) {
            if (num.intValue() == ProxyHelper.PROXY_TYPE_UPLOAD) {
                TaskSchedulers.getInstance().unRegister(obj);
            }
        }
    }
}
