package kotlin.coroutines;

import androidx.core.app.Person;
import com.umeng.analytics.pro.C1615d;
import java.io.Serializable;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.og0;

@ef0
/* loaded from: classes4.dex */
public final class EmptyCoroutineContext implements og0, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    public static final long serialVersionUID = 0;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // me.tvspark.og0
    public <R> R fold(R r, mh0<? super R, ? super og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ? extends R> mh0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mh0Var, "operation");
        return r;
    }

    @Override // me.tvspark.og0
    public <E extends og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> E get(og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Person.KEY_KEY);
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // me.tvspark.og0
    public og0 minusKey(og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Person.KEY_KEY);
        return this;
    }

    @Override // me.tvspark.og0
    public og0 plus(og0 og0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0Var, C1615d.f3292R);
        return og0Var;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
