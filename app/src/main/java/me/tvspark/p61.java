package me.tvspark;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class p61 implements i61 {
    @Override // me.tvspark.i61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        LinkedList linkedList = new LinkedList();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            linkedList.addAll(it.next().parents());
        }
        return new m61(new Elements((List<Element>) linkedList));
    }

    @Override // me.tvspark.i61
    public String name() {
        return "ancestor";
    }
}
