package com.arialyy.aria.core.config;

import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.event.UMaxNumEvent;
import com.arialyy.aria.core.event.USpeedEvent;
import com.arialyy.aria.util.ALog;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class UploadConfig extends BaseTaskConfig implements Serializable {
    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 2;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    /* renamed from: setMaxSpeed  reason: collision with other method in class */
    public UploadConfig mo4410setMaxSpeed(int i) {
        super.mo4410setMaxSpeed(i);
        EventMsgUtil.getDefault().post(new USpeedEvent(i));
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    /* renamed from: setMaxTaskNum  reason: collision with other method in class */
    public UploadConfig mo4411setMaxTaskNum(int i) {
        if (i <= 0) {
            ALog.m4191e(this.TAG, "上传任务最大任务数不能小于0");
            return this;
        }
        super.mo4411setMaxTaskNum(i);
        EventMsgUtil.getDefault().post(new UMaxNumEvent(i));
        return this;
    }
}
