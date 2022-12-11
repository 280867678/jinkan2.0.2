package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class t40 extends p40 {
    public final Collection<f30> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public t40(Collection<f30> collection) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = collection;
    }

    public t40(f30 f30Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.asList(f30Var);
    }

    @Override // me.tvspark.p40
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.p40
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            if (i != 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("?");
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2, b30 b30Var, m40 m40Var) {
        s40 s40Var = new s40(obj, obj2, b30Var, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        for (f30 f30Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!f30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s40Var)) {
                return false;
            }
        }
        return true;
    }

    @Override // me.tvspark.p40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, m40 m40Var) {
        b30 b30Var = m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        b50 b50Var = b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (((c50) b50Var) != null) {
            if (obj instanceof Map) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, b30Var, m40Var)) {
                    return;
                }
                if (!m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    l30Var = l30.Wwwwwwwwwwwwwwwwwwwwwww;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, l30Var, obj);
                    return;
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, l30Var, obj, m40Var);
                    return;
                }
            } else if (((c50) b50Var) != null) {
                int i = 0;
                if (!(obj instanceof List)) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        throw new InvalidPathException(String.format("Filter: %s can not be applied to primitives. Current context is: %s", toString(), obj));
                    }
                    return;
                }
                for (Object obj2 : ((c50) b50Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj)) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m40Var)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, obj, m40Var);
                    }
                    i++;
                }
                return;
            } else {
                throw null;
            }
        }
        throw null;
    }
}
