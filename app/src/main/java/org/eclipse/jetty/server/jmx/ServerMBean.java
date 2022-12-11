package org.eclipse.jetty.server.jmx;

import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/* loaded from: classes4.dex */
public class ServerMBean extends ObjectMBean {
    public final Server server;
    public final long startupTime = System.currentTimeMillis();

    public ServerMBean(Object obj) {
        super(obj);
        this.server = (Server) obj;
    }

    public Handler[] getContexts() {
        return this.server.getChildHandlersByClass(ContextHandler.class);
    }

    public long getStartupTime() {
        return this.startupTime;
    }
}
