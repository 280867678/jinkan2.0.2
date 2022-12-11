package org.eclipse.jetty.p059io;

import java.io.EOFException;

/* renamed from: org.eclipse.jetty.io.EofException */
/* loaded from: classes4.dex */
public class EofException extends EOFException {
    public EofException() {
    }

    public EofException(String str) {
        super(str);
    }

    public EofException(Throwable th) {
        if (th != null) {
            initCause(th);
        }
    }
}
