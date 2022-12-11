package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2164gx;
import me.tvspark.AbstractC2500pu;
import me.tvspark.AbstractC2766wx;
import me.tvspark.C2127fx;
import me.tvspark.C2275jx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class TreeMultiset<E> extends AbstractC2500pu<E> implements Serializable {
    public static final long serialVersionUID = 1;
    public final transient Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> header;
    public final transient GeneralRange<E> range;
    public final transient Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> rootReference;

    /* loaded from: classes3.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return 0L;
                }
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return 0L;
                }
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        };

        /* synthetic */ Aggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        public abstract int nodeAggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

        public abstract long treeAggregate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == t) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, int i) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = e;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }

        public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return 0;
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) + 1;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = TreeMultiset.distinctElements(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) + TreeMultiset.distinctElements(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 1;
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j2 = 0;
            long j3 = j + (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? 0L : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                j2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3 + j2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -2) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return this;
            } else {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare > 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? this : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e), this);
            } else if (compare == 0) {
                return this;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e);
                }
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int i2;
            int i3;
            long j;
            int i4;
            int i5;
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, i);
                    }
                    return this;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, iArr);
                if (i != 0 || iArr[0] == 0) {
                    if (i > 0 && iArr[0] == 0) {
                        i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                    }
                    j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i4 = iArr[0];
                } else {
                    i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i4 = iArr[0];
            } else if (compare <= 0) {
                iArr[0] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i == 0) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i - i2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                return this;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, i);
                    }
                    return this;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, iArr);
                if (i != 0 || iArr[0] == 0) {
                    if (i > 0 && iArr[0] == 0) {
                        i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                    }
                    j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i4 = iArr[0];
                } else {
                    i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i4 = iArr[0];
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j + (i - i4);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e);
                }
                return 0;
            } else if (compare <= 0) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e);
                }
                return 0;
            }
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            TreeMultiset.successor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(e, i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            TreeMultiset.successor(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            long j;
            long j2;
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
                        j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        i = iArr[0];
                    } else {
                        j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2 - i;
                }
                return iArr[0] == 0 ? this : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (compare <= 0) {
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[0] = i2;
                if (i >= i2) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 - i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= i;
                return this;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
                        j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        i = iArr[0];
                    } else {
                        j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j - i;
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(e, i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            TreeMultiset.successor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? this : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e), this);
            } else if (compare == 0) {
                return this;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<? super Comparator<? super E>>) comparator, (Comparator<? super E>) e);
                }
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e, int i, int i2, int[] iArr) {
            int i3;
            int i4;
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (compare < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, i2);
                    }
                    return this;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 != 0 || iArr[0] == 0) {
                        if (i2 > 0 && iArr[0] == 0) {
                            i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2 - iArr[0];
                    } else {
                        i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2 - iArr[0];
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (compare <= 0) {
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[0] = i5;
                if (i == i5) {
                    if (i2 == 0) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2 - i5;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                }
                return this;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, i2);
                    }
                    return this;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 != 0 || iArr[0] == 0) {
                        if (i2 > 0 && iArr[0] == 0) {
                            i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2 - iArr[0];
                    } else {
                        i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2 - iArr[0];
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int compare = comparator.compare(e, (E) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            boolean z = true;
            if (compare < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    iArr[0] = 0;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, i);
                    return this;
                }
                int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i2 ? this : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (compare <= 0) {
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[0] = i3;
                long j = i;
                if (i3 + j > 2147483647L) {
                    z = false;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += j;
                return this;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    iArr[0] = 0;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, i);
                    return this;
                }
                int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i4 ? this : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public String toString() {
            return new Multisets$ImmutableEntry(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).toString();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwww = null;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return true;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wrapEntry = TreeMultiset.this.wrapEntry(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwww = wrapEntry;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww == TreeMultiset.this.header ? null : this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.Wwwwwwwwwwwwwwwwwwwwwww.getElement(), 0);
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return true;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wrapEntry = TreeMultiset.this.wrapEntry(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwww = wrapEntry;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww == TreeMultiset.this.header ? null : this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.Wwwwwwwwwwwwwwwwwwwwwww.getElement(), 0);
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2164gx<E> {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int getCount() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i == 0 ? TreeMultiset.this.count(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : i;
        }

        @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public E getElement() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public TreeMultiset(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, GeneralRange<E> generalRange, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(generalRange.comparator());
        this.rootReference = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.range = generalRange;
        this.header = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(null, 1);
        this.header = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        successor(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.rootReference = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(null);
    }

    private long aggregateAboveRange(Aggregate aggregate, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getUpperEndpoint(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (compare != 0) {
            return aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) + aggregate.nodeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + aggregateAboveRange(aggregate, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        int ordinal = this.range.getUpperBoundType().ordinal();
        if (ordinal == 0) {
            return aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) + aggregate.nodeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (ordinal != 1) {
            throw new AssertionError();
        } else {
            return aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    private long aggregateBelowRange(Aggregate aggregate, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (compare != 0) {
            return aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) + aggregate.nodeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + aggregateBelowRange(aggregate, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        int ordinal = this.range.getLowerBoundType().ordinal();
        if (ordinal == 0) {
            return aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) + aggregate.nodeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (ordinal != 1) {
            throw new AssertionError();
        } else {
            return aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    private long aggregateForEntries(Aggregate aggregate) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long treeAggregate = aggregate.treeAggregate(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) create, (Iterable) iterable);
        return create;
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return 0;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstNode() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E lowerEndpoint = this.range.getLowerEndpoint();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<? super Comparator<? super E>>) comparator(), (Comparator<? super E>) lowerEndpoint);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.header.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != this.header && this.range.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastNode() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E upperEndpoint = this.range.getUpperEndpoint();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator(), upperEndpoint);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        } else {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.header.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != this.header && this.range.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2500pu.class, "comparator").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, comparator);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeMultiset.class, "range").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, GeneralRange.all(comparator));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeMultiset.class, "rootReference").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, 1);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeMultiset.class, "header").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        successor(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, objectInputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void successor(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static <T> void successor(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
        successor(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        successor(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wrapEntry(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(mo4975elementSet().comparator());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, objectOutputStream);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.google.common.collect.TreeMultiset$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public int add(E e, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.range.contains(e));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            comparator().compare(e, e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(e, i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.header;
            successor(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return 0;
        }
        int[] iArr = new int[1];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator(), e, i, iArr);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return iArr[0];
        }
        throw new ConcurrentModificationException();
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (!this.range.hasLowerBound() && !this.range.hasUpperBound()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.header.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            while (true) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.header;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                } else {
                    successor(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    return;
                }
            }
        } else {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator<?>) entryIterator());
        }
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx, me.tvspark.AbstractC2689ux
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (this.range.contains(obj) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Comparator<? super Comparator<? super E>>) comparator(), (Comparator<? super E>) obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // me.tvspark.AbstractC2500pu
    public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> descendingEntryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx
    /* renamed from: descendingMultiset */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4619descendingMultiset() {
        return super.mo4619descendingMultiset();
    }

    @Override // me.tvspark.AbstractC2346lu
    public int distinctElements() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<E> elementIterator() {
        return new C2127fx(entryIterator());
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ NavigableSet mo4975elementSet() {
        return super.mo4975elementSet();
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public /* bridge */ /* synthetic */ Set mo4575entrySet() {
        return super.mo4575entrySet();
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx
    public /* bridge */ /* synthetic */ AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww firstEntry() {
        return super.firstEntry();
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: headMultiset */
    public AbstractC2766wx<E> mo4721headMultiset(E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e, boundType)), this.header);
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, me.tvspark.AbstractC2090ex
    public Iterator<E> iterator() {
        return new C2275jx(this, mo4575entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx
    public /* bridge */ /* synthetic */ AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww lastEntry() {
        return super.lastEntry();
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx
    public /* bridge */ /* synthetic */ AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx
    public /* bridge */ /* synthetic */ AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww pollLastEntry() {
        return super.pollLastEntry();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.google.common.collect.TreeMultiset$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public int remove(Object obj, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator(), obj, i, iArr);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    return iArr[0];
                }
                throw new ConcurrentModificationException();
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.google.common.collect.TreeMultiset$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public int setCount(E e, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        boolean z = true;
        if (!this.range.contains(e)) {
            if (i != 0) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            return 0;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (i > 0) {
                add(e, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator(), e, i, iArr);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return iArr[0];
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2500pu, me.tvspark.AbstractC2766wx
    /* renamed from: subMultiset */
    public /* bridge */ /* synthetic */ AbstractC2766wx mo4623subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.mo4623subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // me.tvspark.AbstractC2766wx
    /* renamed from: tailMultiset */
    public AbstractC2766wx<E> mo4722tailMultiset(E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e, boundType)), this.header);
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.google.common.collect.TreeMultiset$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public boolean setCount(E e, int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "newCount");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "oldCount");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.range.contains(e));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                add(e, i2);
            }
            return true;
        }
        int[] iArr = new int[1];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator(), e, i, i2, iArr);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.rootReference;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            throw new ConcurrentModificationException();
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        return iArr[0] == i;
    }
}
