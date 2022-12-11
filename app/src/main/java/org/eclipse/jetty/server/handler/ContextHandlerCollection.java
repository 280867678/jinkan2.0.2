package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import okhttp3.CertificatePinner;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class ContextHandlerCollection extends HandlerCollection {
    public static final Logger LOG = Log.getLogger(ContextHandlerCollection.class);
    public Class<? extends ContextHandler> _contextClass = ContextHandler.class;
    public volatile PathMap _contextMap;

    public ContextHandlerCollection() {
        super(true);
    }

    private String normalizeHostname(String str) {
        if (str == null) {
            return null;
        }
        return str.endsWith(".") ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -1, 0) : str;
    }

    public ContextHandler addContext(String str, String str2) {
        try {
            ContextHandler newInstance = this._contextClass.newInstance();
            newInstance.setContextPath(str);
            newInstance.setResourceBase(str2);
            addHandler(newInstance);
            return newInstance;
        } catch (Exception e) {
            LOG.debug(e);
            throw new Error(e);
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerCollection, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        mapContexts();
        super.doStart();
    }

    public Class getContextClass() {
        return this._contextClass;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerCollection, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        ContextHandler contextHandler;
        Handler[] handlers = getHandlers();
        if (handlers == null || handlers.length == 0) {
            return;
        }
        AsyncContinuation asyncContinuation = request.getAsyncContinuation();
        if (asyncContinuation.isAsync() && (contextHandler = asyncContinuation.getContextHandler()) != null) {
            contextHandler.handle(str, request, ae0Var, ce0Var);
            return;
        }
        PathMap pathMap = this._contextMap;
        if (pathMap == null || str == null || !str.startsWith("/")) {
            for (Handler handler : handlers) {
                handler.handle(str, request, ae0Var, ce0Var);
                if (request.isHandled()) {
                    return;
                }
            }
            return;
        }
        Object lazyMatches = pathMap.getLazyMatches(str);
        for (int i = 0; i < LazyList.size(lazyMatches); i++) {
            Object value = ((Map.Entry) LazyList.get(lazyMatches, i)).getValue();
            if (value instanceof Map) {
                Map map = (Map) value;
                String normalizeHostname = normalizeHostname(ae0Var.getServerName());
                Object obj = map.get(normalizeHostname);
                for (int i2 = 0; i2 < LazyList.size(obj); i2++) {
                    ((Handler) LazyList.get(obj, i2)).handle(str, request, ae0Var, ce0Var);
                    if (request.isHandled()) {
                        return;
                    }
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CertificatePinner.WILDCARD);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(normalizeHostname.substring(normalizeHostname.indexOf(".") + 1));
                Object obj2 = map.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                for (int i3 = 0; i3 < LazyList.size(obj2); i3++) {
                    ((Handler) LazyList.get(obj2, i3)).handle(str, request, ae0Var, ce0Var);
                    if (request.isHandled()) {
                        return;
                    }
                }
                Object obj3 = map.get("*");
                for (int i4 = 0; i4 < LazyList.size(obj3); i4++) {
                    ((Handler) LazyList.get(obj3, i4)).handle(str, request, ae0Var, ce0Var);
                    if (request.isHandled()) {
                        return;
                    }
                }
                continue;
            } else {
                for (int i5 = 0; i5 < LazyList.size(value); i5++) {
                    ((Handler) LazyList.get(value, i5)).handle(str, request, ae0Var, ce0Var);
                    if (request.isHandled()) {
                        return;
                    }
                }
                continue;
            }
        }
    }

    public void mapContexts() {
        Handler[] childHandlersByClass;
        Map map;
        PathMap pathMap = new PathMap();
        Handler[] handlers = getHandlers();
        for (int i = 0; handlers != null && i < handlers.length; i++) {
            if (handlers[i] instanceof ContextHandler) {
                childHandlersByClass = new Handler[]{handlers[i]};
            } else if (handlers[i] instanceof HandlerContainer) {
                childHandlersByClass = ((HandlerContainer) handlers[i]).getChildHandlersByClass(ContextHandler.class);
            } else {
                continue;
            }
            for (Handler handler : childHandlersByClass) {
                ContextHandler contextHandler = (ContextHandler) handler;
                String contextPath = contextHandler.getContextPath();
                if (contextPath == null || contextPath.indexOf(44) >= 0 || contextPath.startsWith("*")) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal context spec:", contextPath));
                }
                if (!contextPath.startsWith("/")) {
                    contextPath = '/' + contextPath;
                }
                if (contextPath.length() > 1) {
                    if (contextPath.endsWith("/")) {
                        contextPath = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contextPath, "*");
                    } else if (!contextPath.endsWith("/*")) {
                        contextPath = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contextPath, "/*");
                    }
                }
                Object obj = pathMap.get(contextPath);
                String[] virtualHosts = contextHandler.getVirtualHosts();
                if (virtualHosts != null && virtualHosts.length > 0) {
                    if (obj instanceof Map) {
                        map = (Map) obj;
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("*", obj);
                        pathMap.put(contextPath, hashMap);
                        map = hashMap;
                    }
                    for (String str : virtualHosts) {
                        map.put(str, LazyList.add(map.get(str), handlers[i]));
                    }
                } else if (obj instanceof Map) {
                    Map map2 = (Map) obj;
                    map2.put("*", LazyList.add(map2.get("*"), handlers[i]));
                } else {
                    pathMap.put(contextPath, LazyList.add(obj, handlers[i]));
                }
            }
            continue;
        }
        this._contextMap = pathMap;
    }

    public void setContextClass(Class cls) {
        if (cls == null || !ContextHandler.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException();
        }
        this._contextClass = cls;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerCollection
    public void setHandlers(Handler[] handlerArr) {
        this._contextMap = null;
        super.setHandlers(handlerArr);
        if (isStarted()) {
            mapContexts();
        }
    }
}
