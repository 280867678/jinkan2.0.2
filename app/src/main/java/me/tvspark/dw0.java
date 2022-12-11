package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class dw0 implements kw0<short[]> {
    public dw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        short[] sArr = (short[]) obj;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (short s : sArr) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                appendable.append(Short.toString(s));
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
