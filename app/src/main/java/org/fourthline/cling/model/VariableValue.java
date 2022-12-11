package org.fourthline.cling.model;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public class VariableValue {
    public static final Logger log = Logger.getLogger(VariableValue.class.getName());
    public final Datatype datatype;
    public final Object value;

    public VariableValue(Datatype datatype, Object obj) throws InvalidValueException {
        this.datatype = datatype;
        this.value = obj instanceof String ? datatype.mo5215valueOf((String) obj) : obj;
        if (ModelUtil.ANDROID_RUNTIME) {
            return;
        }
        if (getDatatype().isValid(getValue())) {
            logInvalidXML(toString());
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid value for ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDatatype());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(": ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue());
        throw new InvalidValueException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public Datatype getDatatype() {
        return this.datatype;
    }

    public Object getValue() {
        return this.value;
    }

    public void logInvalidXML(String str) {
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 9 && codePointAt != 10 && codePointAt != 13 && ((codePointAt < 32 || codePointAt > 55295) && ((codePointAt < 57344 || codePointAt > 65533) && (codePointAt < 65536 || codePointAt > 1114111)))) {
                Logger logger = log;
                logger.warning("Found invalid XML char code: " + codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    public String toString() {
        return getDatatype().getString(getValue());
    }
}
