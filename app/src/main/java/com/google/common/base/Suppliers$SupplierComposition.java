package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Suppliers$SupplierComposition<F, T> implements AbstractC2684ut<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2271jt<? super F, T> function;
    public final AbstractC2684ut<F> supplier;

    public Suppliers$SupplierComposition(AbstractC2271jt<? super F, T> abstractC2271jt, AbstractC2684ut<F> abstractC2684ut) {
        if (abstractC2271jt != null) {
            this.function = abstractC2271jt;
            if (abstractC2684ut == null) {
                throw null;
            }
            this.supplier = abstractC2684ut;
            return;
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Suppliers$SupplierComposition) {
            Suppliers$SupplierComposition suppliers$SupplierComposition = (Suppliers$SupplierComposition) obj;
            return this.function.equals(suppliers$SupplierComposition.function) && this.supplier.equals(suppliers$SupplierComposition.supplier);
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get */
    public T mo4804get() {
        return this.function.mo4462apply((F) this.supplier.mo4804get());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.supplier});
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Suppliers.compose(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.function);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.supplier);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
