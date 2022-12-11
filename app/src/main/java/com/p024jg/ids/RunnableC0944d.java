package com.p024jg.ids;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.d */
/* loaded from: classes6.dex */
public final class RunnableC0944d implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f608a;

    /* renamed from: b */
    private /* synthetic */ AbstractC0932a f609b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0944d(AbstractC0932a abstractC0932a, String str) {
        this.f609b = abstractC0932a;
        this.f608a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f609b.b(this.f608a);
    }
}
