package com.arialyy.aria.core.download.target;

import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.event.ErrorEvent;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.core.inf.IConfigHandler;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public class DNormalConfigHandler<TARGET extends AbsTarget> implements IConfigHandler {
    public final String TAG = "DNormalDelegate";
    public DownloadEntity mEntity;
    public TARGET mTarget;
    public DTaskWrapper mWrapper;

    public DNormalConfigHandler(TARGET target, long j) {
        this.mTarget = target;
        initTarget(j);
    }

    private DTaskWrapper getWrapper() {
        return this.mWrapper;
    }

    private void initTarget(long j) {
        ErrorEvent errorEvent;
        DTaskWrapper dTaskWrapper = (DTaskWrapper) TaskWrapperManager.getInstance().getNormalTaskWrapper(DTaskWrapper.class, j);
        this.mWrapper = dTaskWrapper;
        if (this.mTarget instanceof AbsNormalTarget) {
            if (j < 0) {
                errorEvent = new ErrorEvent(j, "任务id为空");
            } else if (dTaskWrapper.mo4442getEntity().getId() < 0) {
                dTaskWrapper = this.mWrapper;
                errorEvent = new ErrorEvent(j, "任务信息不存在");
            }
            dTaskWrapper.setErrorEvent(errorEvent);
        }
        this.mEntity = this.mWrapper.mo4442getEntity();
        this.mTarget.setTaskWrapper(this.mWrapper);
        if (this.mEntity != null) {
            getWrapper().setTempFilePath(this.mEntity.getFilePath());
        }
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    /* renamed from: getEntity  reason: collision with other method in class */
    public DownloadEntity mo4422getEntity() {
        return (DownloadEntity) this.mTarget.mo4441getEntity();
    }

    public String getUrl() {
        return this.mEntity.getUrl();
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean isRunning() {
        return DTaskQueue.getInstance().taskIsRunning(this.mEntity.getKey());
    }

    public void setForceDownload(boolean z) {
        getWrapper().setIgnoreFilePathOccupy(z);
    }

    public void setTempFilePath(String str) {
        getWrapper().setTempFilePath(str);
    }

    public void setUrl(String str) {
        this.mEntity.setUrl(str);
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean taskExists() {
        return DbEntity.checkDataExist(DownloadEntity.class, "rowid=?", String.valueOf(this.mEntity.getId()));
    }

    public TARGET updateUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "url更新失败，newUrl为null";
        } else if (!this.mEntity.getUrl().equals(str)) {
            getWrapper().setRefreshInfo(true);
            getWrapper().setTempUrl(str);
            ALog.m4192d("DNormalDelegate", "更新url成功");
            return this.mTarget;
        } else {
            str2 = "url更新失败，新的下载url和旧的url一致";
        }
        ALog.m4191e("DNormalDelegate", str2);
        return this.mTarget;
    }
}
