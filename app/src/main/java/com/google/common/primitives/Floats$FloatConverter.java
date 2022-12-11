package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class Floats$FloatConverter extends Converter<String, Float> implements Serializable {
    public static final Floats$FloatConverter INSTANCE = new Floats$FloatConverter();
    public static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Converter
    public String doBackward(Float f) {
        return f.toString();
    }

    @Override // com.google.common.base.Converter
    public Float doForward(String str) {
        return Float.valueOf(str);
    }

    public String toString() {
        return "Floats.stringConverter()";
    }
}
