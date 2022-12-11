package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.URIUtil;

/* loaded from: classes4.dex */
public class MovedContextHandler extends ContextHandler {
    public boolean _discardPathInfo;
    public boolean _discardQuery;
    public String _expires;
    public String _newContextURL;
    public boolean _permanent;
    public final Redirector _redirector;

    /* loaded from: classes4.dex */
    public class Redirector extends AbstractHandler {
        public Redirector() {
        }

        @Override // org.eclipse.jetty.server.Handler
        public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
            MovedContextHandler movedContextHandler = MovedContextHandler.this;
            String str2 = movedContextHandler._newContextURL;
            if (str2 == null) {
                return;
            }
            if (!movedContextHandler._discardPathInfo && ae0Var.getPathInfo() != null) {
                str2 = URIUtil.addPaths(str2, ae0Var.getPathInfo());
            }
            StringBuilder sb = URIUtil.hasScheme(str2) ? new StringBuilder() : request.getRootURL();
            sb.append(str2);
            if (!MovedContextHandler.this._discardQuery && ae0Var.getQueryString() != null) {
                sb.append('?');
                sb.append(ae0Var.getQueryString().replaceAll("\r\n?&=", "!"));
            }
            ce0Var.setHeader("Location", sb.toString());
            String str3 = MovedContextHandler.this._expires;
            if (str3 != null) {
                ce0Var.setHeader("Expires", str3);
            }
            ce0Var.setStatus(MovedContextHandler.this._permanent ? 301 : 302);
            ce0Var.setContentLength(0);
            request.setHandled(true);
        }
    }

    public MovedContextHandler() {
        Redirector redirector = new Redirector();
        this._redirector = redirector;
        setHandler(redirector);
        setAllowNullPathInfo(true);
    }

    public MovedContextHandler(HandlerContainer handlerContainer, String str, String str2) {
        super(handlerContainer, str);
        this._newContextURL = str2;
        Redirector redirector = new Redirector();
        this._redirector = redirector;
        setHandler(redirector);
    }

    public String getExpires() {
        return this._expires;
    }

    public String getNewContextURL() {
        return this._newContextURL;
    }

    public boolean isDiscardPathInfo() {
        return this._discardPathInfo;
    }

    public boolean isDiscardQuery() {
        return this._discardQuery;
    }

    public boolean isPermanent() {
        return this._permanent;
    }

    public void setDiscardPathInfo(boolean z) {
        this._discardPathInfo = z;
    }

    public void setDiscardQuery(boolean z) {
        this._discardQuery = z;
    }

    public void setExpires(String str) {
        this._expires = str;
    }

    public void setNewContextURL(String str) {
        this._newContextURL = str;
    }

    public void setPermanent(boolean z) {
        this._permanent = z;
    }
}
