package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.download.DownloadEntity;

/* loaded from: classes3.dex */
public class TcpBuilderTarget extends AbsBuilderTarget<TcpBuilderTarget> {
    public DNormalConfigHandler mConfigHandler = new DNormalConfigHandler(this, -1);

    public TcpBuilderTarget(String str, int i) {
        getTaskWrapper().setRequestType(9);
        ((DownloadEntity) mo4441getEntity()).setTaskType(9);
        getTaskWrapper().setNewTask(true);
    }

    public TcpBuilderTarget setFilePath(String str) {
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }
}
