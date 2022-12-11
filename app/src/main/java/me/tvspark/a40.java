package me.tvspark;

import com.jayway.jsonpath.JsonPathException;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a40 implements u30 {
    public abstract Number Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // me.tvspark.u30
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, i30 i30Var, List<t30> list) {
        if (((c50) ((m40) i30Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            int i = 0;
            if (obj instanceof List) {
                for (Object obj2 : ((c50) ((m40) i30Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj)) {
                    if (obj2 instanceof Number) {
                        i++;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Number) obj2);
                    }
                }
            }
            if (list != null) {
                for (t30 t30Var : list) {
                    Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Number)) {
                        i++;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Number) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
            if (i == 0) {
                throw new JsonPathException("Aggregation function attempted to calculate value using empty array");
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Number number);
}
