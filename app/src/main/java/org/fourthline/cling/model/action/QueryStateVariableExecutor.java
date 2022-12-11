package org.fourthline.cling.model.action;

import me.tvspark.outline;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.QueryStateVariableAction;
import org.fourthline.cling.model.meta.StateVariable;
import org.fourthline.cling.model.state.StateVariableAccessor;
import org.fourthline.cling.model.types.ErrorCode;

/* loaded from: classes5.dex */
public class QueryStateVariableExecutor extends AbstractActionExecutor {
    @Override // org.fourthline.cling.model.action.AbstractActionExecutor
    public void execute(ActionInvocation<LocalService> actionInvocation, Object obj) throws Exception {
        if (!(actionInvocation.getAction() instanceof QueryStateVariableAction)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("This class can only execute QueryStateVariableAction's, not: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionInvocation.getAction());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (!actionInvocation.getAction().getService().isSupportsQueryStateVariables()) {
            actionInvocation.setFailure(new ActionException(ErrorCode.INVALID_ACTION, "This service does not support querying state variables"));
        } else {
            executeQueryStateVariable(actionInvocation, obj);
        }
    }

    public void executeQueryStateVariable(ActionInvocation<LocalService> actionInvocation, Object obj) throws Exception {
        LocalService service = actionInvocation.getAction().getService();
        String variableValue = actionInvocation.getInput(QueryStateVariableAction.INPUT_ARG_VAR_NAME).toString();
        StateVariable<LocalService> stateVariable = service.getStateVariable(variableValue);
        if (stateVariable != null) {
            StateVariableAccessor accessor = service.getAccessor(stateVariable.getName());
            if (accessor == null) {
                throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No accessor for state variable, can't read state: ", variableValue));
            }
            try {
                setOutputArgumentValue(actionInvocation, actionInvocation.getAction().getOutputArgument(QueryStateVariableAction.OUTPUT_ARG_RETURN), accessor.read(stateVariable, obj).toString());
                return;
            } catch (Exception e) {
                throw new ActionException(ErrorCode.ACTION_FAILED, e.getMessage());
            }
        }
        throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No state variable found: ", variableValue));
    }
}
