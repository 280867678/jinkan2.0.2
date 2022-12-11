package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.orm.DbEntity;

/* loaded from: classes3.dex */
public class UTaskWrapperFactory implements INormalTEFactory<UploadEntity, UTaskWrapper> {
    public static volatile UTaskWrapperFactory INSTANCE = null;
    public static final String TAG = "UTaskWrapperFactory";

    public static UTaskWrapperFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (UTaskWrapperFactory.class) {
                INSTANCE = new UTaskWrapperFactory();
            }
        }
        return INSTANCE;
    }

    private UploadEntity getUploadEntity(long j) {
        UploadEntity uploadEntity = (UploadEntity) DbEntity.findFirst(UploadEntity.class, "rowid=?", String.valueOf(j));
        return uploadEntity == null ? new UploadEntity() : uploadEntity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.arialyy.aria.core.manager.INormalTEFactory
    /* renamed from: create */
    public UTaskWrapper mo4431create(long j) {
        UTaskWrapper uTaskWrapper = j == -1 ? new UTaskWrapper(new UploadEntity()) : new UTaskWrapper(getUploadEntity(j));
        uTaskWrapper.setRequestType(uTaskWrapper.mo4442getEntity().getTaskType());
        return uTaskWrapper;
    }
}
