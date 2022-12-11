package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class Longs$LongConverter extends Converter<String, Long> implements Serializable {
    public static final Longs$LongConverter INSTANCE = new Longs$LongConverter();
    public static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Converter
    public String doBackward(Long l) {
        return l.toString();
    }

    @Override // com.google.common.base.Converter
    public Long doForward(String str) {
        return Long.decode(str);
    }

    public String toString() {
        return "Longs.stringConverter()";
    }
}
