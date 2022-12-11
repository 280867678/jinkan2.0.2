package com.arialyy.aria.core.upload.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.common.SFtpOption;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class FtpBuilderTarget extends AbsBuilderTarget<FtpBuilderTarget> {
    public UNormalConfigHandler<FtpBuilderTarget> mConfigHandler;
    public String url;

    public FtpBuilderTarget(String str) {
        UNormalConfigHandler<FtpBuilderTarget> uNormalConfigHandler = new UNormalConfigHandler<>(this, -1L);
        this.mConfigHandler = uNormalConfigHandler;
        uNormalConfigHandler.setFilePath(str);
        getTaskWrapper().setRequestType(6);
        ((UploadEntity) mo4441getEntity()).setTaskType(6);
        getTaskWrapper().setNewTask(true);
    }

    @Deprecated
    public FtpBuilderTarget forceUpload() {
        getTaskWrapper().setIgnoreFilePathOccupy(true);
        return this;
    }

    public FtpBuilderTarget option(FtpOption ftpOption) {
        if (ftpOption != null) {
            ftpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.url));
            getTaskWrapper().getOptionParams().setParams(ftpOption);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    public FtpBuilderTarget setUploadUrl(String str) {
        this.url = str;
        this.mConfigHandler.setTempUrl(str);
        return this;
    }

    public FtpBuilderTarget sftpOption(SFtpOption sFtpOption) {
        if (sFtpOption != null) {
            sFtpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.url));
            getTaskWrapper().getOptionParams().setParams(sFtpOption);
            ((UploadEntity) mo4441getEntity()).setTaskType(13);
            getTaskWrapper().setRequestType(13);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }
}
