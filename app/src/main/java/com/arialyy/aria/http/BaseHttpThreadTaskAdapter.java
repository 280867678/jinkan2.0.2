package com.arialyy.aria.http;

import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.task.AbsThreadTaskAdapter;

/* loaded from: classes3.dex */
public abstract class BaseHttpThreadTaskAdapter extends AbsThreadTaskAdapter {
    public HttpTaskOption mTaskOption = (HttpTaskOption) getTaskWrapper().getTaskOption();

    public BaseHttpThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
    }

    /* renamed from: getEntity */
    public AbsNormalEntity mo4443getEntity() {
        return (AbsNormalEntity) getTaskWrapper().mo4442getEntity();
    }

    public String getFileName() {
        return mo4443getEntity().getFileName();
    }
}
