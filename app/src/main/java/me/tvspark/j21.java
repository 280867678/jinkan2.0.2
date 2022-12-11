package me.tvspark;

/* loaded from: classes4.dex */
public final class j21 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public j21(String str, String str2, String str3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j21)) {
            return false;
        }
        j21 j21Var = (j21) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(j21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode()) ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
