package kotlin.jvm.internal;

import me.tvspark.lj0;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference extends PropertyReference implements lj0 {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
