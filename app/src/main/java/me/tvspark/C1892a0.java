package me.tvspark;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: me.tvspark.a0 */
/* loaded from: classes4.dex */
public class C1892a0 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Set<AbstractC2464p0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.newSetFromMap(new WeakHashMap());
    public final List<AbstractC2464p0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2464p0 abstractC2464p0) {
        boolean z = true;
        if (abstractC2464p0 == null) {
            return true;
        }
        boolean remove = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(abstractC2464p0);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(abstractC2464p0) && !remove) {
            z = false;
        }
        if (z) {
            abstractC2464p0.clear();
        }
        return z;
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() + ", isPaused=" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "}";
    }
}
