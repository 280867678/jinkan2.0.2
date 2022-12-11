package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public class RecordUtil {
    public static final String TAG = "RecordUtil";

    public static boolean blockTaskExists(String str) {
        return new File(String.format(IRecordHandler.SUB_PATH, str, 0)).exists();
    }

    public static void delGroupTaskRecordByHash(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(TAG, "删除下载任务组记录失败，groupHash为null");
            return;
        }
        DeleteDGRecord.getInstance().deleteRecord((AbsEntity) DbDataHelper.getDGEntityByHash(str), z, true);
    }

    public static void delNormalTaskRecord(AbsNormalEntity absNormalEntity, boolean z) {
        int taskType = absNormalEntity.getTaskType();
        if (taskType != 1 && taskType != 3 && taskType != 12) {
            if (taskType != 13) {
                switch (taskType) {
                    case 5:
                    case 6:
                        break;
                    case 7:
                    case 8:
                        DeleteM3u8Record.getInstance().deleteRecord((AbsEntity) absNormalEntity, z, true);
                        return;
                    case 9:
                        break;
                    default:
                        return;
                }
            }
            DeleteURecord.getInstance().deleteRecord((AbsEntity) absNormalEntity, z, true);
            return;
        }
        DeleteDRecord.getInstance().deleteRecord((AbsEntity) absNormalEntity, z, true);
    }

    public static void delTaskRecord(String str, int i, boolean z, boolean z2) {
        if (i != 1 && i != 3 && i != 12) {
            if (i != 13) {
                switch (i) {
                    case 5:
                    case 6:
                        break;
                    case 7:
                    case 8:
                        DeleteM3u8Record.getInstance().deleteRecord(str, z, z2);
                        return;
                    case 9:
                        break;
                    default:
                        return;
                }
            }
            DeleteURecord.getInstance().deleteRecord(str, z, z2);
            return;
        }
        DeleteDRecord.getInstance().deleteRecord(str, z, z2);
    }

    public static long getBlockLen(long j, int i, int i2) {
        long j2 = j / i2;
        return i == i2 + (-1) ? j - (i * j2) : j2;
    }

    public static void modifyTaskRecord(String str, String str2, int i) {
        if (str.equals(str2)) {
            ALog.m4185w(TAG, "修改任务记录失败，新文件路径和旧文件路径一致");
            return;
        }
        TaskRecord taskRecord = DbDataHelper.getTaskRecord(str, i);
        if (taskRecord == null) {
            if (!new File(str).exists()) {
                return;
            }
            ALog.m4185w(TAG, "修改任务记录失败，文件【" + str + "】对应的任务记录不存在");
            return;
        }
        if (!taskRecord.isBlock) {
            File file = new File(str);
            if (file.exists()) {
                file.renameTo(new File(str2));
            }
        }
        taskRecord.filePath = str2;
        taskRecord.update();
        List<ThreadRecord> list = taskRecord.threadRecords;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (ThreadRecord threadRecord : taskRecord.threadRecords) {
            threadRecord.taskKey = str2;
            File file2 = new File(String.format(IRecordHandler.SUB_PATH, str, Integer.valueOf(threadRecord.threadId)));
            if (file2.exists()) {
                file2.renameTo(new File(String.format(IRecordHandler.SUB_PATH, str2, Integer.valueOf(threadRecord.threadId))));
            }
        }
        DbEntity.updateManyData(taskRecord.threadRecords);
    }
}
