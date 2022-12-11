package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DbDataHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HttpGroupConfigHandler<TARGET extends AbsTarget> extends AbsGroupConfigHandler<TARGET> {
    public List<String> mUrls = new ArrayList();
    public List<String> mSubNameTemp = new ArrayList();

    public HttpGroupConfigHandler(TARGET target, long j) {
        super(target, j);
        this.mUrls.addAll(mo4422getEntity().getUrls());
    }

    public void setGroupUrl(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new NullPointerException("组合任务子任务下载地址列表为空");
        }
        this.mUrls.clear();
        this.mUrls.addAll(list);
        String md5Code = CommonUtil.getMd5Code(list);
        mo4422getEntity().setGroupHash(md5Code);
        List<DownloadEntity> createHttpSubTask = DbDataHelper.createHttpSubTask(md5Code, this.mUrls);
        ArrayList arrayList = new ArrayList();
        for (DownloadEntity downloadEntity : createHttpSubTask) {
            downloadEntity.setTaskType(1);
            arrayList.add(new DTaskWrapper(downloadEntity));
        }
        mo4422getEntity().setUrls(list);
        mo4422getEntity().setSubEntities(createHttpSubTask);
        getTaskWrapper().setSubTaskWrapper(arrayList);
    }

    public TARGET setSubFileName(List<String> list) {
        String str;
        String str2;
        if (list == null || list.isEmpty()) {
            str = this.TAG;
            str2 = "修改子任务的文件名失败：列表为null";
        } else if (list.size() == getTaskWrapper().getSubTaskWrapper().size()) {
            this.mSubNameTemp.clear();
            this.mSubNameTemp.addAll(list);
            getTaskWrapper().setSubNameTemp(this.mSubNameTemp);
            return getTarget();
        } else {
            str = this.TAG;
            str2 = "修改子任务的文件名失败：子任务文件名列表数量和子任务的数量不匹配";
        }
        ALog.m4185w(str, str2);
        return getTarget();
    }

    public TARGET updateUrls(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new NullPointerException("下载地址列表为空");
        }
        if (list.size() != this.mUrls.size()) {
            throw new IllegalArgumentException("新下载地址数量和旧下载地址数量不一致");
        }
        this.mUrls.clear();
        this.mUrls.addAll(list);
        String md5Code = CommonUtil.getMd5Code(list);
        mo4422getEntity().setUrls(this.mUrls);
        mo4422getEntity().setGroupHash(md5Code);
        mo4422getEntity().update();
        if (mo4422getEntity().getSubEntities() != null && !mo4422getEntity().getSubEntities().isEmpty()) {
            int i = 0;
            for (DownloadEntity downloadEntity : mo4422getEntity().getSubEntities()) {
                downloadEntity.setUrl(this.mUrls.get(i));
                downloadEntity.setGroupHash(md5Code);
                i++;
            }
            DbEntity.updateManyData(mo4422getEntity().getSubEntities());
        }
        return getTarget();
    }
}
