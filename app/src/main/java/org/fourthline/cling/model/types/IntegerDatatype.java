package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class IntegerDatatype extends AbstractDatatype<Integer> {
    public int byteSize;

    public IntegerDatatype(int i) {
        this.byteSize = i;
    }

    public int getByteSize() {
        return this.byteSize;
    }

    public int getMaxValue() {
        int byteSize = getByteSize();
        if (byteSize != 1) {
            if (byteSize == 2) {
                return 32767;
            }
            if (byteSize == 4) {
                return Integer.MAX_VALUE;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid integer byte size: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getByteSize());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return 127;
    }

    public int getMinValue() {
        int byteSize = getByteSize();
        if (byteSize != 1) {
            if (byteSize == 2) {
                return -32768;
            }
            if (byteSize == 4) {
                return Integer.MIN_VALUE;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid integer byte size: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getByteSize());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return -128;
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return cls == Integer.TYPE || Integer.class.isAssignableFrom(cls);
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public boolean isValid(Integer num) {
        return num == null || (num.intValue() >= getMinValue() && num.intValue() <= getMaxValue());
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf */
    public Integer mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        try {
            Integer valueOf = Integer.valueOf(Integer.parseInt(str.trim()));
            if (isValid(valueOf)) {
                return valueOf;
            }
            throw new InvalidValueException("Not a " + getByteSize() + " byte(s) integer: " + str);
        } catch (NumberFormatException e) {
            if (!str.equals("NOT_IMPLEMENTED")) {
                throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't convert string to number: ", str), e);
            }
            return Integer.valueOf(getMaxValue());
        }
    }
}
