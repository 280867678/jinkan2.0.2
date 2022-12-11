package com.p024jg.ids.p035k;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.k.b */
/* loaded from: classes6.dex */
public final class C0981b extends ContentObserver {

    /* renamed from: a */
    private String f639a;

    /* renamed from: b */
    private int f640b;

    /* renamed from: c */
    private /* synthetic */ C0980a f641c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0981b(C0980a c0980a, Handler handler, String str, int i) {
        super(null);
        this.f641c = c0980a;
        this.f639a = str;
        this.f640b = i;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        this.f641c.m3724b(this.f640b, this.f639a);
    }
}
