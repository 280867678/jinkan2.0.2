package me.tvspark;

/* renamed from: me.tvspark.w1 */
/* loaded from: classes4.dex */
public abstract class AbstractC2734w1 {

    /* renamed from: me.tvspark.w1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2734w1 {
        public volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(null);
        }

        @Override // me.tvspark.AbstractC2734w1
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            throw new IllegalStateException("Already released");
        }
    }

    public /* synthetic */ AbstractC2734w1(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
}
