package com.arialyy.aria.core.command;

import com.arialyy.aria.core.queue.AbsTaskQueue;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public abstract class AbsCmd<T extends AbsTaskWrapper> implements ICmd {
    public String TAG;
    public boolean isDownloadCmd = true;
    public AbsTaskQueue mQueue;
    public T mTaskWrapper;
}
