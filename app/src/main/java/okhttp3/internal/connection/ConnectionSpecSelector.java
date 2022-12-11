package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import okhttp3.ConnectionSpec;

@ef0
/* loaded from: classes4.dex */
public final class ConnectionSpecSelector {
    public final List<ConnectionSpec> connectionSpecs;
    public boolean isFallback;
    public boolean isFallbackPossible;
    public int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int size = this.connectionSpecs.size();
        for (int i = this.nextModeIndex; i < size; i++) {
            if (this.connectionSpecs.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i);
            i++;
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i;
                break;
            }
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            connectionSpec.apply$okhttp(sSLSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to find acceptable protocols. isFallback=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isFallback);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" modes=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionSpecs);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        if (enabledProtocols == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        String arrays = Arrays.toString(enabledProtocols);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) arrays, "java.util.Arrays.toString(this)");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrays);
        throw new UnknownServiceException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public final boolean connectionFailed(IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "e");
        this.isFallback = true;
        return this.isFallbackPossible && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) && (iOException instanceof SSLException);
    }
}
