package me.tvspark;

/* loaded from: classes4.dex */
public final class hk0 {
    public final bj0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public hk0(String str, bj0 bj0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "value");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bj0Var, "range");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bj0Var;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof hk0)) {
                return false;
            }
            hk0 hk0Var = (hk0) obj;
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) hk0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, hk0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return true;
    }

    public int hashCode() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        bj0 bj0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bj0Var != null) {
            i = bj0Var.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MatchGroup(value=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", range=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
