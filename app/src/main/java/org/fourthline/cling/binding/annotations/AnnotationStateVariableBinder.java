package org.fourthline.cling.binding.annotations;

import java.util.Set;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.binding.AllowedValueProvider;
import org.fourthline.cling.binding.AllowedValueRangeProvider;
import org.fourthline.cling.binding.LocalServiceBindingException;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.meta.StateVariable;
import org.fourthline.cling.model.meta.StateVariableAllowedValueRange;
import org.fourthline.cling.model.meta.StateVariableEventDetails;
import org.fourthline.cling.model.meta.StateVariableTypeDetails;
import org.fourthline.cling.model.state.StateVariableAccessor;
import org.fourthline.cling.model.types.Datatype;
import org.mozilla.javascript.tools.idswitch.Main;

/* loaded from: classes5.dex */
public class AnnotationStateVariableBinder {
    public static Logger log = Logger.getLogger(AnnotationLocalServiceBinder.class.getName());
    public StateVariableAccessor accessor;
    public UpnpStateVariable annotation;
    public String name;
    public Set<Class> stringConvertibleTypes;

    public AnnotationStateVariableBinder(UpnpStateVariable upnpStateVariable, String str, StateVariableAccessor stateVariableAccessor, Set<Class> set) {
        this.annotation = upnpStateVariable;
        this.name = str;
        this.accessor = stateVariableAccessor;
        this.stringConvertibleTypes = set;
    }

    public Datatype createDatatype() throws LocalServiceBindingException {
        Datatype.Builtin byDescriptorName;
        String datatype = getAnnotation().datatype();
        if (datatype.length() == 0 && getAccessor() != null) {
            Class<?> returnType = getAccessor().getReturnType();
            Logger logger = log;
            logger.finer("Using accessor return type as state variable type: " + returnType);
            if (ModelUtil.isStringConvertibleType(getStringConvertibleTypes(), returnType)) {
                log.finer("Return type is string-convertible, using string datatype");
                byDescriptorName = Datatype.Default.STRING.getBuiltinType();
            } else {
                Datatype.Default byJavaType = Datatype.Default.getByJavaType(returnType);
                if (byJavaType != null) {
                    Logger logger2 = log;
                    logger2.finer("Return type has default UPnP datatype: " + byJavaType);
                    byDescriptorName = byJavaType.getBuiltinType();
                }
            }
            return byDescriptorName.getDatatype();
        }
        if (datatype.length() == 0 && (getAnnotation().allowedValues().length > 0 || getAnnotation().allowedValuesEnum() != Void.TYPE)) {
            log.finer("State variable has restricted allowed values, hence using 'string' datatype");
            datatype = Main.STRING_TAG_STR;
        }
        if (datatype.length() == 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not detect datatype of state variable: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
            throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        Logger logger3 = log;
        logger3.finer("Trying to find built-in UPnP datatype for detected name: " + datatype);
        byDescriptorName = Datatype.Builtin.getByDescriptorName(datatype);
        if (byDescriptorName == null) {
            throw new LocalServiceBindingException("No built-in UPnP datatype found, using CustomDataType (TODO: NOT IMPLEMENTED)");
        }
        Logger logger4 = log;
        logger4.finer("Found built-in UPnP datatype: " + byDescriptorName);
        return byDescriptorName.getDatatype();
    }

    public String createDefaultValue(Datatype datatype) throws LocalServiceBindingException {
        if (getAnnotation().defaultValue().length() != 0) {
            try {
                datatype.mo5215valueOf(getAnnotation().defaultValue());
                Logger logger = log;
                logger.finer("Found state variable default value: " + getAnnotation().defaultValue());
                return getAnnotation().defaultValue();
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Default value doesn't match datatype of state variable '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        return null;
    }

    public StateVariable createStateVariable() throws LocalServiceBindingException {
        String[] strArr;
        int i;
        Class<?> returnType;
        boolean z;
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Creating state variable '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' with accessor: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getAccessor());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        Datatype createDatatype = createDatatype();
        String createDefaultValue = createDefaultValue(createDatatype);
        StateVariableAllowedValueRange stateVariableAllowedValueRange = null;
        int i2 = 0;
        if (Datatype.Builtin.STRING.equals(createDatatype.getBuiltin())) {
            if (getAnnotation().allowedValueProvider() != Void.TYPE) {
                strArr = getAllowedValuesFromProvider();
            } else if (getAnnotation().allowedValues().length > 0) {
                strArr = getAnnotation().allowedValues();
            } else {
                if (getAnnotation().allowedValuesEnum() != Void.TYPE) {
                    returnType = getAnnotation().allowedValuesEnum();
                } else if (getAccessor() == null || !getAccessor().getReturnType().isEnum()) {
                    Logger logger2 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Not restricting allowed values (of string typed state var): ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getName());
                    logger2.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    strArr = null;
                } else {
                    returnType = getAccessor().getReturnType();
                }
                strArr = getAllowedValues(returnType);
            }
            if (strArr != null && createDefaultValue != null) {
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    } else if (strArr[i3].equals(createDefaultValue)) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Default value '", createDefaultValue, "' is not in allowed values of: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
                    throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            }
        } else {
            strArr = null;
        }
        if (Datatype.Builtin.isNumeric(createDatatype.getBuiltin())) {
            if (getAnnotation().allowedValueRangeProvider() != Void.TYPE) {
                stateVariableAllowedValueRange = getAllowedRangeFromProvider();
            } else if (getAnnotation().allowedValueMinimum() > 0 || getAnnotation().allowedValueMaximum() > 0) {
                stateVariableAllowedValueRange = getAllowedValueRange(getAnnotation().allowedValueMinimum(), getAnnotation().allowedValueMaximum(), getAnnotation().allowedValueStep());
            } else {
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Not restricting allowed value range (of numeric typed state var): ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getName());
                logger3.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            }
            if (createDefaultValue != null && stateVariableAllowedValueRange != null) {
                try {
                    if (!stateVariableAllowedValueRange.isInRange(Long.valueOf(createDefaultValue).longValue())) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Default value '", createDefaultValue, "' is not in allowed range of: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getName());
                        throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                } catch (Exception unused) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Default value '", createDefaultValue, "' is not numeric (for range checking) of: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getName());
                    throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                }
            }
        }
        boolean sendEvents = getAnnotation().sendEvents();
        if (sendEvents && getAccessor() == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("State variable sends events but has no accessor for field or getter: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getName());
            throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        }
        if (sendEvents) {
            if (getAnnotation().eventMaximumRateMilliseconds() > 0) {
                Logger logger4 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Moderating state variable events using maximum rate (milliseconds): ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(getAnnotation().eventMaximumRateMilliseconds());
                logger4.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
                i2 = getAnnotation().eventMaximumRateMilliseconds();
            } else {
                i2 = 0;
            }
            if (getAnnotation().eventMinimumDelta() > 0 && Datatype.Builtin.isNumeric(createDatatype.getBuiltin())) {
                Logger logger5 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Moderating state variable events using minimum delta: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(getAnnotation().eventMinimumDelta());
                logger5.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
                i = getAnnotation().eventMinimumDelta();
                return new StateVariable(getName(), new StateVariableTypeDetails(createDatatype, createDefaultValue, strArr, stateVariableAllowedValueRange), new StateVariableEventDetails(sendEvents, i2, i));
            }
        }
        i = 0;
        return new StateVariable(getName(), new StateVariableTypeDetails(createDatatype, createDefaultValue, strArr, stateVariableAllowedValueRange), new StateVariableEventDetails(sendEvents, i2, i));
    }

    public StateVariableAccessor getAccessor() {
        return this.accessor;
    }

    public StateVariableAllowedValueRange getAllowedRangeFromProvider() throws LocalServiceBindingException {
        Class allowedValueRangeProvider = getAnnotation().allowedValueRangeProvider();
        if (AllowedValueRangeProvider.class.isAssignableFrom(allowedValueRangeProvider)) {
            try {
                AllowedValueRangeProvider allowedValueRangeProvider2 = (AllowedValueRangeProvider) allowedValueRangeProvider.newInstance();
                return getAllowedValueRange(allowedValueRangeProvider2.getMinimum(), allowedValueRangeProvider2.getMaximum(), allowedValueRangeProvider2.getStep());
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allowed value range provider can't be instantiated: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
                throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
        }
        throw new LocalServiceBindingException("Allowed value range provider is not of type " + AllowedValueRangeProvider.class + ": " + getName());
    }

    public StateVariableAllowedValueRange getAllowedValueRange(long j, long j2, long j3) throws LocalServiceBindingException {
        if (j2 >= j) {
            return new StateVariableAllowedValueRange(j, j2, j3);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allowed value range maximum is smaller than minimum: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public String[] getAllowedValues(Class cls) throws LocalServiceBindingException {
        if (cls.isEnum()) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Restricting allowed values of state variable to Enum: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
            logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            String[] strArr = new String[cls.getEnumConstants().length];
            for (int i = 0; i < cls.getEnumConstants().length; i++) {
                Object obj = cls.getEnumConstants()[i];
                if (obj.toString().length() > 32) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allowed value string (that is, Enum constant name) is longer than 32 characters: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.toString());
                    throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                }
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Adding allowed value (converted to string): ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(obj.toString());
                logger2.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                strArr[i] = obj.toString();
            }
            return strArr;
        }
        throw new LocalServiceBindingException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allowed values type is not an Enum: ", cls));
    }

    public String[] getAllowedValuesFromProvider() throws LocalServiceBindingException {
        Class allowedValueProvider = getAnnotation().allowedValueProvider();
        if (AllowedValueProvider.class.isAssignableFrom(allowedValueProvider)) {
            try {
                return ((AllowedValueProvider) allowedValueProvider.newInstance()).getValues();
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allowed value provider can't be instantiated: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
                throw new LocalServiceBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
        }
        throw new LocalServiceBindingException("Allowed value provider is not of type " + AllowedValueProvider.class + ": " + getName());
    }

    public UpnpStateVariable getAnnotation() {
        return this.annotation;
    }

    public String getName() {
        return this.name;
    }

    public Set<Class> getStringConvertibleTypes() {
        return this.stringConvertibleTypes;
    }
}
