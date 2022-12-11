package me.tvspark;

import java.security.PrivilegedAction;

/* loaded from: classes4.dex */
public class y81 implements PrivilegedAction<String> {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public y81(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // java.security.PrivilegedAction
    public String run() {
        String property = System.getProperty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (property == null) {
            return null;
        }
        return property;
    }
}
