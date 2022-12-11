package org.apache.http.impl.p057io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.p058io.EofSensor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
/* renamed from: org.apache.http.impl.io.SocketInputBuffer */
/* loaded from: classes4.dex */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    public boolean eof = false;
    public final Socket socket;

    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        i = i < 0 ? socket.getReceiveBufferSize() : i;
        init(socket.getInputStream(), i < 1024 ? 1024 : i, httpParams);
    }

    @Override // org.apache.http.impl.p057io.AbstractSessionInputBuffer
    public int fillBuffer() throws IOException {
        int fillBuffer = super.fillBuffer();
        this.eof = fillBuffer == -1;
        return fillBuffer;
    }

    @Override // org.apache.http.p058io.SessionInputBuffer
    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (!hasBufferedData) {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(i);
                fillBuffer();
                return hasBufferedData();
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        return hasBufferedData;
    }

    @Override // org.apache.http.p058io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
