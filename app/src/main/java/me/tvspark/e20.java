package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class e20 extends v00<Object> {
    public static final w00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final k00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w00 {
        @Override // me.tvspark.w00
        public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
            if (t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Object.class) {
                return new e20(k00Var);
            }
            return null;
        }
    }

    public e20(k00 k00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k00Var;
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        k00 k00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<?> cls = obj.getClass();
        if (k00Var != null) {
            v00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = k00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new t20(cls));
            if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof e20)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, obj);
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        throw null;
    }
}
