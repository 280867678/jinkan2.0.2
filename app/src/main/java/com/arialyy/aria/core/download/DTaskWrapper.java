package com.arialyy.aria.core.download;

import com.arialyy.aria.core.TaskOptionParams;
import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.config.DownloadConfig;
import com.arialyy.aria.core.inf.ITaskOption;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ComponentUtil;

/* loaded from: classes3.dex */
public class DTaskWrapper extends AbsTaskWrapper<DownloadEntity> {
    public String groupHash;
    public ITaskOption m3u8Option;
    public String mTempFilePath;
    public String mTempUrl;
    public boolean isGroupTask = false;
    public TaskOptionParams m3u8Params = new TaskOptionParams();

    public DTaskWrapper(DownloadEntity downloadEntity) {
        super(downloadEntity);
    }

    public void generateM3u8Option(Class<? extends ITaskOption> cls) {
        this.m3u8Option = ComponentUtil.getInstance().buildTaskOption(cls, this.m3u8Params);
    }

    @Override // com.arialyy.aria.core.wrapper.AbsTaskWrapper
    /* renamed from: getConfig  reason: collision with other method in class */
    public DownloadConfig mo4438getConfig() {
        return this.isGroupTask ? Configuration.getInstance().dGroupCfg.getSubConfig() : Configuration.getInstance().downloadCfg;
    }

    public String getGroupHash() {
        return this.groupHash;
    }

    @Override // com.arialyy.aria.core.wrapper.ITaskWrapper
    public String getKey() {
        return mo4442getEntity().getKey();
    }

    public TaskOptionParams getM3U8Params() {
        if (this.m3u8Params == null) {
            this.m3u8Params = new TaskOptionParams();
        }
        return this.m3u8Params;
    }

    public ITaskOption getM3u8Option() {
        return this.m3u8Option;
    }

    public String getTempFilePath() {
        return this.mTempFilePath;
    }

    public String getTempUrl() {
        return this.mTempUrl;
    }

    public boolean isGroupTask() {
        return this.isGroupTask;
    }

    public void setGroupHash(String str) {
        this.groupHash = str;
    }

    public void setGroupTask(boolean z) {
        this.isGroupTask = z;
    }

    public void setTempFilePath(String str) {
        this.mTempFilePath = str;
    }

    public void setTempUrl(String str) {
        this.mTempUrl = str;
    }
}
