package me.tvspark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.stub.StubApp;
import java.util.Iterator;

/* renamed from: me.tvspark.h4 */
/* loaded from: classes4.dex */
public final class C2172h4 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public final AudioManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.h4$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends BroadcastReceiver {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final C2172h4 c2172h4 = C2172h4.this;
            c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.post(new Runnable() { // from class: me.tvspark.u2
                @Override // java.lang.Runnable
                public final void run() {
                    C2172h4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            });
        }
    }

    /* renamed from: me.tvspark.h4$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public C2172h4(Context context, Handler handler, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = origApplicationContext;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AudioManager audioManager = (AudioManager) origApplicationContext.getSystemService("audio");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioManager);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = audioManager;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = audioManager.getStreamVolume(3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.registerReceiver(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioManager audioManager, int i) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 ? audioManager.isStreamMute(i) : audioManager.getStreamVolume(i) == 0;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int streamVolume = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getStreamVolume(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == streamVolume && this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = streamVolume;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Iterator<AbstractC1898a6> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
