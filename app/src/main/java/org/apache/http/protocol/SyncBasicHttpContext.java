package org.apache.http.protocol;

@Deprecated
/* loaded from: classes4.dex */
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext() {
    }

    public SyncBasicHttpContext(HttpContext httpContext) {
        super(httpContext);
    }

    @Override // org.apache.http.protocol.BasicHttpContext
    public synchronized void clear() {
        super.clear();
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object getAttribute(String str) {
        return super.getAttribute(str);
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object removeAttribute(String str) {
        return super.removeAttribute(str);
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized void setAttribute(String str, Object obj) {
        super.setAttribute(str, obj);
    }
}
