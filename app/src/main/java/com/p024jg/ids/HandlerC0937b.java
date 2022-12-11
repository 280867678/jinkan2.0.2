package com.p024jg.ids;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.b */
/* loaded from: classes6.dex */
public final class HandlerC0937b extends Handler {

    /* renamed from: a */
    private /* synthetic */ AbstractC0932a f603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0937b(AbstractC0932a abstractC0932a, Looper looper) {
        super(looper);
        this.f603a = abstractC0932a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            this.f603a.mo3709a(message);
        } catch (Throwable th) {
        }
    }
}
