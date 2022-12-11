package com.arialyy.aria.core.upload.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.common.SFtpOption;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class FtpNormalTarget extends AbsNormalTarget<FtpNormalTarget> {
    public UNormalConfigHandler<FtpNormalTarget> mConfigHandler;

    public FtpNormalTarget(long j) {
        this.mConfigHandler = new UNormalConfigHandler<>(this, j);
        getTaskWrapper().setRequestType(6);
        getTaskWrapper().setNewTask(false);
    }

    @Override // com.arialyy.aria.core.inf.AbsTarget
    /* renamed from: getEntity  reason: collision with other method in class */
    public UploadEntity mo4441getEntity() {
        return (UploadEntity) super.mo4441getEntity();
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean isRunning() {
        return this.mConfigHandler.isRunning();
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
            sFtpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(mo4441getEntity().getUrl()));
            getTaskWrapper().getOptionParams().setParams(sFtpOption);
            mo4441getEntity().setTaskType(13);
            getTaskWrapper().setRequestType(13);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean taskExists() {
        return this.mConfigHandler.taskExists();
    }
}
