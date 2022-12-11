package org.fourthline.cling.model.types;

import java.util.Locale;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class BooleanDatatype extends AbstractDatatype<Boolean> {
    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public String getString(Boolean bool) throws InvalidValueException {
        return bool == null ? "" : bool.booleanValue() ? "1" : "0";
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return cls == Boolean.TYPE || Boolean.class.isAssignableFrom(cls);
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf */
    public Boolean mo5215valueOf(String str) throws InvalidValueException {
        boolean z;
        if (str.equals("")) {
            return null;
        }
        if (str.equals("1") || str.toUpperCase(Locale.ROOT).equals("YES") || str.toUpperCase(Locale.ROOT).equals("TRUE")) {
            z = true;
        } else if (!str.equals("0") && !str.toUpperCase(Locale.ROOT).equals("NO") && !str.toUpperCase(Locale.ROOT).equals("FALSE")) {
            throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid boolean value string: ", str));
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
