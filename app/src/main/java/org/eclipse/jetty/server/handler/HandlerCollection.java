package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

/* loaded from: classes4.dex */
public class HandlerCollection extends AbstractHandlerContainer {
    public volatile Handler[] _handlers;
    public final boolean _mutableWhenRunning;
    public boolean _parallelStart;

    public HandlerCollection() {
        this._parallelStart = false;
        this._mutableWhenRunning = false;
    }

    public HandlerCollection(boolean z) {
        this._parallelStart = false;
        this._mutableWhenRunning = z;
    }

    public void addHandler(Handler handler) {
        setHandlers((Handler[]) LazyList.addToArray(getHandlers(), handler, Handler.class));
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        if (isStopped()) {
            Handler[] childHandlers = getChildHandlers();
            setHandlers(null);
            for (Handler handler : childHandlers) {
                handler.destroy();
            }
            super.destroy();
            return;
        }
        throw new IllegalStateException("!STOPPED");
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        final MultiException multiException = new MultiException();
        if (this._handlers != null) {
            if (this._parallelStart) {
                final CountDownLatch countDownLatch = new CountDownLatch(this._handlers.length);
                final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                for (int i = 0; i < this._handlers.length; i++) {
                    final int i2 = i;
                    getServer().getThreadPool().dispatch(new Runnable() { // from class: org.eclipse.jetty.server.handler.HandlerCollection.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ClassLoader contextClassLoader2 = Thread.currentThread().getContextClassLoader();
                            try {
                                Thread.currentThread().setContextClassLoader(contextClassLoader);
                                HandlerCollection.this._handlers[i2].start();
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    });
                }
                countDownLatch.await();
            } else {
                for (int i3 = 0; i3 < this._handlers.length; i3++) {
                    try {
                        this._handlers[i3].start();
                    } catch (Throwable th) {
                        multiException.add(th);
                    }
                }
            }
        }
        super.doStart();
        multiException.ifExceptionThrow();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        MultiException multiException = new MultiException();
        try {
            super.doStop();
        } catch (Throwable th) {
            multiException.add(th);
        }
        if (this._handlers != null) {
            int length = this._handlers.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    break;
                }
                try {
                    this._handlers[i].stop();
                } catch (Throwable th2) {
                    multiException.add(th2);
                }
                length = i;
            }
        }
        multiException.ifExceptionThrow();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer
    public Object expandChildren(Object obj, Class cls) {
        Handler[] handlers = getHandlers();
        for (int i = 0; handlers != null && i < handlers.length; i++) {
            obj = expandHandler(handlers[i], obj, cls);
        }
        return obj;
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    public Handler[] getHandlers() {
        return this._handlers;
    }

    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        if (this._handlers == null || !isStarted()) {
            return;
        }
        MultiException multiException = null;
        for (int i = 0; i < this._handlers.length; i++) {
            try {
                this._handlers[i].handle(str, request, ae0Var, ce0Var);
            } catch (IOException e) {
                throw e;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                if (multiException == null) {
                    multiException = new MultiException();
                }
                multiException.add(e3);
            }
        }
        if (multiException == null) {
            return;
        }
        if (multiException.size() != 1) {
            throw new ServletException(multiException);
        }
        throw new ServletException(multiException.getThrowable(0));
    }

    public boolean isParallelStart() {
        return this._parallelStart;
    }

    public void removeHandler(Handler handler) {
        Handler[] handlers = getHandlers();
        if (handlers == null || handlers.length <= 0) {
            return;
        }
        setHandlers((Handler[]) LazyList.removeFromArray(handlers, handler));
    }

    public void setHandlers(Handler[] handlerArr) {
        if (this._mutableWhenRunning || !isStarted()) {
            Handler[] handlerArr2 = this._handlers == null ? null : (Handler[]) this._handlers.clone();
            this._handlers = handlerArr;
            Server server = getServer();
            MultiException multiException = new MultiException();
            for (int i = 0; handlerArr != null && i < handlerArr.length; i++) {
                if (handlerArr[i].getServer() != server) {
                    handlerArr[i].setServer(server);
                }
            }
            if (getServer() != null) {
                getServer().getContainer().update((Object) this, (Object[]) handlerArr2, (Object[]) handlerArr, "handler");
            }
            for (int i2 = 0; handlerArr2 != null && i2 < handlerArr2.length; i2++) {
                if (handlerArr2[i2] != null) {
                    try {
                        if (handlerArr2[i2].isStarted()) {
                            handlerArr2[i2].stop();
                        }
                    } catch (Throwable th) {
                        multiException.add(th);
                    }
                }
            }
            multiException.ifExceptionThrowRuntime();
            return;
        }
        throw new IllegalStateException(AbstractLifeCycle.STARTED);
    }

    public void setParallelStart(boolean z) {
        this._parallelStart = z;
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        if (!isStarted()) {
            Server server2 = getServer();
            super.setServer(server);
            Handler[] handlers = getHandlers();
            for (int i = 0; handlers != null && i < handlers.length; i++) {
                handlers[i].setServer(server);
            }
            if (server == null || server == server2) {
                return;
            }
            server.getContainer().update((Object) this, (Object[]) null, (Object[]) this._handlers, "handler");
            return;
        }
        throw new IllegalStateException(AbstractLifeCycle.STARTED);
    }
}
