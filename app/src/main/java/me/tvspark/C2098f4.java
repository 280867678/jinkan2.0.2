package me.tvspark;

import androidx.annotation.Nullable;

/* renamed from: me.tvspark.f4 */
/* loaded from: classes4.dex */
public final class C2098f4 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final C2098f4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2098f4(0, 0);
    public static final C2098f4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        new C2098f4(Long.MAX_VALUE, Long.MAX_VALUE);
        new C2098f4(Long.MAX_VALUE, 0L);
        new C2098f4(0L, Long.MAX_VALUE);
    }

    public C2098f4(long j, long j2) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j >= 0);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 < 0 ? false : z);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2098f4.class != obj.getClass()) {
            return false;
        }
        C2098f4 c2098f4 = (C2098f4) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return (((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + ((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
