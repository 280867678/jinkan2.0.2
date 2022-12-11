package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class bw0 implements kw0<Float> {
    public bw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        Float f = (Float) obj;
        appendable.append(f.isInfinite() ? "null" : f.toString());
    }
}
