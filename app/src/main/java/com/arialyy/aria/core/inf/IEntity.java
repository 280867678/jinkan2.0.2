package com.arialyy.aria.core.inf;

import com.arialyy.aria.orm.annotation.Ignore;

/* loaded from: classes3.dex */
public interface IEntity {
    @Ignore
    public static final int STATE_CANCEL = 7;
    @Ignore
    public static final int STATE_COMPLETE = 1;
    @Ignore
    public static final int STATE_FAIL = 0;
    @Ignore
    public static final int STATE_OTHER = -1;
    @Ignore
    public static final int STATE_POST_PRE = 6;
    @Ignore
    public static final int STATE_PRE = 5;
    @Ignore
    public static final int STATE_RUNNING = 4;
    @Ignore
    public static final int STATE_STOP = 2;
    @Ignore
    public static final int STATE_WAIT = 3;
}
