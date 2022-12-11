package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class Shorts$ShortConverter extends Converter<String, Short> implements Serializable {
    public static final Shorts$ShortConverter INSTANCE = new Shorts$ShortConverter();
    public static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Converter
    public String doBackward(Short sh) {
        return sh.toString();
    }

    @Override // com.google.common.base.Converter
    public Short doForward(String str) {
        return Short.decode(str);
    }

    public String toString() {
        return "Shorts.stringConverter()";
    }
}
