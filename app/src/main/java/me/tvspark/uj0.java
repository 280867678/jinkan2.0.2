package me.tvspark;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;

/* loaded from: classes4.dex */
public final class uj0 {
    public final tj0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final KVariance Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        new uj0(null, null);
    }

    public uj0(KVariance kVariance, tj0 tj0Var) {
        String sb;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kVariance;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tj0Var;
        if (!((kVariance == null) != (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) ? false : true)) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                sb = "Star projection must have no type specified.";
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The projection variance ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" requires type to be specified.");
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof uj0)) {
                return false;
            }
            uj0 uj0Var = (uj0) obj;
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return true;
    }

    public int hashCode() {
        KVariance kVariance = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        tj0 tj0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (tj0Var != null) {
            i = tj0Var.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        KVariance kVariance = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (kVariance == null) {
            return "*";
        }
        int ordinal = kVariance.ordinal();
        if (ordinal == 0) {
            return String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (ordinal == 1) {
            sb = new StringBuilder();
            str = "in ";
        } else if (ordinal != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            sb = new StringBuilder();
            str = "out ";
        }
        sb.append(str);
        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return sb.toString();
    }
}
