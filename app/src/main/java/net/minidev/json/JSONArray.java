package net.minidev.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.iw0;
import me.tvspark.lv0;
import me.tvspark.nv0;
import me.tvspark.ov0;
import me.tvspark.qv0;

/* loaded from: classes4.dex */
public class JSONArray extends ArrayList<Object> implements List<Object>, lv0, nv0 {
    public static final long serialVersionUID = 9106884089231309568L;

    public static String toJSONString(List<? extends Object> list) {
        return toJSONString(list, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static String toJSONString(List<? extends Object> list, ov0 ov0Var) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(list, sb, ov0Var);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static void writeJSONString(Iterable<? extends Object> iterable, Appendable appendable, ov0 ov0Var) throws IOException {
        if (iterable == null) {
            appendable.append("null");
        } else {
            iw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, appendable, ov0Var);
        }
    }

    public static void writeJSONString(List<? extends Object> list, Appendable appendable) throws IOException {
        writeJSONString(list, appendable, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public JSONArray appendElement(Object obj) {
        add(obj);
        return this;
    }

    public void merge(Object obj) {
        JSONObject.merge(this, obj);
    }

    @Override // me.tvspark.kv0
    public String toJSONString() {
        return toJSONString(this, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.lv0
    public String toJSONString(ov0 ov0Var) {
        return toJSONString(this, ov0Var);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return toJSONString();
    }

    public String toString(ov0 ov0Var) {
        return toJSONString(ov0Var);
    }

    @Override // me.tvspark.mv0
    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSONString(this, appendable, qv0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.nv0
    public void writeJSONString(Appendable appendable, ov0 ov0Var) throws IOException {
        writeJSONString(this, appendable, ov0Var);
    }
}
