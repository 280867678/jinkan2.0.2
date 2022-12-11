package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class hw0 implements kw0<boolean[]> {
    public hw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        boolean[] zArr = (boolean[]) obj;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (boolean z2 : zArr) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                appendable.append(Boolean.toString(z2));
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
