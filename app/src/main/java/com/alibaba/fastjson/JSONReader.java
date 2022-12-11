package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class JSONReader implements Closeable {
    public JSONStreamContext context;
    public final DefaultJSONParser parser;
    public Reader reader;

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public JSONReader(Reader reader) {
        this(new JSONLexer(readAll(reader)));
        this.reader = reader;
    }

    private void endStructure() {
        int i;
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i = 1002;
                break;
            case 1002:
                i = 1003;
                break;
            case 1004:
                i = 1005;
                break;
            default:
                i = -1;
                break;
        }
        if (i == -1) {
            return;
        }
        this.context.state = i;
    }

    private void readAfter() {
        int i = this.context.state;
        int i2 = 1002;
        switch (i) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1005;
                break;
            case 1005:
                i2 = -1;
                break;
            default:
                throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal state : ", i));
        }
        if (i2 != -1) {
            this.context.state = i2;
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e) {
            throw new JSONException("read string from reader error", e);
        }
    }

    private void readBefore() {
        DefaultJSONParser defaultJSONParser;
        int i;
        int i2 = this.context.state;
        switch (i2) {
            case 1001:
            case 1004:
                return;
            case 1002:
                defaultJSONParser = this.parser;
                i = 17;
                break;
            case 1003:
            case 1005:
                defaultJSONParser = this.parser;
                i = 16;
                break;
            default:
                throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal state : ", i2));
        }
        defaultJSONParser.accept(i);
    }

    private void startStructure() {
        DefaultJSONParser defaultJSONParser;
        int i;
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                defaultJSONParser = this.parser;
                i = 17;
                break;
            case 1003:
            case 1005:
                defaultJSONParser = this.parser;
                i = 16;
                break;
            default:
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal state : ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.context.state);
                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        defaultJSONParser.accept(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.lexer.close();
        Reader reader = this.reader;
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new JSONException("closed reader error", e);
            }
        }
    }

    public void config(Feature feature, boolean z) {
        this.parser.config(feature, z);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context != null) {
            int i = this.parser.lexer.token();
            int i2 = this.context.state;
            switch (i2) {
                case 1001:
                case 1003:
                    return i != 13;
                case 1002:
                default:
                    throw new JSONException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal state : ", i2));
                case 1004:
                case 1005:
                    return i != 15;
            }
        }
        throw new JSONException("context is null");
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToInt(parse);
    }

    public Long readLong() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToLong(parse);
    }

    public Object readObject() {
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        Object parse = this.parser.parse();
        readAfter();
        return parse;
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        return (T) readObject(typeReference.type);
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return (T) this.parser.parseObject((Class<Object>) cls);
        }
        readBefore();
        T t = (T) this.parser.parseObject((Class<Object>) cls);
        readAfter();
        return t;
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return (T) this.parser.parseObject(type);
        }
        readBefore();
        T t = (T) this.parser.parseObject(type);
        readAfter();
        return t;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object parseObject = this.parser.parseObject(map);
        readAfter();
        return parseObject;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public String readString() {
        Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToString(parse);
    }

    public void startArray() {
        JSONStreamContext jSONStreamContext;
        if (this.context == null) {
            jSONStreamContext = new JSONStreamContext(null, 1004);
        } else {
            startStructure();
            jSONStreamContext = new JSONStreamContext(this.context, 1004);
        }
        this.context = jSONStreamContext;
        this.parser.accept(14);
    }

    public void startObject() {
        JSONStreamContext jSONStreamContext;
        if (this.context == null) {
            jSONStreamContext = new JSONStreamContext(null, 1001);
        } else {
            startStructure();
            jSONStreamContext = new JSONStreamContext(this.context, 1001);
        }
        this.context = jSONStreamContext;
        this.parser.accept(12);
    }
}
