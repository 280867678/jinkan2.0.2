package org.apache.commons.p056io.output;

import java.io.Writer;

/* renamed from: org.apache.commons.io.output.NullWriter */
/* loaded from: classes4.dex */
public class NullWriter extends Writer {
    public static final NullWriter NULL_WRITER = new NullWriter();

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append */
    public Writer mo5115append(char c) {
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append */
    public Writer mo5116append(CharSequence charSequence) {
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append */
    public Writer mo5117append(CharSequence charSequence, int i, int i2) {
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(int i) {
    }

    @Override // java.io.Writer
    public void write(String str) {
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
    }
}
