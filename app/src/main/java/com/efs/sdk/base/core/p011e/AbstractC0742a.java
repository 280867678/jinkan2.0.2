package com.efs.sdk.base.core.p011e;

import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p011e.p012a.AbstractC0743a;
import com.efs.sdk.base.core.util.Log;

/* renamed from: com.efs.sdk.base.core.e.a */
/* loaded from: classes3.dex */
public abstract class AbstractC0742a {

    /* renamed from: a */
    public AbstractC0743a f285a;

    /* renamed from: a */
    public abstract AbstractC0743a mo4086a();

    /* renamed from: a */
    public final void m4090a(C0739b c0739b) {
        try {
            if (this.f285a == null) {
                synchronized (this) {
                    if (this.f285a == null) {
                        AbstractC0743a mo4086a = mo4086a();
                        this.f285a = mo4086a;
                        if (mo4086a == null) {
                            return;
                        }
                    }
                }
            }
            this.f285a.mo4087a(c0739b);
        } catch (Throwable th) {
            Log.m4065e("efs.processor", "log handle error", th);
        }
    }
}
