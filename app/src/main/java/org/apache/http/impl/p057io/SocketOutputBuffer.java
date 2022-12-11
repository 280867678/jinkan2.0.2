package org.apache.http.impl.p057io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
/* renamed from: org.apache.http.impl.io.SocketOutputBuffer */
/* loaded from: classes4.dex */
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        i = i < 0 ? socket.getSendBufferSize() : i;
        init(socket.getOutputStream(), i < 1024 ? 1024 : i, httpParams);
    }
}
