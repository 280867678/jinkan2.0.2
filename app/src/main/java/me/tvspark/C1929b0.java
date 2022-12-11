package me.tvspark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: me.tvspark.b0 */
/* loaded from: classes4.dex */
public final class C1929b0 implements AbstractC2692v {
    public final Set<AbstractC1930b1<?>> Wwwwwwwwwwwwwwwwwwwwwwww = Collections.newSetFromMap(new WeakHashMap());

    @Override // me.tvspark.AbstractC2692v
    public void onDestroy() {
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            ((AbstractC1930b1) it.next()).onDestroy();
        }
    }

    @Override // me.tvspark.AbstractC2692v
    public void onStart() {
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            ((AbstractC1930b1) it.next()).onStart();
        }
    }

    @Override // me.tvspark.AbstractC2692v
    public void onStop() {
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            ((AbstractC1930b1) it.next()).onStop();
        }
    }
}
