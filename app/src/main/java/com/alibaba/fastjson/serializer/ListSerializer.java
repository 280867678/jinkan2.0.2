package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public final class ListSerializer implements ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i = 1;
        boolean z = (serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0;
        Type type2 = null;
        if (z) {
            type2 = TypeUtils.getCollectionItemType(type);
        }
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        if (size == 0) {
            serializeWriter.mo4402append((CharSequence) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj, jSONSerializer.context);
        }
        try {
            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                serializeWriter.write(91);
                jSONSerializer.incrementIndent();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj3 = list.get(i2);
                    if (i2 != 0) {
                        serializeWriter.write(44);
                    }
                    jSONSerializer.println();
                    if (obj3 == null) {
                        jSONSerializer.out.writeNull();
                    } else if (jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj3)) {
                        ObjectSerializer objectSerializer = jSONSerializer.config.get(obj3.getClass());
                        jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0);
                        objectSerializer.write(jSONSerializer, obj3, Integer.valueOf(i2), type2);
                    } else {
                        jSONSerializer.writeReference(obj3);
                    }
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            int i3 = serializeWriter.count + 1;
            if (i3 > serializeWriter.buf.length) {
                if (serializeWriter.writer == null) {
                    serializeWriter.expandCapacity(i3);
                } else {
                    serializeWriter.flush();
                    i3 = 1;
                }
            }
            serializeWriter.buf[serializeWriter.count] = '[';
            serializeWriter.count = i3;
            for (int i4 = 0; i4 < list.size(); i4++) {
                Object obj4 = list.get(i4);
                if (i4 != 0) {
                    int i5 = serializeWriter.count + 1;
                    if (i5 > serializeWriter.buf.length) {
                        if (serializeWriter.writer == null) {
                            serializeWriter.expandCapacity(i5);
                        } else {
                            serializeWriter.flush();
                            i5 = 1;
                        }
                    }
                    serializeWriter.buf[serializeWriter.count] = ',';
                    serializeWriter.count = i5;
                }
                if (obj4 == null) {
                    serializeWriter.mo4402append((CharSequence) "null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj4).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj4).longValue();
                        if (z) {
                            serializeWriter.writeLong(longValue);
                            serializeWriter.write(76);
                        } else {
                            serializeWriter.writeLong(longValue);
                        }
                    } else if (cls == String.class) {
                        String str = (String) obj4;
                        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                            serializeWriter.writeStringWithSingleQuote(str);
                        } else {
                            serializeWriter.writeStringWithDoubleQuote(str, (char) 0, true);
                        }
                    } else {
                        if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                            jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0);
                        }
                        if (jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj4)) {
                            jSONSerializer.config.get(obj4.getClass()).write(jSONSerializer, obj4, Integer.valueOf(i4), type2);
                        } else {
                            jSONSerializer.writeReference(obj4);
                        }
                    }
                }
            }
            int i6 = serializeWriter.count + 1;
            if (i6 > serializeWriter.buf.length) {
                if (serializeWriter.writer != null) {
                    serializeWriter.flush();
                    serializeWriter.buf[serializeWriter.count] = ']';
                    serializeWriter.count = i;
                }
                serializeWriter.expandCapacity(i6);
            }
            i = i6;
            serializeWriter.buf[serializeWriter.count] = ']';
            serializeWriter.count = i;
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
