package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.event.PeerIndexEvent;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public class M3U8NormalTarget extends AbsNormalTarget<M3U8NormalTarget> {
    public M3U8NormalTarget(DTaskWrapper dTaskWrapper) {
        setTaskWrapper(dTaskWrapper);
        getTaskWrapper().setNewTask(false);
        getTaskWrapper().setRequestType(7);
    }

    public void jumPeerIndex(int i) {
        if (i < 1) {
            ALog.m4191e(this.TAG, "切片索引不能小于1");
        } else if (!DTaskQueue.getInstance().taskIsRunning(getTaskWrapper().getKey())) {
            ALog.m4191e(this.TAG, String.format("任务【%s】没有运行，如果你希望在启动任务时初始化索引位置，请调用setPeerIndex(xxx）", getTaskWrapper().getKey()));
        } else {
            EventMsgUtil.getDefault().post(new PeerIndexEvent(getTaskWrapper().getKey(), i));
        }
    }
}
