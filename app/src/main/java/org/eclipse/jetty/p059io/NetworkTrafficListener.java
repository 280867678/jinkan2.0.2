package org.eclipse.jetty.p059io;

import java.net.Socket;

/* renamed from: org.eclipse.jetty.io.NetworkTrafficListener */
/* loaded from: classes4.dex */
public interface NetworkTrafficListener {

    /* renamed from: org.eclipse.jetty.io.NetworkTrafficListener$Empty */
    /* loaded from: classes4.dex */
    public static class Empty implements NetworkTrafficListener {
        @Override // org.eclipse.jetty.p059io.NetworkTrafficListener
        public void closed(Socket socket) {
        }

        @Override // org.eclipse.jetty.p059io.NetworkTrafficListener
        public void incoming(Socket socket, Buffer buffer) {
        }

        @Override // org.eclipse.jetty.p059io.NetworkTrafficListener
        public void opened(Socket socket) {
        }

        @Override // org.eclipse.jetty.p059io.NetworkTrafficListener
        public void outgoing(Socket socket, Buffer buffer) {
        }
    }

    void closed(Socket socket);

    void incoming(Socket socket, Buffer buffer);

    void opened(Socket socket);

    void outgoing(Socket socket, Buffer buffer);
}
