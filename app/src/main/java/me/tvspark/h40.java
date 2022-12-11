package me.tvspark;

import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class h40 implements u30 {
    @Override // me.tvspark.u30
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, i30 i30Var, List<t30> list) {
        b50 b50Var;
        if (((c50) ((m40) i30Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            m40 m40Var = (m40) i30Var;
            if (obj instanceof List) {
                b50Var = m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                b50Var = m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (((c50) b50Var) == null) {
                    throw null;
                }
                if (!(obj instanceof Map)) {
                    return null;
                }
            }
            return Integer.valueOf(((c50) b50Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
        }
        throw null;
    }
}
