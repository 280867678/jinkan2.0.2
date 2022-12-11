package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.download.DGEntityWrapper;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DbDataHelper;
import java.util.List;

/* loaded from: classes3.dex */
public class DGTaskWrapperFactory implements IGroupWrapperFactory<DownloadGroupEntity, DGTaskWrapper> {
    public static volatile DGTaskWrapperFactory INSTANCE;
    public final String TAG = CommonUtil.getClassName(this);

    public static DGTaskWrapperFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (DGTaskWrapperFactory.class) {
                INSTANCE = new DGTaskWrapperFactory();
            }
        }
        return INSTANCE;
    }

    private DownloadGroupEntity getOrCreateHttpDGEntity(long j) {
        List findRelationData = DbEntity.findRelationData(DGEntityWrapper.class, "DownloadGroupEntity.rowid=?", String.valueOf(j));
        if (findRelationData == null || findRelationData.isEmpty()) {
            return new DownloadGroupEntity();
        }
        DownloadGroupEntity downloadGroupEntity = ((DGEntityWrapper) findRelationData.get(0)).groupEntity;
        return downloadGroupEntity == null ? new DownloadGroupEntity() : downloadGroupEntity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.arialyy.aria.core.manager.IGroupWrapperFactory
    /* renamed from: getGroupWrapper */
    public DGTaskWrapper mo4429getGroupWrapper(long j) {
        DGTaskWrapper dGTaskWrapper;
        if (j == -1) {
            dGTaskWrapper = new DGTaskWrapper(new DownloadGroupEntity());
        } else {
            DownloadGroupEntity orCreateHttpDGEntity = getOrCreateHttpDGEntity(j);
            DGTaskWrapper dGTaskWrapper2 = new DGTaskWrapper(orCreateHttpDGEntity);
            if (orCreateHttpDGEntity.getSubEntities() != null && !orCreateHttpDGEntity.getSubEntities().isEmpty()) {
                dGTaskWrapper2.setSubTaskWrapper(DbDataHelper.createDGSubTaskWrapper(orCreateHttpDGEntity));
            }
            dGTaskWrapper = dGTaskWrapper2;
        }
        dGTaskWrapper.setRequestType(((DownloadGroupEntity) dGTaskWrapper.mo4442getEntity()).getTaskType());
        return dGTaskWrapper;
    }
}
