package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes4.dex */
public class j00 extends v00<AtomicLongArray> {
    public final /* synthetic */ v00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public j00(v00 v00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v00Var;
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
        AtomicLongArray atomicLongArray2 = atomicLongArray;
        jsonWriter.beginArray();
        int length = atomicLongArray2.length();
        for (int i = 0; i < length; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, Long.valueOf(atomicLongArray2.get(i)));
        }
        jsonWriter.endArray();
    }
}
