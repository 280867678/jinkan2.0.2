package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t = (T) Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t = (T) Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e) {
                    throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("int value overflow, field : ", obj), e);
                }
            }
            jSONLexer.nextToken(16);
            return t;
        } else if (i == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Long.TYPE || type == Long.class) ? (T) Long.valueOf(decimalValue.longValueExact()) : (T) Integer.valueOf(decimalValue.intValueExact());
        } else {
            T t2 = (T) defaultJSONParser.parse();
            try {
                if (type != Long.TYPE && type != Long.class) {
                    t2 = (T) TypeUtils.castToInt(t2);
                    return t2;
                }
                t2 = (T) TypeUtils.castToLong(t2);
                return t2;
            } catch (Exception e2) {
                throw new JSONException("cast error, field : " + obj + ", value " + t2, e2);
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        int i;
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0) {
            return;
        }
        Class<?> cls = number.getClass();
        if (cls == Byte.class) {
            i = 66;
        } else if (cls == Short.class) {
            i = 83;
        } else if (cls != Long.class) {
            return;
        } else {
            long longValue = number.longValue();
            if (longValue > 2147483647L || longValue < -2147483648L || type == Long.class) {
                return;
            }
            i = 76;
        }
        serializeWriter.write(i);
    }
}
