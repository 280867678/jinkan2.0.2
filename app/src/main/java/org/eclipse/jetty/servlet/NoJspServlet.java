package org.eclipse.jetty.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import me.tvspark.ae0;
import me.tvspark.ce0;

/* loaded from: classes5.dex */
public class NoJspServlet extends HttpServlet {
    public boolean _warned;

    @Override // javax.servlet.http.HttpServlet
    public void doGet(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        if (!this._warned) {
            getServletContext().log("No JSP support.  Check that JSP jars are in lib/jsp and that the JSP option has been specified to start.jar");
        }
        this._warned = true;
        ce0Var.sendError(500, "JSP support not configured");
    }
}
