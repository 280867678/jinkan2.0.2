package org.greenrobot.eventbus;

/* loaded from: classes5.dex */
public class EventBusException extends RuntimeException {
    public static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(String str) {
        super(str);
    }

    public EventBusException(String str, Throwable th) {
        super(str, th);
    }

    public EventBusException(Throwable th) {
        super(th);
    }
}
