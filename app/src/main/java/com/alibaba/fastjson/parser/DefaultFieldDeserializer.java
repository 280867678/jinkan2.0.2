package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    public ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 2);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        return this.fieldValueDeserilizer;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Object deserialze;
        Class<?> cls;
        if (this.fieldValueDeserilizer == null) {
            ParserConfig parserConfig = defaultJSONParser.config;
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        Type type2 = this.fieldInfo.fieldType;
        boolean z = type instanceof ParameterizedType;
        if (z) {
            ParseContext parseContext = defaultJSONParser.contex;
            if (parseContext != null) {
                parseContext.type = type;
            }
            type2 = FieldInfo.getFieldType(this.clazz, type, type2);
            this.fieldValueDeserilizer = defaultJSONParser.config.getDeserializer(type2);
        }
        if ((type2 instanceof ParameterizedType) && z) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            ParameterizedType parameterizedType2 = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType2.getRawType();
            if ((rawType instanceof Class) && TypeUtils.getArgument(actualTypeArguments, ((Class) rawType).getTypeParameters(), parameterizedType2.getActualTypeArguments())) {
                type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
            }
        }
        FieldInfo fieldInfo2 = this.fieldInfo;
        String str = fieldInfo2.format;
        if (str != null) {
            ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
            if (objectDeserializer instanceof DateCodec) {
                deserialze = ((DateCodec) objectDeserializer).deserialze(defaultJSONParser, type2, fieldInfo2.name, str);
                if (defaultJSONParser.resolveStatus != 1) {
                    DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
                    lastResolveTask.fieldDeserializer = this;
                    lastResolveTask.ownerContext = defaultJSONParser.contex;
                    defaultJSONParser.resolveStatus = 0;
                    return;
                } else if (obj == null) {
                    map.put(this.fieldInfo.name, deserialze);
                    return;
                } else if (deserialze == null && ((cls = this.fieldInfo.fieldClass) == Byte.TYPE || cls == Short.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                    return;
                } else {
                    setValue(obj, deserialze);
                    return;
                }
            }
        }
        deserialze = this.fieldValueDeserilizer.deserialze(defaultJSONParser, type2, this.fieldInfo.name);
        if (defaultJSONParser.resolveStatus != 1) {
        }
    }
}
