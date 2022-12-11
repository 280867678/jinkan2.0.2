package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.manager.SubTaskManager;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class FtpDirNormalTarget extends AbsNormalTarget<FtpDirNormalTarget> {
    public FtpDirConfigHandler<FtpDirNormalTarget> mConfigHandler;
    public FtpOption option;

    public FtpDirNormalTarget(long j) {
        this.mConfigHandler = new FtpDirConfigHandler<>(this, j);
        getTaskWrapper().setNewTask(false);
    }

    @Override // com.arialyy.aria.core.inf.AbsTarget
    /* renamed from: getEntity  reason: collision with other method in class */
    public DownloadGroupEntity mo4441getEntity() {
        return (DownloadGroupEntity) super.mo4441getEntity();
    }

    public SubTaskManager getSubTaskManager() {
        return this.mConfigHandler.getSubTaskManager();
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean isRunning() {
        return this.mConfigHandler.isRunning();
    }

    public FtpDirNormalTarget modifyDirPath(String str) {
        return this.mConfigHandler.setDirPath(str);
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public void onPre() {
        super.onPre();
        if (this.option == null) {
            this.option = new FtpOption();
        }
        this.option.setUrlEntity(CommonUtil.getFtpUrlInfo(mo4441getEntity().getKey()));
        getTaskWrapper().getOptionParams().setParams(this.option);
    }

    public FtpDirNormalTarget option(FtpOption ftpOption) {
        if (ftpOption != null) {
            this.option = ftpOption;
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    @Override // com.arialyy.aria.core.common.AbsNormalTarget
    public boolean taskExists() {
        return this.mConfigHandler.taskExists();
    }
}
