package me.tvspark;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.exception.XpathParserException;

/* loaded from: classes4.dex */
public class l61 {
    public l61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public l61(Element element) {
        Elements elements = new Elements();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = elements;
        elements.add(element);
    }

    public l61(Elements elements) {
        Elements elements2 = new Elements();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = elements2;
        elements2.addAll(elements);
    }

    public Element Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.first();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("current context is more than one el,total = ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size());
        throw new XpathParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }
}
