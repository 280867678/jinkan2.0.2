package org.fourthline.cling.support.lastchange;

import java.util.Map;
import org.fourthline.cling.model.types.Datatype;

/* loaded from: classes5.dex */
public class EventedValueString extends EventedValue<String> {
    public EventedValueString(String str) {
        super(str);
    }

    public EventedValueString(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }

    @Override // org.fourthline.cling.support.lastchange.EventedValue
    public Datatype getDatatype() {
        return Datatype.Builtin.STRING.getDatatype();
    }
}
