package org.mozilla.javascript.regexp;

/* loaded from: classes5.dex */
public class REProgState {
    public final REBackTrackData backTrack;
    public final int continuationOp;
    public final int continuationPc;
    public final int index;
    public final int max;
    public final int min;
    public final REProgState previous;

    public REProgState(REProgState rEProgState, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        this.previous = rEProgState;
        this.min = i;
        this.max = i2;
        this.index = i3;
        this.continuationOp = i4;
        this.continuationPc = i5;
        this.backTrack = rEBackTrackData;
    }
}
