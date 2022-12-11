package me.tvspark;

import java.util.Arrays;

/* renamed from: me.tvspark.kx */
/* loaded from: classes4.dex */
public class C2312kx<K> {
    public transient int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient float Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public transient Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.kx$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2164gx<K> {
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (K) C2312kx.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
            if (me.tvspark.Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r4.Wwwwwwwwwwwwwwwwwwwwwwww, r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[r0]) != false) goto L7;
         */
        @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getCount() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i != -1) {
                C2312kx c2312kx = C2312kx.this;
                if (i < c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = C2312kx.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == -1) {
                return 0;
            }
            return C2312kx.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
        }

        @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public K getElement() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public C2312kx() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 1.0f);
    }

    public C2312kx(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 1.0f);
    }

    public C2312kx(int i, float f) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return (int) (j >>> 32);
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length >= 1073741824) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) + 1;
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i - 1;
        for (int i4 = 0; i4 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i4++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr[i4]);
            int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 & i3;
            int i6 = iArr[i5];
            iArr[i5] = i4;
            jArr[i4] = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 << 32) | (i6 & 4294967295L);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = copyOf;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i], Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]));
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = i + 1;
        if (i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return i2;
        }
        return -1;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        if (i >= i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = -1;
            return;
        }
        Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        objArr[i] = objArr[i2];
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        iArr[i] = iArr[i2];
        objArr[i2] = null;
        iArr[i2] = 0;
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j = jArr[i2];
        jArr[i] = j;
        jArr[i2] = -1;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j) & Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = iArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
        if (i3 == i2) {
            iArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = i;
            return;
        }
        while (true) {
            long[] jArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j2 = jArr2[i3];
            int i4 = (int) j2;
            if (i4 == i2) {
                jArr2[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, i);
                return;
            }
            i3 = i4;
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 ? -1 : 0;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        while (i != -1) {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i])) {
                return i;
            }
            i = (int) j;
        }
        return -1;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2]) == i && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2])) {
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                if (i3 == -1) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = (int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                } else {
                    long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    jArr[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr[i3], (int) jArr[i2]);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                return i4;
            }
            int i5 = (int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
            if (i5 == -1) {
                return 0;
            }
            i3 = i2;
            i2 = i5;
        }
    }

    public K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return (K) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = i2;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return i - 1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            return 0;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) null);
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1);
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1L);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        if (i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwww(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, float f) {
        boolean z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "Initial capacity must be non-negative");
        if (f > 0.0f) {
            z = true;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "Illegal load factor");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, f);
        int[] iArr = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
        Arrays.fill(iArr, -1);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object[i];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[i];
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(1, (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * f));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, K k, int i2, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = (i3 << 32) | 4294967295L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = k;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = i2;
    }

    public C2312kx(C2312kx<? extends K> c2312kx) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1.0f);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx<K>) c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = iArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        if (i3 == -1) {
            iArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int i5 = (int) j;
                if (i5 == -1) {
                    jArr[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i2);
                    break;
                }
                i3 = i5;
            }
        }
        int i6 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE) {
            int i7 = i2 + 1;
            int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
            if (i7 > length) {
                int max = Math.max(1, length >>> 1) + length;
                if (max >= 0) {
                    i6 = max;
                }
                if (i6 != length) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, k, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
            if (i2 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length * 2);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }
}
