package org.eclipse.jetty.security;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public class RoleRunAsToken implements RunAsToken {
    public final String _runAsRole;

    public RoleRunAsToken(String str) {
        this._runAsRole = str;
    }

    public String getRunAsRole() {
        return this._runAsRole;
    }

    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RoleRunAsToken("), this._runAsRole, ")");
    }
}
