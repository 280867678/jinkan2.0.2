package me.tvspark;

import java.util.HashSet;
import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class t61 implements i61 {
    @Override // me.tvspark.i61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        HashSet hashSet = new HashSet();
        Elements elements2 = new Elements();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            Elements allElements = next.getAllElements();
            allElements.remove(next);
            hashSet.addAll(allElements);
        }
        elements2.addAll(hashSet);
        return new m61(elements2);
    }

    @Override // me.tvspark.i61
    public String name() {
        return "descendant";
    }
}
