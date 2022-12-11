package me.tvspark;

/* loaded from: classes4.dex */
public final class wi0 extends ui0 {
    static {
        new wi0((char) 1, (char) 0);
    }

    public wi0(char c, char c2) {
        super(c, c2, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof wi0) {
            if (!isEmpty() || !((wi0) obj).isEmpty()) {
                wi0 wi0Var = (wi0) obj;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww != wi0Var.Wwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwww != wi0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.Wwwwwwwwwwwwwwwwwwwwwwww * 31) + this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean isEmpty() {
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww) > 0;
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww + ".." + this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
