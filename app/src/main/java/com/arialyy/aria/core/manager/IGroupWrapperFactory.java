package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public interface IGroupWrapperFactory<ENTITY extends AbsEntity, TASK_ENTITY extends AbsTaskWrapper<ENTITY>> {
    /* renamed from: getGroupWrapper */
    TASK_ENTITY mo4429getGroupWrapper(long j);
}
