package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class ErrorHandler extends AbstractHandler {
    public static final String ERROR_PAGE = "org.eclipse.jetty.server.error_page";
    public static final Logger LOG = Log.getLogger(ErrorHandler.class);
    public boolean _showStacks = true;
    public boolean _showMessageInTitle = true;
    public String _cacheControl = "must-revalidate,no-cache,no-store";

    /* loaded from: classes4.dex */
    public interface ErrorPageMapper {
        String getErrorPage(ae0 ae0Var);
    }

    public String getCacheControl() {
        return this._cacheControl;
    }

    public boolean getShowMessageInTitle() {
        return this._showMessageInTitle;
    }

    @Override // org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException {
        String errorPage;
        String str2;
        AbstractHttpConnection currentConnection = AbstractHttpConnection.getCurrentConnection();
        String method = ae0Var.getMethod();
        if (!method.equals("GET") && !method.equals("POST") && !method.equals("HEAD")) {
            currentConnection.getRequest().setHandled(true);
            return;
        }
        if ((this instanceof ErrorPageMapper) && (errorPage = ((ErrorPageMapper) this).getErrorPage(ae0Var)) != null && ae0Var.getServletContext() != null && ((str2 = (String) ae0Var.getAttribute(ERROR_PAGE)) == null || !str2.equals(errorPage))) {
            ae0Var.setAttribute(ERROR_PAGE, errorPage);
            Dispatcher dispatcher = (Dispatcher) ae0Var.getServletContext().getRequestDispatcher(errorPage);
            try {
                if (dispatcher != null) {
                    dispatcher.error(ae0Var, ce0Var);
                    return;
                }
                Logger logger = LOG;
                logger.warn("No error page " + errorPage, new Object[0]);
            } catch (ServletException e) {
                LOG.warn(Log.EXCEPTION, e);
                return;
            }
        }
        currentConnection.getRequest().setHandled(true);
        ce0Var.setContentType(MimeTypes.TEXT_HTML_8859_1);
        String str3 = this._cacheControl;
        if (str3 != null) {
            ce0Var.setHeader("Cache-Control", str3);
        }
        ByteArrayISO8859Writer byteArrayISO8859Writer = new ByteArrayISO8859Writer(4096);
        handleErrorPage(ae0Var, byteArrayISO8859Writer, currentConnection.getResponse().getStatus(), currentConnection.getResponse().getReason());
        byteArrayISO8859Writer.flush();
        ce0Var.setContentLength(byteArrayISO8859Writer.size());
        byteArrayISO8859Writer.writeTo(ce0Var.getOutputStream());
        byteArrayISO8859Writer.destroy();
    }

    public void handleErrorPage(ae0 ae0Var, Writer writer, int i, String str) throws IOException {
        writeErrorPage(ae0Var, writer, i, str, this._showStacks);
    }

    public boolean isShowStacks() {
        return this._showStacks;
    }

    public void setCacheControl(String str) {
        this._cacheControl = str;
    }

    public void setShowMessageInTitle(boolean z) {
        this._showMessageInTitle = z;
    }

    public void setShowStacks(boolean z) {
        this._showStacks = z;
    }

    public void write(Writer writer, String str) throws IOException {
        String str2;
        if (str == null) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '&') {
                str2 = "&amp;";
            } else if (charAt == '<') {
                str2 = "&lt;";
            } else if (charAt != '>') {
                if (Character.isISOControl(charAt) && !Character.isWhitespace(charAt)) {
                    charAt = '?';
                }
                writer.write(charAt);
            } else {
                str2 = "&gt;";
            }
            writer.write(str2);
        }
    }

    public void writeErrorPage(ae0 ae0Var, Writer writer, int i, String str, boolean z) throws IOException {
        if (str == null) {
            str = HttpStatus.getMessage(i);
        }
        String str2 = str;
        writer.write("<html>\n<head>\n");
        writeErrorPageHead(ae0Var, writer, i, str2);
        writer.write("</head>\n<body>");
        writeErrorPageBody(ae0Var, writer, i, str2, z);
        writer.write("\n</body>\n</html>\n");
    }

    public void writeErrorPageBody(ae0 ae0Var, Writer writer, int i, String str, boolean z) throws IOException {
        writeErrorPageMessage(ae0Var, writer, i, str, ae0Var.getRequestURI());
        if (z) {
            writeErrorPageStacks(ae0Var, writer);
        }
        writer.write("<hr /><i><small>Powered by Jetty://</small></i>");
        for (int i2 = 0; i2 < 20; i2++) {
            writer.write("<br/>                                                \n");
        }
    }

    public void writeErrorPageHead(ae0 ae0Var, Writer writer, int i, String str) throws IOException {
        writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
        writer.write("<title>Error ");
        writer.write(Integer.toString(i));
        if (this._showMessageInTitle) {
            writer.write(32);
            write(writer, str);
        }
        writer.write("</title>\n");
    }

    public void writeErrorPageMessage(ae0 ae0Var, Writer writer, int i, String str, String str2) throws IOException {
        writer.write("<h2>HTTP ERROR ");
        writer.write(Integer.toString(i));
        writer.write("</h2>\n<p>Problem accessing ");
        write(writer, str2);
        writer.write(". Reason:\n<pre>    ");
        write(writer, str);
        writer.write("</pre></p>");
    }

    public void writeErrorPageStacks(ae0 ae0Var, Writer writer) throws IOException {
        for (Throwable th = (Throwable) ae0Var.getAttribute(RequestDispatcher.ERROR_EXCEPTION); th != null; th = th.getCause()) {
            writer.write("<h3>Caused by:</h3><pre>");
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            write(writer, stringWriter.getBuffer().toString());
            writer.write("</pre>\n");
        }
    }
}
