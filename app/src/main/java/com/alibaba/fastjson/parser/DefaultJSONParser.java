package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes3.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    public ParseContext contex;
    public ParseContext[] contextArray;
    public int contextArrayIndex;
    public DateFormat dateFormat;
    public String dateFormatPattern;
    public List<ExtraProcessor> extraProcessors;
    public List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    public List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: classes3.dex */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        int i;
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c = jSONLexer.f159ch;
        char c2 = JSONLexer.EOI;
        if (c == '{') {
            int i2 = jSONLexer.f158bp + 1;
            jSONLexer.f158bp = i2;
            jSONLexer.f159ch = i2 < jSONLexer.len ? jSONLexer.text.charAt(i2) : c2;
            i = 12;
        } else if (c != '[') {
            jSONLexer.nextToken();
            return;
        } else {
            int i3 = jSONLexer.f158bp + 1;
            jSONLexer.f158bp = i3;
            jSONLexer.f159ch = i3 < jSONLexer.len ? jSONLexer.text.charAt(i3) : c2;
            i = 14;
        }
        jSONLexer.token = i;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(new JSONLexer(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(new JSONLexer(cArr, i, i2), parserConfig);
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i) {
            jSONLexer.nextToken();
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, expect ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(i));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", actual ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(this.lexer.token));
        throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        ResolveTask lastResolveTask;
        ResolveFieldDeserializer resolveFieldDeserializer;
        if (collection instanceof List) {
            lastResolveTask = getLastResolveTask();
            resolveFieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
        } else {
            lastResolveTask = getLastResolveTask();
            resolveFieldDeserializer = new ResolveFieldDeserializer(collection);
        }
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.lexer.token == 20) {
                return;
            }
            throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
        } finally {
            this.lexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                ParseContext parseContext = resolveTask.ownerContext;
                Object obj2 = null;
                Object obj3 = parseContext != null ? parseContext.object : null;
                String str = resolveTask.referenceValue;
                if (str.startsWith("$")) {
                    for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
                        if (str.equals(this.contextArray[i2].toString())) {
                            obj2 = this.contextArray[i2].object;
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public Object parse() {
        return parse(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object parse(Object obj) {
        Collection jSONArray;
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
        boolean z = true;
        if (i == 3) {
            if ((jSONLexer.features & Feature.UseBigDecimal.mask) == 0) {
                z = false;
            }
            Number decimalValue = this.lexer.decimalValue(z);
            this.lexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            this.lexer.nextToken(16);
            if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                try {
                    if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                        return jSONLexer2.calendar.getTime();
                    }
                } finally {
                    jSONLexer2.close();
                }
            }
            return stringVal;
        } else if (i == 12) {
            return parseObject((jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), obj);
        } else {
            if (i != 14) {
                switch (i) {
                    case 6:
                        jSONLexer.nextToken(16);
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken(16);
                        return Boolean.FALSE;
                    case 8:
                        break;
                    case 9:
                        jSONLexer.nextToken(18);
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token != 18) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.lexer.info());
                            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        jSONLexer3.nextToken(10);
                        accept(10);
                        long longValue = this.lexer.integerValue().longValue();
                        accept(2);
                        accept(11);
                        return new Date(longValue);
                    default:
                        switch (i) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.lexer.info());
                                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                            case 21:
                                jSONLexer.nextToken();
                                jSONArray = new HashSet();
                                break;
                            case 22:
                                jSONLexer.nextToken();
                                jSONArray = new TreeSet();
                                break;
                            case 23:
                                break;
                            default:
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.lexer.info());
                                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                        }
                }
                this.lexer.nextToken();
                return null;
            }
            jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONArray;
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:16:0x0045, B:53:0x004d, B:19:0x0053, B:22:0x0063, B:24:0x0068, B:25:0x008f, B:26:0x00b4, B:28:0x00ba, B:33:0x0071, B:35:0x0077, B:36:0x0083, B:40:0x008a, B:41:0x0093, B:43:0x009b, B:44:0x00a9, B:46:0x00b1, B:47:0x00a1), top: B:15:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i;
        Object obj2;
        int i2 = this.lexer.token;
        if (i2 == 21 || i2 == 22) {
            this.lexer.nextToken();
        }
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token != 14) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("exepct '[', but ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(this.lexer.token));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.lexer.info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            i = 2;
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.contex;
            if (!this.lexer.disableCircularReferenceDetect) {
                setContext(parseContext, collection, obj);
            }
            int i3 = 0;
            while (true) {
                try {
                    if (this.lexer.token != 16) {
                        this.lexer.nextToken();
                    } else if (this.lexer.token == 15) {
                        this.contex = parseContext;
                        this.lexer.nextToken(16);
                        return;
                    } else {
                        Object obj3 = null;
                        if (Integer.TYPE == type) {
                            obj2 = IntegerCodec.instance.deserialze(this, null, null);
                        } else if (String.class != type) {
                            if (this.lexer.token == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj3 = deserializer.deserialze(this, type, Integer.valueOf(i3));
                            }
                            collection.add(obj3);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                            if (this.lexer.token == 16) {
                                this.lexer.nextToken();
                            }
                            i3++;
                        } else if (this.lexer.token == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            if (parse != null) {
                                obj3 = parse.toString();
                            }
                            obj2 = obj3;
                        }
                        collection.add(obj2);
                        if (this.lexer.token == 16) {
                        }
                        i3++;
                    }
                } catch (Throwable th) {
                    this.contex = parseContext;
                    throw th;
                }
            }
        } else {
            deserializer = this.config.getDeserializer(type);
            jSONLexer = this.lexer;
            i = 12;
        }
        jSONLexer.nextToken(i);
        ParseContext parseContext2 = this.contex;
        if (!this.lexer.disableCircularReferenceDetect) {
        }
        int i32 = 0;
        while (true) {
            if (this.lexer.token != 16) {
            }
        }
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0244 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d6 A[Catch: all -> 0x024a, TryCatch #0 {all -> 0x024a, blocks: (B:11:0x0024, B:14:0x0038, B:21:0x0049, B:24:0x0063, B:28:0x0086, B:30:0x008c, B:32:0x009a, B:35:0x00b4, B:37:0x00bd, B:42:0x00c4, B:43:0x00ac, B:47:0x00cd, B:50:0x00e7, B:52:0x00f0, B:53:0x00f3, B:58:0x00df, B:45:0x00fd, B:60:0x0102, B:62:0x0108, B:84:0x0133, B:85:0x01e0, B:87:0x01e7, B:88:0x01ea, B:90:0x01f0, B:92:0x01f6, B:98:0x020c, B:102:0x021e, B:105:0x023c, B:107:0x0234, B:108:0x023f, B:112:0x0139, B:117:0x0143, B:119:0x0154, B:120:0x015b, B:121:0x015c, B:123:0x0167, B:124:0x0177, B:125:0x0172, B:126:0x0151, B:127:0x0180, B:128:0x0184, B:129:0x0189, B:130:0x018c, B:131:0x0187, B:132:0x0190, B:134:0x01a6, B:136:0x01b1, B:137:0x01b8, B:138:0x01bc, B:140:0x01c7, B:141:0x01dc, B:142:0x01ce, B:143:0x01d6, B:144:0x005b, B:145:0x006a, B:146:0x0070, B:149:0x007d), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a A[Catch: all -> 0x024a, TryCatch #0 {all -> 0x024a, blocks: (B:11:0x0024, B:14:0x0038, B:21:0x0049, B:24:0x0063, B:28:0x0086, B:30:0x008c, B:32:0x009a, B:35:0x00b4, B:37:0x00bd, B:42:0x00c4, B:43:0x00ac, B:47:0x00cd, B:50:0x00e7, B:52:0x00f0, B:53:0x00f3, B:58:0x00df, B:45:0x00fd, B:60:0x0102, B:62:0x0108, B:84:0x0133, B:85:0x01e0, B:87:0x01e7, B:88:0x01ea, B:90:0x01f0, B:92:0x01f6, B:98:0x020c, B:102:0x021e, B:105:0x023c, B:107:0x0234, B:108:0x023f, B:112:0x0139, B:117:0x0143, B:119:0x0154, B:120:0x015b, B:121:0x015c, B:123:0x0167, B:124:0x0177, B:125:0x0172, B:126:0x0151, B:127:0x0180, B:128:0x0184, B:129:0x0189, B:130:0x018c, B:131:0x0187, B:132:0x0190, B:134:0x01a6, B:136:0x01b1, B:137:0x01b8, B:138:0x01bc, B:140:0x01c7, B:141:0x01dc, B:142:0x01ce, B:143:0x01d6, B:144:0x005b, B:145:0x006a, B:146:0x0070, B:149:0x007d), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0108 A[Catch: all -> 0x024a, LOOP:1: B:60:0x0102->B:62:0x0108, LOOP_END, TryCatch #0 {all -> 0x024a, blocks: (B:11:0x0024, B:14:0x0038, B:21:0x0049, B:24:0x0063, B:28:0x0086, B:30:0x008c, B:32:0x009a, B:35:0x00b4, B:37:0x00bd, B:42:0x00c4, B:43:0x00ac, B:47:0x00cd, B:50:0x00e7, B:52:0x00f0, B:53:0x00f3, B:58:0x00df, B:45:0x00fd, B:60:0x0102, B:62:0x0108, B:84:0x0133, B:85:0x01e0, B:87:0x01e7, B:88:0x01ea, B:90:0x01f0, B:92:0x01f6, B:98:0x020c, B:102:0x021e, B:105:0x023c, B:107:0x0234, B:108:0x023f, B:112:0x0139, B:117:0x0143, B:119:0x0154, B:120:0x015b, B:121:0x015c, B:123:0x0167, B:124:0x0177, B:125:0x0172, B:126:0x0151, B:127:0x0180, B:128:0x0184, B:129:0x0189, B:130:0x018c, B:131:0x0187, B:132:0x0190, B:134:0x01a6, B:136:0x01b1, B:137:0x01b8, B:138:0x01bc, B:140:0x01c7, B:141:0x01dc, B:142:0x01ce, B:143:0x01d6, B:144:0x005b, B:145:0x006a, B:146:0x0070, B:149:0x007d), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e A[EDGE_INSN: B:63:0x010e->B:64:0x010e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e7 A[Catch: all -> 0x024a, TryCatch #0 {all -> 0x024a, blocks: (B:11:0x0024, B:14:0x0038, B:21:0x0049, B:24:0x0063, B:28:0x0086, B:30:0x008c, B:32:0x009a, B:35:0x00b4, B:37:0x00bd, B:42:0x00c4, B:43:0x00ac, B:47:0x00cd, B:50:0x00e7, B:52:0x00f0, B:53:0x00f3, B:58:0x00df, B:45:0x00fd, B:60:0x0102, B:62:0x0108, B:84:0x0133, B:85:0x01e0, B:87:0x01e7, B:88:0x01ea, B:90:0x01f0, B:92:0x01f6, B:98:0x020c, B:102:0x021e, B:105:0x023c, B:107:0x0234, B:108:0x023f, B:112:0x0139, B:117:0x0143, B:119:0x0154, B:120:0x015b, B:121:0x015c, B:123:0x0167, B:124:0x0177, B:125:0x0172, B:126:0x0151, B:127:0x0180, B:128:0x0184, B:129:0x0189, B:130:0x018c, B:131:0x0187, B:132:0x0190, B:134:0x01a6, B:136:0x01b1, B:137:0x01b8, B:138:0x01bc, B:140:0x01c7, B:141:0x01dc, B:142:0x01ce, B:143:0x01d6, B:144:0x005b, B:145:0x006a, B:146:0x0070, B:149:0x007d), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f0 A[Catch: all -> 0x024a, TryCatch #0 {all -> 0x024a, blocks: (B:11:0x0024, B:14:0x0038, B:21:0x0049, B:24:0x0063, B:28:0x0086, B:30:0x008c, B:32:0x009a, B:35:0x00b4, B:37:0x00bd, B:42:0x00c4, B:43:0x00ac, B:47:0x00cd, B:50:0x00e7, B:52:0x00f0, B:53:0x00f3, B:58:0x00df, B:45:0x00fd, B:60:0x0102, B:62:0x0108, B:84:0x0133, B:85:0x01e0, B:87:0x01e7, B:88:0x01ea, B:90:0x01f0, B:92:0x01f6, B:98:0x020c, B:102:0x021e, B:105:0x023c, B:107:0x0234, B:108:0x023f, B:112:0x0139, B:117:0x0143, B:119:0x0154, B:120:0x015b, B:121:0x015c, B:123:0x0167, B:124:0x0177, B:125:0x0172, B:126:0x0151, B:127:0x0180, B:128:0x0184, B:129:0x0189, B:130:0x018c, B:131:0x0187, B:132:0x0190, B:134:0x01a6, B:136:0x01b1, B:137:0x01b8, B:138:0x01bc, B:140:0x01c7, B:141:0x01dc, B:142:0x01ce, B:143:0x01d6, B:144:0x005b, B:145:0x006a, B:146:0x0070, B:149:0x007d), top: B:10:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void parseArray(Collection collection, Object obj) {
        boolean z;
        int i;
        int i2;
        Number integerValue;
        JSONLexer jSONLexer;
        Boolean bool;
        Boolean bool2;
        char c;
        int i3 = this.lexer.token;
        if (i3 == 21 || i3 == 22) {
            this.lexer.nextToken();
            i3 = this.lexer.token;
        }
        if (i3 != 14) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, expect [, actual ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(i3));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", pos ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.lexer.pos);
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        boolean z2 = this.lexer.disableCircularReferenceDetect;
        ParseContext parseContext = this.contex;
        if (!z2) {
            setContext(parseContext, collection, obj);
        }
        try {
            char c2 = this.lexer.f159ch;
            char c3 = ']';
            if (c2 != '\"') {
                if (c2 == ']') {
                    this.lexer.next();
                    this.lexer.nextToken(16);
                    if (z2) {
                        return;
                    }
                    return;
                } else if (c2 == '{') {
                    JSONLexer jSONLexer2 = this.lexer;
                    int i4 = jSONLexer2.f158bp + 1;
                    jSONLexer2.f158bp = i4;
                    this.lexer.f159ch = i4 >= this.lexer.len ? JSONLexer.EOI : this.lexer.text.charAt(i4);
                    this.lexer.token = 12;
                } else {
                    this.lexer.nextToken(12);
                }
            } else if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) == 0) {
                z = true;
                i = 0;
                while (true) {
                    if (z && this.lexer.f159ch == '\"') {
                        String scanStringValue = this.lexer.scanStringValue('\"');
                        c = this.lexer.f159ch;
                        if (c != ',') {
                            JSONLexer jSONLexer3 = this.lexer;
                            int i5 = jSONLexer3.f158bp + 1;
                            jSONLexer3.f158bp = i5;
                            JSONLexer jSONLexer4 = this.lexer;
                            char charAt = i5 >= this.lexer.len ? JSONLexer.EOI : this.lexer.text.charAt(i5);
                            jSONLexer4.f159ch = charAt;
                            collection.add(scanStringValue);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                            if (charAt == '\"') {
                                i++;
                                c3 = ']';
                            } else {
                                this.lexer.nextToken();
                                z = false;
                            }
                        } else if (c == c3) {
                            JSONLexer jSONLexer5 = this.lexer;
                            int i6 = jSONLexer5.f158bp + 1;
                            jSONLexer5.f158bp = i6;
                            this.lexer.f159ch = i6 >= this.lexer.len ? JSONLexer.EOI : this.lexer.text.charAt(i6);
                            collection.add(scanStringValue);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                            this.lexer.nextToken(16);
                            if (z2) {
                                return;
                            }
                            this.contex = parseContext;
                            return;
                        } else {
                            this.lexer.nextToken();
                        }
                    }
                    while (true) {
                        i2 = this.lexer.token;
                        if (i2 == 16) {
                            break;
                        }
                        this.lexer.nextToken();
                    }
                    JSONArray jSONArray = null;
                    if (i2 != 2) {
                        integerValue = this.lexer.integerValue();
                    } else if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 6) {
                                bool2 = Boolean.TRUE;
                            } else if (i2 != 7) {
                                if (i2 != 8) {
                                    if (i2 == 12) {
                                        jSONArray = parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), Integer.valueOf(i));
                                    } else if (i2 == 20) {
                                        throw new JSONException("unclosed jsonArray");
                                    } else {
                                        if (i2 != 23) {
                                            if (i2 == 14) {
                                                JSONArray jSONArray2 = new JSONArray();
                                                parseArray(jSONArray2, Integer.valueOf(i));
                                                jSONArray = jSONArray2;
                                            } else if (i2 == 15) {
                                                this.lexer.nextToken(16);
                                                if (z2) {
                                                    return;
                                                }
                                                this.contex = parseContext;
                                                return;
                                            } else {
                                                jSONArray = parse();
                                            }
                                        }
                                    }
                                }
                                this.lexer.nextToken(4);
                            } else {
                                bool2 = Boolean.FALSE;
                            }
                            jSONLexer = this.lexer;
                            bool = bool2;
                            jSONLexer.nextToken(16);
                            jSONArray = bool;
                        } else {
                            String stringVal = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                            jSONArray = stringVal;
                            if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                                JSONLexer jSONLexer6 = new JSONLexer(stringVal);
                                Date date = stringVal;
                                if (jSONLexer6.scanISO8601DateIfMatch(true)) {
                                    date = jSONLexer6.calendar.getTime();
                                }
                                jSONLexer6.close();
                                jSONArray = date;
                            }
                        }
                        collection.add(jSONArray);
                        if (this.resolveStatus == 1) {
                            checkListResolve(collection);
                        }
                        if (this.lexer.token == 16) {
                            char c4 = this.lexer.f159ch;
                            if (c4 == '\"') {
                                this.lexer.pos = this.lexer.f158bp;
                                this.lexer.scanString();
                            } else if (c4 >= '0' && c4 <= '9') {
                                this.lexer.pos = this.lexer.f158bp;
                                this.lexer.scanNumber();
                            } else if (c4 == '{') {
                                this.lexer.token = 12;
                                JSONLexer jSONLexer7 = this.lexer;
                                int i7 = jSONLexer7.f158bp + 1;
                                jSONLexer7.f158bp = i7;
                                this.lexer.f159ch = i7 >= this.lexer.len ? JSONLexer.EOI : this.lexer.text.charAt(i7);
                            } else {
                                this.lexer.nextToken();
                            }
                        }
                        i++;
                        c3 = ']';
                    } else {
                        integerValue = (this.lexer.features & Feature.UseBigDecimal.mask) != 0 ? this.lexer.decimalValue(true) : this.lexer.decimalValue(false);
                    }
                    jSONLexer = this.lexer;
                    bool = integerValue;
                    jSONLexer.nextToken(16);
                    jSONArray = bool;
                    collection.add(jSONArray);
                    if (this.resolveStatus == 1) {
                    }
                    if (this.lexer.token == 16) {
                    }
                    i++;
                    c3 = ']';
                }
            } else {
                this.lexer.nextToken(4);
            }
            z = false;
            i = 0;
            while (true) {
                if (z) {
                    String scanStringValue2 = this.lexer.scanStringValue('\"');
                    c = this.lexer.f159ch;
                    if (c != ',') {
                    }
                }
                while (true) {
                    i2 = this.lexer.token;
                    if (i2 == 16) {
                    }
                    this.lexer.nextToken();
                }
                JSONArray jSONArray3 = null;
                if (i2 != 2) {
                }
                jSONLexer = this.lexer;
                bool = integerValue;
                jSONLexer.nextToken(16);
                jSONArray3 = bool;
                collection.add(jSONArray3);
                if (this.resolveStatus == 1) {
                }
                if (this.lexer.token == 16) {
                }
                i++;
                c3 = ']';
            }
        } finally {
            if (!z2) {
                this.contex = parseContext;
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object valueOf;
        boolean z;
        Class<?> cls;
        int i;
        JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token;
        int i3 = 8;
        if (i2 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i2 != 14) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.lexer.info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                jSONLexer.nextToken(15);
                JSONLexer jSONLexer2 = this.lexer;
                if (jSONLexer2.token == 15) {
                    jSONLexer2.nextToken(16);
                    return new Object[0];
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.lexer.info());
                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
            jSONLexer.nextToken(2);
            int i4 = 0;
            while (i4 < typeArr.length) {
                JSONLexer jSONLexer3 = this.lexer;
                int i5 = jSONLexer3.token;
                if (i5 == i3) {
                    jSONLexer3.nextToken(16);
                    valueOf = null;
                } else {
                    Type type = typeArr[i4];
                    if (type == Integer.TYPE || type == Integer.class) {
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 2) {
                            valueOf = Integer.valueOf(jSONLexer4.intValue());
                            this.lexer.nextToken(16);
                        }
                        valueOf = TypeUtils.cast(parse(), type, this.config);
                    } else if (type == String.class) {
                        if (i5 == 4) {
                            valueOf = jSONLexer3.stringVal();
                            this.lexer.nextToken(16);
                        }
                        valueOf = TypeUtils.cast(parse(), type, this.config);
                    } else {
                        if (i4 != typeArr.length - 1 || !(type instanceof Class)) {
                            z = false;
                            cls = null;
                        } else {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z || this.lexer.token == 14) {
                            valueOf = this.config.getDeserializer(type).deserialze(this, type, null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    JSONLexer jSONLexer5 = this.lexer;
                                    i = jSONLexer5.token;
                                    if (i != 16) {
                                        break;
                                    }
                                    jSONLexer5.nextToken(12);
                                }
                                if (i != 15) {
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.lexer.info());
                                    throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                                }
                            }
                            valueOf = TypeUtils.cast(arrayList, type, this.config);
                        }
                    }
                }
                objArr[i4] = valueOf;
                JSONLexer jSONLexer6 = this.lexer;
                int i6 = jSONLexer6.token;
                if (i6 == 15) {
                    break;
                } else if (i6 != 16) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.lexer.info());
                    throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                } else {
                    if (i4 == typeArr.length - 1) {
                        jSONLexer6.nextToken(15);
                    } else {
                        jSONLexer6.nextToken(2);
                    }
                    i4++;
                    i3 = 8;
                }
            }
            JSONLexer jSONLexer7 = this.lexer;
            if (jSONLexer7.token == 15) {
                jSONLexer7.nextToken(16);
                return objArr;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(this.lexer.info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
        }
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class) type2, (Collection) arrayList);
            return arrayList;
        } else if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (!Object.class.equals(type3)) {
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class) type3, (Collection) arrayList2);
                return arrayList2;
            } else if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            } else {
                throw new JSONException("not support type : " + type);
            }
        } else {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length != 1) {
                    throw new JSONException("not support : " + typeVariable);
                }
                Type type4 = bounds[0];
                if (type4 instanceof Class) {
                    ArrayList arrayList3 = new ArrayList();
                    parseArray((Class) type4, (Collection) arrayList3);
                    return arrayList3;
                }
            }
            if (type2 instanceof ParameterizedType) {
                ArrayList arrayList4 = new ArrayList();
                parseArray((ParameterizedType) type2, arrayList4);
                return arrayList4;
            }
            throw new JSONException("TODO : " + type);
        }
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), (Object) null);
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) jSONLexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02c2, code lost:
        if (r7 != null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02c6, code lost:
        if (r1 != java.lang.Cloneable.class) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02c8, code lost:
        r7 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02d4, code lost:
        if ("java.util.Collections$EmptyMap".equals(r0) == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02d6, code lost:
        r7 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02db, code lost:
        r7 = r1.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02df, code lost:
        if (r10 != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02e1, code lost:
        r13.contex = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02e3, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02ec, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02ed, code lost:
        r13.resolveStatus = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02f2, code lost:
        if (r13.contex == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02f6, code lost:
        if ((r4 instanceof java.lang.Integer) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02f8, code lost:
        r14.popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02ff, code lost:
        if (r3.size() <= 0) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0301, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r2, (java.lang.Class<java.lang.Object>) r1, r13.config);
        r13.parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x030a, code lost:
        if (r10 != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x030c, code lost:
        r13.contex = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x030e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x030f, code lost:
        r0 = r13.config.getDeserializer(r1);
        r1 = r0.deserialze(r13, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x031b, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.MapDeserializer) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x031d, code lost:
        r13.resolveStatus = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0320, code lost:
        if (r10 != false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0322, code lost:
        r13.contex = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0324, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0278, code lost:
        r6.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0281, code lost:
        if (r6.token != 13) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0283, code lost:
        r6.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0286, code lost:
        r2 = r13.config.getDeserializer(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x028e, code lost:
        if ((r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0290, code lost:
        r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2;
        r7 = r2.createInstance(r13, r1);
        r3 = r3.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02a2, code lost:
        if (r3.hasNext() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02a4, code lost:
        r4 = (java.util.Map.Entry) r3.next();
        r5 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02b0, code lost:
        if ((r5 instanceof java.lang.String) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02b2, code lost:
        r5 = r2.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02b8, code lost:
        if (r5 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ba, code lost:
        r5.setValue(r7, r4.getValue());
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03aa A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b4 A[Catch: all -> 0x00a4, TRY_ENTER, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03ff A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05d4 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x05eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0664 A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0477 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0484 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0491 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0488 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x052c A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x053b A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0544 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x054d A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0556 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0548 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0228 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f3 A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:24:0x00a1, B:458:0x009b, B:29:0x00b6, B:31:0x00c2, B:35:0x00cb, B:36:0x00e9, B:40:0x01f3, B:43:0x0206, B:381:0x0222, B:58:0x022a, B:61:0x0231, B:63:0x0239, B:64:0x0242, B:66:0x0248, B:70:0x0255, B:75:0x025d, B:77:0x026b, B:81:0x0278, B:83:0x0283, B:85:0x0286, B:87:0x0290, B:88:0x029e, B:90:0x02a4, B:93:0x02b2, B:96:0x02ba, B:105:0x02c8, B:106:0x02ce, B:108:0x02d6, B:109:0x02db, B:114:0x02e5, B:115:0x02ec, B:121:0x02ed, B:123:0x02f4, B:125:0x02f8, B:126:0x02fb, B:128:0x0301, B:132:0x030f, B:134:0x031d, B:145:0x032c, B:148:0x0334, B:150:0x033b, B:152:0x034c, B:154:0x0354, B:157:0x0359, B:159:0x035d, B:161:0x03a4, B:163:0x03aa, B:167:0x03b4, B:168:0x03cc, B:169:0x0362, B:171:0x036a, B:173:0x036e, B:174:0x0371, B:175:0x0376, B:176:0x03a0, B:177:0x037a, B:180:0x0383, B:182:0x0387, B:184:0x038a, B:186:0x038e, B:187:0x0391, B:188:0x039a, B:189:0x03cd, B:190:0x03e9, B:193:0x03ee, B:198:0x03ff, B:200:0x0405, B:202:0x0411, B:203:0x0417, B:206:0x0433, B:208:0x05c1, B:212:0x05cb, B:215:0x05d4, B:218:0x05e7, B:220:0x05e1, B:224:0x05ef, B:227:0x0602, B:229:0x060b, B:232:0x061e, B:233:0x063e, B:235:0x0664, B:239:0x0618, B:242:0x0627, B:245:0x063a, B:246:0x0634, B:249:0x0645, B:252:0x0658, B:253:0x0652, B:254:0x065f, B:255:0x05fc, B:256:0x066e, B:257:0x0686, B:258:0x041d, B:263:0x042f, B:268:0x0446, B:271:0x045d, B:273:0x0466, B:277:0x0477, B:278:0x047a, B:280:0x0484, B:281:0x048b, B:291:0x0491, B:288:0x04a5, B:289:0x04bd, B:295:0x0488, B:298:0x0457, B:301:0x04c4, B:304:0x04d7, B:306:0x04e8, B:309:0x04fc, B:310:0x0502, B:313:0x050a, B:314:0x0510, B:316:0x051a, B:318:0x052c, B:321:0x0534, B:322:0x0536, B:324:0x053b, B:326:0x0544, B:328:0x054d, B:329:0x0550, B:338:0x0556, B:340:0x055d, B:334:0x056a, B:335:0x0582, B:344:0x0548, B:349:0x04f3, B:350:0x04d1, B:353:0x058b, B:355:0x0597, B:356:0x05be, B:359:0x05a7, B:361:0x05b3, B:362:0x0687, B:364:0x0696, B:365:0x069a, B:375:0x06a3, B:368:0x06af, B:371:0x06c8, B:372:0x06e0, B:388:0x0200, B:389:0x0228, B:449:0x00ee, B:452:0x00ff, B:456:0x00f9, B:394:0x0112, B:396:0x011e, B:397:0x0121, B:401:0x0127, B:402:0x013d, B:410:0x0150, B:412:0x0156, B:414:0x015b, B:416:0x0167, B:417:0x016b, B:421:0x0172, B:422:0x018c, B:423:0x0160, B:425:0x018d, B:426:0x01a7, B:434:0x01b1, B:437:0x01c2, B:439:0x01c8, B:440:0x01e6, B:441:0x01e7, B:443:0x06e1, B:444:0x06f9, B:446:0x06fa, B:447:0x0712), top: B:457:0x009b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:457:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:418:0x009b -> B:24:0x00a1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        boolean z;
        Map<String, Object> map2;
        char c;
        Map map3;
        char c2;
        DefaultJSONParser defaultJSONParser;
        DefaultJSONParser defaultJSONParser2;
        boolean z2;
        ParseContext parseContext;
        boolean z3;
        boolean z4;
        boolean z5;
        Map map4;
        JSONLexer jSONLexer;
        Object obj2;
        Object obj3;
        Map map5;
        Map map6;
        boolean z6;
        String str;
        char c3;
        char c4;
        Map map7;
        boolean z7;
        boolean z8;
        boolean z9;
        Boolean bool;
        Object obj4;
        boolean z10;
        int i;
        boolean z11;
        int i2;
        char c5;
        int i3;
        Number number;
        ResolveTask resolveTask;
        Object obj5;
        boolean z12;
        Object obj6;
        Class<?> cls;
        String str2;
        Map map8 = map;
        JSONLexer jSONLexer2 = this.lexer;
        int i4 = jSONLexer2.token;
        if (i4 == 8) {
            jSONLexer2.nextToken();
            return null;
        } else if (i4 != 12 && i4 != 16) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, expect {, actual ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(i4));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jSONLexer2.info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            if (map8 instanceof JSONObject) {
                z = true;
                map2 = ((JSONObject) map8).getInnerMap();
            } else {
                z = false;
                map2 = map8;
            }
            DefaultJSONParser defaultJSONParser3 = this;
            DefaultJSONParser defaultJSONParser4 = defaultJSONParser3;
            boolean z13 = (jSONLexer2.features & Feature.AllowISO8601DateFormat.mask) != 0;
            boolean z14 = jSONLexer2.disableCircularReferenceDetect;
            ParseContext parseContext2 = this.contex;
            boolean z15 = false;
            JSONLexer jSONLexer3 = jSONLexer2;
            Map map9 = map2;
            boolean z16 = z;
            Object obj7 = obj;
            Object obj8 = obj7;
            Map map10 = map8;
            while (true) {
                try {
                    c = jSONLexer3.f159ch;
                    map3 = map8;
                } catch (Throwable th) {
                    th = th;
                }
                if (c != '\"' && c != '}') {
                    jSONLexer3.skipWhitespace();
                    defaultJSONParser = defaultJSONParser4;
                    defaultJSONParser2 = defaultJSONParser3;
                    z2 = z15;
                    parseContext = parseContext2;
                    z3 = z14;
                    z4 = z13;
                    z5 = z16;
                    map4 = map9;
                    jSONLexer = jSONLexer3;
                    obj2 = obj8;
                    obj3 = obj7;
                    map5 = map10;
                    map6 = map3;
                    c2 = jSONLexer.f159ch;
                    if (c2 == ',') {
                    }
                    th = th;
                    z14 = z3;
                    parseContext2 = parseContext;
                    defaultJSONParser3 = defaultJSONParser2;
                    if (!z14) {
                    }
                    throw th;
                }
                c2 = c;
                defaultJSONParser = defaultJSONParser4;
                defaultJSONParser2 = defaultJSONParser3;
                z2 = z15;
                parseContext = parseContext2;
                z3 = z14;
                z4 = z13;
                z5 = z16;
                map4 = map9;
                jSONLexer = jSONLexer3;
                obj2 = obj8;
                obj3 = obj7;
                map5 = map10;
                map6 = map3;
                if (c2 == ',') {
                    try {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        c2 = jSONLexer.f159ch;
                        if (c2 == ',') {
                            Object obj9 = obj2;
                            Map map11 = map4;
                            char c6 = JSONLexer.EOI;
                            if (c2 == '\"') {
                                String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser2.symbolTable, '\"');
                                str2 = scanSymbol;
                                if (jSONLexer.f159ch != ':') {
                                    jSONLexer.skipWhitespace();
                                    if (jSONLexer.f159ch != ':') {
                                        throw new JSONException("expect ':' at " + jSONLexer.pos + ", name " + ((Object) scanSymbol));
                                    }
                                    str2 = scanSymbol;
                                }
                            } else if (c2 == '}') {
                                int i5 = jSONLexer.f158bp + 1;
                                jSONLexer.f158bp = i5;
                                if (i5 < jSONLexer.len) {
                                    c6 = jSONLexer.text.charAt(i5);
                                }
                                jSONLexer.f159ch = c6;
                                jSONLexer.f161sp = 0;
                                jSONLexer.nextToken(16);
                                if (!z3) {
                                    defaultJSONParser2.contex = parseContext;
                                }
                                return map6;
                            } else if (c2 == '\'') {
                                String scanSymbol2 = jSONLexer.scanSymbol(defaultJSONParser2.symbolTable, ExtendedMessageFormat.QUOTE);
                                if (jSONLexer.f159ch != ':') {
                                    jSONLexer.skipWhitespace();
                                }
                                if (jSONLexer.f159ch != ':') {
                                    throw new JSONException("expect ':' at " + jSONLexer.pos);
                                }
                                str2 = scanSymbol2;
                            } else if (c2 == 26) {
                                throw new JSONException("syntax error, " + jSONLexer.info());
                            } else if (c2 == ',') {
                                throw new JSONException("syntax error, " + jSONLexer.info());
                            } else if ((c2 < '0' || c2 > '9') && c2 != '-') {
                                if (c2 != '{' && c2 != '[') {
                                    String scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser2.symbolTable);
                                    jSONLexer.skipWhitespace();
                                    char c7 = jSONLexer.f159ch;
                                    str2 = scanSymbolUnQuoted;
                                    if (c7 != ':') {
                                        throw new JSONException("expect ':' at " + jSONLexer.f158bp + ", actual " + c7);
                                    } else if (z5) {
                                        str2 = scanSymbolUnQuoted.toString();
                                    }
                                }
                                jSONLexer.nextToken();
                                z6 = true;
                                str = defaultJSONParser.parse();
                                if (z6) {
                                    int i6 = jSONLexer.f158bp + 1;
                                    jSONLexer.f158bp = i6;
                                    c3 = i6 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i6);
                                    jSONLexer.f159ch = c3;
                                    while (c3 <= ' ' && (c3 == ' ' || c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == '\f' || c3 == '\b')) {
                                        jSONLexer.next();
                                        c3 = jSONLexer.f159ch;
                                    }
                                } else {
                                    c3 = jSONLexer.f159ch;
                                }
                                jSONLexer.f161sp = 0;
                                if (str != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                    String scanSymbol3 = jSONLexer.scanSymbol(defaultJSONParser2.symbolTable, '\"');
                                    for (int i7 = 0; i7 < scanSymbol3.length(); i7++) {
                                        char charAt = scanSymbol3.charAt(i7);
                                        if (charAt >= '0' && charAt <= '9') {
                                        }
                                        z12 = false;
                                    }
                                    z12 = true;
                                    if (!z12) {
                                        obj6 = null;
                                        cls = defaultJSONParser2.config.checkAutoType(scanSymbol3, null, jSONLexer.features);
                                    } else {
                                        obj6 = null;
                                        cls = null;
                                    }
                                    if (cls != null) {
                                        break;
                                    }
                                    map6.put(JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                                    z7 = z5;
                                    z8 = z4;
                                    z9 = z2;
                                    map7 = map11;
                                } else if (str == "$ref" || parseContext == null || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                    if (!z3 || z2) {
                                        c4 = '\"';
                                    } else {
                                        ParseContext context = defaultJSONParser2.setContext(defaultJSONParser2.contex, map6, obj3);
                                        if (parseContext == null) {
                                            parseContext = context;
                                        }
                                        c4 = '\"';
                                        z2 = true;
                                    }
                                    if (c3 != c4) {
                                        String scanStringValue = jSONLexer.scanStringValue(c4);
                                        Number number2 = scanStringValue;
                                        if (z4) {
                                            JSONLexer jSONLexer4 = new JSONLexer(scanStringValue);
                                            Date date = scanStringValue;
                                            if (jSONLexer4.scanISO8601DateIfMatch(true)) {
                                                date = jSONLexer4.calendar.getTime();
                                            }
                                            jSONLexer4.close();
                                            number2 = date;
                                        }
                                        if (map11 != null) {
                                            number = number2;
                                        } else {
                                            map6.put(str, number2);
                                            map7 = map11;
                                            z7 = z5;
                                            z8 = z4;
                                            z9 = z2;
                                            c5 = jSONLexer.f159ch;
                                            if (c5 != ',' && c5 != '}') {
                                                jSONLexer.skipWhitespace();
                                                c5 = jSONLexer.f159ch;
                                            }
                                            if (c5 != ',') {
                                                if (c5 != '}') {
                                                    throw new JSONException("syntax error, " + jSONLexer.info());
                                                }
                                                int i8 = jSONLexer.f158bp + 1;
                                                jSONLexer.f158bp = i8;
                                                char charAt2 = i8 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i8);
                                                jSONLexer.f159ch = charAt2;
                                                jSONLexer.f161sp = 0;
                                                if (charAt2 == ',') {
                                                    int i9 = jSONLexer.f158bp + 1;
                                                    jSONLexer.f158bp = i9;
                                                    jSONLexer.f159ch = i9 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i9);
                                                    i3 = 16;
                                                } else if (charAt2 != '}') {
                                                    if (charAt2 == ']') {
                                                        int i10 = jSONLexer.f158bp + 1;
                                                        jSONLexer.f158bp = i10;
                                                        jSONLexer.f159ch = i10 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i10);
                                                        jSONLexer.token = 15;
                                                    } else {
                                                        jSONLexer.nextToken();
                                                    }
                                                    if (!z3) {
                                                        defaultJSONParser2.setContext(defaultJSONParser2.contex, map6, obj3);
                                                    }
                                                    if (!z3) {
                                                        defaultJSONParser2.contex = parseContext;
                                                    }
                                                    return map6;
                                                } else {
                                                    int i11 = jSONLexer.f158bp + 1;
                                                    jSONLexer.f158bp = i11;
                                                    jSONLexer.f159ch = i11 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i11);
                                                    i3 = 13;
                                                }
                                                jSONLexer.token = i3;
                                                if (!z3) {
                                                }
                                                if (!z3) {
                                                }
                                                return map6;
                                            }
                                            int i12 = jSONLexer.f158bp + 1;
                                            jSONLexer.f158bp = i12;
                                            jSONLexer.f159ch = i12 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i12);
                                        }
                                    } else if ((c3 < '0' || c3 > '9') && c3 != '-') {
                                        map7 = map11;
                                        if (c3 == '[') {
                                            jSONLexer.token = 14;
                                            int i13 = jSONLexer.f158bp + 1;
                                            jSONLexer.f158bp = i13;
                                            jSONLexer.f159ch = i13 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i13);
                                            ArrayList arrayList = new ArrayList();
                                            if (obj3 != null) {
                                                z7 = z5;
                                                if (obj9.getClass() == Integer.class) {
                                                    z11 = true;
                                                    if (!z11) {
                                                        defaultJSONParser2.setContext(parseContext);
                                                    }
                                                    defaultJSONParser2.parseArray(arrayList, str);
                                                    JSONArray jSONArray = new JSONArray(arrayList);
                                                    if (map7 == null) {
                                                        map7.put(str, jSONArray);
                                                    } else {
                                                        map6.put(str, jSONArray);
                                                    }
                                                    i2 = jSONLexer.token;
                                                    if (i2 != 13) {
                                                        jSONLexer.nextToken(16);
                                                        if (!z3) {
                                                            defaultJSONParser2.contex = parseContext;
                                                        }
                                                        return map6;
                                                    } else if (i2 != 16) {
                                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                                    } else {
                                                        z8 = z4;
                                                        z9 = z2;
                                                    }
                                                }
                                            } else {
                                                z7 = z5;
                                            }
                                            z11 = false;
                                            if (!z11) {
                                            }
                                            defaultJSONParser2.parseArray(arrayList, str);
                                            JSONArray jSONArray2 = new JSONArray(arrayList);
                                            if (map7 == null) {
                                            }
                                            i2 = jSONLexer.token;
                                            if (i2 != 13) {
                                            }
                                        } else {
                                            z7 = z5;
                                            if (c3 == '{') {
                                                int i14 = jSONLexer.f158bp + 1;
                                                jSONLexer.f158bp = i14;
                                                jSONLexer.f159ch = i14 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i14);
                                                jSONLexer.token = 12;
                                                boolean z17 = obj3 instanceof Integer;
                                                JSONObject jSONObject = (jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject();
                                                ParseContext context2 = (z3 || z17) ? null : defaultJSONParser2.setContext(parseContext, jSONObject, str);
                                                z8 = z4;
                                                if (defaultJSONParser2.fieldTypeResolver != null) {
                                                    z9 = z2;
                                                    Type resolve = defaultJSONParser2.fieldTypeResolver.resolve(map6, str != null ? str.toString() : null);
                                                    if (resolve != null) {
                                                        obj4 = defaultJSONParser2.config.getDeserializer(resolve).deserialze(defaultJSONParser2, resolve, str);
                                                        z10 = true;
                                                        if (!z10) {
                                                            obj4 = defaultJSONParser2.parseObject(jSONObject, str);
                                                        }
                                                        if (context2 != null && jSONObject != obj4) {
                                                            context2.object = map6;
                                                        }
                                                        if (defaultJSONParser2.resolveStatus == 1) {
                                                            defaultJSONParser2.checkMapResolve(map6, str.toString());
                                                        }
                                                        if (map7 == null) {
                                                            map7.put(str, obj4);
                                                        } else {
                                                            map6.put(str, obj4);
                                                        }
                                                        if (z17) {
                                                            defaultJSONParser2.setContext(parseContext, obj4, str);
                                                        }
                                                        i = jSONLexer.token;
                                                        if (i != 13) {
                                                            jSONLexer.nextToken(16);
                                                            if (!z3) {
                                                                defaultJSONParser2.contex = parseContext;
                                                            }
                                                            if (!z3) {
                                                                defaultJSONParser2.contex = parseContext;
                                                            }
                                                            return map6;
                                                        } else if (i != 16) {
                                                            throw new JSONException("syntax error, " + jSONLexer.info());
                                                        }
                                                    }
                                                } else {
                                                    z9 = z2;
                                                }
                                                obj4 = null;
                                                z10 = false;
                                                if (!z10) {
                                                }
                                                if (context2 != null) {
                                                    context2.object = map6;
                                                }
                                                if (defaultJSONParser2.resolveStatus == 1) {
                                                }
                                                if (map7 == null) {
                                                }
                                                if (z17) {
                                                }
                                                i = jSONLexer.token;
                                                if (i != 13) {
                                                }
                                            } else {
                                                z8 = z4;
                                                z9 = z2;
                                                if (c3 == 't') {
                                                    if (jSONLexer.text.startsWith("true", jSONLexer.f158bp)) {
                                                        jSONLexer.f158bp += 3;
                                                        jSONLexer.next();
                                                        bool = Boolean.TRUE;
                                                        map6.put(str, bool);
                                                    }
                                                    c5 = jSONLexer.f159ch;
                                                    if (c5 != ',') {
                                                        jSONLexer.skipWhitespace();
                                                        c5 = jSONLexer.f159ch;
                                                    }
                                                    if (c5 != ',') {
                                                    }
                                                } else if (c3 == 'f') {
                                                    if (jSONLexer.text.startsWith("false", jSONLexer.f158bp)) {
                                                        jSONLexer.f158bp += 4;
                                                        jSONLexer.next();
                                                        bool = Boolean.FALSE;
                                                        map6.put(str, bool);
                                                    }
                                                    c5 = jSONLexer.f159ch;
                                                    if (c5 != ',') {
                                                    }
                                                    if (c5 != ',') {
                                                    }
                                                } else {
                                                    jSONLexer.nextToken();
                                                    Object parse = defaultJSONParser.parse();
                                                    String str3 = str;
                                                    if (map5.getClass() == JSONObject.class) {
                                                        str3 = str.toString();
                                                    }
                                                    map6.put(str3, parse);
                                                    if (jSONLexer.token == 13) {
                                                        jSONLexer.nextToken(16);
                                                        if (!z3) {
                                                            defaultJSONParser2.contex = parseContext;
                                                        }
                                                        return map6;
                                                    } else if (jSONLexer.token != 16) {
                                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        number = jSONLexer.scanNumberValue();
                                    }
                                    map7 = map11;
                                    map7.put(str, number);
                                    z7 = z5;
                                    z8 = z4;
                                    z9 = z2;
                                    c5 = jSONLexer.f159ch;
                                    if (c5 != ',') {
                                    }
                                    if (c5 != ',') {
                                    }
                                } else {
                                    jSONLexer.nextToken(4);
                                    if (jSONLexer.token != 4) {
                                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token));
                                    }
                                    String stringVal = jSONLexer.stringVal();
                                    jSONLexer.nextToken(13);
                                    if ("@".equals(stringVal)) {
                                        ParseContext parseContext3 = defaultJSONParser2.contex;
                                        obj5 = parseContext3.object;
                                        if (!(obj5 instanceof Object[]) && !(obj5 instanceof Collection)) {
                                            if (parseContext3.parent != null) {
                                                obj5 = parseContext3.parent.object;
                                            }
                                            obj5 = null;
                                        }
                                        if (jSONLexer.token != 13) {
                                            jSONLexer.nextToken(16);
                                            if (!z3) {
                                                defaultJSONParser2.contex = parseContext;
                                            }
                                            return obj5;
                                        }
                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                    }
                                    if ("..".equals(stringVal)) {
                                        if (parseContext.object != null) {
                                            obj5 = parseContext.object;
                                            if (jSONLexer.token != 13) {
                                            }
                                        } else {
                                            resolveTask = new ResolveTask(parseContext, stringVal);
                                            defaultJSONParser2.addResolveTask(resolveTask);
                                        }
                                    } else if ("$".equals(stringVal)) {
                                        ParseContext parseContext4 = parseContext;
                                        while (parseContext4.parent != null) {
                                            parseContext4 = parseContext4.parent;
                                        }
                                        if (parseContext4.object != null) {
                                            obj5 = parseContext4.object;
                                            if (jSONLexer.token != 13) {
                                            }
                                        } else {
                                            defaultJSONParser2.addResolveTask(new ResolveTask(parseContext4, stringVal));
                                        }
                                    } else {
                                        resolveTask = new ResolveTask(parseContext, stringVal);
                                        defaultJSONParser2.addResolveTask(resolveTask);
                                    }
                                    defaultJSONParser2.resolveStatus = 1;
                                    obj5 = null;
                                    if (jSONLexer.token != 13) {
                                    }
                                }
                                z13 = z8;
                                map8 = map6;
                                map10 = map5;
                                obj7 = obj3;
                                jSONLexer3 = jSONLexer;
                                map9 = map7;
                                z14 = z3;
                                parseContext2 = parseContext;
                                defaultJSONParser3 = defaultJSONParser2;
                                defaultJSONParser4 = defaultJSONParser;
                                z16 = z7;
                                z15 = z9;
                                obj8 = obj9;
                            } else {
                                jSONLexer.f161sp = 0;
                                jSONLexer.scanNumber();
                                try {
                                    String integerValue = jSONLexer.token == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(true);
                                    if (z5) {
                                        integerValue = integerValue.toString();
                                    }
                                    if (jSONLexer.f159ch != ':') {
                                        throw new JSONException("parse number key error, " + jSONLexer.info());
                                    }
                                    str2 = integerValue;
                                } catch (NumberFormatException unused) {
                                    throw new JSONException("parse number key error, " + jSONLexer.info());
                                }
                            }
                            z6 = false;
                            str = str2;
                            if (z6) {
                            }
                            jSONLexer.f161sp = 0;
                            if (str != JSON.DEFAULT_TYPE_KEY) {
                            }
                            if (str == "$ref") {
                            }
                            if (!z3) {
                            }
                            c4 = '\"';
                            if (c3 != c4) {
                            }
                            map7 = map11;
                            map7.put(str, number);
                            z7 = z5;
                            z8 = z4;
                            z9 = z2;
                            c5 = jSONLexer.f159ch;
                            if (c5 != ',') {
                            }
                            if (c5 != ',') {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z14 = z3;
                        parseContext2 = parseContext;
                        defaultJSONParser3 = defaultJSONParser2;
                    }
                }
                th = th2;
                z14 = z3;
                parseContext2 = parseContext;
                defaultJSONParser3 = defaultJSONParser2;
                if (!z14) {
                    defaultJSONParser3.contex = parseContext2;
                }
                throw th;
            }
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        JSONLexer jSONLexer;
        int i;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i2 = this.lexer.token;
        if (i2 != 12 && i2 != 16) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, expect {, actual ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JSONToken.name(i2));
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                JSONLexer jSONLexer2 = this.lexer;
                int i3 = jSONLexer2.token;
                if (i3 == 13) {
                    jSONLexer2.nextToken(16);
                    return;
                } else if (i3 == 16) {
                    continue;
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                JSONLexer jSONLexer3 = this.lexer;
                if ((jSONLexer3.features & Feature.IgnoreNotMatch.mask) == 0) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setter not found, class ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", property ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(scanSymbol);
                    throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                }
                jSONLexer3.nextTokenWithChar(':');
                parse();
                JSONLexer jSONLexer4 = this.lexer;
                if (jSONLexer4.token == 13) {
                    jSONLexer4.nextToken();
                    return;
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 != Integer.TYPE) {
                    if (cls2 == String.class) {
                        this.lexer.nextTokenWithChar(':');
                        deserialze = parseString();
                    } else if (cls2 != Long.TYPE) {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithChar(':');
                        deserialze = deserializer2.deserialze(this, type, null);
                    }
                    fieldDeserializer.setValue(obj, deserialze);
                    jSONLexer = this.lexer;
                    i = jSONLexer.token;
                    if (i != 16 && i == 13) {
                        jSONLexer.nextToken(16);
                        return;
                    }
                }
                this.lexer.nextTokenWithChar(':');
                deserialze = IntegerCodec.instance.deserialze(this, type, null);
                fieldDeserializer.setValue(obj, deserialze);
                jSONLexer = this.lexer;
                i = jSONLexer.token;
                if (i != 16) {
                    jSONLexer.nextToken(16);
                    return;
                }
                continue;
            }
        }
    }

    public String parseString() {
        JSONLexer jSONLexer;
        JSONLexer jSONLexer2 = this.lexer;
        int i = jSONLexer2.token;
        int i2 = 16;
        if (i != 4) {
            if (i == 2) {
                String numberString = jSONLexer2.numberString();
                this.lexer.nextToken(16);
                return numberString;
            }
            Object parse = parse();
            if (parse != null) {
                return parse.toString();
            }
            return null;
        }
        String stringVal = jSONLexer2.stringVal();
        JSONLexer jSONLexer3 = this.lexer;
        char c = jSONLexer3.f159ch;
        char c2 = JSONLexer.EOI;
        if (c == ',') {
            int i3 = jSONLexer3.f158bp + 1;
            jSONLexer3.f158bp = i3;
            if (i3 < jSONLexer3.len) {
                c2 = jSONLexer3.text.charAt(i3);
            }
            jSONLexer3.f159ch = c2;
            jSONLexer = this.lexer;
        } else if (c == ']') {
            int i4 = jSONLexer3.f158bp + 1;
            jSONLexer3.f158bp = i4;
            if (i4 < jSONLexer3.len) {
                c2 = jSONLexer3.text.charAt(i4);
            }
            jSONLexer3.f159ch = c2;
            jSONLexer = this.lexer;
            i2 = 15;
        } else if (c != '}') {
            jSONLexer3.nextToken();
            return stringVal;
        } else {
            int i5 = jSONLexer3.f158bp + 1;
            jSONLexer3.f158bp = i5;
            if (i5 < jSONLexer3.len) {
                c2 = jSONLexer3.text.charAt(i5);
            }
            jSONLexer3.f159ch = c2;
            jSONLexer = this.lexer;
            i2 = 13;
        }
        jSONLexer.token = i2;
        return stringVal;
    }

    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex;
        parseContextArr[i - 1] = null;
        this.contextArrayIndex = i - 1;
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i] = parseContext2;
        return parseContext2;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.disableCircularReferenceDetect) {
            return;
        }
        this.contex = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }
}
