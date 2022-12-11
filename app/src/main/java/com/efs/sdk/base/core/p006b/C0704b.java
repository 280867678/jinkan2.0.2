package com.efs.sdk.base.core.p006b;

import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.efs.sdk.base.core.b.b */
/* loaded from: classes3.dex */
public final class C0704b {

    /* renamed from: a */
    public ConcurrentHashMap<Byte, AbstractC0708e> f190a = new ConcurrentHashMap<>();

    @Nullable
    /* renamed from: a */
    public final AbstractC0708e m4162a(byte b) {
        ConcurrentHashMap<Byte, AbstractC0708e> concurrentHashMap;
        Byte valueOf;
        AbstractC0708e handlerC0710g;
        if (!this.f190a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                concurrentHashMap = this.f190a;
                valueOf = Byte.valueOf(b);
                handlerC0710g = new HandlerC0710g();
            } else if (b != 2) {
                Log.m4054w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
            } else {
                concurrentHashMap = this.f190a;
                valueOf = Byte.valueOf(b);
                handlerC0710g = new C0707d();
            }
            concurrentHashMap.putIfAbsent(valueOf, handlerC0710g);
        }
        return this.f190a.get(Byte.valueOf(b));
    }
}
