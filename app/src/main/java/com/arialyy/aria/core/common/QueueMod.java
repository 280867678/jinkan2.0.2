package com.arialyy.aria.core.common;

/* loaded from: classes3.dex */
public enum QueueMod {
    WAIT("wait"),
    NOW("now");
    
    public String tag;

    QueueMod(String str) {
        this.tag = str;
    }

    public String getTag() {
        return this.tag;
    }
}
