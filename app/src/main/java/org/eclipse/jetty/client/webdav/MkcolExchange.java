package org.eclipse.jetty.client.webdav;

import java.io.IOException;
import org.eclipse.jetty.client.CachedExchange;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class MkcolExchange extends CachedExchange {
    public static final Logger LOG = Log.getLogger(MkcolExchange.class);
    public boolean exists = false;

    public MkcolExchange() {
        super(true);
    }

    public boolean exists() {
        return this.exists;
    }

    @Override // org.eclipse.jetty.client.CachedExchange, org.eclipse.jetty.client.HttpExchange
    public void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        if (i == 201) {
            LOG.debug("MkcolExchange:Status: Successfully created resource", new Object[0]);
            this.exists = true;
        }
        if (i == 405) {
            LOG.debug("MkcolExchange:Status: Resource must exist", new Object[0]);
            this.exists = true;
        }
        super.onResponseStatus(buffer, i, buffer2);
    }
}
