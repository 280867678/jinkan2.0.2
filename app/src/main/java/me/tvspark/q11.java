package me.tvspark;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes4.dex */
public class q11 extends Handler implements w11 {
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public final o11 Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final v11 Wwwwwwwwwwwwwwwwwwwwwwww = new v11();

    public q11(o11 o11Var, Looper looper, int i) {
        super(looper);
        this.Wwwwwwwwwwwwwwwwwwwwww = o11Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.w11
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21 b21Var, Object obj) {
        u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b21Var, obj);
        synchronized (this) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                u11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    synchronized (this) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            this.Wwwwwwwwwwwwwwwwwwwww = z;
                            return;
                        }
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.Wwwwwwwwwwwwwwwwwwwwwww);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            z = true;
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwww = z;
        }
    }
}
