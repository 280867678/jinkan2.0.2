package me.tvspark;

/* loaded from: classes4.dex */
public final class v11 {
    public u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public synchronized u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        u11 u11Var;
        u11Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            u11 u11Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11Var2;
            if (u11Var2 == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
        return u11Var;
    }

    public synchronized u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws InterruptedException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wait(i);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u11 u11Var) {
        try {
            if (u11Var == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11Var;
            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                throw new IllegalStateException("Head present, but no tail");
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11Var;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }
}
