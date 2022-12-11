package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.AbstractSequentialList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class SerializeConfig {
    public static final SerializeConfig globalInstance = new SerializeConfig();
    public PropertyNamingStrategy propertyNamingStrategy;
    public final IdentityHashMap<ObjectSerializer> serializers;
    public String typeKey = JSON.DEFAULT_TYPE_KEY;

    public SerializeConfig() {
        IdentityHashMap<ObjectSerializer> identityHashMap = new IdentityHashMap<>(1024);
        this.serializers = identityHashMap;
        identityHashMap.put(Boolean.class, BooleanCodec.instance);
        this.serializers.put(Character.class, MiscCodec.instance);
        this.serializers.put(Byte.class, IntegerCodec.instance);
        this.serializers.put(Short.class, IntegerCodec.instance);
        this.serializers.put(Integer.class, IntegerCodec.instance);
        this.serializers.put(Long.class, IntegerCodec.instance);
        this.serializers.put(Float.class, NumberCodec.instance);
        this.serializers.put(Double.class, NumberCodec.instance);
        this.serializers.put(Number.class, NumberCodec.instance);
        this.serializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.serializers.put(BigInteger.class, BigDecimalCodec.instance);
        this.serializers.put(String.class, StringCodec.instance);
        this.serializers.put(Object[].class, ArrayCodec.instance);
        this.serializers.put(Class.class, MiscCodec.instance);
        this.serializers.put(SimpleDateFormat.class, MiscCodec.instance);
        this.serializers.put(Locale.class, MiscCodec.instance);
        this.serializers.put(Currency.class, MiscCodec.instance);
        this.serializers.put(TimeZone.class, MiscCodec.instance);
        this.serializers.put(UUID.class, MiscCodec.instance);
        this.serializers.put(URI.class, MiscCodec.instance);
        this.serializers.put(URL.class, MiscCodec.instance);
        this.serializers.put(Pattern.class, MiscCodec.instance);
        this.serializers.put(Charset.class, MiscCodec.instance);
    }

    public static final SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectSerializer get(Class<?> cls) {
        IdentityHashMap<ObjectSerializer> identityHashMap;
        ObjectSerializer enumSerializer;
        Class<? super Object> superclass;
        boolean z;
        JavaBeanSerializer javaBeanSerializer;
        ArraySerializer arraySerializer;
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer == null) {
            if (Map.class.isAssignableFrom(cls)) {
                identityHashMap = this.serializers;
                enumSerializer = new MapSerializer();
            } else {
                if (!AbstractSequentialList.class.isAssignableFrom(cls)) {
                    if (List.class.isAssignableFrom(cls)) {
                        identityHashMap = this.serializers;
                        enumSerializer = new ListSerializer();
                    } else if (!Collection.class.isAssignableFrom(cls)) {
                        if (!Date.class.isAssignableFrom(cls)) {
                            if (!JSONAware.class.isAssignableFrom(cls) && !JSONSerializable.class.isAssignableFrom(cls) && !JSONStreamAware.class.isAssignableFrom(cls)) {
                                if (!cls.isEnum() && ((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
                                    if (cls.isArray()) {
                                        Class<?> componentType = cls.getComponentType();
                                        ObjectSerializer objectSerializer2 = get(componentType);
                                        IdentityHashMap<ObjectSerializer> identityHashMap2 = this.serializers;
                                        ArraySerializer arraySerializer2 = new ArraySerializer(componentType, objectSerializer2);
                                        identityHashMap2.put(cls, arraySerializer2);
                                        arraySerializer = arraySerializer2;
                                    } else {
                                        if (Throwable.class.isAssignableFrom(cls)) {
                                            JavaBeanSerializer javaBeanSerializer2 = new JavaBeanSerializer(cls, this.propertyNamingStrategy);
                                            javaBeanSerializer2.features |= SerializerFeature.WriteClassName.mask;
                                            javaBeanSerializer = javaBeanSerializer2;
                                        } else if (!TimeZone.class.isAssignableFrom(cls) && !Charset.class.isAssignableFrom(cls) && !Enumeration.class.isAssignableFrom(cls)) {
                                            if (!Calendar.class.isAssignableFrom(cls)) {
                                                Class<?>[] interfaces = cls.getInterfaces();
                                                int length = interfaces.length;
                                                boolean z2 = false;
                                                int i = 0;
                                                while (true) {
                                                    z = true;
                                                    if (i >= length) {
                                                        break;
                                                    }
                                                    Class<?> cls2 = interfaces[i];
                                                    if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                                                        break;
                                                    } else if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                                                        break;
                                                    } else {
                                                        i++;
                                                    }
                                                }
                                                z2 = true;
                                                z = false;
                                                if (z2 || z) {
                                                    ObjectSerializer objectSerializer3 = get(cls.getSuperclass());
                                                    this.serializers.put(cls, objectSerializer3);
                                                    return objectSerializer3;
                                                }
                                                javaBeanSerializer = cls.getName().startsWith("android.net.Uri$") ? MiscCodec.instance : new JavaBeanSerializer(cls, this.propertyNamingStrategy);
                                            }
                                        }
                                        this.serializers.put(cls, javaBeanSerializer);
                                        arraySerializer = javaBeanSerializer;
                                    }
                                    return arraySerializer != null ? this.serializers.get(cls) : arraySerializer;
                                }
                                identityHashMap = this.serializers;
                                enumSerializer = new EnumSerializer();
                            }
                            identityHashMap = this.serializers;
                            enumSerializer = MiscCodec.instance;
                        }
                        identityHashMap = this.serializers;
                        enumSerializer = DateCodec.instance;
                    }
                }
                identityHashMap = this.serializers;
                enumSerializer = CollectionCodec.instance;
            }
            identityHashMap.put(cls, enumSerializer);
            arraySerializer = enumSerializer;
            if (arraySerializer != null) {
            }
        } else {
            return objectSerializer;
        }
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer == null) {
            JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, i, null, z, z2, z3, z4, this.propertyNamingStrategy);
            this.serializers.put(cls, javaBeanSerializer);
            return javaBeanSerializer;
        }
        return objectSerializer;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }
}
