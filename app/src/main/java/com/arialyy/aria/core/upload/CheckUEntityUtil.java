package com.arialyy.aria.core.upload;

import android.text.TextUtils;
import com.arialyy.aria.core.inf.ICheckEntityUtil;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import java.io.File;

/* loaded from: classes3.dex */
public class CheckUEntityUtil implements ICheckEntityUtil {
    public final String TAG = "CheckUEntityUtil";
    public int action;
    public UploadEntity mEntity;
    public UTaskWrapper mWrapper;

    public CheckUEntityUtil(UTaskWrapper uTaskWrapper, int i) {
        this.action = i;
        this.mWrapper = uTaskWrapper;
        this.mEntity = uTaskWrapper.mo4442getEntity();
    }

    private boolean checkFilePath() {
        StringBuilder sb;
        String str;
        String sb2;
        String filePath = this.mEntity.getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            sb2 = "上传失败，文件路径为null";
        } else {
            if (!filePath.startsWith("/")) {
                sb = new StringBuilder();
                sb.append("上传失败，文件路径【");
                sb.append(filePath);
                str = "】不合法";
            } else if (this.mWrapper.isNewTask() && !CheckUtil.checkUPathConflicts(this.mWrapper.isIgnoreFilePathOccupy(), filePath, this.mWrapper.getRequestType())) {
                return false;
            } else {
                File file = new File(this.mEntity.getFilePath());
                if (!file.exists()) {
                    sb = new StringBuilder();
                    sb.append("上传失败，文件【");
                    sb.append(filePath);
                    str = "】不存在";
                } else if (!file.isDirectory()) {
                    return true;
                } else {
                    sb = new StringBuilder();
                    sb.append("上传失败，文件【");
                    sb.append(filePath);
                    str = "】不能是文件夹";
                }
            }
            sb.append(str);
            sb2 = sb.toString();
        }
        ALog.m4191e("CheckUEntityUtil", sb2);
        return false;
    }

    private boolean checkUrl() {
        StringBuilder sb;
        String str;
        String sb2;
        String tempUrl = this.mWrapper.getTempUrl();
        if (TextUtils.isEmpty(tempUrl)) {
            sb2 = "上传失败，url为null";
        } else {
            if (!CheckUtil.checkUrl(tempUrl)) {
                sb = new StringBuilder();
                sb.append("上传失败，url【");
                sb.append(tempUrl);
                str = "】错误";
            } else if (tempUrl.indexOf("://") != -1) {
                this.mEntity.setUrl(tempUrl);
                return true;
            } else {
                sb = new StringBuilder();
                sb.append("上传失败，url【");
                sb.append(tempUrl);
                str = "】不合法";
            }
            sb.append(str);
            sb2 = sb.toString();
        }
        ALog.m4191e("CheckUEntityUtil", sb2);
        return false;
    }

    public static CheckUEntityUtil newInstance(UTaskWrapper uTaskWrapper, int i) {
        return new CheckUEntityUtil(uTaskWrapper, i);
    }

    @Override // com.arialyy.aria.core.inf.ICheckEntityUtil
    public boolean checkEntity() {
        boolean z = true;
        if (this.mWrapper.getErrorEvent() != null) {
            ALog.m4191e("CheckUEntityUtil", String.format("任务操作失败，%s", this.mWrapper.getErrorEvent().errorMsg));
            return false;
        }
        if (!checkUrl() || !checkFilePath()) {
            z = false;
        }
        if (z) {
            this.mEntity.save();
        }
        return z;
    }
}
