package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class ShortDatatype extends AbstractDatatype<Short> {
    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return cls == Short.TYPE || Short.class.isAssignableFrom(cls);
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public Short mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        try {
            Short valueOf = Short.valueOf(Short.parseShort(str.trim()));
            if (isValid(valueOf)) {
                return valueOf;
            }
            throw new InvalidValueException("Not a valid short: " + str);
        } catch (NumberFormatException e) {
            throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't convert string to number: ", str), e);
        }
    }
}
