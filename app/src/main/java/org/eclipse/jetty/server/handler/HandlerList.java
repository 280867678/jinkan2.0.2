package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;

/* loaded from: classes4.dex */
public class HandlerList extends HandlerCollection {
    @Override // org.eclipse.jetty.server.handler.HandlerCollection, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        Handler[] handlers = getHandlers();
        if (handlers == null || !isStarted()) {
            return;
        }
        for (Handler handler : handlers) {
            handler.handle(str, request, ae0Var, ce0Var);
            if (request.isHandled()) {
                return;
            }
        }
    }
}
