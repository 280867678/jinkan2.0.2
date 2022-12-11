package me.tvspark;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class u71 implements k61 {
    @Override // me.tvspark.k61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var) {
        Elements elements = new Elements();
        Iterator<Element> it = l61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            elements.addAll(next.children());
            String ownText = next.ownText();
            if (StringUtils.isNotBlank(ownText)) {
                Element element = new Element("");
                element.appendText(ownText);
                elements.add(element);
            }
        }
        return new m61(elements);
    }

    @Override // me.tvspark.k61
    public String name() {
        return "node";
    }
}
