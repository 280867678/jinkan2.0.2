package com.google.common.collect;

import java.util.Map;
import me.tvspark.AbstractC2271jt;
import me.tvspark.C2126fw;

/* loaded from: classes3.dex */
public enum Maps$EntryFunction implements AbstractC2271jt<Map.Entry<?, ?>, Object> {
    KEY { // from class: com.google.common.collect.Maps$EntryFunction.1
        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply  reason: avoid collision after fix types in other method */
        public Object mo4462apply(Map.Entry<?, ?> entry) {
            return entry.getKey();
        }
    },
    VALUE { // from class: com.google.common.collect.Maps$EntryFunction.2
        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply  reason: avoid collision after fix types in other method */
        public Object mo4462apply(Map.Entry<?, ?> entry) {
            return entry.getValue();
        }
    };

    /* synthetic */ Maps$EntryFunction(C2126fw c2126fw) {
        this();
    }
}
