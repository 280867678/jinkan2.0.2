package org.eclipse.jetty.security;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.Cookie;
import me.tvspark.ae0;
import me.tvspark.ce0;

/* loaded from: classes4.dex */
public class HashCrossContextPsuedoSession<T> implements CrossContextPsuedoSession<T> {
    public final String _cookieName;
    public final String _cookiePath;
    public final Random _random = new SecureRandom();
    public final Map<String, T> _data = new HashMap();

    public HashCrossContextPsuedoSession(String str, String str2) {
        this._cookieName = str;
        this._cookiePath = str2 == null ? "/" : str2;
    }

    @Override // org.eclipse.jetty.security.CrossContextPsuedoSession
    public void clear(ae0 ae0Var) {
        Cookie[] cookies;
        for (Cookie cookie : ae0Var.getCookies()) {
            if (this._cookieName.equals(cookie.getName())) {
                this._data.remove(cookie.getValue());
                return;
            }
        }
    }

    @Override // org.eclipse.jetty.security.CrossContextPsuedoSession
    public T fetch(ae0 ae0Var) {
        Cookie[] cookies;
        for (Cookie cookie : ae0Var.getCookies()) {
            if (this._cookieName.equals(cookie.getName())) {
                return this._data.get(cookie.getValue());
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.security.CrossContextPsuedoSession
    public void store(T t, ce0 ce0Var) {
        String l;
        synchronized (this._data) {
            do {
                l = Long.toString(Math.abs(this._random.nextLong()), ((int) (System.currentTimeMillis() % 7)) + 30);
            } while (this._data.containsKey(l));
            this._data.put(l, t);
        }
        Cookie cookie = new Cookie(this._cookieName, l);
        cookie.setPath(this._cookiePath);
        ce0Var.addCookie(cookie);
    }
}
