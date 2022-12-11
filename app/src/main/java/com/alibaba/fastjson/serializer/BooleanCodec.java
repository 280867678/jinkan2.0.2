package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public final class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = new BooleanCodec();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r3 == 1) goto L4;
     */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i != 6) {
            if (i == 7) {
                jSONLexer.nextToken(16);
            } else if (i != 2) {
                Object parse = defaultJSONParser.parse();
                if (parse != null) {
                    return (T) TypeUtils.castToBoolean(parse);
                }
                return null;
            } else {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
            }
            return (T) Boolean.FALSE;
        }
        jSONLexer.nextToken(16);
        return (T) Boolean.TRUE;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0) {
                serializeWriter.write("false");
            } else {
                serializeWriter.writeNull();
            }
        } else if (bool.booleanValue()) {
            serializeWriter.write("true");
        } else {
            serializeWriter.write("false");
        }
    }
}
