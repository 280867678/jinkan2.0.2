package me.tvspark;

import org.slf4j.Marker;

/* loaded from: classes4.dex */
public class n20 implements w00 {
    public final /* synthetic */ v00 Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Class Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Class Wwwwwwwwwwwwwwwwwwwwwwww;

    public n20(Class cls, Class cls2, v00 v00Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwww = cls2;
        this.Wwwwwwwwwwwwwwwwwwwwww = v00Var;
    }

    @Override // me.tvspark.w00
    public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
        Class<? super T> cls = t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (cls == this.Wwwwwwwwwwwwwwwwwwwwwwww || cls == this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Factory[type=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Marker.ANY_NON_NULL_MARKER);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",adapter=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
