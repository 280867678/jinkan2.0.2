package org.eclipse.jetty.util.ajax;

import com.umeng.analytics.pro.C1543ak;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.util.ajax.JSON;

/* loaded from: classes5.dex */
public class JSONObjectConvertor implements JSON.Convertor {
    public Set _excluded;
    public boolean _fromJSON;

    public JSONObjectConvertor() {
        this._excluded = null;
        this._fromJSON = false;
    }

    public JSONObjectConvertor(boolean z) {
        this._excluded = null;
        this._fromJSON = z;
    }

    public JSONObjectConvertor(boolean z, String[] strArr) {
        this._excluded = null;
        this._fromJSON = z;
        if (strArr != null) {
            this._excluded = new HashSet(Arrays.asList(strArr));
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map map) {
        if (!this._fromJSON) {
            return map;
        }
        throw new UnsupportedOperationException();
    }

    public boolean includeField(String str, Object obj, Method method) {
        Set set = this._excluded;
        return set == null || !set.contains(str);
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output output) {
        Method[] methods;
        StringBuilder sb;
        try {
            obj.getClass();
            if (this._fromJSON) {
                output.addClass(obj.getClass());
            }
            for (Method method : obj.getClass().getMethods()) {
                if (!Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length == 0 && method.getReturnType() != null && method.getDeclaringClass() != Object.class) {
                    String name = method.getName();
                    if (name.startsWith(C1543ak.f2994ae)) {
                        sb = new StringBuilder();
                        sb.append(name.substring(2, 3).toLowerCase(Locale.ENGLISH));
                        sb.append(name.substring(3));
                    } else if (name.startsWith("get")) {
                        sb = new StringBuilder();
                        sb.append(name.substring(3, 4).toLowerCase(Locale.ENGLISH));
                        sb.append(name.substring(4));
                    }
                    String sb2 = sb.toString();
                    if (includeField(sb2, obj, method)) {
                        output.add(sb2, method.invoke(obj, null));
                    }
                }
            }
        } catch (Throwable th) {
            throw new IllegalArgumentException(th);
        }
    }
}
