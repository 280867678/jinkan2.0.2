package me.tvspark;

import java.util.List;

/* loaded from: classes4.dex */
public class g40 implements u30 {
    @Override // me.tvspark.u30
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, i30 i30Var, List<t30> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (((c50) ((m40) i30Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            if (obj instanceof List) {
                for (Object obj2 : ((c50) ((m40) i30Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj)) {
                    if (obj2 instanceof String) {
                        stringBuffer.append(obj2.toString());
                    }
                }
            }
            if (list != null) {
                for (t30 t30Var : list) {
                    Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        stringBuffer.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                }
            }
            return stringBuffer.toString();
        }
        throw null;
    }
}
