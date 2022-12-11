package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;

/* loaded from: classes5.dex */
public class CompilerState {
    public char[] cpbegin;
    public int cpend;

    /* renamed from: cx */
    public Context f4727cx;
    public int flags;
    public int parenNesting;
    public RENode result;

    /* renamed from: cp */
    public int f4726cp = 0;
    public int backReferenceLimit = Integer.MAX_VALUE;
    public int maxBackReference = 0;
    public int parenCount = 0;
    public int classCount = 0;
    public int progLength = 0;

    public CompilerState(Context context, char[] cArr, int i, int i2) {
        this.f4727cx = context;
        this.cpbegin = cArr;
        this.cpend = i;
        this.flags = i2;
    }
}
