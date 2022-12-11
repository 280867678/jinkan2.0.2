package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.orm.DbEntity;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class CheckUtil {
    public static final String TAG = "CheckUtil";

    public static boolean checkDGPathConflicts(boolean z, String str) {
        if (DbEntity.checkDataExist(DownloadGroupEntity.class, "dirPath=?", str)) {
            if (!z) {
                ALog.m4191e(TAG, String.format("下载失败，文件夹路径【%s】已经被其它任务占用，请设置其它文件路径", str));
                return false;
            }
            ALog.m4185w(TAG, String.format("文件夹路径【%s】已经被其它任务占用，当前任务将覆盖该路径", str));
            DeleteDGRecord.getInstance().deleteRecord(str, false, true);
        }
        return true;
    }

    public static boolean checkDPathConflicts(boolean z, String str, int i) {
        if (DbEntity.checkDataExist(DownloadEntity.class, "downloadPath=?", str)) {
            if (!z) {
                ALog.m4191e(TAG, String.format("下载失败，保存路径【%s】已经被其它任务占用，请设置其它保存路径", str));
                return false;
            }
            ALog.m4185w(TAG, String.format("保存路径【%s】已经被其它任务占用，当前任务将覆盖该路径的文件", str));
            RecordUtil.delTaskRecord(str, i, false, true);
        }
        return true;
    }

    public static boolean checkDownloadUrlsIsEmpty(List<String> list) {
        if (list == null || list.isEmpty()) {
            ALog.m4191e(TAG, "链接组不能为null");
            return true;
        }
        return false;
    }

    public static boolean checkIp(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 7 || str.length() > 15) {
            return false;
        }
        Matcher matcher = Pattern.compile(Regular.REG_IP_V4).matcher(str);
        return matcher.find() && matcher.groupCount() > 0;
    }

    public static void checkMemberClass(Class cls) {
        int modifiers = cls.getModifiers();
        if (!cls.isMemberClass() || !Modifier.isStatic(modifiers)) {
            ALog.m4191e(TAG, String.format("为了防止内存泄漏，请使用静态的成员类(public static class %s)或文件类(%s.java)", cls.getSimpleName(), cls.getSimpleName()));
        }
    }

    public static void checkPageParams(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new NullPointerException("page和num不能小于1");
        }
    }

    public static boolean checkUPathConflicts(boolean z, String str, int i) {
        if (DbEntity.checkDataExist(UploadEntity.class, "filePath=?", str)) {
            if (!z) {
                ALog.m4191e(TAG, String.format("上传失败，文件路径【%s】已经被其它任务占用，请设置其它文件路径", str));
                return false;
            }
            ALog.m4185w(TAG, String.format("文件路径【%s】已经被其它任务占用，当前任务将覆盖该路径的文件", str));
            RecordUtil.delTaskRecord(str, i, false, true);
        }
        return true;
    }

    public static void checkUploadPathIsEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return;
        }
        throw new IllegalArgumentException("上传地址不能为null");
    }

    public static boolean checkUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "url不能为null";
        } else if (str.startsWith("http") || str.startsWith("ftp") || str.startsWith("sftp")) {
            if (str.indexOf("://") != -1) {
                return true;
            }
            ALog.m4191e(TAG, "url【" + str + "】不合法");
            return true;
        } else {
            str2 = "url【" + str + "】错误";
        }
        ALog.m4191e(TAG, str2);
        return false;
    }

    public static boolean ftpIsBadRequest(int i) {
        return i >= 400 && i < 600;
    }

    public static boolean httpIsBadRequest(int i) {
        return i == 502 || i == 405 || i == 400;
    }
}
