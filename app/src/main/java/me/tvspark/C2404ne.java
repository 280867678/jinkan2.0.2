package me.tvspark;

/* renamed from: me.tvspark.ne */
/* loaded from: classes4.dex */
public class C2404ne implements AbstractC2220if {
    public final AbstractC2220if[] Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2404ne(AbstractC2220if[] abstractC2220ifArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2220ifArr;
    }

    @Override // me.tvspark.AbstractC2220if
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = Long.MAX_VALUE;
        for (AbstractC2220if abstractC2220if : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != Long.MIN_VALUE) {
                j = Math.min(j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // me.tvspark.AbstractC2220if
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = Long.MAX_VALUE;
        for (AbstractC2220if abstractC2220if : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != Long.MIN_VALUE) {
                j = Math.min(j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // me.tvspark.AbstractC2220if
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        for (AbstractC2220if abstractC2220if : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            abstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        }
    }

    @Override // me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        for (AbstractC2220if abstractC2220if : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (abstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return true;
            }
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2220if
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        AbstractC2220if[] abstractC2220ifArr;
        boolean z;
        boolean z2 = false;
        do {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (AbstractC2220if abstractC2220if : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                boolean z3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != Long.MIN_VALUE && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= j;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z3) {
                    z |= abstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
