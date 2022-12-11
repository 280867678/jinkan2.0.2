package kotlin.jvm.internal;

import me.tvspark.hj0;
import me.tvspark.ki0;
import me.tvspark.qj0;

/* loaded from: classes4.dex */
public abstract class PropertyReference0 extends PropertyReference implements qj0 {
    public PropertyReference0() {
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public hj0 computeReflected() {
        if (ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return this;
        }
        throw null;
    }

    @Override // me.tvspark.qj0
    public Object getDelegate() {
        return ((qj0) mo4906getReflected()).getDelegate();
    }

    @Override // me.tvspark.qj0
    /* renamed from: getGetter  reason: collision with other method in class */
    public qj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4907getGetter() {
        return ((qj0) mo4906getReflected()).mo4907getGetter();
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke */
    public Object mo4969invoke() {
        return get();
    }
}
