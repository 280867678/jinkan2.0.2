package kotlin.jvm.internal;

import me.tvspark.di0;
import me.tvspark.ij0;
import me.tvspark.jj0;

/* loaded from: classes4.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }

    public MutablePropertyReference2Impl(jj0 jj0Var, String str, String str2) {
        super(((di0) jj0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), str, str2, !(jj0Var instanceof ij0) ? 1 : 0);
    }

    @Override // me.tvspark.sj0
    public Object get(Object obj, Object obj2) {
        return mo4909getGetter().call(obj, obj2);
    }

    public void set(Object obj, Object obj2, Object obj3) {
        mo4905getSetter().call(obj, obj2, obj3);
    }
}
