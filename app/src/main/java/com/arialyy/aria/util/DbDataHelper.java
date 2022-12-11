package com.arialyy.aria.util;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.download.DGEntityWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DbDataHelper {
    public static List<DTaskWrapper> createDGSubTaskWrapper(DownloadGroupEntity downloadGroupEntity) {
        ArrayList arrayList = new ArrayList();
        for (DownloadEntity downloadEntity : downloadGroupEntity.getSubEntities()) {
            DTaskWrapper dTaskWrapper = new DTaskWrapper(downloadEntity);
            dTaskWrapper.setGroupHash(downloadGroupEntity.getKey());
            dTaskWrapper.setGroupTask(true);
            arrayList.add(dTaskWrapper);
        }
        return arrayList;
    }

    public static List<DownloadEntity> createHttpSubTask(String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str2 = list.get(i);
            DownloadEntity downloadEntity = new DownloadEntity();
            downloadEntity.setUrl(str2);
            downloadEntity.setFilePath(str + "_" + i);
            int lastIndexOf = str2.lastIndexOf(File.separator);
            int lastIndexOf2 = str2.lastIndexOf("?");
            if (lastIndexOf2 < 0 || lastIndexOf2 < lastIndexOf) {
                lastIndexOf2 = str2.length();
            }
            downloadEntity.setFileName(str2.substring(lastIndexOf + 1, lastIndexOf2));
            downloadEntity.setGroupHash(str);
            downloadEntity.setGroupChild(true);
            arrayList.add(downloadEntity);
        }
        return arrayList;
    }

    public static DownloadGroupEntity getDGEntity(long j) {
        List findRelationData = DbEntity.findRelationData(DGEntityWrapper.class, "DownloadGroupEntity.rowid=?", String.valueOf(j));
        if (findRelationData == null || findRelationData.size() == 0) {
            return null;
        }
        return ((DGEntityWrapper) findRelationData.get(0)).groupEntity;
    }

    public static DownloadGroupEntity getDGEntityByHash(String str) {
        List findRelationData = DbEntity.findRelationData(DGEntityWrapper.class, "DownloadGroupEntity.groupHash=?", str);
        if (findRelationData == null || findRelationData.size() == 0) {
            return null;
        }
        return ((DGEntityWrapper) findRelationData.get(0)).groupEntity;
    }

    public static DownloadGroupEntity getDGEntityByPath(String str) {
        List findRelationData = DbEntity.findRelationData(DGEntityWrapper.class, "DownloadGroupEntity.dirPath=?", str);
        if (findRelationData == null || findRelationData.size() == 0) {
            return null;
        }
        return ((DGEntityWrapper) findRelationData.get(0)).groupEntity;
    }

    public static DownloadGroupEntity getOrCreateFtpDGEntity(String str) {
        DownloadGroupEntity downloadGroupEntity;
        List findRelationData = DbEntity.findRelationData(DGEntityWrapper.class, "DownloadGroupEntity.groupHash=?", str);
        if (findRelationData == null || findRelationData.isEmpty()) {
            downloadGroupEntity = new DownloadGroupEntity();
        } else {
            downloadGroupEntity = ((DGEntityWrapper) findRelationData.get(0)).groupEntity;
            if (downloadGroupEntity == null) {
                downloadGroupEntity = new DownloadGroupEntity();
            }
        }
        downloadGroupEntity.setGroupHash(str);
        return downloadGroupEntity;
    }

    public static TaskRecord getTaskRecord(String str, int i) {
        TaskRecord taskRecord = (TaskRecord) DbEntity.findFirst(TaskRecord.class, "filePath=? AND taskType=?", str, String.valueOf(i));
        if (taskRecord != null) {
            taskRecord.threadRecords = DbEntity.findDatas(ThreadRecord.class, "taskKey=? AND threadType=?", str, String.valueOf(i));
        }
        return taskRecord;
    }
}
