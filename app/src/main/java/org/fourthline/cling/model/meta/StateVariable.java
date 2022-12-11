package org.fourthline.cling.model.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.Validatable;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.Datatype;

/* loaded from: classes5.dex */
public class StateVariable<S extends Service> implements Validatable {
    public static final Logger log = Logger.getLogger(StateVariable.class.getName());
    public final StateVariableEventDetails eventDetails;
    public final String name;
    public S service;
    public final StateVariableTypeDetails type;

    public StateVariable(String str, StateVariableTypeDetails stateVariableTypeDetails) {
        this(str, stateVariableTypeDetails, new StateVariableEventDetails());
    }

    public StateVariable(String str, StateVariableTypeDetails stateVariableTypeDetails, StateVariableEventDetails stateVariableEventDetails) {
        this.name = str;
        this.type = stateVariableTypeDetails;
        this.eventDetails = stateVariableEventDetails;
    }

    public StateVariable<S> deepCopy() {
        return new StateVariable<>(getName(), getTypeDetails(), getEventDetails());
    }

    public StateVariableEventDetails getEventDetails() {
        return this.eventDetails;
    }

    public String getName() {
        return this.name;
    }

    public S getService() {
        return this.service;
    }

    public StateVariableTypeDetails getTypeDetails() {
        return this.type;
    }

    public boolean isModeratedNumericType() {
        return Datatype.Builtin.isNumeric(getTypeDetails().getDatatype().getBuiltin()) && getEventDetails().getEventMinimumDelta() > 0;
    }

    public void setService(S s) {
        if (this.service == null) {
            this.service = s;
            return;
        }
        throw new IllegalStateException("Final value has been set already, model is immutable");
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StateVariable.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Name: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Type: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getTypeDetails().getDatatype().getDisplayString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        if (!getEventDetails().isSendEvents()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (No Events)");
        }
        if (getTypeDetails().getDefaultValue() != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Default Value: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getTypeDetails().getDefaultValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
        }
        if (getTypeDetails().getAllowedValues() != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Allowed Values: ");
            for (String str : getTypeDetails().getAllowedValues()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("|");
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getName() == null || getName().length() == 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("StateVariable without name of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getService());
            arrayList.add(new ValidationError(StateVariable.class, "name", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
        } else if (!ModelUtil.isValidUDAName(getName())) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getService().getDevice());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            Logger logger2 = log;
            logger2.warning("Invalid state variable name: " + this);
        }
        arrayList.addAll(getTypeDetails().validate());
        return arrayList;
    }
}
