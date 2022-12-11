package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes4.dex */
public class ContextedRuntimeException extends RuntimeException implements ExceptionContext {
    public static final long serialVersionUID = 20110706;
    public final ExceptionContext exceptionContext;

    public ContextedRuntimeException() {
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(String str) {
        super(str);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(String str, Throwable th) {
        super(str, th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(String str, Throwable th, ExceptionContext exceptionContext) {
        super(str, th);
        this.exceptionContext = exceptionContext == null ? new DefaultExceptionContext() : exceptionContext;
    }

    public ContextedRuntimeException(Throwable th) {
        super(th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    /* renamed from: addContextValue */
    public ContextedRuntimeException mo5171addContextValue(String str, Object obj) {
        this.exceptionContext.mo5171addContextValue(str, obj);
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.exceptionContext.getContextEntries();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        return this.exceptionContext.getContextLabels();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String str) {
        return this.exceptionContext.getContextValues(str);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String str) {
        return this.exceptionContext.getFirstContextValue(str);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        return this.exceptionContext.getFormattedExceptionMessage(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    public String getRawMessage() {
        return super.getMessage();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    /* renamed from: setContextValue */
    public ContextedRuntimeException mo5172setContextValue(String str, Object obj) {
        this.exceptionContext.mo5172setContextValue(str, obj);
        return this;
    }
}
