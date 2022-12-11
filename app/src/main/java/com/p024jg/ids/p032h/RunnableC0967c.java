package com.p024jg.ids.p032h;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.h.c */
/* loaded from: classes6.dex */
final class RunnableC0967c implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f626a;

    /* renamed from: b */
    private /* synthetic */ C0965a f627b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0967c(C0965a c0965a, String str) {
        this.f627b = c0965a;
        this.f626a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f627b.b(this.f626a);
    }
}
