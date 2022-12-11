package com.arialyy.aria.core.queue.pool;

/* loaded from: classes3.dex */
public class DLoadSharePool {
    public static volatile DLoadSharePool INSTANCE;
    public DLoadExecutePool executePool = new DLoadExecutePool();
    public BaseCachePool cachePool = new BaseCachePool();

    public static DLoadSharePool getInstance() {
        if (INSTANCE == null) {
            synchronized (DLoadSharePool.class) {
                INSTANCE = new DLoadSharePool();
            }
        }
        return INSTANCE;
    }
}
