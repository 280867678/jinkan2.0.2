package me.tvspark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.stub.StubApp;

/* renamed from: me.tvspark.w2 */
/* loaded from: classes4.dex */
public final class C2735w2 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.w2$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.w2$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends BroadcastReceiver implements Runnable {
        public final Handler Wwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = handler;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2735w2.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, -1, 3);
            }
        }
    }

    public C2735w2(Context context, Handler handler, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        boolean z2;
        if (z && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.registerReceiver(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            z2 = true;
        } else if (z || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unregisterReceiver(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z2 = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
    }
}
