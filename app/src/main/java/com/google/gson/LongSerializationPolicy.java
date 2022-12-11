package com.google.gson;

import me.tvspark.AbstractC3508o00;
import me.tvspark.r00;

/* loaded from: classes3.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public AbstractC3508o00 serialize(Long l) {
            return new r00(l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public AbstractC3508o00 serialize(Long l) {
            return new r00(String.valueOf(l));
        }
    };

    public abstract AbstractC3508o00 serialize(Long l);
}
