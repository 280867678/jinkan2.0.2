package me.tvspark;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class y61 implements i61 {
    @Override // me.tvspark.i61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        Elements elements2 = new Elements();
        LinkedList linkedList = new LinkedList();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            Iterator<Element> it2 = next.parents().iterator();
            while (it2.hasNext()) {
                Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it2.next());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    linkedList.addAll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
            Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                linkedList.addAll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
        elements2.addAll(linkedList);
        return new m61(elements2);
    }

    @Override // me.tvspark.i61
    public String name() {
        return "preceding";
    }
}
