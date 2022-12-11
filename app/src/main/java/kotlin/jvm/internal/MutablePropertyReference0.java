package kotlin.jvm.internal;

import me.tvspark.hj0;
import me.tvspark.ki0;
import me.tvspark.mj0;
import me.tvspark.qj0;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements mj0 {
    public MutablePropertyReference0() {
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
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
        return ((mj0) mo4906getReflected()).getDelegate();
    }

    @Override // me.tvspark.qj0
    /* renamed from: getGetter  reason: collision with other method in class */
    public qj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4907getGetter() {
        return ((mj0) mo4906getReflected()).mo4907getGetter();
    }

    @Override // me.tvspark.mj0
    /* renamed from: getSetter  reason: collision with other method in class */
    public mj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4901getSetter() {
        return ((mj0) mo4906getReflected()).mo4901getSetter();
    }

    @Override // me.tvspark.xg0
    /* renamed from: invoke */
    public Object mo4969invoke() {
        return get();
    }
}
