package com.arialyy.aria.core.download;

import com.arialyy.annotations.TaskEnum;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.AriaManager;
import com.arialyy.aria.core.command.CancelAllCmd;
import com.arialyy.aria.core.command.CmdHelper;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.ProxyHelper;
import com.arialyy.aria.core.download.target.DTargetFactory;
import com.arialyy.aria.core.download.target.FtpBuilderTarget;
import com.arialyy.aria.core.download.target.FtpDirBuilderTarget;
import com.arialyy.aria.core.download.target.FtpDirNormalTarget;
import com.arialyy.aria.core.download.target.FtpNormalTarget;
import com.arialyy.aria.core.download.target.GroupBuilderTarget;
import com.arialyy.aria.core.download.target.GroupNormalTarget;
import com.arialyy.aria.core.download.target.HttpBuilderTarget;
import com.arialyy.aria.core.download.target.HttpNormalTarget;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.inf.AbsReceiver;
import com.arialyy.aria.core.inf.ReceiverType;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.ComponentUtil;
import com.arialyy.aria.util.DbDataHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class DownloadReceiver extends AbsReceiver {
    public final String TAG = "DownloadReceiver";

    public List<DownloadEntity> getAllCompleteTask() {
        return DbEntity.findDatas(DownloadEntity.class, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "true");
    }

    public List<DownloadEntity> getAllCompleteTask(int i, int i2) {
        CheckUtil.checkPageParams(i, i2);
        return DbEntity.findDatas(DownloadEntity.class, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "true");
    }

    public List<DownloadEntity> getAllNotCompleteTask() {
        return DbEntity.findDatas(DownloadEntity.class, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "false");
    }

    public List<DownloadEntity> getAllNotCompleteTask(int i, int i2) {
        CheckUtil.checkPageParams(i, i2);
        return DbEntity.findDatas(DownloadEntity.class, i, i2, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "false");
    }

    public List<DownloadGroupEntity> getDGRunningTask() {
        return DGroupTaskQueue.getInstance().getRunningTask(DownloadGroupEntity.class);
    }

    public List<DownloadEntity> getDRunningTask() {
        return DTaskQueue.getInstance().getRunningTask(DownloadEntity.class);
    }

    public DownloadEntity getDownloadEntity(long j) {
        if (j < 0) {
            ALog.m4191e("DownloadReceiver", "taskId错误");
            return null;
        }
        return (DownloadEntity) DbEntity.findFirst(DownloadEntity.class, "rowid=?", String.valueOf(j));
    }

    public List<DownloadEntity> getDownloadEntity(String str) {
        if (!CheckUtil.checkUrl(str)) {
            return null;
        }
        return DbEntity.findDatas(DownloadEntity.class, "url=? and isGroupChild='false'", str);
    }

    public DownloadEntity getFirstDownloadEntity(String str) {
        if (!CheckUtil.checkUrl(str)) {
            return null;
        }
        return (DownloadEntity) DbEntity.findFirst(DownloadEntity.class, "url=? and isGroupChild='false'", str);
    }

    public DownloadGroupEntity getFtpDirEntity(String str) {
        if (!CheckUtil.checkUrl(str)) {
            return null;
        }
        return DbDataHelper.getDGEntityByHash(str);
    }

    public DownloadGroupEntity getGroupEntity(long j) {
        if (j < 0) {
            ALog.m4191e("DownloadReceiver", "任务Id错误");
        }
        return DbDataHelper.getDGEntity(j);
    }

    public DownloadGroupEntity getGroupEntity(List<String> list) {
        if (CheckUtil.checkDownloadUrlsIsEmpty(list)) {
            return null;
        }
        return DbDataHelper.getDGEntityByHash(CommonUtil.getMd5Code(list));
    }

    public List<DownloadGroupEntity> getGroupTaskList() {
        return getGroupTaskList(1, 10);
    }

    public List<DownloadGroupEntity> getGroupTaskList(int i, int i2) {
        List<DGEntityWrapper> findRelationData = DbEntity.findRelationData(DGEntityWrapper.class, i, i2, new String[0]);
        if (findRelationData == null || findRelationData.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DGEntityWrapper dGEntityWrapper : findRelationData) {
            arrayList.add(dGEntityWrapper.groupEntity);
        }
        return arrayList;
    }

    public List<DownloadEntity> getTaskList() {
        return DbEntity.findDatas(DownloadEntity.class, "isGroupChild=? and downloadPath!=''", "false");
    }

    public List<DownloadEntity> getTaskList(int i, int i2) {
        CheckUtil.checkPageParams(i, i2);
        return DbEntity.findDatas(DownloadEntity.class, i, i2, "isGroupChild=? and downloadPath!=''", "false");
    }

    public List<AbsEntity> getTotalTaskList() {
        ArrayList arrayList = new ArrayList();
        List<DownloadEntity> taskList = getTaskList();
        List<DownloadGroupEntity> groupTaskList = getGroupTaskList();
        if (taskList != null && !taskList.isEmpty()) {
            arrayList.addAll(taskList);
        }
        if (groupTaskList != null && !groupTaskList.isEmpty()) {
            arrayList.addAll(groupTaskList);
        }
        return arrayList;
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public String getType() {
        return ReceiverType.DOWNLOAD;
    }

    public HttpBuilderTarget load(String str) {
        ComponentUtil.getInstance().checkComponentExist(1);
        return (HttpBuilderTarget) DTargetFactory.getInstance().generateBuilderTarget(HttpBuilderTarget.class, str);
    }

    public HttpNormalTarget load(long j) {
        ComponentUtil.getInstance().checkComponentExist(1);
        return (HttpNormalTarget) DTargetFactory.getInstance().generateNormalTarget(HttpNormalTarget.class, j);
    }

    public FtpBuilderTarget loadFtp(String str) {
        ComponentUtil.getInstance().checkComponentExist(2);
        return (FtpBuilderTarget) DTargetFactory.getInstance().generateBuilderTarget(FtpBuilderTarget.class, str);
    }

    public FtpNormalTarget loadFtp(long j) {
        ComponentUtil.getInstance().checkComponentExist(2);
        return (FtpNormalTarget) DTargetFactory.getInstance().generateNormalTarget(FtpNormalTarget.class, j);
    }

    public FtpDirBuilderTarget loadFtpDir(String str) {
        ComponentUtil.getInstance().checkComponentExist(2);
        return DTargetFactory.getInstance().generateDirBuilderTarget(str);
    }

    public FtpDirNormalTarget loadFtpDir(long j) {
        ComponentUtil.getInstance().checkComponentExist(2);
        return (FtpDirNormalTarget) DTargetFactory.getInstance().generateNormalTarget(FtpDirNormalTarget.class, j);
    }

    public GroupBuilderTarget loadGroup(List<String> list) {
        ComponentUtil.getInstance().checkComponentExist(1);
        return DTargetFactory.getInstance().generateGroupBuilderTarget(list);
    }

    public GroupNormalTarget loadGroup(long j) {
        ComponentUtil.getInstance().checkComponentExist(1);
        return (GroupNormalTarget) DTargetFactory.getInstance().generateNormalTarget(GroupNormalTarget.class, j);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public void register() {
        TaskSchedulers taskSchedulers;
        TaskEnum taskEnum;
        Object obj = AbsReceiver.OBJ_MAP.get(getKey());
        if (obj == null) {
            ALog.m4191e("DownloadReceiver", String.format("【%s】观察者为空", getTargetName()));
            return;
        }
        Set<Integer> checkProxyType = ProxyHelper.getInstance().checkProxyType(obj.getClass());
        if (checkProxyType == null || checkProxyType.isEmpty()) {
            ALog.m4191e("DownloadReceiver", "没有Aria的注解方法，详情见：https://aria.laoyuyu.me/aria_doc/other/annotaion_invalid.html");
            return;
        }
        for (Integer num : checkProxyType) {
            if (num.intValue() == ProxyHelper.PROXY_TYPE_DOWNLOAD) {
                taskSchedulers = TaskSchedulers.getInstance();
                taskEnum = TaskEnum.DOWNLOAD;
            } else if (num.intValue() == ProxyHelper.PROXY_TYPE_DOWNLOAD_GROUP) {
                taskSchedulers = TaskSchedulers.getInstance();
                taskEnum = TaskEnum.DOWNLOAD_GROUP;
            } else if (num.intValue() == ProxyHelper.PROXY_TYPE_M3U8_PEER) {
                taskSchedulers = TaskSchedulers.getInstance();
                taskEnum = TaskEnum.M3U8_PEER;
            } else if (num.intValue() == ProxyHelper.PROXY_TYPE_DOWNLOAD_GROUP_SUB) {
                taskSchedulers = TaskSchedulers.getInstance();
                taskEnum = TaskEnum.DOWNLOAD_GROUP_SUB;
            }
            taskSchedulers.register(obj, taskEnum);
        }
    }

    public void removeAllTask(boolean z) {
        AriaManager ariaManager = AriaManager.getInstance();
        CancelAllCmd cancelAllCmd = (CancelAllCmd) CmdHelper.createNormalCmd(new DTaskWrapper(null), NormalCmdFactory.TASK_CANCEL_ALL, 1);
        cancelAllCmd.removeFile = z;
        EventMsgUtil.getDefault().post(cancelAllCmd);
        for (String str : ariaManager.getReceiver().keySet()) {
            ariaManager.getReceiver().remove(str);
        }
    }

    public void resumeAllTask() {
        EventMsgUtil.getDefault().post(NormalCmdFactory.getInstance().createCmd((AbsTaskWrapper) new DTaskWrapper(null), 184, 1));
    }

    @Deprecated
    public DownloadReceiver setMaxSpeed(int i) {
        AriaConfig.getInstance().getDConfig().mo4410setMaxSpeed(i);
        return this;
    }

    public void stopAllTask() {
        EventMsgUtil.getDefault().post(NormalCmdFactory.getInstance().createCmd((AbsTaskWrapper) new DTaskWrapper(null), 183, 1));
    }

    public boolean taskExists(String str) {
        return DbEntity.checkDataExist(DownloadEntity.class, "url=?", str);
    }

    public boolean taskExists(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return DbEntity.checkDataExist(DownloadGroupEntity.class, "groupHash=?", CommonUtil.getMd5Code(list));
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
            ALog.m4191e("DownloadReceiver", String.format("【%s】观察者为空", getTargetName()));
            return;
        }
        Set<Integer> set = ProxyHelper.getInstance().mProxyCache.get(obj.getClass().getName());
        if (set == null) {
            return;
        }
        for (Integer num : set) {
            if (num.intValue() == ProxyHelper.PROXY_TYPE_DOWNLOAD || num.intValue() == ProxyHelper.PROXY_TYPE_DOWNLOAD_GROUP) {
                TaskSchedulers.getInstance().unRegister(obj);
            }
        }
    }
}
