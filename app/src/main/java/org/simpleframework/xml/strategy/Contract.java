package org.simpleframework.xml.strategy;

/* loaded from: classes5.dex */
public class Contract {
    public String label;
    public String length;
    public String mark;
    public String refer;

    public Contract(String str, String str2, String str3, String str4) {
        this.length = str4;
        this.label = str3;
        this.refer = str2;
        this.mark = str;
    }

    public String getIdentity() {
        return this.mark;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLength() {
        return this.length;
    }

    public String getReference() {
        return this.refer;
    }
}
