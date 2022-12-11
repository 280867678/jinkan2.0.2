package org.eclipse.jetty.util.ajax;

import java.util.Map;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.ajax.JSON;

/* loaded from: classes5.dex */
public class JSONPojoConvertorFactory implements JSON.Convertor {
    public final boolean _fromJson;
    public final JSON _json;

    public JSONPojoConvertorFactory(JSON json) {
        if (json != null) {
            this._json = json;
            this._fromJson = true;
            return;
        }
        throw new IllegalArgumentException();
    }

    public JSONPojoConvertorFactory(JSON json, boolean z) {
        if (json != null) {
            this._json = json;
            this._fromJson = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fromJSON(Map map) {
        String str = (String) map.get("class");
        if (str != null) {
            JSON.Convertor convertorFor = this._json.getConvertorFor(str);
            if (convertorFor == null) {
                try {
                    JSONPojoConvertor jSONPojoConvertor = new JSONPojoConvertor(Loader.loadClass(JSON.class, str), this._fromJson);
                    try {
                        this._json.addConvertorFor(str, jSONPojoConvertor);
                        convertorFor = jSONPojoConvertor;
                    } catch (ClassNotFoundException e) {
                        e = e;
                        convertorFor = jSONPojoConvertor;
                        JSON.LOG.warn(e);
                        if (convertorFor == null) {
                        }
                    }
                } catch (ClassNotFoundException e2) {
                    e = e2;
                }
            }
            return convertorFor == null ? convertorFor.fromJSON(map) : map;
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void toJSON(Object obj, JSON.Output output) {
        JSONPojoConvertor jSONPojoConvertor;
        String name = obj.getClass().getName();
        JSON.Convertor convertorFor = this._json.getConvertorFor(name);
        if (convertorFor == null) {
            try {
                jSONPojoConvertor = new JSONPojoConvertor(Loader.loadClass(JSON.class, name), this._fromJson);
            } catch (ClassNotFoundException e) {
                e = e;
            }
            try {
                this._json.addConvertorFor(name, jSONPojoConvertor);
                convertorFor = jSONPojoConvertor;
            } catch (ClassNotFoundException e2) {
                e = e2;
                convertorFor = jSONPojoConvertor;
                JSON.LOG.warn(e);
                if (convertorFor == null) {
                }
            }
        }
        if (convertorFor == null) {
            convertorFor.toJSON(obj, output);
        }
    }
}
