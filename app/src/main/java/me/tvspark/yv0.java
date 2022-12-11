package me.tvspark;

import java.io.IOException;
import net.minidev.json.JSONObject;

/* loaded from: classes4.dex */
public class yv0 implements kw0<Object> {
    @Override // me.tvspark.kw0
    public <E> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, Appendable appendable, ov0 ov0Var) throws IOException {
        bv0[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            dv0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = dv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e.getClass(), pv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            appendable.append('{');
            boolean z = false;
            for (bv0 bv0Var : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((dv0) e, bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null || !ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if (z) {
                        appendable.append(',');
                    } else {
                        z = true;
                    }
                    JSONObject.writeJSONKV(bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, appendable, ov0Var);
                }
            }
            appendable.append('}');
        } catch (IOException e2) {
            throw e2;
        }
    }
}
