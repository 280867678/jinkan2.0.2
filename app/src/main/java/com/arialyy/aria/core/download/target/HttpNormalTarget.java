package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.m3u8.M3U8LiveOption;
import com.arialyy.aria.core.download.m3u8.M3U8VodOption;

/* loaded from: classes3.dex */
public class HttpNormalTarget extends AbsNormalTarget<HttpNormalTarget> {
    public DNormalConfigHandler<HttpNormalTarget> mConfigHandler;

    public HttpNormalTarget(long j) {
        this.mConfigHandler = new DNormalConfigHandler<>(this, j);
        getTaskWrapper().setRequestType(getTaskWrapper().mo4442getEntity().getTaskType());
        getTaskWrapper().setNewTask(false);
    }

    public String getContentDisposition() {
        return mo4441getEntity().getDisposition();
    }

    @Override // com.arialyy.aria.core.inf.AbsTarget
    /* renamed from: getEntity  reason: collision with other method in class */
    public DownloadEntity mo4441getEntity() {
        return (DownloadEntity) super.mo4441getEntity();
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean isRunning() {
        return this.mConfigHandler.isRunning();
    }

    public HttpNormalTarget m3u8LiveOption(M3U8LiveOption m3U8LiveOption) {
        if (m3U8LiveOption != null) {
            getTaskWrapper().setRequestType(8);
            ((DTaskWrapper) getTaskWrapper()).getM3U8Params().setParams(m3U8LiveOption);
            return this;
        }
        throw new NullPointerException("m3u8任务设置为空");
    }

    public M3U8NormalTarget m3u8VodOption() {
        return new M3U8NormalTarget((DTaskWrapper) getTaskWrapper());
    }

    public M3U8NormalTarget m3u8VodOption(M3U8VodOption m3U8VodOption) {
        if (m3U8VodOption != null) {
            getTaskWrapper().setRequestType(7);
            getTaskWrapper().mo4442getEntity().setFileSize(m3U8VodOption.getFileSize());
            ((DTaskWrapper) getTaskWrapper()).getM3U8Params().setParams(m3U8VodOption);
            return new M3U8NormalTarget((DTaskWrapper) getTaskWrapper());
        }
        throw new NullPointerException("m3u8任务设置为空");
    }

    public HttpNormalTarget modifyFilePath(String str) {
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }

    public HttpNormalTarget option(HttpOption httpOption) {
        if (httpOption != null) {
            getTaskWrapper().getOptionParams().setParams(httpOption);
            return this;
        }
        throw new NullPointerException("任务配置为空");
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean taskExists() {
        return this.mConfigHandler.taskExists();
    }

    public HttpNormalTarget updateUrl(String str) {
        return this.mConfigHandler.updateUrl(str);
    }
}
