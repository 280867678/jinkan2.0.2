package org.mozilla.javascript.regexp;

/* loaded from: classes5.dex */
public class RENode {
    public int bmsize;
    public char chr;
    public int flatIndex;
    public boolean greedy;
    public int index;
    public RENode kid;
    public RENode kid2;
    public int kidlen;
    public int length;
    public int max;
    public int min;
    public RENode next;

    /* renamed from: op */
    public byte f4733op;
    public int parenCount;
    public int parenIndex;
    public boolean sense;
    public int startIndex;

    public RENode(byte b) {
        this.f4733op = b;
    }
}
