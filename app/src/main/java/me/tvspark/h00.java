package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes4.dex */
public class h00 extends v00<Number> {
    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Number number) throws IOException {
        Number number2 = number;
        if (number2 == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(number2.toString());
        }
    }
}
