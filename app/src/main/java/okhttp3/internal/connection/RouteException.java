package okhttp3.internal.connection;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final class RouteException extends RuntimeException {
    public final IOException firstConnectException;
    public IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(IOException iOException) {
        super(iOException);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "firstConnectException");
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    public final void addConnectException(IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "e");
        this.firstConnectException.addSuppressed(iOException);
        this.lastConnectException = iOException;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
