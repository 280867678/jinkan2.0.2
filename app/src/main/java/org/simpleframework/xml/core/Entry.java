package org.simpleframework.xml.core;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;

/* loaded from: classes5.dex */
public class Entry {
    public static final String DEFAULT_NAME = "entry";
    public boolean attribute;
    public Contact contact;
    public String entry;
    public String key;
    public Class keyType;
    public ElementMap label;
    public String value;
    public Class valueType;

    public Entry(Contact contact, ElementMap elementMap) {
        this.attribute = elementMap.attribute();
        this.entry = elementMap.entry();
        this.value = elementMap.value();
        this.key = elementMap.key();
        this.contact = contact;
        this.label = elementMap;
    }

    private Class getDependent(int i) throws Exception {
        Class[] dependents = this.contact.getDependents();
        return (dependents.length >= i && dependents.length != 0) ? dependents[i] : Object.class;
    }

    private boolean isEmpty(String str) {
        return str.length() == 0;
    }

    public Contact getContact() {
        return this.contact;
    }

    public String getEntry() throws Exception {
        String str = this.entry;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.entry = DEFAULT_NAME;
        }
        return this.entry;
    }

    public String getKey() throws Exception {
        String str = this.key;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.key = null;
        }
        return this.key;
    }

    public Converter getKey(Context context) throws Exception {
        Type keyType = getKeyType();
        return context.isPrimitive(keyType) ? new PrimitiveKey(context, this, keyType) : new CompositeKey(context, this, keyType);
    }

    public Type getKeyType() throws Exception {
        if (this.keyType == null) {
            Class keyType = this.label.keyType();
            this.keyType = keyType;
            if (keyType == Void.TYPE) {
                this.keyType = getDependent(0);
            }
        }
        return new ClassType(this.keyType);
    }

    public String getValue() throws Exception {
        String str = this.value;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.value = null;
        }
        return this.value;
    }

    public Converter getValue(Context context) throws Exception {
        Type valueType = getValueType();
        return context.isPrimitive(valueType) ? new PrimitiveValue(context, this, valueType) : new CompositeValue(context, this, valueType);
    }

    public Type getValueType() throws Exception {
        if (this.valueType == null) {
            Class valueType = this.label.valueType();
            this.valueType = valueType;
            if (valueType == Void.TYPE) {
                this.valueType = getDependent(1);
            }
        }
        return new ClassType(this.valueType);
    }

    public boolean isAttribute() {
        return this.attribute;
    }

    public boolean isInline() throws Exception {
        return isAttribute();
    }

    public String toString() {
        return String.format("%s on %s", this.label, this.contact);
    }
}
