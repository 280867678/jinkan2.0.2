package me.tvspark;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class u11 {
    public static final List<u11> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public b21 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public u11(Object obj, b21 b21Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b21Var;
    }

    public static u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21 b21Var, Object obj) {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            if (size > 0) {
                u11 remove = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(size - 1);
                remove.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
                remove.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b21Var;
                remove.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                return remove;
            }
            return new u11(obj, b21Var);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u11 u11Var) {
        u11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        u11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        u11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() < 10000) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(u11Var);
            }
        }
    }
}
