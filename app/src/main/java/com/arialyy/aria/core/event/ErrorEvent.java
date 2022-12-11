package com.arialyy.aria.core.event;

/* loaded from: classes3.dex */
public class ErrorEvent {
    public String errorMsg;
    public long taskId;

    public ErrorEvent(long j, String str) {
        this.taskId = j;
        this.errorMsg = str;
    }
}
