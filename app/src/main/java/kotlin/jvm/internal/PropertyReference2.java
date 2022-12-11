package kotlin.jvm.internal;

import me.tvspark.hj0;
import me.tvspark.ki0;
import me.tvspark.sj0;

/* loaded from: classes4.dex */
public abstract class PropertyReference2 extends PropertyReference implements sj0 {
    public PropertyReference2() {
    }

    public PropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public hj0 computeReflected() {
        if (ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return this;
        }
        throw null;
    }

    @Override // me.tvspark.sj0
    public Object getDelegate(Object obj, Object obj2) {
        return ((sj0) mo4906getReflected()).getDelegate(obj, obj2);
    }

    @Override // me.tvspark.sj0
    /* renamed from: getGetter  reason: collision with other method in class */
    public sj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4909getGetter() {
        return ((sj0) mo4906getReflected()).mo4909getGetter();
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public Object mo4918invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }
}
