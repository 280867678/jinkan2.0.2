package org.fourthline.cling.model.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.Validatable;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.Service;

/* loaded from: classes5.dex */
public class Action<S extends Service> implements Validatable {
    public static final Logger log = Logger.getLogger(Action.class.getName());
    public final ActionArgument[] arguments;
    public final ActionArgument[] inputArguments;
    public final String name;
    public final ActionArgument[] outputArguments;
    public S service;

    public Action(String str, ActionArgument[] actionArgumentArr) {
        this.name = str;
        if (actionArgumentArr == null) {
            this.arguments = new ActionArgument[0];
            this.inputArguments = new ActionArgument[0];
            this.outputArguments = new ActionArgument[0];
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ActionArgument actionArgument : actionArgumentArr) {
            actionArgument.setAction(this);
            if (actionArgument.getDirection().equals(ActionArgument.Direction.IN)) {
                arrayList.add(actionArgument);
            }
            if (actionArgument.getDirection().equals(ActionArgument.Direction.OUT)) {
                arrayList2.add(actionArgument);
            }
        }
        this.arguments = actionArgumentArr;
        this.inputArguments = (ActionArgument[]) arrayList.toArray(new ActionArgument[arrayList.size()]);
        this.outputArguments = (ActionArgument[]) arrayList2.toArray(new ActionArgument[arrayList2.size()]);
    }

    public Action<S> deepCopy() {
        ActionArgument[] actionArgumentArr = new ActionArgument[getArguments().length];
        for (int i = 0; i < getArguments().length; i++) {
            actionArgumentArr[i] = getArguments()[i].deepCopy();
        }
        return new Action<>(getName(), actionArgumentArr);
    }

    public ActionArgument[] getArguments() {
        return this.arguments;
    }

    public ActionArgument<S> getFirstInputArgument() {
        if (hasInputArguments()) {
            return getInputArguments()[0];
        }
        throw new IllegalStateException("No input arguments: " + this);
    }

    public ActionArgument<S> getFirstOutputArgument() {
        if (hasOutputArguments()) {
            return getOutputArguments()[0];
        }
        throw new IllegalStateException("No output arguments: " + this);
    }

    public ActionArgument<S> getInputArgument(String str) {
        ActionArgument<S>[] inputArguments;
        for (ActionArgument<S> actionArgument : getInputArguments()) {
            if (actionArgument.isNameOrAlias(str)) {
                return actionArgument;
            }
        }
        return null;
    }

    public ActionArgument<S>[] getInputArguments() {
        return this.inputArguments;
    }

    public String getName() {
        return this.name;
    }

    public ActionArgument<S> getOutputArgument(String str) {
        ActionArgument<S>[] outputArguments;
        for (ActionArgument<S> actionArgument : getOutputArguments()) {
            if (actionArgument.getName().equals(str)) {
                return actionArgument;
            }
        }
        return null;
    }

    public ActionArgument<S>[] getOutputArguments() {
        return this.outputArguments;
    }

    public S getService() {
        return this.service;
    }

    public boolean hasArguments() {
        return getArguments() != null && getArguments().length > 0;
    }

    public boolean hasInputArguments() {
        return getInputArguments() != null && getInputArguments().length > 0;
    }

    public boolean hasOutputArguments() {
        return getOutputArguments() != null && getOutputArguments().length > 0;
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
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Arguments: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getArguments() != null ? Integer.valueOf(getArguments().length) : "NO ARGS");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.Validatable
    public List<ValidationError> validate() {
        ActionArgument[] arguments;
        ActionArgument[] arguments2;
        ArrayList arrayList = new ArrayList();
        if (getName() == null || getName().length() == 0) {
            Class<?> cls = getClass();
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Action without name of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getService());
            arrayList.add(new ValidationError(cls, "name", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
        } else if (!ModelUtil.isValidUDAName(getName())) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getService().getDevice());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            log.warning("Invalid action name: " + this);
        }
        for (ActionArgument actionArgument : getArguments()) {
            if (getService().getStateVariable(actionArgument.getRelatedStateVariableName()) == null) {
                Class<?> cls2 = getClass();
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Action argument references an unknown state variable: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(actionArgument.getRelatedStateVariableName());
                arrayList.add(new ValidationError(cls2, "arguments", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString()));
            }
        }
        ActionArgument actionArgument2 = null;
        int i = 0;
        int i2 = 0;
        for (ActionArgument actionArgument3 : getArguments()) {
            if (actionArgument3.isReturnValue()) {
                if (actionArgument3.getDirection() == ActionArgument.Direction.IN) {
                    Logger logger2 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of :");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getService().getDevice());
                    logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                    log.warning("Input argument can not have <retval/>");
                } else {
                    if (actionArgument2 != null) {
                        Logger logger3 = log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(getService().getDevice());
                        logger3.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
                        Logger logger4 = log;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Only one argument of action '");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(getName());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append("' can be <retval/>");
                        logger4.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
                    }
                    i2 = i;
                    actionArgument2 = actionArgument3;
                }
            }
            i++;
        }
        if (actionArgument2 != null) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (getArguments()[i3].getDirection() == ActionArgument.Direction.OUT) {
                    Logger logger5 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(getService().getDevice());
                    logger5.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString());
                    Logger logger6 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Argument '");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(actionArgument2.getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append("' of action '");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append("' is <retval/> but not the first OUT argument");
                    logger6.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString());
                }
            }
        }
        for (ActionArgument actionArgument4 : this.arguments) {
            arrayList.addAll(actionArgument4.validate());
        }
        return arrayList;
    }
}
