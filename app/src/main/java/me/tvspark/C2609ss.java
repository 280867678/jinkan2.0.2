package me.tvspark;

/* renamed from: me.tvspark.ss */
/* loaded from: classes4.dex */
public class C2609ss {
    public static final AbstractC2572rs Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final AbstractC2572rs Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final AbstractC2572rs Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final AbstractC2572rs Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2572rs {
        @Override // me.tvspark.AbstractC2572rs
        public C2646ts Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f3, f2, 0.35f, f2);
            return C2646ts.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255, 0, f2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f), C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 255, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f3, f));
        }
    }

    /* renamed from: me.tvspark.ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2572rs {
        @Override // me.tvspark.AbstractC2572rs
        public C2646ts Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
            return C2646ts.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255, 0, f2, f3, f), C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 255, f2, f3, f));
        }
    }

    /* renamed from: me.tvspark.ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2572rs {
        @Override // me.tvspark.AbstractC2572rs
        public C2646ts Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
            return C2646ts.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255, 0, f2, f3, f), 255);
        }
    }

    /* renamed from: me.tvspark.ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2572rs {
        @Override // me.tvspark.AbstractC2572rs
        public C2646ts Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
            return new C2646ts(255, C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 255, f2, f3, f), true);
        }
    }

    public static AbstractC2572rs Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        if (i == 0) {
            return z ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (i == 1) {
            return z ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (i == 2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid fade mode: ", i));
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}
