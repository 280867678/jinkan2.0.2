package com.arialyy.aria.orm;

import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.core.upload.UploadEntity;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DBConfig {
    public static String DB_NAME;
    public static boolean DEBUG;
    public static final boolean SAVE_IN_SDCARD = false;
    public static int VERSION;
    public static Map<String, Class<? extends DbEntity>> mapping = new LinkedHashMap();

    static {
        VERSION = 58;
        if (TextUtils.isEmpty(DB_NAME)) {
            DB_NAME = "AndroidAria.db";
        }
        if (VERSION == -1) {
            VERSION = 1;
        }
        mapping.put("DownloadEntity", DownloadEntity.class);
        mapping.put("DownloadGroupEntity", DownloadGroupEntity.class);
        mapping.put("UploadEntity", UploadEntity.class);
        mapping.put("ThreadRecord", ThreadRecord.class);
        mapping.put("TaskRecord", TaskRecord.class);
        mapping.put("M3U8Entity", M3U8Entity.class);
    }
}
