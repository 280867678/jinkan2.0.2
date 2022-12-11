package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes4.dex */
public class u00 extends v00<T> {
    public final /* synthetic */ v00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public u00(v00 v00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v00Var;
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T t) throws IOException {
        if (t == 0) {
            jsonWriter.nullValue();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t);
        }
    }
}
