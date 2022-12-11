package kotlin.jvm.internal;

import java.io.Serializable;
import me.tvspark.hi0;
import me.tvspark.ii0;
import me.tvspark.ji0;
import me.tvspark.jj0;
import me.tvspark.ki0;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class AdaptedFunctionReference implements hi0, Serializable {
    public final int arity;
    public final int flags;
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public final String signature;

    public AdaptedFunctionReference(int i, Class cls, String str, String str2, int i2) {
        this(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public AdaptedFunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i2 & 1) == 1;
        this.arity = i;
        this.flags = i2 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        return this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.receiver, adaptedFunctionReference.receiver) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature);
    }

    @Override // me.tvspark.hi0
    public int getArity() {
        return this.arity;
    }

    public jj0 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            if (ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                throw null;
            }
            return new ji0(cls, "");
        }
        return ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        if (cls != null) {
            i = cls.hashCode();
        }
        return ((((outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.signature, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.name, (hashCode + i) * 31, 31), 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }
}
