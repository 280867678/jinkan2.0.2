package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class gw0 implements kw0<double[]> {
    public gw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        double[] dArr = (double[]) obj;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (double d : dArr) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                appendable.append(Double.toString(d));
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
