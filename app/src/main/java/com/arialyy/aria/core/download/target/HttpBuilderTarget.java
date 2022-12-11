package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.m3u8.M3U8LiveOption;
import com.arialyy.aria.core.download.m3u8.M3U8VodOption;

/* loaded from: classes3.dex */
public class HttpBuilderTarget extends AbsBuilderTarget<HttpBuilderTarget> {
    public DNormalConfigHandler<HttpBuilderTarget> mConfigHandler;

    public HttpBuilderTarget(String str) {
        DNormalConfigHandler<HttpBuilderTarget> dNormalConfigHandler = new DNormalConfigHandler<>(this, -1L);
        this.mConfigHandler = dNormalConfigHandler;
        dNormalConfigHandler.setUrl(str);
        getTaskWrapper().setRequestType(1);
        getTaskWrapper().setNewTask(true);
        ((DownloadEntity) mo4441getEntity()).setTaskType(1);
    }

    public HttpBuilderTarget m3u8LiveOption(M3U8LiveOption m3U8LiveOption) {
        if (m3U8LiveOption != null) {
            getTaskWrapper().setRequestType(8);
            ((DTaskWrapper) getTaskWrapper()).getM3U8Params().setParams(m3U8LiveOption);
            return this;
        }
        throw new NullPointerException("m3u8任务设置为空");
    }

    public HttpBuilderTarget m3u8VodOption(M3U8VodOption m3U8VodOption) {
        if (m3U8VodOption != null) {
            getTaskWrapper().setRequestType(7);
            getTaskWrapper().mo4442getEntity().setFileSize(m3U8VodOption.getFileSize());
            ((DTaskWrapper) getTaskWrapper()).getM3U8Params().setParams(m3U8VodOption);
            return this;
        }
        throw new NullPointerException("m3u8任务设置为空");
    }

    public HttpBuilderTarget option(HttpOption httpOption) {
        if (httpOption != null) {
            getTaskWrapper().getOptionParams().setParams(httpOption);
            return this;
        }
        throw new NullPointerException("任务配置为空");
    }

    public HttpBuilderTarget setFilePath(String str) {
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }

    @Deprecated
    public HttpBuilderTarget setFilePath(String str, boolean z) {
        this.mConfigHandler.setTempFilePath(str);
        this.mConfigHandler.setForceDownload(z);
        return this;
    }
}
