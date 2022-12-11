package org.fourthline.cling.support.lastchange;

import java.util.Map;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.shared.AbstractMap;

/* loaded from: classes5.dex */
public abstract class EventedValue<V> {
    public final V value;

    public EventedValue(V v) {
        this.value = v;
    }

    public EventedValue(Map.Entry<String, String>[] entryArr) {
        try {
            this.value = valueOf(entryArr);
        } catch (InvalidValueException e) {
            throw new RuntimeException(e);
        }
    }

    public Map.Entry<String, String>[] getAttributes() {
        return new Map.Entry[]{new AbstractMap.SimpleEntry("val", toString())};
    }

    public abstract Datatype getDatatype();

    public String getName() {
        return getClass().getSimpleName();
    }

    public V getValue() {
        return this.value;
    }

    public String toString() {
        return getDatatype().getString(getValue());
    }

    /* renamed from: valueOf */
    public V mo5218valueOf(String str) throws InvalidValueException {
        return (V) getDatatype().mo5215valueOf(str);
    }

    public V valueOf(Map.Entry<String, String>[] entryArr) throws InvalidValueException {
        V v = null;
        for (Map.Entry<String, String> entry : entryArr) {
            if (entry.getKey().equals("val")) {
                v = mo5218valueOf(entry.getValue());
            }
        }
        return v;
    }
}
