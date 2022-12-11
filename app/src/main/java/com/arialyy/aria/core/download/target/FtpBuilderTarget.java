package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.common.SFtpOption;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class FtpBuilderTarget extends AbsBuilderTarget<FtpBuilderTarget> {
    public DNormalConfigHandler<FtpBuilderTarget> mConfigHandler;

    public FtpBuilderTarget(String str) {
        DNormalConfigHandler<FtpBuilderTarget> dNormalConfigHandler = new DNormalConfigHandler<>(this, -1L);
        this.mConfigHandler = dNormalConfigHandler;
        dNormalConfigHandler.setUrl(str);
        getTaskWrapper().setRequestType(3);
        mo4441getEntity().setTaskType(3);
        getTaskWrapper().setNewTask(true);
    }

    @Override // com.arialyy.aria.core.inf.AbsTarget
    /* renamed from: getEntity  reason: collision with other method in class */
    public DownloadEntity mo4441getEntity() {
        return (DownloadEntity) super.mo4441getEntity();
    }

    public FtpBuilderTarget option(FtpOption ftpOption) {
        if (ftpOption != null) {
            ftpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.mConfigHandler.getUrl()));
            getTaskWrapper().getOptionParams().setParams(ftpOption);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    public FtpBuilderTarget setFilePath(String str) {
        mo4441getEntity().setFileName(this.mConfigHandler.getUrl().substring(this.mConfigHandler.getUrl().lastIndexOf("/") + 1));
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }

    @Deprecated
    public FtpBuilderTarget setFilePath(String str, boolean z) {
        this.mConfigHandler.setTempFilePath(str);
        this.mConfigHandler.setForceDownload(z);
        return this;
    }

    public FtpBuilderTarget sftpOption(SFtpOption sFtpOption) {
        if (sFtpOption != null) {
            sFtpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.mConfigHandler.getUrl()));
            getTaskWrapper().getOptionParams().setParams(sFtpOption);
            mo4441getEntity().setTaskType(12);
            getTaskWrapper().setRequestType(12);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }
}
