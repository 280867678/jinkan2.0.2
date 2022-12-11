package me.tvspark;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class rx0 implements hy0 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public gy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<ey0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(100);
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    public rx0(gy0 gy0Var) {
        if (gy0Var != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = gy0Var;
            return;
        }
        throw new NullPointerException("tokenSource cannot be null");
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int size = (i - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) + 1;
        return size <= 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(size) >= size;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            ey0 nextToken = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nextToken();
            if (nextToken instanceof ky0) {
                ((ky0) nextToken).setTokenIndex(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size());
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(nextToken);
            if (nextToken.getType() == -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                return i2 + 1;
            }
        }
        return i;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        throw null;
    }

    @Override // me.tvspark.yx0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
    }

    @Override // me.tvspark.hy0
    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
    }

    @Override // me.tvspark.yx0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).getType();
    }

    @Override // me.tvspark.yx0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = false;
        if (i >= 0 && (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() : i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1)) {
            z = true;
        }
        if (z || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) != -1) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
            return;
        }
        throw new IllegalStateException("cannot consume EOF");
    }

    @Override // me.tvspark.yx0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (i >= size()) {
            return size() - 1;
        }
        while (true) {
            ey0 ey0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if (ey0Var.getChannel() == i2 || ey0Var.getType() == -1) {
                return i;
            }
            i++;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    @Override // me.tvspark.hy0
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ey0 ey0Var, ey0 ey0Var2) {
        if (ey0Var == null || ey0Var2 == null) {
            return "";
        }
        z01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ey0Var.getTokenIndex(), ey0Var2.getTokenIndex());
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i < 0 || i2 < 0) {
            return "";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        do {
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000) >= 1000);
        if (i2 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1;
        }
        StringBuilder sb = new StringBuilder();
        while (i <= i2) {
            ey0 ey0Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if (ey0Var3.getType() == -1) {
                break;
            }
            sb.append(ey0Var3.getText());
            i++;
        }
        return sb.toString();
    }

    @Override // me.tvspark.yx0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // me.tvspark.hy0
    public ey0 get(int i) {
        if (i < 0 || i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("token index ", i, " out of range 0..");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1);
            throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    @Override // me.tvspark.hy0
    public gy0 getTokenSource() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.yx0
    public int mark() {
        return 0;
    }

    @Override // me.tvspark.yx0
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
    }
}
