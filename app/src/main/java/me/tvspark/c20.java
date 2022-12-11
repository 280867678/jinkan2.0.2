package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class c20 extends JsonWriter {
    public String Wwwwwwwwwwwwwwwwwwwwwww;
    public static final Writer Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final r00 Wwwwwwwwwwwwwwwwwwww = new r00("closed");
    public final List<AbstractC3508o00> Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public AbstractC3508o00 Wwwwwwwwwwwwwwwwwwwwww = p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public c20() {
        super(Wwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC3508o00 abstractC3508o00) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            if (abstractC3508o00 != null) {
                if (!(abstractC3508o00 instanceof p00) || getSerializeNulls()) {
                    ((q00) peek()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwww, abstractC3508o00);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = null;
                return;
            }
            throw null;
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwww = abstractC3508o00;
        } else {
            AbstractC3508o00 peek = peek();
            if (!(peek instanceof m00)) {
                throw new IllegalStateException();
            }
            m00 m00Var = (m00) peek;
            if (m00Var == null) {
                throw null;
            }
            if (abstractC3508o00 == null) {
                abstractC3508o00 = p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            m00Var.Wwwwwwwwwwwwwwwwwwwwwwww.add(abstractC3508o00);
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        m00 m00Var = new m00();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m00Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.add(m00Var);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        q00 q00Var = new q00();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(q00Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.add(q00Var);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwww);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof m00)) {
            throw new IllegalStateException();
        }
        List<AbstractC3508o00> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof q00)) {
            throw new IllegalStateException();
        }
        List<AbstractC3508o00> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof q00)) {
            throw new IllegalStateException();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return this;
    }

    public final AbstractC3508o00 peek() {
        List<AbstractC3508o00> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return list.get(list.size() - 1);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d) throws IOException {
        if (isLenient() || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return this;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return this;
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return this;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00(str));
        return this;
    }
}
