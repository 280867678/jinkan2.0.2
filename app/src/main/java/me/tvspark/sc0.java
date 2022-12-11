package me.tvspark;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public final class sc0<T> implements s70<T> {
    public AtomicReferenceArray<Object> Wwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwww;
    public AtomicReferenceArray<Object> Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwwwwwwwwwww = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object Wwwwwwwwwwwwwww = new Object();
    public final AtomicLong Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicLong();
    public final AtomicLong Wwwwwwwwwwwwwwwww = new AtomicLong();

    public sc0(int i) {
        int Wwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwww(Math.max(8, i));
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwww - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Wwwwwwwwwwwwwwwwwwwwwwwww + 1);
        this.Wwwwwwwwwwwwwwwwwwww = atomicReferenceArray;
        this.Wwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwww / 4, Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwww = atomicReferenceArray;
        this.Wwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwww = i2 - 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(0L);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        while (true) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                return (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww.get();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2) {
        int i;
        AtomicReferenceArray<Object> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i2 = this.Wwwwwwwwwwwwwwwwwwwww;
        long j = 2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (atomicReferenceArray.get(((int) j) & i2) == null) {
            i = ((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) & i2;
            atomicReferenceArray.lazySet(i + 1, t2);
        } else {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.Wwwwwwwwwwwwwwwwwwww = atomicReferenceArray2;
            i = ((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) & i2;
            atomicReferenceArray2.lazySet(i + 1, t2);
            atomicReferenceArray2.lazySet(i, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            t = (T) Wwwwwwwwwwwwwww;
        }
        atomicReferenceArray.lazySet(i, t);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(j);
        return true;
    }

    @Override // me.tvspark.t70
    public void clear() {
        while (true) {
            if (mo4868poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.t70
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwwwww;
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            int i = this.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = ((int) j) & i;
            if (j < this.Wwwwwwwwwwwwwwwwwwwwww) {
                atomicReferenceArray.lazySet(i2, t);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(j + 1);
                return true;
            }
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwww + j;
            if (atomicReferenceArray.get(((int) j2) & i) == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww = j2 - 1;
                atomicReferenceArray.lazySet(i2, t);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(j + 1);
                return true;
            }
            long j3 = j + 1;
            if (atomicReferenceArray.get(((int) j3) & i) == null) {
                atomicReferenceArray.lazySet(i2, t);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(j3);
                return true;
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.Wwwwwwwwwwwwwwwwwwww = atomicReferenceArray2;
            this.Wwwwwwwwwwwwwwwwwwwwww = (i + j) - 1;
            atomicReferenceArray2.lazySet(i2, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i2, Wwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(j3);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwww;
        int i = ((int) this.Wwwwwwwwwwwwwwwww.get()) & this.Wwwwwwwwwwwwwwwwwww;
        T t = (T) atomicReferenceArray.get(i);
        if (t == Wwwwwwwwwwwwwww) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
            this.Wwwwwwwwwwwwwwwwww = atomicReferenceArray2;
            return (T) atomicReferenceArray2.get(i);
        }
        return t;
    }

    @Override // me.tvspark.s70, me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.Wwwwwwwwwwwwwwwwww;
        long j = this.Wwwwwwwwwwwwwwwww.get();
        int i = this.Wwwwwwwwwwwwwwwwwww & ((int) j);
        T t = (T) atomicReferenceArray.get(i);
        boolean z = t == Wwwwwwwwwwwwwww;
        if (t != null && !z) {
            atomicReferenceArray.lazySet(i, null);
            this.Wwwwwwwwwwwwwwwww.lazySet(j + 1);
            return t;
        } else if (!z) {
            return null;
        } else {
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
            this.Wwwwwwwwwwwwwwwwww = atomicReferenceArray2;
            T t2 = (T) atomicReferenceArray2.get(i);
            if (t2 != null) {
                atomicReferenceArray2.lazySet(i, null);
                this.Wwwwwwwwwwwwwwwww.lazySet(j + 1);
            }
            return t2;
        }
    }
}
