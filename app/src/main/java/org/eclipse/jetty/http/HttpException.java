package org.eclipse.jetty.http;

import java.io.IOException;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class HttpException extends IOException {
    public String _reason;
    public int _status;

    public HttpException(int i) {
        this._status = i;
        this._reason = null;
    }

    public HttpException(int i, String str) {
        this._status = i;
        this._reason = str;
    }

    public HttpException(int i, String str, Throwable th) {
        this._status = i;
        this._reason = str;
        initCause(th);
    }

    public String getReason() {
        return this._reason;
    }

    public int getStatus() {
        return this._status;
    }

    public void setReason(String str) {
        this._reason = str;
    }

    public void setStatus(int i) {
        this._status = i;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HttpException(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._status);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._reason);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(super.getCause());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
