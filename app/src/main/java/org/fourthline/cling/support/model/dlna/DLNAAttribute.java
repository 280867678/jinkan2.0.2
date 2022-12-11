package org.fourthline.cling.support.model.dlna;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class DLNAAttribute<T> {
    public static final Logger log = Logger.getLogger(DLNAAttribute.class.getName());
    public T value;

    /* loaded from: classes5.dex */
    public enum Type {
        DLNA_ORG_PN("DLNA.ORG_PN", DLNAProfileAttribute.class),
        DLNA_ORG_OP("DLNA.ORG_OP", DLNAOperationsAttribute.class),
        DLNA_ORG_PS("DLNA.ORG_PS", DLNAPlaySpeedAttribute.class),
        DLNA_ORG_CI("DLNA.ORG_CI", DLNAConversionIndicatorAttribute.class),
        DLNA_ORG_FLAGS("DLNA.ORG_FLAGS", DLNAFlagsAttribute.class);
        
        public static Map<String, Type> byName = new HashMap<String, Type>() { // from class: org.fourthline.cling.support.model.dlna.DLNAAttribute.Type.1
            {
                Type[] values;
                for (Type type : Type.values()) {
                    put(type.getAttributeName().toUpperCase(Locale.ROOT), type);
                }
            }
        };
        public String attributeName;
        public Class<? extends DLNAAttribute>[] attributeTypes;

        @SafeVarargs
        Type(String str, Class... clsArr) {
            this.attributeName = str;
            this.attributeTypes = clsArr;
        }

        public static Type valueOfAttributeName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str.toUpperCase(Locale.ROOT));
        }

        public String getAttributeName() {
            return this.attributeName;
        }

        public Class<? extends DLNAAttribute>[] getAttributeTypes() {
            return this.attributeTypes;
        }
    }

    public static DLNAAttribute newInstance(Type type, String str, String str2) {
        DLNAAttribute dLNAAttribute;
        Exception e;
        DLNAAttribute dLNAAttribute2 = null;
        for (int i = 0; i < type.getAttributeTypes().length && dLNAAttribute2 == null; i++) {
            Class<? extends DLNAAttribute> cls = type.getAttributeTypes()[i];
            try {
                try {
                    log.finest("Trying to parse DLNA '" + type + "' with class: " + cls.getSimpleName());
                    dLNAAttribute = cls.newInstance();
                    if (str != null) {
                        try {
                            dLNAAttribute.setString(str, str2);
                        } catch (Exception e2) {
                            e = e2;
                            log.severe("Error instantiating DLNA attribute of type '" + type + "' with value: " + str);
                            log.log(Level.SEVERE, "Exception root cause: ", Exceptions.unwrap(e));
                            dLNAAttribute2 = dLNAAttribute;
                        }
                    }
                } catch (InvalidDLNAProtocolAttributeException e3) {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid DLNA attribute value for tested type: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getSimpleName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" - ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e3.getMessage());
                    logger.finest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    dLNAAttribute2 = null;
                }
            } catch (Exception e4) {
                dLNAAttribute = dLNAAttribute2;
                e = e4;
            }
            dLNAAttribute2 = dLNAAttribute;
        }
        return dLNAAttribute2;
    }

    public abstract String getString();

    public T getValue() {
        return this.value;
    }

    public abstract void setString(String str, String str2) throws InvalidDLNAProtocolAttributeException;

    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
