package com.arialyy.aria.core.queue.pool;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class DGLoadExecutePool<TASK extends AbsTask> extends DLoadExecutePool<TASK> {
    public final String TAG = CommonUtil.getClassName(this);

    @Override // com.arialyy.aria.core.queue.pool.DLoadExecutePool, com.arialyy.aria.core.queue.pool.BaseExecutePool
    public int getMaxSize() {
        return AriaConfig.getInstance().getDGConfig().getMaxTaskNum();
    }
}
