package com.arialyy.aria.m3u8.live;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.m3u8.M3U8InfoTask;
import com.arialyy.aria.m3u8.M3U8Listener;
import com.arialyy.aria.m3u8.M3U8TaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class LiveStateManager implements IThreadStateManager {
    public final String TAG = CommonUtil.getClassName(LiveStateManager.class);
    public Handler.Callback mCallback = new Handler.Callback() { // from class: com.arialyy.aria.m3u8.live.LiveStateManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String str;
            String str2;
            Bundle data;
            int i = message.getData().getInt(ISchedulers.DATA_M3U8_PEER_INDEX);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    LiveStateManager.this.mLoader.notifyLock(false, i);
                    LiveStateManager.this.mListener.onPeerFail(LiveStateManager.this.mTaskWrapper.getKey(), message.getData().getString(ISchedulers.DATA_M3U8_PEER_PATH), i);
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        LiveStateManager.this.mLoader.notifyLock(true, i);
                        if (LiveStateManager.this.mM3U8Option.isGenerateIndexFile() && !LiveStateManager.this.mLoader.isBreak()) {
                            LiveStateManager liveStateManager = LiveStateManager.this;
                            liveStateManager.addExtInf(liveStateManager.mLoader.getCurExtInfo().url, LiveStateManager.this.mLoader.getCurExtInfo().extInf);
                        }
                        LiveStateManager.this.mListener.onPeerComplete(LiveStateManager.this.mTaskWrapper.getKey(), message.getData().getString(ISchedulers.DATA_M3U8_PEER_PATH), i);
                    } else if (i2 == 5 && (data = message.getData()) != null) {
                        LiveStateManager.this.mProgress += data.getLong(IThreadStateManager.DATA_ADD_LEN, 0L);
                    }
                } else if (LiveStateManager.this.mLoader.isBreak()) {
                    str = LiveStateManager.this.TAG;
                    str2 = "任务取消";
                    ALog.m4192d(str, str2);
                    LiveStateManager.this.quitLooper();
                }
            } else if (LiveStateManager.this.mLoader.isBreak()) {
                str = LiveStateManager.this.TAG;
                str2 = "任务停止";
                ALog.m4192d(str, str2);
                LiveStateManager.this.quitLooper();
            }
            return true;
        }
    };
    public FileOutputStream mIndexFos;
    public M3U8Listener mListener;
    public M3U8LiveLoader mLoader;
    public Looper mLooper;
    public M3U8TaskOption mM3U8Option;
    public long mProgress;
    public DTaskWrapper mTaskWrapper;

    public LiveStateManager(DTaskWrapper dTaskWrapper, IEventListener iEventListener) {
        this.mTaskWrapper = dTaskWrapper;
        this.mListener = (M3U8Listener) iEventListener;
        this.mM3U8Option = (M3U8TaskOption) dTaskWrapper.getM3u8Option();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExtInf(String str, String str2) {
        File file = new File(String.format(M3U8InfoTask.M3U8_INDEX_FORMAT, this.mTaskWrapper.mo4442getEntity().getFilePath()));
        if (!file.exists()) {
            ALog.m4191e(this.TAG, String.format("索引文件【%s】不存在，添加peer的extInf失败", file.getPath()));
            return;
        }
        try {
            if (this.mIndexFos == null) {
                this.mIndexFos = new FileOutputStream(file, true);
            }
            this.mIndexFos.write(str2.concat("\r\n").getBytes(Charset.forName("UTF-8")));
            this.mIndexFos.write(str.concat("\r\n").getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitLooper() {
        ALog.m4192d(this.TAG, "quitLooper");
        this.mLooper.quit();
        FileOutputStream fileOutputStream = this.mIndexFos;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public long getCurrentProgress() {
        return this.mProgress;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public Handler.Callback getHandlerCallback() {
        return this.mCallback;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public boolean isComplete() {
        return false;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public boolean isFail() {
        return false;
    }

    public void setLoader(M3U8LiveLoader m3U8LiveLoader) {
        this.mLoader = m3U8LiveLoader;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public void setLooper(TaskRecord taskRecord, Looper looper) {
        this.mLooper = looper;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public void updateCurrentProgress(long j) {
        this.mProgress = j;
    }
}
