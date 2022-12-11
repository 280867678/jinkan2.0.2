package kotlin.coroutines;

import androidx.core.app.Person;
import com.umeng.analytics.pro.C1615d;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$IntRef;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.of0;
import me.tvspark.og0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class CombinedContext implements og0, Serializable {
    public final og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww element;
    public final og0 left;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Serialized implements Serializable {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        public static final long serialVersionUID = 0;
        public final og0[] elements;

        /* loaded from: classes4.dex */
        public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
            }
        }

        public Serialized(og0[] og0VarArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0VarArr, "elements");
            this.elements = og0VarArr;
        }

        private final Object readResolve() {
            og0[] og0VarArr = this.elements;
            og0 og0Var = EmptyCoroutineContext.INSTANCE;
            for (og0 og0Var2 : og0VarArr) {
                og0Var = og0Var.plus(og0Var2);
            }
            return og0Var;
        }

        public final og0[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(og0 og0Var, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0Var, "left");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "element");
        this.left = og0Var;
        this.element = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    private final boolean contains(og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getKey()), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            og0 og0Var = combinedContext.left;
            if (!(og0Var instanceof CombinedContext)) {
                if (og0Var == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                }
                return contains((og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) og0Var);
            }
            combinedContext = (CombinedContext) og0Var;
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            og0 og0Var = combinedContext.left;
            if (!(og0Var instanceof CombinedContext)) {
                og0Var = null;
            }
            combinedContext = (CombinedContext) og0Var;
            if (combinedContext != null) {
                i++;
            } else {
                return i;
            }
        }
    }

    private final Object writeReplace() {
        int size = size();
        og0[] og0VarArr = new og0[size];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        boolean z = false;
        ref$IntRef.element = 0;
        fold(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new CombinedContext$writeReplace$1(og0VarArr, ref$IntRef));
        if (ref$IntRef.element == size) {
            z = true;
        }
        if (z) {
            return new Serialized(og0VarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // me.tvspark.og0
    public <R> R fold(R r, mh0<? super R, ? super og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ? extends R> mh0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mh0Var, "operation");
        return mh0Var.mo4918invoke((Object) this.left.fold(r, mh0Var), this.element);
    }

    @Override // me.tvspark.og0
    public <E extends og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> E get(og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Person.KEY_KEY);
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (e != null) {
                return e;
            }
            og0 og0Var = combinedContext.left;
            if (!(og0Var instanceof CombinedContext)) {
                return (E) og0Var.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            combinedContext = (CombinedContext) og0Var;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // me.tvspark.og0
    public og0 minusKey(og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Person.KEY_KEY);
        if (this.element.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            return this.left;
        }
        og0 minusKey = this.left.minusKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // me.tvspark.og0
    public og0 plus(og0 og0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0Var, C1615d.f3292R);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0Var, C1615d.f3292R);
        return og0Var == EmptyCoroutineContext.INSTANCE ? this : (og0) og0Var.fold(this, CoroutineContext$plus$1.INSTANCE);
    }

    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("["), (String) fold("", CombinedContext$toString$1.INSTANCE), "]");
    }
}
