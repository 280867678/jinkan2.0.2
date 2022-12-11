package me.tvspark;

import java.util.Iterator;

@ef0
/* loaded from: classes4.dex */
public final class wj0<T> implements zj0<T>, xj0<T> {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final zj0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<T>, pi0 {
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final Iterator<T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wj0 wj0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            this.Wwwwwwwwwwwwwwwwwwwwwww = wj0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            while (this.Wwwwwwwwwwwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wj0(zj0<? extends T> zj0Var, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0Var, "sequence");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zj0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (i >= 0) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count must be non-negative, but was ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('.');
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
    }

    @Override // me.tvspark.xj0
    public zj0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
        return i2 < 0 ? new wj0(this, i) : new wj0(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2);
    }

    @Override // me.tvspark.zj0
    public Iterator<T> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }
}
