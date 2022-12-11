package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;

/* loaded from: classes3.dex */
public class DTaskWrapperFactory implements INormalTEFactory<DownloadEntity, DTaskWrapper> {
    public static volatile DTaskWrapperFactory INSTANCE;
    public final String TAG = "DTaskWrapperFactory";

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        if (r5 == r2.threadNum) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (r2.taskType != 7) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DownloadEntity getEntity(long j) {
        DownloadEntity downloadEntity = (DownloadEntity) DbEntity.findFirst(DownloadEntity.class, "rowid=? and isGroupChild='false'", String.valueOf(j));
        if (downloadEntity == null) {
            return new DownloadEntity();
        }
        File file = new File(downloadEntity.getFilePath());
        if (!downloadEntity.isComplete()) {
            TaskRecord taskRecord = (TaskRecord) DbEntity.findFirst(TaskRecord.class, "filePath=?", downloadEntity.getFilePath());
            if (taskRecord != null) {
                if (taskRecord.isBlock) {
                    int i = taskRecord.threadNum;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        if (!new File(String.format(IRecordHandler.SUB_PATH, taskRecord.filePath, Integer.valueOf(i3))).exists()) {
                            i2++;
                        }
                    }
                } else if (!file.exists()) {
                }
            }
            resetEntity(downloadEntity);
        }
        return downloadEntity;
    }

    public static DTaskWrapperFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (DTaskWrapperFactory.class) {
                INSTANCE = new DTaskWrapperFactory();
            }
        }
        return INSTANCE;
    }

    private void resetEntity(DownloadEntity downloadEntity) {
        downloadEntity.setPercent(downloadEntity.getPercent());
        downloadEntity.setCompleteTime(0L);
        downloadEntity.setComplete(false);
        downloadEntity.setCurrentProgress(0L);
        downloadEntity.setState(3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.arialyy.aria.core.manager.INormalTEFactory
    /* renamed from: create */
    public DTaskWrapper mo4431create(long j) {
        DTaskWrapper dTaskWrapper = j == -1 ? new DTaskWrapper(new DownloadEntity()) : new DTaskWrapper(getEntity(j));
        dTaskWrapper.setRequestType(dTaskWrapper.mo4442getEntity().getTaskType());
        return dTaskWrapper;
    }
}
