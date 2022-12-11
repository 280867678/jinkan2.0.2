package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class EnumDeserializer implements ObjectDeserializer {
    public final Class<?> enumClass;
    public long[] enumNameHashCodes;
    public final Enum[] enums;
    public final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i = 0;
        while (true) {
            Enum[] enumArr2 = this.ordinalEnums;
            if (i >= enumArr2.length) {
                break;
            }
            String name = enumArr2[i].name();
            long j = -3750763034362895579L;
            for (int i2 = 0; i2 < name.length(); i2++) {
                j = (j ^ name.charAt(i2)) * 1099511628211L;
            }
            jArr[i] = j;
            this.enumNameHashCodes[i] = j;
            i++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i3 = 0; i3 < this.enumNameHashCodes.length; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (this.enumNameHashCodes[i3] == jArr[i4]) {
                    this.enums[i3] = this.ordinalEnums[i4];
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token;
            if (i == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0 && intValue <= this.ordinalEnums.length) {
                    return (T) this.ordinalEnums[intValue];
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            } else if (i != 4) {
                if (i == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                Object parse = defaultJSONParser.parse();
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + parse);
            } else {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                long j = -3750763034362895579L;
                for (int i2 = 0; i2 < stringVal.length(); i2++) {
                    j = (j ^ stringVal.charAt(i2)) * 1099511628211L;
                }
                int binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j);
                if (binarySearch >= 0) {
                    return (T) this.enums[binarySearch];
                }
                return null;
            }
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }
}
