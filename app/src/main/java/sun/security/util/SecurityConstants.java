package sun.security.util;

import java.net.NetPermission;
import java.net.SocketPermission;
import java.security.AllPermission;
import java.security.BasicPermission;
import java.security.SecurityPermission;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public final class SecurityConstants {
    public static final RuntimePermission Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RuntimePermission("getClassLoader");

    /* loaded from: classes5.dex */
    public static class FakeAWTPermission extends BasicPermission {
        public static final long serialVersionUID = -1;

        public FakeAWTPermission(String str) {
            super(str);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(\"java.awt.AWTPermission\" \"");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\")");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    static {
        new AllPermission();
        new NetPermission("specifyStreamHandler");
        new NetPermission("setProxySelector");
        new NetPermission("getProxySelector");
        new NetPermission("setCookieHandler");
        new NetPermission("getCookieHandler");
        new NetPermission("setResponseCache");
        new NetPermission("getResponseCache");
        new RuntimePermission("createClassLoader");
        new RuntimePermission("accessDeclaredMembers");
        new RuntimePermission("modifyThread");
        new RuntimePermission("modifyThreadGroup");
        new RuntimePermission("getProtectionDomain");
        new RuntimePermission("stopThread");
        new RuntimePermission("getStackTrace");
        new SecurityPermission("createAccessControlContext");
        new SecurityPermission("getDomainCombiner");
        new SecurityPermission("getPolicy");
        new SocketPermission("localhost:1024-", "listen");
    }
}
