package me.tvspark;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class O000000<Z> implements AbstractC1886O0<Z> {
    public boolean Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1886O0<Z> Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, O000000<?> o000000);
    }

    public O000000(AbstractC1886O0<Z> abstractC1886O0, boolean z, boolean z2, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC1886O0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwww = z2;
        this.Wwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwww <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i = this.Wwwwwwwwwwwwwwwwwww - 1;
            this.Wwwwwwwwwwwwwwwwwww = i;
            if (i != 0) {
                z = false;
            }
        }
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, this);
        }
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Class<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwww) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.Wwwwwwwwwwwwwwwwwww++;
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Z get() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.get();
    }

    @Override // me.tvspark.AbstractC1886O0
    public int getSize() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.getSize();
    }

    @Override // me.tvspark.AbstractC1886O0
    public synchronized void recycle() {
        if (this.Wwwwwwwwwwwwwwwwwww > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.Wwwwwwwwwwwwwwwwww) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.Wwwwwwwwwwwwwwwwww = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.Wwwwwwwwwwwwwwwwwwwwwwww + ", listener=" + this.Wwwwwwwwwwwwwwwwwwwww + ", key=" + this.Wwwwwwwwwwwwwwwwwwww + ", acquired=" + this.Wwwwwwwwwwwwwwwwwww + ", isRecycled=" + this.Wwwwwwwwwwwwwwwwww + ", resource=" + this.Wwwwwwwwwwwwwwwwwwwwww + '}';
    }
}
