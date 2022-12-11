package org.apache.http;

import java.io.IOException;

/* loaded from: classes4.dex */
public class NoHttpResponseException extends IOException {
    public static final long serialVersionUID = -7658940387386078766L;

    public NoHttpResponseException(String str) {
        super(HttpException.clean(str));
    }
}
