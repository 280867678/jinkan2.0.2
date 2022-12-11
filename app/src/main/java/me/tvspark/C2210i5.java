package me.tvspark;

import android.media.AudioTrack;

/* renamed from: me.tvspark.i5 */
/* loaded from: classes4.dex */
public class C2210i5 extends Thread {
    public final /* synthetic */ AudioTrack Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2210i5(AudioTrack audioTrack) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.release();
    }
}
