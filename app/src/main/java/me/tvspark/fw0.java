package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class fw0 implements kw0<float[]> {
    public fw0(iw0 iw0Var) {
    }

    @Override // me.tvspark.kw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        float[] fArr = (float[]) obj;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (float f : fArr) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                appendable.append(Float.toString(f));
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
