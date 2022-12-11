package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes5.dex */
public class OutputBuffer {
    public StringBuilder text = new StringBuilder();

    public void append(char c) {
        this.text.append(c);
    }

    public void append(String str) {
        this.text.append(str);
    }

    public void append(String str, int i, int i2) {
        this.text.append((CharSequence) str, i, i2);
    }

    public void append(char[] cArr) {
        this.text.append(cArr, 0, cArr.length);
    }

    public void append(char[] cArr, int i, int i2) {
        this.text.append(cArr, i, i2);
    }

    public void clear() {
        this.text.setLength(0);
    }

    public void write(Writer writer) throws IOException {
        writer.append((CharSequence) this.text);
    }
}
