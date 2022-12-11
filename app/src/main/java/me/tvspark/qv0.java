package me.tvspark;

import java.io.IOException;
import java.util.Iterator;
import me.tvspark.iw0;

/* loaded from: classes4.dex */
public class qv0 {
    public static ov0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ov0.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final iw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new iw0();
    public static final pw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new pw0();

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Appendable appendable, ov0 ov0Var) {
        if (str == null) {
            return;
        }
        ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, appendable);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        kw0<?> kw0Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (kw0Var == null) {
            if (cls.isArray()) {
                kw0Var = iw0.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                iw0 iw0Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Class<?> cls2 = obj.getClass();
                Iterator<iw0.Wwwwwwwwwwwwwwwwwwwwwwwwww> it = iw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                while (true) {
                    if (it.hasNext()) {
                        iw0.Wwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                        if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls2)) {
                            kw0Var = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            break;
                        }
                    } else {
                        kw0Var = null;
                        break;
                    }
                }
                if (kw0Var == null) {
                    kw0Var = iw0.Wwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kw0Var, cls);
        }
        kw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, appendable, ov0Var);
    }
}
