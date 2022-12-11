package com.arialyy.aria.core.loader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class GroupSubThreadStateManager implements IThreadStateManager {
    public Handler mHandler;
    public String mKey;
    public Looper mLooper;
    public long mProgress;
    public TaskRecord mTaskRecord;
    public int mThreadNum;
    public final String TAG = CommonUtil.getClassName(this);
    public AtomicInteger mCancelNum = new AtomicInteger(0);
    public AtomicInteger mStopNum = new AtomicInteger(0);
    public AtomicInteger mFailNum = new AtomicInteger(0);
    public AtomicInteger mCompleteNum = new AtomicInteger(0);
    public Handler.Callback callback = new Handler.Callback() { // from class: com.arialyy.aria.core.loader.GroupSubThreadStateManager.1
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
            if (r6.this$0.isFail() != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00bb, code lost:
            if (r6.this$0.isCancel() != false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00e9, code lost:
            r6.this$0.quitLooper();
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cd, code lost:
            if (r6.this$0.isFail() != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00e7, code lost:
            if (r6.this$0.isStop() != false) goto L26;
         */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleMessage(Message message) {
            GroupSubThreadStateManager.this.checkLooper();
            switch (message.what) {
                case 1:
                    GroupSubThreadStateManager.this.mStopNum.getAndIncrement();
                    break;
                case 2:
                    GroupSubThreadStateManager.this.mFailNum.getAndIncrement();
                    break;
                case 3:
                    GroupSubThreadStateManager.this.mCancelNum.getAndIncrement();
                    break;
                case 4:
                    GroupSubThreadStateManager.this.mCompleteNum.getAndIncrement();
                    if (!GroupSubThreadStateManager.this.isComplete()) {
                        break;
                    } else {
                        String str = GroupSubThreadStateManager.this.TAG;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("isComplete, completeNum = ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(GroupSubThreadStateManager.this.mCompleteNum);
                        ALog.m4192d(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        if (GroupSubThreadStateManager.this.mTaskRecord.isBlock && !GroupSubThreadStateManager.this.mergeFile()) {
                            Bundle data = message.getData();
                            data.putBoolean(IThreadStateManager.DATA_RETRY, false);
                            message.setData(data);
                            message.what = 2;
                            sendMessageFromMsg(message);
                        }
                    }
                    sendMessageFromMsg(message);
                    GroupSubThreadStateManager.this.quitLooper();
                    break;
                case 5:
                    Bundle data2 = message.getData();
                    if (data2 != null) {
                        GroupSubThreadStateManager.this.mProgress += data2.getLong(IThreadStateManager.DATA_ADD_LEN, 0L);
                    }
                    message.obj = Long.valueOf(GroupSubThreadStateManager.this.mProgress);
                    sendMessageFromMsg(message);
                    break;
                case 6:
                    Object obj = message.obj;
                    if (obj == null) {
                        GroupSubThreadStateManager groupSubThreadStateManager = GroupSubThreadStateManager.this;
                        groupSubThreadStateManager.mProgress = groupSubThreadStateManager.updateBlockProgress();
                    } else if (obj instanceof Long) {
                        GroupSubThreadStateManager.this.mProgress = ((Long) obj).longValue();
                    }
                    message.obj = Long.valueOf(GroupSubThreadStateManager.this.mProgress);
                    sendMessageFromMsg(message);
                    break;
            }
            return false;
        }

        public void sendMessageFromMsg(Message message) {
            Message obtainMessage = GroupSubThreadStateManager.this.mHandler.obtainMessage();
            Bundle data = obtainMessage.getData();
            data.putString(IThreadStateManager.DATA_THREAD_NAME, GroupSubThreadStateManager.this.mKey);
            message.setData(data);
            obtainMessage.copyFrom(message);
            GroupSubThreadStateManager.this.mHandler.sendMessage(obtainMessage);
        }
    };

    public GroupSubThreadStateManager(Handler handler, String str) {
        this.mHandler = handler;
        this.mKey = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLooper() {
        if (this.mTaskRecord != null) {
            if (this.mLooper == null) {
                throw new NullPointerException("Looper为空");
            }
            return;
        }
        throw new NullPointerException("任务记录为空");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mergeFile() {
        if (this.mTaskRecord.threadNum == 1) {
            return new File(String.format(IRecordHandler.SUB_PATH, this.mTaskRecord.filePath, 0)).renameTo(new File(this.mTaskRecord.filePath));
        }
        ArrayList arrayList = new ArrayList();
        int i = this.mTaskRecord.threadNum;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(IRecordHandler.SUB_PATH, this.mTaskRecord.filePath, Integer.valueOf(i2)));
        }
        if (!FileUtil.mergeFile(this.mTaskRecord.filePath, arrayList)) {
            ALog.m4191e(this.TAG, "合并失败");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FileUtil.deleteFile((String) it.next());
        }
        File file = new File(this.mTaskRecord.filePath);
        if (!file.exists() || file.length() <= this.mTaskRecord.fileLength) {
            return true;
        }
        ALog.m4191e(this.TAG, String.format("任务【%s】分块文件合并失败，下载长度超出文件真实长度，downloadLen: %s，fileSize: %s", file.getName(), Long.valueOf(file.length()), Long.valueOf(this.mTaskRecord.fileLength)));
        return false;
    }

    private boolean mergerSFtp() {
        if (this.mTaskRecord.threadNum == 1) {
            return new File(String.format(IRecordHandler.SUB_PATH, this.mTaskRecord.filePath, 0)).renameTo(new File(this.mTaskRecord.filePath));
        }
        ArrayList arrayList = new ArrayList();
        int i = this.mTaskRecord.threadNum;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(IRecordHandler.SUB_PATH, this.mTaskRecord.filePath, Integer.valueOf(i2)));
        }
        TaskRecord taskRecord = this.mTaskRecord;
        FileUtil.mergeSFtpFile(taskRecord.filePath, arrayList, taskRecord.fileLength);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FileUtil.deleteFile((String) it.next());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitLooper() {
        this.mLooper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long updateBlockProgress() {
        int size = this.mTaskRecord.threadRecords.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            File file = new File(String.format(IRecordHandler.SUB_PATH, this.mTaskRecord.filePath, Integer.valueOf(i)));
            if (file.exists()) {
                j = file.length() + j;
            }
        }
        return j;
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
        return this.callback;
    }

    public boolean isCancel() {
        return this.mCancelNum.get() == this.mThreadNum;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public boolean isComplete() {
        return this.mCompleteNum.get() == this.mThreadNum;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public boolean isFail() {
        if (this.mCompleteNum.get() != this.mThreadNum) {
            if (this.mFailNum.get() != this.mThreadNum) {
                if (this.mCompleteNum.get() + this.mFailNum.get() == this.mThreadNum) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean isStop() {
        if (this.mStopNum.get() != this.mThreadNum) {
            if (this.mCompleteNum.get() + this.mStopNum.get() != this.mThreadNum) {
                return false;
            }
        }
        return true;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public void setLooper(TaskRecord taskRecord, Looper looper) {
        this.mTaskRecord = taskRecord;
        this.mThreadNum = taskRecord.threadNum;
        this.mLooper = looper;
    }

    @Override // com.arialyy.aria.core.inf.IThreadStateManager
    public void updateCurrentProgress(long j) {
        this.mProgress = j;
    }
}
