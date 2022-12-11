package org.eclipse.jetty.http;

/* loaded from: classes4.dex */
public class HttpCookie {
    public final String _comment;
    public final String _domain;
    public final boolean _httpOnly;
    public final int _maxAge;
    public final String _name;
    public final String _path;
    public final boolean _secure;
    public final String _value;
    public final int _version;

    public HttpCookie(String str, String str2) {
        this._name = str;
        this._value = str2;
        this._comment = null;
        this._domain = null;
        this._httpOnly = false;
        this._maxAge = -1;
        this._path = null;
        this._secure = false;
        this._version = 0;
    }

    public HttpCookie(String str, String str2, int i) {
        this._name = str;
        this._value = str2;
        this._comment = null;
        this._domain = null;
        this._httpOnly = false;
        this._maxAge = i;
        this._path = null;
        this._secure = false;
        this._version = 0;
    }

    public HttpCookie(String str, String str2, String str3, String str4) {
        this._name = str;
        this._value = str2;
        this._comment = null;
        this._domain = str3;
        this._httpOnly = false;
        this._maxAge = -1;
        this._path = str4;
        this._secure = false;
        this._version = 0;
    }

    public HttpCookie(String str, String str2, String str3, String str4, int i, boolean z, boolean z2) {
        this._comment = null;
        this._domain = str3;
        this._httpOnly = z;
        this._maxAge = i;
        this._name = str;
        this._path = str4;
        this._secure = z2;
        this._value = str2;
        this._version = 0;
    }

    public HttpCookie(String str, String str2, String str3, String str4, int i, boolean z, boolean z2, String str5, int i2) {
        this._comment = str5;
        this._domain = str3;
        this._httpOnly = z;
        this._maxAge = i;
        this._name = str;
        this._path = str4;
        this._secure = z2;
        this._value = str2;
        this._version = i2;
    }

    public String getComment() {
        return this._comment;
    }

    public String getDomain() {
        return this._domain;
    }

    public int getMaxAge() {
        return this._maxAge;
    }

    public String getName() {
        return this._name;
    }

    public String getPath() {
        return this._path;
    }

    public String getValue() {
        return this._value;
    }

    public int getVersion() {
        return this._version;
    }

    public boolean isHttpOnly() {
        return this._httpOnly;
    }

    public boolean isSecure() {
        return this._secure;
    }
}
