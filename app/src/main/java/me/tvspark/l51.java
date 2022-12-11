package me.tvspark;

/* loaded from: classes4.dex */
public abstract class l51 {
    public l51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public l51(int i) {
        if (i == 262144 || i == 327680) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    public abstract x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, String str, boolean z);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 327680) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, str2, str3, i == 185);
            return;
        }
        l51 l51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (l51Var == null) {
            return;
        }
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str, str2, str3);
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, k51 k51Var);

    public abstract x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z);

    public abstract x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, String str, boolean z);

    public abstract x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, k51[] k51VarArr, k51[] k51VarArr2, int[] iArr, String str, boolean z);

    public abstract x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, k51 k51Var, k51... k51VarArr);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2, String str3, boolean z);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, k51 k51Var);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, k51 k51Var, k51 k51Var2, int i);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51 k51Var);
}
