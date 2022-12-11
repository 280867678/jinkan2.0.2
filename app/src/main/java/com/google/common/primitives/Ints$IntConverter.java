package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class Ints$IntConverter extends Converter<String, Integer> implements Serializable {
    public static final Ints$IntConverter INSTANCE = new Ints$IntConverter();
    public static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Converter
    public String doBackward(Integer num) {
        return num.toString();
    }

    @Override // com.google.common.base.Converter
    public Integer doForward(String str) {
        return Integer.decode(str);
    }

    public String toString() {
        return "Ints.stringConverter()";
    }
}
