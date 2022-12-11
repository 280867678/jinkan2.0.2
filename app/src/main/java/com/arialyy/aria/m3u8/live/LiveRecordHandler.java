package com.arialyy.aria.m3u8.live;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.RecordHandler;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.m3u8.M3U8TaskOption;
import com.arialyy.aria.util.DeleteM3u8Record;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class LiveRecordHandler extends RecordHandler {
    public M3U8TaskOption mOption;

    public LiveRecordHandler(AbsTaskWrapper absTaskWrapper) {
        super(absTaskWrapper);
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public TaskRecord createTaskRecord(int i) {
        TaskRecord taskRecord = new TaskRecord();
        taskRecord.fileName = getEntity().getFileName();
        taskRecord.filePath = getEntity().getFilePath();
        taskRecord.threadRecords = new ArrayList();
        taskRecord.threadNum = i;
        taskRecord.isBlock = true;
        taskRecord.taskType = 8;
        taskRecord.bandWidth = this.mOption.getBandWidth();
        return taskRecord;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    @Deprecated
    public ThreadRecord createThreadRecord(TaskRecord taskRecord, int i, long j, long j2) {
        return null;
    }

    public ThreadRecord createThreadRecord(TaskRecord taskRecord, String str, int i) {
        ThreadRecord threadRecord = new ThreadRecord();
        threadRecord.taskKey = taskRecord.filePath;
        threadRecord.isComplete = false;
        threadRecord.tsUrl = str;
        threadRecord.threadType = taskRecord.taskType;
        threadRecord.threadId = i;
        threadRecord.startLocation = 0L;
        taskRecord.threadRecords.add(threadRecord);
        return threadRecord;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    @Deprecated
    public void handlerTaskRecord(TaskRecord taskRecord) {
        if (taskRecord.threadRecords == null) {
            taskRecord.threadRecords = new ArrayList();
        }
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public int initTaskThreadNum() {
        return 1;
    }

    @Override // com.arialyy.aria.core.common.RecordHandler, com.arialyy.aria.core.loader.IRecordHandler
    public void onPre() {
        super.onPre();
        DeleteM3u8Record.getInstance().deleteRecord(getEntity().getFilePath(), true, true);
    }

    public void setOption(M3U8TaskOption m3U8TaskOption) {
        this.mOption = m3U8TaskOption;
    }
}
