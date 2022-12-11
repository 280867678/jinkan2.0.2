package org.fourthline.cling.model.action;

import org.fourthline.cling.model.VariableValue;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.Datatype;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public class ActionArgumentValue<S extends Service> extends VariableValue {
    public final ActionArgument<S> argument;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActionArgumentValue(ActionArgument<S> actionArgument, Object obj) throws InvalidValueException {
        super(r0, obj);
        Datatype datatype = actionArgument.getDatatype();
        if (obj != null && obj.getClass().isEnum()) {
            obj = obj.toString();
        }
        this.argument = actionArgument;
    }

    public ActionArgument<S> getArgument() {
        return this.argument;
    }
}
