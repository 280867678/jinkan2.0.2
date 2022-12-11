package me.tvspark;

import androidx.annotation.Nullable;

/* renamed from: me.tvspark.u7 */
/* loaded from: classes4.dex */
public final class C2662u7 {
    public static final C2662u7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2662u7(0, 0);
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2662u7(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2662u7.class != obj.getClass()) {
            return false;
        }
        C2662u7 c2662u7 = (C2662u7) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return (((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + ((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder sb = new StringBuilder(60);
        sb.append("[timeUs=");
        sb.append(j);
        sb.append(", position=");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, j2, "]");
    }
}
