package com.arialyy.aria.core.download;

import android.text.TextUtils;
import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.inf.ICheckEntityUtil;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.RecordUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class CheckDGEntityUtil implements ICheckEntityUtil {
    public int action;
    public DownloadGroupEntity mEntity;
    public DGTaskWrapper mWrapper;
    public final String TAG = "CheckDGEntityUtil";
    public boolean needModifyPath = false;

    public CheckDGEntityUtil(DGTaskWrapper dGTaskWrapper, int i) {
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
                    this.needModifyPath = true;
                    this.mEntity.setDirPath(this.mWrapper.getDirPathTemp());
                    ALog.m4189i("CheckDGEntityUtil", String.format("文件夹路径改变，将更新文件夹路径为：%s", this.mWrapper.getDirPathTemp()));
                }
                return true;
            }
            format = String.format("路径【%s】是文件，请设置文件夹路径", this.mWrapper.getDirPathTemp());
        }
        ALog.m4191e("CheckDGEntityUtil", format);
        return false;
    }

    private boolean checkGroupHash(boolean z, String str) {
        if (DbEntity.checkDataExist(DownloadGroupEntity.class, "groupHash=?", str)) {
            if (!z) {
                ALog.m4191e("CheckDGEntityUtil", String.format("下载失败，数据库中已存在相同的url的组任务，groupHash = %s", str));
                return false;
            }
            ALog.m4185w("CheckDGEntityUtil", String.format("数据库中已存在相同的url的组任务，将删除groupHash = %s 的旧任务", str));
            RecordUtil.delGroupTaskRecordByHash(str, true);
        }
        return true;
    }

    private boolean checkSubName() {
        if (this.mWrapper.getSubNameTemp() == null || this.mWrapper.getSubNameTemp().isEmpty() || this.mEntity.getUrls().size() == this.mWrapper.getSubNameTemp().size()) {
            return true;
        }
        ALog.m4191e("CheckDGEntityUtil", "子任务文件名必须和子任务数量一致");
        return false;
    }

    private boolean checkUrls() {
        String str;
        StringBuilder sb;
        String str2;
        String format;
        int i = 0;
        if (this.mEntity.getUrls().isEmpty()) {
            format = "操作失败，子任务下载列表为null";
        } else {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (String str3 : this.mEntity.getUrls()) {
                if (!hashSet.add(str3)) {
                    arrayList.add(str3);
                }
            }
            if (arrayList.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (String str4 : this.mEntity.getUrls()) {
                    if (TextUtils.isEmpty(str4)) {
                        str = "子任务url为null，即将删除该子任务。";
                    } else {
                        if (!str4.startsWith("http")) {
                            sb = new StringBuilder();
                            sb.append("子任务url【");
                            sb.append(str4);
                            str2 = "】错误，即将删除该子任务。";
                        } else if (str4.indexOf("://") == -1) {
                            sb = new StringBuilder();
                            sb.append("子任务url【");
                            sb.append(str4);
                            str2 = "】不合法，即将删除该子任务。";
                        } else {
                            i++;
                        }
                        sb.append(str2);
                        str = sb.toString();
                    }
                    ALog.m4191e("CheckDGEntityUtil", str);
                    hashSet2.add(Integer.valueOf(i));
                }
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    this.mEntity.getUrls().remove(intValue);
                    if (this.mWrapper.getSubNameTemp() != null && !this.mWrapper.getSubNameTemp().isEmpty()) {
                        this.mWrapper.getSubNameTemp().remove(intValue);
                    }
                }
                return true;
            }
            format = String.format("组合任务中有url重复，重复的url：%s", Arrays.toString(arrayList.toArray()));
        }
        ALog.m4191e("CheckDGEntityUtil", format);
        return false;
    }

    public static CheckDGEntityUtil newInstance(DGTaskWrapper dGTaskWrapper, int i) {
        return new CheckDGEntityUtil(dGTaskWrapper, i);
    }

    private void reChangeDirPath(String str) {
        ALog.m4192d("CheckDGEntityUtil", String.format("修改新路径为：%s", str));
        List<DTaskWrapper> subTaskWrapper = this.mWrapper.getSubTaskWrapper();
        if (subTaskWrapper == null || subTaskWrapper.isEmpty()) {
            return;
        }
        for (DTaskWrapper dTaskWrapper : subTaskWrapper) {
            DownloadEntity mo4442getEntity = dTaskWrapper.mo4442getEntity();
            String filePath = mo4442getEntity.getFilePath();
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "/");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(mo4442getEntity.getFileName());
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            File file = new File(filePath);
            if (file.exists()) {
                file.renameTo(new File(sb));
            }
            mo4442getEntity.setFilePath(sb);
        }
    }

    private void saveEntity() {
        this.mEntity.save();
        DbEntity.saveAll(this.mEntity.getSubEntities());
    }

    private void updateSingleSubFileName() {
        int i = 0;
        for (DTaskWrapper dTaskWrapper : this.mWrapper.getSubTaskWrapper()) {
            if (i < this.mWrapper.getSubNameTemp().size()) {
                String str = this.mWrapper.getSubNameTemp().get(i);
                DownloadEntity mo4442getEntity = dTaskWrapper.mo4442getEntity();
                if (!str.equals(mo4442getEntity.getFileName())) {
                    String str2 = this.mEntity.getDirPath() + "/" + mo4442getEntity.getFileName();
                    String str3 = this.mEntity.getDirPath() + "/" + str;
                    if (DbEntity.checkDataExist(DownloadEntity.class, "downloadPath=?", str3)) {
                        ALog.m4185w("CheckDGEntityUtil", String.format("更新文件名失败，路径【%s】被其它任务占用", str3));
                        return;
                    }
                    RecordUtil.modifyTaskRecord(str2, str3, this.mEntity.getTaskType());
                    mo4442getEntity.setFilePath(str3);
                    mo4442getEntity.setFileName(str);
                } else {
                    continue;
                }
            }
            i++;
        }
    }

    @Override // com.arialyy.aria.core.inf.ICheckEntityUtil
    public boolean checkEntity() {
        String str;
        if (this.mWrapper.getErrorEvent() != null) {
            str = String.format("任务操作失败，%s", this.mWrapper.getErrorEvent().errorMsg);
        } else {
            int i = this.action;
            if (((i == 1 || i == 5) && !checkGroupHash(this.mWrapper.isIgnoreTaskOccupy(), this.mEntity.getGroupHash())) || !checkDirPath() || !checkSubName() || !checkUrls()) {
                return false;
            }
            if (this.action == 4 || this.mWrapper.isUnknownSize() || this.mEntity.getFileSize() != 0) {
                if (this.mWrapper.getOptionParams().getParam(IOptionConstant.requestEnum) == RequestEnum.POST) {
                    for (DTaskWrapper dTaskWrapper : this.mWrapper.getSubTaskWrapper()) {
                        dTaskWrapper.getOptionParams().setParams(IOptionConstant.requestEnum, RequestEnum.POST);
                    }
                }
                if (this.needModifyPath) {
                    reChangeDirPath(this.mWrapper.getDirPathTemp());
                }
                if (!this.mWrapper.getSubNameTemp().isEmpty()) {
                    updateSingleSubFileName();
                }
                saveEntity();
                return true;
            }
            str = "组合任务必须设置文件文件大小，默认需要强制设置文件大小。如果无法获取到总长度，请调用#unknownSize()来标志该组合任务";
        }
        ALog.m4191e("CheckDGEntityUtil", str);
        return false;
    }
}
