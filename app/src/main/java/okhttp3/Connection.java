package okhttp3;

import java.net.Socket;
import me.tvspark.ef0;

@ef0
/* loaded from: classes4.dex */
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
