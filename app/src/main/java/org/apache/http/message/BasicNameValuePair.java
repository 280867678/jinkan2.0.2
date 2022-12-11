package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
    public static final long serialVersionUID = -6437800749411518984L;
    public final String name;
    public final String value;

    public BasicNameValuePair(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        return this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value);
    }

    @Override // org.apache.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.http.NameValuePair
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder sb = new StringBuilder(this.value.length() + this.name.length() + 1);
        sb.append(this.name);
        sb.append("=");
        sb.append(this.value);
        return sb.toString();
    }
}
