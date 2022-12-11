package com.arialyy.aria.m3u8.vod;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.listener.ISchedulers;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.processor.ITsMergeHandler;
import com.arialyy.aria.core.task.ThreadTask;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.exception.AriaM3U8Exception;
import com.arialyy.aria.m3u8.BaseM3U8Loader;
import com.arialyy.aria.m3u8.M3U8Listener;
import com.arialyy.aria.m3u8.M3U8TaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.o11;

/* loaded from: classes3.dex */
public final class VodStateManager implements IThreadStateManager {
    public M3U8Listener listener;
    public M3U8VodLoader loader;
    public Looper looper;
    public M3U8TaskOption m3U8Option;
    public long progress;
    public int startThreadNum;
    public TaskRecord taskRecord;
    public DTaskWrapper wrapper;
    public final String TAG = CommonUtil.getClassName(VodStateManager.class);
    public AtomicInteger cancelNum = new AtomicInteger(0);
    public AtomicInteger stopNum = new AtomicInteger(0);
    public AtomicInteger failNum = new AtomicInteger(0);
    public Handler.Callback callback = new Handler.Callback() { // from class: com.arialyy.aria.m3u8.vod.VodStateManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String str;
            String format;
            Bundle data;
            int i = message.getData().getInt(ISchedulers.DATA_M3U8_PEER_INDEX);
            int i2 = message.what;
            if (i2 == 1) {
                VodStateManager.this.stopNum.getAndIncrement();
                VodStateManager.this.removeSignThread((ThreadTask) message.obj);
                if (VodStateManager.this.loader.isJump() && ((VodStateManager.this.stopNum.get() == VodStateManager.this.loader.getCurrentFlagSize() || VodStateManager.this.loader.getCurrentFlagSize() == 0) && !VodStateManager.this.loader.isBreak())) {
                    VodStateManager.this.loader.resumeTask();
                    return true;
                }
                if (VodStateManager.this.loader.isBreak()) {
                    str = VodStateManager.this.TAG;
                    format = String.format("vod任务【%s】停止", VodStateManager.this.loader.getTempFile().getName());
                    ALog.m4192d(str, format);
                }
                return true;
            }
            if (i2 == 2) {
                VodStateManager.this.failNum.getAndIncrement();
                Iterator<ThreadRecord> it = VodStateManager.this.taskRecord.threadRecords.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ThreadRecord next = it.next();
                    if (next.threadId == i) {
                        VodStateManager.this.loader.getBeforePeer().put(i, next);
                        break;
                    }
                }
                VodStateManager.this.getListener().onPeerFail(VodStateManager.this.wrapper.getKey(), message.getData().getString(ISchedulers.DATA_M3U8_PEER_PATH), i);
                if (VodStateManager.this.isFail()) {
                    ALog.m4192d(VodStateManager.this.TAG, String.format("vod任务【%s】失败", VodStateManager.this.loader.getTempFile().getName()));
                    Bundle data2 = message.getData();
                    VodStateManager.this.listener.onFail(data2.getBoolean(IThreadStateManager.DATA_RETRY, true), (AriaException) data2.getSerializable(IThreadStateManager.DATA_ERROR_INFO));
                }
            } else if (i2 == 3) {
                VodStateManager.this.cancelNum.getAndIncrement();
                VodStateManager.this.removeSignThread((ThreadTask) message.obj);
                if (VodStateManager.this.loader.isBreak()) {
                    str = VodStateManager.this.TAG;
                    format = String.format("vod任务【%s】取消", VodStateManager.this.loader.getTempFile().getName());
                    ALog.m4192d(str, format);
                }
            } else if (i2 == 4) {
                if (VodStateManager.this.loader.isBreak()) {
                    VodStateManager.this.quitLooper();
                }
                VodStateManager.this.loader.setCompleteNum(VodStateManager.this.loader.getCompleteNum() + 1);
                if (VodStateManager.this.loader.isJump()) {
                    VodStateManager.this.loader.setCurrentFlagSize(VodStateManager.this.loader.getCurrentFlagSize() - 1);
                    if (VodStateManager.this.loader.getCurrentFlagSize() < 0) {
                        VodStateManager.this.loader.setCurrentFlagSize(0);
                    }
                }
                VodStateManager.this.removeSignThread((ThreadTask) message.obj);
                VodStateManager.this.getListener().onPeerComplete(VodStateManager.this.wrapper.getKey(), message.getData().getString(ISchedulers.DATA_M3U8_PEER_PATH), i);
                VodStateManager.this.handlerPercent();
                if (!VodStateManager.this.loader.isJump()) {
                    VodStateManager.this.loader.notifyWaitLock(true);
                }
                if (VodStateManager.this.isComplete()) {
                    ALog.m4192d(VodStateManager.this.TAG, String.format("startThreadNum = %s, stopNum = %s, cancelNum = %s, failNum = %s, completeNum = %s, flagQueueSize = %s", Integer.valueOf(VodStateManager.this.startThreadNum), VodStateManager.this.stopNum, VodStateManager.this.cancelNum, VodStateManager.this.failNum, Integer.valueOf(VodStateManager.this.loader.getCompleteNum()), Integer.valueOf(VodStateManager.this.loader.getCurrentFlagSize())));
                    ALog.m4192d(VodStateManager.this.TAG, String.format("vod任务【%s】完成", VodStateManager.this.loader.getTempFile().getName()));
                    if (VodStateManager.this.m3U8Option.isMergeFile()) {
                        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new DownloadCompleteEvent(VodStateManager.this.getEntity().getM3U8Entity().getLocalM3u8Path(), VodStateManager.this.taskRecord.filePath));
                        VodStateManager.this.mergeFile();
                    } else if (!VodStateManager.this.m3U8Option.isGenerateIndexFile() || VodStateManager.this.loader.generateIndexFile(false)) {
                        VodStateManager.this.listener.onComplete();
                    } else {
                        VodStateManager.this.listener.onFail(false, new AriaM3U8Exception(VodStateManager.this.TAG, "创建索引文件失败"));
                    }
                }
            } else if (i2 == 5 && (data = message.getData()) != null) {
                VodStateManager.this.progress += data.getLong(IThreadStateManager.DATA_ADD_LEN, 0L);
            }
            return true;
            VodStateManager.this.quitLooper();
            return true;
        }
    };

    public VodStateManager(DTaskWrapper dTaskWrapper, M3U8Listener m3U8Listener) {
        this.wrapper = dTaskWrapper;
        this.listener = m3U8Listener;
        this.m3U8Option = (M3U8TaskOption) dTaskWrapper.getM3u8Option();
        this.progress = dTaskWrapper.mo4442getEntity().getCurrentProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadEntity getEntity() {
        return this.wrapper.mo4442getEntity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M3U8Listener getListener() {
        return this.listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerPercent() {
        int completeNum = this.m3U8Option.getCompleteNum() + 1;
        this.m3U8Option.setCompleteNum(completeNum);
        getEntity().setPercent((completeNum * 100) / this.taskRecord.threadRecords.size());
        getEntity().update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFile() {
        new AsyncTask<Void, Void, Boolean>() { // from class: com.arialyy.aria.m3u8.vod.VodStateManager.2
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean mergeFile;
                File[] listFiles;
                ITsMergeHandler mergeHandler = VodStateManager.this.m3U8Option.getMergeHandler();
                String cacheDir = VodStateManager.this.loader.getCacheDir();
                ArrayList arrayList = new ArrayList();
                for (ThreadRecord threadRecord : VodStateManager.this.taskRecord.threadRecords) {
                    arrayList.add(BaseM3U8Loader.getTsFilePath(cacheDir, threadRecord.threadId));
                }
                if (mergeHandler != null) {
                    mergeFile = mergeHandler.merge(VodStateManager.this.getEntity().getM3U8Entity(), arrayList);
                    if (mergeHandler.getClass().isAnonymousClass()) {
                        VodStateManager.this.m3U8Option.setMergeHandler(null);
                    }
                } else {
                    mergeFile = FileUtil.mergeFile(VodStateManager.this.taskRecord.filePath, arrayList);
                }
                boolean z = false;
                if (mergeFile) {
                    for (File file : new File(cacheDir).listFiles()) {
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    File file2 = new File(cacheDir);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    z = true;
                } else {
                    ALog.m4191e(VodStateManager.this.TAG, "合并失败");
                }
                return Boolean.valueOf(z);
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) {
                super.onPostExecute((AsyncTaskC06882) bool);
                if (bool.booleanValue()) {
                    VodStateManager.this.listener.onComplete();
                } else {
                    VodStateManager.this.listener.onFail(false, null);
                }
            }
        }.execute(new Void[0]);
    }

    private void printInfo(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitLooper() {
        ALog.m4192d(this.TAG, "quitLooper");
        this.looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSignThread(ThreadTask threadTask) {
        this.loader.getTaskList().remove(threadTask);
        ThreadTaskManager.getInstance().removeSingleTaskThread(this.wrapper.getKey(), threadTask);
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public long getCurrentProgress() {
        return this.progress;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public Handler.Callback getHandlerCallback() {
        return this.callback;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public boolean isComplete() {
        if (this.m3U8Option.isIgnoreFailureTs()) {
            return this.failNum.get() + this.loader.getCompleteNum() >= this.taskRecord.threadRecords.size() && !this.loader.isJump();
        }
        return this.loader.getCompleteNum() == this.taskRecord.threadRecords.size() && !this.loader.isJump();
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public boolean isFail() {
        printInfo("isFail");
        return this.failNum.get() != 0 && this.failNum.get() == this.loader.getCurrentFlagSize() && !this.loader.isJump();
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public void setLooper(TaskRecord taskRecord, Looper looper) {
        this.looper = looper;
        this.taskRecord = taskRecord;
        for (ThreadRecord threadRecord : taskRecord.threadRecords) {
            if (!threadRecord.isComplete) {
                this.startThreadNum++;
            }
        }
    }

    public void setVodLoader(M3U8VodLoader m3U8VodLoader) {
        this.loader = m3U8VodLoader;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public void updateCurrentProgress(long j) {
        this.progress = j;
    }

    public void updateStateCount() {
        this.cancelNum.set(0);
        this.stopNum.set(0);
        this.failNum.set(0);
    }
}
