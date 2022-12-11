package me.tvspark;

/* loaded from: classes4.dex */
public final class a20 implements w00 {
    public final g10 Wwwwwwwwwwwwwwwwwwwwwwww;

    public a20(g10 g10Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = g10Var;
    }

    @Override // me.tvspark.w00
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        x00 x00Var = (x00) t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAnnotation(x00.class);
        if (x00Var == null) {
            return null;
        }
        return (v00<T>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, k00Var, t20Var, x00Var);
    }

    public v00<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g10 g10Var, k00 k00Var, t20<?> t20Var, x00 x00Var) {
        v00<?> j20Var;
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = g10Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new t20(x00Var.value())).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof v00) {
            j20Var = (v00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof w00) {
            j20Var = ((w00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00Var, t20Var);
        } else {
            boolean z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof t00;
            if (!z && !(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof n00)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid attempt to bind an instance of ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass().getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" as a @JsonAdapter for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(t20Var.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
            n00 n00Var = null;
            t00 t00Var = z ? (t00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof n00) {
                n00Var = (n00) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            j20Var = new j20<>(t00Var, n00Var, k00Var, t20Var, null);
        }
        return (j20Var == null || !x00Var.nullSafe()) ? j20Var : new u00(j20Var);
    }
}
