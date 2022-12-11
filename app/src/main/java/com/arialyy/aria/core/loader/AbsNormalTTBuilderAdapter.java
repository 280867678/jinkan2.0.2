package com.arialyy.aria.core.loader;

import android.os.Handler;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.task.IThreadTaskAdapter;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.CommonUtil;
import java.io.File;

/* loaded from: classes3.dex */
public abstract class AbsNormalTTBuilderAdapter {
    public String TAG = CommonUtil.getClassName(this);
    public File tempFile;
    public AbsTaskWrapper wrapper;

    private SubThreadConfig createNormalSubThreadConfig(Handler handler, ThreadRecord threadRecord, boolean z, int i) {
        SubThreadConfig subThreadConfig = new SubThreadConfig();
        subThreadConfig.url = getEntity().isRedirect() ? getEntity().getRedirectUrl() : getEntity().getUrl();
        subThreadConfig.tempFile = z ? new File(String.format(IRecordHandler.SUB_PATH, this.tempFile.getPath(), Integer.valueOf(threadRecord.threadId))) : this.tempFile;
        subThreadConfig.isBlock = z;
        subThreadConfig.startThreadNum = i;
        AbsTaskWrapper absTaskWrapper = this.wrapper;
        subThreadConfig.taskWrapper = absTaskWrapper;
        subThreadConfig.record = threadRecord;
        subThreadConfig.stateHandler = handler;
        subThreadConfig.threadType = SubThreadConfig.getThreadType(absTaskWrapper.getRequestType());
        subThreadConfig.updateInterval = SubThreadConfig.getUpdateInterval(this.wrapper.getRequestType());
        return subThreadConfig;
    }

    public abstract IThreadTaskAdapter getAdapter(SubThreadConfig subThreadConfig);

    public AbsNormalEntity getEntity() {
        return (AbsNormalEntity) this.wrapper.mo4442getEntity();
    }

    public SubThreadConfig getSubThreadConfig(Handler handler, ThreadRecord threadRecord, boolean z, int i) {
        return createNormalSubThreadConfig(handler, threadRecord, z, i);
    }

    public File getTempFile() {
        return this.tempFile;
    }

    public abstract boolean handleNewTask(TaskRecord taskRecord, int i);

    public void setWrapper(AbsTaskWrapper absTaskWrapper) {
        this.wrapper = absTaskWrapper;
        this.tempFile = new File(((AbsNormalEntity) absTaskWrapper.mo4442getEntity()).getFilePath());
    }
}
