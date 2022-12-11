package org.fourthline.cling.model;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class DiscoveryOptions {
    public static String simpleName = "DiscoveryOptions";
    public boolean advertised;
    public boolean byeByeBeforeFirstAlive;

    public DiscoveryOptions(boolean z) {
        this.advertised = z;
    }

    public DiscoveryOptions(boolean z, boolean z2) {
        this.advertised = z;
        this.byeByeBeforeFirstAlive = z2;
    }

    public boolean isAdvertised() {
        return this.advertised;
    }

    public boolean isByeByeBeforeFirstAlive() {
        return this.byeByeBeforeFirstAlive;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(simpleName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" advertised: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(isAdvertised());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" byebyeBeforeFirstAlive: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(isByeByeBeforeFirstAlive());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
