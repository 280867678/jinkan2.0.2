package okhttp3;

import me.tvspark.ef0;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public interface WebSocket {

    @ef0
    /* loaded from: classes4.dex */
    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, String str);

    long queueSize();

    Request request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
