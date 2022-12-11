package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2271jt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Functions$ConstantFunction<E> implements AbstractC2271jt<Object, E>, Serializable {
    public static final long serialVersionUID = 0;
    public final E value;

    public Functions$ConstantFunction(E e) {
        this.value = e;
    }

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public E mo4462apply(Object obj) {
        return this.value;
    }

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Functions$ConstantFunction) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value, ((Functions$ConstantFunction) obj).value);
        }
        return false;
    }

    public int hashCode() {
        E e = this.value;
        if (e == null) {
            return 0;
        }
        return e.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Functions.constant(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.value);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
