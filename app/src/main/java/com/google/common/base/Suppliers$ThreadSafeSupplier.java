package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2684ut;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Suppliers$ThreadSafeSupplier<T> implements AbstractC2684ut<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2684ut<T> delegate;

    public Suppliers$ThreadSafeSupplier(AbstractC2684ut<T> abstractC2684ut) {
        if (abstractC2684ut != null) {
            this.delegate = abstractC2684ut;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get */
    public T mo4804get() {
        T mo4804get;
        synchronized (this.delegate) {
            mo4804get = this.delegate.mo4804get();
        }
        return mo4804get;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Suppliers.synchronizedSupplier(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.delegate);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
