package org.eclipse.jetty.security;

import org.eclipse.jetty.util.security.Constraint;

/* loaded from: classes4.dex */
public class ConstraintMapping {
    public Constraint _constraint;
    public String _method;
    public String[] _methodOmissions;
    public String _pathSpec;

    public Constraint getConstraint() {
        return this._constraint;
    }

    public String getMethod() {
        return this._method;
    }

    public String[] getMethodOmissions() {
        return this._methodOmissions;
    }

    public String getPathSpec() {
        return this._pathSpec;
    }

    public void setConstraint(Constraint constraint) {
        this._constraint = constraint;
    }

    public void setMethod(String str) {
        this._method = str;
    }

    public void setMethodOmissions(String[] strArr) {
        this._methodOmissions = strArr;
    }

    public void setPathSpec(String str) {
        this._pathSpec = str;
    }
}
