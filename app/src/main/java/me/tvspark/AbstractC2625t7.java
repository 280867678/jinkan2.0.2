package me.tvspark;

import androidx.annotation.Nullable;

/* renamed from: me.tvspark.t7 */
/* loaded from: classes4.dex */
public interface AbstractC2625t7 {

    /* renamed from: me.tvspark.t7$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2625t7 {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 == 0 ? C2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : new C2662u7(0L, j2));
        }

        @Override // me.tvspark.AbstractC2625t7
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2625t7
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2625t7
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }
    }

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.t7$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final C2662u7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2662u7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2662u7 c2662u7) {
            if (c2662u7 != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2662u7;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2662u7;
                return;
            }
            throw null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31);
        }

        public String toString() {
            String sb;
            String valueOf = String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                sb = "";
            } else {
                String valueOf2 = String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 2);
                sb2.append(", ");
                sb2.append(valueOf2);
                sb = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, valueOf.length() + 2));
            sb3.append("[");
            sb3.append(valueOf);
            sb3.append(sb);
            sb3.append("]");
            return sb3.toString();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2662u7 c2662u7, C2662u7 c2662u72) {
            if (c2662u7 != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2662u7;
                if (c2662u72 == null) {
                    throw null;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2662u72;
                return;
            }
            throw null;
        }
    }
}
