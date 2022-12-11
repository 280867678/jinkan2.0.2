package com.arialyy.aria.core.config;

import com.arialyy.aria.core.event.DGMaxNumEvent;
import com.arialyy.aria.core.event.DSpeedEvent;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.util.ALog;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class DGroupConfig extends BaseTaskConfig implements Serializable {
    public DownloadConfig subConfig;
    public int subMaxTaskNum = 3;
    public boolean subFailAsStop = true;
    public int subReTryNum = 5;
    public int subReTryInterval = 2000;

    public DGroupConfig() {
        getSubConfig();
    }

    public DownloadConfig getSubConfig() {
        if (this.subConfig == null) {
            DownloadConfig downloadConfig = new DownloadConfig();
            this.subConfig = downloadConfig;
            downloadConfig.threadNum = 1;
            downloadConfig.useBlock = false;
            downloadConfig.buffSize = this.buffSize;
            downloadConfig.caName = this.caName;
            downloadConfig.caPath = this.caPath;
            downloadConfig.connectTimeOut = this.connectTimeOut;
            downloadConfig.iOTimeOut = this.iOTimeOut;
            downloadConfig.isConvertSpeed = this.isConvertSpeed;
            downloadConfig.maxSpeed = this.maxSpeed;
            downloadConfig.queueMod = "now";
            downloadConfig.reTryInterval = this.subReTryInterval;
            downloadConfig.reTryNum = this.subReTryNum;
            downloadConfig.updateInterval = this.updateInterval;
        }
        return this.subConfig;
    }

    public int getSubMaxTaskNum() {
        return this.subMaxTaskNum;
    }

    public int getSubReTryInterval() {
        return this.subReTryInterval;
    }

    public int getSubReTryNum() {
        return this.subReTryNum;
    }

    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 4;
    }

    public boolean isSubFailAsStop() {
        return this.subFailAsStop;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    /* renamed from: setMaxSpeed  reason: collision with other method in class */
    public DGroupConfig mo4410setMaxSpeed(int i) {
        super.mo4410setMaxSpeed(i);
        EventMsgUtil.getDefault().post(new DSpeedEvent(i));
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    /* renamed from: setMaxTaskNum  reason: collision with other method in class */
    public DGroupConfig mo4411setMaxTaskNum(int i) {
        if (i <= 0) {
            ALog.m4191e(this.TAG, "组合任务最大任务数不能小于0");
            return this;
        }
        super.mo4411setMaxTaskNum(i);
        EventMsgUtil.getDefault().post(new DGMaxNumEvent(i));
        return this;
    }

    public DGroupConfig setSubFailAsStop(boolean z) {
        this.subFailAsStop = z;
        save();
        return this;
    }

    public DGroupConfig setSubMaxTaskNum(int i) {
        this.subMaxTaskNum = i;
        save();
        return this;
    }

    public DGroupConfig setSubReTryInterval(int i) {
        this.subReTryInterval = i;
        this.subConfig.reTryInterval = i;
        save();
        return this;
    }

    public DGroupConfig setSubReTryNum(int i) {
        this.subReTryNum = i;
        this.subConfig.reTryNum = i;
        save();
        return this;
    }
}
