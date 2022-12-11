package me.tvspark;

/* loaded from: classes4.dex */
public final class jf0 implements Comparable<jf0> {
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // java.lang.Comparable
    public int compareTo(jf0 jf0Var) {
        long j = jf0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        throw null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof jf0) && this.Wwwwwwwwwwwwwwwwwwwwwwww == ((jf0) obj).Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (j >= 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
            String l = Long.toString(j, 10);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l, "java.lang.Long.toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = 10;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
        String l2 = Long.toString(j3, 10);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l2);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
        String l3 = Long.toString(j4, 10);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
