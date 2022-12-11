package kotlin.jvm.internal;

import me.tvspark.hi0;
import me.tvspark.hj0;
import me.tvspark.ii0;
import me.tvspark.ki0;
import me.tvspark.kj0;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class FunctionReference extends CallableReference implements hi0, kj0 {
    public final int arity;
    public final int flags;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public hj0 computeReflected() {
        if (ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return this;
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getOwner(), functionReference.getOwner()) && getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getBoundReceiver(), functionReference.getBoundReceiver());
        } else if (!(obj instanceof kj0)) {
            return false;
        } else {
            return obj.equals(compute());
        }
    }

    @Override // me.tvspark.hi0
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.CallableReference
    /* renamed from: getReflected  reason: collision with other method in class */
    public kj0 mo4906getReflected() {
        return (kj0) super.mo4906getReflected();
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // me.tvspark.kj0
    public boolean isExternal() {
        return mo4906getReflected().isExternal();
    }

    @Override // me.tvspark.kj0
    public boolean isInfix() {
        return mo4906getReflected().isInfix();
    }

    @Override // me.tvspark.kj0
    public boolean isInline() {
        return mo4906getReflected().isInline();
    }

    @Override // me.tvspark.kj0
    public boolean isOperator() {
        return mo4906getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, me.tvspark.hj0
    public boolean isSuspend() {
        return mo4906getReflected().isSuspend();
    }

    public String toString() {
        hj0 compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("function ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (Kotlin reflection is not available)");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
