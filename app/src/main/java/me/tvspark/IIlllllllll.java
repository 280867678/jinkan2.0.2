package me.tvspark;

import me.tvspark.C1882Il;

/* loaded from: classes4.dex */
public class IIlllllllll implements Runnable {
    public final /* synthetic */ C1882Il Wwwwwwwwwwwwwwwwwwwwwwww;

    public IIlllllllll(C1882Il c1882Il) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c1882Il;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1882Il c1882Il = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (c1882Il != null) {
            while (true) {
                try {
                    c1882Il.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C1882Il.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) c1882Il.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove());
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            throw null;
        }
    }
}
