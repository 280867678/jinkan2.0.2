package me.tvspark;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class t01<T> implements Set<T> {
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public T[][] Wwwwwwwwwwwwwwwwwwwwwww;
    public final s01<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<T> {
        public final T[] Wwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww = 0;
        public boolean Wwwwwwwwwwwwwwwwwwwwww = true;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T[] tArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwww.length;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                this.Wwwwwwwwwwwwwwwwwwwwww = false;
                T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i + 1;
                return tArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                t01.this.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwww - 1]);
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public t01() {
        this(null, 16, 8);
    }

    public t01(s01<? super T> s01Var, int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwww = (int) Math.floor(12.0d);
        this.Wwwwwwwwwwwwwwwwwwww = 1;
        this.Wwwwwwwwwwwwwwwwwww = 8;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = s01Var == null ? b11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : s01Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Wwwwwwwwwwwwwwwwwww = i2;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        T t2;
        if (t == null) {
            return false;
        }
        T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t)];
        if (tArr == null) {
            return false;
        }
        for (int i = 0; i < tArr.length && (t2 = tArr[i]) != null; i++) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t2, t)) {
                System.arraycopy(tArr, i + 1, tArr, i, (tArr.length - i) - 1);
                tArr[tArr.length - 1] = null;
                this.Wwwwwwwwwwwwwwwwwwwwww--;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        T[] tArr;
        int i = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwww) {
            T[][] tArr2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww += 4;
            int length = tArr2.length * 2;
            T[][] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
            int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length];
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = (int) (length * 0.75d);
            for (T[] tArr3 : tArr2) {
                if (tArr3 != null) {
                    for (T t2 : tArr3) {
                        if (t2 == null) {
                            break;
                        }
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t2);
                        int i2 = iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                        if (i2 == 0) {
                            tArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = tArr;
                        } else {
                            tArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                            if (i2 == tArr.length) {
                                tArr = (T[]) Arrays.copyOf(tArr, tArr.length * 2);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = tArr;
                            }
                        }
                        tArr[i2] = t2;
                        iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] + 1;
                    }
                }
            }
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
        T[] tArr4 = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
        if (tArr4 != null) {
            while (true) {
                if (i >= tArr4.length) {
                    int length2 = tArr4.length;
                    Object[] copyOf = Arrays.copyOf(tArr4, tArr4.length * 2);
                    this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = copyOf;
                    copyOf[length2] = t;
                    break;
                }
                T t3 = tArr4[i];
                if (t3 == null) {
                    tArr4[i] = t;
                    break;
                } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t3, t)) {
                    return t3;
                } else {
                    i++;
                }
            }
        } else {
            T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[0] = t;
            this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww++;
        return t;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t) & (this.Wwwwwwwwwwwwwwwwwwwwwww.length - 1);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        if (t == null) {
            return false;
        }
        T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t)];
        T t2 = null;
        if (tArr != null) {
            int length = tArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    T t3 = tArr[i];
                    if (t3 == null) {
                        break;
                    } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t3, t)) {
                        t2 = t3;
                        break;
                    } else {
                        i++;
                    }
                } else {
                    break;
                }
            }
        }
        return t2 != null;
    }

    public T[][] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (T[][]) new Object[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return obj;
    }

    public T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (T[]) new Object[i];
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T t) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t) == t;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (T t : collection) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t) != t) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwww = (int) Math.floor(12.0d);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t01<T>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
        continue;
     */
    @Override // java.util.Set, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean containsAll(Collection<?> collection) {
        T[][] tArr;
        if (!(collection instanceof t01)) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t01<T>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next()))) {
                    return false;
                }
            }
            return true;
        }
        for (T[] tArr2 : ((t01) collection).Wwwwwwwwwwwwwwwwwwwwwww) {
            if (tArr2 != null) {
                for (T t : tArr2) {
                    if (t == null) {
                        break;
                    } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t01<T>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t01)) {
            return false;
        }
        t01 t01Var = (t01) obj;
        if (t01Var.Wwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww) {
            return containsAll(t01Var);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        T[][] tArr;
        int i = 0;
        for (T[] tArr2 : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (tArr2 != null) {
                for (T t : tArr2) {
                    if (t == null) {
                        break;
                    }
                    i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t));
                }
            }
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwww == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(toArray());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next()));
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        T[][] tArr;
        boolean z = false;
        int i = 0;
        for (T[] tArr2 : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (tArr2 != null) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < tArr2.length && tArr2[i2] != null) {
                    if (collection.contains(tArr2[i2])) {
                        if (i2 != i3) {
                            tArr2[i3] = tArr2[i2];
                        }
                        i3++;
                        i++;
                    }
                    i2++;
                }
                i += i3;
                while (i3 < i2) {
                    tArr2[i3] = null;
                    i3++;
                }
            }
        }
        if (i != this.Wwwwwwwwwwwwwwwwwwwwww) {
            z = true;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.Set, java.util.Collection
    public T[] toArray() {
        T[][] tArr;
        T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        int i = 0;
        for (T[] tArr2 : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (tArr2 != null) {
                int length = tArr2.length;
                int i2 = 0;
                while (i2 < length) {
                    T t = tArr2[i2];
                    if (t == null) {
                        break;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[i] = t;
                    i2++;
                    i++;
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public String toString() {
        T[][] tArr;
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 0) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('{');
        boolean z = true;
        for (T[] tArr2 : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (tArr2 != null) {
                for (T t : tArr2) {
                    if (t == null) {
                        break;
                    }
                    if (z) {
                        z = false;
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(t.toString());
                }
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public <U> U[] toArray(U[] uArr) {
        T[][] tArr;
        int length = uArr.length;
        int i = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (length < i) {
            uArr = (U[]) Arrays.copyOf(uArr, i);
        }
        int i2 = 0;
        for (T[] tArr2 : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (tArr2 != null) {
                int length2 = tArr2.length;
                int i3 = 0;
                while (i3 < length2) {
                    T t = tArr2[i3];
                    if (t == null) {
                        break;
                    }
                    uArr[i2] = t;
                    i3++;
                    i2++;
                }
            }
        }
        return uArr;
    }
}
