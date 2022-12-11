package me.tvspark;

import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class c61 {
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public c61(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    public List<c61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (!(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof Element)) {
            return null;
        }
        return new b61(new Elements((Element) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    public String toString() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return obj instanceof Element ? ((Element) obj).toString() : String.valueOf(obj);
    }
}
