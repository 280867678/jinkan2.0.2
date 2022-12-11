package org.fourthline.cling.model;

/* loaded from: classes5.dex */
public class UnsupportedDataException extends RuntimeException {
    public static final long serialVersionUID = 661795454401413339L;
    public Object data;

    public UnsupportedDataException(String str) {
        super(str);
    }

    public UnsupportedDataException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedDataException(String str, Throwable th, Object obj) {
        super(str, th);
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }
}
