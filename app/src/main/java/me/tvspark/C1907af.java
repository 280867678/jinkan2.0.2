package me.tvspark;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.just.agentweb.WebIndicator;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import me.tvspark.AbstractC2624t6;
import me.tvspark.C2356m3;

/* renamed from: me.tvspark.af */
/* loaded from: classes4.dex */
public final class C1907af {
    public AbstractC2470p6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2356m3 c2356m3) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 18) {
            C2739w6 c2739w6 = new C2739w6(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, new C2188hk(C2208i3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, WebIndicator.MAX_UNIFORM_SPEED_DURATION, WebIndicator.MAX_UNIFORM_SPEED_DURATION, false));
            for (Map.Entry<String, String> entry : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                c2739w6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey(), entry.getValue());
            }
            HashMap hashMap = new HashMap();
            UUID uuid = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2699v6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2225ik c2225ik = new C2225ik();
            UUID uuid2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2699v6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            byte[] bArr = null;
            if (uuid2 == null) {
                throw null;
            }
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                boolean z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                boolean z2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection<? extends Number>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                for (int i : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    boolean z3 = true;
                    if (i != 2 && i != 1) {
                        z3 = false;
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z3);
                }
                DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2739w6, hashMap, z, (int[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clone(), z2, c2225ik, 300000L, null);
                byte[] bArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (bArr2 != null) {
                    bArr = Arrays.copyOf(bArr2, bArr2.length);
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(defaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
                defaultDrmSessionManager.Wwwwwwwwwwwww = 0;
                defaultDrmSessionManager.Wwwwwwwwwwww = bArr;
                return defaultDrmSessionManager;
            }
            throw null;
        }
        return C2433o6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
