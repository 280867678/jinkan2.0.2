package kotlin.jvm.internal;

import me.tvspark.hj0;
import me.tvspark.ki0;
import me.tvspark.rj0;

/* loaded from: classes4.dex */
public abstract class PropertyReference1 extends PropertyReference implements rj0 {
    public PropertyReference1() {
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public hj0 computeReflected() {
        if (ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return this;
        }
        throw null;
    }

    @Override // me.tvspark.rj0
    public Object getDelegate(Object obj) {
        return ((rj0) mo4906getReflected()).getDelegate(obj);
    }

    @Override // me.tvspark.rj0
    /* renamed from: getGetter  reason: collision with other method in class */
    public rj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4908getGetter() {
        return ((rj0) mo4906getReflected()).mo4908getGetter();
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public Object mo4916invoke(Object obj) {
        return get(obj);
    }
}
