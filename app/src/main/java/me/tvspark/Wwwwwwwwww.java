package me.tvspark;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class Wwwwwwwwww {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LinkedHashMap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashMap();
    public HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public Wwwwwwwwww(String str, String str2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("URL_KEY_DEFAULT", str);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
    }

    public Wwwwwwwwww(LinkedHashMap linkedHashMap, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putAll(linkedHashMap);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = 0;
        for (Object obj : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keySet()) {
            if (i2 == i) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(obj);
            }
            i2++;
        }
        return null;
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = 0;
        for (Object obj : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keySet()) {
            if (i2 == i) {
                return obj.toString();
            }
            i2++;
        }
        return null;
    }

    public Wwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return new Wwwwwwwwww(linkedHashMap, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
