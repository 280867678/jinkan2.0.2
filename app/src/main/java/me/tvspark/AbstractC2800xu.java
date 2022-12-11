package me.tvspark;

import java.util.Comparator;

/* renamed from: me.tvspark.xu */
/* loaded from: classes4.dex */
public abstract class AbstractC2800xu {
    public static final AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
    public static final AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);

    /* renamed from: me.tvspark.xu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2800xu {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            return this;
        }

        @Override // me.tvspark.AbstractC2800xu
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            return this;
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // me.tvspark.AbstractC2800xu
        public <T> AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2, Comparator<T> comparator) {
            return this;
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            return this;
        }
    }

    /* renamed from: me.tvspark.xu$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2800xu {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z));
        }

        @Override // me.tvspark.AbstractC2800xu
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return 0;
        }

        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            if (i < 0) {
                return AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (i > 0) {
                return AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return AbstractC2800xu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2));
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparable comparable, Comparable comparable2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparable.compareTo(comparable2));
        }

        @Override // me.tvspark.AbstractC2800xu
        public <T> AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2, Comparator<T> comparator) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparator.compare(t, t2));
        }

        @Override // me.tvspark.AbstractC2800xu
        public AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2));
        }
    }

    public /* synthetic */ AbstractC2800xu(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
    }

    public abstract AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2);

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    public abstract AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, T t2, Comparator<T> comparator);

    public abstract AbstractC2800xu Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2);
}
