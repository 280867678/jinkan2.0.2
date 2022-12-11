package com.p024jg.ids;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.e */
/* loaded from: classes6.dex */
public final class RunnableC0949e implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f611a;

    /* renamed from: b */
    private /* synthetic */ AbstractC0932a f612b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0949e(AbstractC0932a abstractC0932a, String str) {
        this.f612b = abstractC0932a;
        this.f611a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f612b.a(this.f611a);
    }
}
