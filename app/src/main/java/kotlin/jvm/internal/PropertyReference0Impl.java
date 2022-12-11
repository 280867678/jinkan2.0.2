package kotlin.jvm.internal;

import me.tvspark.di0;
import me.tvspark.ij0;
import me.tvspark.jj0;

/* loaded from: classes4.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public PropertyReference0Impl(jj0 jj0Var, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((di0) jj0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), str, str2, !(jj0Var instanceof ij0) ? 1 : 0);
    }

    @Override // me.tvspark.qj0
    public Object get() {
        return mo4907getGetter().call(new Object[0]);
    }
}
