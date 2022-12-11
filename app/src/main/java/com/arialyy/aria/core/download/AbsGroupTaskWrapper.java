package com.arialyy.aria.core.download;

import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbsGroupTaskWrapper<ENTITY extends AbsEntity, SUB extends AbsTaskWrapper> extends AbsTaskWrapper<ENTITY> {
    public boolean ignoreTaskOccupy = false;

    public AbsGroupTaskWrapper(ENTITY entity) {
        super(entity);
    }

    public abstract List<SUB> getSubTaskWrapper();

    public boolean isIgnoreTaskOccupy() {
        return this.ignoreTaskOccupy;
    }

    public void setIgnoreTaskOccupy(boolean z) {
        this.ignoreTaskOccupy = z;
    }

    public abstract void setSubTaskWrapper(List<SUB> list);
}
