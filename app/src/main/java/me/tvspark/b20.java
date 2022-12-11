package me.tvspark;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b20 extends JsonReader {
    public static final Object Wwwwwwwwwwwwwwwwwwww = new Object();
    public int[] Wwwwwwwwwwwwwwwwwwwww;
    public String[] Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public Object[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    private String locationString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" at path ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getPath());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww - 1;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 1];
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(objArr, i2);
            this.Wwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwww, i2);
            this.Wwwwwwwwwwwwwwwwwwwwww = (String[]) Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwww, i2);
        }
        Object[] objArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.BEGIN_ARRAY);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((m00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).iterator());
        this.Wwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.BEGIN_OBJECT);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((q00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Object[]{Wwwwwwwwwwwwwwwwwwww};
        this.Wwwwwwwwwwwwwwwwwwwwwww = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.END_ARRAY);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.END_OBJECT);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('$');
        int i = 0;
        while (i < this.Wwwwwwwwwwwwwwwwwwwwwww) {
            Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (objArr[i] instanceof m00) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('[');
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwww[i]);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(']');
                }
            } else if (objArr[i] instanceof q00) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('.');
                    String[] strArr = this.Wwwwwwwwwwwwwwwwwwwwww;
                    if (strArr[i] != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.BOOLEAN);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((r00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(JsonToken.NUMBER);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(peek);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        r00 r00Var = (r00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        double doubleValue = r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number ? r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().doubleValue() : Double.parseDouble(r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (!isLenient() && (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + doubleValue);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return doubleValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(JsonToken.NUMBER);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(peek);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        r00 r00Var = (r00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int intValue = r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number ? r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().intValue() : Integer.parseInt(r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return intValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(JsonToken.NUMBER);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(peek);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        r00 r00Var = (r00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        long longValue = r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number ? r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().longValue() : Long.parseLong(r00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return longValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).next();
        String str = (String) entry.getKey();
        this.Wwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 1] = str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.NULL);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.STRING && peek != JsonToken.NUMBER) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(JsonToken.STRING);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(peek);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((r00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof Iterator) {
            boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 2] instanceof q00;
            Iterator it = (Iterator) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next());
                return peek();
            }
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof q00) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof m00) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof r00)) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof p00) {
                    return JsonToken.NULL;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != Wwwwwwwwwwwwwwwwwwww) {
                    throw new AssertionError();
                }
                throw new IllegalStateException("JsonReader is closed");
            }
            Object obj = ((r00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (obj instanceof String) {
                return JsonToken.STRING;
            }
            if (obj instanceof Boolean) {
                return JsonToken.BOOLEAN;
            }
            if (!(obj instanceof Number)) {
                throw new AssertionError();
            }
            return JsonToken.NUMBER;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NAME;
        if (peek == jsonToken) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonToken);
            Map.Entry entry = (Map.Entry) ((Iterator) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).next();
            this.Wwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 1] = (String) entry.getKey();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getValue());
            this.Wwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 2] = "null";
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwww[i - 1] = "null";
            }
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i2 > 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwww;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return b20.class.getSimpleName();
    }
}
