package kotlin;

import java.io.Serializable;
import me.tvspark.df0;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.lf0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class UnsafeLazyImpl<T> implements df0<T>, Serializable {
    public Object _value = lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public xg0<? extends T> initializer;

    public UnsafeLazyImpl(xg0<? extends T> xg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "initializer");
        this.initializer = xg0Var;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // me.tvspark.df0
    public T getValue() {
        if (this._value == lf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            xg0<? extends T> xg0Var = this.initializer;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var);
            this._value = xg0Var.mo4969invoke();
            this.initializer = null;
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
