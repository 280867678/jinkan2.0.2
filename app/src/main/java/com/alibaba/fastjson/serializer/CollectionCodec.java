package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import me.tvspark.outline;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.alibaba.fastjson.JSONArray, T, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            ?? r4 = (T) new JSONArray();
            defaultJSONParser.parseArray(r4);
            return r4;
        } else {
            Type type2 = type;
            while (!(type2 instanceof Class)) {
                if (!(type2 instanceof ParameterizedType)) {
                    throw new JSONException("TODO");
                }
                type2 = ((ParameterizedType) type2).getRawType();
            }
            Class cls = (Class) type2;
            if (cls == AbstractCollection.class || cls == Collection.class) {
                t = (T) new ArrayList();
            } else if (cls.isAssignableFrom(HashSet.class)) {
                t = (T) new HashSet();
            } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
                t = (T) new LinkedHashSet();
            } else if (cls.isAssignableFrom(TreeSet.class)) {
                t = (T) new TreeSet();
            } else if (cls.isAssignableFrom(ArrayList.class)) {
                t = (T) new ArrayList();
            } else if (cls.isAssignableFrom(EnumSet.class)) {
                t = (T) EnumSet.noneOf(type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class);
            } else {
                try {
                    t = (Collection) cls.newInstance();
                } catch (Exception unused) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("create instane error, class ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
                    throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
            defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), (Collection) t, obj);
            return t;
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        Type type2 = null;
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            type2 = TypeUtils.getCollectionItemType(type);
        }
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        int i = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            if (HashSet.class == collection.getClass()) {
                str = "Set";
            } else if (TreeSet.class == collection.getClass()) {
                str = "TreeSet";
            }
            serializeWriter.mo4402append((CharSequence) str);
        }
        try {
            serializeWriter.write(91);
            for (Object obj3 : collection) {
                int i2 = i + 1;
                if (i != 0) {
                    serializeWriter.write(44);
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) obj3).longValue());
                        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer.config.get(cls).write(jSONSerializer, obj3, Integer.valueOf(i2 - 1), type2);
                    }
                }
                i = i2;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
