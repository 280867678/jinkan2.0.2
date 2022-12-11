package org.eclipse.jetty.client.webdav;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import me.tvspark.outline;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class WebdavSupportedExchange extends HttpExchange {
    public static final Logger LOG = Log.getLogger(WebdavSupportedExchange.class);
    public boolean _webdavSupported = false;
    public boolean _isComplete = false;

    public boolean isWebdavSupported() {
        return this._webdavSupported;
    }

    @Override // org.eclipse.jetty.client.HttpExchange
    public void onResponseComplete() throws IOException {
        this._isComplete = true;
        super.onResponseComplete();
    }

    @Override // org.eclipse.jetty.client.HttpExchange
    public void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("WebdavSupportedExchange:Header:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(buffer.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" / ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(buffer2.toString());
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        if ("DAV".equals(buffer.toString()) && (buffer2.toString().indexOf("1") >= 0 || buffer2.toString().indexOf(ExifInterface.GPS_MEASUREMENT_2D) >= 0)) {
            this._webdavSupported = true;
        }
        super.onResponseHeader(buffer, buffer2);
    }

    public void waitTilCompletion() throws InterruptedException {
        synchronized (this) {
            while (!this._isComplete) {
                wait();
            }
        }
    }
}
