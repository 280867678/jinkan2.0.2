package org.fourthline.cling.model.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.profile.RemoteClientInfo;
import org.fourthline.cling.model.state.StateVariableAccessor;
import org.fourthline.cling.model.types.ErrorCode;
import org.seamless.util.Reflections;

/* loaded from: classes5.dex */
public class MethodActionExecutor extends AbstractActionExecutor {
    public static Logger log = Logger.getLogger(MethodActionExecutor.class.getName());
    public Method method;

    public MethodActionExecutor(Method method) {
        this.method = method;
    }

    public MethodActionExecutor(Map<ActionArgument<LocalService>, StateVariableAccessor> map, Method method) {
        super(map);
        this.method = method;
    }

    public Object[] createInputArgumentValues(ActionInvocation<LocalService> actionInvocation, Method method) throws ActionException {
        ActionArgument<LocalService> actionArgument;
        int i;
        LocalService service = actionInvocation.getAction().getService();
        ArrayList arrayList = new ArrayList();
        ActionArgument<LocalService>[] inputArguments = actionInvocation.getAction().getInputArguments();
        int length = inputArguments.length;
        char c = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Object obj = null;
            if (i2 >= length) {
                if (method.getParameterTypes().length > 0 && RemoteClientInfo.class.isAssignableFrom(method.getParameterTypes()[method.getParameterTypes().length - 1])) {
                    if (actionInvocation instanceof RemoteActionInvocation) {
                        RemoteActionInvocation remoteActionInvocation = (RemoteActionInvocation) actionInvocation;
                        if (remoteActionInvocation.getRemoteClientInfo() != null) {
                            Logger logger = log;
                            logger.finer("Providing remote client info as last action method input argument: " + method);
                            arrayList.add(i3, remoteActionInvocation.getRemoteClientInfo());
                        }
                    }
                    arrayList.add(i3, null);
                }
                return arrayList.toArray(new Object[arrayList.size()]);
            }
            actionArgument = inputArguments[i2];
            Class<?> cls = method.getParameterTypes()[i3];
            ActionArgumentValue<LocalService> input = actionInvocation.getInput(actionArgument);
            if (!cls.isPrimitive() || (input != null && input.toString().length() != 0)) {
                if (input == null) {
                    i = i3 + 1;
                } else {
                    String variableValue = input.toString();
                    if (variableValue.length() <= 0 || !service.isStringConvertibleType((Class) cls) || cls.isEnum()) {
                        i = i3 + 1;
                        obj = input.getValue();
                    } else {
                        try {
                            Class<?>[] clsArr = new Class[1];
                            clsArr[c] = String.class;
                            Constructor<?> constructor = cls.getConstructor(clsArr);
                            Logger logger2 = log;
                            logger2.finer("Creating new input argument value instance with String.class constructor of type: " + cls);
                            Object[] objArr = {variableValue};
                            int i4 = i3 + 1;
                            arrayList.add(i3, constructor.newInstance(objArr));
                            i3 = i4;
                            i2++;
                            c = 0;
                        } catch (Exception e) {
                            Logger logger3 = log;
                            logger3.warning("Error preparing action method call: " + method);
                            Logger logger4 = log;
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't convert input argument string to desired type of '");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgument.getName());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e);
                            logger4.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                            ErrorCode errorCode = ErrorCode.ARGUMENT_VALUE_INVALID;
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't convert input argument string to desired type of '");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(actionArgument.getName());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("': ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e);
                            throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                    }
                }
                arrayList.add(i3, obj);
                i3 = i;
                i2++;
                c = 0;
            }
        }
        ErrorCode errorCode2 = ErrorCode.ARGUMENT_VALUE_INVALID;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Primitive action method argument '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(actionArgument.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("' requires input value, can't be null or empty string");
        throw new ActionException(errorCode2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    @Override // org.fourthline.cling.model.action.AbstractActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(ActionInvocation<LocalService> actionInvocation, Object obj) throws Exception {
        Object invoke;
        boolean z;
        ActionArgument<LocalService>[] outputArguments;
        Object[] createInputArgumentValues = createInputArgumentValues(actionInvocation, this.method);
        if (!actionInvocation.getAction().hasOutputArguments()) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Calling local service method with no output arguments: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.method);
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            Reflections.invoke(this.method, obj, createInputArgumentValues);
            return;
        }
        boolean equals = this.method.getReturnType().equals(Void.TYPE);
        Logger logger2 = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Calling local service method with output arguments: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.method);
        logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        if (equals) {
            log.fine("Action method is void, calling declared accessors(s) on service instance to retrieve ouput argument(s)");
            Reflections.invoke(this.method, obj, createInputArgumentValues);
        } else if (!isUseOutputArgumentAccessors(actionInvocation)) {
            log.fine("Action method is not void, using returned value as (single) output argument");
            invoke = Reflections.invoke(this.method, obj, createInputArgumentValues);
            z = false;
            outputArguments = actionInvocation.getAction().getOutputArguments();
            if (z || !(invoke instanceof Object[])) {
                if (outputArguments.length != 1) {
                    setOutputArgumentValue(actionInvocation, outputArguments[0], invoke);
                    return;
                }
                ErrorCode errorCode = ErrorCode.ACTION_FAILED;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Method return does not match required number of output arguments: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(outputArguments.length);
                throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            }
            Object[] objArr = (Object[]) invoke;
            Logger logger3 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Accessors returned Object[], setting output argument values: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(objArr.length);
            logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            for (int i = 0; i < outputArguments.length; i++) {
                setOutputArgumentValue(actionInvocation, outputArguments[i], objArr[i]);
            }
            return;
        } else {
            log.fine("Action method is not void, calling declared accessor(s) on returned instance to retrieve ouput argument(s)");
            obj = Reflections.invoke(this.method, obj, createInputArgumentValues);
        }
        invoke = readOutputArgumentValues(actionInvocation.getAction(), obj);
        z = true;
        outputArguments = actionInvocation.getAction().getOutputArguments();
        if (z) {
        }
        if (outputArguments.length != 1) {
        }
    }

    public Method getMethod() {
        return this.method;
    }

    public boolean isUseOutputArgumentAccessors(ActionInvocation<LocalService> actionInvocation) {
        for (ActionArgument<LocalService> actionArgument : actionInvocation.getAction().getOutputArguments()) {
            if (getOutputArgumentAccessors().get(actionArgument) != null) {
                return true;
            }
        }
        return false;
    }
}
