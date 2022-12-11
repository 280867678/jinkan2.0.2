package org.fourthline.cling.model.types;

/* loaded from: classes5.dex */
public class StringDatatype extends AbstractDatatype<String> {
    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public String mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        return str;
    }
}
