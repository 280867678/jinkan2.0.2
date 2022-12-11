package me.tvspark;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/* loaded from: classes4.dex */
public class nw0<T> extends qw0<T> {
    public nw0(pw0 pw0Var) {
        super(pw0Var);
    }

    @Override // me.tvspark.qw0
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new JSONObject();
    }

    @Override // me.tvspark.qw0
    public qw0<lv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.qw0
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new JSONArray();
    }

    @Override // me.tvspark.qw0
    public qw0<lv0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.qw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    @Override // me.tvspark.qw0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str, Object obj2) {
        ((JSONObject) obj).put(str, obj2);
    }
}
