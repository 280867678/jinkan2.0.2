package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DeleteDRecord implements IDeleteRecord {
    public static volatile DeleteDRecord INSTANCE;
    public String TAG = CommonUtil.getClassName(this);

    public static DeleteDRecord getInstance() {
        if (INSTANCE == null) {
            synchronized (DeleteDRecord.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeleteDRecord();
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
        if (absEntity == null) {
            ALog.m4191e(this.TAG, "删除下载记录失败，实体为空");
            return;
        }
        DownloadEntity downloadEntity = (DownloadEntity) absEntity;
        String filePath = downloadEntity.getFilePath();
        File file = new File(filePath);
        if (downloadEntity.getTaskType() == 7 || downloadEntity.getTaskType() == 8) {
            DeleteM3u8Record.getInstance().deleteRecord(downloadEntity, z, z2);
            return;
        }
        TaskRecord taskRecord = DbDataHelper.getTaskRecord(downloadEntity.getFilePath(), downloadEntity.getTaskType());
        if (taskRecord == null) {
            String str = this.TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("删除下载记录失败，记录为空，filePath：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(downloadEntity.getFilePath());
            ALog.m4191e(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (z2 || !downloadEntity.isComplete()) {
            FileUtil.deleteFile(file);
            if (taskRecord.isBlock) {
                removeBlockFile(taskRecord);
            }
        }
        try {
            DbEntity.deleteData(ThreadRecord.class, "taskKey=? AND threadType=?", filePath, String.valueOf(downloadEntity.getTaskType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!z2) {
            return;
        }
        try {
            DbEntity.deleteData(DownloadEntity.class, "downloadPath=?", filePath);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.arialyy.aria.util.IDeleteRecord
    public void deleteRecord(String str, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException(String.format("文件路径错误，filePath：%s", str));
            }
            DownloadEntity downloadEntity = (DownloadEntity) DbEntity.findFirst(DownloadEntity.class, "downloadPath=?", str);
            if (downloadEntity != null) {
                deleteRecord(downloadEntity, z, z2);
                return;
            }
            String str2 = this.TAG;
            ALog.m4191e(str2, "删除下载记录失败，没有在数据库中找到对应的实体文件，filePath：" + str);
            return;
        }
        throw new NullPointerException("删除记录失败，文件路径为空");
    }
}
