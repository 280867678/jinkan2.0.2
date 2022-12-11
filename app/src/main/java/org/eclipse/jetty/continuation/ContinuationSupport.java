package org.eclipse.jetty.continuation;

import java.lang.reflect.Constructor;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;

/* loaded from: classes4.dex */
public class ContinuationSupport {
    public static final boolean __jetty6;
    public static final Constructor<? extends Continuation> __newJetty6Continuation;
    public static final Constructor<? extends Continuation> __newServlet3Continuation;
    public static final boolean __servlet3;
    public static final Class<?> __waitingContinuation;

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Class<?>, java.lang.reflect.Constructor<? extends org.eclipse.jetty.continuation.Continuation>] */
    static {
        Constructor<? extends Continuation> constructor;
        Constructor<? extends Continuation> constructor2;
        boolean z;
        Constructor<? extends Continuation> constructor3 = 0;
        boolean z2 = true;
        int i = 0;
        try {
            if (ServletRequest.class.getMethod("startAsync", new Class[i]) != null) {
                constructor2 = ContinuationSupport.class.getClassLoader().loadClass("org.eclipse.jetty.continuation.Servlet3Continuation").asSubclass(Continuation.class).getConstructor(ServletRequest.class);
                z = true;
            } else {
                constructor2 = constructor3;
                z = false;
            }
        } catch (Exception unused) {
        } finally {
            __servlet3 = i;
            __newServlet3Continuation = constructor3;
        }
        try {
            Class<?> loadClass = ContinuationSupport.class.getClassLoader().loadClass("org.mortbay.util.ajax.Continuation");
            if (loadClass != null) {
                constructor = ContinuationSupport.class.getClassLoader().loadClass("org.eclipse.jetty.continuation.Jetty6Continuation").asSubclass(Continuation.class).getConstructor(ServletRequest.class, loadClass);
            } else {
                constructor = constructor3;
                z2 = false;
            }
        } catch (Exception unused2) {
        } finally {
            __jetty6 = i;
            __newJetty6Continuation = constructor3;
        }
        try {
            constructor3 = ContinuationSupport.class.getClassLoader().loadClass("org.mortbay.util.ajax.WaitingContinuation");
        } catch (Exception unused3) {
        } finally {
            __waitingContinuation = constructor3;
        }
    }

    public static Continuation getContinuation(ServletRequest servletRequest) {
        Continuation newInstance;
        Continuation continuation = (Continuation) servletRequest.getAttribute(Continuation.ATTRIBUTE);
        if (continuation != null) {
            return continuation;
        }
        while (servletRequest instanceof ServletRequestWrapper) {
            servletRequest = ((ServletRequestWrapper) servletRequest).getRequest();
        }
        if (__servlet3) {
            try {
                Continuation newInstance2 = __newServlet3Continuation.newInstance(servletRequest);
                servletRequest.setAttribute(Continuation.ATTRIBUTE, newInstance2);
                return newInstance2;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (!__jetty6) {
            throw new IllegalStateException("!(Jetty || Servlet 3.0 || ContinuationFilter)");
        } else {
            Object attribute = servletRequest.getAttribute("org.mortbay.jetty.ajax.Continuation");
            if (attribute != null) {
                try {
                    if (__waitingContinuation != null && !__waitingContinuation.isInstance(attribute)) {
                        newInstance = __newJetty6Continuation.newInstance(servletRequest, attribute);
                        servletRequest.setAttribute(Continuation.ATTRIBUTE, newInstance);
                        return newInstance;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            newInstance = new FauxContinuation(servletRequest);
            servletRequest.setAttribute(Continuation.ATTRIBUTE, newInstance);
            return newInstance;
        }
    }

    @Deprecated
    public static Continuation getContinuation(ServletRequest servletRequest, ServletResponse servletResponse) {
        return getContinuation(servletRequest);
    }
}
