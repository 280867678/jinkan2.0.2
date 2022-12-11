package com.arialyy.aria.core.queue.pool;

/* loaded from: classes3.dex */
public class UploadSharePool {
    public static volatile UploadSharePool INSTANCE;
    public UploadExecutePool executePool = new UploadExecutePool();
    public BaseCachePool cachePool = new BaseCachePool();

    public static UploadSharePool getInstance() {
        if (INSTANCE == null) {
            synchronized (UploadSharePool.class) {
                INSTANCE = new UploadSharePool();
            }
        }
        return INSTANCE;
    }
}
