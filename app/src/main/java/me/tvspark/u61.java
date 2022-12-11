package me.tvspark;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class u61 implements i61 {
    @Override // me.tvspark.i61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        LinkedList linkedList = new LinkedList();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            Iterator<Element> it2 = next.parents().iterator();
            while (it2.hasNext()) {
                Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it2.next());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    Iterator<Element> it3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                    while (it3.hasNext()) {
                        linkedList.addAll(it3.next().getAllElements());
                    }
                }
            }
            Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                Iterator<Element> it4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.iterator();
                while (it4.hasNext()) {
                    linkedList.addAll(it4.next().getAllElements());
                }
            }
        }
        return new m61(new Elements((List<Element>) linkedList));
    }

    @Override // me.tvspark.i61
    public String name() {
        return "following";
    }
}
