package org.simpleframework.xml.stream;

import java.io.BufferedWriter;
import java.io.Writer;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.B64Code;
import org.seamless.xml.DOM;

/* loaded from: classes5.dex */
public class Formatter {
    public OutputBuffer buffer = new OutputBuffer();
    public Indenter indenter;
    public Tag last;
    public String prolog;
    public Writer result;
    public static final char[] NAMESPACE = {'x', 'm', 'l', 'n', 's'};
    public static final char[] LESS = {'&', 'l', 't', BasicHeaderValueParser.PARAM_DELIMITER};
    public static final char[] GREATER = {'&', 'g', 't', BasicHeaderValueParser.PARAM_DELIMITER};
    public static final char[] DOUBLE = {'&', 'q', 'u', 'o', 't', BasicHeaderValueParser.PARAM_DELIMITER};
    public static final char[] SINGLE = {'&', 'a', 'p', 'o', 's', BasicHeaderValueParser.PARAM_DELIMITER};
    public static final char[] AND = {'&', 'a', 'm', 'p', BasicHeaderValueParser.PARAM_DELIMITER};
    public static final char[] OPEN = {'<', PublicSuffixDatabase.EXCEPTION_MARKER, '-', '-', TokenParser.f4579SP};
    public static final char[] CLOSE = {TokenParser.f4579SP, '-', '-', '>'};

    /* loaded from: classes5.dex */
    public enum Tag {
        COMMENT,
        START,
        TEXT,
        END
    }

    public Formatter(Writer writer, Format format) {
        this.result = new BufferedWriter(writer, 1024);
        this.indenter = new Indenter(format);
        this.prolog = format.getProlog();
    }

    private void append(char c) throws Exception {
        this.buffer.append(c);
    }

    private void append(String str) throws Exception {
        this.buffer.append(str);
    }

    private void append(char[] cArr) throws Exception {
        this.buffer.append(cArr);
    }

    private void data(String str) throws Exception {
        write(DOM.CDATA_BEGIN);
        write(str);
        write(DOM.CDATA_END);
    }

    private void escape(char c) throws Exception {
        char[] symbol = symbol(c);
        if (symbol != null) {
            write(symbol);
        } else {
            write(c);
        }
    }

    private void escape(String str) throws Exception {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            escape(str.charAt(i));
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private boolean isText(char c) {
        if (c == '\t' || c == '\n' || c == '\r' || c == ' ') {
            return true;
        }
        return c > ' ' && c <= '~' && c != 247;
    }

    private char[] symbol(char c) {
        if (c != '\"') {
            if (c == '<') {
                return LESS;
            }
            if (c == '>') {
                return GREATER;
            }
            if (c == '&') {
                return AND;
            }
            if (c == '\'') {
                return SINGLE;
            }
            return null;
        }
        return DOUBLE;
    }

    private String unicode(char c) {
        return Integer.toString(c);
    }

    private void write(char c) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(c);
    }

    private void write(String str) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(str);
    }

    private void write(String str, String str2) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        if (!isEmpty(str2)) {
            this.result.write(str2);
            this.result.write(58);
        }
        this.result.write(str);
    }

    private void write(char[] cArr) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(cArr);
    }

    public void flush() throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.flush();
    }

    public void writeAttribute(String str, String str2, String str3) throws Exception {
        if (this.last == Tag.START) {
            write(TokenParser.f4579SP);
            write(str, str3);
            write(B64Code.__pad);
            write('\"');
            escape(str2);
            write('\"');
            return;
        }
        throw new NodeException("Start element required");
    }

    public void writeComment(String str) throws Exception {
        String pVar = this.indenter.top();
        if (this.last == Tag.START) {
            append('>');
        }
        if (pVar != null) {
            append(pVar);
            append(OPEN);
            append(str);
            append(CLOSE);
        }
        this.last = Tag.COMMENT;
    }

    public void writeEnd(String str, String str2) throws Exception {
        String pop = this.indenter.pop();
        Tag tag = this.last;
        if (tag != Tag.START) {
            if (tag != Tag.TEXT) {
                write(pop);
            }
            if (this.last != Tag.START) {
                write('<');
                write('/');
                write(str, str2);
            }
            this.last = Tag.END;
        }
        write('/');
        write('>');
        this.last = Tag.END;
    }

    public void writeNamespace(String str, String str2) throws Exception {
        if (this.last == Tag.START) {
            write(TokenParser.f4579SP);
            write(NAMESPACE);
            if (!isEmpty(str2)) {
                write(':');
                write(str2);
            }
            write(B64Code.__pad);
            write('\"');
            escape(str);
            write('\"');
            return;
        }
        throw new NodeException("Start element required");
    }

    public void writeProlog() throws Exception {
        String str = this.prolog;
        if (str != null) {
            write(str);
            write("\n");
        }
    }

    public void writeStart(String str, String str2) throws Exception {
        String push = this.indenter.push();
        if (this.last == Tag.START) {
            append('>');
        }
        flush();
        append(push);
        append('<');
        if (!isEmpty(str2)) {
            append(str2);
            append(':');
        }
        append(str);
        this.last = Tag.START;
    }

    public void writeText(String str) throws Exception {
        writeText(str, Mode.ESCAPE);
    }

    public void writeText(String str, Mode mode) throws Exception {
        if (this.last == Tag.START) {
            write('>');
        }
        if (mode == Mode.DATA) {
            data(str);
        } else {
            escape(str);
        }
        this.last = Tag.TEXT;
    }
}
