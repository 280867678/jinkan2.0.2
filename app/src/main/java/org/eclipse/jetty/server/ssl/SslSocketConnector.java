package org.eclipse.jetty.server.ssl;

import com.tencent.bugly.BuglyStrategy;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import me.tvspark.outline;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.RuntimeIOException;
import org.eclipse.jetty.p059io.bio.SocketEndPoint;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/* loaded from: classes5.dex */
public class SslSocketConnector extends SocketConnector implements SslConnector {
    public static final Logger LOG = Log.getLogger(SslSocketConnector.class);
    public int _handshakeTimeout;
    public final SslContextFactory _sslContextFactory;

    /* loaded from: classes5.dex */
    public class SslConnectorEndPoint extends SocketConnector.ConnectorEndPoint {
        public SslConnectorEndPoint(Socket socket) throws IOException {
            super(socket);
        }

        @Override // org.eclipse.jetty.server.bio.SocketConnector.ConnectorEndPoint, org.eclipse.jetty.p059io.bio.SocketEndPoint, org.eclipse.jetty.p059io.bio.StreamEndPoint, org.eclipse.jetty.p059io.EndPoint
        public /* bridge */ /* synthetic */ void close() throws IOException {
            super.close();
        }

        @Override // org.eclipse.jetty.server.bio.SocketConnector.ConnectorEndPoint
        public /* bridge */ /* synthetic */ void dispatch() throws IOException {
            super.dispatch();
        }

        @Override // org.eclipse.jetty.server.bio.SocketConnector.ConnectorEndPoint, org.eclipse.jetty.p059io.bio.StreamEndPoint, org.eclipse.jetty.p059io.EndPoint
        public /* bridge */ /* synthetic */ int fill(Buffer buffer) throws IOException {
            return super.fill(buffer);
        }

        @Override // org.eclipse.jetty.server.bio.SocketConnector.ConnectorEndPoint, org.eclipse.jetty.p059io.ConnectedEndPoint
        public /* bridge */ /* synthetic */ Connection getConnection() {
            return super.getConnection();
        }

        @Override // org.eclipse.jetty.server.bio.SocketConnector.ConnectorEndPoint, java.lang.Runnable
        public void run() {
            try {
                try {
                    try {
                        int handshakeTimeout = SslSocketConnector.this.getHandshakeTimeout();
                        int soTimeout = ((SocketConnector.ConnectorEndPoint) this)._socket.getSoTimeout();
                        if (handshakeTimeout > 0) {
                            ((SocketConnector.ConnectorEndPoint) this)._socket.setSoTimeout(handshakeTimeout);
                        }
                        final SSLSocket sSLSocket = (SSLSocket) ((SocketConnector.ConnectorEndPoint) this)._socket;
                        sSLSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() { // from class: org.eclipse.jetty.server.ssl.SslSocketConnector.SslConnectorEndPoint.1
                            public boolean handshook = false;

                            @Override // javax.net.ssl.HandshakeCompletedListener
                            public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                                if (!this.handshook) {
                                    this.handshook = true;
                                } else if (SslSocketConnector.this._sslContextFactory.isAllowRenegotiate()) {
                                } else {
                                    Logger logger = SslSocketConnector.LOG;
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SSL renegotiate denied: ");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sSLSocket);
                                    logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                                    try {
                                        sSLSocket.close();
                                    } catch (IOException e) {
                                        SslSocketConnector.LOG.warn(e);
                                    }
                                }
                            }
                        });
                        sSLSocket.startHandshake();
                        if (handshakeTimeout > 0) {
                            ((SocketConnector.ConnectorEndPoint) this)._socket.setSoTimeout(soTimeout);
                        }
                        super.run();
                    } catch (SSLException e) {
                        SslSocketConnector.LOG.debug(e);
                        close();
                    }
                } catch (IOException e2) {
                    SslSocketConnector.LOG.debug(e2);
                    close();
                }
            } catch (IOException e3) {
                SslSocketConnector.LOG.ignore(e3);
            }
        }

        @Override // org.eclipse.jetty.server.bio.SocketConnector.ConnectorEndPoint, org.eclipse.jetty.p059io.ConnectedEndPoint
        public /* bridge */ /* synthetic */ void setConnection(Connection connection) {
            super.setConnection(connection);
        }

        @Override // org.eclipse.jetty.p059io.bio.SocketEndPoint, org.eclipse.jetty.p059io.bio.StreamEndPoint, org.eclipse.jetty.p059io.EndPoint
        public void shutdownInput() throws IOException {
            close();
        }

        @Override // org.eclipse.jetty.p059io.bio.SocketEndPoint, org.eclipse.jetty.p059io.bio.StreamEndPoint, org.eclipse.jetty.p059io.EndPoint
        public void shutdownOutput() throws IOException {
            close();
        }
    }

    public SslSocketConnector() {
        this(new SslContextFactory(SslContextFactory.DEFAULT_KEYSTORE_PATH));
        setSoLingerTime(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
    }

    public SslSocketConnector(SslContextFactory sslContextFactory) {
        this._handshakeTimeout = 0;
        this._sslContextFactory = sslContextFactory;
    }

    @Override // org.eclipse.jetty.server.bio.SocketConnector, org.eclipse.jetty.server.AbstractConnector
    public void accept(int i) throws IOException, InterruptedException {
        Socket accept = this._serverSocket.accept();
        configure(accept);
        new SslConnectorEndPoint(accept).dispatch();
    }

    @Override // org.eclipse.jetty.server.AbstractConnector
    public void configure(Socket socket) throws IOException {
        super.configure(socket);
    }

    @Override // org.eclipse.jetty.server.bio.SocketConnector, org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.server.Connector
    public void customize(EndPoint endPoint, Request request) throws IOException {
        super.customize(endPoint, request);
        request.setScheme("https");
        SslCertificates.customize(((SSLSocket) ((SocketEndPoint) endPoint).getTransport()).getSession(), endPoint, request);
    }

    @Override // org.eclipse.jetty.server.bio.SocketConnector, org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._sslContextFactory.checkKeyStore();
        this._sslContextFactory.start();
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.bio.SocketConnector, org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._sslContextFactory.stop();
        super.doStop();
    }

    @Deprecated
    public String getAlgorithm() {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String[] getExcludeCipherSuites() {
        return this._sslContextFactory.getExcludeCipherSuites();
    }

    public int getHandshakeTimeout() {
        return this._handshakeTimeout;
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String[] getIncludeCipherSuites() {
        return this._sslContextFactory.getIncludeCipherSuites();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getKeystore() {
        return this._sslContextFactory.getKeyStorePath();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getKeystoreType() {
        return this._sslContextFactory.getKeyStoreType();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public boolean getNeedClientAuth() {
        return this._sslContextFactory.getNeedClientAuth();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getProtocol() {
        return this._sslContextFactory.getProtocol();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getProvider() {
        return this._sslContextFactory.getProvider();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getSecureRandomAlgorithm() {
        return this._sslContextFactory.getSecureRandomAlgorithm();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public SSLContext getSslContext() {
        return this._sslContextFactory.getSslContext();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    public SslContextFactory getSslContextFactory() {
        return this._sslContextFactory;
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getSslKeyManagerFactoryAlgorithm() {
        return this._sslContextFactory.getSslKeyManagerFactoryAlgorithm();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getSslTrustManagerFactoryAlgorithm() {
        return this._sslContextFactory.getTrustManagerFactoryAlgorithm();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getTruststore() {
        return this._sslContextFactory.getTrustStore();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public String getTruststoreType() {
        return this._sslContextFactory.getTrustStoreType();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public boolean getWantClientAuth() {
        return this._sslContextFactory.getWantClientAuth();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    public boolean isAllowRenegotiate() {
        return this._sslContextFactory.isAllowRenegotiate();
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.server.Connector
    public boolean isConfidential(Request request) {
        int confidentialPort = getConfidentialPort();
        return confidentialPort == 0 || confidentialPort == request.getServerPort();
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.server.Connector
    public boolean isIntegral(Request request) {
        int integralPort = getIntegralPort();
        return integralPort == 0 || integralPort == request.getServerPort();
    }

    @Override // org.eclipse.jetty.server.bio.SocketConnector
    public ServerSocket newServerSocket(String str, int i, int i2) throws IOException {
        return this._sslContextFactory.newSslServerSocket(str, i, i2);
    }

    @Override // org.eclipse.jetty.server.bio.SocketConnector, org.eclipse.jetty.server.Connector
    public void open() throws IOException {
        this._sslContextFactory.checkKeyStore();
        try {
            this._sslContextFactory.start();
            super.open();
        } catch (Exception e) {
            throw new RuntimeIOException(e);
        }
    }

    @Deprecated
    public void setAlgorithm(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    public void setAllowRenegotiate(boolean z) {
        this._sslContextFactory.setAllowRenegotiate(z);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setExcludeCipherSuites(String[] strArr) {
        this._sslContextFactory.setExcludeCipherSuites(strArr);
    }

    public void setHandshakeTimeout(int i) {
        this._handshakeTimeout = i;
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setIncludeCipherSuites(String[] strArr) {
        this._sslContextFactory.setIncludeCipherSuites(strArr);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setKeyPassword(String str) {
        this._sslContextFactory.setKeyManagerPassword(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setKeystore(String str) {
        this._sslContextFactory.setKeyStorePath(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setKeystoreType(String str) {
        this._sslContextFactory.setKeyStoreType(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setNeedClientAuth(boolean z) {
        this._sslContextFactory.setNeedClientAuth(z);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setPassword(String str) {
        this._sslContextFactory.setKeyStorePassword(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setProtocol(String str) {
        this._sslContextFactory.setProtocol(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setProvider(String str) {
        this._sslContextFactory.setProvider(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setSecureRandomAlgorithm(String str) {
        this._sslContextFactory.setSecureRandomAlgorithm(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setSslContext(SSLContext sSLContext) {
        this._sslContextFactory.setSslContext(sSLContext);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setSslKeyManagerFactoryAlgorithm(String str) {
        this._sslContextFactory.setSslKeyManagerFactoryAlgorithm(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setSslTrustManagerFactoryAlgorithm(String str) {
        this._sslContextFactory.setTrustManagerFactoryAlgorithm(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setTrustPassword(String str) {
        this._sslContextFactory.setTrustStorePassword(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setTruststore(String str) {
        this._sslContextFactory.setTrustStore(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setTruststoreType(String str) {
        this._sslContextFactory.setTrustStoreType(str);
    }

    @Override // org.eclipse.jetty.server.ssl.SslConnector
    @Deprecated
    public void setWantClientAuth(boolean z) {
        this._sslContextFactory.setWantClientAuth(z);
    }
}
