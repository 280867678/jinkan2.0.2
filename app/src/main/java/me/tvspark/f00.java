package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes4.dex */
public class f00 extends v00<Number> {
    public f00(k00 k00Var) {
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Number number) throws IOException {
        Number number2 = number;
        if (number2 == null) {
            jsonWriter.nullValue();
            return;
        }
        k00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(number2.doubleValue());
        jsonWriter.value(number2);
    }
}
