package me.tvspark;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import me.tvspark.AbstractC2116fm;

/* renamed from: me.tvspark.fm */
/* loaded from: classes4.dex */
public interface AbstractC2116fm {

    /* renamed from: me.tvspark.fm$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public final AbstractC2116fm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Handler handler, @Nullable AbstractC2116fm abstractC2116fm) {
            if (abstractC2116fm == null) {
                handler = null;
            } else if (handler == null) {
                throw null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2116fm;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final int i, final int i2, final int i3, final float f) {
            Handler handler = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (handler != null) {
                handler.post(new Runnable() { // from class: me.tvspark.tl
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, i3, f);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, float f) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.onVideoSizeChanged(i, i2, i3, f);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Surface surface) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surface);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, long j2) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, j, j2);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5) {
            c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractC2116fm abstractC2116fm = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2116fm);
            abstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Surface surface);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, long j2);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);

    void onVideoSizeChanged(int i, int i2, int i3, float f);
}
