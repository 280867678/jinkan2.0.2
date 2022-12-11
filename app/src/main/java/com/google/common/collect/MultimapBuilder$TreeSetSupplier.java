package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public final class MultimapBuilder$TreeSetSupplier<V> implements AbstractC2684ut<SortedSet<V>>, Serializable {
    public final Comparator<? super V> comparator;

    public MultimapBuilder$TreeSetSupplier(Comparator<? super V> comparator) {
        if (comparator != null) {
            this.comparator = comparator;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get  reason: collision with other method in class */
    public SortedSet<V> mo4804get() {
        return new TreeSet(this.comparator);
    }
}
