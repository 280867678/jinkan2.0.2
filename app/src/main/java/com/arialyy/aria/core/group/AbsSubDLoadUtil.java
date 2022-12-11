package com.arialyy.aria.core.group;

import android.os.Handler;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.inf.IUtil;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.loader.SubLoader;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public abstract class AbsSubDLoadUtil implements IUtil, Runnable {
    public Handler mSchedulers;
    public DTaskWrapper mWrapper;
    public boolean needGetInfo;
    public String parentKey;
    public final String TAG = CommonUtil.getClassName((Class) getClass());
    public boolean isStop = false;
    public boolean isCancel = false;
    public SubLoader mDLoader = getLoader();

    public AbsSubDLoadUtil(DTaskWrapper dTaskWrapper, Handler handler, boolean z, String str) {
        this.mWrapper = dTaskWrapper;
        this.mSchedulers = handler;
        this.parentKey = str;
        this.needGetInfo = z;
    }

    public abstract LoaderStructure buildLoaderStructure();

    @Override // com.arialyy.aria.core.inf.IUtil
    public void cancel() {
        if (this.isCancel) {
            ALog.m4185w(this.TAG, "子任务已取消");
            return;
        }
        this.isCancel = true;
        if (this.mDLoader == null || !isRunning()) {
            this.mSchedulers.obtainMessage(5, this).sendToTarget();
        } else {
            this.mDLoader.cancel();
        }
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    @Deprecated
    public long getCurrentLocation() {
        return -1L;
    }

    public DownloadEntity getEntity() {
        return this.mWrapper.mo4442getEntity();
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    @Deprecated
    public long getFileSize() {
        return -1L;
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public String getKey() {
        return this.mDLoader.getKey();
    }

    public abstract SubLoader getLoader();

    public String getParentKey() {
        return this.parentKey;
    }

    public TaskRecord getRecord() {
        return getLoader().getRecord();
    }

    public Handler getSchedulers() {
        return this.mSchedulers;
    }

    public DTaskWrapper getWrapper() {
        return this.mWrapper;
    }

    public boolean isNeedGetInfo() {
        return this.needGetInfo;
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public boolean isRunning() {
        SubLoader subLoader = this.mDLoader;
        return subLoader != null && subLoader.isRunning();
    }

    public void reStart() {
        SubLoader subLoader = this.mDLoader;
        if (subLoader != null) {
            subLoader.retryTask();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isStop || this.isCancel) {
            return;
        }
        buildLoaderStructure();
        new Thread(this.mDLoader).start();
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    @Deprecated
    public void start() {
        throw new AssertionError("请在线程池中使用");
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public void stop() {
        if (this.isStop) {
            ALog.m4185w(this.TAG, "任务已停止");
            return;
        }
        this.isStop = true;
        if (this.mDLoader == null || !isRunning()) {
            this.mSchedulers.obtainMessage(3, this).sendToTarget();
        } else {
            this.mDLoader.stop();
        }
    }
}
