package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public class xv0 implements kw0<Object> {
    @Override // me.tvspark.kw0
    public <E> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, Appendable appendable, ov0 ov0Var) throws IOException {
        Object[] objArr;
        if (ov0Var != null) {
            appendable.append('[');
            boolean z = false;
            for (Object obj : (Object[]) e) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, appendable, ov0Var);
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
