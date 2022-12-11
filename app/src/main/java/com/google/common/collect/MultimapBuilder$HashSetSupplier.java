package com.google.common.collect;

import java.io.Serializable;
import java.util.Set;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class MultimapBuilder$HashSetSupplier<V> implements AbstractC2684ut<Set<V>>, Serializable {
    public final int expectedValuesPerKey;

    public MultimapBuilder$HashSetSupplier(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo4804get() {
        return CompactHashSet.createWithExpectedSize(this.expectedValuesPerKey);
    }
}
