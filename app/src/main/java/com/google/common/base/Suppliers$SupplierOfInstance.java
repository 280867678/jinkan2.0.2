package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Suppliers$SupplierOfInstance<T> implements AbstractC2684ut<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final T instance;

    public Suppliers$SupplierOfInstance(T t) {
        this.instance = t;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Suppliers$SupplierOfInstance) {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.instance, ((Suppliers$SupplierOfInstance) obj).instance);
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get */
    public T mo4804get() {
        return this.instance;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.instance});
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Suppliers.ofInstance(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.instance);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
