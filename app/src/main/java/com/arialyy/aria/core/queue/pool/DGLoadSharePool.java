package com.arialyy.aria.core.queue.pool;

/* loaded from: classes3.dex */
public class DGLoadSharePool {
    public static volatile DGLoadSharePool INSTANCE;
    public DGLoadExecutePool executePool = new DGLoadExecutePool();
    public BaseCachePool cachePool = new BaseCachePool();

    public static DGLoadSharePool getInstance() {
        if (INSTANCE == null) {
            synchronized (DGLoadSharePool.class) {
                INSTANCE = new DGLoadSharePool();
            }
        }
        return INSTANCE;
    }
}
