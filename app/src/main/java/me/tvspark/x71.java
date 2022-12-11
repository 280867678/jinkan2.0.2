package me.tvspark;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class x71 implements k61 {
    @Override // me.tvspark.k61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var) {
        Elements elements = l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        LinkedList linkedList = new LinkedList();
        if (elements != null && elements.size() > 0) {
            if (l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return z71.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("allText").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61Var);
            }
            Iterator<Element> it = elements.iterator();
            while (it.hasNext()) {
                Element next = it.next();
                linkedList.add("script".equals(next.nodeName()) ? next.data() : next.ownText());
            }
        }
        return new m61(linkedList);
    }

    @Override // me.tvspark.k61
    public String name() {
        return "text";
    }
}
