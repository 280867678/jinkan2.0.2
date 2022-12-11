package javax.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.le0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.MimeTypes;

/* loaded from: classes4.dex */
public abstract class HttpServlet extends GenericServlet implements Serializable {
    public static final String HEADER_IFMODSINCE = "If-Modified-Since";
    public static final String HEADER_LASTMOD = "Last-Modified";
    public static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    public static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");

    private Method[] getAllDeclaredMethods(Class<?> cls) {
        if (cls.equals(HttpServlet.class)) {
            return null;
        }
        Method[] allDeclaredMethods = getAllDeclaredMethods(cls.getSuperclass());
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (allDeclaredMethods == null || allDeclaredMethods.length <= 0) {
            return declaredMethods;
        }
        Method[] methodArr = new Method[allDeclaredMethods.length + declaredMethods.length];
        System.arraycopy(allDeclaredMethods, 0, methodArr, 0, allDeclaredMethods.length);
        System.arraycopy(declaredMethods, 0, methodArr, allDeclaredMethods.length, declaredMethods.length);
        return methodArr;
    }

    private void maybeSetLastModified(ce0 ce0Var, long j) {
        if (!ce0Var.containsHeader("Last-Modified") && j >= 0) {
            ce0Var.setDateHeader("Last-Modified", j);
        }
    }

    public void doDelete(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String protocol = ae0Var.getProtocol();
        ce0Var.sendError(protocol.endsWith("1.1") ? 405 : 400, lStrings.getString("http.method_delete_not_supported"));
    }

    public void doGet(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String protocol = ae0Var.getProtocol();
        ce0Var.sendError(protocol.endsWith("1.1") ? 405 : 400, lStrings.getString("http.method_get_not_supported"));
    }

    public void doHead(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        le0 le0Var = new le0(ce0Var);
        doGet(ae0Var, le0Var);
        if (!le0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            PrintWriter printWriter = le0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (printWriter != null) {
                printWriter.flush();
            }
            le0Var.setContentLength(le0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void doOptions(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        Method[] allDeclaredMethods;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (Method method : getAllDeclaredMethods(getClass())) {
            if (method.getName().equals("doGet")) {
                z = true;
                z2 = true;
            }
            if (method.getName().equals("doPost")) {
                z3 = true;
            }
            if (method.getName().equals("doPut")) {
                z4 = true;
            }
            if (method.getName().equals("doDelete")) {
                z5 = true;
            }
        }
        String str = null;
        if (z) {
            str = "GET";
        }
        if (z2) {
            str = str == null ? "HEAD" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ", HEAD");
        }
        if (z3) {
            str = str == null ? "POST" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ", POST");
        }
        if (z4) {
            str = str == null ? "PUT" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ", PUT");
        }
        if (z5) {
            str = str == null ? "DELETE" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ", DELETE");
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str == null ? "TRACE" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ", TRACE");
        ce0Var.setHeader("Allow", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? "OPTIONS" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ", OPTIONS"));
    }

    public void doPost(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String protocol = ae0Var.getProtocol();
        ce0Var.sendError(protocol.endsWith("1.1") ? 405 : 400, lStrings.getString("http.method_post_not_supported"));
    }

    public void doPut(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String protocol = ae0Var.getProtocol();
        ce0Var.sendError(protocol.endsWith("1.1") ? 405 : 400, lStrings.getString("http.method_put_not_supported"));
    }

    public void doTrace(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder("TRACE ");
        sb.append(ae0Var.getRequestURI());
        sb.append(StringUtils.SPACE);
        sb.append(ae0Var.getProtocol());
        Enumeration<String> headerNames = ae0Var.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "\r\n", nextElement, ": ");
            sb.append(ae0Var.getHeader(nextElement));
        }
        sb.append("\r\n");
        int length = sb.length();
        ce0Var.setContentType(MimeTypes.MESSAGE_HTTP);
        ce0Var.setContentLength(length);
        ce0Var.getOutputStream().print(sb.toString());
    }

    public long getLastModified(ae0 ae0Var) {
        return -1L;
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        try {
            service((ae0) servletRequest, (ce0) servletResponse);
        } catch (ClassCastException unused) {
            throw new ServletException("non-HTTP request or response");
        }
    }

    public void service(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String method = ae0Var.getMethod();
        if (method.equals("GET")) {
            long lastModified = getLastModified(ae0Var);
            if (lastModified != -1) {
                if (ae0Var.getDateHeader("If-Modified-Since") >= lastModified) {
                    ce0Var.setStatus(304);
                    return;
                }
                maybeSetLastModified(ce0Var, lastModified);
            }
            doGet(ae0Var, ce0Var);
        } else if (method.equals("HEAD")) {
            maybeSetLastModified(ce0Var, getLastModified(ae0Var));
            doHead(ae0Var, ce0Var);
        } else if (method.equals("POST")) {
            doPost(ae0Var, ce0Var);
        } else if (method.equals("PUT")) {
            doPut(ae0Var, ce0Var);
        } else if (method.equals("DELETE")) {
            doDelete(ae0Var, ce0Var);
        } else if (method.equals("OPTIONS")) {
            doOptions(ae0Var, ce0Var);
        } else if (method.equals("TRACE")) {
            doTrace(ae0Var, ce0Var);
        } else {
            ce0Var.sendError(501, MessageFormat.format(lStrings.getString("http.method_not_implemented"), method));
        }
    }
}
