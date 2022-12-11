package com.google.common.collect;

import com.google.common.base.Converter;
import java.io.Serializable;
import me.tvspark.AbstractC2648tu;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Maps$BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2648tu<A, B> bimap;

    public Maps$BiMapConverter(AbstractC2648tu<A, B> abstractC2648tu) {
        if (abstractC2648tu != null) {
            this.bimap = abstractC2648tu;
            return;
        }
        throw null;
    }

    public static <X, Y> Y convert(AbstractC2648tu<X, Y> abstractC2648tu, X x) {
        Y y = abstractC2648tu.get(x);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y != null, "No non-null mapping present for input: %s", x);
        return y;
    }

    @Override // com.google.common.base.Converter
    public A doBackward(B b) {
        return (A) convert(this.bimap.mo4713inverse(), b);
    }

    @Override // com.google.common.base.Converter
    public B doForward(A a) {
        return (B) convert(this.bimap, a);
    }

    @Override // com.google.common.base.Converter, me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Maps$BiMapConverter) {
            return this.bimap.equals(((Maps$BiMapConverter) obj).bimap);
        }
        return false;
    }

    public int hashCode() {
        return this.bimap.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Maps.asConverter(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.bimap);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
