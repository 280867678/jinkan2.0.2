package com.p024jg.ids;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.c */
/* loaded from: classes6.dex */
public final class RunnableC0942c implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f605a;

    /* renamed from: b */
    private /* synthetic */ AbstractC0932a f606b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0942c(AbstractC0932a abstractC0932a, String str) {
        this.f606b = abstractC0932a;
        this.f605a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f606b.c(this.f605a);
    }
}
