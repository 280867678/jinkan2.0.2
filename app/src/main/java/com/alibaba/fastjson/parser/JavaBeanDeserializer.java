package com.alibaba.fastjson.parser;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.umeng.analytics.pro.C1543ak;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    public final Class<?> clazz;
    public ConcurrentMap<String, Object> extraFieldDeserializers;
    public final FieldDeserializer[] fieldDeserializers;
    public transient long[] smartMatchHashArray;
    public transient int[] smartMatchHashArrayMapping;
    public final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        String[] strArr;
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:404:0x04b5
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r45, java.lang.reflect.Type r46, java.lang.Object r47, java.lang.Object r48) {
        /*
            Method dump skipped, instructions count: 2027
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0239, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal enum." + r2.info());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0113, code lost:
        throw new com.alibaba.fastjson.JSONException("not match string. feild : " + r19);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        char charAt;
        char charAt2;
        Enum r8;
        String str;
        char charAt3;
        char charAt4;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (true) {
            int i2 = 16;
            if (i >= length) {
                if (jSONLexer.f159ch == ',') {
                    int i3 = jSONLexer.f158bp + 1;
                    jSONLexer.f158bp = i3;
                    jSONLexer.f159ch = i3 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i3);
                    jSONLexer.token = 16;
                } else {
                    jSONLexer.nextToken();
                }
                return t;
            }
            char c = i == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t, new Integer(scanLongValue));
                    }
                    if (jSONLexer.f159ch == ',') {
                        int i4 = jSONLexer.f158bp + 1;
                        jSONLexer.f158bp = i4;
                        charAt4 = i4 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i4);
                        jSONLexer.f159ch = charAt4;
                        jSONLexer.token = 16;
                    } else {
                        if (jSONLexer.f159ch == ']') {
                            int i5 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i5;
                            charAt3 = i5 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i5);
                            jSONLexer.f159ch = charAt3;
                            jSONLexer.token = 15;
                        }
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    if (jSONLexer.f159ch == '\"') {
                        str = jSONLexer.scanStringValue('\"');
                    } else if (jSONLexer.f159ch != 'n' || !jSONLexer.text.startsWith("null", jSONLexer.f158bp)) {
                        break;
                    } else {
                        int i6 = jSONLexer.f158bp + 4;
                        jSONLexer.f158bp = i6;
                        jSONLexer.f159ch = i6 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i6);
                        str = null;
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t, str);
                    } else {
                        fieldDeserializer.setValue(t, str);
                    }
                    if (jSONLexer.f159ch == ',') {
                        int i7 = jSONLexer.f158bp + 1;
                        jSONLexer.f158bp = i7;
                        charAt4 = i7 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i7);
                        jSONLexer.f159ch = charAt4;
                        jSONLexer.token = 16;
                    } else {
                        if (jSONLexer.f159ch == ']') {
                            int i8 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i8;
                            charAt3 = i8 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i8);
                            jSONLexer.f159ch = charAt3;
                            jSONLexer.token = 15;
                        }
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(t, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t, new Long(scanLongValue2));
                        }
                        if (jSONLexer.f159ch == ',') {
                            int i9 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i9;
                            charAt2 = i9 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i9);
                            jSONLexer.f159ch = charAt2;
                            jSONLexer.token = i2;
                        } else {
                            if (jSONLexer.f159ch == ']') {
                                int i10 = jSONLexer.f158bp + 1;
                                jSONLexer.f158bp = i10;
                                charAt = i10 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i10);
                                jSONLexer.f159ch = charAt;
                                i2 = 15;
                                jSONLexer.token = i2;
                            }
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(t, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t, Boolean.valueOf(scanBoolean));
                        }
                        if (jSONLexer.f159ch == ',') {
                            int i11 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i11;
                            charAt2 = i11 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i11);
                            jSONLexer.f159ch = charAt2;
                            jSONLexer.token = i2;
                        } else {
                            if (jSONLexer.f159ch == ']') {
                                int i12 = jSONLexer.f158bp + 1;
                                jSONLexer.f158bp = i12;
                                charAt = i12 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i12);
                                jSONLexer.f159ch = charAt;
                                i2 = 15;
                                jSONLexer.token = i2;
                            }
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c2 = jSONLexer.f159ch;
                        if (c2 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            r8 = scanSymbol == null ? null : Enum.valueOf(cls, scanSymbol);
                        } else if (c2 < '0' || c2 > '9') {
                            break;
                        } else {
                            r8 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).ordinalEnums[(int) jSONLexer.scanLongValue()];
                        }
                        fieldDeserializer.setValue(t, r8);
                        if (jSONLexer.f159ch == ',') {
                            int i13 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i13;
                            charAt2 = i13 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i13);
                            jSONLexer.f159ch = charAt2;
                            jSONLexer.token = i2;
                        } else {
                            if (jSONLexer.f159ch == ']') {
                                int i14 = jSONLexer.f158bp + 1;
                                jSONLexer.f158bp = i14;
                                charAt = i14 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i14);
                                jSONLexer.f159ch = charAt;
                                i2 = 15;
                                jSONLexer.token = i2;
                            }
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.f159ch == '1') {
                        fieldDeserializer.setValue(t, new Date(jSONLexer.scanLongValue()));
                        if (jSONLexer.f159ch == ',') {
                            int i15 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i15;
                            charAt2 = i15 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i15);
                            jSONLexer.f159ch = charAt2;
                            jSONLexer.token = i2;
                        } else {
                            if (jSONLexer.f159ch == ']') {
                                int i16 = jSONLexer.f158bp + 1;
                                jSONLexer.f158bp = i16;
                                charAt = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
                                jSONLexer.f159ch = charAt;
                                i2 = 15;
                                jSONLexer.token = i2;
                            }
                            jSONLexer.nextToken();
                        }
                    } else {
                        if (jSONLexer.f159ch == '[') {
                            int i17 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i17;
                            jSONLexer.f159ch = i17 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i17);
                            jSONLexer.token = 14;
                        } else if (jSONLexer.f159ch == '{') {
                            int i18 = jSONLexer.f158bp + 1;
                            jSONLexer.f158bp = i18;
                            jSONLexer.f159ch = i18 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i18);
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t, fieldInfo.fieldType, null);
                        if (c == ']') {
                            if (jSONLexer.token != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (c == ',' && jSONLexer.token != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i++;
                }
                i++;
            } catch (IllegalAccessException e) {
                throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set "), fieldInfo.name, "error"), e);
            }
        }
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        Field[] declaredFields;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            fieldDeserializer = smartMatch(str);
        }
        int i = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && ((defaultJSONParser.lexer.features & i) != 0 || (i & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> cls = this.clazz; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(':');
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    private FieldDeserializer smartMatch(String str) {
        boolean z;
        long fnv_64_lower = TypeUtils.fnv_64_lower(str);
        int i = 0;
        if (this.smartMatchHashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.smartMatchHashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
        if (binarySearch < 0) {
            z = str.startsWith(C1543ak.f2994ae);
            if (z) {
                binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str.substring(2)));
            }
        } else {
            z = false;
        }
        if (binarySearch >= 0) {
            if (this.smartMatchHashArrayMapping == null) {
                int[] iArr = new int[this.smartMatchHashArray.length];
                Arrays.fill(iArr, -1);
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                    if (i >= fieldDeserializerArr2.length) {
                        break;
                    }
                    int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                    if (binarySearch2 >= 0) {
                        iArr[binarySearch2] = i;
                    }
                    i++;
                }
                this.smartMatchHashArrayMapping = iArr;
            }
            int i3 = this.smartMatchHashArrayMapping[binarySearch];
            if (i3 == -1) {
                return null;
            }
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i3];
            Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
            if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                return null;
            }
            return fieldDeserializer;
        }
        return null;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        FieldInfo[] fieldInfoArr;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.defaultConstructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        if (javaBeanInfo2.factoryMethod != null && javaBeanInfo2.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            Constructor<?> constructor = this.beanInfo.defaultConstructor;
            Object newInstance = this.beanInfo.defaultConstructorParameterSize == 0 ? constructor != null ? constructor.newInstance(new Object[0]) : this.beanInfo.factoryMethod.invoke(null, new Object[0]) : constructor.newInstance(defaultJSONParser.contex.object);
            if (defaultJSONParser != null && (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        fieldInfo.set(newInstance, "");
                    }
                }
            }
            return newInstance;
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("create instance error, class ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.clazz.getName());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x013b, code lost:
        if (r5 == r1.getClass()) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        float floatValue;
        double doubleValue;
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor != null) {
            FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
            int length = fieldInfoArr.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                FieldInfo fieldInfo = fieldInfoArr[i];
                Object obj = map.get(fieldInfo.name);
                if (obj == null) {
                    obj = TypeUtils.defaultValue(fieldInfo.fieldClass);
                }
                objArr[i] = obj;
            }
            Constructor<?> constructor = this.beanInfo.creatorConstructor;
            if (constructor == null) {
                return null;
            }
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("create instance error, ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.beanInfo.creatorConstructor.toGenericString());
                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
        }
        Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
            if (fieldDeserializer != null) {
                Object value = entry.getValue();
                if (value == null) {
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (cls == Integer.TYPE) {
                        value = 0;
                    } else if (cls == Long.TYPE) {
                        value = 0L;
                    } else if (cls == Short.TYPE) {
                        value = (short) 0;
                    } else if (cls == Byte.TYPE) {
                        value = (byte) 0;
                    } else if (cls == Float.TYPE) {
                        value = Float.valueOf(0.0f);
                    } else if (cls == Double.TYPE) {
                        value = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
                    } else if (cls == Character.TYPE) {
                        value = '0';
                    } else if (cls == Boolean.TYPE) {
                        value = false;
                    }
                }
                FieldInfo fieldInfo2 = fieldDeserializer.fieldInfo;
                Method method = fieldInfo2.method;
                if (method != null) {
                    method.invoke(createInstance, TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                } else {
                    Field field = fieldInfo2.field;
                    Type type = fieldInfo2.fieldType;
                    if (type == Boolean.TYPE) {
                        if (value == Boolean.FALSE) {
                            field.setBoolean(createInstance, false);
                        } else if (value == Boolean.TRUE) {
                            field.setBoolean(createInstance, true);
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null && type == Date.class && (value instanceof String)) {
                                try {
                                    value = new SimpleDateFormat(str).parse((String) value);
                                } catch (ParseException unused) {
                                    value = null;
                                }
                            } else {
                                value = type instanceof ParameterizedType ? TypeUtils.cast(value, (ParameterizedType) type, parserConfig) : TypeUtils.cast(value, type, parserConfig);
                            }
                            field.set(createInstance, value);
                        }
                    } else if (type == Integer.TYPE) {
                        if (value instanceof Number) {
                            field.setInt(createInstance, ((Number) value).intValue());
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null) {
                            }
                            if (type instanceof ParameterizedType) {
                            }
                            field.set(createInstance, value);
                        }
                    } else if (type == Long.TYPE) {
                        if (value instanceof Number) {
                            field.setLong(createInstance, ((Number) value).longValue());
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null) {
                            }
                            if (type instanceof ParameterizedType) {
                            }
                            field.set(createInstance, value);
                        }
                    } else if (type == Float.TYPE) {
                        if (value instanceof Number) {
                            floatValue = ((Number) value).floatValue();
                        } else if (value instanceof String) {
                            String str2 = (String) value;
                            floatValue = str2.length() <= 10 ? TypeUtils.parseFloat(str2) : Float.parseFloat(str2);
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null) {
                            }
                            if (type instanceof ParameterizedType) {
                            }
                            field.set(createInstance, value);
                        }
                        field.setFloat(createInstance, floatValue);
                    } else {
                        if (type == Double.TYPE) {
                            if (value instanceof Number) {
                                doubleValue = ((Number) value).doubleValue();
                            } else if (value instanceof String) {
                                String str3 = (String) value;
                                doubleValue = str3.length() <= 10 ? TypeUtils.parseDouble(str3) : Double.parseDouble(str3);
                            }
                            field.setDouble(createInstance, doubleValue);
                        } else if (value != null) {
                        }
                        str = fieldDeserializer.fieldInfo.format;
                        if (str == null) {
                        }
                        if (type instanceof ParameterizedType) {
                        }
                        field.set(createInstance, value);
                    }
                }
            }
        }
        return createInstance;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (!this.beanInfo.ordered) {
            int length = this.sortedFieldDeserializers.length - 1;
            int i2 = 0;
            while (i2 <= length) {
                int i3 = (i2 + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i3].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i2 = i3 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedFieldDeserializers[i3];
                } else {
                    length = i3 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i4 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i4 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i4] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i4].fieldInfo.name);
                    i4++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str));
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i5 = this.smartMatchHashArrayMapping[binarySearch];
                if (i5 != -1) {
                    return this.sortedFieldDeserializers[i5];
                }
            }
            return smartMatch(str);
        }
        while (true) {
            FieldDeserializer[] fieldDeserializerArr3 = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr3.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr3[i];
            if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    public FieldDeserializer getFieldDeserializerByHash(long j) {
        int i = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i < fieldDeserializerArr.length) {
                FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
                if (fieldDeserializer.fieldInfo.nameHashCode == j) {
                    return fieldDeserializer;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) == 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setter not found, class ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.clazz.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", property ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        jSONLexer.nextTokenWithChar(':');
        Type type = null;
        List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
        if (list != null) {
            for (ExtraTypeProvider extraTypeProvider : list) {
                type = extraTypeProvider.getExtraType(obj, str);
            }
        }
        Object parse = type == null ? defaultJSONParser.parse() : defaultJSONParser.parseObject(type);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parse);
            return;
        }
        List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
        if (list2 == null) {
            return;
        }
        for (ExtraProcessor extraProcessor : list2) {
            extraProcessor.processExtra(obj, str, parse);
        }
    }
}
