package com.alibaba.fastjson.util;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.umeng.analytics.pro.C1543ak;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.optimizer.OptRuntime;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes3.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    public static volatile Map<Class, String[]> kotlinIgnores = null;
    public static volatile boolean kotlinIgnores_error = false;
    public static volatile boolean kotlin_class_klass_error = false;
    public static volatile boolean kotlin_error = false;
    public static volatile Constructor kotlin_kclass_constructor = null;
    public static volatile Method kotlin_kclass_getConstructors = null;
    public static volatile Method kotlin_kfunction_getParameters = null;
    public static volatile Method kotlin_kparameter_getName = null;
    public static volatile Class kotlin_metadata = null;
    public static volatile boolean kotlin_metadata_error = false;
    public static final ConcurrentMap<String, Class<?>> mappings;
    public static boolean setAccessibleEnable = true;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        mappings = concurrentHashMap;
        concurrentHashMap.put(ClassTransform.BYTE, Byte.TYPE);
        mappings.put(ClassTransform.SHORT, Short.TYPE);
        mappings.put(ClassTransform.INTEGER, Integer.TYPE);
        mappings.put(ClassTransform.LONG, Long.TYPE);
        mappings.put(ClassTransform.FLOAT, Float.TYPE);
        mappings.put(ClassTransform.DOUBLE, Double.TYPE);
        mappings.put(ClassTransform.BOOLEAN, Boolean.TYPE);
        mappings.put(ClassTransform.CHARACTER, Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        mappings.put("java.util.HashMap", HashMap.class);
        mappings.put("java.util.TreeMap", TreeMap.class);
        mappings.put("java.util.Date", Date.class);
        mappings.put("com.alibaba.fastjson.JSONObject", JSONObject.class);
        mappings.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        mappings.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        mappings.put("java.lang.StackTraceElement", StackTraceElement.class);
        mappings.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        return (T) cast(obj, cls, parserConfig, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig, int i) {
        T t;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig, i) : obj;
        }
        int i2 = 0;
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection<Object> collection = (Collection) obj;
                T t2 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                for (Object obj2 : collection) {
                    Array.set(t2, i2, cast(obj2, (Class<Object>) cls.getComponentType(), parserConfig));
                    i2++;
                }
                return t2;
            } else if (cls == byte[].class) {
                return (T) castToBytes(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) castToBoolean(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) castToByte(obj);
        }
        if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
            String str = (String) obj;
            if (str.length() == 1) {
                return (T) Character.valueOf(str.charAt(0));
            }
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) castToShort(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) castToInt(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) castToLong(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) castToFloat(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) castToDouble(obj);
        }
        if (cls == String.class) {
            return (T) castToString(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }
        if (cls == BigInteger.class) {
            return (T) castToBigInteger(obj);
        }
        if (cls == Date.class) {
            return (T) castToDate(obj);
        }
        if (cls.isEnum()) {
            return (T) castToEnum(obj, cls, parserConfig);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date castToDate = castToDate(obj);
            if (cls == Calendar.class) {
                t = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
            } else {
                try {
                    t = (T) ((Calendar) cls.newInstance());
                } catch (Exception e) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to : ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
                    throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
                }
            }
            ((Calendar) t).setTime(castToDate);
            return t;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str2);
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to : ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
        throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, java.util.HashMap] */
    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        if (obj == 0) {
            return obj;
        }
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ?? r0 = (T) new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    r0.add(type instanceof Class ? (obj2 == null || obj2.getClass() != JSONObject.class) ? cast(obj2, (Class) type, parserConfig, 0) : ((JSONObject) obj2).toJavaObject((Class) type, parserConfig, 0) : cast(obj2, type, parserConfig));
                }
                return r0;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    T next = it.next();
                    ((Collection) t).add(type2 instanceof Class ? (next == null || next.getClass() != JSONObject.class) ? cast(next, (Class) type2, parserConfig, 0) : ((JSONObject) next).toJavaObject((Class) type2, parserConfig, 0) : cast(next, type2, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r8 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r8.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return r8;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig, 0);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() != 0 && !"null".equals(obj2)) {
            return new BigDecimal(obj2);
        }
        return null;
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() != 0 && !"null".equals(obj2)) {
            return new BigInteger(obj2);
        }
        return null;
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        boolean z = false;
        if (obj instanceof BigDecimal) {
            if (((BigDecimal) obj).intValueExact() == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (obj instanceof Number) {
            if (((Number) obj).intValue() == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                    return Boolean.FALSE;
                }
            }
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to int, value : ", obj));
        }
    }

    public static final Byte castToByte(Object obj) {
        byte parseByte;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseByte = ((Number) obj).byteValue();
        } else if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to byte, value : ", obj));
        } else {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            parseByte = Byte.parseByte(str);
        }
        return Byte.valueOf(parseByte);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to int, value : ", obj));
        }
        String str = (String) obj;
        return JSONLexer.decodeFast(str, 0, str.length());
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to byte, value : ", obj));
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() != 1) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to byte, value : ", obj));
        }
        return Character.valueOf(str.charAt(0));
    }

    public static final Date castToDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j = -1;
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int scale = bigDecimal.scale();
            j = (scale < -100 || scale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
        } else if (obj instanceof Number) {
            j = ((Number) obj).longValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.indexOf(45) != -1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str.length() == JSON.DEFFAULT_DATE_FORMAT.length() ? JSON.DEFFAULT_DATE_FORMAT : str.length() == 10 ? "yyyy-MM-dd" : str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : (str.length() == 29 && str.charAt(26) == ':' && str.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS", JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException unused) {
                    throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to Date, value : ", str));
                }
            } else if (str.length() == 0 || "null".equals(str)) {
                return null;
            } else {
                j = Long.parseLong(str);
            }
        }
        if (j < 0) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to Date, value : ", obj));
        }
        return new Date(j);
    }

    public static final Double castToDouble(Object obj) {
        double parseDouble;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseDouble = ((Number) obj).doubleValue();
        } else if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to double, value : ", obj));
        } else {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            parseDouble = Double.parseDouble(obj2);
        }
        return Double.valueOf(parseDouble);
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() != 0) {
                    return (T) Enum.valueOf(cls, str);
                }
                return null;
            }
            if ((obj instanceof Integer) || (obj instanceof Long)) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to : ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to : ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e);
        }
    }

    public static final Float castToFloat(Object obj) {
        float parseFloat;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseFloat = ((Number) obj).floatValue();
        } else if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to float, value : ", obj));
        } else {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            parseFloat = Float.parseFloat(obj2);
        }
        return Float.valueOf(parseFloat);
    }

    public static final Integer castToInt(Object obj) {
        int parseInt;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int scale = bigDecimal.scale();
            parseInt = (scale < -100 || scale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
        } else if (obj instanceof Number) {
            parseInt = ((Number) obj).intValue();
        } else if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to int, value : ", obj));
        } else {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            parseInt = Integer.parseInt(str);
        }
        return Integer.valueOf(parseInt);
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class<Object>) cls, ParserConfig.global);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        return (T) castToJavaBean(map, cls, parserConfig, 0);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig, int i) {
        int i2 = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i2 = number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, i2);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            JavaBeanDeserializer javaBeanDeserializer = null;
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> checkAutoType = parserConfig.checkAutoType(str4, null, i);
                if (checkAutoType == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                } else if (!checkAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, checkAutoType, parserConfig, i);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject(map);
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                return parserConfig.getDeserializer(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            } else if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            } else {
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                if (deserializer instanceof JavaBeanDeserializer) {
                    javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                }
                if (javaBeanDeserializer == null) {
                    throw new JSONException("can not get javaBeanDeserializer");
                }
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public static final Long castToLong(Object obj) {
        long timeInMillis;
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int scale = bigDecimal.scale();
            timeInMillis = (scale < -100 || scale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
        } else if (!(obj instanceof Number)) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException unused) {
                    JSONLexer jSONLexer = new JSONLexer(str);
                    if (jSONLexer.scanISO8601DateIfMatch(false)) {
                        calendar = jSONLexer.calendar;
                    }
                    jSONLexer.close();
                    if (calendar != null) {
                        timeInMillis = calendar.getTimeInMillis();
                    }
                }
            }
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to long, value : ", obj));
        } else {
            timeInMillis = ((Number) obj).longValue();
        }
        return Long.valueOf(timeInMillis);
    }

    public static final Short castToShort(Object obj) {
        short parseShort;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseShort = ((Number) obj).shortValue();
        } else if (!(obj instanceof String)) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("can not cast to short, value : ", obj));
        } else {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            parseShort = Short.parseShort(str);
        }
        return Short.valueOf(parseShort);
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        StringBuilder sb;
        String str;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str2 = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str2);
        }
        if (genericComponentType instanceof Class) {
            Class cls = (Class) genericComponentType;
            if (!cls.isPrimitive()) {
                return genericArrayType;
            }
            try {
                if (cls == Boolean.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "Z";
                } else if (cls == Character.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "C";
                } else if (cls == Byte.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "B";
                } else if (cls == Short.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = ExifInterface.LATITUDE_SOUTH;
                } else if (cls == Integer.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = OptRuntime.GeneratorState.resumptionPoint_TYPE;
                } else if (cls == Long.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "J";
                } else if (cls == Float.TYPE) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "F";
                } else if (cls != Double.TYPE) {
                    return genericArrayType;
                } else {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "D";
                }
                sb.append(str);
                return Class.forName(sb.toString());
            } catch (ClassNotFoundException unused) {
                return genericArrayType;
            }
        }
        return genericArrayType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:175:0x0429, code lost:
        if (r0 == null) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x02ad, code lost:
        if (java.lang.Character.isUpperCase(r5.charAt(4)) != false) goto L123;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05d8  */
    /* JADX WARN: Type inference failed for: r18v15, types: [java.lang.annotation.Annotation[][]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<FieldInfo> computeGetters(Class<?> cls, int i, boolean z, JSONType jSONType, Map<String, String> map, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        String[] strArr;
        boolean z5;
        boolean z6;
        int i2;
        int i3;
        Iterator it;
        LinkedHashMap linkedHashMap;
        Field[] declaredFields;
        String[] strArr2;
        Field[] fieldArr;
        Constructor<?>[] constructorArr;
        JSONField[][] jSONFieldArr;
        JSONField jSONField;
        String[] strArr3;
        short[] sArr;
        HashMap hashMap;
        Class<? super Object> cls2;
        Field[] fieldArr2;
        int i4;
        int i5;
        String str;
        Method method;
        HashMap hashMap2;
        Field[] fieldArr3;
        int i6;
        int i7;
        Map<String, String> map2;
        LinkedHashMap linkedHashMap2;
        Field[] fieldArr4;
        String substring;
        PropertyNamingStrategy propertyNamingStrategy2;
        int i8;
        int i9;
        JSONField jSONField2;
        String substring2;
        int i10;
        int i11;
        JSONField jSONField3;
        boolean z7;
        JSONField jSONField4;
        String[] strArr4;
        Constructor<?>[] constructorArr2;
        String[] strArr5;
        JSONField[] jSONFieldArr2;
        Method[] methodArr;
        Class<?> cls3 = cls;
        int i12 = i;
        JSONType jSONType2 = jSONType;
        Map<String, String> map3 = map;
        PropertyNamingStrategy propertyNamingStrategy3 = propertyNamingStrategy;
        Class<? super Object> cls4 = Object.class;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        HashMap hashMap3 = new HashMap();
        Field[] declaredFields2 = cls.getDeclaredFields();
        if (!z) {
            boolean isKotlin = isKotlin(cls);
            ArrayList arrayList = new ArrayList();
            for (Class<? super Object> cls5 = cls3; cls5 != null && cls5 != cls4; cls5 = cls5.getSuperclass()) {
                Method[] declaredMethods = cls5.getDeclaredMethods();
                int length = declaredMethods.length;
                int i13 = 0;
                while (i13 < length) {
                    Method method2 = declaredMethods[i13];
                    int modifiers = method2.getModifiers();
                    if ((modifiers & 8) == 0 && (modifiers & 2) == 0) {
                        methodArr = declaredMethods;
                        if ((modifiers & 256) == 0 && (modifiers & 4) == 0 && !method2.getReturnType().equals(Void.TYPE) && method2.getParameterTypes().length == 0 && method2.getReturnType() != ClassLoader.class && method2.getDeclaringClass() != cls4) {
                            arrayList.add(method2);
                        }
                    } else {
                        methodArr = declaredMethods;
                    }
                    i13++;
                    declaredMethods = methodArr;
                }
            }
            Iterator it2 = arrayList.iterator();
            Constructor<?>[] constructorArr3 = null;
            String[] strArr6 = null;
            short[] sArr2 = null;
            JSONField[][] jSONFieldArr3 = null;
            while (it2.hasNext()) {
                Method method3 = (Method) it2.next();
                String name = method3.getName();
                if (name.equals("getMetaClass")) {
                    strArr2 = strArr6;
                    if (method3.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                        strArr6 = strArr2;
                    }
                } else {
                    strArr2 = strArr6;
                }
                JSONField jSONField5 = z3 ? (JSONField) method3.getAnnotation(JSONField.class) : null;
                if (jSONField5 == null && z3) {
                    jSONField5 = getSupperMethodAnnotation(cls3, method3);
                }
                if (!isKotlin || !isKotlinIgnore(cls3, name)) {
                    Class<? super Object> cls6 = cls4;
                    if (jSONField5 != null || !isKotlin) {
                        fieldArr = declaredFields2;
                        constructorArr = constructorArr3;
                        jSONFieldArr = jSONFieldArr3;
                        jSONField = jSONField5;
                        strArr3 = strArr2;
                    } else {
                        if (constructorArr3 == null) {
                            constructorArr3 = cls.getDeclaredConstructors();
                            JSONField[][] jSONFieldArr4 = jSONFieldArr3;
                            if (constructorArr3.length == 1) {
                                ?? parameterAnnotations = constructorArr3[0].getParameterAnnotations();
                                String[] koltinConstructorParameters = getKoltinConstructorParameters(cls);
                                if (koltinConstructorParameters != null) {
                                    String[] strArr7 = new String[koltinConstructorParameters.length];
                                    System.arraycopy(koltinConstructorParameters, 0, strArr7, 0, koltinConstructorParameters.length);
                                    Arrays.sort(strArr7);
                                    short[] sArr3 = new short[koltinConstructorParameters.length];
                                    jSONField4 = jSONField5;
                                    for (short s = 0; s < koltinConstructorParameters.length; s = (short) (s + 1)) {
                                        sArr3[Arrays.binarySearch(strArr7, koltinConstructorParameters[s])] = s;
                                    }
                                    strArr4 = strArr7;
                                    jSONFieldArr3 = parameterAnnotations;
                                    sArr2 = sArr3;
                                    constructorArr3 = constructorArr3;
                                } else {
                                    jSONField4 = jSONField5;
                                    strArr4 = koltinConstructorParameters;
                                    jSONFieldArr3 = parameterAnnotations;
                                }
                            } else {
                                jSONField4 = jSONField5;
                                strArr4 = strArr2;
                                jSONFieldArr3 = jSONFieldArr4;
                            }
                        } else {
                            jSONField4 = jSONField5;
                            strArr4 = strArr2;
                        }
                        if (strArr4 == null || sArr2 == null || !name.startsWith("get")) {
                            constructorArr2 = constructorArr3;
                            strArr5 = strArr4;
                            fieldArr = declaredFields2;
                        } else {
                            String decapitalize = decapitalize(name.substring(3));
                            int binarySearch = Arrays.binarySearch(strArr4, decapitalize);
                            constructorArr2 = constructorArr3;
                            fieldArr = declaredFields2;
                            if (binarySearch < 0) {
                                int i14 = 0;
                                while (true) {
                                    if (i14 >= strArr4.length) {
                                        break;
                                    } else if (decapitalize.equalsIgnoreCase(strArr4[i14])) {
                                        binarySearch = i14;
                                        break;
                                    } else {
                                        i14++;
                                    }
                                }
                            }
                            if (binarySearch >= 0 && (jSONFieldArr2 = jSONFieldArr3[sArr2[binarySearch]]) != null) {
                                int length2 = jSONFieldArr2.length;
                                int i15 = 0;
                                while (i15 < length2) {
                                    String[] strArr8 = strArr4;
                                    JSONField jSONField6 = jSONFieldArr2[i15];
                                    JSONField[] jSONFieldArr5 = jSONFieldArr2;
                                    if (jSONField6 instanceof JSONField) {
                                        jSONField = jSONField6;
                                        sArr = sArr2;
                                        jSONFieldArr = jSONFieldArr3;
                                        strArr3 = strArr8;
                                        constructorArr = constructorArr2;
                                        break;
                                    }
                                    i15++;
                                    strArr4 = strArr8;
                                    jSONFieldArr2 = jSONFieldArr5;
                                }
                            }
                            strArr5 = strArr4;
                        }
                        jSONFieldArr = jSONFieldArr3;
                        strArr3 = strArr5;
                        jSONField = jSONField4;
                        constructorArr = constructorArr2;
                    }
                    sArr = sArr2;
                    if (jSONField != null) {
                        if (jSONField.serialize()) {
                            i4 = jSONField.ordinal();
                            i5 = SerializerFeature.m4193of(jSONField.serialzeFeatures());
                            if (jSONField.name().length() != 0) {
                                String name2 = jSONField.name();
                                if (map3 == null || (name2 = map3.get(name2)) != null) {
                                    String str2 = name2;
                                    setAccessible(cls3, method3, i12);
                                    fieldArr2 = fieldArr;
                                    hashMap = hashMap3;
                                    cls2 = cls6;
                                    linkedHashMap3 = linkedHashMap3;
                                    linkedHashMap3.put(str2, new FieldInfo(str2, method3, null, cls, null, i4, i5, jSONField, null, true));
                                    i7 = i;
                                    linkedHashMap2 = linkedHashMap3;
                                    hashMap2 = hashMap;
                                    map2 = map3;
                                    fieldArr4 = fieldArr2;
                                    cls3 = cls;
                                    linkedHashMap3 = linkedHashMap2;
                                    i12 = i7;
                                    declaredFields2 = fieldArr4;
                                    map3 = map2;
                                    constructorArr3 = constructorArr;
                                    strArr6 = strArr3;
                                    sArr2 = sArr;
                                    jSONFieldArr3 = jSONFieldArr;
                                    cls4 = cls2;
                                    hashMap3 = hashMap2;
                                    jSONType2 = jSONType;
                                    propertyNamingStrategy3 = propertyNamingStrategy;
                                }
                            } else {
                                hashMap = hashMap3;
                                cls2 = cls6;
                                fieldArr2 = fieldArr;
                            }
                        }
                        hashMap2 = hashMap3;
                        linkedHashMap2 = linkedHashMap3;
                        i7 = i12;
                        map2 = map3;
                        cls2 = cls6;
                        fieldArr4 = fieldArr;
                        cls3 = cls;
                        linkedHashMap3 = linkedHashMap2;
                        i12 = i7;
                        declaredFields2 = fieldArr4;
                        map3 = map2;
                        constructorArr3 = constructorArr;
                        strArr6 = strArr3;
                        sArr2 = sArr;
                        jSONFieldArr3 = jSONFieldArr;
                        cls4 = cls2;
                        hashMap3 = hashMap2;
                        jSONType2 = jSONType;
                        propertyNamingStrategy3 = propertyNamingStrategy;
                    } else {
                        hashMap = hashMap3;
                        cls2 = cls6;
                        fieldArr2 = fieldArr;
                        i4 = 0;
                        i5 = 0;
                    }
                    if (name.startsWith("get")) {
                        if (name.length() >= 4) {
                            if (!name.equals("getClass")) {
                                char charAt = name.charAt(3);
                                if (Character.isUpperCase(charAt)) {
                                    if (!compatibleWithJavaBean) {
                                        substring2 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                                        if (!isJSONTypeIgnore(cls3, jSONType2, substring2)) {
                                            Field[] fieldArr5 = fieldArr2;
                                            Field field = getField(cls3, substring2, fieldArr5, hashMap);
                                            if (field != null) {
                                                JSONField jSONField7 = z3 ? (JSONField) field.getAnnotation(JSONField.class) : null;
                                                if (jSONField7 != null) {
                                                    if (jSONField7.serialize()) {
                                                        i4 = jSONField7.ordinal();
                                                        i5 = SerializerFeature.m4193of(jSONField7.serialzeFeatures());
                                                        if (jSONField7.name().length() != 0) {
                                                            substring2 = jSONField7.name();
                                                            if (map3 == null || (substring2 = map3.get(substring2)) != null) {
                                                                i10 = i4;
                                                                i11 = i5;
                                                                jSONField3 = jSONField7;
                                                                z7 = true;
                                                                if (propertyNamingStrategy3 != null && !z7) {
                                                                    substring2 = propertyNamingStrategy3.translate(substring2);
                                                                }
                                                                if (map3 != null || (substring2 = map3.get(substring2)) != null) {
                                                                    HashMap hashMap4 = hashMap;
                                                                    String str3 = substring2;
                                                                    setAccessible(cls3, method3, i);
                                                                    fieldArr3 = fieldArr5;
                                                                    hashMap2 = hashMap4;
                                                                    str = name;
                                                                    method = method3;
                                                                    i6 = 3;
                                                                    linkedHashMap3 = linkedHashMap3;
                                                                    linkedHashMap3.put(str3, new FieldInfo(str3, method3, field, cls, null, i10, i11, jSONField, jSONField3, z4));
                                                                    i4 = i10;
                                                                    i5 = i11;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    i7 = i;
                                                    linkedHashMap2 = linkedHashMap3;
                                                    hashMap2 = hashMap;
                                                    map2 = map3;
                                                    fieldArr4 = fieldArr5;
                                                    cls3 = cls;
                                                    linkedHashMap3 = linkedHashMap2;
                                                    i12 = i7;
                                                    declaredFields2 = fieldArr4;
                                                    map3 = map2;
                                                    constructorArr3 = constructorArr;
                                                    strArr6 = strArr3;
                                                    sArr2 = sArr;
                                                    jSONFieldArr3 = jSONFieldArr;
                                                    cls4 = cls2;
                                                    hashMap3 = hashMap2;
                                                    jSONType2 = jSONType;
                                                    propertyNamingStrategy3 = propertyNamingStrategy;
                                                }
                                                i10 = i4;
                                                i11 = i5;
                                                jSONField3 = jSONField7;
                                            } else {
                                                i10 = i4;
                                                i11 = i5;
                                                jSONField3 = null;
                                            }
                                            z7 = false;
                                            if (propertyNamingStrategy3 != null) {
                                                substring2 = propertyNamingStrategy3.translate(substring2);
                                            }
                                            if (map3 != null) {
                                            }
                                            HashMap hashMap42 = hashMap;
                                            String str32 = substring2;
                                            setAccessible(cls3, method3, i);
                                            fieldArr3 = fieldArr5;
                                            hashMap2 = hashMap42;
                                            str = name;
                                            method = method3;
                                            i6 = 3;
                                            linkedHashMap3 = linkedHashMap3;
                                            linkedHashMap3.put(str32, new FieldInfo(str32, method3, field, cls, null, i10, i11, jSONField, jSONField3, z4));
                                            i4 = i10;
                                            i5 = i11;
                                        }
                                    }
                                    substring2 = decapitalize(name.substring(3));
                                    if (!isJSONTypeIgnore(cls3, jSONType2, substring2)) {
                                    }
                                } else {
                                    if (charAt == '_') {
                                        substring2 = name.substring(4);
                                    } else if (charAt == 'f') {
                                        substring2 = name.substring(3);
                                    } else if (name.length() >= 5) {
                                    }
                                    if (!isJSONTypeIgnore(cls3, jSONType2, substring2)) {
                                    }
                                }
                            }
                            i7 = i;
                            linkedHashMap2 = linkedHashMap3;
                            hashMap2 = hashMap;
                            map2 = map3;
                            fieldArr4 = fieldArr2;
                            cls3 = cls;
                            linkedHashMap3 = linkedHashMap2;
                            i12 = i7;
                            declaredFields2 = fieldArr4;
                            map3 = map2;
                            constructorArr3 = constructorArr;
                            strArr6 = strArr3;
                            sArr2 = sArr;
                            jSONFieldArr3 = jSONFieldArr;
                            cls4 = cls2;
                            hashMap3 = hashMap2;
                            jSONType2 = jSONType;
                            propertyNamingStrategy3 = propertyNamingStrategy;
                        }
                        i7 = i;
                        map2 = map;
                        linkedHashMap2 = linkedHashMap3;
                        hashMap2 = hashMap;
                        fieldArr4 = fieldArr2;
                        cls3 = cls;
                        linkedHashMap3 = linkedHashMap2;
                        i12 = i7;
                        declaredFields2 = fieldArr4;
                        map3 = map2;
                        constructorArr3 = constructorArr;
                        strArr6 = strArr3;
                        sArr2 = sArr;
                        jSONFieldArr3 = jSONFieldArr;
                        cls4 = cls2;
                        hashMap3 = hashMap2;
                        jSONType2 = jSONType;
                        propertyNamingStrategy3 = propertyNamingStrategy;
                    } else {
                        str = name;
                        method = method3;
                        hashMap2 = hashMap;
                        fieldArr3 = fieldArr2;
                        i6 = 3;
                    }
                    if (str.startsWith(C1543ak.f2994ae) && str.length() >= i6) {
                        char charAt2 = str.charAt(2);
                        if (Character.isUpperCase(charAt2)) {
                            substring = compatibleWithJavaBean ? decapitalize(str.substring(2)) : Character.toLowerCase(str.charAt(2)) + str.substring(i6);
                        } else if (charAt2 == '_') {
                            substring = str.substring(i6);
                        } else if (charAt2 == 'f') {
                            substring = str.substring(2);
                        }
                        if (!isJSONTypeIgnore(cls3, jSONType2, substring)) {
                            fieldArr4 = fieldArr3;
                            HashMap hashMap5 = hashMap2;
                            Field field2 = getField(cls3, substring, fieldArr4, hashMap5);
                            if (field2 == null) {
                                field2 = getField(cls3, str, fieldArr4, hashMap5);
                            }
                            Field field3 = field2;
                            if (field3 != null) {
                                JSONField jSONField8 = z3 ? (JSONField) field3.getAnnotation(JSONField.class) : null;
                                if (jSONField8 == null) {
                                    map2 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    i8 = i4;
                                    i9 = i5;
                                    jSONField2 = jSONField8;
                                } else if (!jSONField8.serialize()) {
                                    i7 = i;
                                    map2 = map;
                                    linkedHashMap2 = linkedHashMap3;
                                    hashMap2 = hashMap5;
                                    cls3 = cls;
                                    linkedHashMap3 = linkedHashMap2;
                                    i12 = i7;
                                    declaredFields2 = fieldArr4;
                                    map3 = map2;
                                    constructorArr3 = constructorArr;
                                    strArr6 = strArr3;
                                    sArr2 = sArr;
                                    jSONFieldArr3 = jSONFieldArr;
                                    cls4 = cls2;
                                    hashMap3 = hashMap2;
                                    jSONType2 = jSONType;
                                    propertyNamingStrategy3 = propertyNamingStrategy;
                                } else {
                                    int ordinal = jSONField8.ordinal();
                                    int m4193of = SerializerFeature.m4193of(jSONField8.serialzeFeatures());
                                    if (jSONField8.name().length() != 0) {
                                        substring = jSONField8.name();
                                        map2 = map;
                                        if (map2 != null) {
                                            substring = map2.get(substring);
                                        }
                                    } else {
                                        map2 = map;
                                    }
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    jSONField2 = jSONField8;
                                    i8 = ordinal;
                                    i9 = m4193of;
                                }
                            } else {
                                map2 = map;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                i8 = i4;
                                i9 = i5;
                                jSONField2 = null;
                            }
                            if (propertyNamingStrategy2 != null) {
                                substring = propertyNamingStrategy2.translate(substring);
                            }
                            if (map2 == null || (substring = map2.get(substring)) != null) {
                                String str4 = substring;
                                setAccessible(cls3, field3, i);
                                Method method4 = method;
                                setAccessible(cls3, method4, i);
                                hashMap2 = hashMap5;
                                i7 = i;
                                linkedHashMap2 = linkedHashMap3;
                                linkedHashMap2.put(str4, new FieldInfo(str4, method4, field3, cls, null, i8, i9, jSONField, jSONField2, z4));
                                cls3 = cls;
                                linkedHashMap3 = linkedHashMap2;
                                i12 = i7;
                                declaredFields2 = fieldArr4;
                                map3 = map2;
                                constructorArr3 = constructorArr;
                                strArr6 = strArr3;
                                sArr2 = sArr;
                                jSONFieldArr3 = jSONFieldArr;
                                cls4 = cls2;
                                hashMap3 = hashMap2;
                                jSONType2 = jSONType;
                                propertyNamingStrategy3 = propertyNamingStrategy;
                            }
                            i7 = i;
                            linkedHashMap2 = linkedHashMap3;
                            hashMap2 = hashMap5;
                            cls3 = cls;
                            linkedHashMap3 = linkedHashMap2;
                            i12 = i7;
                            declaredFields2 = fieldArr4;
                            map3 = map2;
                            constructorArr3 = constructorArr;
                            strArr6 = strArr3;
                            sArr2 = sArr;
                            jSONFieldArr3 = jSONFieldArr;
                            cls4 = cls2;
                            hashMap3 = hashMap2;
                            jSONType2 = jSONType;
                            propertyNamingStrategy3 = propertyNamingStrategy;
                        }
                    }
                    i7 = i;
                    map2 = map;
                    linkedHashMap2 = linkedHashMap3;
                    fieldArr4 = fieldArr3;
                    cls3 = cls;
                    linkedHashMap3 = linkedHashMap2;
                    i12 = i7;
                    declaredFields2 = fieldArr4;
                    map3 = map2;
                    constructorArr3 = constructorArr;
                    strArr6 = strArr3;
                    sArr2 = sArr;
                    jSONFieldArr3 = jSONFieldArr;
                    cls4 = cls2;
                    hashMap3 = hashMap2;
                    jSONType2 = jSONType;
                    propertyNamingStrategy3 = propertyNamingStrategy;
                } else {
                    strArr6 = strArr2;
                }
            }
        }
        Class<? super Object> cls7 = cls4;
        int i16 = i12;
        Map<String, String> map4 = map3;
        Field[] fieldArr6 = declaredFields2;
        LinkedHashMap linkedHashMap4 = linkedHashMap3;
        ArrayList arrayList2 = new ArrayList(fieldArr6.length);
        for (Field field4 : fieldArr6) {
            if ((field4.getModifiers() & 8) == 0 && !field4.getName().equals("this$0") && (field4.getModifiers() & 1) != 0) {
                arrayList2.add(field4);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls8 = cls7;
            if (superclass == cls8) {
                break;
            }
            for (Field field5 : superclass.getDeclaredFields()) {
                if ((field5.getModifiers() & 8) == 0 && (field5.getModifiers() & 1) != 0) {
                    arrayList2.add(field5);
                }
            }
            superclass = superclass.getSuperclass();
            cls7 = cls8;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Field field6 = (Field) it3.next();
            JSONField jSONField9 = z3 ? (JSONField) field6.getAnnotation(JSONField.class) : null;
            String name3 = field6.getName();
            if (jSONField9 == null) {
                i2 = 0;
                i3 = 0;
            } else if (jSONField9.serialize()) {
                int ordinal2 = jSONField9.ordinal();
                int m4193of2 = SerializerFeature.m4193of(jSONField9.serialzeFeatures());
                if (jSONField9.name().length() != 0) {
                    name3 = jSONField9.name();
                }
                i2 = ordinal2;
                i3 = m4193of2;
            }
            if (map4 == null || (name3 = map4.get(name3)) != null) {
                if (propertyNamingStrategy != null) {
                    name3 = propertyNamingStrategy.translate(name3);
                }
                String str5 = name3;
                if (!linkedHashMap4.containsKey(str5)) {
                    setAccessible(cls, field6, i16);
                    it = it3;
                    linkedHashMap = linkedHashMap4;
                    linkedHashMap.put(str5, new FieldInfo(str5, null, field6, cls, null, i2, i3, null, jSONField9, z4));
                } else {
                    it = it3;
                    linkedHashMap = linkedHashMap4;
                }
                linkedHashMap4 = linkedHashMap;
                it3 = it;
            }
        }
        LinkedHashMap linkedHashMap5 = linkedHashMap4;
        ArrayList arrayList3 = new ArrayList();
        if (jSONType != null) {
            strArr = jSONType.orders();
            if (strArr != null && strArr.length == linkedHashMap5.size()) {
                int length3 = strArr.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length3) {
                        z6 = true;
                        break;
                    } else if (!linkedHashMap5.containsKey(strArr[i17])) {
                        z6 = false;
                        break;
                    } else {
                        i17++;
                    }
                }
                z5 = z6;
                if (!z5) {
                    for (String str6 : strArr) {
                        arrayList3.add((FieldInfo) linkedHashMap5.get(str6));
                    }
                } else {
                    for (FieldInfo fieldInfo : linkedHashMap5.values()) {
                        arrayList3.add(fieldInfo);
                    }
                    if (z2) {
                        Collections.sort(arrayList3);
                    }
                }
                return arrayList3;
            }
        } else {
            strArr = null;
        }
        z5 = false;
        if (!z5) {
        }
        return arrayList3;
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        return cls == Float.TYPE ? Float.valueOf(0.0f) : cls == Double.TYPE ? Double.valueOf((double) RoundRectDrawableWithShadow.COS_45) : cls == Boolean.TYPE ? Boolean.FALSE : cls == Character.TYPE ? '0' : null;
    }

    public static long fnv_64_lower(String str) {
        if (str == null) {
            return 0L;
        }
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_' && charAt != '-') {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + TokenParser.f4579SP);
                }
                j = (j ^ charAt) * 1099511628211L;
            }
        }
        return j;
    }

    public static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? getClass(upperBounds[0]) : Object.class;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        return getField(cls, str, fieldArr, null);
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field field0 = getField0(cls, str, fieldArr, map);
        if (field0 == null) {
            field0 = getField0(cls, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_", str), fieldArr, map);
        }
        if (field0 == null) {
            field0 = getField0(cls, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("m_", str), fieldArr, map);
        }
        if (field0 == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("m");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.substring(0, 1).toUpperCase());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.substring(1));
            return getField0(cls, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), fieldArr, map);
        }
        return field0;
    }

    public static Field getField0(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        Field[] fieldArr2 = null;
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        if (map != null) {
            fieldArr2 = map.get(superclass);
        }
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return getField(superclass, str, fieldArr2, map);
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                Class<?> cls2 = Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                kotlin_kclass_constructor = cls2.getConstructor(Class.class);
                kotlin_kclass_getConstructors = cls2.getMethod("getConstructors", new Class[0]);
                kotlin_kfunction_getParameters = Class.forName("me.tvspark.kj0").getMethod("getParameters", new Class[0]);
                kotlin_kparameter_getName = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor != null && !kotlin_error) {
            try {
                Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
                Object obj = null;
                while (it.hasNext()) {
                    Object next = it.next();
                    List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                    if (obj == null || list.size() != 0) {
                        obj = next;
                    }
                    it.hasNext();
                }
                List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
                String[] strArr = new String[list2.size()];
                for (int i = 0; i < list2.size(); i++) {
                    strArr[i] = (String) kotlin_kparameter_getName.invoke(list2.get(i), new Object[0]);
                }
                return strArr;
            } catch (Throwable unused2) {
                kotlin_error = true;
                return null;
            }
        }
        return null;
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        Method[] methods;
        boolean z;
        JSONField jSONField;
        Method[] methods2;
        boolean z2;
        JSONField jSONField2;
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z2 = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && isGenericParamType(genericSuperclass);
    }

    public static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (jSONType != null && jSONType.ignores() != null) {
            for (String str2 : jSONType.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Class.forName("me.tvspark.ef0");
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    public static boolean isKotlinIgnore(Class cls, String str) {
        String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("me.tvspark.wi0"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("me.tvspark.bj0"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("me.tvspark.ej0"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("me.tvspark.yi0"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("me.tvspark.xi0"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        return (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() >= 256) {
            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("className too long. ", str));
        }
        Class<?> cls = mappings.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            Class<?> loadClass = loadClass(str.substring(1), classLoader, false);
            if (loadClass != null) {
                return Array.newInstance(loadClass, 0).getClass();
            }
            return null;
        } else if (str.startsWith("L") && str.endsWith(";")) {
            return loadClass(str.substring(1, str.length() - 1), classLoader, false);
        } else {
            if (classLoader != null) {
                try {
                    cls = classLoader.loadClass(str);
                    if (z) {
                        mappings.put(str, cls);
                    }
                    return cls;
                } catch (Exception unused) {
                }
            }
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null && contextClassLoader != classLoader) {
                    cls = contextClassLoader.loadClass(str);
                    if (z) {
                        mappings.put(str, cls);
                    }
                    return cls;
                }
            } catch (Exception unused2) {
            }
            try {
                cls = Class.forName(str);
                mappings.put(str, cls);
                return cls;
            } catch (Exception unused3) {
                return cls;
            }
        }
    }

    public static double parseDouble(String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Double.parseDouble(str);
            } else {
                j = (j * 10) + (charAt - '0');
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                d = j;
                d2 = 10.0d;
                break;
            case 2:
                d = j;
                d2 = 100.0d;
                break;
            case 3:
                d = j;
                d2 = 1000.0d;
                break;
            case 4:
                d = j;
                d2 = 10000.0d;
                break;
            case 5:
                d = j;
                d2 = 100000.0d;
                break;
            case 6:
                d = j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = j;
                d2 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d / d2;
    }

    public static float parseFloat(String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Float.parseFloat(str);
            } else {
                j = (j * 10) + (charAt - '0');
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return (float) j;
            case 1:
                f = (float) j;
                f2 = 10.0f;
                break;
            case 2:
                f = (float) j;
                f2 = 100.0f;
                break;
            case 3:
                f = (float) j;
                f2 = 1000.0f;
                break;
            case 4:
                f = (float) j;
                f2 = 10000.0f;
                break;
            case 5:
                f = (float) j;
                f2 = 100000.0f;
                break;
            case 6:
                f = (float) j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = (float) j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = (float) j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = (float) j;
                f2 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f / f2;
    }

    public static boolean setAccessible(Class<?> cls, Member member, int i) {
        if (member != null && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }
}
