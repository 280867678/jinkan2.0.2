package org.eclipse.jetty.util.ajax;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.tvspark.outline;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public class JSON {
    public Map<String, Convertor> _convertors = new ConcurrentHashMap();
    public int _stringBufferSize = 1024;
    public static final Logger LOG = Log.getLogger(JSON.class);
    public static final JSON DEFAULT = new JSON();

    /* loaded from: classes5.dex */
    public final class ConvertableOutput implements Output {
        public final Appendable _buffer;

        /* renamed from: c */
        public char f4597c;

        public ConvertableOutput(Appendable appendable) {
            this.f4597c = '{';
            this._buffer = appendable;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(Object obj) {
            if (this.f4597c != 0) {
                JSON.this.append(this._buffer, obj);
                this.f4597c = (char) 0;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String str, double d) {
            try {
                if (this.f4597c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f4597c);
                QuotedStringTokenizer.quote(this._buffer, str);
                this._buffer.append(':');
                JSON.this.appendNumber(this._buffer, Double.valueOf(d));
                this.f4597c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String str, long j) {
            try {
                if (this.f4597c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f4597c);
                QuotedStringTokenizer.quote(this._buffer, str);
                this._buffer.append(':');
                JSON.this.appendNumber(this._buffer, Long.valueOf(j));
                this.f4597c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String str, Object obj) {
            try {
                if (this.f4597c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f4597c);
                QuotedStringTokenizer.quote(this._buffer, str);
                this._buffer.append(':');
                JSON.this.append(this._buffer, obj);
                this.f4597c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String str, boolean z) {
            try {
                if (this.f4597c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f4597c);
                QuotedStringTokenizer.quote(this._buffer, str);
                this._buffer.append(':');
                JSON.this.appendBoolean(this._buffer, z ? Boolean.TRUE : Boolean.FALSE);
                this.f4597c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void addClass(Class cls) {
            try {
                if (this.f4597c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f4597c);
                this._buffer.append("\"class\":");
                JSON.this.append(this._buffer, cls.getName());
                this.f4597c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void complete() {
            Appendable appendable;
            String str;
            try {
                if (this.f4597c == '{') {
                    appendable = this._buffer;
                    str = MessageFormatter.DELIM_STR;
                } else if (this.f4597c == 0) {
                    return;
                } else {
                    appendable = this._buffer;
                    str = "}";
                }
                appendable.append(str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface Convertible {
        void fromJSON(Map map);

        void toJSON(Output output);
    }

    /* loaded from: classes5.dex */
    public interface Convertor {
        Object fromJSON(Map map);

        void toJSON(Object obj, Output output);
    }

    /* loaded from: classes5.dex */
    public interface Generator {
        void addJSON(Appendable appendable);
    }

    /* loaded from: classes5.dex */
    public static class Literal implements Generator {
        public String _json;

        public Literal(String str) {
            if (JSON.LOG.isDebugEnabled()) {
                JSON.parse(str);
            }
            this._json = str;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Generator
        public void addJSON(Appendable appendable) {
            try {
                appendable.append(this._json);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String toString() {
            return this._json;
        }
    }

    /* loaded from: classes5.dex */
    public interface Output {
        void add(Object obj);

        void add(String str, double d);

        void add(String str, long j);

        void add(String str, Object obj);

        void add(String str, boolean z);

        void addClass(Class cls);
    }

    /* loaded from: classes5.dex */
    public static class ReaderSource implements Source {
        public int _next = -1;
        public Reader _reader;
        public char[] scratch;

        public ReaderSource(Reader reader) {
            this._reader = reader;
        }

        private void getNext() {
            if (this._next < 0) {
                try {
                    this._next = this._reader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public boolean hasNext() {
            getNext();
            if (this._next < 0) {
                this.scratch = null;
                return false;
            }
            return true;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char next() {
            getNext();
            char c = (char) this._next;
            this._next = -1;
            return c;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char peek() {
            getNext();
            return (char) this._next;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char[] scratchBuffer() {
            if (this.scratch == null) {
                this.scratch = new char[1024];
            }
            return this.scratch;
        }

        public void setReader(Reader reader) {
            this._reader = reader;
            this._next = -1;
        }
    }

    /* loaded from: classes5.dex */
    public interface Source {
        boolean hasNext();

        char next();

        char peek();

        char[] scratchBuffer();
    }

    /* loaded from: classes5.dex */
    public static class StringSource implements Source {
        public int index;
        public char[] scratch;
        public final String string;

        public StringSource(String str) {
            this.string = str;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public boolean hasNext() {
            if (this.index < this.string.length()) {
                return true;
            }
            this.scratch = null;
            return false;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char next() {
            String str = this.string;
            int i = this.index;
            this.index = i + 1;
            return str.charAt(i);
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char peek() {
            return this.string.charAt(this.index);
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char[] scratchBuffer() {
            if (this.scratch == null) {
                this.scratch = new char[this.string.length()];
            }
            return this.scratch;
        }

        public String toString() {
            return this.string.substring(0, this.index) + "|||" + this.string.substring(this.index);
        }
    }

    public static void complete(String str, Source source) {
        int i = 0;
        while (source.hasNext() && i < str.length()) {
            char next = source.next();
            int i2 = i + 1;
            if (next != str.charAt(i)) {
                throw new IllegalStateException("Unexpected '" + next + " while seeking  \"" + str + "\"");
            }
            i = i2;
        }
        if (i >= str.length()) {
            return;
        }
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected \"", str, "\""));
    }

    public static JSON getDefault() {
        return DEFAULT;
    }

    @Deprecated
    public static Object parse(InputStream inputStream) throws IOException {
        return DEFAULT.parse((Source) new StringSource(C3009IO.toString(inputStream)), false);
    }

    @Deprecated
    public static Object parse(InputStream inputStream, boolean z) throws IOException {
        return DEFAULT.parse(new StringSource(C3009IO.toString(inputStream)), z);
    }

    public static Object parse(Reader reader) throws IOException {
        return DEFAULT.parse((Source) new ReaderSource(reader), false);
    }

    public static Object parse(Reader reader, boolean z) throws IOException {
        return DEFAULT.parse(new ReaderSource(reader), z);
    }

    public static Object parse(String str) {
        return DEFAULT.parse((Source) new StringSource(str), false);
    }

    public static Object parse(String str, boolean z) {
        return DEFAULT.parse(new StringSource(str), z);
    }

    public static void registerConvertor(Class cls, Convertor convertor) {
        DEFAULT.addConvertor(cls, convertor);
    }

    @Deprecated
    public static void setDefault(JSON json) {
    }

    public static String toString(Object obj) {
        StringBuilder sb = new StringBuilder(DEFAULT.getStringBufferSize());
        DEFAULT.append(sb, obj);
        return sb.toString();
    }

    public static String toString(Map map) {
        StringBuilder sb = new StringBuilder(DEFAULT.getStringBufferSize());
        DEFAULT.appendMap(sb, map);
        return sb.toString();
    }

    public static String toString(Object[] objArr) {
        StringBuilder sb = new StringBuilder(DEFAULT.getStringBufferSize());
        DEFAULT.appendArray(sb, objArr);
        return sb.toString();
    }

    public void addConvertor(Class cls, Convertor convertor) {
        this._convertors.put(cls.getName(), convertor);
    }

    public void addConvertorFor(String str, Convertor convertor) {
        this._convertors.put(str, convertor);
    }

    public void append(Appendable appendable, Object obj) {
        String obj2;
        try {
            if (obj == null) {
                appendable.append("null");
            } else if (obj instanceof Map) {
                appendMap(appendable, (Map) obj);
            } else {
                if (obj instanceof String) {
                    obj2 = (String) obj;
                } else if (obj instanceof Number) {
                    appendNumber(appendable, (Number) obj);
                    return;
                } else if (obj instanceof Boolean) {
                    appendBoolean(appendable, (Boolean) obj);
                    return;
                } else if (obj.getClass().isArray()) {
                    appendArray(appendable, obj);
                    return;
                } else if (obj instanceof Character) {
                    obj2 = obj.toString();
                } else if (obj instanceof Convertible) {
                    appendJSON(appendable, (Convertible) obj);
                    return;
                } else if (obj instanceof Generator) {
                    appendJSON(appendable, (Generator) obj);
                    return;
                } else {
                    Convertor convertor = getConvertor(obj.getClass());
                    if (convertor != null) {
                        appendJSON(appendable, convertor, obj);
                        return;
                    } else if (obj instanceof Collection) {
                        appendArray(appendable, (Collection) obj);
                        return;
                    } else {
                        obj2 = obj.toString();
                    }
                }
                appendString(appendable, obj2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void append(StringBuffer stringBuffer, Object obj) {
        append((Appendable) stringBuffer, obj);
    }

    public void appendArray(Appendable appendable, Object obj) {
        try {
            if (obj == null) {
                appendNull(appendable);
                return;
            }
            appendable.append('[');
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    appendable.append(',');
                }
                append(appendable, Array.get(obj, i));
            }
            appendable.append(']');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendArray(Appendable appendable, Collection collection) {
        try {
            if (collection == null) {
                appendNull(appendable);
                return;
            }
            appendable.append('[');
            boolean z = true;
            for (Object obj : collection) {
                if (!z) {
                    appendable.append(',');
                }
                z = false;
                append(appendable, obj);
            }
            appendable.append(']');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendArray(StringBuffer stringBuffer, Object obj) {
        appendArray((Appendable) stringBuffer, obj);
    }

    @Deprecated
    public void appendArray(StringBuffer stringBuffer, Collection collection) {
        appendArray((Appendable) stringBuffer, collection);
    }

    public void appendBoolean(Appendable appendable, Boolean bool) {
        try {
            if (bool == null) {
                appendNull(appendable);
            } else {
                appendable.append(bool.booleanValue() ? "true" : "false");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendBoolean(StringBuffer stringBuffer, Boolean bool) {
        appendBoolean((Appendable) stringBuffer, bool);
    }

    public void appendJSON(Appendable appendable, Convertible convertible) {
        ConvertableOutput convertableOutput = new ConvertableOutput(appendable);
        convertible.toJSON(convertableOutput);
        convertableOutput.complete();
    }

    public void appendJSON(Appendable appendable, final Convertor convertor, final Object obj) {
        appendJSON(appendable, new Convertible() { // from class: org.eclipse.jetty.util.ajax.JSON.1
            @Override // org.eclipse.jetty.util.ajax.JSON.Convertible
            public void fromJSON(Map map) {
            }

            @Override // org.eclipse.jetty.util.ajax.JSON.Convertible
            public void toJSON(Output output) {
                convertor.toJSON(obj, output);
            }
        });
    }

    public void appendJSON(Appendable appendable, Generator generator) {
        generator.addJSON(appendable);
    }

    @Deprecated
    public void appendJSON(StringBuffer stringBuffer, Convertible convertible) {
        appendJSON((Appendable) stringBuffer, convertible);
    }

    @Deprecated
    public void appendJSON(StringBuffer stringBuffer, Convertor convertor, Object obj) {
        appendJSON((Appendable) stringBuffer, convertor, obj);
    }

    @Deprecated
    public void appendJSON(StringBuffer stringBuffer, Generator generator) {
        generator.addJSON(stringBuffer);
    }

    public void appendMap(Appendable appendable, Map<?, ?> map) {
        try {
            if (map == null) {
                appendNull(appendable);
                return;
            }
            appendable.append('{');
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                QuotedStringTokenizer.quote(appendable, next.getKey().toString());
                appendable.append(':');
                append(appendable, next.getValue());
                if (it.hasNext()) {
                    appendable.append(',');
                }
            }
            appendable.append('}');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendMap(StringBuffer stringBuffer, Map<?, ?> map) {
        appendMap((Appendable) stringBuffer, map);
    }

    public void appendNull(Appendable appendable) {
        try {
            appendable.append("null");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendNull(StringBuffer stringBuffer) {
        appendNull((Appendable) stringBuffer);
    }

    public void appendNumber(Appendable appendable, Number number) {
        try {
            if (number == null) {
                appendNull(appendable);
            } else {
                appendable.append(String.valueOf(number));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendNumber(StringBuffer stringBuffer, Number number) {
        appendNumber((Appendable) stringBuffer, number);
    }

    public void appendString(Appendable appendable, String str) {
        if (str == null) {
            appendNull(appendable);
        } else {
            QuotedStringTokenizer.quote(appendable, str);
        }
    }

    @Deprecated
    public void appendString(StringBuffer stringBuffer, String str) {
        appendString((Appendable) stringBuffer, str);
    }

    public JSON contextFor(String str) {
        return this;
    }

    public JSON contextForArray() {
        return this;
    }

    public Object convertTo(Class cls, Map map) {
        if (cls == null || !Convertible.class.isAssignableFrom(cls)) {
            Convertor convertor = getConvertor(cls);
            return convertor != null ? convertor.fromJSON(map) : map;
        }
        try {
            Convertible convertible = (Convertible) cls.newInstance();
            convertible.fromJSON(map);
            return convertible;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object fromJSON(String str) {
        return parse(new StringSource(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        r5 = r5.getSuperclass();
        r0 = r4._convertors.get(r5.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Convertor getConvertor(Class cls) {
        JSON json;
        Convertor convertor = this._convertors.get(cls.getName());
        if (convertor == null && this != (json = DEFAULT)) {
            convertor = json.getConvertor(cls);
        }
        while (convertor == null && cls != Object.class) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i = 0; convertor == null && interfaces != null && i < interfaces.length; i++) {
                convertor = this._convertors.get(interfaces[i].getName());
            }
        }
        return convertor;
    }

    public Convertor getConvertorFor(String str) {
        JSON json;
        Convertor convertor = this._convertors.get(str);
        return (convertor != null || this == (json = DEFAULT)) ? convertor : json.getConvertorFor(str);
    }

    public int getStringBufferSize() {
        return this._stringBufferSize;
    }

    public Object handleUnknown(Source source, char c) {
        throw new IllegalStateException("unknown char '" + c + "'(" + ((int) c) + ") in " + source);
    }

    public Object[] newArray(int i) {
        return new Object[i];
    }

    public Map<String, Object> newMap() {
        return new HashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r1 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object parse(Source source) {
        String str;
        char c = 0;
        while (source.hasNext()) {
            char peek = source.peek();
            if (c == 1) {
                if (peek != '*') {
                    if (peek == '/') {
                        c = 65535;
                    }
                }
                c = 2;
            } else if (c > 1) {
                if (peek != '*') {
                    if (peek == '/') {
                    }
                    c = 2;
                } else {
                    c = 3;
                }
            } else if (c < 0) {
                if (peek != '\n' && peek != '\r') {
                }
                c = 0;
            } else if (peek == '\"') {
                return parseString(source);
            } else {
                if (peek == '-') {
                    return parseNumber(source);
                }
                if (peek != '/') {
                    if (peek == 'N') {
                        str = "NaN";
                    } else if (peek == '[') {
                        return parseArray(source);
                    } else {
                        if (peek == 'f') {
                            complete("false", source);
                            return Boolean.FALSE;
                        } else if (peek == 'n') {
                            str = "null";
                        } else if (peek == '{') {
                            return parseObject(source);
                        } else {
                            if (peek == 't') {
                                complete("true", source);
                                return Boolean.TRUE;
                            } else if (peek == 'u') {
                                str = "undefined";
                            } else if (Character.isDigit(peek)) {
                                return parseNumber(source);
                            } else {
                                if (!Character.isWhitespace(peek)) {
                                    return handleUnknown(source, peek);
                                }
                            }
                        }
                    }
                    complete(str, source);
                    return null;
                }
                c = 1;
            }
            source.next();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0043, code lost:
        if (r4 != '\r') goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object parse(Source source, boolean z) {
        if (!z) {
            return parse(source);
        }
        Object obj = null;
        char c = 0;
        char c2 = 1;
        while (source.hasNext()) {
            char peek = source.peek();
            if (c == 1) {
                if (peek == '*') {
                    if (c2 == 1) {
                        c = 0;
                        c2 = 2;
                    }
                    c = 2;
                } else if (peek == '/') {
                    c = 65535;
                }
                source.next();
            } else {
                if (c > 1) {
                    if (peek != '*') {
                        if (peek == '/' && c == 3) {
                            if (c2 == 2) {
                                return obj;
                            }
                            c = 0;
                        }
                        c = 2;
                    }
                    c = 3;
                } else if (c < 0) {
                    if (peek != '\n') {
                    }
                    c = 0;
                } else if (!Character.isWhitespace(peek)) {
                    if (peek == '/') {
                        c = 1;
                    } else if (peek == '*') {
                        c = 3;
                    } else if (obj == null) {
                        obj = parse(source);
                    }
                }
                source.next();
            }
        }
        return obj;
    }

    public Object parseArray(Source source) {
        if (source.next() == '[') {
            Object obj = null;
            ArrayList arrayList = null;
            boolean z = true;
            int i = 0;
            while (source.hasNext()) {
                char peek = source.peek();
                if (peek != ',') {
                    if (peek == ']') {
                        source.next();
                        if (i == 0) {
                            return newArray(0);
                        }
                        if (i != 1) {
                            return arrayList.toArray(newArray(arrayList.size()));
                        }
                        Object[] newArray = newArray(1);
                        Array.set(newArray, 0, obj);
                        return newArray;
                    } else if (Character.isWhitespace(peek)) {
                        source.next();
                    } else {
                        int i2 = i + 1;
                        if (i == 0) {
                            obj = contextForArray().parse(source);
                        } else {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayList.add(obj);
                            }
                            arrayList.add(contextForArray().parse(source));
                            obj = null;
                        }
                        i = i2;
                        z = false;
                    }
                } else if (z) {
                    throw new IllegalStateException();
                } else {
                    source.next();
                    z = true;
                }
            }
            throw new IllegalStateException("unexpected end of array");
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[LOOP:1: B:22:0x0064->B:35:0x007c, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Number parseNumber(Source source) {
        StringBuilder sb;
        boolean z = false;
        long j = 0;
        while (source.hasNext()) {
            char peek = source.peek();
            if (peek != '+') {
                if (peek != 'E' && peek != 'e') {
                    if (peek != '-') {
                        if (peek != '.') {
                            switch (peek) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    j = (j * 10) + (peek - '0');
                                    source.next();
                                default:
                                    sb = null;
                                    if (sb == null) {
                                        if (z) {
                                            j *= -1;
                                        }
                                        return Long.valueOf(j);
                                    }
                                    while (source.hasNext()) {
                                        char peek2 = source.peek();
                                        if (peek2 != '+' && peek2 != 'E' && peek2 != 'e' && peek2 != '-' && peek2 != '.') {
                                            switch (peek2) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    return new Double(sb.toString());
                                            }
                                        }
                                        sb.append(peek2);
                                        source.next();
                                    }
                                    return new Double(sb.toString());
                            }
                        }
                    }
                }
                sb = new StringBuilder(16);
                if (z) {
                    sb.append('-');
                }
                sb.append(j);
                sb.append(peek);
                source.next();
                if (sb == null) {
                }
            }
            if (j != 0) {
                throw new IllegalStateException("bad number");
            }
            z = true;
            source.next();
        }
        sb = null;
        if (sb == null) {
        }
    }

    public Object parseObject(Source source) {
        if (source.next() == '{') {
            Map<String, Object> newMap = newMap();
            while (true) {
                char seekTo = seekTo("\"}", source);
                if (source.hasNext()) {
                    if (seekTo != '}') {
                        String parseString = parseString(source);
                        seekTo(':', source);
                        source.next();
                        newMap.put(parseString, contextFor(parseString).parse(source));
                        seekTo(",}", source);
                        if (source.next() == '}') {
                            break;
                        }
                    } else {
                        source.next();
                        break;
                    }
                } else {
                    break;
                }
            }
            String str = (String) newMap.get("x-class");
            if (str != null) {
                Convertor convertorFor = getConvertorFor(str);
                if (convertorFor != null) {
                    return convertorFor.fromJSON(newMap);
                }
                LOG.warn("No Convertor for x-class '{}'", str);
            }
            String str2 = (String) newMap.get("class");
            if (str2 != null) {
                try {
                    return convertTo(Loader.loadClass(JSON.class, str2), newMap);
                } catch (ClassNotFoundException unused) {
                    LOG.warn("No Class for '{}'", str2);
                }
            }
            return newMap;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
        if (r4 == '\"') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (r4 == '/') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        if (r4 == '\\') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (r4 == 'b') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
        if (r4 == 'f') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
        if (r4 == 'n') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
        if (r4 == 'r') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
        if (r4 == 't') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
        r4 = r5 + 1;
        r3[r5] = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c1, code lost:
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0056, code lost:
        if (r4 == 'u') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0058, code lost:
        r14 = r5 + 1;
        r3[r5] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
        r5 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x005d, code lost:
        r14 = r5 + 1;
        r3[r5] = (char) (org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r21.next()) + (((org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r21.next()) << 12) + (org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r21.next()) << 8)) + (org.eclipse.jetty.util.TypeUtil.convertHexDigit((byte) r21.next()) << 4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0099, code lost:
        r4 = r5 + 1;
        r3[r5] = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        r4 = r5 + 1;
        r3[r5] = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
        r4 = r5 + 1;
        r3[r5] = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ac, code lost:
        r4 = r5 + 1;
        r3[r5] = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b3, code lost:
        r4 = r5 + 1;
        r3[r5] = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
        r4 = r5 + 1;
        r3[r5] = '/';
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bd, code lost:
        r4 = r5 + 1;
        r3[r5] = '\"';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00da, code lost:
        if (r16 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e0, code lost:
        return toString(r3, 0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e1, code lost:
        r3 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ed -> B:17:0x00ef). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String parseString(Source source) {
        boolean z;
        StringBuilder sb;
        if (source.next() == '\"') {
            char[] scratchBuffer = source.scratchBuffer();
            if (scratchBuffer == null) {
                StringBuilder sb2 = new StringBuilder(getStringBufferSize());
                z = false;
                while (source.hasNext()) {
                    char next = source.next();
                    if (z) {
                        if (next == '\"') {
                            sb2.append('\"');
                        } else if (next == '/') {
                            sb2.append('/');
                        } else if (next == '\\') {
                            sb2.append('\\');
                        } else if (next == 'b') {
                            sb2.append('\b');
                        } else if (next == 'f') {
                            sb2.append('\f');
                        } else if (next == 'n') {
                            sb2.append('\n');
                        } else if (next == 'r') {
                            sb2.append('\r');
                        } else if (next == 't') {
                            sb2.append('\t');
                        } else {
                            if (next == 'u') {
                                next = (char) (TypeUtil.convertHexDigit((byte) source.next()) + (TypeUtil.convertHexDigit((byte) source.next()) << 12) + (TypeUtil.convertHexDigit((byte) source.next()) << 8) + (TypeUtil.convertHexDigit((byte) source.next()) << 4));
                            }
                            sb2.append(next);
                        }
                        z = false;
                        while (source.hasNext()) {
                        }
                    } else if (next == '\\') {
                        z = true;
                    } else if (next == '\"') {
                        break;
                    } else {
                        sb2.append(next);
                    }
                }
                return sb2.toString();
            }
            int i = 0;
            loop0: while (true) {
                z = false;
                while (true) {
                    if (!source.hasNext()) {
                        sb = null;
                        break loop0;
                    } else if (i >= scratchBuffer.length) {
                        StringBuilder sb3 = new StringBuilder(scratchBuffer.length * 2);
                        sb3.append(scratchBuffer, 0, i);
                        sb = sb3;
                        break loop0;
                    } else {
                        char next2 = source.next();
                        if (z) {
                            break;
                        } else if (next2 == '\\') {
                            z = true;
                        } else if (next2 == '\"') {
                            return toString(scratchBuffer, 0, i);
                        } else {
                            scratchBuffer[i] = next2;
                            i++;
                        }
                    }
                }
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public char seekTo(String str, Source source) {
        while (source.hasNext()) {
            char peek = source.peek();
            if (str.indexOf(peek) >= 0) {
                return peek;
            }
            if (!Character.isWhitespace(peek)) {
                throw new IllegalStateException("Unexpected '" + peek + "' while seeking one of '" + str + "'");
            }
            source.next();
        }
        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected one of '", str, "'"));
    }

    public void seekTo(char c, Source source) {
        while (source.hasNext()) {
            char peek = source.peek();
            if (peek == c) {
                return;
            }
            if (!Character.isWhitespace(peek)) {
                throw new IllegalStateException("Unexpected '" + peek + " while seeking '" + c + "'");
            }
            source.next();
        }
        throw new IllegalStateException("Expected '" + c + "'");
    }

    public void setStringBufferSize(int i) {
        this._stringBufferSize = i;
    }

    public String toJSON(Object obj) {
        StringBuilder sb = new StringBuilder(getStringBufferSize());
        append(sb, obj);
        return sb.toString();
    }

    public String toString(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }
}
