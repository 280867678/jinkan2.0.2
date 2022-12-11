package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes4.dex */
public class p20 implements w00 {
    public final /* synthetic */ v00 Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Class Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends v00<T1> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls) {
        }

        @Override // me.tvspark.v00
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T1 t1) throws IOException {
            p20.this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t1);
        }
    }

    public p20(Class cls, v00 v00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwww = v00Var;
    }

    @Override // me.tvspark.w00
    public <T2> v00<T2> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T2> t20Var) {
        Class<? super T2> cls = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls)) {
            return null;
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Factory[typeHierarchy=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(",adapter=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
