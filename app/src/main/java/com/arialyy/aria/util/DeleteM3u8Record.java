package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.m3u8.M3U8InfoTask;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DeleteM3u8Record implements IDeleteRecord {
    public static volatile DeleteM3u8Record INSTANCE;
    public String TAG = CommonUtil.getClassName(this);

    public static DeleteM3u8Record getInstance() {
        if (INSTANCE == null) {
            synchronized (DeleteM3u8Record.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeleteM3u8Record();
                }
            }
        }
        return INSTANCE;
    }

    public static void removeTsCache(File file, long j) {
        File[] listFiles;
        String format = !file.isDirectory() ? String.format("%s/.%s_%s", file.getParent(), file.getName(), Long.valueOf(j)) : null;
        if (!TextUtils.isEmpty(format)) {
            File file2 = new File(format);
            if (!file2.exists()) {
                return;
            }
            for (File file3 : file2.listFiles()) {
                if (file3.exists()) {
                    file3.delete();
                }
            }
            File file4 = new File(format);
            if (file4.exists()) {
                file4.delete();
            }
        }
        File file5 = new File(String.format(M3U8InfoTask.M3U8_INDEX_FORMAT, file.getPath()));
        if (file5.exists()) {
            file5.delete();
        }
    }

    @Override // com.arialyy.aria.util.IDeleteRecord
    public void deleteRecord(AbsEntity absEntity, boolean z, boolean z2) {
        if (absEntity == null) {
            ALog.m4191e(this.TAG, "删除下载记录失败，实体为空");
            return;
        }
        DownloadEntity downloadEntity = (DownloadEntity) absEntity;
        TaskRecord taskRecord = DbDataHelper.getTaskRecord(downloadEntity.getFilePath(), downloadEntity.getTaskType());
        String filePath = downloadEntity.getFilePath();
        if (taskRecord == null) {
            String str = this.TAG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("删除下载记录失败，记录为空，filePath：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(downloadEntity.getFilePath());
            ALog.m4191e(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (z || !downloadEntity.isComplete()) {
            removeTsCache(new File(filePath), taskRecord.bandWidth);
            FileUtil.deleteFile(filePath);
        }
        try {
            DbEntity.deleteData(M3U8Entity.class, "filePath=?", filePath);
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
