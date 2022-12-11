package com.p024jg.ids.p032h;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.h.b */
/* loaded from: classes6.dex */
final class RunnableC0966b implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f624a;

    /* renamed from: b */
    private /* synthetic */ C0965a f625b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0966b(C0965a c0965a, String str) {
        this.f625b = c0965a;
        this.f624a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f625b.c(this.f624a);
    }
}
