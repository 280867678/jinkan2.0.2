package kotlin.jvm.internal;

import me.tvspark.di0;
import me.tvspark.ij0;
import me.tvspark.jj0;

/* loaded from: classes4.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        super(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(i, obj, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, jj0 jj0Var, String str, String str2) {
        super(i, CallableReference.NO_RECEIVER, ((di0) jj0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), str, str2, !(jj0Var instanceof ij0) ? 1 : 0);
    }
}
