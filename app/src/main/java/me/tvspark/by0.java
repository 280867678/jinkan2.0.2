package me.tvspark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class by0 extends dy0 {
    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<f11> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public by0() {
    }

    public by0(by0 by0Var, int i) {
        super(by0Var, i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g11 g11Var) {
    }

    public <T extends by0> List<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<? extends T> cls) {
        List<f11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = null;
        for (f11 f11Var : list) {
            if (cls.isInstance(f11Var)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cls.cast(f11Var));
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public <T extends by0> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<? extends T> cls, int i) {
        List<f11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        T t = null;
        if (list != null && i >= 0 && i < list.size()) {
            int i2 = -1;
            Iterator<f11> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f11 next = it.next();
                if (cls.isInstance(next) && (i2 = i2 + 1) == i) {
                    t = cls.cast(next);
                    break;
                }
            }
        }
        return t;
    }

    @Override // me.tvspark.dy0, me.tvspark.f11
    public f11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        List<f11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    public <T extends f11> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(t);
        return t;
    }

    public k11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        List<f11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            int i3 = -1;
            for (f11 f11Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (f11Var instanceof k11) {
                    k11 k11Var = (k11) f11Var;
                    if (k11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getType() == i && (i3 = i3 + 1) == i2) {
                        return k11Var;
                    }
                }
            }
        }
        return null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g11 g11Var) {
    }

    @Override // me.tvspark.dy0, me.tvspark.j11
    public int getChildCount() {
        List<f11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
