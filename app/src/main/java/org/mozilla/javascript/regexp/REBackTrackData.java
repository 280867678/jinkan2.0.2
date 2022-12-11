package org.mozilla.javascript.regexp;

/* loaded from: classes5.dex */
public class REBackTrackData {
    public final int continuationOp;
    public final int continuationPc;

    /* renamed from: cp */
    public final int f4729cp;

    /* renamed from: op */
    public final int f4730op;
    public final long[] parens;

    /* renamed from: pc */
    public final int f4731pc;
    public final REBackTrackData previous;
    public final REProgState stateStackTop;

    public REBackTrackData(REGlobalData rEGlobalData, int i, int i2, int i3, int i4, int i5) {
        this.previous = rEGlobalData.backTrackStackTop;
        this.f4730op = i;
        this.f4731pc = i2;
        this.f4729cp = i3;
        this.continuationOp = i4;
        this.continuationPc = i5;
        this.parens = rEGlobalData.parens;
        this.stateStackTop = rEGlobalData.stateStackTop;
    }
}
