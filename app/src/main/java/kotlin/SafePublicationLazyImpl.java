package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import me.tvspark.df0;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.lf0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class SafePublicationLazyImpl<T> implements df0<T>, Serializable {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    public volatile Object _value = lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: final  reason: not valid java name */
    public final Object f5057final = lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile xg0<? extends T> initializer;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }
    }

    public SafePublicationLazyImpl(xg0<? extends T> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "initializer");
        this.initializer = xg0Var;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // me.tvspark.df0
    public T getValue() {
        T t = (T) this._value;
        if (t != lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return t;
        }
        xg0<? extends T> xg0Var = this.initializer;
        if (xg0Var != null) {
            T mo4969invoke = xg0Var.mo4969invoke();
            if (valueUpdater.compareAndSet(this, lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, mo4969invoke)) {
                this.initializer = null;
                return mo4969invoke;
            }
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
