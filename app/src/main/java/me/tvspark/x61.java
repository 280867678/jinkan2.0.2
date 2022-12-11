package me.tvspark;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class x61 implements i61 {
    @Override // me.tvspark.i61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        LinkedList linkedList = new LinkedList();
        Elements elements2 = new Elements();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().mo5259parent());
        }
        elements2.addAll(linkedList);
        return new m61(elements2);
    }

    @Override // me.tvspark.i61
    public String name() {
        return "parent";
    }
}
