package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.mozilla.javascript.Token;

/* loaded from: classes4.dex */
public final class o10 implements w00, Cloneable {
    public static final o10 Wwwwwwwwwwwwwwwwwww = new o10();
    public double Wwwwwwwwwwwwwwwwwwwwwwww = -1.0d;
    public int Wwwwwwwwwwwwwwwwwwwwwww = Token.JSR;
    public boolean Wwwwwwwwwwwwwwwwwwwwww = true;
    public List<c00> Wwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
    public List<c00> Wwwwwwwwwwwwwwwwwwww = Collections.emptyList();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends v00<T> {
        public final /* synthetic */ t20 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ k00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, k00 k00Var, t20 t20Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k00Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t20Var;
        }

        @Override // me.tvspark.v00
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, T t) throws IOException {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                jsonWriter.nullValue();
                return;
            }
            v00 v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (v00Var == null) {
                v00Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o10.this, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v00Var;
            }
            v00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jsonWriter, t);
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    @Override // me.tvspark.w00
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        Class<? super T> cls = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class<?>) cls, true);
        boolean z2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class<?>) cls, false);
        if (z || z2) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z, k00Var, t20Var);
        }
        return null;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == -1.0d || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((z00) cls.getAnnotation(z00.class), (a10) cls.getAnnotation(a10.class))) {
            return (!this.Wwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls)) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        }
        return true;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls, boolean z) {
        for (c00 c00Var : z ? this.Wwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwww) {
            if (c00Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls)) {
                return true;
            }
        }
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return (o10) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z00 z00Var, a10 a10Var) {
        if (z00Var == null || z00Var.value() <= this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            return a10Var == null || (a10Var.value() > this.Wwwwwwwwwwwwwwwwwwwwwwww ? 1 : (a10Var.value() == this.Wwwwwwwwwwwwwwwwwwwwwwww ? 0 : -1)) > 0;
        }
        return false;
    }
}
