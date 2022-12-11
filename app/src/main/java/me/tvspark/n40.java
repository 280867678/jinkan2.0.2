package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import java.util.List;

/* loaded from: classes4.dex */
public class n40 extends p40 {
    public final List<t30> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public n40(String str, List<t30> list) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((list == null || list.size() <= 0) ? "()" : "(...)");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        if (str != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.p40
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.p40
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // me.tvspark.p40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, l30 l30Var, Object obj, m40 m40Var) {
        x30 y30Var;
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class cls = v30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str2);
        if (cls != null) {
            try {
                u30 u30Var = (u30) cls.newInstance();
                List<t30> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (list != null) {
                    for (t30 t30Var : list) {
                        if (!t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue()) {
                            int ordinal = t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
                            if (ordinal == 0) {
                                y30Var = new y30(m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, t30Var);
                            } else if (ordinal == 1) {
                                y30Var = new z30(t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = y30Var;
                            t30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        }
                    }
                }
                Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, l30Var, obj, m40Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                m40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), l30Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, l30Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, m40Var);
                return;
            } catch (Exception e) {
                throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Function of name: ", str2, " cannot be created"), e);
            }
        }
        throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Function with name: ", str2, " does not exist."));
    }
}
