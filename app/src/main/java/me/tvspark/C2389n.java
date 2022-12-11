package me.tvspark;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: me.tvspark.n */
/* loaded from: classes4.dex */
public class C2389n implements AbstractC2654u {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Set<AbstractC2692v> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.newSetFromMap(new WeakHashMap());

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            ((AbstractC2692v) it.next()).onStop();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            ((AbstractC2692v) it.next()).onStart();
        }
    }

    @Override // me.tvspark.AbstractC2654u
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2692v abstractC2692v) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(abstractC2692v);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            ((AbstractC2692v) it.next()).onDestroy();
        }
    }

    @Override // me.tvspark.AbstractC2654u
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2692v abstractC2692v) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2692v);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            abstractC2692v.onDestroy();
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            abstractC2692v.onStart();
        } else {
            abstractC2692v.onStop();
        }
    }
}
