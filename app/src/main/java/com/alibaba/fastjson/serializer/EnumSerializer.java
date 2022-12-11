package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class EnumSerializer implements ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Enum r2 = (Enum) obj;
        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) == 0) {
            serializeWriter.writeInt(r2.ordinal());
            return;
        }
        String str = r2.toString();
        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeStringWithSingleQuote(str);
        } else {
            serializeWriter.writeStringWithDoubleQuote(str, (char) 0, false);
        }
    }
}
