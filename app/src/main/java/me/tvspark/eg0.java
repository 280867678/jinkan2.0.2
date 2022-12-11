package me.tvspark;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

@ef0
/* loaded from: classes4.dex */
public final class eg0<T> extends rf0<T> implements RandomAccess {
    public final Object[] Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends qf0<T> {
        public int Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwww = eg0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwww = eg0.this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public eg0(Object[] objArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objArr, "buffer");
        this.Wwwwwwwwwwwwwwwwwwwww = objArr;
        boolean z = false;
        if (i >= 0) {
            if (i <= this.Wwwwwwwwwwwwwwwwwwwww.length ? true : z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.length;
                this.Wwwwwwwwwwwwwwwwwwwwww = i;
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwww.length);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ring buffer filled size should not be negative but it is ", i).toString());
    }

    @Override // kotlin.collections.AbstractCollection
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        if (i >= 0) {
            if (i > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                z = false;
            }
            if (!z) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("n shouldn't be greater than the buffer size: n = ", i, ", size = ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
            } else if (i <= 0) {
                return;
            } else {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = (i2 + i) % i3;
                if (i2 > i4) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, (Object) null, i2, i3);
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, (Object) null, 0, i4);
                } else {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, (Object) null, i2, i4);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = i4;
                this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - i;
                return;
            }
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("n shouldn't be negative but it is ", i).toString());
    }

    @Override // me.tvspark.rf0, java.util.List
    public T get(int i) {
        rf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwww);
        return (T) this.Wwwwwwwwwwwwwwwwwwwww[(this.Wwwwwwwwwwwwwwwwwwwwwww + i) % this.Wwwwwwwwwwwwwwwwwwwwwwww];
    }

    @Override // me.tvspark.rf0, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "array");
        if (tArr.length < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            tArr = (T[]) Arrays.copyOf(tArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.Wwwwwwwwwwwwwwwwwwwwwww; i2 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 && i3 < this.Wwwwwwwwwwwwwwwwwwwwwwww; i3++) {
            tArr[i2] = this.Wwwwwwwwwwwwwwwwwwwww[i3];
            i2++;
        }
        while (i2 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            tArr[i2] = this.Wwwwwwwwwwwwwwwwwwwww[i];
            i2++;
            i++;
        }
        if (tArr.length > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            tArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()] = null;
        }
        return tArr;
    }
}
