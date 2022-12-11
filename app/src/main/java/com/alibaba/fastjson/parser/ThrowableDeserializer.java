package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d8, code lost:
        if (r2 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00da, code lost:
        r3 = (T) new java.lang.Exception(r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0160, code lost:
        if (r13 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0162, code lost:
        ((java.lang.Throwable) r3).setStackTrace(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0165, code lost:
        if (r5 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0167, code lost:
        if (r2 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x016b, code lost:
        if (r2 != r18.clazz) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x016d, code lost:
        r7 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x017e, code lost:
        if (r7 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0180, code lost:
        r0 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x018c, code lost:
        if (r0.hasNext() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x018e, code lost:
        r2 = (java.util.Map.Entry) r0.next();
        r2 = r2.getValue();
        r4 = r7.getFieldDeserializer((java.lang.String) r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01a2, code lost:
        if (r4 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01a4, code lost:
        r4.setValue(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x016f, code lost:
        r0 = r19.config.getDeserializer(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0177, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0179, code lost:
        r7 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x017d, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01a8, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
        r4 = r2.getConstructors();
        r6 = r4.length;
        r9 = r15;
        r10 = r9;
        r14 = r10;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00eb, code lost:
        if (r7 >= r6) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ed, code lost:
        r16 = r4[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f4, code lost:
        if (r16.getParameterTypes().length != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f6, code lost:
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012b, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00fe, code lost:
        if (r16.getParameterTypes().length != 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0108, code lost:
        if (r16.getParameterTypes()[0] != java.lang.String.class) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010a, code lost:
        r10 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0113, code lost:
        if (r16.getParameterTypes().length != 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011c, code lost:
        if (r16.getParameterTypes()[0] != java.lang.String.class) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0127, code lost:
        if (r16.getParameterTypes()[1] != java.lang.Throwable.class) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0129, code lost:
        r9 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x012f, code lost:
        if (r9 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0131, code lost:
        r3 = r9.newInstance(r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013e, code lost:
        r3 = (T) ((java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0159, code lost:
        if (r3 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015b, code lost:
        r3 = (T) new java.lang.Exception(r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0141, code lost:
        if (r10 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0143, code lost:
        r3 = r10.newInstance(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014e, code lost:
        if (r14 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0150, code lost:
        r3 = r14.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0158, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b1, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00d5 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        Constructor<?> constructor;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
        } else if (i != 12) {
            throw new JSONException("syntax error");
        }
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        HashMap hashMap = null;
        Throwable th = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (scanSymbol == null) {
                int i2 = jSONLexer.token;
                if (i2 == 13) {
                    jSONLexer.nextToken(16);
                    constructor = null;
                    break;
                } else if (i2 == 16) {
                }
            }
            jSONLexer.nextTokenWithChar(':');
            if (JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (jSONLexer.token != 4) {
                    throw new JSONException("syntax error");
                }
                cls = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader, false);
                jSONLexer.nextToken(16);
            } else if ("message".equals(scanSymbol)) {
                int i3 = jSONLexer.token;
                if (i3 == 8) {
                    str = null;
                } else if (i3 != 4) {
                    throw new JSONException("syntax error");
                } else {
                    str = jSONLexer.stringVal();
                }
                jSONLexer.nextToken();
            } else {
                if ("cause".equals(scanSymbol)) {
                    constructor = null;
                    th = (Throwable) deserialze(defaultJSONParser, null, "cause");
                } else {
                    constructor = null;
                    if ("stackTrace".equals(scanSymbol)) {
                        stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class<Object>) StackTraceElement[].class);
                    } else {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(scanSymbol, defaultJSONParser.parse());
                    }
                }
                if (jSONLexer.token != 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
            constructor = null;
            if (jSONLexer.token != 13) {
            }
        }
    }
}
