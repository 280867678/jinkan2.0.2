package me.tvspark;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class aj0 extends cg0 {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public aj0(int i, int i2, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i2;
        boolean z = i3 <= 0 ? i >= i2 : i <= i2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwww = !z ? this.Wwwwwwwwwwwwwwwwwwwwwwww : i;
    }

    @Override // me.tvspark.cg0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (i != this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww + i;
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            throw new NoSuchElementException();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
