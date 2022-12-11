package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* loaded from: classes4.dex */
public class Lllllll<A, B> {
    public final C2465p1<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<A>, B> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<A> {
        public static final Queue<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        public A Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public static <A> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<A> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(A a, int i, int i2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<A> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<A>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2465p1<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<A>, B> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Lllllll lllllll, long j) {
            super(j);
        }

        @Override // me.tvspark.C2465p1
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, @Nullable Object obj2) {
            ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public Lllllll(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
    }
}
