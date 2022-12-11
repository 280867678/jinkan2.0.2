package org.apache.commons.lang3.exception;

/* loaded from: classes4.dex */
public class CloneFailedException extends RuntimeException {
    public static final long serialVersionUID = 20091223;

    public CloneFailedException(String str) {
        super(str);
    }

    public CloneFailedException(String str, Throwable th) {
        super(str, th);
    }

    public CloneFailedException(Throwable th) {
        super(th);
    }
}
