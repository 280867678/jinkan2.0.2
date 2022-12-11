package com.google.common.collect;

import java.util.LinkedList;
import java.util.List;
import me.tvspark.AbstractC2684ut;

/* loaded from: classes3.dex */
public enum MultimapBuilder$LinkedListSupplier implements AbstractC2684ut<List<Object>> {
    INSTANCE;

    public static <V> AbstractC2684ut<List<V>> instance() {
        return INSTANCE;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get  reason: collision with other method in class */
    public List<Object> mo4804get() {
        return new LinkedList();
    }
}
