package org.eclipse.jetty.continuation;

import com.umeng.umcrash.BuildConfig;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* loaded from: classes4.dex */
public class ContinuationFilter implements Filter {
    public static boolean __debug;
    public static boolean _initialized;
    public ServletContext _context;
    public boolean _debug;
    public boolean _faux;
    public boolean _filtered;
    public boolean _jetty6;

    /* loaded from: classes4.dex */
    public interface FilteredContinuation extends Continuation {
        boolean enter(ServletResponse servletResponse);

        boolean exit();
    }

    private void debug(String str) {
        if (this._debug) {
            this._context.log(str);
        }
    }

    private void debug(String str, Throwable th) {
        if (this._debug) {
            if (!(th instanceof ContinuationThrowable)) {
                this._context.log(str, th);
                return;
            }
            ServletContext servletContext = this._context;
            servletContext.log(str + ":" + th);
        }
    }

    @Override // javax.servlet.Filter
    public void destroy() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r1.enter(r8) != false) goto L19;
     */
    @Override // javax.servlet.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object obj;
        if (!this._filtered) {
            try {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } catch (ContinuationThrowable e) {
                debug("caught", e);
                return;
            }
        }
        Object obj2 = (Continuation) servletRequest.getAttribute(Continuation.ATTRIBUTE);
        if (!this._faux || (obj2 != null && (obj2 instanceof FauxContinuation))) {
            obj = (FilteredContinuation) obj2;
        } else {
            obj = new FauxContinuation(servletRequest);
            servletRequest.setAttribute(Continuation.ATTRIBUTE, obj);
        }
        while (true) {
            boolean z = false;
            while (!z) {
                z = true;
                if (obj != null) {
                    try {
                        try {
                        } catch (ContinuationThrowable e2) {
                            debug("faux", e2);
                            if (obj == null) {
                                obj = (FilteredContinuation) servletRequest.getAttribute(Continuation.ATTRIBUTE);
                            }
                            if (obj == null) {
                                continue;
                            } else if (obj.exit()) {
                            }
                        }
                    } catch (Throwable th) {
                        if (obj == null) {
                            obj = (FilteredContinuation) servletRequest.getAttribute(Continuation.ATTRIBUTE);
                        }
                        if (obj != null) {
                            obj.exit();
                        }
                        throw th;
                    }
                }
                filterChain.doFilter(servletRequest, servletResponse);
                if (obj == null) {
                    obj = (FilteredContinuation) servletRequest.getAttribute(Continuation.ATTRIBUTE);
                }
                if (obj != null && !obj.exit()) {
                    break;
                }
            }
            return;
        }
    }

    @Override // javax.servlet.Filter
    public void init(FilterConfig filterConfig) throws ServletException {
        boolean equals = "org.eclipse.jetty.servlet".equals(filterConfig.getClass().getPackage().getName());
        this._context = filterConfig.getServletContext();
        String initParameter = filterConfig.getInitParameter(BuildConfig.BUILD_TYPE);
        boolean z = false;
        boolean z2 = initParameter != null && Boolean.parseBoolean(initParameter);
        this._debug = z2;
        if (z2) {
            __debug = true;
        }
        String initParameter2 = filterConfig.getInitParameter("jetty6");
        if (initParameter2 == null) {
            initParameter2 = filterConfig.getInitParameter("partial");
        }
        this._jetty6 = initParameter2 != null ? Boolean.parseBoolean(initParameter2) : ContinuationSupport.__jetty6 && !equals;
        String initParameter3 = filterConfig.getInitParameter("faux");
        this._faux = initParameter3 != null ? Boolean.parseBoolean(initParameter3) : !equals && !this._jetty6 && this._context.getMajorVersion() < 3;
        if (this._faux || this._jetty6) {
            z = true;
        }
        this._filtered = z;
        if (this._debug) {
            ServletContext servletContext = this._context;
            servletContext.log("ContinuationFilter  jetty=" + equals + " jetty6=" + this._jetty6 + " faux=" + this._faux + " filtered=" + this._filtered + " servlet3=" + ContinuationSupport.__servlet3);
        }
        _initialized = true;
    }
}
