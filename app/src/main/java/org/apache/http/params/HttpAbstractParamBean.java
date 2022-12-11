package org.apache.http.params;

import org.apache.http.util.Args;

@Deprecated
/* loaded from: classes4.dex */
public abstract class HttpAbstractParamBean {
    public final HttpParams params;

    public HttpAbstractParamBean(HttpParams httpParams) {
        this.params = (HttpParams) Args.notNull(httpParams, "HTTP parameters");
    }
}
