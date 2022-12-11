package com.arialyy.aria.core.download;

import android.text.TextUtils;
import com.arialyy.aria.core.inf.ICheckEntityUtil;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.FileUtil;
import com.arialyy.aria.util.RecordUtil;
import java.io.File;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class CheckDEntityUtil implements ICheckEntityUtil {
    public final String TAG = CommonUtil.getClassName(CheckDEntityUtil.class);
    public int action;
    public DownloadEntity mEntity;
    public DTaskWrapper mWrapper;

    public CheckDEntityUtil(DTaskWrapper dTaskWrapper, int i) {
        this.action = i;
        this.mWrapper = dTaskWrapper;
        this.mEntity = dTaskWrapper.mo4442getEntity();
    }

    private boolean checkFilePath() {
        String tempFilePath = this.mWrapper.getTempFilePath();
        if (TextUtils.isEmpty(tempFilePath)) {
            ALog.m4191e(this.TAG, "下载失败，文件保存路径为null");
            return false;
        } else if (!tempFilePath.startsWith("/")) {
            ALog.m4191e(this.TAG, String.format("下载失败，文件保存路径【%s】错误", tempFilePath));
            return false;
        } else {
            File file = new File(tempFilePath);
            if (file.isDirectory()) {
                if (this.mWrapper.getRequestType() == 1 || this.mWrapper.getRequestType() == 7) {
                    ALog.m4191e(this.TAG, String.format("下载失败，保存路径【%s】不能为文件夹，路径需要是完整的文件路径，如：/mnt/sdcard/game.zip", tempFilePath));
                    return false;
                } else if (this.mWrapper.getRequestType() == 4) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tempFilePath);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mEntity.getFileName());
                    tempFilePath = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
            } else if (TextUtils.isEmpty(this.mEntity.getFileName())) {
                this.mEntity.setFileName(file.getName());
            }
            return checkPathConflicts(tempFilePath);
        }
    }

    private boolean checkPathConflicts(String str) {
        String str2;
        String format;
        if (!str.equals(this.mEntity.getFilePath())) {
            if (!CheckUtil.checkDPathConflicts(this.mWrapper.isIgnoreFilePathOccupy(), str, this.mWrapper.getRequestType())) {
                return false;
            }
            File file = new File(str);
            this.mEntity.setFilePath(str);
            this.mEntity.setFileName(file.getName());
            Object param = this.mWrapper.getOptionParams().getParam(IOptionConstant.useServerFileName);
            if ((param == null || !((Boolean) param).booleanValue()) && this.mWrapper.getRequestType() != 8 && !TextUtils.isEmpty(this.mEntity.getFilePath())) {
                File file2 = new File(this.mEntity.getFilePath());
                if (file2.exists()) {
                    RecordUtil.modifyTaskRecord(file2.getPath(), file.getPath(), this.mEntity.getTaskType());
                    str2 = this.TAG;
                    format = String.format("将任务重命名为：%s", file.getName());
                } else if (RecordUtil.blockTaskExists(file2.getPath())) {
                    RecordUtil.modifyTaskRecord(file2.getPath(), file.getPath(), this.mEntity.getTaskType());
                    str2 = this.TAG;
                    format = String.format("将分块任务重命名为：%s", file.getName());
                }
                ALog.m4189i(str2, format);
            }
        }
        return true;
    }

    private boolean checkUrl() {
        String url = this.mEntity.getUrl();
        if (TextUtils.isEmpty(url)) {
            ALog.m4191e(this.TAG, "下载失败，url为null");
            return false;
        } else if (!CheckUtil.checkUrl(url)) {
            String str = this.TAG;
            ALog.m4191e(str, "下载失败，url【" + url + "】错误");
            return false;
        } else if (url.indexOf("://") != -1) {
            if (TextUtils.isEmpty(this.mWrapper.getTempUrl())) {
                return true;
            }
            this.mEntity.setUrl(this.mWrapper.getTempUrl());
            return true;
        } else {
            String str2 = this.TAG;
            ALog.m4191e(str2, "下载失败，url【" + url + "】不合法");
            return false;
        }
    }

    private void handleM3U8() {
        File file = new File(this.mWrapper.getTempFilePath());
        Object param = this.mWrapper.getM3U8Params().getParam(IOptionConstant.bandWidth);
        int intValue = param == null ? 0 : ((Integer) param).intValue();
        String tsCacheDir = FileUtil.getTsCacheDir(file.getPath(), intValue);
        this.mWrapper.getM3U8Params().setParams(IOptionConstant.cacheDir, tsCacheDir);
        M3U8Entity m3U8Entity = this.mEntity.getM3U8Entity();
        if (m3U8Entity == null) {
            M3U8Entity m3U8Entity2 = new M3U8Entity();
            m3U8Entity2.setFilePath(this.mEntity.getFilePath());
            m3U8Entity2.setPeerIndex(0);
            m3U8Entity2.setCacheDir(tsCacheDir);
            m3U8Entity2.insert();
        } else {
            m3U8Entity.update();
        }
        if (this.mWrapper.getRequestType() == 7 && this.action == 1) {
            if (this.mEntity.getFileSize() == 0) {
                ALog.m4185w(this.TAG, "由于m3u8协议的特殊性质，无法有效快速获取到正确到文件长度，如果你需要显示文件中长度，你需要自行设置文件长度：.asM3U8().asVod().setFileSize(xxx)");
            }
        } else if (this.mWrapper.getRequestType() == 8 && this.action != 4 && file.exists()) {
            ALog.m4185w(this.TAG, "对于直播来说，每次下载都是一个新文件，所以你需要设置新都文件路径，否则Aria框架将会覆盖已下载的文件");
            file.delete();
        }
        if (this.action == 4 || this.mWrapper.getM3U8Params().getHandler(IOptionConstant.bandWidthUrlConverter) == null || intValue != 0) {
            return;
        }
        ALog.m4185w(this.TAG, "你已经设置了码率url转换器，但是没有设置码率，Aria框架将采用第一个获取到的码率");
    }

    public static CheckDEntityUtil newInstance(DTaskWrapper dTaskWrapper, int i) {
        return new CheckDEntityUtil(dTaskWrapper, i);
    }

    @Override // com.arialyy.aria.core.inf.ICheckEntityUtil
    public boolean checkEntity() {
        boolean z = true;
        if (this.mWrapper.getErrorEvent() != null) {
            ALog.m4191e(this.TAG, String.format("任务操作失败，%s", this.mWrapper.getErrorEvent().errorMsg));
            return false;
        }
        if (!checkUrl() || !checkFilePath()) {
            z = false;
        }
        if (z) {
            this.mEntity.save();
        }
        if (this.mWrapper.getRequestType() == 7 || this.mWrapper.getRequestType() == 8) {
            handleM3U8();
        }
        return z;
    }
}
