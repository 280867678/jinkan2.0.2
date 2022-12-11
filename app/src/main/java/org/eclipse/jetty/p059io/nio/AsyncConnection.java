package org.eclipse.jetty.p059io.nio;

import java.io.IOException;
import org.eclipse.jetty.p059io.Connection;

/* renamed from: org.eclipse.jetty.io.nio.AsyncConnection */
/* loaded from: classes4.dex */
public interface AsyncConnection extends Connection {
    void onInputShutdown() throws IOException;
}
