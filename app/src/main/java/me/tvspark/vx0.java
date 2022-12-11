package me.tvspark;

/* loaded from: classes4.dex */
public class vx0 extends rx0 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public vx0(gy0 gy0Var) {
        super(gy0Var);
    }

    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 0) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 - i >= 0) {
                for (int i3 = 1; i3 <= i && i2 > 0; i3++) {
                    i2--;
                    int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                    if (i2 >= size()) {
                        i2 = size() - 1;
                    } else {
                        while (i2 >= 0) {
                            ey0 ey0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                            if (ey0Var.getType() != -1 && ey0Var.getChannel() != i4) {
                                i2--;
                            }
                        }
                    }
                }
                if (i2 >= 0) {
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                }
                return null;
            }
        }
        return null;
    }

    @Override // me.tvspark.rx0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.rx0, me.tvspark.hy0
    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (i == 0) {
            return null;
        }
        if (i < 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwww(-i);
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (int i3 = 1; i3 < i; i3++) {
            int i4 = i2 + 1;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i4)) {
                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
    }
}
