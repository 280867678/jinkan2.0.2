package kotlin.jvm.internal;

import java.io.Serializable;
import me.tvspark.ef0;
import me.tvspark.hi0;
import me.tvspark.ii0;
import me.tvspark.ki0;

@ef0
/* loaded from: classes4.dex */
public abstract class Lambda<R> implements hi0<R>, Serializable {
    public final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // me.tvspark.hi0
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Reflection.renderLambdaToString(this)");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
