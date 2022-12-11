package me.tvspark;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class lx0 extends sw0 {
    public final Socket Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Logger.getLogger("okio.Okio");

    public lx0(Socket socket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "socket");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = socket;
    }

    @Override // me.tvspark.sw0
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.sw0
    public void timedOut() {
        Level level;
        StringBuilder sb;
        Logger logger;
        Exception exc;
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
        } catch (AssertionError e) {
            if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e)) {
                throw e;
            }
            Logger logger2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e;
            logger = logger2;
            sb.append("Failed to close timed out socket ");
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            logger.log(level, sb.toString(), (Throwable) exc);
        } catch (Exception e2) {
            Logger logger3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e2;
            logger = logger3;
            sb.append("Failed to close timed out socket ");
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            logger.log(level, sb.toString(), (Throwable) exc);
        }
    }
}
