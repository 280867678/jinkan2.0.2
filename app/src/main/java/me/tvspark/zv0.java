package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class zv0 implements kw0<Double> {
    public zv0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        Double d = (Double) obj;
        appendable.append(d.isInfinite() ? "null" : d.toString());
    }
}
