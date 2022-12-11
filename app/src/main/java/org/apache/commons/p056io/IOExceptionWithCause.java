package org.apache.commons.p056io;

import java.io.IOException;

@Deprecated
/* renamed from: org.apache.commons.io.IOExceptionWithCause */
/* loaded from: classes4.dex */
public class IOExceptionWithCause extends IOException {
    public static final long serialVersionUID = 1;

    public IOExceptionWithCause(String str, Throwable th) {
        super(str, th);
    }

    public IOExceptionWithCause(Throwable th) {
        super(th);
    }
}
