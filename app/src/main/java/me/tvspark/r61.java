package me.tvspark;

import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class r61 implements i61 {
    @Override // me.tvspark.i61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements) {
        Elements elements2 = new Elements();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            elements2.addAll(it.next().children());
        }
        return new m61(elements2);
    }

    @Override // me.tvspark.i61
    public String name() {
        return "child";
    }
}
