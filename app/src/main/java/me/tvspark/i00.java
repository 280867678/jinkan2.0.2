package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class i00 extends v00<AtomicLong> {
    public final /* synthetic */ v00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public i00(v00 v00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v00Var;
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, Long.valueOf(atomicLong.get()));
    }
}
