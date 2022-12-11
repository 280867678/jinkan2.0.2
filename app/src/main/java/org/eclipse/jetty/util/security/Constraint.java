package org.eclipse.jetty.util.security;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Constraint implements Cloneable, Serializable {
    public static final String ANY_ROLE = "*";
    public static final int DC_CONFIDENTIAL = 2;
    public static final int DC_FORBIDDEN = 3;
    public static final int DC_INTEGRAL = 1;
    public static final int DC_NONE = 0;
    public static final int DC_UNSET = -1;
    public static final String NONE = "NONE";
    public static final String __BASIC_AUTH = "BASIC";
    public static final String __CERT_AUTH = "CLIENT_CERT";
    public static final String __CERT_AUTH2 = "CLIENT-CERT";
    public static final String __DIGEST_AUTH = "DIGEST";
    public static final String __FORM_AUTH = "FORM";
    public static final String __NEGOTIATE_AUTH = "NEGOTIATE";
    public static final String __SPNEGO_AUTH = "SPNEGO";
    public String _name;
    public String[] _roles;
    public int _dataConstraint = -1;
    public boolean _anyRole = false;
    public boolean _authenticate = false;

    public Constraint() {
    }

    public Constraint(String str, String str2) {
        setName(str);
        setRoles(new String[]{str2});
    }

    public static boolean validateMethod(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        return trim.equals(__FORM_AUTH) || trim.equals(__BASIC_AUTH) || trim.equals(__DIGEST_AUTH) || trim.equals(__CERT_AUTH) || trim.equals(__CERT_AUTH2) || trim.equals(__SPNEGO_AUTH) || trim.equals(__NEGOTIATE_AUTH);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean getAuthenticate() {
        return this._authenticate;
    }

    public int getDataConstraint() {
        return this._dataConstraint;
    }

    public String[] getRoles() {
        return this._roles;
    }

    public boolean hasDataConstraint() {
        return this._dataConstraint >= 0;
    }

    public boolean hasRole(String str) {
        if (this._anyRole) {
            return true;
        }
        String[] strArr = this._roles;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (str.equals(this._roles[i])) {
                return true;
            }
            length = i;
        }
    }

    public boolean isAnyRole() {
        return this._anyRole;
    }

    public boolean isForbidden() {
        String[] strArr;
        return this._authenticate && !this._anyRole && ((strArr = this._roles) == null || strArr.length == 0);
    }

    public void setAuthenticate(boolean z) {
        this._authenticate = z;
    }

    public void setDataConstraint(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Constraint out of range");
        }
        this._dataConstraint = i;
    }

    public void setName(String str) {
        this._name = str;
    }

    public void setRoles(String[] strArr) {
        this._roles = strArr;
        this._anyRole = false;
        if (strArr != null) {
            int length = strArr.length;
            while (true) {
                boolean z = this._anyRole;
                if (z) {
                    return;
                }
                int i = length - 1;
                if (length <= 0) {
                    return;
                }
                this._anyRole = "*".equals(strArr[i]) | z;
                length = i;
            }
        }
    }

    public String toString() {
        String obj;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SC{");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._name);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        if (this._anyRole) {
            obj = "*";
        } else {
            String[] strArr = this._roles;
            obj = strArr == null ? "-" : Arrays.asList(strArr).toString();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        int i = this._dataConstraint;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i == -1 ? "DC_UNSET}" : i == 0 ? "NONE}" : i == 1 ? "INTEGRAL}" : "CONFIDENTIAL}");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
