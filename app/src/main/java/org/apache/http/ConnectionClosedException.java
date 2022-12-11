package org.apache.http;

import java.io.IOException;

/* loaded from: classes4.dex */
public class ConnectionClosedException extends IOException {
    public static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException(String str) {
        super(HttpException.clean(str));
    }
}
