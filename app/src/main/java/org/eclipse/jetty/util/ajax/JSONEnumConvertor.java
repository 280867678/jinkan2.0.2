package org.eclipse.jetty.util.ajax;

import java.lang.reflect.Method;
import java.util.Map;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.ajax.JSON;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class JSONEnumConvertor implements JSON.Convertor {
    public static final Logger LOG = Log.getLogger(JSONEnumConvertor.class);
    public boolean _fromJSON;
    public Method _valueOf;

    public JSONEnumConvertor() {
        this(false);
    }

    public JSONEnumConvertor(boolean z) {
        try {
            this._valueOf = Loader.loadClass(getClass(), "java.lang.Enum").getMethod("valueOf", Class.class, String.class);
            this._fromJSON = z;
        } catch (Exception e) {
            throw new RuntimeException("!Enums", e);
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map map) {
        if (this._fromJSON) {
            try {
                return this._valueOf.invoke(null, Loader.loadClass(getClass(), (String) map.get("class")), map.get("value"));
            } catch (Exception e) {
                LOG.warn(e);
                return null;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output output) {
        if (!this._fromJSON) {
            output.add(((Enum) obj).name());
            return;
        }
        output.addClass(obj.getClass());
        output.add("value", ((Enum) obj).name());
    }
}
