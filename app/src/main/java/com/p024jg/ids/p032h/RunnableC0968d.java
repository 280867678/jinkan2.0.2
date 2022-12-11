package com.p024jg.ids.p032h;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.h.d */
/* loaded from: classes6.dex */
final class RunnableC0968d implements Runnable {

    /* renamed from: a */
    private /* synthetic */ String f628a;

    /* renamed from: b */
    private /* synthetic */ C0965a f629b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0968d(C0965a c0965a, String str) {
        this.f629b = c0965a;
        this.f628a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f629b.a(this.f628a);
    }
}
