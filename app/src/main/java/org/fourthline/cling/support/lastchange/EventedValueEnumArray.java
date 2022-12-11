package org.fourthline.cling.support.lastchange;

import java.lang.Enum;
import java.util.Map;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public abstract class EventedValueEnumArray<E extends Enum> extends EventedValue<E[]> {
    public EventedValueEnumArray(E[] eArr) {
        super(eArr);
    }

    public EventedValueEnumArray(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }

    public abstract E[] enumValueOf(String[] strArr);

    @Override // org.fourthline.cling.support.lastchange.EventedValue
    public Datatype getDatatype() {
        return null;
    }

    @Override // org.fourthline.cling.support.lastchange.EventedValue
    public String toString() {
        return ModelUtil.toCommaSeparatedList(getValue());
    }

    @Override // org.fourthline.cling.support.lastchange.EventedValue
    /* renamed from: valueOf  reason: collision with other method in class */
    public E[] mo5218valueOf(String str) throws InvalidValueException {
        return enumValueOf(ModelUtil.fromCommaSeparatedList(str));
    }
}
