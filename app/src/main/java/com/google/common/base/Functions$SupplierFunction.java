package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Functions$SupplierFunction<T> implements AbstractC2271jt<Object, T>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2684ut<T> supplier;

    public Functions$SupplierFunction(AbstractC2684ut<T> abstractC2684ut) {
        if (abstractC2684ut != null) {
            this.supplier = abstractC2684ut;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public T mo4462apply(Object obj) {
        return this.supplier.mo4804get();
    }

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Functions$SupplierFunction) {
            return this.supplier.equals(((Functions$SupplierFunction) obj).supplier);
        }
        return false;
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Functions.forSupplier(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.supplier);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
