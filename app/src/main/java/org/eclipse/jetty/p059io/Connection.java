package org.eclipse.jetty.p059io;

import java.io.IOException;

/* renamed from: org.eclipse.jetty.io.Connection */
/* loaded from: classes4.dex */
public interface Connection {
    long getTimeStamp();

    Connection handle() throws IOException;

    boolean isIdle();

    boolean isSuspended();

    void onClose();

    void onIdleExpired(long j);
}
