package com.arialyy.aria.core.download;

import com.arialyy.aria.core.config.Configuration;
import com.arialyy.aria.core.config.DGroupConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DGTaskWrapper extends AbsGroupTaskWrapper<DownloadGroupEntity, DTaskWrapper> {
    public String dirPathTemp;
    public List<DTaskWrapper> subWrappers;
    public boolean unknownSize = false;
    public List<String> subNameTemp = new ArrayList();

    public DGTaskWrapper(DownloadGroupEntity downloadGroupEntity) {
        super(downloadGroupEntity);
    }

    @Override // com.arialyy.aria.core.wrapper.AbsTaskWrapper
    /* renamed from: getConfig  reason: collision with other method in class */
    public DGroupConfig mo4438getConfig() {
        return Configuration.getInstance().dGroupCfg;
    }

    public String getDirPathTemp() {
        return this.dirPathTemp;
    }

    @Override // com.arialyy.aria.core.wrapper.ITaskWrapper
    public String getKey() {
        return ((DownloadGroupEntity) mo4442getEntity()).getKey();
    }

    public List<String> getSubNameTemp() {
        return this.subNameTemp;
    }

    @Override // com.arialyy.aria.core.download.AbsGroupTaskWrapper
    public List<DTaskWrapper> getSubTaskWrapper() {
        if (this.subWrappers == null) {
            this.subWrappers = new ArrayList();
        }
        return this.subWrappers;
    }

    public boolean isUnknownSize() {
        return this.unknownSize;
    }

    public void setDirPathTemp(String str) {
        this.dirPathTemp = str;
    }

    public void setSubNameTemp(List<String> list) {
        this.subNameTemp = list;
    }

    @Override // com.arialyy.aria.core.download.AbsGroupTaskWrapper
    public void setSubTaskWrapper(List<DTaskWrapper> list) {
        this.subWrappers = list;
    }

    public void setUnknownSize(boolean z) {
        this.unknownSize = z;
    }
}
