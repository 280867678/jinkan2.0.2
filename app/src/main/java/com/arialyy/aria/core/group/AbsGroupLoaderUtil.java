package com.arialyy.aria.core.group;

import com.arialyy.aria.core.inf.IUtil;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public abstract class AbsGroupLoaderUtil implements IUtil {
    public IEventListener mListener;
    public AbsTaskWrapper mTaskWrapper;
    public String TAG = CommonUtil.getClassName((Class) getClass());
    public boolean isStop = false;
    public boolean isCancel = false;
    public AbsGroupLoader mLoader = getLoader();

    public AbsGroupLoaderUtil(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        this.mTaskWrapper = absTaskWrapper;
        this.mListener = iEventListener;
    }

    public abstract LoaderStructure buildLoaderStructure();

    @Override // com.arialyy.aria.core.inf.IUtil
    public void cancel() {
        this.isCancel = true;
        this.mLoader.cancel();
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public long getCurrentLocation() {
        return this.mLoader.getCurrentProgress();
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public long getFileSize() {
        return this.mTaskWrapper.mo4442getEntity().getFileSize();
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public String getKey() {
        return this.mTaskWrapper.getKey();
    }

    public IEventListener getListener() {
        return this.mListener;
    }

    public abstract AbsGroupLoader getLoader();

    public AbsTaskWrapper getTaskWrapper() {
        return this.mTaskWrapper;
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public boolean isRunning() {
        return this.mLoader.isRunning();
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public void start() {
        if (this.isStop || this.isCancel) {
            ALog.m4185w(this.TAG, "启动组合任务失败，任务已停止或已取消");
            return;
        }
        this.mListener.onPre();
        buildLoaderStructure();
        new Thread(this.mLoader).start();
    }

    public void startSubTask(String str) {
        getLoader().startSubTask(str);
    }

    @Override // com.arialyy.aria.core.inf.IUtil
    public void stop() {
        this.isStop = true;
        this.mLoader.stop();
    }

    public void stopSubTask(String str) {
        getLoader().stopSubTask(str);
    }
}
