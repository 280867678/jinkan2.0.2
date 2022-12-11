package com.arialyy.aria.core;

import com.arialyy.aria.orm.DbEntity;

/* loaded from: classes3.dex */
public class ThreadRecord extends DbEntity {
    public long endLocation;
    public long startLocation;
    public String taskKey;
    public String tsUrl;
    public boolean isComplete = false;
    public int threadId = 0;
    public long blockLen = 0;
    public int threadType = 0;
}
