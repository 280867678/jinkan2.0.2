package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class j20<T> extends v00<T> {
    public v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final j20<T>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, null);
    public final w00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final t20<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final k00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final t00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements s00 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j20 j20Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    public j20(t00<T> t00Var, n00<T> n00Var, k00 k00Var, t20<T> t20Var, w00 w00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t00Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k00Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t20Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = w00Var;
    }

    @Override // me.tvspark.v00
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T t) throws IOException {
        t00<T> t00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (t00Var == null) {
            v00<T> v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (v00Var == null) {
                v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = v00Var;
            }
            v00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            l20.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }
}
