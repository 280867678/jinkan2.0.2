package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.orm.DbEntity;

/* loaded from: classes3.dex */
public class DeleteURecord implements IDeleteRecord {
    public static volatile DeleteURecord INSTANCE;
    public String TAG = CommonUtil.getClassName(this);

    public static DeleteURecord getInstance() {
        if (INSTANCE == null) {
            synchronized (DeleteURecord.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeleteURecord();
                }
            }
        }
        return INSTANCE;
    }

    @Override // com.arialyy.aria.util.IDeleteRecord
    public void deleteRecord(AbsEntity absEntity, boolean z, boolean z2) {
        if (absEntity == null) {
            ALog.m4191e(this.TAG, "删除上传记录失败，实体为空");
            return;
        }
        UploadEntity uploadEntity = (UploadEntity) absEntity;
        DbEntity.deleteData(TaskRecord.class, "filePath=? AND taskType=?", uploadEntity.getFilePath(), String.valueOf(uploadEntity.getTaskType()));
        if (z) {
            FileUtil.deleteFile(uploadEntity.getFilePath());
        }
        if (!z2) {
            return;
        }
        DbEntity.deleteData(UploadEntity.class, "filePath=?", uploadEntity.getFilePath());
    }

    @Override // com.arialyy.aria.util.IDeleteRecord
    public void deleteRecord(String str, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException(String.format("文件路径错误，filePath：%s", str));
            }
            UploadEntity uploadEntity = (UploadEntity) DbEntity.findFirst(UploadEntity.class, "filePath=?", str);
            if (uploadEntity != null) {
                deleteRecord(uploadEntity, z, z2);
                return;
            }
            String str2 = this.TAG;
            ALog.m4191e(str2, "删除上传记录失败，没有在数据库中找到对应的实体文件，filePath：" + str);
            return;
        }
        throw new NullPointerException("删除记录失败，文件路径为空");
    }
}
