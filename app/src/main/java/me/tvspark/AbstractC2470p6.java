package me.tvspark;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import me.tvspark.AbstractC2396n6;

/* renamed from: me.tvspark.p6 */
/* loaded from: classes4.dex */
public interface AbstractC2470p6 {
    public static final AbstractC2470p6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.p6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2470p6 {
        @Override // me.tvspark.AbstractC2470p6
        @Nullable
        public DrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper, @Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2245j3 c2245j3) {
            if (c2245j3.Wwwwwwwwww == null) {
                return null;
            }
            return new C2550r6(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }

        @Override // me.tvspark.AbstractC2470p6
        @Nullable
        public Class<C2813y6> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            if (c2245j3.Wwwwwwwwww != null) {
                return C2813y6.class;
            }
            return null;
        }

        @Override // me.tvspark.AbstractC2470p6
        public /* synthetic */ void prepare() {
            C2433o6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // me.tvspark.AbstractC2470p6
        public /* synthetic */ void release() {
            C2433o6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    @Nullable
    DrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper, @Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2245j3 c2245j3);

    @Nullable
    Class<? extends AbstractC2587s6> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);

    void prepare();

    void release();
}
