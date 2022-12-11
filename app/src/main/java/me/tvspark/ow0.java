package me.tvspark;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minidev.json.JSONArray;

/* loaded from: classes4.dex */
public class ow0 extends qw0<lv0> {
    public ow0(pw0 pw0Var) {
        super(pw0Var);
    }

    @Override // me.tvspark.qw0
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new LinkedHashMap();
    }

    @Override // me.tvspark.qw0
    public qw0<lv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.qw0
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new JSONArray();
    }

    @Override // me.tvspark.qw0
    public qw0<lv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.qw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    @Override // me.tvspark.qw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }
}
