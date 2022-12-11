package org.eclipse.jetty.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import javax.net.SocketFactory;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.bio.SocketEndPoint;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class SocketConnector extends AbstractLifeCycle implements HttpClient.Connector {
    public static final Logger LOG = Log.getLogger(SocketConnector.class);
    public final HttpClient _httpClient;

    public SocketConnector(HttpClient httpClient) {
        this._httpClient = httpClient;
    }

    @Override // org.eclipse.jetty.client.HttpClient.Connector
    public void startConnection(final HttpDestination httpDestination) throws IOException {
        Socket newSslSocket = httpDestination.isSecure() ? httpDestination.getSslContextFactory().newSslSocket() : SocketFactory.getDefault().createSocket();
        newSslSocket.setSoTimeout(0);
        newSslSocket.setTcpNoDelay(true);
        newSslSocket.connect((httpDestination.isProxied() ? httpDestination.getProxy() : httpDestination.getAddress()).toSocketAddress(), this._httpClient.getConnectTimeout());
        final BlockingHttpConnection blockingHttpConnection = new BlockingHttpConnection(this._httpClient.getRequestBuffers(), this._httpClient.getResponseBuffers(), new SocketEndPoint(newSslSocket));
        blockingHttpConnection.setDestination(httpDestination);
        httpDestination.onNewConnection(blockingHttpConnection);
        this._httpClient.getThreadPool().dispatch(new Runnable() { // from class: org.eclipse.jetty.client.SocketConnector.1
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0014 -> B:9:0x003e). Please submit an issue!!! */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        try {
                            Connection connection = blockingHttpConnection;
                            while (true) {
                                Connection handle = connection.handle();
                                if (handle == connection) {
                                    httpDestination.returnConnection(blockingHttpConnection, true);
                                    return;
                                }
                                connection = handle;
                            }
                        } catch (IOException e) {
                            SocketConnector.LOG.debug(e);
                        }
                    } catch (IOException e2) {
                        if (e2 instanceof InterruptedIOException) {
                            SocketConnector.LOG.ignore(e2);
                        } else {
                            SocketConnector.LOG.debug(e2);
                            httpDestination.onException(e2);
                        }
                        httpDestination.returnConnection(blockingHttpConnection, true);
                    }
                } catch (Throwable th) {
                    try {
                        httpDestination.returnConnection(blockingHttpConnection, true);
                    } catch (IOException e3) {
                        SocketConnector.LOG.debug(e3);
                    }
                    throw th;
                }
            }
        });
    }
}
