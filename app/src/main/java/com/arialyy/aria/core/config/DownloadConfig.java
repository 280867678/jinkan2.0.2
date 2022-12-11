package com.arialyy.aria.core.config;

import com.arialyy.aria.core.event.DMaxNumEvent;
import com.arialyy.aria.core.event.DSpeedEvent;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.util.ALog;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class DownloadConfig extends BaseTaskConfig implements Serializable {
    public int threadNum = 3;
    public boolean useBlock = true;

    public int getThreadNum() {
        return this.threadNum;
    }

    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 1;
    }

    public boolean isUseBlock() {
        return this.useBlock;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    /* renamed from: setMaxSpeed  reason: collision with other method in class */
    public DownloadConfig mo4410setMaxSpeed(int i) {
        super.mo4410setMaxSpeed(i);
        EventMsgUtil.getDefault().post(new DSpeedEvent(i));
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    /* renamed from: setMaxTaskNum  reason: collision with other method in class */
    public DownloadConfig mo4411setMaxTaskNum(int i) {
        if (i <= 0) {
            ALog.m4191e(this.TAG, "下载任务最大任务数不能小于0");
            return this;
        }
        super.mo4411setMaxTaskNum(i);
        EventMsgUtil.getDefault().post(new DMaxNumEvent(i));
        return this;
    }

    public DownloadConfig setThreadNum(int i) {
        this.threadNum = i;
        save();
        return this;
    }

    public DownloadConfig setUseBlock(boolean z) {
        this.useBlock = z;
        save();
        return this;
    }
}
