package me.tvspark;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class vi0 extends wf0 {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public vi0(char c, char c2, int i) {
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2;
        boolean z = true;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c, c2);
        if (i <= 0 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwww = !z ? this.Wwwwwwwwwwwwwwwwwwwwwwww : c;
    }

    @Override // me.tvspark.wf0
    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (i != this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww + i;
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            throw new NoSuchElementException();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
