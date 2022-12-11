package com.arialyy.aria.orm;

/* loaded from: classes3.dex */
public enum ActionPolicy {
    NO_ACTION("NO ACTION"),
    RESTRICT("RESTRICT"),
    SET_NULL("SET NULL"),
    SET_DEFAULT("SET ERROR"),
    CASCADE("CASCADE");
    
    public String function;

    ActionPolicy(String str) {
        this.function = str;
    }
}
