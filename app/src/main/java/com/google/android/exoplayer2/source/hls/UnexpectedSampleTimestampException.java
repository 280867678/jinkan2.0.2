package com.google.android.exoplayer2.source.hls;

import java.io.IOException;
import me.tvspark.AbstractC2559rf;
import me.tvspark.C1895a3;

/* loaded from: classes3.dex */
public final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final AbstractC2559rf mediaChunk;
    public final long rejectedSampleTimeUs;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UnexpectedSampleTimestampException(AbstractC2559rf abstractC2559rf, long j, long j2) {
        super(r6.toString());
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
        long j3 = abstractC2559rf.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j4 = abstractC2559rf.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(103);
        sb.append("Unexpected sample timestamp: ");
        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        sb.append(" in chunk [");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append("]");
        this.mediaChunk = abstractC2559rf;
        this.lastAcceptedSampleTimeUs = j;
        this.rejectedSampleTimeUs = j2;
    }
}
