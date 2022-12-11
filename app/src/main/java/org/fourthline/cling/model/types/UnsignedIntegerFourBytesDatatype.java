package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class UnsignedIntegerFourBytesDatatype extends AbstractDatatype<UnsignedIntegerFourBytes> {
    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public UnsignedIntegerFourBytes mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        try {
            return new UnsignedIntegerFourBytes(str);
        } catch (NumberFormatException e) {
            throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't convert string to number or not in range: ", str), e);
        }
    }
}
