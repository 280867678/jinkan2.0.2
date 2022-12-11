package com.arialyy.aria.core.download;

import com.arialyy.aria.orm.AbsDbWrapper;
import com.arialyy.aria.orm.annotation.Many;
import com.arialyy.aria.orm.annotation.One;
import com.arialyy.aria.orm.annotation.Wrapper;
import java.util.List;

@Wrapper
/* loaded from: classes3.dex */
public class DGEntityWrapper extends AbsDbWrapper {
    @One
    public DownloadGroupEntity groupEntity;
    @Many(entityColumn = "groupHash", parentColumn = "groupHash")
    public List<DownloadEntity> subEntity;

    @Override // com.arialyy.aria.orm.AbsDbWrapper
    public void handleConvert() {
        List<DownloadEntity> list = this.subEntity;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.groupEntity.setSubEntities(this.subEntity);
    }
}
