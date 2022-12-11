package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;

@ef0
/* loaded from: classes4.dex */
public final class fk0 implements zj0<bj0> {
    public final mh0<CharSequence, Integer, Pair<Integer, Integer>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<bj0>, pi0 {
        public int Wwwwwwwwwwwwwwwwwwww;
        public bj0 Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww = -1;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = fk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = fk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
            if (length >= 0) {
                if (i < 0) {
                    i = 0;
                } else if (i > length) {
                    i = length;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwww = i;
                return;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (r4 < r0) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            bj0 bj0Var;
            int i = 0;
            if (this.Wwwwwwwwwwwwwwwwwwwwww < 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
                this.Wwwwwwwwwwwwwwwwwwwww = null;
                return;
            }
            int i2 = fk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = -1;
            if (i2 > 0) {
                int i4 = this.Wwwwwwwwwwwwwwwwwwww + 1;
                this.Wwwwwwwwwwwwwwwwwwww = i4;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwww <= fk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length()) {
                fk0 fk0Var = fk0.this;
                Pair<Integer, Integer> mo4918invoke = fk0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4918invoke(fk0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwww));
                if (mo4918invoke == null) {
                    bj0Var = new bj0(this.Wwwwwwwwwwwwwwwwwwwwwww, nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    this.Wwwwwwwwwwwwwwwwwwwww = bj0Var;
                    this.Wwwwwwwwwwwwwwwwwwwwww = i3;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
                }
                int intValue = mo4918invoke.component1().intValue();
                int intValue2 = mo4918invoke.component2().intValue();
                this.Wwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, intValue);
                int i5 = intValue + intValue2;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i5;
                if (intValue2 == 0) {
                    i = 1;
                }
                i3 = i5 + i;
                this.Wwwwwwwwwwwwwwwwwwwwww = i3;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
            }
            bj0Var = new bj0(this.Wwwwwwwwwwwwwwwwwwwwwww, nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            this.Wwwwwwwwwwwwwwwwwwwww = bj0Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww == 1;
        }

        @Override // java.util.Iterator
        public bj0 next() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww != 0) {
                bj0 bj0Var = this.Wwwwwwwwwwwwwwwwwwwww;
                if (bj0Var == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
                }
                this.Wwwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = -1;
                return bj0Var;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public fk0(CharSequence charSequence, int i, int i2, mh0<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mh0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, "input");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mh0Var, "getNextMatch");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mh0Var;
    }

    @Override // me.tvspark.zj0
    public Iterator<bj0> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
