package com.arialyy.aria.core.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.arialyy.annotations.TaskEnum;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.group.GroupSendParams;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.ITaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.task.DownloadGroupTask;
import com.arialyy.aria.core.task.DownloadTask;
import com.arialyy.aria.core.task.ITask;
import com.arialyy.aria.core.task.UploadTask;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.NetUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class TaskSchedulers<TASK extends ITask> implements ISchedulers {
    public static volatile TaskSchedulers INSTANCE;
    public static FailureTaskHandler mFailureTaskHandler;
    public final String TAG = CommonUtil.getClassName(TaskSchedulers.class);
    public Map<String, Map<TaskEnum, ISchedulerListener>> mObservers = new ConcurrentHashMap();
    public AriaConfig mAriaConfig = AriaConfig.getInstance();

    private Intent createData(int i, int i2, AbsEntity absEntity) {
        Intent intent = new Intent(ISchedulers.ARIA_TASK_INFO_ACTION);
        Bundle bundle = new Bundle();
        bundle.putInt(ISchedulers.TASK_TYPE, i2);
        bundle.putInt(ISchedulers.TASK_STATE, i);
        bundle.putLong(ISchedulers.TASK_SPEED, absEntity.getSpeed());
        bundle.putInt(ISchedulers.TASK_PERCENT, absEntity.getPercent());
        bundle.putParcelable(ISchedulers.TASK_ENTITY, absEntity);
        intent.putExtras(bundle);
        return intent;
    }

    private ISchedulerListener createListener(String str) {
        String str2;
        String message;
        try {
            return (ISchedulerListener) Class.forName(str).newInstance();
        } catch (ClassNotFoundException e) {
            str2 = this.TAG;
            message = e.getMessage();
            ALog.m4191e(str2, message);
            return null;
        } catch (IllegalAccessException e2) {
            str2 = this.TAG;
            message = e2.getMessage();
            ALog.m4191e(str2, message);
            return null;
        } catch (InstantiationException e3) {
            str2 = this.TAG;
            message = e3.getMessage();
            ALog.m4191e(str2, message);
            return null;
        }
    }

    public static TaskSchedulers getInstance() {
        if (INSTANCE == null) {
            synchronized (TaskSchedulers.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskSchedulers();
                    mFailureTaskHandler = FailureTaskHandler.init(INSTANCE);
                }
            }
        }
        return INSTANCE;
    }

    private String getKey(Object obj) {
        return obj.getClass().getName() + obj.hashCode();
    }

    private void handleFailTask(ITaskQueue iTaskQueue, TASK task) {
        if (!task.isNeedRetry() || task.isStop() || task.isCancel()) {
            iTaskQueue.removeTaskFormQueue(task.getKey());
            startNextTask(iTaskQueue, task.getSchedulerType());
            normalTaskCallback(4, task);
            return;
        }
        int reTryNum = task.getTaskWrapper().mo4438getConfig().getReTryNum();
        boolean isNotNetRetry = this.mAriaConfig.getAConfig().isNotNetRetry();
        if ((NetUtils.isConnected(this.mAriaConfig.getAPP()) || isNotNetRetry) && task.getTaskWrapper().mo4442getEntity().getFailNum() <= reTryNum) {
            mFailureTaskHandler.offer(task);
            return;
        }
        iTaskQueue.removeTaskFormQueue(task.getKey());
        startNextTask(iTaskQueue, task.getSchedulerType());
        TaskWrapperManager.getInstance().removeTaskWrapper(task.getTaskWrapper());
        normalTaskCallback(4, task);
    }

    private void handleNormalEvent(TASK task, int i) {
        String str;
        String format;
        String str2;
        String format2;
        ITaskQueue queue = getQueue(task.getTaskType());
        if (i != 3) {
            if (i != 4) {
                if (i == 5) {
                    queue.removeTaskFormQueue(task.getKey());
                    if (queue.getCurrentExePoolNum() < queue.getMaxTaskNum()) {
                        str2 = this.TAG;
                        format2 = String.format("删除任务【%s】成功，尝试开始下一任务", task.getTaskName());
                    } else {
                        str = this.TAG;
                        format = String.format("删除任务【%s】成功", task.getTaskName());
                        ALog.m4192d(str, format);
                    }
                } else if (i == 6) {
                    queue.removeTaskFormQueue(task.getKey());
                    str2 = this.TAG;
                    format2 = String.format("任务【%s】处理完成", task.getTaskName());
                }
                ALog.m4192d(str2, format2);
                startNextTask(queue, task.getSchedulerType());
            } else {
                handleFailTask(queue, task);
            }
        } else if (task.getState() != 3) {
            queue.removeTaskFormQueue(task.getKey());
            if (queue.getCurrentExePoolNum() < queue.getMaxTaskNum()) {
                str2 = this.TAG;
                format2 = String.format("停止任务【%s】成功，尝试开始下一任务", task.getTaskName());
                ALog.m4192d(str2, format2);
                startNextTask(queue, task.getSchedulerType());
            } else {
                str = this.TAG;
                format = String.format("停止任务【%s】成功", task.getTaskName());
                ALog.m4192d(str, format);
            }
        }
        if (i == 4 || i == 11) {
            return;
        }
        if (i == 5 || i == 6) {
            TaskWrapperManager.getInstance().removeTaskWrapper(task.getTaskWrapper());
        } else if (i != 7) {
            TaskWrapperManager.getInstance().putTaskWrapper(task.getTaskWrapper());
        }
        normalTaskCallback(i, task);
    }

    private boolean handlePeerEvent(Message message) {
        M3U8PeerTaskListener m3U8PeerTaskListener;
        Bundle data = message.getData();
        if (this.mObservers.size() > 0) {
            for (String str : this.mObservers.keySet()) {
                Map<TaskEnum, ISchedulerListener> map = this.mObservers.get(str);
                if (map != null && !map.isEmpty() && (m3U8PeerTaskListener = (M3U8PeerTaskListener) map.get(TaskEnum.M3U8_PEER)) != null) {
                    switch (message.what) {
                        case 177:
                            m3U8PeerTaskListener.onPeerStart(data.getString(ISchedulers.DATA_M3U8_URL), data.getString(ISchedulers.DATA_M3U8_PEER_PATH), data.getInt(ISchedulers.DATA_M3U8_PEER_INDEX));
                            continue;
                        case 178:
                            m3U8PeerTaskListener.onPeerComplete(data.getString(ISchedulers.DATA_M3U8_URL), data.getString(ISchedulers.DATA_M3U8_PEER_PATH), data.getInt(ISchedulers.DATA_M3U8_PEER_INDEX));
                            continue;
                        case 179:
                            m3U8PeerTaskListener.onPeerFail(data.getString(ISchedulers.DATA_M3U8_URL), data.getString(ISchedulers.DATA_M3U8_PEER_PATH), data.getInt(ISchedulers.DATA_M3U8_PEER_INDEX));
                            continue;
                    }
                }
            }
        }
        if (this.mAriaConfig.getAConfig().isUseBroadcast()) {
            Intent intent = new Intent(ISchedulers.ARIA_TASK_INFO_ACTION);
            intent.putExtras(data);
            this.mAriaConfig.getAPP().sendBroadcast(intent);
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handlePreFailTask(int i) {
        NormalTaskListener<TASK> normalTaskListener;
        TaskEnum taskEnum;
        startNextTask(getQueue(i), 1);
        if (this.mAriaConfig.getAConfig().isUseBroadcast()) {
            Intent intent = new Intent(ISchedulers.ARIA_TASK_INFO_ACTION);
            Bundle bundle = new Bundle();
            bundle.putInt(ISchedulers.TASK_TYPE, i);
            bundle.putInt(ISchedulers.TASK_STATE, 4);
            this.mAriaConfig.getAPP().sendBroadcast(intent);
        }
        if (this.mObservers.size() > 0) {
            for (String str : this.mObservers.keySet()) {
                Map<TaskEnum, ISchedulerListener> map = this.mObservers.get(str);
                if (map != null && !map.isEmpty()) {
                    if (this.mObservers.get(str) != null) {
                        if (i == 1) {
                            taskEnum = TaskEnum.DOWNLOAD;
                        } else if (i == 3) {
                            taskEnum = TaskEnum.DOWNLOAD_GROUP;
                        } else if (i == 3) {
                            taskEnum = TaskEnum.UPLOAD;
                        }
                        normalTaskListener = (NormalTaskListener) map.get(taskEnum);
                        if (normalTaskListener == null) {
                            normalTaskCallback(11, null, normalTaskListener);
                        }
                    }
                    normalTaskListener = null;
                    if (normalTaskListener == null) {
                    }
                }
            }
        }
    }

    private boolean handleSubEvent(Message message) {
        SubTaskListener subTaskListener;
        GroupSendParams groupSendParams = (GroupSendParams) message.obj;
        if (this.mObservers.size() > 0) {
            for (String str : this.mObservers.keySet()) {
                Map<TaskEnum, ISchedulerListener> map = this.mObservers.get(str);
                if (map != null && !map.isEmpty() && (subTaskListener = (SubTaskListener) map.get(TaskEnum.DOWNLOAD_GROUP_SUB)) != null) {
                    switch (message.what) {
                        case 161:
                            subTaskListener.onSubTaskPre(groupSendParams.groupTask, groupSendParams.entity);
                            continue;
                        case 162:
                            subTaskListener.onSubTaskStart(groupSendParams.groupTask, groupSendParams.entity);
                            continue;
                        case 163:
                            subTaskListener.onSubTaskStop(groupSendParams.groupTask, groupSendParams.entity);
                            continue;
                        case 164:
                            subTaskListener.onSubTaskCancel(groupSendParams.groupTask, groupSendParams.entity);
                            continue;
                        case 165:
                            GROUP_TASK group_task = groupSendParams.groupTask;
                            subTaskListener.onSubTaskFail(group_task, groupSendParams.entity, (Exception) group_task.getExpand(AbsTask.ERROR_INFO_KEY));
                            continue;
                        case 166:
                            subTaskListener.onSubTaskRunning(groupSendParams.groupTask, groupSendParams.entity);
                            continue;
                        case 167:
                            subTaskListener.onSubTaskComplete(groupSendParams.groupTask, groupSendParams.entity);
                            continue;
                    }
                }
            }
        }
        if (this.mAriaConfig.getAConfig().isUseBroadcast()) {
            this.mAriaConfig.getAPP().sendBroadcast(createData(message.what, 4, groupSendParams.entity));
            return true;
        }
        return true;
    }

    private boolean hasProxyListener(Map<TaskEnum, ISchedulerListener> map, TaskEnum taskEnum) {
        return !map.isEmpty() && map.get(taskEnum) != null;
    }

    private void normalTaskCallback(int i, TASK task) {
        TaskEnum taskEnum;
        sendNormalBroadcast(i, task);
        if (this.mObservers.size() > 0) {
            for (String str : this.mObservers.keySet()) {
                Map<TaskEnum, ISchedulerListener> map = this.mObservers.get(str);
                if (map != null && !map.isEmpty()) {
                    NormalTaskListener<TASK> normalTaskListener = null;
                    if (this.mObservers.get(str) != null) {
                        if (task instanceof DownloadTask) {
                            taskEnum = TaskEnum.DOWNLOAD;
                        } else if (task instanceof DownloadGroupTask) {
                            taskEnum = TaskEnum.DOWNLOAD_GROUP;
                        } else if (task instanceof UploadTask) {
                            taskEnum = TaskEnum.UPLOAD;
                        }
                        normalTaskListener = (NormalTaskListener) map.get(taskEnum);
                    }
                    if (normalTaskListener != null) {
                        normalTaskCallback(i, task, normalTaskListener);
                    }
                }
            }
        }
    }

    private void normalTaskCallback(int i, TASK task, NormalTaskListener<TASK> normalTaskListener) {
        if (normalTaskListener != null) {
            if (task == null && i != 11) {
                ALog.m4191e(this.TAG, "TASK 为null，回调失败");
                return;
            }
            TASK task2 = null;
            switch (i) {
                case 0:
                    normalTaskListener.onPre(task);
                    return;
                case 1:
                    normalTaskListener.onTaskPre(task);
                    return;
                case 2:
                    normalTaskListener.onTaskStart(task);
                    return;
                case 3:
                    normalTaskListener.onTaskStop(task);
                    return;
                case 4:
                    if (task.getTaskType() != 6) {
                        task2 = task;
                    }
                    normalTaskListener.onTaskFail(task2, (Exception) task.getExpand(AbsTask.ERROR_INFO_KEY));
                    return;
                case 5:
                    normalTaskListener.onTaskCancel(task);
                    return;
                case 6:
                    normalTaskListener.onTaskComplete(task);
                    return;
                case 7:
                    normalTaskListener.onTaskRunning(task);
                    return;
                case 8:
                    normalTaskListener.onTaskResume(task);
                    return;
                case 9:
                    normalTaskListener.onNoSupportBreakPoint(task);
                    return;
                case 10:
                    normalTaskListener.onWait(task);
                    return;
                case 11:
                    normalTaskListener.onTaskFail(null, null);
                    return;
                default:
                    return;
            }
        }
    }

    private void sendNormalBroadcast(int i, TASK task) {
        if (!this.mAriaConfig.getAConfig().isUseBroadcast()) {
            return;
        }
        int taskType = task.getTaskType();
        if (taskType == 1 || taskType == 3 || taskType == 2) {
            this.mAriaConfig.getAPP().sendBroadcast(createData(i, taskType, task.getTaskWrapper().mo4442getEntity()));
        } else {
            ALog.m4185w(this.TAG, "发送广播失败，没有对应的任务");
        }
    }

    public ITaskQueue getQueue(int i) {
        if (i == 1) {
            return DTaskQueue.getInstance();
        }
        if (i == 3) {
            return DGroupTaskQueue.getInstance();
        }
        if (i != 2) {
            throw new NullPointerException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("任务类型错误，type = ", i));
        }
        return UTaskQueue.getInstance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 11) {
            handlePreFailTask(message.arg1);
            return true;
        }
        int i2 = message.arg1;
        if (i2 == 209) {
            return handleSubEvent(message);
        }
        if (i2 == 210) {
            return handlePeerEvent(message);
        }
        ITask iTask = (ITask) message.obj;
        if (iTask == null) {
            ALog.m4191e(this.TAG, "请传入下载任务");
            return true;
        }
        handleNormalEvent(iTask, i);
        return true;
    }

    public void register(Object obj, TaskEnum taskEnum) {
        String name = obj.getClass().getName();
        Map<TaskEnum, ISchedulerListener> map = this.mObservers.get(getKey(obj));
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.mObservers.put(getKey(obj), map);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(taskEnum.proxySuffix);
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        if (!hasProxyListener(map, taskEnum)) {
            ISchedulerListener createListener = createListener(sb);
            if (createListener != null) {
                createListener.setListener(obj);
                map.put(taskEnum, createListener);
                return;
            }
            String str = this.TAG;
            ALog.m4191e(str, "注册错误，没有【" + sb + "】观察者");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startNextTask(ITaskQueue iTaskQueue, int i) {
        if (i == 2) {
            return;
        }
        ITask mo4433getNextTask = iTaskQueue.mo4433getNextTask();
        if (mo4433getNextTask == null) {
            if (iTaskQueue.getCurrentExePoolNum() != 0) {
                return;
            }
            ALog.m4189i(this.TAG, "没有等待中的任务");
        } else if (mo4433getNextTask.getState() != 3) {
        } else {
            iTaskQueue.startTask(mo4433getNextTask);
        }
    }

    public void unRegister(Object obj) {
        if (!this.mObservers.containsKey(getKey(obj))) {
            return;
        }
        Iterator<Map.Entry<String, Map<TaskEnum, ISchedulerListener>>> it = this.mObservers.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(getKey(obj))) {
                it.remove();
            }
        }
    }
}
