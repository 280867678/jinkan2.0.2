package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes3.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    /* JADX WARN: Removed duplicated region for block: B:28:0x009c A[Catch: all -> 0x013c, TRY_LEAVE, TryCatch #0 {all -> 0x013c, blocks: (B:9:0x0035, B:72:0x003b, B:13:0x0048, B:15:0x004c, B:17:0x0059, B:20:0x0061, B:22:0x0068, B:24:0x0074, B:25:0x0087, B:26:0x0095, B:28:0x009c, B:31:0x00a5, B:32:0x00ac, B:33:0x0077, B:36:0x0080, B:38:0x0084, B:40:0x008a, B:41:0x00ad, B:42:0x00c7, B:43:0x00c8, B:46:0x00d0, B:48:0x00dc, B:50:0x00e4, B:54:0x00f0, B:52:0x00f7, B:57:0x00fa, B:59:0x0105, B:61:0x0110, B:62:0x0113, B:64:0x011c, B:69:0x0123, B:70:0x013b), top: B:8:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[Catch: all -> 0x013c, TRY_ENTER, TryCatch #0 {all -> 0x013c, blocks: (B:9:0x0035, B:72:0x003b, B:13:0x0048, B:15:0x004c, B:17:0x0059, B:20:0x0061, B:22:0x0068, B:24:0x0074, B:25:0x0087, B:26:0x0095, B:28:0x009c, B:31:0x00a5, B:32:0x00ac, B:33:0x0077, B:36:0x0080, B:38:0x0084, B:40:0x008a, B:41:0x00ad, B:42:0x00c7, B:43:0x00c8, B:46:0x00d0, B:48:0x00dc, B:50:0x00e4, B:54:0x00f0, B:52:0x00f7, B:57:0x00fa, B:59:0x0105, B:61:0x0110, B:62:0x0113, B:64:0x011c, B:69:0x0123, B:70:0x013b), top: B:8:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        ParseContext parseContext;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        int i2 = 16;
        if (i != 12 && i != 16) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, expect {, actual ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(i));
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.config.getDeserializer(type2);
        jSONLexer.nextToken();
        ParseContext parseContext2 = defaultJSONParser.contex;
        while (true) {
            try {
                int i3 = jSONLexer.token;
                if (i3 == 13) {
                    jSONLexer.nextToken(i2);
                    return map;
                } else if (i3 != 4 || jSONLexer.f161sp != 4 || !jSONLexer.text.startsWith("$ref", jSONLexer.f160np + 1) || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    if (map.size() == 0 && i3 == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        jSONLexer.nextTokenWithChar(':');
                        jSONLexer.nextToken(16);
                        if (jSONLexer.token == 13) {
                            jSONLexer.nextToken();
                            return map;
                        }
                        jSONLexer.nextToken();
                    }
                    Object deserialze = deserializer.deserialze(defaultJSONParser, type, null);
                    if (jSONLexer.token != 17) {
                        throw new JSONException("syntax error, expect :, actual " + jSONLexer.token);
                    }
                    jSONLexer.nextToken();
                    Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkMapResolve(map, deserialze);
                    }
                    map.put(deserialze, deserialze2);
                    if (jSONLexer.token == 16) {
                        jSONLexer.nextToken();
                    }
                    i2 = 16;
                } else {
                    jSONLexer.nextTokenWithChar(':');
                    if (jSONLexer.token != 4) {
                        throw new JSONException("illegal ref, " + JSONToken.name(i3));
                    }
                    String stringVal = jSONLexer.stringVal();
                    if ("..".equals(stringVal)) {
                        parseContext = parseContext2.parent;
                    } else if (!"$".equals(stringVal)) {
                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext2, stringVal));
                        defaultJSONParser.resolveStatus = 1;
                        obj2 = null;
                        jSONLexer.nextToken(13);
                        if (jSONLexer.token == 13) {
                            throw new JSONException("illegal ref");
                        }
                        jSONLexer.nextToken(16);
                        return obj2;
                    } else {
                        parseContext = parseContext2;
                        while (parseContext.parent != null) {
                            parseContext = parseContext.parent;
                        }
                    }
                    obj2 = parseContext.object;
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token == 13) {
                    }
                }
            } finally {
                defaultJSONParser.setContext(parseContext2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0122, code lost:
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String scanSymbolUnQuoted;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token != 12) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, expect {, actual ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jSONLexer.token);
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        ParseContext parseContext = defaultJSONParser.contex;
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char c = jSONLexer.f159ch;
                if (c == ',') {
                    jSONLexer.next();
                } else {
                    if (c == '\"') {
                        scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\"');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.f159ch != ':') {
                            throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                    } else if (c == '}') {
                        jSONLexer.next();
                        jSONLexer.f161sp = 0;
                        jSONLexer.nextToken(16);
                        return map;
                    } else if (c == '\'') {
                        scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, ExtendedMessageFormat.QUOTE);
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.f159ch != ':') {
                            throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                    } else {
                        scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.symbolTable);
                        jSONLexer.skipWhitespace();
                        char c2 = jSONLexer.f159ch;
                        if (c2 != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos + ", actual " + c2);
                        }
                    }
                    jSONLexer.next();
                    jSONLexer.skipWhitespace();
                    jSONLexer.f161sp = 0;
                    Object obj2 = null;
                    if (scanSymbolUnQuoted != JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        jSONLexer.nextToken();
                        defaultJSONParser.setContext(parseContext);
                        if (jSONLexer.token == 8) {
                            jSONLexer.nextToken();
                        } else {
                            obj2 = defaultJSONParser.parseObject(type, scanSymbolUnQuoted);
                        }
                        map.put(scanSymbolUnQuoted, obj2);
                        if (defaultJSONParser.resolveStatus == 1) {
                            defaultJSONParser.checkMapResolve(map, scanSymbolUnQuoted);
                        }
                        defaultJSONParser.setContext(parseContext, obj2, scanSymbolUnQuoted);
                        int i = jSONLexer.token;
                        if (i == 20 || i == 15) {
                            break;
                        } else if (i == 13) {
                            jSONLexer.nextToken();
                            return map;
                        }
                    } else {
                        Class<?> checkAutoType = defaultJSONParser.config.checkAutoType(jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\"'), null, jSONLexer.features);
                        if (checkAutoType != map.getClass()) {
                            ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(checkAutoType);
                            jSONLexer.nextToken(16);
                            defaultJSONParser.resolveStatus = 2;
                            if (parseContext != null && !(obj instanceof Integer)) {
                                defaultJSONParser.popContext();
                            }
                            return (Map) deserializer.deserialze(defaultJSONParser, checkAutoType, obj);
                        }
                        jSONLexer.nextToken(16);
                        if (jSONLexer.token == 13) {
                            jSONLexer.nextToken(16);
                            return map;
                        }
                    }
                }
            } finally {
                defaultJSONParser.setContext(parseContext);
            }
        }
    }

    public Map<?, ?> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : createMap(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException("unsupport type " + type, e);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> createMap = createMap(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, createMap, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) defaultJSONParser.parseObject(createMap, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            return String.class == type2 ? (T) parseMap(defaultJSONParser, createMap, type3, obj) : (T) parseMap(defaultJSONParser, createMap, type2, type3, obj);
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }
}
