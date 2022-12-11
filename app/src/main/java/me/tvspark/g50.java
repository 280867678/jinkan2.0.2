package me.tvspark;

/* loaded from: classes4.dex */
public final class g50<A, B> {
    public final B Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final A Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public g50(A a, B b) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g50.class != obj.getClass()) {
            return false;
        }
        g50 g50Var = (g50) obj;
        A a = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (a == null) {
            if (g50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return false;
            }
        } else if (!a.equals(g50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return false;
        }
        B b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        B b2 = g50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (b == null) {
            if (b2 != null) {
                return false;
            }
        } else if (!b.equals(b2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        int hashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
        B b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }
}
