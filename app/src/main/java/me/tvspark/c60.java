package me.tvspark;

import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes4.dex */
public final class c60<T> {
    public static final c60<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new c60<>(null);
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public c60(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    public static <T> c60<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "value is null");
        return new c60<>(t);
    }

    public static <T> c60<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, "error is null");
        return new c60<>(NotificationLite.error(th));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return obj != null && !NotificationLite.isError(obj);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return NotificationLite.isError(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c60) {
            return l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((c60) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OnErrorNotification[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(NotificationLite.getError(obj));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OnNextNotification[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
