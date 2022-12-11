package org.simpleframework.xml.core;

/* loaded from: classes5.dex */
public enum MethodType {
    GET(3),
    IS(2),
    SET(3),
    NONE(0);
    
    public int prefix;

    MethodType(int i) {
        this.prefix = i;
    }

    public int getPrefix() {
        return this.prefix;
    }
}
