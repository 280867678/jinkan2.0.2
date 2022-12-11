package me.tvspark;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public class OO0000000 {
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Handler(Looper.getMainLooper(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((AbstractC1886O0) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1886O0<?> abstractC1886O0, boolean z) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            abstractC1886O0.recycle();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(1, abstractC1886O0).sendToTarget();
    }
}
