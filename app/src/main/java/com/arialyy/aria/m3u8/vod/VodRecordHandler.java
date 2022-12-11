package com.arialyy.aria.m3u8.vod;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.RecordHandler;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.m3u8.BaseM3U8Loader;
import com.arialyy.aria.m3u8.M3U8InfoTask;
import com.arialyy.aria.m3u8.M3U8TaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class VodRecordHandler extends RecordHandler {
    public M3U8TaskOption mOption;

    public VodRecordHandler(DTaskWrapper dTaskWrapper) {
        super(dTaskWrapper);
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public TaskRecord createTaskRecord(int i) {
        TaskRecord taskRecord = new TaskRecord();
        taskRecord.fileName = getEntity().getFileName();
        taskRecord.filePath = getEntity().getFilePath();
        taskRecord.threadRecords = new ArrayList();
        taskRecord.threadNum = i;
        taskRecord.isBlock = true;
        taskRecord.taskType = 7;
        taskRecord.bandWidth = this.mOption.getBandWidth();
        return taskRecord;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public ThreadRecord createThreadRecord(TaskRecord taskRecord, int i, long j, long j2) {
        ThreadRecord threadRecord = new ThreadRecord();
        threadRecord.taskKey = taskRecord.filePath;
        threadRecord.threadId = i;
        threadRecord.isComplete = false;
        threadRecord.startLocation = 0L;
        threadRecord.threadType = taskRecord.taskType;
        threadRecord.tsUrl = this.mOption.getUrls().get(i);
        return threadRecord;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public void handlerTaskRecord(TaskRecord taskRecord) {
        String cacheDir = this.mOption.getCacheDir();
        boolean z = ((DownloadEntity) getEntity()).getM3U8Entity().getPeerNum() <= 0 || (this.mOption.isGenerateIndexFile() && !new File(String.format(M3U8InfoTask.M3U8_INDEX_FORMAT, getEntity().getFilePath())).exists());
        long j = 0;
        int i = 0;
        for (ThreadRecord threadRecord : taskRecord.threadRecords) {
            File file = new File(BaseM3U8Loader.getTsFilePath(cacheDir, threadRecord.threadId));
            if (!threadRecord.isComplete || z) {
                if (file.exists()) {
                    FileUtil.deleteFile(file);
                }
                threadRecord.startLocation = 0L;
            } else if (!file.exists()) {
                threadRecord.startLocation = 0L;
                threadRecord.isComplete = false;
                ALog.m4185w(this.TAG, String.format("分片【%s】不存在，将重新下载该分片", Integer.valueOf(threadRecord.threadId)));
            } else {
                i++;
                j += file.length();
            }
        }
        this.mOption.setCompleteNum(i);
        getEntity().setCurrentProgress(j);
        taskRecord.bandWidth = this.mOption.getBandWidth();
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public int initTaskThreadNum() {
        if (getWrapper().getRequestType() != 7) {
            return getWrapper().getRequestType() == 8 ? 1 : 0;
        } else if (this.mOption.getUrls() != null && !this.mOption.getUrls().isEmpty()) {
            return this.mOption.getUrls().size();
        } else {
            return 1;
        }
    }

    public void setOption(M3U8TaskOption m3U8TaskOption) {
        this.mOption = m3U8TaskOption;
    }
}
