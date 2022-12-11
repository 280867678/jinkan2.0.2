package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;

/* loaded from: classes4.dex */
public abstract class ScopedHandler extends HandlerWrapper {
    public static final ThreadLocal<ScopedHandler> __outerScope = new ThreadLocal<>();
    public ScopedHandler _nextScope;
    public ScopedHandler _outerScope;

    public abstract void doHandle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException;

    public abstract void doScope(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException;

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        try {
            ScopedHandler scopedHandler = __outerScope.get();
            this._outerScope = scopedHandler;
            if (scopedHandler == null) {
                __outerScope.set(this);
            }
            super.doStart();
            this._nextScope = (ScopedHandler) getChildHandlerByClass(ScopedHandler.class);
        } finally {
            if (this._outerScope == null) {
                __outerScope.set(null);
            }
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public final void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        if (this._outerScope == null) {
            doScope(str, request, ae0Var, ce0Var);
        } else {
            doHandle(str, request, ae0Var, ce0Var);
        }
    }

    public boolean never() {
        return false;
    }

    public final void nextHandle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        ScopedHandler scopedHandler = this._nextScope;
        if (scopedHandler != null && scopedHandler == this._handler) {
            scopedHandler.doHandle(str, request, ae0Var, ce0Var);
            return;
        }
        Handler handler = this._handler;
        if (handler == null) {
            return;
        }
        handler.handle(str, request, ae0Var, ce0Var);
    }

    public final void nextScope(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        ScopedHandler scopedHandler = this._nextScope;
        if (scopedHandler != null) {
            scopedHandler.doScope(str, request, ae0Var, ce0Var);
            return;
        }
        ScopedHandler scopedHandler2 = this._outerScope;
        if (scopedHandler2 != null) {
            scopedHandler2.doHandle(str, request, ae0Var, ce0Var);
        } else {
            doHandle(str, request, ae0Var, ce0Var);
        }
    }
}
