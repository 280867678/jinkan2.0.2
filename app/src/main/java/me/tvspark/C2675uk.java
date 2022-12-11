package me.tvspark;

/* renamed from: me.tvspark.uk */
/* loaded from: classes4.dex */
public class C2675uk {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2675uk() {
        AbstractC2564rk abstractC2564rk = AbstractC2564rk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        notifyAll();
        return true;
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        return z;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws InterruptedException {
        while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wait();
        }
    }
}
