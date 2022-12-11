package org.fourthline.cling.model.types;

import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public interface Datatype<V> {

    /* loaded from: classes5.dex */
    public enum Builtin {
        UI1("ui1", new UnsignedIntegerOneByteDatatype()),
        UI2("ui2", new UnsignedIntegerTwoBytesDatatype()),
        UI4("ui4", new UnsignedIntegerFourBytesDatatype()),
        I1("i1", new IntegerDatatype(1)),
        I2("i2", new IntegerDatatype(2)),
        I2_SHORT("i2", new ShortDatatype()),
        I4("i4", new IntegerDatatype(4)),
        INT(ClassTransform.INTEGER, new IntegerDatatype(4)),
        R4("r4", new FloatDatatype()),
        R8("r8", new DoubleDatatype()),
        NUMBER("number", new DoubleDatatype()),
        FIXED144("fixed.14.4", new DoubleDatatype()),
        FLOAT(ClassTransform.FLOAT, new DoubleDatatype()),
        CHAR(ClassTransform.CHARACTER, new CharacterDatatype()),
        STRING(Main.STRING_TAG_STR, new StringDatatype()),
        DATE("date", new DateTimeDatatype(new String[]{"yyyy-MM-dd"}, "yyyy-MM-dd")),
        DATETIME("dateTime", new DateTimeDatatype(new String[]{"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"}, "yyyy-MM-dd'T'HH:mm:ss")),
        DATETIME_TZ("dateTime.tz", new DateTimeDatatype(new String[]{"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZ"}, "yyyy-MM-dd'T'HH:mm:ssZ")),
        TIME("time", new DateTimeDatatype(new String[]{"HH:mm:ss"}, "HH:mm:ss")),
        TIME_TZ("time.tz", new DateTimeDatatype(new String[]{"HH:mm:ssZ", "HH:mm:ss"}, "HH:mm:ssZ")),
        BOOLEAN(ClassTransform.BOOLEAN, new BooleanDatatype()),
        BIN_BASE64("bin.base64", new Base64Datatype()),
        BIN_HEX("bin.hex", new BinHexDatatype()),
        URI("uri", new URIDatatype()),
        UUID("uuid", new StringDatatype());
        
        public static Map<String, Builtin> byName = new HashMap<String, Builtin>() { // from class: org.fourthline.cling.model.types.Datatype.Builtin.1
            {
                Builtin[] values;
                for (Builtin builtin : Builtin.values()) {
                    if (!containsKey(builtin.getDescriptorName().toLowerCase(Locale.ROOT))) {
                        put(builtin.getDescriptorName().toLowerCase(Locale.ROOT), builtin);
                    }
                }
            }
        };
        public Datatype datatype;
        public String descriptorName;

        Builtin(String str, AbstractDatatype abstractDatatype) {
            abstractDatatype.setBuiltin(this);
            this.descriptorName = str;
            this.datatype = abstractDatatype;
        }

        public static Builtin getByDescriptorName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str.toLowerCase(Locale.ROOT));
        }

        public static boolean isNumeric(Builtin builtin) {
            return builtin != null && (builtin.equals(UI1) || builtin.equals(UI2) || builtin.equals(UI4) || builtin.equals(I1) || builtin.equals(I2) || builtin.equals(I4) || builtin.equals(INT));
        }

        public Datatype getDatatype() {
            return this.datatype;
        }

        public String getDescriptorName() {
            return this.descriptorName;
        }
    }

    /* loaded from: classes5.dex */
    public enum Default {
        BOOLEAN(Boolean.class, Builtin.BOOLEAN),
        BOOLEAN_PRIMITIVE(Boolean.TYPE, Builtin.BOOLEAN),
        SHORT(Short.class, Builtin.I2_SHORT),
        SHORT_PRIMITIVE(Short.TYPE, Builtin.I2_SHORT),
        INTEGER(Integer.class, Builtin.I4),
        INTEGER_PRIMITIVE(Integer.TYPE, Builtin.I4),
        UNSIGNED_INTEGER_ONE_BYTE(UnsignedIntegerOneByte.class, Builtin.UI1),
        UNSIGNED_INTEGER_TWO_BYTES(UnsignedIntegerTwoBytes.class, Builtin.UI2),
        UNSIGNED_INTEGER_FOUR_BYTES(UnsignedIntegerFourBytes.class, Builtin.UI4),
        FLOAT(Float.class, Builtin.R4),
        FLOAT_PRIMITIVE(Float.TYPE, Builtin.R4),
        DOUBLE(Double.class, Builtin.FLOAT),
        DOUBLE_PRIMTIIVE(Double.TYPE, Builtin.FLOAT),
        CHAR(Character.class, Builtin.CHAR),
        CHAR_PRIMITIVE(Character.TYPE, Builtin.CHAR),
        STRING(String.class, Builtin.STRING),
        CALENDAR(Calendar.class, Builtin.DATETIME),
        BYTES(byte[].class, Builtin.BIN_BASE64),
        URI(URI.class, Builtin.URI);
        
        public Builtin builtinType;
        public Class javaType;

        Default(Class cls, Builtin builtin) {
            this.javaType = cls;
            this.builtinType = builtin;
        }

        public static Default getByJavaType(Class cls) {
            Default[] values;
            for (Default r3 : values()) {
                if (r3.getJavaType().equals(cls)) {
                    return r3;
                }
            }
            return null;
        }

        public Builtin getBuiltinType() {
            return this.builtinType;
        }

        public Class getJavaType() {
            return this.javaType;
        }

        @Override // java.lang.Enum
        public String toString() {
            return getJavaType() + " => " + getBuiltinType();
        }
    }

    Builtin getBuiltin();

    String getDisplayString();

    String getString(V v) throws InvalidValueException;

    boolean isHandlingJavaType(Class cls);

    boolean isValid(V v);

    /* renamed from: valueOf */
    V mo5215valueOf(String str) throws InvalidValueException;
}
