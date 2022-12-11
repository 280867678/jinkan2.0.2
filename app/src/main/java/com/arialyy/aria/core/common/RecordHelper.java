package com.arialyy.aria.core.common;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.BufferedRandomAccessFile;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class RecordHelper {
    public String TAG = CommonUtil.getClassName(RecordHelper.class);
    public TaskRecord mTaskRecord;
    public AbsTaskWrapper mWrapper;

    public RecordHelper(AbsTaskWrapper absTaskWrapper, TaskRecord taskRecord) {
        this.mWrapper = absTaskWrapper;
        this.mTaskRecord = taskRecord;
    }

    private void createPlaceHolderFile(File file) {
        try {
            new BufferedRandomAccessFile(file, "rw").setLength(this.mWrapper.mo4442getEntity().getFileSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleBlockRecord() {
        long fileSize = this.mWrapper.mo4442getEntity().getFileSize() / this.mTaskRecord.threadRecords.size();
        for (ThreadRecord threadRecord : this.mTaskRecord.threadRecords) {
            long j = threadRecord.blockLen;
            File file = new File(String.format(IRecordHandler.SUB_PATH, this.mTaskRecord.filePath, Integer.valueOf(threadRecord.threadId)));
            if (!file.exists()) {
                ALog.m4189i(this.TAG, String.format("分块文件【%s】不存在，该分块将重新开始", file.getPath()));
                threadRecord.isComplete = false;
                threadRecord.startLocation = threadRecord.threadId * fileSize;
            } else if (!threadRecord.isComplete) {
                ALog.m4189i(this.TAG, String.format("startLocation = %s; endLocation = %s; block = %s; tempLen = %s; threadId = %s", Long.valueOf(threadRecord.startLocation), Long.valueOf(threadRecord.endLocation), Long.valueOf(j), Long.valueOf(file.length()), Integer.valueOf(threadRecord.threadId)));
                long length = file.length();
                int i = (length > j ? 1 : (length == j ? 0 : -1));
                if (i > 0) {
                    ALog.m4189i(this.TAG, String.format("分块【%s】错误，分块长度【%s】 > 线程区间长度【%s】，将重新开始该分块", Integer.valueOf(threadRecord.threadId), Long.valueOf(length), Long.valueOf(j)));
                    file.delete();
                    threadRecord.startLocation = threadRecord.threadId * j;
                } else {
                    long j2 = (threadRecord.threadId * fileSize) + length;
                    if (i != 0 || length == 0) {
                        int i2 = (threadRecord.startLocation > j2 ? 1 : (threadRecord.startLocation == j2 ? 0 : -1));
                        String str = this.TAG;
                        Object[] objArr = new Object[2];
                        String path = file.getPath();
                        if (i2 != 0) {
                            objArr[0] = path;
                            objArr[1] = Long.valueOf(j2);
                            ALog.m4189i(str, String.format("修正分块【%s】的进度记录为：%s", objArr));
                            threadRecord.startLocation = j2;
                        } else {
                            objArr[0] = path;
                            objArr[1] = Long.valueOf(j2);
                            ALog.m4189i(str, String.format("修正分块【%s】的进度记录为：%s", objArr));
                            threadRecord.startLocation = j2;
                            threadRecord.isComplete = false;
                        }
                    } else {
                        ALog.m4189i(this.TAG, String.format("分块【%s】已完成，更新记录", file.getPath()));
                        threadRecord.startLocation = length;
                        threadRecord.isComplete = true;
                    }
                }
            } else {
                ALog.m4189i(this.TAG, String.format("分块【%s】已完成", file.getPath()));
            }
        }
        this.mWrapper.setNewTask(false);
    }

    public void handleMultiRecord() {
        boolean z;
        long fileSize = this.mWrapper.mo4442getEntity().getFileSize() / this.mTaskRecord.threadRecords.size();
        File file = new File(this.mTaskRecord.filePath);
        if (!file.exists()) {
            createPlaceHolderFile(file);
            z = false;
        } else {
            if (file.length() != this.mWrapper.mo4442getEntity().getFileSize()) {
                FileUtil.deleteFile(file);
                createPlaceHolderFile(file);
            }
            z = true;
        }
        if (!z) {
            ALog.m4185w(this.TAG, String.format("文件【%s】被删除，重新分配线程区间", this.mTaskRecord.filePath));
            int i = 0;
            while (true) {
                TaskRecord taskRecord = this.mTaskRecord;
                if (i >= taskRecord.threadNum) {
                    break;
                }
                int i2 = i + 1;
                long j = i2 * fileSize;
                ThreadRecord threadRecord = taskRecord.threadRecords.get(i);
                threadRecord.startLocation = i * fileSize;
                threadRecord.isComplete = false;
                if (threadRecord.threadId == this.mTaskRecord.threadNum - 1) {
                    j = this.mWrapper.mo4442getEntity().getFileSize();
                }
                threadRecord.endLocation = j;
                i = i2;
            }
        }
        this.mWrapper.setNewTask(false);
    }

    public void handleNoSupportBPRecord() {
        ThreadRecord threadRecord = this.mTaskRecord.threadRecords.get(0);
        threadRecord.startLocation = 0L;
        long fileSize = this.mWrapper.mo4442getEntity().getFileSize();
        threadRecord.endLocation = fileSize;
        threadRecord.taskKey = this.mTaskRecord.filePath;
        threadRecord.blockLen = fileSize;
        threadRecord.isComplete = false;
    }

    public void handleSingleThreadRecord() {
        TaskRecord taskRecord = this.mTaskRecord;
        File file = new File(taskRecord.isBlock ? String.format(IRecordHandler.SUB_PATH, taskRecord.filePath, 0) : taskRecord.filePath);
        ThreadRecord threadRecord = this.mTaskRecord.threadRecords.get(0);
        if (!file.exists()) {
            File file2 = new File(this.mTaskRecord.filePath);
            if (!threadRecord.isComplete || !file2.exists() || file2.length() == 0 || file2.length() != this.mWrapper.mo4442getEntity().getFileSize()) {
                ALog.m4185w(this.TAG, String.format("文件【%s】不存在，任务将重新开始", file.getPath()));
                threadRecord.startLocation = 0L;
                threadRecord.isComplete = false;
                threadRecord.endLocation = this.mWrapper.mo4442getEntity().getFileSize();
            }
            threadRecord.isComplete = true;
        } else if (file.length() > this.mWrapper.mo4442getEntity().getFileSize()) {
            ALog.m4189i(this.TAG, String.format("文件【%s】错误，任务重新开始", file.getPath()));
            FileUtil.deleteFile(file);
            threadRecord.startLocation = 0L;
            threadRecord.isComplete = false;
            threadRecord.endLocation = this.mWrapper.mo4442getEntity().getFileSize();
        } else if (file.length() != 0 && file.length() == this.mWrapper.mo4442getEntity().getFileSize()) {
            ALog.m4192d(this.TAG, "文件长度一致，线程完成");
            threadRecord.isComplete = true;
        } else if (file.length() != threadRecord.startLocation) {
            ALog.m4189i(this.TAG, String.format("修正【%s】的进度记录为：%s", file.getPath(), Long.valueOf(file.length())));
            threadRecord.startLocation = file.length();
            threadRecord.isComplete = false;
        }
        this.mWrapper.setNewTask(false);
    }
}
