package org.mozilla.javascript.regexp;

/* loaded from: classes5.dex */
public class REGlobalData {
    public REBackTrackData backTrackStackTop;

    /* renamed from: cp */
    public int f4732cp;
    public boolean multiline;
    public long[] parens;
    public RECompiled regexp;
    public int skipped;
    public REProgState stateStackTop;

    public int parensIndex(int i) {
        return (int) this.parens[i];
    }

    public int parensLength(int i) {
        return (int) (this.parens[i] >>> 32);
    }

    public void setParens(int i, int i2, int i3) {
        REBackTrackData rEBackTrackData = this.backTrackStackTop;
        if (rEBackTrackData != null) {
            long[] jArr = rEBackTrackData.parens;
            long[] jArr2 = this.parens;
            if (jArr == jArr2) {
                this.parens = (long[]) jArr2.clone();
            }
        }
        this.parens[i] = (i3 << 32) | (i2 & 4294967295L);
    }
}
