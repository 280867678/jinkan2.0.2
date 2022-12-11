package org.fourthline.cling.model.action;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.Command;
import org.fourthline.cling.model.ServiceManager;
import org.fourthline.cling.model.meta.Action;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.state.StateVariableAccessor;
import org.fourthline.cling.model.types.ErrorCode;
import org.fourthline.cling.model.types.InvalidValueException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class AbstractActionExecutor implements ActionExecutor {
    public static Logger log = Logger.getLogger(AbstractActionExecutor.class.getName());
    public Map<ActionArgument<LocalService>, StateVariableAccessor> outputArgumentAccessors;

    public AbstractActionExecutor() {
        this.outputArgumentAccessors = new HashMap();
    }

    public AbstractActionExecutor(Map<ActionArgument<LocalService>, StateVariableAccessor> map) {
        this.outputArgumentAccessors = new HashMap();
        this.outputArgumentAccessors = map;
    }

    @Override // org.fourthline.cling.model.action.ActionExecutor
    public void execute(final ActionInvocation<LocalService> actionInvocation) {
        ActionException actionException;
        Logger logger = log;
        logger.fine("Invoking on local service: " + actionInvocation);
        LocalService service = actionInvocation.getAction().getService();
        try {
            if (service.getManager() == null) {
                throw new IllegalStateException("Service has no implementation factory, can't get service instance");
            }
            service.getManager().execute(new Command() { // from class: org.fourthline.cling.model.action.AbstractActionExecutor.1
                @Override // org.fourthline.cling.model.Command
                public void execute(ServiceManager serviceManager) throws Exception {
                    AbstractActionExecutor.this.execute(actionInvocation, serviceManager.getImplementation());
                }

                public String toString() {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Action invocation: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionInvocation.getAction());
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
            });
        } catch (InterruptedException e) {
            if (log.isLoggable(Level.FINE)) {
                Logger logger2 = log;
                logger2.fine("InterruptedException thrown by service, wrapping in invocation and returning: " + e);
                log.log(Level.FINE, "Exception root cause: ", Exceptions.unwrap(e));
            }
            actionException = new ActionCancelledException(e);
            actionInvocation.setFailure(actionException);
        } catch (ActionException e2) {
            if (log.isLoggable(Level.FINE)) {
                Logger logger3 = log;
                logger3.fine("ActionException thrown by service, wrapping in invocation and returning: " + e2);
                log.log(Level.FINE, "Exception root cause: ", Exceptions.unwrap(e2));
            }
            actionInvocation.setFailure(e2);
        } catch (Throwable th) {
            Throwable unwrap = Exceptions.unwrap(th);
            if (log.isLoggable(Level.FINE)) {
                Logger logger4 = log;
                logger4.fine("Execution has thrown, wrapping root cause in ActionException and returning: " + th);
                log.log(Level.FINE, "Exception root cause: ", unwrap);
            }
            actionException = new ActionException(ErrorCode.ACTION_FAILED, unwrap.getMessage() != null ? unwrap.getMessage() : unwrap.toString(), unwrap);
            actionInvocation.setFailure(actionException);
        }
    }

    public abstract void execute(ActionInvocation<LocalService> actionInvocation, Object obj) throws Exception;

    public Map<ActionArgument<LocalService>, StateVariableAccessor> getOutputArgumentAccessors() {
        return this.outputArgumentAccessors;
    }

    public Object readOutputArgumentValues(Action<LocalService> action, Object obj) throws Exception {
        int length = action.getOutputArguments().length;
        Object[] objArr = new Object[length];
        Logger logger = log;
        logger.fine("Attempting to retrieve output argument values using accessor: " + length);
        ActionArgument<LocalService>[] outputArguments = action.getOutputArguments();
        int length2 = outputArguments.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            ActionArgument<LocalService> actionArgument = outputArguments[i];
            Logger logger2 = log;
            logger2.finer("Calling acccessor method for: " + actionArgument);
            StateVariableAccessor stateVariableAccessor = getOutputArgumentAccessors().get(actionArgument);
            if (stateVariableAccessor == null) {
                throw new IllegalStateException("No accessor bound for: " + actionArgument);
            }
            Logger logger3 = log;
            logger3.fine("Calling accessor to read output argument value: " + stateVariableAccessor);
            objArr[i2] = stateVariableAccessor.read(obj);
            i++;
            i2++;
        }
        if (length == 1) {
            return objArr[0];
        }
        if (length <= 0) {
            return null;
        }
        return objArr;
    }

    public void setOutputArgumentValue(ActionInvocation<LocalService> actionInvocation, ActionArgument<LocalService> actionArgument, Object obj) throws ActionException {
        ActionArgumentValue<LocalService> actionArgumentValue;
        LocalService service = actionInvocation.getAction().getService();
        if (obj == null) {
            log.fine("Result of invocation is null, not setting any output argument value(s)");
            return;
        }
        try {
            if (service.isStringConvertibleType(obj)) {
                log.fine("Result of invocation matches convertible type, setting toString() single output argument value");
                actionArgumentValue = new ActionArgumentValue<>(actionArgument, obj.toString());
            } else {
                log.fine("Result of invocation is Object, setting single output argument value");
                actionArgumentValue = new ActionArgumentValue<>(actionArgument, obj);
            }
            actionInvocation.setOutput(actionArgumentValue);
        } catch (InvalidValueException e) {
            ErrorCode errorCode = ErrorCode.ARGUMENT_VALUE_INVALID;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Wrong type or invalid value for '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgument.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }
}
