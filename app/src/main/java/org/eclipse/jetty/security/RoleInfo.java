package org.eclipse.jetty.security;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class RoleInfo {
    public boolean _checked;
    public boolean _forbidden;
    public boolean _isAnyRole;
    public final Set<String> _roles = new CopyOnWriteArraySet();
    public UserDataConstraint _userDataConstraint;

    public void addRole(String str) {
        this._roles.add(str);
    }

    public void combine(RoleInfo roleInfo) {
        if (roleInfo._forbidden) {
            setForbidden(true);
        } else if (!roleInfo._checked) {
            setChecked(true);
        } else if (roleInfo._isAnyRole) {
            setAnyRole(true);
        } else if (!this._isAnyRole) {
            for (String str : roleInfo._roles) {
                this._roles.add(str);
            }
        }
        setUserDataConstraint(roleInfo._userDataConstraint);
    }

    public Set<String> getRoles() {
        return this._roles;
    }

    public UserDataConstraint getUserDataConstraint() {
        return this._userDataConstraint;
    }

    public boolean isAnyRole() {
        return this._isAnyRole;
    }

    public boolean isChecked() {
        return this._checked;
    }

    public boolean isForbidden() {
        return this._forbidden;
    }

    public void setAnyRole(boolean z) {
        this._isAnyRole = z;
        if (z) {
            this._checked = true;
            this._roles.clear();
        }
    }

    public void setChecked(boolean z) {
        this._checked = z;
        if (!z) {
            this._forbidden = false;
            this._roles.clear();
            this._isAnyRole = false;
        }
    }

    public void setForbidden(boolean z) {
        this._forbidden = z;
        if (z) {
            this._checked = true;
            this._userDataConstraint = null;
            this._isAnyRole = false;
            this._roles.clear();
        }
    }

    public void setUserDataConstraint(UserDataConstraint userDataConstraint) {
        if (userDataConstraint != null) {
            UserDataConstraint userDataConstraint2 = this._userDataConstraint;
            if (userDataConstraint2 != null) {
                userDataConstraint = userDataConstraint2.combine(userDataConstraint);
            }
            this._userDataConstraint = userDataConstraint;
            return;
        }
        throw new NullPointerException("Null UserDataConstraint");
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("{RoleInfo");
        String str = "";
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._forbidden ? ",F" : str);
        if (this._checked) {
            str = ",C";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._isAnyRole ? ",*" : this._roles);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("}");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
