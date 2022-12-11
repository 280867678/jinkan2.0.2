package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class CustomDatatype extends AbstractDatatype<String> {
    public String name;

    public CustomDatatype(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(CustomDatatype.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public String mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        return str;
    }
}
