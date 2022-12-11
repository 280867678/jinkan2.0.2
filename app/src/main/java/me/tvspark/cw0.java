package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class cw0 implements kw0<int[]> {
    public cw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        int[] iArr = (int[]) obj;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (int i : iArr) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                appendable.append(Integer.toString(i));
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
