package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* renamed from: me.tvspark.o00  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3508o00 {
    public r00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this instanceof r00) {
            return (r00) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            l20.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
