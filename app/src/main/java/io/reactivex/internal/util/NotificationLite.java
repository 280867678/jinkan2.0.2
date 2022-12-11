package io.reactivex.internal.util;

import java.io.Serializable;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.outline;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes4.dex */
    public static final class DisposableNotification implements Serializable {
        public static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d */
        public final p60 f4475d;

        public DisposableNotification(p60 p60Var) {
            this.f4475d = p60Var;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("NotificationLite.Disposable[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4475d);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class ErrorNotification implements Serializable {
        public static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e */
        public final Throwable f4476e;

        public ErrorNotification(Throwable th) {
            this.f4476e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.f4476e, ((ErrorNotification) obj).f4476e);
            }
            return false;
        }

        public int hashCode() {
            return this.f4476e.hashCode();
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("NotificationLite.Error[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4476e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class SubscriptionNotification implements Serializable {
        public static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: s */
        public final t51 f4477s;

        public SubscriptionNotification(t51 t51Var) {
            this.f4477s = t51Var;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("NotificationLite.Subscription[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4477s);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public static <T> boolean accept(Object obj, j60<? super T> j60Var) {
        if (obj == COMPLETE) {
            j60Var.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            j60Var.onError(((ErrorNotification) obj).f4476e);
            return true;
        } else {
            j60Var.onNext(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, s51<? super T> s51Var) {
        if (obj == COMPLETE) {
            s51Var.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            s51Var.onError(((ErrorNotification) obj).f4476e);
            return true;
        } else {
            s51Var.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, j60<? super T> j60Var) {
        if (obj == COMPLETE) {
            j60Var.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            j60Var.onError(((ErrorNotification) obj).f4476e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            j60Var.onSubscribe(((DisposableNotification) obj).f4475d);
            return false;
        } else {
            j60Var.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, s51<? super T> s51Var) {
        if (obj == COMPLETE) {
            s51Var.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            s51Var.onError(((ErrorNotification) obj).f4476e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            s51Var.onSubscribe(((SubscriptionNotification) obj).f4477s);
            return false;
        } else {
            s51Var.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(p60 p60Var) {
        return new DisposableNotification(p60Var);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static p60 getDisposable(Object obj) {
        return ((DisposableNotification) obj).f4475d;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f4476e;
    }

    public static t51 getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).f4477s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(t51 t51Var) {
        return new SubscriptionNotification(t51Var);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
