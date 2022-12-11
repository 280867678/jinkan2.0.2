package org.eclipse.jetty.client.webdav;

import java.io.IOException;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class PropfindExchange extends HttpExchange {
    public static final Logger LOG = Log.getLogger(PropfindExchange.class);
    public boolean _propertyExists = false;

    public boolean exists() {
        return this._propertyExists;
    }

    @Override // org.eclipse.jetty.client.HttpExchange
    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        if (i == 200) {
            LOG.debug("PropfindExchange:Status: Exists", new Object[0]);
            this._propertyExists = true;
        } else {
            LOG.debug("PropfindExchange:Status: Not Exists", new Object[0]);
        }
        super.onResponseStatus(buffer, i, buffer2);
    }
}
