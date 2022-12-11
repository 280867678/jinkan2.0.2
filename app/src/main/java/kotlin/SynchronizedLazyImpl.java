package kotlin;

import java.io.Serializable;
import me.tvspark.df0;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.lf0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class SynchronizedLazyImpl<T> implements df0<T>, Serializable {
    public volatile Object _value;
    public xg0<? extends T> initializer;
    public final Object lock;

    public SynchronizedLazyImpl(xg0<? extends T> xg0Var, Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "initializer");
        this.initializer = xg0Var;
        this._value = lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(xg0 xg0Var, Object obj, int i, gi0 gi0Var) {
        this(xg0Var, (i & 2) != 0 ? null : obj);
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // me.tvspark.df0
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        if (t2 != lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                xg0<? extends T> xg0Var = this.initializer;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var);
                t = xg0Var.mo4969invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
