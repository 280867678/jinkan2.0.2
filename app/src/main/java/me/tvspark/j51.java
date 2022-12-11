package me.tvspark;

/* loaded from: classes4.dex */
public final class j51 {
    public j51 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public j51() {
    }

    public j51(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public j51(int i, j51 j51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3) {
        int hashCode;
        int i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
        if (i != 1) {
            if (i == 12) {
                i2 = ((str2.hashCode() * str.hashCode()) + i) & Integer.MAX_VALUE;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            } else if (i != 16 && i != 30) {
                if (i == 7) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                } else if (i != 8) {
                    hashCode = str3.hashCode() * str2.hashCode() * str.hashCode();
                    i2 = (hashCode + i) & Integer.MAX_VALUE;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                }
            }
        }
        hashCode = str.hashCode();
        i2 = (hashCode + i) & Integer.MAX_VALUE;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }
}
