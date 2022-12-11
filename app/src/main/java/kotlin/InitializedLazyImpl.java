package kotlin;

import java.io.Serializable;
import me.tvspark.df0;
import me.tvspark.ef0;

@ef0
/* loaded from: classes4.dex */
public final class InitializedLazyImpl<T> implements df0<T>, Serializable {
    public final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // me.tvspark.df0
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
