package org.apache.http;

/* loaded from: classes4.dex */
public class MethodNotSupportedException extends HttpException {
    public static final long serialVersionUID = 3365359036840171201L;

    public MethodNotSupportedException(String str) {
        super(str);
    }

    public MethodNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
