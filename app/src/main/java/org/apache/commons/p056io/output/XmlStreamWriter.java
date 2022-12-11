package org.apache.commons.p056io.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.p056io.input.XmlStreamReader;

/* renamed from: org.apache.commons.io.output.XmlStreamWriter */
/* loaded from: classes4.dex */
public class XmlStreamWriter extends Writer {
    public static final int BUFFER_SIZE = 4096;
    public static final Pattern ENCODING_PATTERN = XmlStreamReader.ENCODING_PATTERN;
    public final String defaultEncoding;
    public String encoding;
    public final OutputStream out;
    public Writer writer;
    public StringWriter xmlPrologWriter;

    public XmlStreamWriter(File file) throws FileNotFoundException {
        this(file, (String) null);
    }

    public XmlStreamWriter(File file, String str) throws FileNotFoundException {
        this(new FileOutputStream(file), str);
    }

    public XmlStreamWriter(OutputStream outputStream) {
        this(outputStream, (String) null);
    }

    public XmlStreamWriter(OutputStream outputStream, String str) {
        this.xmlPrologWriter = new StringWriter(4096);
        this.out = outputStream;
        this.defaultEncoding = str == null ? "UTF-8" : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        if (r0.length() >= 4096) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void detectEncoding(char[] cArr, int i, int i2) throws IOException {
        String str;
        StringBuffer buffer = this.xmlPrologWriter.getBuffer();
        int length = buffer.length() + i2 > 4096 ? 4096 - buffer.length() : i2;
        this.xmlPrologWriter.write(cArr, i, length);
        if (buffer.length() >= 5) {
            if (buffer.substring(0, 5).equals("<?xml")) {
                int indexOf = buffer.indexOf("?>");
                if (indexOf > 0) {
                    Matcher matcher = ENCODING_PATTERN.matcher(buffer.substring(0, indexOf));
                    if (matcher.find()) {
                        String upperCase = matcher.group(1).toUpperCase();
                        this.encoding = upperCase;
                        str = upperCase.substring(1, upperCase.length() - 1);
                        this.encoding = str;
                        if (this.encoding != null) {
                            return;
                        }
                        this.xmlPrologWriter = null;
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.out, this.encoding);
                        this.writer = outputStreamWriter;
                        outputStreamWriter.write(buffer.toString());
                        if (i2 <= length) {
                            return;
                        }
                        this.writer.write(cArr, i + length, i2 - length);
                        return;
                    }
                }
            }
            str = this.defaultEncoding;
            this.encoding = str;
            if (this.encoding != null) {
            }
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.writer == null) {
            this.encoding = this.defaultEncoding;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.out, this.encoding);
            this.writer = outputStreamWriter;
            outputStreamWriter.write(this.xmlPrologWriter.toString());
        }
        this.writer.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        Writer writer = this.writer;
        if (writer != null) {
            writer.flush();
        }
    }

    public String getDefaultEncoding() {
        return this.defaultEncoding;
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        if (this.xmlPrologWriter != null) {
            detectEncoding(cArr, i, i2);
        } else {
            this.writer.write(cArr, i, i2);
        }
    }
}
