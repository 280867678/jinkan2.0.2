package me.tvspark;

import java.util.List;

/* loaded from: classes4.dex */
public class w30 implements u30 {
    @Override // me.tvspark.u30
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, i30 i30Var, List<t30> list) {
        b50 b50Var = ((m40) i30Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null && list.size() > 0) {
            for (t30 t30Var : list) {
                if (((c50) b50Var) != null) {
                    if (obj instanceof List) {
                        c50 c50Var = (c50) b50Var;
                        c50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, c50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj), t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                } else {
                    throw null;
                }
            }
        }
        return obj;
    }
}
