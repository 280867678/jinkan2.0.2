package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class ew0 implements kw0<long[]> {
    public ew0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        long[] jArr = (long[]) obj;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (long j : jArr) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                appendable.append(Long.toString(j));
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
