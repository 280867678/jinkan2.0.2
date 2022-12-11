package org.eclipse.jetty.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.outline;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;

/* loaded from: classes5.dex */
public class ErrorPageErrorHandler extends ErrorHandler implements ErrorHandler.ErrorPageMapper {
    public static final String GLOBAL_ERROR_PAGE = "org.eclipse.jetty.server.error_page.global";
    public ServletContext _servletContext;
    public final Map<String, String> _errorPages = new HashMap();
    public final List<ErrorCodeRange> _errorPageList = new ArrayList();

    /* loaded from: classes5.dex */
    public class ErrorCodeRange {
        public int _from;
        public int _to;
        public String _uri;

        public ErrorCodeRange(int i, int i2, String str) throws IllegalArgumentException {
            if (i <= i2) {
                this._from = i;
                this._to = i2;
                this._uri = str;
                return;
            }
            throw new IllegalArgumentException("from>to");
        }

        public String getUri() {
            return this._uri;
        }

        public boolean isInRange(int i) {
            return i >= this._from && i <= this._to;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("from: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._from);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",to: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._to);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",uri: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._uri);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public void addErrorPage(int i, int i2, String str) {
        this._errorPageList.add(new ErrorCodeRange(i, i2, str));
    }

    public void addErrorPage(int i, String str) {
        this._errorPages.put(Integer.toString(i), str);
    }

    public void addErrorPage(Class<? extends Throwable> cls, String str) {
        this._errorPages.put(cls.getName(), str);
    }

    public void addErrorPage(String str, String str2) {
        this._errorPages.put(str, str2);
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
        this._servletContext = ContextHandler.getCurrentContext();
    }

    @Override // org.eclipse.jetty.server.handler.ErrorHandler.ErrorPageMapper
    public String getErrorPage(ae0 ae0Var) {
        String str;
        Integer num;
        Class<?> cls = (Class) ae0Var.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
        if (ServletException.class.equals(cls)) {
            str = this._errorPages.get(cls.getName());
            if (str == null) {
                Throwable th = (Throwable) ae0Var.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
                while (th instanceof ServletException) {
                    th = ((ServletException) th).getRootCause();
                }
                if (th != null) {
                    cls = th.getClass();
                }
            }
        } else {
            str = null;
        }
        while (str == null && cls != null) {
            str = this._errorPages.get(cls.getName());
            cls = cls.getSuperclass();
        }
        if (str == null && (num = (Integer) ae0Var.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) != null && (str = this._errorPages.get(Integer.toString(num.intValue()))) == null && this._errorPageList != null) {
            int i = 0;
            while (true) {
                if (i >= this._errorPageList.size()) {
                    break;
                }
                ErrorCodeRange errorCodeRange = this._errorPageList.get(i);
                if (errorCodeRange.isInRange(num.intValue())) {
                    str = errorCodeRange.getUri();
                    break;
                }
                i++;
            }
        }
        return str == null ? this._errorPages.get(GLOBAL_ERROR_PAGE) : str;
    }

    public Map<String, String> getErrorPages() {
        return this._errorPages;
    }

    public void setErrorPages(Map<String, String> map) {
        this._errorPages.clear();
        if (map != null) {
            this._errorPages.putAll(map);
        }
    }
}
