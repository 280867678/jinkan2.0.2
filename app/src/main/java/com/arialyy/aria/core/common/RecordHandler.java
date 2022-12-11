package com.arialyy.aria.core.common;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.core.wrapper.RecordWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DbDataHelper;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class RecordHandler implements IRecordHandler {
    public final String TAG = CommonUtil.getClassName(this);
    @Deprecated
    public File mConfigFile;
    public AbsNormalEntity mEntity;
    public String mFilePath;
    public long mFileSize;
    public TaskRecord mTaskRecord;
    public AbsTaskWrapper mTaskWrapper;

    public RecordHandler(AbsTaskWrapper absTaskWrapper) {
        this.mTaskWrapper = absTaskWrapper;
        this.mEntity = (AbsNormalEntity) absTaskWrapper.mo4442getEntity();
    }

    private void convertDb() {
        String str;
        String str2;
        List findRelationData = DbEntity.findRelationData(RecordWrapper.class, "TaskRecord.filePath=?", getFilePath());
        if (findRelationData == null || findRelationData.size() == 0) {
            Properties loadConfig = FileUtil.loadConfig(this.mConfigFile);
            if (loadConfig.isEmpty()) {
                str = this.TAG;
                str2 = "老版本的线程记录为空，任务为新任务";
            } else {
                Set<Object> keySet = loadConfig.keySet();
                HashSet hashSet = new HashSet();
                for (Object obj : keySet) {
                    String valueOf = String.valueOf(obj);
                    hashSet.add(Integer.valueOf(Integer.parseInt(valueOf.substring(valueOf.length() - 1))));
                }
                int size = hashSet.size();
                if (size != 0) {
                    this.mTaskWrapper.setNewTask(false);
                    TaskRecord createTaskRecord = createTaskRecord(size);
                    this.mTaskRecord = createTaskRecord;
                    createTaskRecord.isBlock = false;
                    File file = new File(getFilePath());
                    for (int i = 0; i < size; i++) {
                        ThreadRecord threadRecord = new ThreadRecord();
                        threadRecord.taskKey = this.mTaskRecord.filePath;
                        String property = loadConfig.getProperty(file.getName() + IRecordHandler.STATE + i);
                        String property2 = loadConfig.getProperty(file.getName() + IRecordHandler.RECORD + i);
                        if (property == null || Integer.parseInt(property) != 1) {
                            long j = 0;
                            if (property2 != null) {
                                long parseLong = Long.parseLong(property2);
                                if (parseLong > 0) {
                                    j = parseLong;
                                }
                            }
                            threadRecord.startLocation = j;
                            this.mTaskRecord.threadRecords.add(threadRecord);
                        } else {
                            threadRecord.isComplete = true;
                        }
                    }
                    FileUtil.deleteFile(this.mConfigFile);
                    return;
                }
                str = this.TAG;
                str2 = "线程数为空，任务为新任务";
            }
            ALog.m4192d(str, str2);
            initRecord(true);
        }
    }

    private String getFilePath() {
        return this.mEntity instanceof DownloadEntity ? ((DownloadEntity) this.mTaskWrapper.mo4442getEntity()).getFilePath() : ((UploadEntity) this.mTaskWrapper.mo4442getEntity()).getFilePath();
    }

    private void initRecord(boolean z) {
        if (z) {
            this.mTaskRecord = createTaskRecord(initTaskThreadNum());
        }
        this.mTaskWrapper.setNewTask(true);
        if (this.mTaskWrapper.getRequestType() == 8) {
            return;
        }
        long fileSize = getFileSize() / this.mTaskRecord.threadNum;
        int i = 0;
        while (true) {
            TaskRecord taskRecord = this.mTaskRecord;
            if (i >= taskRecord.threadNum) {
                return;
            }
            int i2 = i + 1;
            this.mTaskRecord.threadRecords.add(createThreadRecord(taskRecord, i, i * fileSize, i2 * fileSize));
            i = i2;
        }
    }

    private void saveRecord() {
        TaskRecord taskRecord = this.mTaskRecord;
        taskRecord.threadNum = taskRecord.threadRecords.size();
        this.mTaskRecord.save();
        List<ThreadRecord> list = this.mTaskRecord.threadRecords;
        if (list != null && !list.isEmpty()) {
            DbEntity.saveAll(this.mTaskRecord.threadRecords);
        }
        ALog.m4192d(this.TAG, String.format("保存记录，线程记录数：%s", Integer.valueOf(this.mTaskRecord.threadRecords.size())));
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public boolean checkTaskCompleted() {
        List<ThreadRecord> list;
        TaskRecord taskRecord = this.mTaskRecord;
        if (taskRecord == null || (list = taskRecord.threadRecords) == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        for (ThreadRecord threadRecord : this.mTaskRecord.threadRecords) {
            if (threadRecord.isComplete) {
                i++;
            }
        }
        return i != 0 && i == this.mTaskRecord.threadNum;
    }

    public AbsNormalEntity getEntity() {
        return this.mEntity;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public TaskRecord getRecord(long j) {
        this.mFileSize = j;
        File file = new File(CommonUtil.getFileConfigPath(false, this.mEntity.getFileName()));
        this.mConfigFile = file;
        if (file.exists()) {
            convertDb();
        } else {
            onPre();
            TaskRecord taskRecord = DbDataHelper.getTaskRecord(getFilePath(), this.mEntity.getTaskType());
            this.mTaskRecord = taskRecord;
            if (taskRecord == null) {
                initRecord(true);
            } else {
                List<ThreadRecord> list = taskRecord.threadRecords;
                if (list == null || list.size() == 0) {
                    TaskRecord taskRecord2 = this.mTaskRecord;
                    if (taskRecord2.threadRecords == null) {
                        taskRecord2.threadRecords = new ArrayList();
                    }
                    initRecord(false);
                }
            }
            handlerTaskRecord(this.mTaskRecord);
        }
        saveRecord();
        return this.mTaskRecord;
    }

    public AbsTaskWrapper getWrapper() {
        return this.mTaskWrapper;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public void onPre() {
    }
}
