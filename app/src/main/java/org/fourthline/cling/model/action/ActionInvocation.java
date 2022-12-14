package org.fourthline.cling.model.action;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.outline;
import org.fourthline.cling.model.meta.Action;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.profile.ClientInfo;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public class ActionInvocation<S extends Service> {
    public final Action<S> action;
    public final ClientInfo clientInfo;
    public ActionException failure;
    public Map<String, ActionArgumentValue<S>> input;
    public Map<String, ActionArgumentValue<S>> output;

    public ActionInvocation(ActionException actionException) {
        this.input = new LinkedHashMap();
        this.output = new LinkedHashMap();
        this.failure = null;
        this.action = null;
        this.input = null;
        this.output = null;
        this.failure = actionException;
        this.clientInfo = null;
    }

    public ActionInvocation(Action<S> action) {
        this(action, null, null, null);
    }

    public ActionInvocation(Action<S> action, ClientInfo clientInfo) {
        this(action, null, null, clientInfo);
    }

    public ActionInvocation(Action<S> action, ActionArgumentValue<S>[] actionArgumentValueArr) {
        this(action, actionArgumentValueArr, null, null);
    }

    public ActionInvocation(Action<S> action, ActionArgumentValue<S>[] actionArgumentValueArr, ClientInfo clientInfo) {
        this(action, actionArgumentValueArr, null, clientInfo);
    }

    public ActionInvocation(Action<S> action, ActionArgumentValue<S>[] actionArgumentValueArr, ActionArgumentValue<S>[] actionArgumentValueArr2) {
        this(action, actionArgumentValueArr, actionArgumentValueArr2, null);
    }

    public ActionInvocation(Action<S> action, ActionArgumentValue<S>[] actionArgumentValueArr, ActionArgumentValue<S>[] actionArgumentValueArr2, ClientInfo clientInfo) {
        this.input = new LinkedHashMap();
        this.output = new LinkedHashMap();
        this.failure = null;
        if (action != null) {
            this.action = action;
            setInput(actionArgumentValueArr);
            setOutput(actionArgumentValueArr2);
            this.clientInfo = clientInfo;
            return;
        }
        throw new IllegalArgumentException("Action can not be null");
    }

    public Action<S> getAction() {
        return this.action;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public ActionException getFailure() {
        return this.failure;
    }

    public ActionArgumentValue<S> getInput(String str) {
        return getInput(getInputArgument(str));
    }

    public ActionArgumentValue<S> getInput(ActionArgument<S> actionArgument) {
        return this.input.get(actionArgument.getName());
    }

    public ActionArgumentValue<S>[] getInput() {
        return (ActionArgumentValue[]) this.input.values().toArray(new ActionArgumentValue[this.input.size()]);
    }

    public ActionArgument<S> getInputArgument(String str) {
        ActionArgument<S> inputArgument = getAction().getInputArgument(str);
        if (inputArgument != null) {
            return inputArgument;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Argument not found: ", str));
    }

    public Map<String, ActionArgumentValue<S>> getInputMap() {
        return Collections.unmodifiableMap(this.input);
    }

    public ActionArgumentValue<S> getOutput(String str) {
        return getOutput(getOutputArgument(str));
    }

    public ActionArgumentValue<S> getOutput(ActionArgument<S> actionArgument) {
        return this.output.get(actionArgument.getName());
    }

    public ActionArgumentValue<S>[] getOutput() {
        return (ActionArgumentValue[]) this.output.values().toArray(new ActionArgumentValue[this.output.size()]);
    }

    public ActionArgument<S> getOutputArgument(String str) {
        ActionArgument<S> outputArgument = getAction().getOutputArgument(str);
        if (outputArgument != null) {
            return outputArgument;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Argument not found: ", str));
    }

    public Map<String, ActionArgumentValue<S>> getOutputMap() {
        return Collections.unmodifiableMap(this.output);
    }

    public void setFailure(ActionException actionException) {
        this.failure = actionException;
    }

    public void setInput(String str, Object obj) throws InvalidValueException {
        setInput(new ActionArgumentValue<>(getInputArgument(str), obj));
    }

    public void setInput(ActionArgumentValue<S> actionArgumentValue) {
        this.input.put(actionArgumentValue.getArgument().getName(), actionArgumentValue);
    }

    public void setInput(ActionArgumentValue<S>[] actionArgumentValueArr) {
        if (actionArgumentValueArr == null) {
            return;
        }
        for (ActionArgumentValue<S> actionArgumentValue : actionArgumentValueArr) {
            this.input.put(actionArgumentValue.getArgument().getName(), actionArgumentValue);
        }
    }

    public void setOutput(String str, Object obj) throws InvalidValueException {
        setOutput(new ActionArgumentValue<>(getOutputArgument(str), obj));
    }

    public void setOutput(ActionArgumentValue<S> actionArgumentValue) {
        this.output.put(actionArgumentValue.getArgument().getName(), actionArgumentValue);
    }

    public void setOutput(ActionArgumentValue<S>[] actionArgumentValueArr) {
        if (actionArgumentValueArr == null) {
            return;
        }
        for (ActionArgumentValue<S> actionArgumentValue : actionArgumentValueArr) {
            this.output.put(actionArgumentValue.getArgument().getName(), actionArgumentValue);
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getAction());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
