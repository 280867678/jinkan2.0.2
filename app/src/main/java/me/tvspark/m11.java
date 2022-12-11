package me.tvspark;

/* loaded from: classes4.dex */
public class m11 implements Runnable, w11 {
    public final o11 Wwwwwwwwwwwwwwwwwwwwwww;
    public final v11 Wwwwwwwwwwwwwwwwwwwwwwww = new v11();

    public m11(o11 o11Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = o11Var;
    }

    @Override // me.tvspark.w11
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21 b21Var, Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj));
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
