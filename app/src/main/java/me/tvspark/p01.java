package me.tvspark;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class p01 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final bz0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<r01, r01> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    public p01(bz0 bz0Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bz0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        boolean z = true;
        if (!(bz0Var instanceof k01) || !((k01) bz0Var).Wwwwwwwwwwwwwwwwwwwwwwwww) {
            z = false;
        } else {
            r01 r01Var = new r01(new ny0(true));
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new r01[0];
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r01Var;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, r01 r01Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (i < 0) {
                return;
            }
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (r01[]) Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i + 1);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = r01Var;
            }
            return;
        }
        throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? "" : new q01(this, jy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString();
    }
}
