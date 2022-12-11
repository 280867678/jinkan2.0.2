package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

/* loaded from: classes5.dex */
public class OverrideValue implements Value {
    public final Class type;
    public final Value value;

    public OverrideValue(Value value, Class cls) {
        this.value = value;
        this.type = cls;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public int getLength() {
        return this.value.getLength();
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Object getValue() {
        return this.value.getValue();
    }

    @Override // org.simpleframework.xml.strategy.Value
    public boolean isReference() {
        return this.value.isReference();
    }

    @Override // org.simpleframework.xml.strategy.Value
    public void setValue(Object obj) {
        this.value.setValue(obj);
    }
}
