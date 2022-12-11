package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

/* loaded from: classes5.dex */
public class ObjectInstance implements Instance {
    public final Context context;
    public final Class type;
    public final Value value;

    public ObjectInstance(Context context, Value value) {
        this.type = value.getType();
        this.context = context;
        this.value = value;
    }

    @Override // org.simpleframework.xml.core.Instance
    public Object getInstance() throws Exception {
        if (this.value.isReference()) {
            return this.value.getValue();
        }
        Object objectInstance = getInstance(this.type);
        Value value = this.value;
        if (value != null) {
            value.setValue(objectInstance);
        }
        return objectInstance;
    }

    public Object getInstance(Class cls) throws Exception {
        return this.context.getInstance(cls).getInstance();
    }

    @Override // org.simpleframework.xml.core.Instance
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Instance
    public boolean isReference() {
        return this.value.isReference();
    }

    @Override // org.simpleframework.xml.core.Instance
    public Object setInstance(Object obj) {
        Value value = this.value;
        if (value != null) {
            value.setValue(obj);
        }
        return obj;
    }
}
