package com.google.android.exoplayer2.source;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class MergingMediaSource$IllegalMergeException extends IOException {
    public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
    public final int reason;

    public MergingMediaSource$IllegalMergeException(int i) {
        this.reason = i;
    }
}
