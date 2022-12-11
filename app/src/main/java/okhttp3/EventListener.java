package okhttp3;

import androidx.core.app.NotificationCompat;
import com.arialyy.aria.core.inf.IOptionConstant;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public void callEnd(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void callFailed(Call call, IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "ioe");
    }

    public void callStart(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "inetSocketAddress");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxy, IOptionConstant.proxy);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "inetSocketAddress");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxy, IOptionConstant.proxy);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "inetSocketAddress");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxy, IOptionConstant.proxy);
    }

    public void connectionAcquired(Call call, Connection connection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "domainName");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
    }

    public void requestBodyEnd(Call call, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void requestBodyStart(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void requestFailed(Call call, IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
    }

    public void requestHeadersStart(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyEnd(Call call, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyStart(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseFailed(Call call, IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
    }

    public void responseHeadersStart(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectStart(Call call) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
    }
}
