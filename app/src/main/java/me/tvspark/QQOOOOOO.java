package me.tvspark;

/* loaded from: classes4.dex */
public final class QQOOOOOO implements OO0000<int[]> {
    @Override // me.tvspark.OO0000
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 4;
    }

    @Override // me.tvspark.OO0000
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr) {
        return iArr.length;
    }

    @Override // me.tvspark.OO0000
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override // me.tvspark.OO0000
    public int[] newArray(int i) {
        return new int[i];
    }
}
