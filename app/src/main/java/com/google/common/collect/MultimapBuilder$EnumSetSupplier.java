package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumSet;
import java.util.Set;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public final class MultimapBuilder$EnumSetSupplier<V extends Enum<V>> implements AbstractC2684ut<Set<V>>, Serializable {
    public final Class<V> clazz;

    public MultimapBuilder$EnumSetSupplier(Class<V> cls) {
        if (cls != null) {
            this.clazz = cls;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo4804get() {
        return EnumSet.noneOf(this.clazz);
    }
}
