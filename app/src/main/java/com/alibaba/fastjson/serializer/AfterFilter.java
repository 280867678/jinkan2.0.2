package com.alibaba.fastjson.serializer;

/* loaded from: classes3.dex */
public abstract class AfterFilter implements SerializeFilter {
    public static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<>();
    public static final ThreadLocal<Character> seperatorLocal = new ThreadLocal<>();
    public static final Character COMMA = ',';

    public final char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        serializerLocal.set(jSONSerializer);
        seperatorLocal.set(Character.valueOf(c));
        writeAfter(obj);
        serializerLocal.set(null);
        return seperatorLocal.get().charValue();
    }

    public abstract void writeAfter(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        char charValue = seperatorLocal.get().charValue();
        serializerLocal.get().writeKeyValue(charValue, str, obj);
        if (charValue != ',') {
            seperatorLocal.set(COMMA);
        }
    }
}
