package com.google.android.exoplayer2.source;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class ClippingMediaSource$IllegalClippingException extends IOException {
    public static final int REASON_INVALID_PERIOD_COUNT = 0;
    public static final int REASON_NOT_SEEKABLE_TO_START = 1;
    public static final int REASON_START_EXCEEDS_END = 2;
    public final int reason;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ClippingMediaSource$IllegalClippingException(int i) {
        super(r0.length() != 0 ? "Illegal clipping: ".concat(r0) : new String("Illegal clipping: "));
        String valueOf = String.valueOf(getReasonDescription(i));
        this.reason = i;
    }

    public static String getReasonDescription(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
    }
}
