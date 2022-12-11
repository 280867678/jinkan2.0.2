package org.apache.http.protocol;

import me.tvspark.outline;
import org.apache.http.util.Args;

@Deprecated
/* loaded from: classes4.dex */
public final class DefaultedHttpContext implements HttpContext {
    public final HttpContext defaults;
    public final HttpContext local;

    public DefaultedHttpContext(HttpContext httpContext, HttpContext httpContext2) {
        this.local = (HttpContext) Args.notNull(httpContext, "HTTP context");
        this.defaults = httpContext2;
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String str) {
        Object attribute = this.local.getAttribute(str);
        return attribute == null ? this.defaults.getAttribute(str) : attribute;
    }

    public HttpContext getDefaults() {
        return this.defaults;
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        return this.local.removeAttribute(str);
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        this.local.setAttribute(str, obj);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[local: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.local);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("defaults: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.defaults);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
