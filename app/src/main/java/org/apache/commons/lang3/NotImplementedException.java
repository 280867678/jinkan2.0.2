package org.apache.commons.lang3;

/* loaded from: classes4.dex */
public class NotImplementedException extends UnsupportedOperationException {
    public static final long serialVersionUID = 20131021;
    public final String code;

    public NotImplementedException(String str) {
        this(str, (String) null);
    }

    public NotImplementedException(String str, String str2) {
        super(str);
        this.code = str2;
    }

    public NotImplementedException(String str, Throwable th) {
        this(str, th, null);
    }

    public NotImplementedException(String str, Throwable th, String str2) {
        super(str, th);
        this.code = str2;
    }

    public NotImplementedException(Throwable th) {
        this(th, (String) null);
    }

    public NotImplementedException(Throwable th, String str) {
        super(th);
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }
}
