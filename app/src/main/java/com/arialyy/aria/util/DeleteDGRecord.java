package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.wrapper.RecordWrapper;
import com.arialyy.aria.orm.DbEntity;
import java.util.List;

/* loaded from: classes3.dex */
public class DeleteDGRecord implements IDeleteRecord {
    public static volatile DeleteDGRecord INSTANCE;
    public String TAG = CommonUtil.getClassName(this);

    public static DeleteDGRecord getInstance() {
        if (INSTANCE == null) {
            synchronized (DeleteDGRecord.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeleteDGRecord();
                }
            }
        }
        return INSTANCE;
    }

    private void removeBlockFile(TaskRecord taskRecord) {
        int i = taskRecord.threadNum;
        for (int i2 = 0; i2 < i; i2++) {
            FileUtil.deleteFile(String.format(IRecordHandler.SUB_PATH, taskRecord.filePath, Integer.valueOf(i2)));
        }
    }

    @Override // com.arialyy.aria.util.IDeleteRecord
    public void deleteRecord(AbsEntity absEntity, boolean z, boolean z2) {
        TaskRecord taskRecord;
        if (absEntity == null) {
            ALog.m4191e(this.TAG, "删除组合任务记录失败，组合任务实体为空");
            return;
        }
        DownloadGroupEntity downloadGroupEntity = (DownloadGroupEntity) absEntity;
        List<RecordWrapper> findRelationData = DbEntity.findRelationData(RecordWrapper.class, "dGroupHash=?", downloadGroupEntity.getGroupHash());
        if (findRelationData == null || findRelationData.isEmpty()) {
            ALog.m4185w(this.TAG, "组任务记录已删除");
        } else {
            for (RecordWrapper recordWrapper : findRelationData) {
                if (recordWrapper != null && (taskRecord = recordWrapper.taskRecord) != null) {
                    if (taskRecord.isBlock) {
                        removeBlockFile(taskRecord);
                    }
                    DbEntity.deleteData(ThreadRecord.class, "taskKey=?", recordWrapper.taskRecord.filePath);
                    recordWrapper.taskRecord.deleteData();
                }
            }
        }
        List<DownloadEntity> subEntities = downloadGroupEntity.getSubEntities();
        if (subEntities != null) {
            for (DownloadEntity downloadEntity : subEntities) {
                if (z || !downloadGroupEntity.isComplete()) {
                    FileUtil.deleteFile(downloadEntity.getFilePath());
                }
            }
        }
        if (!TextUtils.isEmpty(downloadGroupEntity.getDirPath()) && (z || !downloadGroupEntity.isComplete())) {
            FileUtil.deleteFile(downloadGroupEntity.getDirPath());
        }
        if (!z2) {
            return;
        }
        DbEntity.deleteData(DownloadEntity.class, "groupHash=?", downloadGroupEntity.getGroupHash());
        DbEntity.deleteData(DownloadGroupEntity.class, "groupHash=?", downloadGroupEntity.getGroupHash());
    }

    @Override // com.arialyy.aria.util.IDeleteRecord
    public void deleteRecord(String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(this.TAG, "删除下载任务组记录失败，组合任务路径为空");
        } else {
            deleteRecord(DbDataHelper.getDGEntityByPath(str), z, z2);
        }
    }
}
