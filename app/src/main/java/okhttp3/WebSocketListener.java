package okhttp3;

import com.umeng.analytics.pro.C1543ak;
import me.tvspark.ef0;
import me.tvspark.ii0;
import okio.ByteString;
import org.eclipse.jetty.http.HttpHeaderValues;

@ef0
/* loaded from: classes4.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocket, "webSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocket, "webSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocket, "webSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, C1543ak.f2971aH);
    }

    public void onMessage(WebSocket webSocket, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocket, "webSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "text");
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocket, "webSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, HttpHeaderValues.BYTES);
    }

    public void onOpen(WebSocket webSocket, Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocket, "webSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
    }
}
