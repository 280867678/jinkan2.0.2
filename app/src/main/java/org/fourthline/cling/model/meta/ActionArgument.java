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
public class ActionArgument<S extends Service> implements Validatable {
    public static final Logger log = Logger.getLogger(ActionArgument.class.getName());
    public Action<S> action;
    public final String[] aliases;
    public final Direction direction;
    public final String name;
    public final String relatedStateVariableName;
    public final boolean returnValue;

    /* loaded from: classes5.dex */
    public enum Direction {
        IN,
        OUT
    }

    public ActionArgument(String str, String str2, Direction direction) {
        this(str, new String[0], str2, direction, false);
    }

    public ActionArgument(String str, String str2, Direction direction, boolean z) {
        this(str, new String[0], str2, direction, z);
    }

    public ActionArgument(String str, String[] strArr, String str2, Direction direction) {
        this(str, strArr, str2, direction, false);
    }

    public ActionArgument(String str, String[] strArr, String str2, Direction direction, boolean z) {
        this.name = str;
        this.aliases = strArr;
        this.relatedStateVariableName = str2;
        this.direction = direction;
        this.returnValue = z;
    }

    public ActionArgument<S> deepCopy() {
        return new ActionArgument<>(getName(), getAliases(), getRelatedStateVariableName(), getDirection(), isReturnValue());
    }

    public Action<S> getAction() {
        return this.action;
    }

    public String[] getAliases() {
        return this.aliases;
    }

    public Datatype getDatatype() {
        return getAction().getService().getDatatype(this);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String getName() {
        return this.name;
    }

    public String getRelatedStateVariableName() {
        return this.relatedStateVariableName;
    }

    public boolean isNameOrAlias(String str) {
        if (getName().equalsIgnoreCase(str)) {
            return true;
        }
        for (String str2 : this.aliases) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isReturnValue() {
        return this.returnValue;
    }

    public void setAction(Action<S> action) {
        if (this.action == null) {
            this.action = action;
            return;
        }
        throw new IllegalStateException("Final value has been set already, model is immutable");
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ActionArgument.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDirection());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getName());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.Validatable
    public List<ValidationError> validate() {
        Logger logger;
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        if (getName() == null || getName().length() == 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Argument without name of: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getAction());
            arrayList.add(new ValidationError(ActionArgument.class, "name", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
        } else {
            if (!ModelUtil.isValidUDAName(getName())) {
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getAction().getService().getDevice());
                logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                logger = log;
                sb = new StringBuilder();
                str = "Invalid argument name: ";
            } else if (getName().length() > 32) {
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("UPnP specification violation of: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getAction().getService().getDevice());
                logger3.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                logger = log;
                sb = new StringBuilder();
                str = "Argument name should be less than 32 characters: ";
            }
            sb.append(str);
            sb.append(this);
            logger.warning(sb.toString());
        }
        if (getDirection() == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Argument '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append("' requires a direction, either IN or OUT");
            arrayList.add(new ValidationError(ActionArgument.class, "direction", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString()));
        }
        if (isReturnValue() && getDirection() != Direction.OUT) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Return value argument '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append("' must be direction OUT");
            arrayList.add(new ValidationError(ActionArgument.class, "direction", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString()));
        }
        return arrayList;
    }
}
