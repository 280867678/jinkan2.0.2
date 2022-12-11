package org.eclipse.jetty.client.security;

import java.io.IOException;
import me.tvspark.outline;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.util.B64Code;

/* loaded from: classes4.dex */
public class BasicAuthentication implements Authentication {
    public Buffer _authorization;

    public BasicAuthentication(Realm realm) throws IOException {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Basic ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(B64Code.encode(realm.getPrincipal() + ":" + realm.getCredentials(), "ISO-8859-1"));
        this._authorization = new ByteArrayBuffer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // org.eclipse.jetty.client.security.Authentication
    public void setCredentials(HttpExchange httpExchange) throws IOException {
        httpExchange.setRequestHeader(HttpHeaders.AUTHORIZATION_BUFFER, this._authorization);
    }
}
