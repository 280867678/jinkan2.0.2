package org.fourthline.cling.model.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.ServiceReference;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.ServiceType;

/* loaded from: classes5.dex */
public abstract class Service<D extends Device, S extends Service> {
    public static final Logger log = Logger.getLogger(Service.class.getName());
    public final Map<String, Action> actions;
    public D device;
    public final ServiceId serviceId;
    public final ServiceType serviceType;
    public final Map<String, StateVariable> stateVariables;

    public Service(ServiceType serviceType, ServiceId serviceId) throws ValidationException {
        this(serviceType, serviceId, null, null);
    }

    public Service(ServiceType serviceType, ServiceId serviceId, Action<S>[] actionArr, StateVariable<S>[] stateVariableArr) throws ValidationException {
        this.actions = new HashMap();
        this.stateVariables = new HashMap();
        this.serviceType = serviceType;
        this.serviceId = serviceId;
        if (actionArr != null) {
            for (Action<S> action : actionArr) {
                this.actions.put(action.getName(), action);
                action.setService(this);
            }
        }
        if (stateVariableArr != null) {
            for (StateVariable<S> stateVariable : stateVariableArr) {
                this.stateVariables.put(stateVariable.getName(), stateVariable);
                stateVariable.setService(this);
            }
        }
    }

    public Action<S> getAction(String str) {
        Map<String, Action> map = this.actions;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Action<S>[] getActions() {
        Map<String, Action> map = this.actions;
        if (map == null) {
            return null;
        }
        return (Action[]) map.values().toArray(new Action[this.actions.values().size()]);
    }

    public Datatype<S> getDatatype(ActionArgument actionArgument) {
        return getRelatedStateVariable(actionArgument).getTypeDetails().getDatatype();
    }

    public D getDevice() {
        return this.device;
    }

    public abstract Action getQueryStateVariableAction();

    public ServiceReference getReference() {
        return new ServiceReference(getDevice().getIdentity().getUdn(), getServiceId());
    }

    public StateVariable<S> getRelatedStateVariable(ActionArgument actionArgument) {
        return getStateVariable(actionArgument.getRelatedStateVariableName());
    }

    public ServiceId getServiceId() {
        return this.serviceId;
    }

    public ServiceType getServiceType() {
        return this.serviceType;
    }

    public StateVariable<S> getStateVariable(String str) {
        if (QueryStateVariableAction.VIRTUAL_STATEVARIABLE_INPUT.equals(str)) {
            return new StateVariable<>(QueryStateVariableAction.VIRTUAL_STATEVARIABLE_INPUT, new StateVariableTypeDetails(Datatype.Builtin.STRING.getDatatype()));
        }
        if (QueryStateVariableAction.VIRTUAL_STATEVARIABLE_OUTPUT.equals(str)) {
            return new StateVariable<>(QueryStateVariableAction.VIRTUAL_STATEVARIABLE_OUTPUT, new StateVariableTypeDetails(Datatype.Builtin.STRING.getDatatype()));
        }
        Map<String, StateVariable> map = this.stateVariables;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public StateVariable<S>[] getStateVariables() {
        Map<String, StateVariable> map = this.stateVariables;
        if (map == null) {
            return null;
        }
        return (StateVariable[]) map.values().toArray(new StateVariable[this.stateVariables.values().size()]);
    }

    public boolean hasActions() {
        return getActions() != null && getActions().length > 0;
    }

    public boolean hasStateVariables() {
        return getStateVariables() != null && getStateVariables().length > 0;
    }

    public void setDevice(D d) {
        if (this.device == null) {
            this.device = d;
            return;
        }
        throw new IllegalStateException("Final value has been set already, model is immutable");
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ServiceId: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getServiceId());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public List<ValidationError> validate() {
        Action<S>[] actions;
        ArrayList arrayList = new ArrayList();
        if (getServiceType() == null) {
            arrayList.add(new ValidationError(getClass(), "serviceType", "Service type/info is required"));
        }
        if (getServiceId() == null) {
            arrayList.add(new ValidationError(getClass(), "serviceId", "Service ID is required"));
        }
        if (hasStateVariables()) {
            for (StateVariable<S> stateVariable : getStateVariables()) {
                arrayList.addAll(stateVariable.validate());
            }
        }
        if (hasActions()) {
            for (Action<S> action : getActions()) {
                List<ValidationError> validate = action.validate();
                if (validate.size() > 0) {
                    this.actions.remove(action.getName());
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Discarding invalid action of service '");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getServiceId());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(action.getName());
                    logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    for (ValidationError validationError : validate) {
                        Logger logger2 = log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid action '");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(action.getName());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("': ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(validationError);
                        logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                }
            }
        }
        return arrayList;
    }
}
