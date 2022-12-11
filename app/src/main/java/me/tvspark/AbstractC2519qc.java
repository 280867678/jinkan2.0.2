package me.tvspark;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.qc */
/* loaded from: classes4.dex */
public abstract class AbstractC2519qc implements AbstractC2328lc {
    @Override // me.tvspark.AbstractC2328lc
    @Nullable
    public final C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2402nc c2402nc) {
        ByteBuffer byteBuffer = c2402nc.Wwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
        ByteBuffer byteBuffer2 = byteBuffer;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2.position() == 0 && byteBuffer2.hasArray() && byteBuffer2.arrayOffset() == 0);
        if (c2402nc.isDecodeOnly()) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2402nc, byteBuffer2);
    }

    @Nullable
    public abstract C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2402nc c2402nc, ByteBuffer byteBuffer);
}
