package me.tvspark;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public abstract class rn0 {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (rn0.this) {
                long elapsedRealtime = rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else if (elapsedRealtime < rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    if (!rn0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                    }
                }
            }
        }
    }

    public rn0(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public final synchronized rn0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SystemClock.elapsedRealtime() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sendMessage(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(1));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        return this;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);
}
