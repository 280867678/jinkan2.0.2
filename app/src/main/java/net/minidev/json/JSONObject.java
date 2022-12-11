package net.minidev.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.iw0;
import me.tvspark.kv0;
import me.tvspark.lv0;
import me.tvspark.nv0;
import me.tvspark.ov0;
import me.tvspark.qv0;

/* loaded from: classes4.dex */
public class JSONObject extends HashMap<String, Object> implements kv0, lv0, nv0 {
    public static final long serialVersionUID = -503443796854799292L;

    public JSONObject() {
    }

    public JSONObject(Map<String, ?> map) {
        super(map);
    }

    public static String escape(String str) {
        ov0 ov0Var = qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, sb);
        return sb.toString();
    }

    public static JSONArray merge(JSONArray jSONArray, Object obj) {
        if (obj == null) {
            return jSONArray;
        }
        if (jSONArray instanceof JSONArray) {
            return merge(jSONArray, (JSONArray) obj);
        }
        jSONArray.add(obj);
        return jSONArray;
    }

    public static JSONArray merge(JSONArray jSONArray, JSONArray jSONArray2) {
        jSONArray.addAll(jSONArray2);
        return jSONArray;
    }

    public static JSONObject merge(JSONObject jSONObject, Object obj) {
        if (obj == null) {
            return jSONObject;
        }
        if (obj instanceof JSONObject) {
            return merge(jSONObject, (JSONObject) obj);
        }
        throw new RuntimeException("JSON megre can not merge JSONObject with " + obj.getClass());
    }

    public static JSONObject merge(JSONObject jSONObject, JSONObject jSONObject2) {
        Cloneable merge;
        if (jSONObject2 == null) {
            return jSONObject;
        }
        for (String str : jSONObject.keySet()) {
            Object obj = jSONObject.get(str);
            Object obj2 = jSONObject2.get(str);
            if (obj2 != null) {
                if (obj instanceof JSONArray) {
                    merge = merge((JSONArray) obj, obj2);
                } else if (obj instanceof JSONObject) {
                    merge = merge((JSONObject) obj, obj2);
                } else if (!obj.equals(obj2)) {
                    if (obj.getClass().equals(obj2.getClass())) {
                        throw new RuntimeException("JSON merge can not merge two " + obj.getClass().getName() + " Object together");
                    }
                    throw new RuntimeException("JSON merge can not merge " + obj.getClass().getName() + " with " + obj2.getClass().getName());
                }
                jSONObject.put(str, merge);
            }
        }
        for (String str2 : jSONObject2.keySet()) {
            if (!jSONObject.containsKey(str2)) {
                jSONObject.put(str2, jSONObject2.get(str2));
            }
        }
        return jSONObject;
    }

    public static String toJSONString(Map<String, ? extends Object> map) {
        return toJSONString(map, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static String toJSONString(Map<String, ? extends Object> map, ov0 ov0Var) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSON(map, sb, ov0Var);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static void writeJSON(Map<String, ? extends Object> map, Appendable appendable) throws IOException {
        writeJSON(map, appendable, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static void writeJSON(Map<String, ? extends Object> map, Appendable appendable, ov0 ov0Var) throws IOException {
        if (map == null) {
            appendable.append("null");
        } else {
            iw0.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, appendable, ov0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void writeJSONKV(String str, Object obj, Appendable appendable, ov0 ov0Var) throws IOException {
        if (str == null) {
            str = "null";
        } else if (ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            appendable.append('\"');
            qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, appendable, ov0Var);
            appendable.append('\"');
            appendable.append(':');
            if (!(obj instanceof String)) {
                ov0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appendable, (String) obj);
                return;
            } else {
                qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, appendable, ov0Var);
                return;
            }
        }
        appendable.append(str);
        appendable.append(':');
        if (!(obj instanceof String)) {
        }
    }

    public JSONObject appendField(String str, Object obj) {
        put(str, obj);
        return this;
    }

    public Number getAsNumber(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj instanceof Number ? (Number) obj : Long.valueOf(obj.toString());
    }

    public String getAsString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public void merge(Object obj) {
        merge(this, obj);
    }

    @Override // me.tvspark.kv0
    public String toJSONString() {
        return toJSONString(this, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.lv0
    public String toJSONString(ov0 ov0Var) {
        return toJSONString(this, ov0Var);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return toJSONString(this, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString(ov0 ov0Var) {
        return toJSONString(this, ov0Var);
    }

    @Override // me.tvspark.mv0
    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSON(this, appendable, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.nv0
    public void writeJSONString(Appendable appendable, ov0 ov0Var) throws IOException {
        writeJSON(this, appendable, ov0Var);
    }
}
