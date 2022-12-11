package com.arialyy.aria.core.common;

import com.arialyy.aria.core.wrapper.ITaskWrapper;

/* loaded from: classes3.dex */
public class CompleteInfo {
    public int code;
    public Object obj;
    public ITaskWrapper wrapper;

    public CompleteInfo() {
    }

    public CompleteInfo(int i, ITaskWrapper iTaskWrapper) {
        this.code = i;
        this.wrapper = iTaskWrapper;
    }
}
