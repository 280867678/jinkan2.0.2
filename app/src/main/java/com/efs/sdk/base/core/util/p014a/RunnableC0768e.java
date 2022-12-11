package com.efs.sdk.base.core.util.p014a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.efs.sdk.base.core.util.a.e */
/* loaded from: classes3.dex */
public class RunnableC0768e<T> implements Runnable {

    /* renamed from: a */
    public List<AbstractC0765b<T>> f319a = new ArrayList(5);

    /* renamed from: b */
    public AbstractC0766c<T> f320b;

    public RunnableC0768e(@NonNull AbstractC0766c<T> abstractC0766c) {
        this.f320b = abstractC0766c;
    }

    /* renamed from: a */
    public final T m4040a() {
        T t = null;
        try {
            Iterator<AbstractC0765b<T>> it = this.f319a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t = this.f320b.mo4020a();
            for (AbstractC0765b<T> abstractC0765b : this.f319a) {
                abstractC0765b.mo4042a(this.f320b, t);
            }
            for (AbstractC0765b<T> abstractC0765b2 : this.f319a) {
                abstractC0765b2.result(t);
            }
        } catch (Throwable th) {
            Log.m4052w("efs.util.concurrent", th);
            Iterator<AbstractC0765b<T>> it2 = this.f319a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        return t;
    }

    /* renamed from: a */
    public final void m4039a(@NonNull List<AbstractC0765b<T>> list) {
        this.f319a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        m4040a();
    }
}
