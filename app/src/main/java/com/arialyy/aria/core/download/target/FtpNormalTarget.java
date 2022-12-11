package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.common.SFtpOption;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class FtpNormalTarget extends AbsNormalTarget<FtpNormalTarget> {
    public DNormalConfigHandler<FtpNormalTarget> mConfigHandler;

    public FtpNormalTarget(long j) {
        this.mConfigHandler = new DNormalConfigHandler<>(this, j);
        getTaskWrapper().setRequestType(3);
        getTaskWrapper().setNewTask(false);
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

    public FtpNormalTarget modifyFilePath(String str) {
        mo4441getEntity().setFileName(this.mConfigHandler.getUrl().substring(this.mConfigHandler.getUrl().lastIndexOf("/") + 1));
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }

    public FtpNormalTarget option(FtpOption ftpOption) {
        if (ftpOption != null) {
            ftpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(mo4441getEntity().getUrl()));
            getTaskWrapper().getOptionParams().setParams(ftpOption);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    public FtpNormalTarget sftpOption(SFtpOption sFtpOption) {
        if (sFtpOption != null) {
            sFtpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.mConfigHandler.getUrl()));
            getTaskWrapper().getOptionParams().setParams(sFtpOption);
            mo4441getEntity().setTaskType(12);
            getTaskWrapper().setRequestType(12);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean taskExists() {
        return this.mConfigHandler.taskExists();
    }

    public FtpNormalTarget updateUrl(String str) {
        return this.mConfigHandler.updateUrl(str);
    }
}
