package org.mozilla.javascript.commonjs.module.provider;

import java.io.Serializable;
import java.net.URLConnection;

/* loaded from: classes5.dex */
public class DefaultUrlConnectionExpiryCalculator implements UrlConnectionExpiryCalculator, Serializable {
    public static final long serialVersionUID = 1;
    public final long relativeExpiry;

    public DefaultUrlConnectionExpiryCalculator() {
        this(60000L);
    }

    public DefaultUrlConnectionExpiryCalculator(long j) {
        if (j >= 0) {
            this.relativeExpiry = j;
            return;
        }
        throw new IllegalArgumentException("relativeExpiry < 0");
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.UrlConnectionExpiryCalculator
    public long calculateExpiry(URLConnection uRLConnection) {
        return System.currentTimeMillis() + this.relativeExpiry;
    }
}
