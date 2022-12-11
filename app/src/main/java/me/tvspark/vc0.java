package me.tvspark;

import io.reactivex.internal.schedulers.RxThreadFactory;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class vc0 extends k60 {
    public static final vc0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new vc0();
    public static final RxThreadFactory Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    @Override // me.tvspark.k60
    public k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new wc0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
