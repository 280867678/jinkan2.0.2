package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import me.tvspark.outline;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = new MiscCodec();

    /* JADX WARN: Type inference failed for: r8v7, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse;
        if (type == StackTraceElement.class) {
            return (T) parseStackTraceElement(defaultJSONParser);
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            if (!"val".equals(jSONLexer.stringVal())) {
                throw new JSONException("syntax error");
            }
            jSONLexer.nextToken();
            defaultJSONParser.accept(17);
            parse = defaultJSONParser.parse();
            defaultJSONParser.accept(13);
        } else {
            parse = defaultJSONParser.parse();
        }
        if (parse == null) {
            return null;
        }
        if (!(parse instanceof String)) {
            if (parse instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) parse;
                if (type == Currency.class) {
                    String string = jSONObject.getString("currency");
                    if (string != null) {
                        return (T) Currency.getInstance(string);
                    }
                    String string2 = jSONObject.getString("currencyCode");
                    if (string2 != null) {
                        return (T) Currency.getInstance(string2);
                    }
                }
                if (type == Map.Entry.class) {
                    return (T) jSONObject.entrySet().iterator().next();
                }
            }
            throw new JSONException("except string value");
        }
        String str = (String) parse;
        if (str.length() == 0) {
            return null;
        }
        if (type == UUID.class) {
            return (T) UUID.fromString(str);
        }
        if (type == Class.class) {
            return (T) TypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader, false);
        }
        if (type == Locale.class) {
            String[] split = str.split("_");
            return split.length == 1 ? (T) new Locale(split[0]) : split.length == 2 ? (T) new Locale(split[0], split[1]) : (T) new Locale(split[0], split[1], split[2]);
        } else if (type == URI.class) {
            return (T) URI.create(str);
        } else {
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e) {
                    throw new JSONException("create url error", e);
                }
            } else if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            } else {
                if (type == Charset.class) {
                    return (T) Charset.forName(str);
                }
                if (type == Currency.class) {
                    return (T) Currency.getInstance(str);
                }
                if (type == SimpleDateFormat.class) {
                    ?? r8 = (T) new SimpleDateFormat(str, defaultJSONParser.lexer.locale);
                    r8.setTimeZone(defaultJSONParser.lexer.timeZone);
                    return r8;
                } else if (type == Character.TYPE || type == Character.class) {
                    return (T) TypeUtils.castToChar(str);
                } else {
                    if (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName())) {
                        return (T) TimeZone.getTimeZone(str);
                    }
                    try {
                        return (T) Class.forName("android.net.Uri").getMethod("parse", String.class).invoke(null, str);
                    } catch (Exception e2) {
                        throw new JSONException("parse android.net.Uri error.", e2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0142, code lost:
        r0.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x014a, code lost:
        return (T) new java.lang.StackTraceElement(r4, r6, r7, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T parseStackTraceElement(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(jSONLexer.token()));
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            int i = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (true) {
                String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                if (scanSymbol == null) {
                    if (jSONLexer.token() == 13) {
                        break;
                    } else if (jSONLexer.token() == 16) {
                        continue;
                    }
                }
                jSONLexer.nextTokenWithChar(':');
                if ("className".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str = null;
                    } else if (jSONLexer.token() != 4) {
                        throw new JSONException("syntax error");
                    } else {
                        str = jSONLexer.stringVal();
                    }
                } else if ("methodName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str2 = null;
                    } else if (jSONLexer.token() != 4) {
                        throw new JSONException("syntax error");
                    } else {
                        str2 = jSONLexer.stringVal();
                    }
                } else if ("fileName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str3 = null;
                    } else if (jSONLexer.token() != 4) {
                        throw new JSONException("syntax error");
                    } else {
                        str3 = jSONLexer.stringVal();
                    }
                } else if ("lineNumber".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        i = 0;
                    } else if (jSONLexer.token() != 2) {
                        throw new JSONException("syntax error");
                    } else {
                        i = jSONLexer.intValue();
                    }
                } else if ("nativeMethod".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8 && jSONLexer.token() != 6 && jSONLexer.token() != 7) {
                        throw new JSONException("syntax error");
                    }
                    jSONLexer.nextToken(16);
                } else if (scanSymbol != JSON.DEFAULT_TYPE_KEY) {
                    throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error : ", scanSymbol));
                } else {
                    if (jSONLexer.token() == 4) {
                        String stringVal = jSONLexer.stringVal();
                        if (!stringVal.equals("java.lang.StackTraceElement")) {
                            throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error : ", stringVal));
                        }
                    } else if (jSONLexer.token() != 8) {
                        throw new JSONException("syntax error");
                    }
                }
                if (jSONLexer.token() == 13) {
                    break;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String obj3;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                jSONSerializer.write("");
                return;
            } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Enumeration.class.isAssignableFrom(TypeUtils.getClass(type))) {
                serializeWriter.writeNull();
                return;
            } else {
                serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
        }
        if (obj instanceof Pattern) {
            obj3 = ((Pattern) obj).pattern();
        } else if (obj instanceof TimeZone) {
            obj3 = ((TimeZone) obj).getID();
        } else if (obj instanceof Currency) {
            obj3 = ((Currency) obj).getCurrencyCode();
        } else if (obj instanceof Class) {
            obj3 = ((Class) obj).getName();
        } else if (obj instanceof Character) {
            Character ch = (Character) obj;
            obj3 = ch.charValue() == 0 ? "\u0000" : ch.toString();
        } else {
            int i = 0;
            if (obj instanceof SimpleDateFormat) {
                String pattern = ((SimpleDateFormat) obj).toPattern();
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                    serializeWriter.writeString(pattern);
                    return;
                }
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeString(pattern);
                serializeWriter.write(125);
                return;
            } else if (obj instanceof JSONStreamAware) {
                ((JSONStreamAware) obj).writeJSONString(serializeWriter);
                return;
            } else if (obj instanceof JSONAware) {
                serializeWriter.write(((JSONAware) obj).toJSONString());
                return;
            } else if (obj instanceof JSONSerializable) {
                ((JSONSerializable) obj).write(jSONSerializer, obj2, type);
                return;
            } else if (obj instanceof Enumeration) {
                Type type2 = null;
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && (type instanceof ParameterizedType)) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                }
                Enumeration enumeration = (Enumeration) obj;
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj, obj2, 0);
                try {
                    serializeWriter.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object nextElement = enumeration.nextElement();
                        int i2 = i + 1;
                        if (i != 0) {
                            serializeWriter.write(44);
                        }
                        if (nextElement == null) {
                            serializeWriter.writeNull();
                        } else {
                            jSONSerializer.config.get(nextElement.getClass()).write(jSONSerializer, nextElement, Integer.valueOf(i2 - 1), type2);
                        }
                        i = i2;
                    }
                    serializeWriter.write(93);
                    return;
                } finally {
                    jSONSerializer.context = serialContext;
                }
            } else {
                obj3 = obj.toString();
            }
        }
        jSONSerializer.write(obj3);
    }
}
