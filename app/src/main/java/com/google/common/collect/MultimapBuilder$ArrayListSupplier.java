package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class MultimapBuilder$ArrayListSupplier<V> implements AbstractC2684ut<List<V>>, Serializable {
    public final int expectedValuesPerKey;

    public MultimapBuilder$ArrayListSupplier(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get  reason: collision with other method in class */
    public List<V> mo4804get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
