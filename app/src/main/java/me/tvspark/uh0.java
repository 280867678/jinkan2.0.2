package me.tvspark;

/* loaded from: classes4.dex */
public final class uh0 extends uf0 {
    public final boolean[] Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public uh0(boolean[] zArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr, "array");
        this.Wwwwwwwwwwwwwwwwwwwwwww = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.length;
    }
}
