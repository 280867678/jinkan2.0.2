package com.arialyy.aria.core.queue.pool;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.task.AbsTask;

/* loaded from: classes3.dex */
public class UploadExecutePool<TASK extends AbsTask> extends BaseExecutePool<TASK> {
    @Override // com.arialyy.aria.core.queue.pool.BaseExecutePool
    public int getMaxSize() {
        return AriaConfig.getInstance().getUConfig().getMaxTaskNum();
    }
}
