package me.tvspark;

import com.arialyy.aria.core.ProtocolType;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class el0 extends SSLSocketFactory {
    public static String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SSLSocketFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        String[] supportedProtocols;
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket();
            if (sSLSocket == null) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (String str : sSLSocket.getSupportedProtocols()) {
                if (!str.toUpperCase().contains(ProtocolType.SSL)) {
                    linkedList.add(str);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (String[]) linkedList.toArray(new String[linkedList.size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public el0(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, x509TrustManager != null ? new X509TrustManager[]{x509TrustManager} : null, null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SSLSocket sSLSocket) {
        String[] strArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createSocket(str, i, inetAddress, i2);
        if (createSocket instanceof SSLSocket) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createSocket(inetAddress, i);
        if (createSocket instanceof SSLSocket) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createSocket(inetAddress, i, inetAddress2, i2);
        if (createSocket instanceof SSLSocket) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return null;
    }
}
