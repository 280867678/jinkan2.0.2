package me.tvspark;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.exception.XpathSyntaxErrorException;

/* loaded from: classes4.dex */
public class b61 {
    public Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public b61(Elements elements) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = elements;
    }

    public List<c61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            g61 g61Var = new g61(new vx0(new e61(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str))));
            g61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new y71();
            m61 m61Var = (m61) g61Var.Wwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new n61(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            if (m61Var.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Elements) {
                Iterator<Element> it = ((Elements) m61Var.Wwwwwwwwwwwwwwwwwwwwwwww).iterator();
                while (it.hasNext()) {
                    linkedList.add(new c61(it.next()));
                }
                return linkedList;
            } else if (m61Var.Wwwwwwwwwwwwwwwwwwwwwwww instanceof List) {
                for (String str2 : (List) m61Var.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    linkedList.add(new c61(str2));
                }
                return linkedList;
            } else if (m61Var.Wwwwwwwwwwwwwwwwwwwwwwww instanceof String) {
                linkedList.add(new c61(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                return linkedList;
            } else if (m61Var.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Number) {
                linkedList.add(new c61(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                return linkedList;
            } else if (m61Var.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Boolean) {
                linkedList.add(new c61(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                return linkedList;
            } else if (m61Var.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Date) {
                linkedList.add(new c61(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                return linkedList;
            } else {
                linkedList.add(new c61(m61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                return linkedList;
            }
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Please check the syntax of your xpath expr or commit a ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExceptionUtils.getRootCauseMessage(e));
            throw new XpathSyntaxErrorException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }
}
