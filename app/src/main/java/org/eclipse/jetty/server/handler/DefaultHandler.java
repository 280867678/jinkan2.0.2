package org.eclipse.jetty.server.handler;

import androidx.recyclerview.widget.FastScroller;
import com.just.agentweb.DefaultWebClient;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes4.dex */
public class DefaultHandler extends AbstractHandler {
    public static final Logger LOG = Log.getLogger(DefaultHandler.class);
    public byte[] _favicon;
    public final long _faviconModified = (System.currentTimeMillis() / 1000) * 1000;
    public boolean _serveIcon = true;
    public boolean _showContexts = true;

    public DefaultHandler() {
        try {
            URL resource = getClass().getClassLoader().getResource("org/eclipse/jetty/favicon.ico");
            if (resource == null) {
                return;
            }
            this._favicon = C3009IO.readBytes(Resource.newResource(resource).getInputStream());
        } catch (Exception e) {
            LOG.warn(e);
        }
    }

    public boolean getServeIcon() {
        return this._serveIcon;
    }

    public boolean getShowContexts() {
        return this._showContexts;
    }

    @Override // org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        String str2;
        if (ce0Var.isCommitted() || request.isHandled()) {
            return;
        }
        request.setHandled(true);
        String method = ae0Var.getMethod();
        if (this._serveIcon && this._favicon != null && method.equals("GET") && ae0Var.getRequestURI().equals("/favicon.ico")) {
            if (ae0Var.getDateHeader("If-Modified-Since") == this._faviconModified) {
                ce0Var.setStatus(304);
                return;
            }
            ce0Var.setStatus(200);
            ce0Var.setContentType("image/x-icon");
            ce0Var.setContentLength(this._favicon.length);
            ce0Var.setDateHeader("Last-Modified", this._faviconModified);
            ce0Var.setHeader("Cache-Control", "max-age=360000,public");
            ce0Var.getOutputStream().write(this._favicon);
        } else if (!method.equals("GET") || !ae0Var.getRequestURI().equals("/")) {
            ce0Var.sendError(404);
        } else {
            ce0Var.setStatus(404);
            ce0Var.setContentType("text/html");
            ByteArrayISO8859Writer byteArrayISO8859Writer = new ByteArrayISO8859Writer((int) FastScroller.HIDE_DELAY_AFTER_VISIBLE_MS);
            byteArrayISO8859Writer.write("<HTML>\n<HEAD>\n<TITLE>Error 404 - Not Found");
            byteArrayISO8859Writer.write("</TITLE>\n<BODY>\n<H2>Error 404 - Not Found.</H2>\n");
            byteArrayISO8859Writer.write("No context on this server matched or handled this request.<BR>");
            if (this._showContexts) {
                byteArrayISO8859Writer.write("Contexts known to this server are: <ul>");
                Server server = getServer();
                Handler[] childHandlersByClass = server == null ? null : server.getChildHandlersByClass(ContextHandler.class);
                for (int i = 0; childHandlersByClass != null && i < childHandlersByClass.length; i++) {
                    ContextHandler contextHandler = (ContextHandler) childHandlersByClass[i];
                    if (contextHandler.isRunning()) {
                        byteArrayISO8859Writer.write("<li><a href=\"");
                        if (contextHandler.getVirtualHosts() != null && contextHandler.getVirtualHosts().length > 0) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(contextHandler.getVirtualHosts()[0]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ae0Var.getLocalPort());
                            byteArrayISO8859Writer.write(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        byteArrayISO8859Writer.write(contextHandler.getContextPath());
                        if (contextHandler.getContextPath().length() > 1 && contextHandler.getContextPath().endsWith("/")) {
                            byteArrayISO8859Writer.write("/");
                        }
                        byteArrayISO8859Writer.write("\">");
                        byteArrayISO8859Writer.write(contextHandler.getContextPath());
                        if (contextHandler.getVirtualHosts() != null && contextHandler.getVirtualHosts().length > 0) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("&nbsp;@&nbsp;");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(contextHandler.getVirtualHosts()[0]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(ae0Var.getLocalPort());
                            byteArrayISO8859Writer.write(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                        byteArrayISO8859Writer.write("&nbsp;--->&nbsp;");
                        byteArrayISO8859Writer.write(contextHandler.toString());
                        str2 = "</a></li>\n";
                    } else {
                        byteArrayISO8859Writer.write("<li>");
                        byteArrayISO8859Writer.write(contextHandler.getContextPath());
                        if (contextHandler.getVirtualHosts() != null && contextHandler.getVirtualHosts().length > 0) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("&nbsp;@&nbsp;");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(contextHandler.getVirtualHosts()[0]);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(":");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(ae0Var.getLocalPort());
                            byteArrayISO8859Writer.write(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                        }
                        byteArrayISO8859Writer.write("&nbsp;--->&nbsp;");
                        byteArrayISO8859Writer.write(contextHandler.toString());
                        if (contextHandler.isFailed()) {
                            byteArrayISO8859Writer.write(" [failed]");
                        }
                        if (contextHandler.isStopped()) {
                            byteArrayISO8859Writer.write(" [stopped]");
                        }
                        str2 = "</li>\n";
                    }
                    byteArrayISO8859Writer.write(str2);
                }
            }
            for (int i2 = 0; i2 < 10; i2++) {
                byteArrayISO8859Writer.write("\n<!-- Padding for IE                  -->");
            }
            byteArrayISO8859Writer.write("\n</BODY>\n</HTML>\n");
            byteArrayISO8859Writer.flush();
            ce0Var.setContentLength(byteArrayISO8859Writer.size());
            ServletOutputStream outputStream = ce0Var.getOutputStream();
            byteArrayISO8859Writer.writeTo(outputStream);
            outputStream.close();
        }
    }

    public void setServeIcon(boolean z) {
        this._serveIcon = z;
    }

    public void setShowContexts(boolean z) {
        this._showContexts = z;
    }
}
