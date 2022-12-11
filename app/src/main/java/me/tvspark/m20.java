package me.tvspark;

/* loaded from: classes4.dex */
public class m20 implements w00 {
    public final /* synthetic */ v00 Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Class Wwwwwwwwwwwwwwwwwwwwwwww;

    public m20(Class cls, v00 v00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwww = v00Var;
    }

    @Override // me.tvspark.w00
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        if (t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Factory[type=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",adapter=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
