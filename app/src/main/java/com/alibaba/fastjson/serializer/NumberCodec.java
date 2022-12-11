package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = new NumberCodec();
    public DecimalFormat decimalFormat;

    public NumberCodec() {
        this.decimalFormat = null;
    }

    public NumberCodec(String str) {
        this(new DecimalFormat(str));
    }

    public NumberCodec(DecimalFormat decimalFormat) {
        this.decimalFormat = null;
        this.decimalFormat = decimalFormat;
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [java.math.BigDecimal, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            } else if (type == Float.TYPE || type == Float.class) {
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(numberString2));
            } else {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken(16);
                return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf((short) longValue) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf((byte) longValue) : (longValue < -2147483648L || longValue > 2147483647L) ? (T) Long.valueOf(longValue) : (T) Integer.valueOf((int) longValue);
            }
        } else if (i != 3) {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (type == Double.TYPE || type == Double.class) ? (T) TypeUtils.castToDouble(parse) : (type == Float.TYPE || type == Float.class) ? (T) TypeUtils.castToFloat(parse) : (type == Short.TYPE || type == Short.class) ? (T) TypeUtils.castToShort(parse) : (type == Byte.TYPE || type == Byte.class) ? (T) TypeUtils.castToByte(parse) : (T) TypeUtils.castToBigDecimal(parse);
        } else if (type == Double.TYPE || type == Double.class) {
            String numberString3 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString3));
        } else if (type == Float.TYPE || type == Float.class) {
            String numberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Float.valueOf(Float.parseFloat(numberString4));
        } else {
            ?? r8 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf(r8.shortValueExact()) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r8.byteValueExact()) : r8;
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String format;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
            } else {
                serializeWriter.writeNull();
            }
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue) || Float.isInfinite(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            String f = Float.toString(floatValue);
            if (f.endsWith(".0")) {
                f = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, -2, 0);
            }
            serializeWriter.write(f);
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0) {
                return;
            }
            serializeWriter.write(70);
        } else {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                serializeWriter.writeNull();
                return;
            }
            DecimalFormat decimalFormat = this.decimalFormat;
            if (decimalFormat == null) {
                format = Double.toString(doubleValue);
                if (format.endsWith(".0")) {
                    format = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(format, -2, 0);
                }
            } else {
                format = decimalFormat.format(doubleValue);
            }
            serializeWriter.mo4402append((CharSequence) format);
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0) {
                return;
            }
            serializeWriter.write(68);
        }
    }
}
