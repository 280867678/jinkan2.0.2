package me.tvspark;

import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.nodes.Element;

/* loaded from: classes4.dex */
public class w71 implements k61 {
    @Override // me.tvspark.k61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var) {
        LinkedList linkedList = new LinkedList();
        Iterator<Element> it = l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().outerHtml());
        }
        return new m61(linkedList);
    }

    @Override // me.tvspark.k61
    public String name() {
        return "outerHtml";
    }
}
