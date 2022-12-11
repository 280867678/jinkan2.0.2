package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import me.tvspark.g20;

/* loaded from: classes4.dex */
public final class k20<T> extends v00<T> {
    public final Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final k00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public k20(k00 k00Var, v00<T> v00Var, Type type) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k00Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v00Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = type;
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T t) throws IOException {
        v00<T> v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Type type = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t20) new t20<>(type));
            if (v00Var instanceof g20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                v00<T> v00Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!(v00Var2 instanceof g20.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    v00Var = v00Var2;
                }
            }
        }
        v00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t);
    }
}
