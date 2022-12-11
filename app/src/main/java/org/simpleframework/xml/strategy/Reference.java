package org.simpleframework.xml.strategy;

/* loaded from: classes5.dex */
public class Reference implements Value {
    public Class type;
    public Object value;

    public Reference(Object obj, Class cls) {
        this.value = obj;
        this.type = cls;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public int getLength() {
        return 0;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Object getValue() {
        return this.value;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public boolean isReference() {
        return true;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public void setValue(Object obj) {
        this.value = obj;
    }
}
