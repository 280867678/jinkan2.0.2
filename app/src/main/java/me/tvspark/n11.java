package me.tvspark;

import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class n11 implements Runnable, w11 {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final o11 Wwwwwwwwwwwwwwwwwwwwwww;
    public final v11 Wwwwwwwwwwwwwwwwwwwwwwww = new v11();

    public n11(o11 o11Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = o11Var;
    }

    @Override // me.tvspark.w11
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21 b21Var, Object obj) {
        u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
        synchronized (this) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    synchronized (this) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            return;
                        }
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (InterruptedException e) {
                r11 r11Var = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww;
                Level level = Level.WARNING;
                r11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level, Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwww = false;
            }
        }
    }
}
