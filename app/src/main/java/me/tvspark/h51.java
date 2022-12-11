package me.tvspark;

/* loaded from: classes4.dex */
public final class h51 {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public h51(int i, String str, String str2, String str3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h51)) {
            return false;
        }
        h51 h51Var = (h51) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(h51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode()) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        stringBuffer.append('.');
        stringBuffer.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        stringBuffer.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        stringBuffer.append(" (");
        stringBuffer.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}
