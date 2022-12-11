package com.google.android.exoplayer2;

import me.tvspark.AbstractC2209i4;

/* loaded from: classes3.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final AbstractC2209i4 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(AbstractC2209i4 abstractC2209i4, int i, long j) {
        this.timeline = abstractC2209i4;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
