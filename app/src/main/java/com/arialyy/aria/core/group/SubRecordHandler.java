package com.arialyy.aria.core.group;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.RecordHandler;
import com.arialyy.aria.core.common.RecordHelper;
import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.RecordUtil;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SubRecordHandler extends RecordHandler {
    public SubRecordHandler(AbsTaskWrapper absTaskWrapper) {
        super(absTaskWrapper);
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public TaskRecord createTaskRecord(int i) {
        TaskRecord taskRecord = new TaskRecord();
        taskRecord.fileName = getEntity().getFileName();
        taskRecord.filePath = getEntity().getFilePath();
        taskRecord.threadRecords = new ArrayList();
        taskRecord.threadNum = i;
        int requestType = getWrapper().getRequestType();
        taskRecord.isBlock = (requestType == 1 || requestType == 2) ? Configuration.getInstance().downloadCfg.isUseBlock() : false;
        taskRecord.taskType = requestType;
        boolean isGroupChild = getEntity().isGroupChild();
        taskRecord.isGroupRecord = isGroupChild;
        if (isGroupChild && (getEntity() instanceof DownloadEntity)) {
            taskRecord.dGroupHash = ((DownloadEntity) getEntity()).getGroupHash();
        }
        return taskRecord;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public ThreadRecord createThreadRecord(TaskRecord taskRecord, int i, long j, long j2) {
        ThreadRecord threadRecord = new ThreadRecord();
        threadRecord.taskKey = taskRecord.filePath;
        threadRecord.threadId = i;
        threadRecord.startLocation = j;
        threadRecord.isComplete = false;
        threadRecord.threadType = taskRecord.taskType;
        if (i == taskRecord.threadNum - 1) {
            j2 = getFileSize();
        }
        threadRecord.endLocation = j2;
        threadRecord.blockLen = RecordUtil.getBlockLen(getFileSize(), i, taskRecord.threadNum);
        return threadRecord;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public void handlerTaskRecord(TaskRecord taskRecord) {
        RecordHelper recordHelper = new RecordHelper(getWrapper(), taskRecord);
        if (!getWrapper().isSupportBP() || taskRecord.threadNum <= 1) {
            if (!getWrapper().isSupportBP()) {
                recordHelper.handleNoSupportBPRecord();
            } else {
                recordHelper.handleSingleThreadRecord();
            }
        } else if (taskRecord.isBlock) {
            recordHelper.handleBlockRecord();
        } else {
            recordHelper.handleMultiRecord();
        }
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public int initTaskThreadNum() {
        int requestType = getWrapper().getRequestType();
        if (requestType != 5) {
            if (requestType == 1 && !getWrapper().isSupportBP()) {
                return 1;
            }
            int threadNum = Configuration.getInstance().downloadCfg.getThreadNum();
            if (getFileSize() > 1048576) {
                return threadNum;
            }
            return 1;
        }
        return 1;
    }
}
