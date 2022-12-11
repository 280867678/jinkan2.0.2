package com.arialyy.aria.core.upload;

import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.config.UploadConfig;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public class UTaskWrapper extends AbsTaskWrapper<UploadEntity> {
    public String tempUrl;

    public UTaskWrapper(UploadEntity uploadEntity) {
        super(uploadEntity);
    }

    @Override // com.arialyy.aria.core.wrapper.AbsTaskWrapper
    /* renamed from: getConfig  reason: collision with other method in class */
    public UploadConfig mo4438getConfig() {
        return Configuration.getInstance().uploadCfg;
    }

    @Override // com.arialyy.aria.core.wrapper.ITaskWrapper
    public String getKey() {
        return mo4442getEntity().getKey();
    }

    public String getTempUrl() {
        return this.tempUrl;
    }

    public void setTempUrl(String str) {
        this.tempUrl = str;
    }
}
