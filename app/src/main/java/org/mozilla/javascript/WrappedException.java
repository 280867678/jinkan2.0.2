package org.mozilla.javascript;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class WrappedException extends EvaluatorException {
    public static final long serialVersionUID = -1551979216966520648L;
    public Throwable exception;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WrappedException(Throwable th) {
        super(r0.toString());
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Wrapped ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.toString());
        this.exception = th;
        initCause(th);
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        int i = iArr[0];
        if (sourcePositionFromStack != null) {
            initSourceName(sourcePositionFromStack);
        }
        if (i != 0) {
            initLineNumber(i);
        }
    }

    public Throwable getWrappedException() {
        return this.exception;
    }

    @Deprecated
    public Object unwrap() {
        return getWrappedException();
    }
}
