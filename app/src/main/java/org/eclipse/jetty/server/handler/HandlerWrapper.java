package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

/* loaded from: classes4.dex */
public class HandlerWrapper extends AbstractHandlerContainer {
    public Handler _handler;

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        if (isStopped()) {
            Handler handler = getHandler();
            if (handler != null) {
                setHandler(null);
                handler.destroy();
            }
            super.destroy();
            return;
        }
        throw new IllegalStateException("!STOPPED");
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        Handler handler = this._handler;
        if (handler != null) {
            handler.start();
        }
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        Handler handler = this._handler;
        if (handler != null) {
            handler.stop();
        }
        super.doStop();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer
    public Object expandChildren(Object obj, Class cls) {
        return expandHandler(this._handler, obj, cls);
    }

    public Handler getHandler() {
        return this._handler;
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    public Handler[] getHandlers() {
        Handler handler = this._handler;
        return handler == null ? new Handler[0] : new Handler[]{handler};
    }

    public <H extends Handler> H getNestedHandlerByClass(Class<H> cls) {
        HandlerWrapper handlerWrapper = this;
        while (handlerWrapper != null) {
            if (cls.isInstance(handlerWrapper)) {
                return handlerWrapper;
            }
            Handler handler = handlerWrapper.getHandler();
            if (!(handler instanceof HandlerWrapper)) {
                return null;
            }
            handlerWrapper = (HandlerWrapper) handler;
        }
        return null;
    }

    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        if (this._handler == null || !isStarted()) {
            return;
        }
        this._handler.handle(str, request, ae0Var, ce0Var);
    }

    public void setHandler(Handler handler) {
        if (!isStarted()) {
            Handler handler2 = this._handler;
            this._handler = handler;
            if (handler != null) {
                handler.setServer(getServer());
            }
            if (getServer() == null) {
                return;
            }
            getServer().getContainer().update(this, handler2, handler, "handler");
            return;
        }
        throw new IllegalStateException(AbstractLifeCycle.STARTED);
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        Server server2 = getServer();
        if (server == server2) {
            return;
        }
        if (isStarted()) {
            throw new IllegalStateException(AbstractLifeCycle.STARTED);
        }
        super.setServer(server);
        Handler handler = getHandler();
        if (handler != null) {
            handler.setServer(server);
        }
        if (server == null || server == server2) {
            return;
        }
        server.getContainer().update(this, (Object) null, this._handler, "handler");
    }
}
