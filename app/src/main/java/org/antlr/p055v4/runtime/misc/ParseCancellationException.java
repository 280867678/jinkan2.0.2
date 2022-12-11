package org.antlr.p055v4.runtime.misc;

import java.util.concurrent.CancellationException;

/* renamed from: org.antlr.v4.runtime.misc.ParseCancellationException */
/* loaded from: classes4.dex */
public class ParseCancellationException extends CancellationException {
    public ParseCancellationException() {
    }

    public ParseCancellationException(String str) {
        super(str);
    }

    public ParseCancellationException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    public ParseCancellationException(Throwable th) {
        initCause(th);
    }
}
