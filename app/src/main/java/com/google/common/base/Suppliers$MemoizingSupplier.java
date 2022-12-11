package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2684ut;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Suppliers$MemoizingSupplier<T> implements AbstractC2684ut<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2684ut<T> delegate;
    public volatile transient boolean initialized;
    public transient T value;

    public Suppliers$MemoizingSupplier(AbstractC2684ut<T> abstractC2684ut) {
        if (abstractC2684ut != null) {
            this.delegate = abstractC2684ut;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get */
    public T mo4804get() {
        if (!this.initialized) {
            synchronized (this) {
                if (!this.initialized) {
                    T mo4804get = this.delegate.mo4804get();
                    this.value = mo4804get;
                    this.initialized = true;
                    return mo4804get;
                }
            }
        }
        return this.value;
    }

    public String toString() {
        Object obj;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Suppliers.memoize(");
        if (this.initialized) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<supplier that returned ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.value);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(">");
            obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        } else {
            obj = this.delegate;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
