package com.arialyy.aria.core.download;

import android.text.TextUtils;
import com.arialyy.aria.core.FtpUrlEntity;
import com.arialyy.aria.core.inf.ICheckEntityUtil;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import java.io.File;

/* loaded from: classes3.dex */
public class CheckFtpDirEntityUtil implements ICheckEntityUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final String TAG = "CheckFtpDirEntityUtil";
    public int action;
    public DownloadGroupEntity mEntity;
    public DGTaskWrapper mWrapper;

    public CheckFtpDirEntityUtil(DGTaskWrapper dGTaskWrapper, int i) {
        this.action = i;
        this.mWrapper = dGTaskWrapper;
        this.mEntity = (DownloadGroupEntity) dGTaskWrapper.mo4442getEntity();
    }

    private boolean checkDirPath() {
        String format;
        if (TextUtils.isEmpty(this.mWrapper.getDirPathTemp())) {
            format = "文件夹路径不能为null";
        } else if (!this.mWrapper.getDirPathTemp().startsWith("/")) {
            format = String.format("文件夹路径【%s】错误", this.mWrapper.getDirPathTemp());
        } else {
            File file = new File(this.mWrapper.getDirPathTemp());
            if (!file.isFile()) {
                if (this.mWrapper.isNewTask() && !CheckUtil.checkDGPathConflicts(this.mWrapper.isIgnoreFilePathOccupy(), this.mWrapper.getDirPathTemp())) {
                    return false;
                }
                if (TextUtils.isEmpty(this.mEntity.getDirPath()) || !this.mEntity.getDirPath().equals(this.mWrapper.getDirPathTemp())) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.mEntity.setDirPath(this.mWrapper.getDirPathTemp());
                    ALog.m4189i("CheckFtpDirEntityUtil", String.format("文件夹路径改变，将更新文件夹路径为：%s", this.mWrapper.getDirPathTemp()));
                }
                return true;
            }
            format = String.format("路径【%s】是文件，请设置文件夹路径", this.mWrapper.getDirPathTemp());
        }
        ALog.m4191e("CheckFtpDirEntityUtil", format);
        return false;
    }

    private boolean checkUrl() {
        StringBuilder sb;
        String str;
        String sb2;
        String key = this.mEntity.getKey();
        if (TextUtils.isEmpty(key)) {
            sb2 = "下载失败，url为null";
        } else {
            if (!key.startsWith("ftp")) {
                sb = new StringBuilder();
                sb.append("下载失败，url【");
                sb.append(key);
                str = "】错误";
            } else if (key.indexOf("://") != -1) {
                return true;
            } else {
                sb = new StringBuilder();
                sb.append("下载失败，url【");
                sb.append(key);
                str = "】不合法";
            }
            sb.append(str);
            sb2 = sb.toString();
        }
        ALog.m4191e("CheckFtpDirEntityUtil", sb2);
        return false;
    }

    public static CheckFtpDirEntityUtil newInstance(DGTaskWrapper dGTaskWrapper, int i) {
        return new CheckFtpDirEntityUtil(dGTaskWrapper, i);
    }

    @Override // com.arialyy.aria.core.inf.ICheckEntityUtil
    public boolean checkEntity() {
        String str;
        boolean z = true;
        if (this.mWrapper.getErrorEvent() == null) {
            if (!checkDirPath() || !checkUrl()) {
                z = false;
            }
            if (z) {
                this.mEntity.save();
            }
            FtpUrlEntity ftpUrlEntity = (FtpUrlEntity) this.mWrapper.getOptionParams().getParam(IOptionConstant.ftpUrlEntity);
            if (ftpUrlEntity.isFtps) {
                if (TextUtils.isEmpty(ftpUrlEntity.idEntity.storePath)) {
                    str = "证书路径为空";
                } else if (TextUtils.isEmpty(ftpUrlEntity.idEntity.keyAlias)) {
                    str = "证书别名为空";
                }
            }
            return z;
        }
        str = String.format("任务操作失败，%s", this.mWrapper.getErrorEvent().errorMsg);
        ALog.m4191e("CheckFtpDirEntityUtil", str);
        return false;
    }
}
