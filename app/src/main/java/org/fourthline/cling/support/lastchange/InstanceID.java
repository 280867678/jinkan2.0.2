package org.fourthline.cling.support.lastchange;

import java.util.ArrayList;
import java.util.List;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;

/* loaded from: classes5.dex */
public class InstanceID {

    /* renamed from: id */
    public UnsignedIntegerFourBytes f4633id;
    public List<EventedValue> values;

    public InstanceID(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        this(unsignedIntegerFourBytes, new ArrayList());
    }

    public InstanceID(UnsignedIntegerFourBytes unsignedIntegerFourBytes, List<EventedValue> list) {
        this.values = new ArrayList();
        this.f4633id = unsignedIntegerFourBytes;
        this.values = list;
    }

    public UnsignedIntegerFourBytes getId() {
        return this.f4633id;
    }

    public List<EventedValue> getValues() {
        return this.values;
    }
}
