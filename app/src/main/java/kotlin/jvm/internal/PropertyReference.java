package kotlin.jvm.internal;

import me.tvspark.hj0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.pj0;

/* loaded from: classes4.dex */
public abstract class PropertyReference extends CallableReference implements pj0 {
    public PropertyReference() {
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getBoundReceiver(), propertyReference.getBoundReceiver());
        } else if (!(obj instanceof pj0)) {
            return false;
        } else {
            return obj.equals(compute());
        }
    }

    @Override // kotlin.jvm.internal.CallableReference
    /* renamed from: getReflected  reason: collision with other method in class */
    public pj0 mo4906getReflected() {
        return (pj0) super.mo4906getReflected();
    }

    public int hashCode() {
        int hashCode = getName().hashCode();
        return getSignature().hashCode() + ((hashCode + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // me.tvspark.pj0
    public boolean isConst() {
        return mo4906getReflected().isConst();
    }

    @Override // me.tvspark.pj0
    public boolean isLateinit() {
        return mo4906getReflected().isLateinit();
    }

    public String toString() {
        hj0 compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("property ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (Kotlin reflection is not available)");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
