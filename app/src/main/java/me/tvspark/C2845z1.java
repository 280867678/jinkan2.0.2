package me.tvspark;

import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.concurrent.TimeoutException;
import me.tvspark.AbstractC2736w3;
import me.tvspark.AbstractC2809y2;

/* compiled from: lambda */
/* renamed from: me.tvspark.z1 */
/* loaded from: classes4.dex */
public final /* synthetic */ class C2845z1 implements AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final /* synthetic */ C2845z1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2845z1();

    private /* synthetic */ C2845z1() {
    }

    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onPlayerError(ExoPlaybackException.createForTimeout(new TimeoutException("Player release timed out."), 1));
    }
}
