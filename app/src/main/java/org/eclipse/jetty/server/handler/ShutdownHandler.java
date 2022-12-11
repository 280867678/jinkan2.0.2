package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class ShutdownHandler extends AbstractHandler {
    public static final Logger LOG = Log.getLogger(ShutdownHandler.class);
    public boolean _exitJvm = false;
    public final Server _server;
    public final String _shutdownToken;

    public ShutdownHandler(Server server, String str) {
        this._server = server;
        this._shutdownToken = str;
    }

    private boolean hasCorrectSecurityToken(ae0 ae0Var) {
        return this._shutdownToken.equals(ae0Var.getParameter("token"));
    }

    private boolean requestFromLocalhost(ae0 ae0Var) {
        return "127.0.0.1".equals(getRemoteAddr(ae0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownServer() throws Exception {
        this._server.stop();
        if (this._exitJvm) {
            System.exit(0);
        }
    }

    public String getRemoteAddr(ae0 ae0Var) {
        return ae0Var.getRemoteAddr();
    }

    @Override // org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        if (!str.equals("/shutdown")) {
            return;
        }
        if (!ae0Var.getMethod().equals("POST")) {
            ce0Var.sendError(400);
        } else if (!hasCorrectSecurityToken(ae0Var)) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unauthorized shutdown attempt from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRemoteAddr(ae0Var));
            logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            ce0Var.sendError(401);
        } else if (!requestFromLocalhost(ae0Var)) {
            Logger logger2 = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unauthorized shutdown attempt from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getRemoteAddr(ae0Var));
            logger2.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
            ce0Var.sendError(401);
        } else {
            Logger logger3 = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Shutting down by request from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getRemoteAddr(ae0Var));
            logger3.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), new Object[0]);
            new Thread() { // from class: org.eclipse.jetty.server.handler.ShutdownHandler.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ShutdownHandler.this.shutdownServer();
                    } catch (InterruptedException e) {
                        ShutdownHandler.LOG.ignore(e);
                    } catch (Exception e2) {
                        throw new RuntimeException("Shutting down server", e2);
                    }
                }
            }.start();
        }
    }

    public void setExitJvm(boolean z) {
        this._exitJvm = z;
    }
}
