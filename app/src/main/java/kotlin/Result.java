package kotlin;

import java.io.Serializable;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class Result<T> implements Serializable {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public final Object value;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failure(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.exception);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }
    }

    public /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m4869boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m4870constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4871equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, ((Result) obj2).m4879unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4872equalsimpl0(Object obj, Object obj2) {
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m4873exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    public static final T m4874getOrNullimpl(Object obj) {
        if (m4876isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4875hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m4876isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m4877isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4878toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m4871equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4875hashCodeimpl(this.value);
    }

    public String toString() {
        return m4878toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m4879unboximpl() {
        return this.value;
    }
}
