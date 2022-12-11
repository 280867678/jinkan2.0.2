package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.manager.SubTaskManager;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class FtpDirBuilderTarget extends AbsBuilderTarget<FtpDirBuilderTarget> {
    public FtpDirConfigHandler<FtpDirBuilderTarget> mConfigHandler = new FtpDirConfigHandler<>(this, -1);
    public String url;

    public FtpDirBuilderTarget(String str) {
        this.url = str;
        mo4441getEntity().setGroupHash(str);
        getTaskWrapper().setNewTask(true);
    }

    @Override // com.arialyy.aria.core.inf.AbsTarget
    /* renamed from: getEntity  reason: collision with other method in class */
    public DownloadGroupEntity mo4441getEntity() {
        return (DownloadGroupEntity) super.mo4441getEntity();
    }

    public SubTaskManager getSubTaskManager() {
        return this.mConfigHandler.getSubTaskManager();
    }

    public FtpDirBuilderTarget option(FtpOption ftpOption) {
        if (ftpOption != null) {
            ftpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.url));
            getTaskWrapper().getOptionParams().setParams(ftpOption);
            return this;
        }
        throw new NullPointerException("ftp 任务配置为空");
    }

    public FtpDirBuilderTarget setDirPath(String str) {
        return this.mConfigHandler.setDirPath(str);
    }

    public FtpDirBuilderTarget setGroupAlias(String str) {
        this.mConfigHandler.setGroupAlias(str);
        return this;
    }
}
